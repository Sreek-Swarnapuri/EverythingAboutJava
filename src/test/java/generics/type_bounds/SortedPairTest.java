package generics.type_bounds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortedPairTest {

    @Test
    public void shouldRetainOrderOfOrderedPair() {
        SortedPair<Integer> pair = new SortedPair<>(1, 2);

        Assertions.assertEquals(1, pair.getFirst().intValue());
        Assertions.assertEquals(2, pair.getSecond().intValue());
    }

    @Test
    public void shouldFlipOrderOfMisorderedPair() {
        SortedPair<Integer> pair = new SortedPair<>(2, 1);

        Assertions.assertEquals(1, pair.getFirst().intValue());
        Assertions.assertEquals(2, pair.getSecond().intValue());
    }

}
