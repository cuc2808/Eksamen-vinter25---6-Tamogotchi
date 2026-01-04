import java.util.ArrayList;

public class Tamagotchi {

    public String name;
    public int hunger = 70;
    public int energy = 70;
    public int happiness = 70;
    public int coins = 0;


    public void performActivity() {

    }


    public void tamoSleep(int hoursSlept) {
        setEnergy((energy += (30 * hoursSlept)));
        setHunger((hunger += (-20 * hoursSlept)));
    }

    public void tamoFeed(int portions) {
        setEnergy((energy += (5 * portions)));
        setHunger((hunger += (25 * portions)));
        setHappiness((happiness += (10 * portions)));
    }

    public void tamoPlay(int hoursPlayed) {
        setHunger((hunger += (-10 * hoursPlayed)));
        setEnergy((energy += (-10 * hoursPlayed)));
        setHappiness((happiness += (30 * hoursPlayed)));
    }

    public void tamoWork(int hoursWorked) {
        setHunger((hunger += (-5 * hoursWorked)));
        setEnergy((energy += (-5 * hoursWorked)));
        setHappiness((happiness += (-10 * hoursWorked)));
        setCoins((coins += (50 * hoursWorked)));
    }


    // GETTERs AND SETTERs

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger > 300) {
            hunger = 300;
        } else if (hunger < -300)
        this.hunger = hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy > 100) {
            energy = 100;
        }
        this.energy = energy;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if (happiness > 100) {
            happiness = 100;
        }
        this.happiness = happiness;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
