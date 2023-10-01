package org.acme.http.user;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import java.util.HashMap;
import java.util.Map;
import org.acme.http.user.model.User;

@Default
@ApplicationScoped
public class UserService {
  private Map<String, User> users = new HashMap<>();

  @CacheResult(cacheName = "user-cache")
  public Map<String, User> getUsers() {
    return users;
  }

  @CacheResult(cacheName = "user-cache")
  public User getUser(String id) {
    return users.get(id);
  }

  public User addUser(User user) {
    users.put(user.id, user);
    return user;
  }

  public User deleteUser(String id) {
    return users.remove(id);
  }
}
