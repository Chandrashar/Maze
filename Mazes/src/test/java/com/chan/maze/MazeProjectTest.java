/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chan.maze;

import static com.chan.maze.MazeProject.EMPTY_SPACE;
import static com.chan.maze.MazeProject.EXIT;
import static com.chan.maze.MazeProject.START;
import static com.chan.maze.MazeProject.WALL;
import java.awt.Point;
import java.time.Clock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class MazeProjectTest {
     MazeProject testObject = null;
        
     char[][] easyMaze = {                    
                    { WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL },
                    { WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, START, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL  },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, WALL  },
                    { WALL, EMPTY_SPACE, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL, EMPTY_SPACE, WALL },
                    { WALL, EMPTY_SPACE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, EMPTY_SPACE, EMPTY_SPACE, EMPTY_SPACE, WALL },
                    { WALL, EXIT, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL }                   
                };
    
    public MazeProjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testObject = new MazeProject(easyMaze);
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test Object Creation, of class MazeProject
     */
    @org.junit.Test
    public void testCreatMazeProjectTestObject() throws Exception {
        assertNotNull(testObject);        
    }
    
    /**
     * Test a Maze as Maze1.txt consist of Walls 'X'
     */
    @org.junit.Test
    public void testWallsExist(){
         System.out.println("Test: testWallsExist");
        Point wallPoint = testObject.findPositionMarker(WALL);
        assertNotNull(wallPoint);
    }
    
    /**
     * Test a Maze as Maze1.txt consist of One and Only one Start point as 'S'
     */
    @org.junit.Test
    public void testStartPointExist(){
        System.out.println("Test: testStartPointExist");
        Point startPoint = testObject.findPositionMarker(START);
        assertNotNull(startPoint);
    }
    /**
     * Test a Maze as Maze1.txt consist of One and Only one Exit point as 'E' 
     */
    @org.junit.Test
    public void testExitPointExist(){
        System.out.println("Test: testExitPointExist");
        Point exitPoint = testObject.findPositionMarker(EXIT);
        assertNotNull(exitPoint);
    }
    
    /**
     * Test a Maze as Maze1.txt consist of Empty spaces ' ' 
     */
    @org.junit.Test
    public void testEmptySpacesExist(){
        System.out.println("Test: testEmptySpacesExist");
        Point emptyPoint = testObject.findPositionMarker(EMPTY_SPACE);
        assertNotNull(emptyPoint);
    }
    
    
    
    /**
     * Test of getNeighbourPosition method, of class MazeProject.
     */
    @Test
    public void testGetNeighbourPosition() {
        System.out.println("Test: getNeighbourPosition");
        Point location = new Point(7, 9);
        Point[] expResult = new Point[4];
        expResult[0] = new Point(8, 9);
        expResult[1] = new Point(7, 10);
        expResult[2] = new Point(6, 9);
        expResult[3] = new Point(7, 8);
        
        Point[] result = testObject.getNeighbourPosition(location);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of findStatPosition method, of class MazeProject.
     */
    @Test
    public void testFindStatPosition() {
        System.out.println("Test: findStatPosition");       
        Point result = testObject.findStatPosition();
        assertEquals(3, result.x); // START coordinates - x
        assertEquals(3, result.y); // START coordinates - x
    }


    /**
     * Test of mazeCompleted method, of class MazeProject.
     */
    @Test
    public void testMazeCompleted() {
        System.out.println("Test: mazeCompleted");
        Point location = new Point(14, 1);        
        boolean result = testObject.mazeCompleted(location);
        assertTrue(result);
         location = new Point(9, 6);
         result = testObject.mazeCompleted(location);
        assertFalse(result);
    }

    /**
     * Test of findPositionMarker method, of class MazeProject.
     */
    @Test
    public void testFindPositionMarker() {
        System.out.println("Test: findPositionMarker");
        char c = ' ';
        //Point expResult = null;
        Point result = testObject.findPositionMarker(c);
        assertNotNull(result);
    }

    /**
     * Test of checkNeighbourPositionFree method, of class MazeProject.
     */
    @Test
    public void testCheckNeighbourPositionFree() {
        System.out.println("Test: checkNeighbourPositionFree");
        Point square = new Point(9, 9);
        //boolean expResult = false;
        boolean result = testObject.checkNeighbourPositionFree(square);
        assertFalse(result);
    }

    /**
     * Test of calculateExitPosition method, of class MazeProject.
     */
    @Test
    public void testCalculateExitPosition() {
        System.out.println("Test: calculateExitPosition");       
        Point result = testObject.calculateExitPosition();
        assertEquals(14, result.x); // X coordinate of Exit Point
        assertEquals(1, result.y); // Y coordinate of Exit Point        
    }
    
}
