import java.util.Scanner;

public class SmartCityManagement {
    private enum MenuOption {
        ADD_BUILDING(1, "Add building"),
        VIEW_BUILDING(2, "View building"),
        EXIT(3, "Exit");

        private final int code;
        private final String label;

        MenuOption(int code, String label) {
            this.code = code;
            this.label = label;
        }

        public int getCode() {
            return  this.code;
        }

        public  String getLabel() {
            return this.label;
        }

        public static MenuOption fromCode(int code) {
            for (MenuOption option : values()) {
                if (option.code == code) return option;
            }
            return  null;
        }
    }

    private record Building(String name, String address, int numberOfFloors) {
    }

    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to Smart City Management System");

        boolean running = true;
        while (running) {
            printMenu();

            int code = readInt("Please select an option: ");
            MenuOption option = MenuOption.fromCode(code);

            if (option == null) {
                System.out.println("Invalid option. Please try again.\n");
                continue;
            }

            switch (option) {
                case ADD_BUILDING -> addBuilding();
                case VIEW_BUILDING -> viewBuilding();
                case EXIT -> running = exit();
            }
        }
    }

    private void printMenu() {
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.getCode() + ". " + option.getLabel());
        }
    }

    private void addBuilding() {
        System.out.print("Enter Building Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Building Address: ");
        String address = scanner.nextLine().trim();

        int floors = readInt("Enter Number of Floors: ");

        Building building = new Building(name, address, floors);

        printDivider();
        System.out.println("Building Name: "    + building.name());
        System.out.println("Building Address: " + building.address());
        System.out.println("Number of Floors: " + building.numberOfFloors());
        printDivider();
        System.out.println("Building added successfully!\n");
    }

    private void viewBuilding() {
        System.out.println("Coming Soon.....\n\n");
        printDivider();
    }

    private boolean exit() {
        System.out.println("Exiting program. Goodbye!");
        return false;
    }

    private int readInt(String promt) {
        while (true) {
            System.out.print(promt);
            String inp = scanner.nextLine().trim();
            try {
                return Integer.parseInt(inp);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number");
            }
        }
    }

    private void printDivider() {
        System.out.println("=".repeat(35));
    }
}
