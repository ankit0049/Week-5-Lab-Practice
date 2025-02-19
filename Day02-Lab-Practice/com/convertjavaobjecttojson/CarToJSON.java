package com.convertjavaobjecttojson;
import org.json.JSONObject;
public class CarToJSON {
    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Rolls Royce", "Ghost Series II", 2025);

        // Convert the Car object to JSON
        JSONObject carJson = car.toJSON();

        // Print the JSON output
        System.out.println(carJson.toString(4));
    }
}
