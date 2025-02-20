package com.iplandcensoranalyzer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// This class reads IPL match data from a JSON file
public class IPLCensorJSON {
    // Method to read data from a JSON file, applies censorship rules, and writes to a new file.
    public void processJSON(String inputFile, String outputFile)throws IOException {
        try {
            // Read the entire JSON file as a string
            String jsonContent = new String(Files.readAllBytes(Paths.get(inputFile)));

            // Convert JSON string into a JSONArray object
            JSONArray matches = new JSONArray(jsonContent);

            // Loop through each match in the JSON array
            for (int i = 0; i < matches.length(); i++) {
                // Get the match object at index 'i'
                JSONObject match = matches.getJSONObject(i);

                // Mask the team names in "team1" and "team2"
                String maskedTeam1 = maskTeamName(match.getString("team1"));
                String maskedTeam2 = maskTeamName(match.getString("team2"));

                // Update JSON object with masked team names
                match.put("team1", maskedTeam1);
                match.put("team2", maskedTeam2);

                // Mask the "winner" field by modifying the team name
                match.put("winner", maskTeamName(match.getString("winner")));

                // Redact the "player_of_match" field
                match.put("player_of_match", "REDACTED");

                // Get the "score" object which contains team names as keys
                JSONObject score = match.getJSONObject("score");

                // Create a new object to store masked scores
                JSONObject maskedScore = new JSONObject();

                // Loop through the keys in the score object
                for (String key : score.keySet()) {

                    maskedScore.put(maskTeamName(key), score.getInt(key));
                }
                // Update JSON object with masked scores
                match.put("score", maskedScore);
            }

            // Write the censored JSON data to a new file
            FileWriter file = new FileWriter(outputFile);
            file.write(matches.toString(4));
            file.close();
            System.out.println("Censored JSON file generated: " + outputFile);
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