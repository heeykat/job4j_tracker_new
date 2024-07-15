package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы
 * @author Savchuk Ekaterina
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя и добавляет его в Map
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспорт пользователя, идентефицирует пользователя и удаляет его из системы
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает паспорт и счет пользователя,
     * идентифицирует пользователя и добавляет ему счет
     * @param passport номер паспорта пользователя
     * @param account номер счета пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает номер паспорта и находит по нему пользователя
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает номер паспорта и реквизиты пользователя и
     * находит по ним счет пользователя
     * @param passport номер паспорта пользователя
     * @param requisite номер реквизитов счета пользователя
     * @return возвращает номер счета или null, в случае если он не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перечислить деньги с одного счёта на другой счёт
     * Если аккаунты отправителя и получателя не равны null, и на счету отправителя
     * достаточно средств для перевода, со счета отправителя списывается сумма перевода, а
     * на счет получателя зачисляется такая же сумма
     * @param sourcePassport паспорт пользователя-отправителя
     * @param sourceRequisite реквизиты счета пользователя-отправителя
     * @param destinationPassport паспорт пользователя-получателя
     * @param destinationRequisite реквизиты счета пользователя-получателя
     * @param amount сумма денег
     * @return true в случае успешного перевода, false в обратном случае
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account accountDestination = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSource != null && accountDestination != null
                && accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDestination.setBalance(accountDestination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод позволяет найти все счета пользователя
     * @param user пользователь
     * @return возвращает счета пользователя в коллекции типа List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}