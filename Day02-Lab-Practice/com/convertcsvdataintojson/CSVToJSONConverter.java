package com.convertcsvdataintojson;// Import necessary classes for file reading and JSON processing
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;

// This class converts CSV data into JSON format.

public class CSVToJSONConverter {
    public static void main(String[] args) {
        // Created a file and store in csvFile varible to read the data
        String csvFile = "ankit.csv";
        // use try-with-resource to automatic close the resource after use
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // reading row wise
            String headerLine = br.readLine();

            // split the data based on , delimiter and convert into array of string now format
            String[] headers = headerLine.split(",");

            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }
            // Displaying the result
            System.out.println(jsonArray.toString(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
