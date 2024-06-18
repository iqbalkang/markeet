package one.markeet.DAOs;

import one.markeet.DataStore;
import one.markeet.entities.User;

public class UserDAO {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
