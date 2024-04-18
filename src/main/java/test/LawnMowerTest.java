package main.java.test;

import main.lawnmower.LawnMower;
import main.orientation.Orientation;
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
    void testMoveWithEdgeCase() {
        // Arrange
        LawnMower lawnMower = new LawnMower(3, 3, Orientation.E);
        
        // Act
        lawnMower.move("AADAADADDA", 5, 5);
        
        // Assert
        assertEquals("5 1 E", lawnMower.getPosition());
    }
    
    @Test
    void testMoveOutsideBoundary() {
        // Arrange
        LawnMower lawnMower = new LawnMower(0, 0, Orientation.S);
        
        // Act
        lawnMower.move("AAAAA", 2, 2);
        
        // Assert
        assertEquals("0 0 S", lawnMower.getPosition());
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
}
