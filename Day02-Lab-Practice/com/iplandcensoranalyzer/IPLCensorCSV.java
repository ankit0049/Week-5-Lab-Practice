
package com.iplandcensoranalyzer;

import java.io.*;

// This class reads IPL match data from a CSV file
public class IPLCensorCSV {
    // Method to read data from a CSV file,censorship rules, and writes to a new file.
    public void processCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            // Read the first line and write it to the new file
            String header = br.readLine();
            bw.write(header + "\n");

            // Read each line of the CSV file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the CSV line into fields using commas
                String[] fields = line.split(",");

                // Mask the team names in columns (Team1, Team2, Winner)
                fields[1] = maskTeamName(fields[1]);
                fields[2] = maskTeamName(fields[2]);
                fields[5] = maskTeamName(fields[5]);

                // Redact the "player_of_match" field
                fields[6] = "REDACTED";

                // Write the updated row to the new CSV file
                bw.write(String.join(",", fields) + "\n");
            }
            System.out.println("Censored CSV file generated: " + outputFile);
        }
        catch (IOException e) {
            // Print stack trace if an error occurs
            e.printStackTrace();
        }
    }

    // Masks part of the team name for censorship.
    private String maskTeamName(String teamName) {
        // Split the team name by spaces into an array
        String[] parts = teamName.split(" ");

        // If the team name contains multiple words, mask the last word
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        // If the team name is a single word, return it unchanged
        return teamName;
    }
}








