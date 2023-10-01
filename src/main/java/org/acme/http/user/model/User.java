package org.acme.http.user.model;
import java.util.UUID;

public class User {

  public String id;
  public String name;
  public String email;

  public User(String name, String email) {
    UUID uuid = UUID.randomUUID();

    this.id = uuid.toString();
    this.name = name;
    this.email = email;
  }
}
