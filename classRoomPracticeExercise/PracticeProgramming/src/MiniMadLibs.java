import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        String input1, input2, input3, input4, input5, input6,
                input7, input8, input9, input10;
        Scanner inputReader = new Scanner(System.in);

        System.out.println("Let's play MAD LIBS!");
        System.out.println();

        System.out.println("I need a noun: ");
        input1 = inputReader.nextLine();
        System.out.println("Now an adjective: ");
        input2 = inputReader.nextLine();
        System.out.println("Another noun: ");
        input3 = inputReader.nextLine();
        System.out.println("And a number: ");
        input4 = inputReader.nextLine();
        System.out.println("Another adjective: ");
        input5 = inputReader.nextLine();
        System.out.println("A plural noun: ");
        input6 = inputReader.nextLine();
        System.out.println("Another one: ");
        input7 = inputReader.nextLine();
        System.out.println("One more: ");
        input8 = inputReader.nextLine();
        System.out.println("A verb (infinitive form): ");
        input9 = inputReader.nextLine();
        System.out.println("Same verb (past participle): ");
        input10 = inputReader.nextLine();

        System.out.println();
        System.out.println("*** NOW LETS GET MAD (libs) ***");
        System.out.println(input1 + ": the " + input2 + " frontier. These are the voyages of the starship " + input3
            + ". Its" + input4 + "-year mission: to explore strange " + input5 + " " + input6
            + ", to seek out " + input5 + " " + input7 + " and " + input5 + " " + input8 + ", to boldly "
            + input9 + " where no one has " + input10 + " before.");

    }
}
