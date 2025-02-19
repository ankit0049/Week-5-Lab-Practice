package com.readjsonandprintallkeysandvalues;// Import necessary classes for file reading and JSON processing
import org.json.JSONObject;
import java.nio.file.*;
import java.util.Iterator;

// This class reads a JSON file and prints all keys and values.

public class PrintJSONKeysValues {
    public static void main(String[] args) {
        try {
            // Read JSON file content as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get("user.json")));

            // Convert string into JSON object
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Iterate through keys and print key-value pairs
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                // Extracting the key
                String key = keys.next();
                //Displaying the key and value
                System.out.println(key + ": " + jsonObject.get(key));
            }

        } catch (Exception e) {
            // Printing the stackTrace that hold message about the exception
            e.printStackTrace();
        }
    }
}
