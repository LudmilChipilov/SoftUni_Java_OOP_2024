package inheritanceThree;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList
{

    private final Random random = new Random();

    public Object getRandomElement()
    {
        int randomIndex = random.nextInt(this.size()); // this == randomArrayList
        return this.remove(randomIndex); // remove element at randomIndex

    }
}
