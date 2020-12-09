package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accountsList = new ArrayList<>();
        if (!users.containsKey(user)) {
            users.put(user, accountsList);
        }
    }

    public void addAccount(String passport, Account account) {
        users.get(this.findByPassport(passport)).add(account);
    }


    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> listAccounts = users.get(this.findByPassport(passport));
        if (listAccounts!=null) {
            for (Account ac : listAccounts) {
                if (ac.getRequisite().equals(requisite)) {
                    return ac;
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        Account firstAccount = findByRequisite(srcPassport, srcRequisite);
        if (firstAccount == null) {
            return false;
        }
        Account secondAccount = findByRequisite(destPassport, destRequisite);
        if (secondAccount == null) {
            return false;
        }
        if (!(firstAccount.getBalance() >=amount)) {
                return false;
        }
        firstAccount.setBalance(firstAccount.getBalance() - amount);
        secondAccount.setBalance(secondAccount.getBalance() + amount);
        boolean rsl = true;
        return rsl;
    }
}