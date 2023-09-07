package org.acme.user.resource;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import org.acme.user.model.User;

@Path("/users")
public class UserResource {

  private Set<User> users = Collections.newSetFromMap(
      Collections.synchronizedMap(new LinkedHashMap<>()));

  @GET
  public Set<User> list() {
    return users;
  }

  @POST
  public Set<User> add(User user) {
    users.add(user);
    return users;
  }

  @DELETE
  public Set<User> delete(User user) {
    users.removeIf(existingUser -> existingUser.name.contentEquals(user.name));
    return users;
  }
}
