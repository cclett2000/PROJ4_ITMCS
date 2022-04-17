//++++++++++++++++++++++++++++++++++++++++++++++++
// Name: getMapType.java
// Function: get function mapping type
// Programmer: Charles Lett Jr.
// Last Updated: 04/17/22
//++++++++++++++++++++++++++++++++++++++++++++++++

import java.util.Arrays;
import java.util.Scanner;

public class getMapType {
    public void run(){
        getType();
    }

    private static void getType(){
        boolean isSurjecive = false;
        boolean isInjective = false;
        boolean isBijective = false;


        // provided function
        String[] func_X = {"a", "b", "c", "d"};
        String[] func_Y = {"1", "2", "3", "4"};

        // init storage for user function
        String[] u_func_X = new String[4];
        int[] x_temp = {0, 0, 0, 0};
        int[] y_temp = {0, 0, 0, 0};

        String[] u_func_Y = new String[4];

        Scanner uInput = new Scanner(System.in);

        System.out.println("Provided Function: \n"
                + "\tX = " + Arrays.toString(func_X)
                + "\n\tY = " + Arrays.toString(func_Y));

        System.out.println("Now choose from the above to create your own set.");

        System.out.println("Begin Filling Domain...");
        for (int x = 0; x < u_func_X.length; x++){
            System.out.print((x + 1) + "/" + u_func_X.length + " >>> ");
            u_func_X[x] = uInput.nextLine();
        }
        System.out.println("Domain Filled!");

        System.out.println("\nBegin Filling Target (input '-1' for no target)");
        for (int y = 0; y < u_func_Y.length; y++){
            System.out.print((y + 1) + "/" + u_func_Y.length + " >>> ");
            u_func_Y[y] = uInput.nextLine();
        }
        System.out.println("Target Filled!");

        // begin type check
        int[] target_count = new int[4];    // number target occurrences

        // domain check
        for (int i = 0; i < u_func_X.length; i++) {
            for (int j = 0; j < u_func_X.length; j++) {
                if (u_func_X[j].equals(u_func_X[i])){
                    x_temp[i] += 1;
                }
            }
        }

        for (int k = 0; k < x_temp.length; k++) {
            if (x_temp[k] > 1) {
                System.out.println("\nThis is not a function! [ERR: Duplicate Domain(s) Found!]");
                System.exit(419);
            }
        }

        // target check
        for(int y = 0; y < u_func_Y.length; y++){
            if (u_func_Y[y].equals("-1")){
                System.out.println("\nThis is not a function! [ERR: Unmapped Domain Detected!]");
                System.exit(920);
            }

            for (int yy = 0; yy < u_func_Y.length; yy++){
                if (u_func_Y[y].equals(u_func_Y[yy])){
                    y_temp[y] += 1;
                }
            }
        }

        for(int i = 0; i < y_temp.length; i++){
            if (y_temp[i] > 1){
                isInjective = false;
                isSurjecive = true;
            }

            if (y_temp[i] == 1) {
                isInjective = true;
                isSurjecive = true;
            }
        }

        if (isInjective == true && isSurjecive == true) isBijective = true;

        // debug info
        System.out.println("\n[DEBUG]\n" + Arrays.toString(x_temp));
        System.out.println(Arrays.toString(u_func_X));

        System.out.println("\n" + Arrays.toString(y_temp));
        System.out.println(Arrays.toString(u_func_Y));

        System.out.println("\nInjective: " + isInjective);
        System.out.println("Surjective: " + isSurjecive);
        System.out.println("Bijective: " + isBijective);

    }
}
