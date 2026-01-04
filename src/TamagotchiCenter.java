import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TamagotchiCenter {

    public static ArrayList<Tamagotchi> tamagotchis = new ArrayList<>();

    public void addPet(String tamaName) {
        Tamagotchi tamagotchi = new Tamagotchi(tamaName);
        tamagotchis.add(tamagotchi);
    }

    public void removePet(String tamaName) {
        tamagotchis.remove(getPet(tamaName));
    }

    public Tamagotchi getPet(String tamaName) {
        for (Tamagotchi tamagotchi : tamagotchis) {
            if (tamagotchi.getName().equalsIgnoreCase(tamaName)) {
                return tamagotchi;
            }
        }
        return null;
    }

    public void performActivityOnPet(String tamaName, String activity, int hoursDoingActivity) {
        getPet(tamaName).performActivity(activity,hoursDoingActivity);

    }

    public void printStatusReport() {
        System.out.println("=== Status on Tamagotchis ===\n");
        if (tamagotchis.isEmpty()) {
            System.out.println("There is no tamagotchi!...");
        }
        for (Tamagotchi tamagotchi : tamagotchis) {
            System.out.println("Name: " + tamagotchi.getName());
            System.out.println("-Happiness " + tamagotchi.getHappiness());
            System.out.println("-Energy " + tamagotchi.getEnergy());
            System.out.println("-Hunger " + tamagotchi.getHunger());
            System.out.println("-Coins " + tamagotchi.getCoins());
            System.out.println("\n----------------------------\n");
        }
    }

    public LinkedHashMap <Tamagotchi, Integer> getHappiestPet() {
        LinkedHashMap <Tamagotchi, Integer> happiestList = new LinkedHashMap<>();
        for(int i = 100; i >= 0; i--) {
            for (Tamagotchi tamagotchi : tamagotchis) {
                if (tamagotchi.getHappiness() == i) {
                    happiestList.put(tamagotchi,tamagotchi.getHappiness());
                }
            }
        }
        return happiestList;
    }

    public LinkedHashMap <Tamagotchi, Integer> getMostHungryPet() {
        LinkedHashMap <Tamagotchi, Integer> mostHungryList = new LinkedHashMap<>();
        for(int i = 200; i >= -300; i--) {
            for (Tamagotchi tamagotchi : tamagotchis) {
                if (tamagotchi.getHunger() == i) {
                    mostHungryList.put(tamagotchi,tamagotchi.getHunger());
                }
            }
        }
        return mostHungryList;
    }

    public double getAverageHappiness() {
        int amountOfTamas = 0;
        int totalHappiness = 0;
        for (Tamagotchi tamagotchi : tamagotchis) {
            amountOfTamas++;
            totalHappiness += tamagotchi.getHappiness();
        }

        return (double) totalHappiness /amountOfTamas;
    }
}
