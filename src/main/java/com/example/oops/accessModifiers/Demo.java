package com.example.oops.accessModifiers;

public class Demo {
    public void showMarks(Student st) { // st.marks = 100
        System.out.println(st.marks); // 100
        doubleMarks(st);
        System.out.println(st.marks); // 200
    }

    public void doubleMarks(Student st) {
        st.marks = 2 * st.marks;
        System.out.println(st.marks); // 200
        st = null;
    }
}
