public class Admin {
    Meals_Managment meals = new Meals_Managment();
    Emp_Managment employee = new Emp_Managment();

    Reports reports = new Reports();

    public static double ApplyOffer(double Total){

        // Applying 10% offer

        double AfterOffer = Total - (Total * 0.1);
        return AfterOffer;
    }

}
