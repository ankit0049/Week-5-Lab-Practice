package com.listofobjectintojsonarray;// Import necessary classes for JSON processing and lists
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ListToJSONArray {
    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();

        //Creating student object and store it in list
        students.add(new Student("Ankit", 21));
        students.add(new Student("Amana", 21));
        students.add(new Student("Sanu", 21));

        // Convert list of students to a JSON array
        JSONArray studentArray = new JSONArray();
        for (Student student : students) {
            studentArray.put(student.toJSON());
        }

        // Print the JSON array
        System.out.println(studentArray.toString(4));
    }
}
