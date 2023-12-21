<<<<<<< HEAD
import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your last name");
        String lastName = sc.nextLine();

        if(lastName.compareToIgnoreCase("Baggins") < 0) { // compareToIgnoreCase()
            System.out.println("Red Dragons");
        } else if (lastName.compareToIgnoreCase("Dresden") < 0 ) {
            System.out.println("Dark Wizards");
        } else if (lastName.compareToIgnoreCase("Howl") < 0 ) {
            System.out.println("Moving Castles");
        } else if (lastName.compareToIgnoreCase("Potter") < 0 ) {
            System.out.println("Golden Snitches");
        } else if (lastName.compareToIgnoreCase("Vimes") < 0 ) {
            System.out.println("Night Guards");
        } else System.out.println("Black Holes");


    }
}
=======
public class FieldDay {
    public static void main(String[] args) {
        //need help
    }
}
>>>>>>> 6a51527984e9c113aa8e3981d95c1f1168074c88
