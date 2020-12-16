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
        User user = this.findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        try {
            User nae = users.entrySet()
                    .stream()
                    .filter(e -> e.getKey()
                            .getPassport()
                            .equals(passport))
                    .findFirst()
                    .get()
                    .getKey();
            return nae;
        } catch (Exception e) {

        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (this.findByPassport(passport) != null) {
            return users.get(findByPassport(passport))
                    .stream()
                    .filter(e -> e.getRequisite().equals(requisite))
                    .findFirst()
                    .get();
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account firstAccount = findByRequisite(srcPassport, srcRequisite);
        Account secondAccount = findByRequisite(destPassport, destRequisite);
        if (firstAccount == null || secondAccount == null
                || !(firstAccount.getBalance() >= amount)) {
            return false;
        }
        firstAccount.setBalance(firstAccount.getBalance() - amount);
        secondAccount.setBalance(secondAccount.getBalance() + amount);
        boolean rsl = true;
        return rsl;
    }
}