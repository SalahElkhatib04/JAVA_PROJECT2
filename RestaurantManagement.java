import java.util.Scanner;

public class RestaurantManagement {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(10); // Define the maximum number of meals

        // Adding meals to the restaurant
        restaurant.addMeal(new Meal("Burger", 5.5, "Classic beef burger"));
        restaurant.addMeal(new Meal("Pizza", 13.0, "Margherita pizza"));
        restaurant.addMeal(new Meal("meat", 9.0, "Rice with meat"));
        restaurant.addMeal(new Meal("Pasta", 20.0, " Pasta white sauce"));
        restaurant.addMeal(new Meal("Fried chicken", 10.5, "Fried chicken with fries"));
        restaurant.addMeal(new Meal("Crepe", 6.5, "Chicken crepe"));

        Meal[] orderedMeals = new Meal[10]; // Maximum number of ordered meals
        int orderedMealsCount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Restaurant!");

        while (true) {
            System.out.println("\n1. View Menu");
            System.out.println("2. Order a Meal");
            System.out.println("3. Remove an Order");
            System.out.println("4. Total Price of Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Menu:");
                    for (Meal meal : restaurant.getMenu()) {
                        if (meal != null) {
                            System.out.println("Name: " + meal.getName() + " | Price: " + meal.getPrice() + " | Description: " + meal.getDescription());
                        }
                    }
                    break;
                case 2:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the name of the meal you want to order: ");
                    String selectedMealName = scanner.nextLine();
                    Meal selectedMeal = restaurant.selectMeal(selectedMealName);
                    if (selectedMeal != null) {
                        orderedMeals[orderedMealsCount] = selectedMeal;
                        orderedMealsCount++;
                        System.out.println("You've ordered: " + selectedMeal.getName());
                    } else {
                        System.out.println("Meal not found.");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the name of the meal to remove from the order: ");
                    String mealToRemove = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < orderedMealsCount; i++) {
                        if (orderedMeals[i] != null && orderedMeals[i].getName().equalsIgnoreCase(mealToRemove)) {
                            orderedMeals[i] = null;
                            found = true;
                            System.out.println("Order removed: " + mealToRemove);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Meal not found in the order.");
                    }
                    break;
                case 4:
                    double totalPrice = 0;
                    for (Meal meal : orderedMeals) {
                        if (meal != null) {
                            totalPrice += meal.getPrice();
                        }
                    }
                    System.out.println("Total Price of Order: $" + totalPrice);
                    break;
                case 5:
                    System.out.println("Thank you for visiting!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
