package com.createjsonobject;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJsonCreator {
    public static void main(String[] args) {
        // Creating a JSON object to represent a student
        JSONObject studentJson = new JSONObject();

        // Adding student's basic details
        studentJson.put("name", "John Doe");
        studentJson.put("age", 20);

        // Creating an array for subjects
        JSONArray subjectsArray = new JSONArray();
        subjectsArray.put("Mathematics");
        subjectsArray.put("Science");
        subjectsArray.put("History");

        // Adding subjects array to the student JSON object
        studentJson.put("subjects", subjectsArray);

        // Printing the final JSON object, Pretty print with indentation
        System.out.println(studentJson.toString(4));
    }
}
