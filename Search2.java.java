import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("meals.txt");
            Scanner scanner = new Scanner(file);

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Enter a search (meal name, description, or ID):");
            String query = inputScanner.nextLine().toLowerCase();

            searchMeals(scanner, query);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void searchMeals(Scanner scanner, String query) {
        boolean found = false;
        boolean firstLine = true; 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (firstLine) {
                firstLine = false;
                continue; 
            }
            String[] data = line.split(",");
            if (data.length == 4) {
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String description = data[3];

                if (name.toLowerCase().contains(query) || description.toLowerCase().contains(query) || query.equals(String.valueOf(id))) {
                    found = true;
                    System.out.println("ID: " + id + " | Name: " + name + " | Description: " + description + " | Price: $" + price);
                }
            }
        }

        if (!found) {
            System.out.println("No meals found matching the search.");
        }
    }
}
