public class Menu {

    TamagotchiCenter tc = new TamagotchiCenter();
    UI ui = new UI();

    public void startMenu() {
        while (true) {
            tc.printStatusReport();
            if (tc.tamagotchis.isEmpty()) {
                System.out.println("What would you like to do?\n");
                System.out.println("1. Add pet");
                System.out.println("2. Close application\n");
                System.out.println("Input here: ");
                int input = ui.userIntInput();
                switch (input) {
                    case 1:
                        addMenu();
                        break;
                    case 2:
                        closeApp();
                        return;
                    default:
                        System.out.println("Unknown input");
                        break;
                }

            } else {
                System.out.println("What would you like to do?\n");
                System.out.println("1. Add pet");
                System.out.println("2. Remove pet");
                System.out.println("3. Interact with pet");
                System.out.println("4. Find the happiest pet");
                System.out.println("5. Find the hungriest pet");
                System.out.println("6. Get Average happiness");
                System.out.println("7. Close application\n");
                System.out.println("Input here: ");
                int input = ui.userIntInput();
                switch (input) {
                    case 1:
                        addMenu();
                        break;
                    case 2:
                        removeMenu();
                        break;
                    case 3:
                        activityMenu();
                        break;
                    case 4:
                        happiestMenu();
                        break;
                    case 5:
                        hungriestMenu();
                        break;
                    case 6:
                        averageMenu();
                        break;
                    case 7:
                        closeApp();
                        return;
                        break;
                    default:
                        System.out.println("Unknown input");
                        break;
                }
            }
        }
    }

    public void addMenu() {
        System.out.println("Type the name of the new pet: ");
        String input = ui.userStringInput();
        tc.addPet(input);
    }

    public void removeMenu() {
        System.out.println("Type the name of the new pet: ");
        String input = ui.userStringInput();
        tc.removePet(input);
    }
}
