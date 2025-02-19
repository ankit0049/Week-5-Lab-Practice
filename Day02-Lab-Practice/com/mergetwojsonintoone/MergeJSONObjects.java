package com.mergetwojsonintoone;// Import necessary JSON classes
import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {
        // Create first JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Ankit Rajput");
        jsonObject.put("age", 21);

        // Create second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("city", "Seoni Malwa");
        json2.put("Region", "India");

        // Merge both JSON objects
        JSONObject mergedJson = new JSONObject(jsonObject, JSONObject.getNames(jsonObject));
        for (String key : JSONObject.getNames(json2)) {
            mergedJson.put(key, json2.get(key));
        }

        // Print the merged JSON object
        System.out.println(mergedJson.toString(4));
    }
}
