package map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e11even on 13/04/18.
 */
public class Map {

    private List<Property> properties;

    public Map() {
        init();
    }

    public void init() {
        properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public Property getPropertyAt(int mapIndex) {
        return properties.get(mapIndex);
    }

    public int getSize() {
        return properties.size();
    }
}
