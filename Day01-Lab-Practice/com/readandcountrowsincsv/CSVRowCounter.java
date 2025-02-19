package com.readandcountrowsincsv;// Import necessary classes for file reading
import java.io.BufferedReader;  
import java.io.FileReader;      
import java.io.IOException;     

// Define the class to count rows in a CSV file
public class CSVRowCounter {

    // Define the main method which will execute the program
    public static void main(String[] args) {

        // defining the path of the csv file
        String filePath = "studentdetails.csv";

        // Initialize a variable to track the number of rows
        int rowCount = 0;  

        // Initialize the BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Declare a variable to hold each line read from the file
            String line;

            // Skip the header row to avoid counting it
            br.readLine();  

            // Loop through each line and count the number of data rows
            while ((line = br.readLine()) != null) {
                rowCount++;  
            }

            // Output the total number of data rows excluding the header
            System.out.println("Number of records (excluding header): " + rowCount);
        } catch (IOException e) {

            // Handle any IOExceptions that may occur during file reading
            e.printStackTrace();  
        }
    }
}
