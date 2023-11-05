package unit_tests;

import org.junit.jupiter.api.Test;
import util.Pair;

import static org.junit.jupiter.api.Assertions.*;

class TestPair {
    Pair<Integer, String> pair1 = new Pair<>(3,"2");
    Pair <Integer, String> pair1Altered = new Pair<>(3, null);
    Pair<Integer, String> pair2 = new Pair<>(null, "1");
    Pair<Integer, String> undeclaredPair;
    Pair<Integer,Integer> nullPair = new Pair<>(null,null);

    @Test
    void testEquality() {
        //Test was should be equals
        Pair<Integer, String> pair1clone = Pair.makePair(3, "2");
        assertEquals(pair1,pair1clone);
        assertEquals(pair1, pair1);

        //Should be equal to the prime number used in the method
        int primeValueUsed = 31;
        assertEquals(primeValueUsed * primeValueUsed,nullPair.hashCode());

        //a and b not equal, they shouldn't be equivalent.
        assertNotEquals(pair1, pair2);
        assertNotEquals(pair2,pair1);

        //As one pair is not instantiated shouldn't be equal
        assertNotEquals(pair1, undeclaredPair);

        //Both shouldn't be true though equal types a value is null
        assertNotEquals(pair1, pair1Altered);
        assertNotEquals(pair1Altered,pair1);
    }
}
