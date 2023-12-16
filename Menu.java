import java.util.Scanner;

public class Menu {

    public static int JoinAs(){
        Scanner input = new Scanner(System.in);
        System.out.println("Join As:");
        System.out.print("1.Admin  2.Employee  3.Customer:");
        int ch = input.nextInt();
        System.out.println("#########################################################");
        return ch;
    }

    // Admin class ==> Meal Management | Employee Management |  Report Management
    public static int AdminMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("#########################################################");
        System.out.println("Choose From the Following:");
        System.out.print("1.Manage Meals  2.Manage Employees  3.Manage Reports  -1.To Exit :");
        int s = input.nextInt();
        System.out.println("#########################################################");
        return s;
    }

    public static int MealManagement(){
        System.out.println("#########################################################");
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to Meals Management****");
        System.out.println("1.Add a meal  2.Remove a meal  3.Update a meal  4.Search Up A meal  5.List all Meals");
        int s = input.nextInt();
        System.out.println("#########################################################");
        return s;
    }    // Meal Management Menu

    public static int EmpManagement() {
        System.out.println("#########################################################");
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to the Employees Management****");
        System.out.println("1.Add Employee  2.Remove Employee  3.Update Employee information  4.Search Up An Employee  5.List all Employees");
        int s = input.nextInt();
        System.out.println("#########################################################");
        return s;
    }   // Employee Management Menu

    public static int ReportMangement(){

        System.out.println("#########################################################");
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Reports Menu:");
        System.out.print("1.Create a Report for an Employee   2.Create a Report for a Customer:");
        int choice = input.nextInt();
        input.nextLine();
        System.out.println("#########################################################");
        return choice;
    } // Reports Management

    // Reports Methods
    public static void EmpRep(){

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.print("Enter the Id of the Employee you want to Report:");
        String id = input.nextLine();
        System.out.println("Enter the Report:");
        String report = input.nextLine();
        admin.reports.EmpReports(id,report);
        System.out.println("\n");
    }

    public static void CusRep(){
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Id of the Customer you want to Report:");
        String id = input.nextLine();
        System.out.println("Enter the Report:");
        String report = input.nextLine();
        admin.reports.CustomerReports(id,report);
        System.out.println("\n");
    }

    // Meals Methods
    public static  void AddMeal_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the meal name:");
        String name = input.nextLine();
        System.out.print("Enter the Price:");
        double price = input.nextDouble();
        input.nextLine();
        System.out.print("Enter the Meal's Description:");
        String dis = input.nextLine();
        admin.meals.Add_Meal(name,price,dis);
        System.out.println("\n");
    }

    public static void RemoveMeal_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Name or Id of the Meal:");
        String name = input.nextLine();
        admin.meals.Remove_Meal(name);
        System.out.println("\n");
    }

    public static void UpdateMeal_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter The ID of the meal U want to alter:");
        String name = input.nextLine();
        System.out.print("Enter the OLD feature:");
        String old_feature = input.nextLine();
        System.out.println("Enter the New Feature:");
        String new_feature = input.nextLine();
        admin.meals.Update_Meals(name, new_feature, old_feature);
        System.out.println("\n");
    }

    public static void SearchMeal_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the ID of the meal:");
        String id = input.nextLine();
        System.out.println("ID  |   Meal   |  Price  |  Description");
        System.out.println(admin.meals.searchMeals(id));
        System.out.println("\n");
    }

    public static void ListMeal_Menu(){

        Admin admin = new Admin();

        System.out.println("ID  |   Meal   |  Price  |  Description");
        System.out.println(admin.meals.listMeals());
        System.out.println("\n");
    }

    // Employees Methods
    public static  void AddEmp_Menu(){

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();

        System.out.print("Enter the Employee name: ");
        String name = input.nextLine();
        System.out.print("Enter the Password: ");
        String password = input.nextLine();

        admin.employee.Add_Employee(name, password);
        System.out.println("\n");
    }

    public static void RemoveEmp_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the Name or Id of the Employee: ");
        String name = input.nextLine();
        admin.employee.Remove_Employee(name);
        System.out.println("\n");
    }

    public static void UpdateEmp_Menu(){

        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter The ID of the Employee U want to alter: ");
        String id = input.nextLine();
        System.out.print("Enter the OLD information: ");
        String old_info = input.nextLine();
        System.out.println("Enter the New information: ");
        String new_info = input.nextLine();

        admin.employee.Update_Employees(id, new_info, old_info);
        System.out.println("\n");
    }

    public static void SearchEmp_Menu(){

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        System.out.print("Enter the ID of the Employee: ");
        String id = input.nextLine();
        System.out.println("ID  |     name      |  password");
        System.out.println(admin.employee.search_Employee(id));
        System.out.println("\n");
    }

    public static void ListEmp_Menu(){
        Admin admin = new Admin();
        System.out.println("ID  |     name      |  password");
        System.out.println(admin.employee.listEmployees());
        System.out.println("\n");
    }



    // Employee Class ==>  Manage Customers  |  Manage Orders
    public static int EmployeeMenu(){  // Aymann
        Scanner input = new Scanner(System.in);
        System.out.println("#########################################################");
        System.out.println("Choose From the Following:");
        System.out.print("1.Manage Customers  2.Manage Orders   -1.To Exit :");
        int s = input.nextInt();
        System.out.println("#########################################################");
        return s;
    }

    // Customer management Menu:
    public static int CustomerManagement() {
        System.out.println("#########################################################");
        Scanner input = new Scanner(System.in);
        System.out.println("****Welcome to the Customers Management****");
        System.out.println("1.Add Customer  2.Remove Customer  3.Update Customer information  4.Search Up A Customer  5.List all Customers");
        int s = input.nextInt();
        System.out.println("#########################################################");
        return s;
    }

    // Cutomer Management Methods
    public static  void AddCustomer_Menu(){

        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Enter the customer name: ");
        String name = input.nextLine();
        System.out.print("Enter the Password: ");
        String password = input.nextLine();

        employee.customer.Add_Customers(name, password);
        System.out.println("\n");
    }

    public static void RemoveCustomer_Menu(){

        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Name or Id of the Customer: ");
        String name = input.nextLine();
        employee.customer.Delete_Customer(name);
        System.out.println("\n");
    }

    public static void UpdateCustomer_Menu(){

        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter The ID of the Customer U want to alter: ");
        String id = input.nextLine();
        System.out.print("Enter the OLD information:");
        String old_info = input.nextLine();
        System.out.println("Enter the New information:");
        String new_info = input.nextLine();

        employee.customer.Update_Customers(id, new_info, old_info);
        System.out.println("\n");
    }

    public static void SearchCustomer_Menu(){

        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.print("Enter the ID of the Customer: ");
        String id = input.nextLine();
        System.out.println("ID  |     name      |  password");
        System.out.println(employee.customer.search_Customers(id));
        System.out.println("\n");
    }

    public static void ListCustomer_Menu(){
        Employee employee = new Employee();
        System.out.println("ID  |     name      |  password");
        System.out.println(employee.customer.listCustomers());
        System.out.println("\n");
    }

}
