package com.example.projects.libraryManagementSystem.items;

import com.example.projects.libraryManagementSystem.users.User;

public interface ILendableItem {
    boolean lendItem(User user);

    void returnItem(User user);
}
