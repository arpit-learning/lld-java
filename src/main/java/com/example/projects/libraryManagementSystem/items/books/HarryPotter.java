package com.example.projects.libraryManagementSystem.items.books;

import com.example.projects.libraryManagementSystem.items.ILendableItem;
import com.example.projects.libraryManagementSystem.users.User;

public class HarryPotter extends Book implements ILendableItem {
    public HarryPotter(int itemId, String isbn, String title, String author, boolean isAvailable) {
        super(itemId, isbn, title, author, isAvailable);
    }

    @Override
    public boolean lendItem(User user) {
        return false;
    }

    @Override
    public void returnItem(User user) {

    }
}
