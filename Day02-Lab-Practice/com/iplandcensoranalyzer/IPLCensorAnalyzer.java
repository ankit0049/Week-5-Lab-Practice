package com.iplandcensoranalyzer;

import java.io.IOException;

// This is the main class that calls separate methods to handle JSON and CSV censorship.
public class IPLCensorAnalyzer {
    public static void main(String[] args) throws IOException {
        // Define the input and output file paths for JSON processing
        String jsonInputFile = "ipl_matches.json";
        String jsonOutputFile = "censored_ipl.json";

        // Define the input and output file paths for CSV processing
        String csvInputFile = "ipl_matches.csv";
        String csvOutputFile = "censored_ipl.csv";

        // Create instances of the JSON and CSV processors
        IPLCensorJSON jsonProcessor = new IPLCensorJSON();
        IPLCensorCSV csvProcessor = new IPLCensorCSV();

        // Process the JSON file by applying censorship rules
        jsonProcessor.processJSON(jsonInputFile, jsonOutputFile);

        // Process the CSV file by applying censorship rules
        csvProcessor.processCSV(csvInputFile, csvOutputFile);

        // Print completion message to indicate the program has finished
        System.out.println("IPL data processing complete!");
    }
}