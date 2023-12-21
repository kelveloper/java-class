public class Main {
    public static void main(String args[]) {
        int i = 0, j = 2;
        do {
            i = ++i;
            j--;
        } while (j > 0);
        System.out.println(i);
    }
}