package projects.lld.spotify.manager;

import projects.lld.spotify.entity.User;
import projects.lld.spotify.exception.UserAlreadyExistsException;
import projects.lld.spotify.exception.UserNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserManager {

    private final Map<String, User> users;
    private static UserManager userManager;
    private static final Lock lock = new ReentrantLock();

    private UserManager() {
        users = new ConcurrentHashMap<>();
    }

    public static UserManager getUserManager() {
        if(userManager == null) {
            lock.lock();
            try {
                if (userManager == null) {
                    userManager = new UserManager();
                }
            }
            finally {
                lock.unlock();
            }
        }
        return userManager;
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        if(users.containsKey(user.getUserid())) {
            throw new UserAlreadyExistsException("User with Id " + user.getUserid() + " already exists.");
        }
        users.put(user.getUserid(), user);
    }

    public User getUser(String userId) {
        User user = users.get(userId);
        if(user == null) {
            throw new UserNotFoundException("User with Id " + userId + " not found.");
        }
        return user;
    }

    public void updateUser(User user) {
        if(!users.containsKey(user.getUserid())) {
            throw new UserNotFoundException("User " + user.getUsername() + " not found!");
        }
        users.put(user.getUserid(), user);
    }
}
