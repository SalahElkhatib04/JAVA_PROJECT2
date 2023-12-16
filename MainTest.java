import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {

        Admin admin = new Admin();

        int ch = Menu.JoinAs();
        if(ch == 1){
            while (true){
                int s = Menu.AdminMenu();
                if(s == -1)
                    break;
                else if (s == 1){

                    int i = Menu.MealManagement();

                    if(i == 1)
                        Menu.AddMeal_Menu();
                    else if (i == 2) {
                        Menu.RemoveMeal_Menu();
                    } else if (i == 3) {
                        Menu.UpdateMeal_Menu();
                    } else if (i == 4) {
                       Menu.SearchMeal_Menu();
                    } else if (i == 5) {
                        Menu.ListMeal_Menu();
                    }
                }
                else if (s == 2) {
                    int j  = Menu.EmpManagement();

                    if(j == 1)
                        Menu.AddEmp_Menu();
                    else if (j == 2) {
                        Menu.RemoveEmp_Menu();
                    } else if (j == 3) {
                        Menu.UpdateEmp_Menu();
                    } else if (j == 4) {
                        Menu.SearchEmp_Menu();
                    } else if (j == 5) {
                        Menu.ListEmp_Menu();
                    }
                }
                else if (s == 3) {
                    int choice = Menu.ReportMangement();
                    if(choice == 1){
                        Menu.EmpRep();
                    } else if (choice == 2) {
                        Menu.CusRep();
                    }
                    else
                        System.out.println("Wrong Input!!");
                }
                else{
                    System.out.println("Wrong Input!!");
                    break;
                }
            }

        } else if (ch == 2) {
            while (true){
                int s = Menu.EmployeeMenu();
                if(s == -1)
                    break;

                else if (s == 1){

                    int i = Menu.CustomerManagement();

                    if(i == 1)
                        Menu.AddCustomer_Menu();
                    else if (i == 2) {
                        Menu.RemoveCustomer_Menu();
                    } else if (i == 3) {
                        Menu.UpdateCustomer_Menu();
                    } else if (i == 4) {
                        Menu.SearchCustomer_Menu();
                    } else if (i == 5) {
                        Menu.ListCustomer_Menu();
                    }
                }
            }

        } else
            System.out.println("Wrong Input!!");
    }
}
