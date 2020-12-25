package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
/**
 * Класс описывает действия с объектами User и Account.
 * Класс имеет поле users, которое хранит
 * в себе данные о пользователях(User) и их счетах(Account).
 * @author Denis Sotnikov
 * @version 1.0
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();
    /**
     * Метод позволяет добавить объект класса User в поле users,
     * класса BankService.
     * @param user - Пользователь
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет добавить объект класса Account
     * по отношению к конкретному User.
     * @param passport - пасспорт
     * @param account - аккаунт
     */
    public void addAccount(String passport, Account account) {
        Optional<User> rsl = this.findByPassport(passport);
        if (rsl.isPresent()) {
            if (!users.get(rsl.get()).contains(account)) {
                users.get(rsl.get()).add(account);
            }
        }
    }

    /**
     * Метод позволяет найти конкретный объект класса User
     * из поля users, класса BankService.
     * @param passport - паспорт
     * @return Optional  - возвращает объект Optional
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        e -> e.getPassport()
                                .equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет найти конкретный объект класса Account
     * по отношению к конкретному объекту класса User. Поиск производится
     * в поле users класса BankService.
     * @param passport - паспорт
     * @param requisite - реквизиты
     * @return Optional в случае успешного выполнения поиска.
     * Если необходимый объект класса Account не найден, то метод вернет
     * Optional.empty()
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> necessaryUser = this.findByPassport(passport);
        if (necessaryUser.isPresent()) {
            return users.get(necessaryUser.get())
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод позволяет осуществить перевод денежных средств
     * с одного объекта класса Account к другому.
     * @param srcPassport - паспорт User от которого будет осуществляться перевод
     * @param srcRequisite - реквизиты конкретного объекта класса Account.
     * Счет откуда будут списываться деньги
     * @param destPassport - паспорт User которому будет осуществляться перевод
     * @param destRequisite - реквизиты конкретного объекта класса Account.
     * Счет на который будут зачисляться деньги
     * @param amount - сумма которую необходимо перевести.
     * @return boolean - в случае успешного перевода,
     * метод возвращает true. В случае неудачного перевода
     * метод вернет false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> firstAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> secondAccount = findByRequisite(destPassport, destRequisite);
        if (!firstAccount.isPresent() || !secondAccount.isPresent()
                || !(firstAccount.get().getBalance() >= amount)) {
            return false;
        }
        firstAccount.get().setBalance(firstAccount.get().getBalance() - amount);
        secondAccount.get().setBalance(secondAccount.get().getBalance() + amount);
        boolean rsl = true;
        return rsl;
    }
}