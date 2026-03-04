package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public interface UserRepository {
  List<User> saveAll (List<User> users);

  User findById (int id);

}
