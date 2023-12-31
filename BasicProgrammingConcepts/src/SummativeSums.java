public class SummativeSums {
    public static void main(String[] args) {
        /*
        Write a static method that takes in an array of ints, adds them together, and returns the result.

Call your new method inside a main method and print out the results for the following three example arrays:

{ 1, 90, -33, -55, 67, -16, 28, -55, 15 }
{ 999, -60, -77, 14, 160, 301 }
{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
140, 150, 160, 170, 180, 190, 200, -99 }
What You Should See
The following is an example of what the output might look like.

#1 Array Sum: 42
#2 Array Sum: 1337
#3 Array Sum: 2001
         */

        int[] arrOne = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] arrTwo = { 999, -60, -77, 14, 160, 301 };
        int[] arrThree = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
                140, 150, 160, 170, 180, 190, 200, -99 };

        System.out.println("#1 Array Sum: " + countAll(arrOne));
        System.out.println("#2 Array Sum: " + countAll(arrTwo));
        System.out.println("#3 Array Sum: " + countAll(arrThree));
    }
    public static int countAll(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

}
