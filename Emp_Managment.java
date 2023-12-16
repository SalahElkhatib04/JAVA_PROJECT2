import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Emp_Managment {
    private int id;
    private String username;
    private String password;

    public Emp_Managment(){
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password){this.password = password;}


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.username;
    }

    public String getPassword(){return  this.password;}


    File EMP_File = new File("Employee.txt");

    public void Add_Employee(String username, String password){       // To Add An Employee
        String line;
        this.username = username;
        this.password = password;
        try {
            Scanner adder = new Scanner(EMP_File);
            if(adder.hasNextLine()) {
                while (adder.hasNextLine()) {
                    line = adder.nextLine();
                    String[] words = line.split(",");
                    this.id = Integer.parseInt(words[0]);
                }
                id++;
            }
            else
                this.id = 101;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            FileWriter Add = new FileWriter(EMP_File, true);
            Add.write(id + ",\t\t" + username + ",\t\t" + password  + ".\n");
            Add.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Remove_Employee(String name) {  // To Remove a Employee by its name or ID
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

    public void Update_Employees(String id,String new_feature,String old_Feature){ // To Update a meal using its Name;
        String content = "";
        String line;
        try {
            Scanner update = new Scanner(EMP_File);
            while(update.hasNextLine()){
                line = update.nextLine();
                String[] data = line.split(",");
                if(data[0].contains(id)) { // If the Scanner found the Name we want
                    for (int i = 0; i < data.length; i++) {
                        if (data[i].contains(old_Feature) || old_Feature.equals(String.valueOf(data[i]))) {
                            content += "\t\t" + new_feature;  // Replacing the old feature with the new one.

                        } else
                            content += data[i] ;
                        if(i< data.length-1)
                            content += ",";
                    }
                    content += "\n";
                    continue;
                }
                for (int i = 0; i < data.length-1; i++) {
                    content += data[i] + ",";
                }
                content += data[data.length-1] + "\n";
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

    public String search_Employee(String name) {  // Search For A meal Using ID or Name
        String line;
        String result = "";
        try {
            Scanner input = new Scanner(EMP_File);
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] data = line.split(",");
               // int id = Integer.parseInt(data[0]);
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

    public String listEmployees(){
        String line;
        String result = "";

        try {
            Scanner input = new Scanner(EMP_File);
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
