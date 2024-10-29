package DAO;

import models.Account;

import java.util.HashMap;

public class AccountDAO {
    private static final HashMap<String, Account> accounts = new HashMap<>();

    static {
        accounts.put("user1", new Account("user1", "pass1"));
    }

    public static Account login(String userName, String password) {
        Account account = accounts.get(userName);
        if (account != null && account.getPassword().equals(password)) {
            return account;
        }
        return  null;
    }

    public static void register(String userName, String password) {
        Account account = new Account(userName, password);
        accounts.put(account.getUserName(), account);
    }
}
