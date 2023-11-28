// 1. Adding a Meal
// 2. Removing a Meal
// 3. Updating a Meal's (Name,Price,Description)
// 4. Listing All Meals
// 5. Search For a Meal By its Name

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.jar.Attributes;

public class Meals_Managment {
    private int id;
    private String name;
    private double price;
    private String description;

    public Meals_Managment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    File MenuFile = new File("Test.txt");  // The File That Contains The Menu

    public void Add_Meal(String name, double price, String description) {       // To Add A meal
        this.name = name;
        this.price = price;
        this.description = description;
        try {
            FileWriter Add = new FileWriter(MenuFile, true);
            Add.write(name + "\t\t" + price + "\t\t" + description);
            Add.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void Remove_Meal(String name) {  // To Remove a meal by its name or ID
        String content = "";
        String line;
        try {
            Scanner remover = new Scanner(MenuFile);
            while (remover.hasNextLine()) {
                line = remover.nextLine();
                String[] words = line.split(",");
                if (words.length > 0 && (words[1].contains(name) || name.equals(String.valueOf(words[0])))) {
                    continue;
                }
                content += line + "\n";
            }
            remover.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter filler = new FileWriter(MenuFile, false);
            filler.write(content);
            filler.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update_Meals(String new_feature,String old_Feature){
        String content = "";
        String line;
        try {
            Scanner update = new Scanner(MenuFile);
            while(update.hasNextLine()){
                line = update.nextLine();
                String[] data = line.split(",");
                for(int i=0;i<data.length;i++){
                    if(data[i].contains(old_Feature) || old_Feature.equals(String.valueOf(data[i]))){
                        content += new_feature +",";
                    }
                    else
                        content += data[i] + ",";
                }
                content += "\n";
            }
            update.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter filler = new FileWriter(MenuFile, false);
            filler.write(content);
            filler.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String searchMeals(String name) {  // Search For A meal
        String line;
        String result = "";
        try {
            Scanner input = new Scanner(MenuFile);
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                if (name.equals(String.valueOf(data[0])) || data[1].contains(name)) {
                    for (int i = 0; i < data.length; i++) {
                        result += data[i];
                    }
                    return result;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public String listMeals(){
        String line;
        String result = "";

        try {
            Scanner input = new Scanner(MenuFile);
            while (input.hasNextLine()) {
                line = input.nextLine();
                result += line +"\n";
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}