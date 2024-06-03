package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user: users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User is not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() && user.getUsername().length() >= 3) {
            return true;
        } else {
            throw new UserInvalidException("User data is not valid");
        }
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            validate(user);
        } catch (UserInvalidException eb) {
            throw new RuntimeException(eb);
        } catch (UserNotFoundException ea) {
            throw new RuntimeException(ea);
        }
    }
}
