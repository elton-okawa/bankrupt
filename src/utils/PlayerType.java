package utils;

/**
 * Created by e11even on 14/04/18.
 */
public enum PlayerType {
    IMPULSIVE (0, "Impulsivo"),
    DEMANDING (1, "Exigente"),
    CAUTIOUS (2, "Cauteloso"),
    RANDOM (3, "Aleatorio");

    private int type;
    private String typeString;

    PlayerType(int type, String typeString){
        this.type = type;
        this.typeString = typeString;
    }

    public int getType() {
        return type;
    }

    public String getTypeString() {
        return typeString;
    }

    public static PlayerType getPlayerByType(int type) {
        if (type == IMPULSIVE.getType()) {
            return IMPULSIVE;
        }
        else if (type == DEMANDING.getType()) {
            return DEMANDING;
        }
        else if (type == CAUTIOUS.getType()) {
            return CAUTIOUS;
        }
        else if (type == RANDOM.getType()) {
            return RANDOM;
        }
        else {
            System.err.println("PlayerType not found: " + type);
            return IMPULSIVE;
        }

    }
}
