//package com.write_data_to_csv;
//import java.io.FileWriter;
//import java.io.IOException;
//
//
//// Define the class responsible for writing CSV data
//public class CSVWriterExample {
//
//    // Define the main method which will execute the program
//    public static <CSVWriter> void main(String[] args) {
//
//        // Specify the path where the CSV file will be created
//        String filePath = "employee_details.csv";
//
//        // Initialize CSVWriter to write to the specified file
//        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
//
//            // Define the header of the CSV file with column names
//            String[] header = {"ID", "Name", "Department", "Salary"};
//
//            // Write the header to the CSV file
//            writer.writeNext(header);
//
//            // Define employee records and write them to the file
//            String[] employee1 = {"24", "Ankit", "HR", "50000"};
//            writer.writeNext(employee1);
//
//            String[] employee2 = {"23", "Anshul", "IT", "60000"};
//            writer.writeNext(employee2);
//
//            String[] employee3 = {"243", "Ravi", "Finance", "55000"};
//            writer.writeNext(employee3);
//
//            String[] employee4 = {"42", "Saransh", "IT", "70000"};
//            writer.writeNext(employee4);
//
//            String[] employee5 = {"35", "Jogy", "HR", "48000"};
//            writer.writeNext(employee5);
//        } catch (IOException e) {
//
//            // Handle any IOExceptions that occur during file writing
//            e.printStackTrace();
//        }
//    }
//}
