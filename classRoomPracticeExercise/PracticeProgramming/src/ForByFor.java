package com.sg.foundations.flowcontrol.fors;

public class ForByFor {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                // if j = 1, add $
                for (int k = 0; k < 3; k++) {
                    if ( i == 1 && j == 1) { // whatever signs that will get override goes first
                        System.out.print("#");
                    }
                    else if (i == 1) {
                        System.out.print("@");
                    }
                    else if (j == 1) {
                        System.out.print("$");
                    }
                    else System.out.print("*");
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}

/*
if (we're in the middle column-group {
    if(we're in middle row {
        #
    } else {
        $
      }
      else { // we're in left or right column-group
             // do either * or @
             if(we're in row 1 or row 3) {
                *
             }
             else {
                @
             }
}
 */