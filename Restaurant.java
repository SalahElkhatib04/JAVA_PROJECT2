class Restaurant {
    private Meal[] menu;
    private int menuSize;

    public Restaurant(int maxSize) {
        this.menu = new Meal[maxSize];
        this.menuSize = 0;
    }

    public void addMeal(Meal meal) {
        if (menuSize < menu.length) {
            menu[menuSize] = meal;
            menuSize++;
        } else {
            System.out.println("Menu is full. Cannot add more meals.");
        }
    }

    public Meal[] getMenu() {
        return menu;
    }

    public Meal selectMeal(String name) {
        for (Meal meal : menu) {
            if (meal != null && meal.getName().equalsIgnoreCase(name)) {
                return meal;
            }
        }
        return null; // Meal not found
    }
}