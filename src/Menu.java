public class Menu {

    TamagotchiCenter tc = new TamagotchiCenter();
    UI ui = new UI();

    public void startMenu() {
        while (true) {
            tc.printStatusReport();
            if (tc.tamagotchis.isEmpty()) {
                System.out.println("");
                System.out.println("What would you like to do?\n");
                System.out.println("1. Add tamagotchi");
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
                System.out.println("1. Add tamagotchi");
                System.out.println("2. Remove tamagotchi");
                System.out.println("3. Interact with tamagotchi");
                System.out.println("4. Find the happiest tamagotchi/s");
                System.out.println("5. Find the hungriest tamagotchi/s");
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
                    default:
                        System.out.println("Unknown input");
                        break;
                }
            }
        }
    }

    public void addMenu() {
        System.out.println("Type the name of the new tamagotchi: ");
        String input = ui.userStringInput();
        tc.addPet(input);
    }

    public void removeMenu() {
        System.out.println("Type the name of the new tamagotchi: ");
        String input = ui.userNameStringInput();
        tc.removePet(input);
    }

    public void activityMenu() {
        System.out.println("Type the name of the tamagotchi: ");
        String input = ui.userNameStringInput();
        System.out.println("What do you wanna do?");
        System.out.println("1. Make tamagotchi Sleep");
        System.out.println("2. Feed tamagotchi");
        System.out.println("3. play");
        System.out.println("4. work\n");
        System.out.println("Input here:");
        int actInput = ui.userActIntInput();
        String activityName = "sleep";
        switch (actInput) {
            case 1:
                activityName = "sleep";
                System.out.println("How long will the tamagotchi sleep? (hours)");
                break;
            case 2:
                activityName = "feed";
                System.out.println("How many portions will you feed the tamagotchi? (portions)");
                break;
            case 3:
                activityName = "play";
                System.out.println("How long will the tamagotchi play? (hours)");
                break;
            case 4:
                activityName = "work";
                System.out.println("How long will the tamagotchi work? (hours)");
                break;
        }
        int hours = ui.userIntInput();
        tc.performActivityOnPet(input, activityName,hours);
        System.out.println("The tamagotchis is performing activity!..");
        ui.sleep(3000);
    }

    public void happiestMenu() {
        System.out.println("The happiest tamagotchi is: ");
        Tamagotchi happiestPet = tc.getHappiestPet().firstEntry().getKey();
        tc.getHappiestPet().keySet().forEach(Tamagotchi -> {
            if (Tamagotchi.getHappiness() == happiestPet.getHappiness()) {
                System.out.println(Tamagotchi.getName() + " Happiness: " + Tamagotchi.getHappiness());
            }
        });
        System.out.println(" ");
        ui.sleep(3000);
    }

    public void hungriestMenu() {
        System.out.println("The hungriest tamagotchi is: ");
        Tamagotchi hungriestPet = tc.getMostHungryPet().firstEntry().getKey();
        tc.getMostHungryPet().keySet().forEach(Tamagotchi -> {
            if (Tamagotchi.getHunger() == hungriestPet.getHunger()) {
                System.out.println(Tamagotchi.getName() + " Hunger: " + Tamagotchi.getHunger());
            }
        });
        System.out.println(" ");
        ui.sleep(3000);
    }

    public void averageMenu() {
        System.out.println("The average happiness around here is " + tc.getAverageHappiness() + " wowie!" + "\n");
        ui.sleep(3000);
    }

    public void closeApp() {
        System.out.println("Closing app...");
        ui.sleep(2000);
        System.out.println("Have a good day! :D");
    }
}
