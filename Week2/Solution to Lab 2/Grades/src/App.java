import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Solution to COMP 305, Lab 2.
 */

public class App {

    /**
     * 
     * @param args - not used
     */

    public static void main(String[] args) {

        Scanner fileScanner = null;
        FileWriter fileWriter;

        /**
         *   1  Open input and output files
         *   2  Convert input file to html table
         *   3  Close input and output files
         */  
        try {
            // 1
            fileWriter = new FileWriter("src/res/grades.html");
            fileScanner = new Scanner(new File("src/res/grades.csv"));
            // 2
            String table = buildTable(fileScanner);
            fileWriter.append(table);
            // 3
            fileWriter.close();
            fileScanner.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 
     * @param fileScanner - Scanner object configured to read from input csv file
     * @return            - html String containing table definition 
     */
    static private String buildTable(Scanner fileScanner) {
        StringBuilder builder = new StringBuilder();

        /**
         *  Define CSS for table borders
         */

        final String css = "<style>"
                + " td,th { border: thin solid} "
                + " table,td,th { border-collapse:collapse}"
                + "</style>";
        builder.append(css).append("\n");

        /**
         * Create table header
         */
        
        builder.append("<table>").append("\n");
        String headerLine = fileScanner.nextLine();
        headerLine = headerLine.replaceAll("\"", "");       // Remove quotation marks
        String[] fieldNames = headerLine.split(",");        // Separate column names
        builder.append("<tr>").append("\n");                // Build header row
        for (int i = 0; i < fieldNames.length; i++) {
            builder.append("<th>").append(fieldNames[i]).append("</th>").append("\n");
        }
        builder.append("</tr>").append("\n");

        /**
         *  Populate table body
         */

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().replaceAll("\"", "");  // Remove quotes from line
            String[] grades = line.split(",");                          // Separate fields
            if (grades.length == 9) {                                   // Check validity of line
                builder.append("<tr>");                                 // Create table row
                for (int i = 0; i < grades.length; i++) {               // Create table data for each grade 
                    builder.append("<td>").append(grades[i]).append("</td>").append("\n");
                }
                builder.append("</tr>");                                // close row
            }
        }
        builder.append("</table>");                                     // close table

        /**
         * Create string that holds html table definition 
         */

        String html = builder.toString();
        return html;
    }
}