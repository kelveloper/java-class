public class LovesMe {
    public static void main(String[] args) {
        boolean loveMe = true;
        int petals = 2;
        System.out.println("Well here goes nothing...");
        do {
            System.out.println("It LOVES me!");
            petals--;
            System.out.println("It loves me NOT!");
            petals--;
        } while(petals >= 0);

    }
}
