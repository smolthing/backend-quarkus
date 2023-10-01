package org.acme.http.user.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.acme.http.user.HttpResponse.GetUserResponse;
import org.acme.http.user.UserService;
import org.acme.http.user.model.User;

@Path("/users")
public class UserResource {

  @Inject
  private UserService userService;

  @GET
  public GetUserResponse getUsers() {
    return new GetUserResponse(userService.getUsers());
  }

  @GET
  @Path("/{id}")
  public User getUser(@PathParam("id") String id) {
    final var user = userService.getUser(id);
    if (user == null) {
      throw new NotFoundException();
    }

    return user;
  }

  @POST
  public User add(User user) {
    return userService.addUser(user);
  }

  @DELETE
  @Path("/{id}")
  public Response delete(String id) {
    final var user = userService.deleteUser(id);
    if (user == null) {
      throw new NotFoundException();
    }
    return Response.status(204).build();
  }
}
