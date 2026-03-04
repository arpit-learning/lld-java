package com.example.projects.ecomClassDiagram.models;

public abstract class User extends BaseModel {
  private String name;
  private String password;

  public User () {
  }

  public String getName () {
    return name;
  }

  public User setName (String name) {
    this.name = name;
    return this;
  }

  public String getPassword () {
    return password;
  }

  public User setPassword (String password) {
    this.password = password;
    return this;
  }
}
