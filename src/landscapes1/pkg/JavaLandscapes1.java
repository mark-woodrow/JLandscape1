/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landscapes1.pkg;

import java.util.Random;

/**
 *
 * @author mark
 */
public class JavaLandscapes1 {

    static final int size = 20;
    static int landscape[][] = new int[size][size];
    static Random rand;

    
    /**
     * returns either +1 or -1, randomly.  This determines whether
     * the landscape moves up, or down.
     * We use the range 0 .. 99 to try and get a better, more even
     * distribution of results.
     * @return 
     */
    static int getRandomDelta() {
        int d = rand.nextInt(100);
        if (d < 50) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        rand = new Random();
        int delta;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.format("%2d ", landscape[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        // Iterate for lots of times
        for (int counter = 0; counter < 900; counter++) {

            // pick a row, 0 .. size-1
            int row = rand.nextInt(size);
            // pick a level change, up or down
            delta = getRandomDelta();
            // raise/lower the land below this row
            for (int i = row; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    landscape[i][j] += delta;
                }
            }

            // pick a column, 0 .. size-1
            int column = rand.nextInt(size);
            // pick a level change
            delta = getRandomDelta();
            // raise/lower the land after this column
            for (int i = 0; i < size; i++) {
                for (int j = column; j < size; j++) {
                    landscape[i][j] += delta;
                }
            }

        }

        // chop the sea away!
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (landscape[i][j] < 0)
                        landscape[i][j] = 0;
                }
            }
        
        
        // print the landscape array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.format("%3d ", landscape[i][j]);
            }
            System.out.println();
        }

    }

}
