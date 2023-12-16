import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Reports {

    File EmpFile = new File("Employee.txt");

    File CustomerFile = new File("Customers.txt");

    public void EmpReports(String id,String report){

        String line;
        String result = "";

        try {
            Scanner input = new Scanner(EmpFile);
            result += "ID | Employee    |  Password \n";
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] data = line.split(",");
                if(id.equals(String.valueOf(data[0]))){
                    for (int i = 0; i < data.length; i++) {
                        result += data[i];
                    }
                    result += "\n" + "**** " + report + " *****\n";
                }
            }
            File EmpRep = new File(id+"_Report.txt");
            if (!EmpRep.exists())
                EmpRep.createNewFile();

            FileWriter fw = new FileWriter(EmpRep,true);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void CustomerReports(String id,String report){
        String line;
        String result = "";

        try {
            Scanner input = new Scanner(CustomerFile);
            result += "ID |  Customer     |  Password \n";
            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] data = line.split(",");
                if(id.equals(String.valueOf(data[0]))){
                    for (int i = 0; i < data.length; i++) {
                        result += data[i];
                    }
                    result += "\n" + "**** " + report + " *****\n\n";
                }
            }
            File EmpRep = new File(id+"_Report.txt");
            if (!EmpRep.exists())
                EmpRep.createNewFile();

            FileWriter fw = new FileWriter(EmpRep,true);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
