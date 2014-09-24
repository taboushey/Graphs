package Graph;

import java.io.*;
import java.util.*;

/*
 * @author Tabetha Boushey
 * Date: 7/9/2013
 * CSCI232 Lab 3
 * Class: Driver
 */

public class Driver {

    public Driver() {
        int[][] myMatrixArray = null;
        try {
            Scanner scanner1 = new Scanner(new FileReader("input.txt")); // counts how large the Matrix is
            int counter = 0;
            while (scanner1.hasNextLine()) {
                if (scanner1.nextLine() != null) {
                    counter++;
                }
            }
            scanner1.close();

            myMatrixArray = new int[counter][counter]; // makes the matrix square
            Scanner scanner2 = new Scanner(new FileReader("input.txt"));
            String temp = "";
            for (int x = 0; x < counter; x++) {
                temp = scanner2.nextLine();
                for (int y = 0; y < counter; y++) {
                    myMatrixArray[x][y] = Integer.parseInt("" + temp.charAt(y));
                }
            }
            scanner2.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Graph bfsGraph = new Graph(myMatrixArray);
        Algorithms.breadthFirstSearch(bfsGraph, 0);

        Graph dfsGraph = new Graph(myMatrixArray);
        Algorithms.depthFirstSearch(dfsGraph, 0);

        Graph dijkstras = new Graph(myMatrixArray);
        Algorithms.dijkstra(dijkstras, 0, 5);

        Graph prim = new Graph(myMatrixArray);
        Algorithms.prims(prim, 0);

        Graph floyd = new Graph(myMatrixArray);
        Algorithms.floydWarshall(floyd);
    }

    public static void main(String[] args) {
        new Driver();
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
}
