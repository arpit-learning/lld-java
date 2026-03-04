package com.example.projects.splitwiseClassDiagram.models;

import java.util.List;

public class GroupService {

  private GroupRepository groupRepository;

  public Group createGroup (Group group) {
    return groupRepository.save(group);
  }

  public List<Group> getAllGroups () {
    return groupRepository.findAll();
  }

  public List<Expense> getAllExpensesByGroupId (int groupId) {
    return groupRepository
        .findById(groupId)
        .getExpenses();
  }

  public List<Transaction> settleUpByGroupId (int groupId) {
    Group group = groupRepository.findById(groupId);
    ISettleUpStrategy settleUpStrategy = SettleUpStrategyFactory.getSettleUpStrategy();
    return settleUpStrategy.settleUp(group.getExpenses());
  }
}
