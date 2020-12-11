package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User s : users) {
            if (s.getUsername().equals(login)) {
                return s;
            }
        }
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException();
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
                e.printStackTrace();
                System.out.println("Пользователь не валидный");
        } catch (UserNotFoundException e) {
                e.printStackTrace();
                System.out.println("Пользователь не найден");
        }

    }
}