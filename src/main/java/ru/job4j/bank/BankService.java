package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> rsl = this.findByPassport(passport);
        if (rsl.isPresent()) {
            if (!users.get(rsl.get()).contains(account)) {
                users.get(rsl.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(
                        e -> e.getPassport()
                                .equals(passport))
                .findFirst();
    }

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