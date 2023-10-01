package org.acme.http.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.acme.http.user.model.User;

public class HttpResponse {
  public static class GetUserResponse {
    public List<User> users;

    public GetUserResponse(Map<String, User> listOfUsers) {
      this.users = listOfUsers.values().stream().toList();;
    }
  }
}
