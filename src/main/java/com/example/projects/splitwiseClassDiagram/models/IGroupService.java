package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public interface IGroupService {
  Group createGroup (Group group);

  List<Group> getAllGroups ();

  List<Expense> getAllExpensesByGroupId (int groupId);

  List<Transaction> settleUpByGroupId (int groupId);
}
