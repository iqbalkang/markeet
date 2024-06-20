package one.markeet.managers;

import one.markeet.DAOs.UserDAO;
import one.markeet.entities.User;

import java.util.List;

public class UserManager {
    private static final UserManager instance = new UserManager();
    private final UserDAO userDAO = new UserDAO();

    private UserManager() {
    }

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long id, int gender, String email, String password, String firstName, String lastName, String userType) {
        User user = new User();
        user.setId(id);
        user.setGender(gender);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUserType(userType);

        return user;
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
