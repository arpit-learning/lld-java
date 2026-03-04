package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public class User extends BaseModel {
  private String name;
  private String password;
  private String email;
  private List<Group> groups;

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public String getPassword () {
    return password;
  }

  public void setPassword (String password) {
    this.password = password;
  }

  public String getEmail () {
    return email;
  }

  public void setEmail (String email) {
    this.email = email;
  }

  public List<Group> getGroups () {
    return groups;
  }

  public void setGroups (List<Group> groups) {
    this.groups = groups;
  }
}