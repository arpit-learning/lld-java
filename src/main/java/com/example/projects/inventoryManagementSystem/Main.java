package com.example.projects.inventoryManagementSystem;

import com.example.projects.inventoryManagementSystem.items.Book;
import com.example.projects.inventoryManagementSystem.items.Clothing;
import com.example.projects.inventoryManagementSystem.items.Electronic;
import com.example.projects.inventoryManagementSystem.storage.Inventory;
import com.example.projects.inventoryManagementSystem.storage.SearchHistory;

public class Main {
    private SearchHistory searchHistory;
    private Inventory<Book> booksInventory;
    private Inventory<Clothing> clothingsInventory;
    private Inventory<Electronic> electronicsInventory;

    public Main() {
        searchHistory = new SearchHistory();
        booksInventory = new Inventory<>(searchHistory);
        clothingsInventory = new Inventory<>(searchHistory);
        electronicsInventory = new Inventory<>(searchHistory);
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.booksInventory.add(new Book("1", "Book 1", 9.99, 10, "Author 1"));
        main.booksInventory.add(new Book("2", "Book 2", 9.99, 10, "Author 2"));

        main.electronicsInventory.add(new Electronic("1", "Electronic 1", 9.99, 10, 100));
        main.electronicsInventory.add(new Electronic("2", "Electronic 2", 9.99, 10, 100));

        main.clothingsInventory.add(new Clothing("1", "Clothing 1", 9.99, 10, "S"));
        main.clothingsInventory.add(new Clothing("2", "Clothing 2", 9.99, 10, "M"));

        main.booksInventory.get("1");
        main.electronicsInventory.get("2");
        main.booksInventory.get("2");
        main.clothingsInventory.get("1");
        main.electronicsInventory.get("1");
        main.booksInventory.get("2");

        System.out.println(main.searchHistory.getHistory());
    }


}
