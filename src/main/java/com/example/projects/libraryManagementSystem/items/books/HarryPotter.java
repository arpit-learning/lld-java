package com.example.projects.libraryManagementSystem.items.books;

import com.example.projects.libraryManagementSystem.items.ILendableItem;
import com.example.projects.libraryManagementSystem.users.User;

public class HarryPotter extends Book implements ILendableItem {
    public HarryPotter(int itemId) {
        super(itemId, "HP1234", "Harry Potter", "Harry Potter author", true);
    }

    @Override
    public boolean lendItem(User user) {
        if (!user.canBorrowBooks()) {
            System.out.println(user.getName() + "cannot borrow books");
            return false;
        }

        if (this.getIsAvailable()) {
            this.setIsAvailable(false);
            user.setCurrentBorrowed(user.getCurrentBorrowed() + 1);
            System.out.println("Lending Harry Potter " + this.getItemId() + " to " + user.getName());
            return true;
        }

        System.out.println("Harry Potter " + this.getItemId() + " is already lent out");
        return false;
    }

    @Override
    public void returnItem(User user) {
        if (!this.getIsAvailable()) {
            this.setIsAvailable(true);
            user.setCurrentBorrowed(user.getCurrentBorrowed() - 1);
            System.out.println("Harry Potter " + this.getItemId() + " is returned by " + user.getName());
            return;
        }

        System.out.println("Harry Potter " + this.getItemId() + " is already available");
    }
}
