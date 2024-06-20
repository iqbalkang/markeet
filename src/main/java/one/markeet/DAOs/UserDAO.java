package one.markeet.DAOs;

import one.markeet.DataStore;
import one.markeet.entities.User;

import java.util.List;

public class UserDAO {
    public List<User> getUsers() {
        return DataStore.getUsers();
    }
}
