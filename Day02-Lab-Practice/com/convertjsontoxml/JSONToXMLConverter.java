package com.convertjsontoxml;// Import necessary classes for JSON and XML conversion
import org.json.JSONObject;
import org.json.XML;

// This class converting java obj into xml format
public class JSONToXMLConverter {
    public static void main(String[] args) {
        // Define a JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ankit Rajput");
        jsonObject.put("age", 21);
        jsonObject.put("city", "Narmadapuram");

        // Convert JSON to XML
        String xml = XML.toString(jsonObject);

        // Print the XML output
        System.out.println(xml);
    }
}
