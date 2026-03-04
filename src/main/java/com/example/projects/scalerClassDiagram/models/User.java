package com.example.projects.scalerClassDiagram.models;

public class User extends BaseModel {
  String name;
  String email;
  String phoneNumber;
  String password;

  public User () {
  }

  public String getName () {
    return name;
  }

  public User setName (String name) {
    this.name = name;
    return this;
  }

  public String getEmail () {
    return email;
  }

  public User setEmail (String email) {
    this.email = email;
    return this;
  }

  public String getPhoneNumber () {
    return phoneNumber;
  }

  public User setPhoneNumber (String phoneNumber) {
    this.phoneNumber = phoneNumber;
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
