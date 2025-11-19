package com.example.projects.libraryManagementSystem;

import com.example.projects.libraryManagementSystem.items.books.HarryPotter;
import com.example.projects.libraryManagementSystem.users.Student;

public class Main {
    public static void main(String[] args) {
        Student st = new Student(1, "student 1", "student1@email.com", 1);
        st.getDetails();
        HarryPotter hp = new HarryPotter(2);

        hp.getDetails();
        hp.lendItem(st);
        st.getDetails();
        hp.getDetails();

        hp.returnItem(st);
        st.getDetails();
        hp.getDetails();

        hp.returnItem(st);
        st.getDetails();
        hp.getDetails();
    }
}
