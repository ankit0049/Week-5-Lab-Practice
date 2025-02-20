package com.listofobjectintojsonarray;

import org.json.JSONObject;

// Created a class to create objects
public class Student {
    private String name;
    private int age;

    // Constructor to initialize Student object
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Converts a Student object to JSON format
    public JSONObject toJSON() {
        JSONObject studentJson = new JSONObject();
        studentJson.put("name", this.name);
        studentJson.put("age", this.age);
        return studentJson;
    }
}
