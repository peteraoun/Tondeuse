package main.java.test;

import main.java.orientation.Orientation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testTurnRight() {
        // Test de rotation à droite depuis chaque orientation
        assertEquals(Orientation.E, Orientation.N.turnRight());
        assertEquals(Orientation.S, Orientation.E.turnRight());
        assertEquals(Orientation.W, Orientation.S.turnRight());
        assertEquals(Orientation.N, Orientation.W.turnRight());
    }

    @Test
    void testTurnLeft() {
        // Test de rotation à gauche depuis chaque orientation
        assertEquals(Orientation.W, Orientation.N.turnLeft());
        assertEquals(Orientation.N, Orientation.E.turnLeft());
        assertEquals(Orientation.E, Orientation.S.turnLeft());
        assertEquals(Orientation.S, Orientation.W.turnLeft());
    }
}
