package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public interface GroupRepository {
  Group save (Group group);

  List<Group> findAll ();

  Group findById (int id);
}
