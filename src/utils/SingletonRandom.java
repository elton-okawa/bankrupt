package utils;

import java.util.Random;

/**
 * Created by e11even on 13/04/18.
 */
public class SingletonRandom {

    private static SingletonRandom singletonRandom;
    private Random random;

    private SingletonRandom(){
        random = new Random();
    };

    public static SingletonRandom getInstance() {
        if (singletonRandom == null) {
            singletonRandom = new SingletonRandom();
        }
        return singletonRandom;
    }

    public int nextInt(int start, int end) {
        return random.nextInt(end - start) + start;
    }
}
