import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManageCustomers {
    private int id;
    private String username;
    private String password;

    public ManageCustomers() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    File EMP_File = new File("Customers.txt");

    public void Add_Customers(String username, String password) {       // To Add An Customer
        String line;
        this.username = username;
        this.password = password;
        try {
            Scanner adder = new Scanner(EMP_File);
            if (adder.hasNextLine()) {
                while (adder.hasNextLine()) {
                    line = adder.nextLine();
                    String[] words = line.split(",");
                    this.id = Integer.parseInt(words[0]);
                }
                id++;
            } else
                this.id = 101;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter Add = new FileWriter(EMP_File, true);
            Add.write(id + ",\t\t" + username + ",\t\t" + password + ".\n");
            Add.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete_Customer(String name) {  // To Remove a Customer by his name or ID
        String content = "";
        String line;
        try {
            Scanner remover = new Scanner(EMP_File);
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
            FileWriter filler = new FileWriter(EMP_File, false);
            filler.write(content);
            filler.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update_Customers(String id, String new_feature, String old_Feature) { // To Update a Customer using his Name;
        String content = "";
        String line;
        try {
            Scanner update = new Scanner(EMP_File);
            while (update.hasNextLine()) {
                line = update.nextLine();
                String[] data = line.split(",");
                if (data[0].contains(id)) { // If the Scanner found the Name we want
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].contains(old_Feature) || old_Feature.equals(String.valueOf(data[i]))) {
                            content += "\t\t" + new_feature; //Replace the old information with the new one

                        } else
                            content += data[i];
                        if (i < data.length - 1)
                            content += ",";
                    }
                    content += "\n";
                    continue;
                }
                for (int i = 0; i < data.length - 1; i++) {
                    content += data[i] + ",";
                }
                content += data[data.length - 1] + "\n";
            }
            update.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter filler = new FileWriter(EMP_File, false);
            filler.write(content);
            filler.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String search_Customers(String name) {  // Search For A Customer Using ID or Name
        String line;
        String result = "";
        try {
            Scanner input = new Scanner(EMP_File);
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

    public String listCustomers() {
        String line;
        String result = "";

        try {
            Scanner input = new Scanner(EMP_File);
            while (input.hasNextLine()) {
                line = input.nextLine();
                result += line + "\n";
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}