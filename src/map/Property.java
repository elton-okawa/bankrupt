package map;

import utils.GameConstants;

/**
 * Created by e11even on 13/04/18.
 */
public class Property {

    private int rent;
    private int price;
    private int ownerId;

    public Property(int price, int rent) {
        init(price, rent);
    }

    public void init(int price, int rent) {
        this.price = price;
        this.rent = rent;
        this.ownerId = GameConstants.NO_OWNER;
    }

    public boolean hasOwner() {
        return ownerId != GameConstants.NO_OWNER;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getRent() {
        return rent;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Property: price: %d, rent: %d, ownerId: %d\n", price, rent, ownerId);
    }
}

