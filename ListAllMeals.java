import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("meals.txt");
            Scanner scanner = new Scanner(file);

            listAllMeals(scanner);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    private static void listAllMeals(Scanner scanner) {
        boolean firstLine = true; // Track the first line to skip header
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (firstLine) {
                firstLine = false;
                continue; // Skip the first line (header)
            }
            String[] data = line.split(",");
            if (data.length == 4) {
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String description = data[3];

                System.out.println("ID: " + id + " | Name: " + name + " | Description: " + description + " | Price: $" + price);
            }
        }
    }
}
