package main.java.test;

import main.java.lawnmower.LawnMower;
import main.java.orientation.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {
    
    @Test
    void testMove() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);
        
        // Act
        lawnMower.move("GAGAGAGAA", 5, 5);
        
        // Assert
        assertEquals("1 3 N", lawnMower.getPosition());
    }
    
    @Test
    void testMoveForward() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);
        
        // Act
        lawnMower.moveForward(5, 5);
        
        // Assert
        assertEquals("1 3 N", lawnMower.getPosition());
    }

    // Test for moving the lawn mower outside the boundaries
    @Test
    void testMoveForwardOutsideBoundary() {
        // Arrange
        LawnMower lawnMower = new LawnMower(5, 5, Orientation.N);
        
        // Act
        lawnMower.moveForward(5, 5);
        
        // Assert
        assertEquals("5 5 N", lawnMower.getPosition());
    }

    @Test
    void testMoveWithNoInstructions() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);

        // Act
        lawnMower.move("", 5, 5);

        // Assert
        assertEquals("1 2 N", lawnMower.getPosition());
    }

    @Test
    void testMoveOffTheLawn() {
        // Arrange
        LawnMower lawnMower = new LawnMower(5, 5, Orientation.N);

        // Act
        lawnMower.move("A", 5, 5);

        // Assert
        assertEquals("5 5 N", lawnMower.getPosition());
    }

    @Test
    void testMoveStraight() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);

        // Act
        lawnMower.move("A", 5, 5);

        // Assert
        assertEquals("1 3 N", lawnMower.getPosition());
    }

    @Test
    void testTurnRight() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);

        // Act
        lawnMower.move("D", 5, 5);

        // Assert
        assertEquals("1 2 E", lawnMower.getPosition());
    }

    @Test
    void testTurnLeft() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);

        // Act
        lawnMower.move("G", 5, 5);

        // Assert
        assertEquals("1 2 W", lawnMower.getPosition());
    }

    @Test
    void testMultipleInstructions() {
        // Arrange
        LawnMower lawnMower = new LawnMower(1, 2, Orientation.N);

        // Act
        lawnMower.move("DAAD", 5, 5);

        // Assert
        assertEquals("3 2 S", lawnMower.getPosition());
    }

    @Test
    void testMoveOutOfBounds() {
        // Arrange
        LawnMower lawnMower = new LawnMower(0, 0, Orientation.S);

        // Act
        lawnMower.move("AAAAA", 2, 2);

        // Assert
        assertEquals("0 0 S", lawnMower.getPosition());
    }

    @Test
    void testHandlingOfTwoMowersWithMower1ReachingBounds() {
        // Arrange
        LawnMower mower1 = new LawnMower(1, 2, Orientation.N);
        LawnMower mower2 = new LawnMower(3, 3, Orientation.E);

        // Act
        mower1.move("AAAGAGAD", 5, 5);
        mower2.move("DAADAD", 5, 5);

        // Assert
        assertEquals("0 4 W", mower1.getPosition());
        assertEquals("2 1 N", mower2.getPosition());
    }

    @Test
    void testHandlingOfFiveMowers() {
        // Arrange
        LawnMower[] mowers = {
                new LawnMower(1, 2, Orientation.N),
                new LawnMower(3, 3, Orientation.E),
                new LawnMower(0, 0, Orientation.W),
                new LawnMower(4, 4, Orientation.S),
                new LawnMower(2, 2, Orientation.S)
        };

        // Act
        mowers[0].move("AAAGAGAD", 5, 5); //move + turn
        mowers[1].move("DAADAD", 5, 5); //turn + move
        mowers[2].move("AAA", 5, 5); //try to move out of bounds and stay put
        mowers[3].move("AADA", 5, 5); //move + turn
        mowers[4].move("A", 5, 5); //move once forward

        // Assert
        assertEquals("0 4 W", mowers[0].getPosition());
        assertEquals("2 1 N", mowers[1].getPosition());
        assertEquals("0 0 W", mowers[2].getPosition());
        assertEquals("3 2 W", mowers[3].getPosition());
        assertEquals("2 1 S", mowers[4].getPosition());
    }

    @Test
    void testUpperBounds() {
        // Arrange
        LawnMower lawnMower = new LawnMower(5, 5, Orientation.N);

        // Act
        lawnMower.move("A", 5, 5);

        // Assert
        assertEquals("5 5 N", lawnMower.getPosition());
    }

    @Test
    void testLowerBounds() {
        // Arrange
        LawnMower lawnMower = new LawnMower(0, 0, Orientation.N);

        // Act
        lawnMower.move("A", 5, 5);

        // Assert
        assertEquals("0 1 N", lawnMower.getPosition());
    }

    @Test
    void testTurnAtUpperBounds() {
        // Arrange
        LawnMower lawnMower = new LawnMower(5, 5, Orientation.N);

        // Act
        lawnMower.move("D", 5, 5);

        // Assert
        assertEquals("5 5 E", lawnMower.getPosition());
    }

    @Test
    void testTurnAtLowerBounds() {
        // Arrange
        LawnMower lawnMower = new LawnMower(0, 0, Orientation.N);

        // Act
        lawnMower.move("G", 5, 5);

        // Assert
        assertEquals("0 0 W", lawnMower.getPosition());
    }
}
