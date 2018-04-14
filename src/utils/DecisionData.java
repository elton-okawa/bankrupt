package utils;

/**
 * Created by e11even on 13/04/18.
 */
public class DecisionData {

    private int coins;
    private int price;
    private int rent;

    public DecisionData() {}

    public void reset() {
        coins = -1;
        price = -1;
        rent = -1;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
