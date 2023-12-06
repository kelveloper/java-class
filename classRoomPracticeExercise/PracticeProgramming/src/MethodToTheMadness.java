package com.sg.foundations.basics.methods;

public class MethodToTheMadness {
    public static void main(String[] args) {
        eatMe();
        drinkMe();

        System.out.println("\n ― Lewis Carroll, Alice in Wonderland");
    }

    static void eatMe(){
        System.out.println(" 'But I don’t want to go among mad people,' Alice remarked.");
        System.out.println(" 'Oh, you can’t help that,' said the Cat.");
        System.out.print(" 'We’re all mad here. I’m mad. You’re mad.'");
    }

    static void drinkMe(){ // on the method course #8, it prints the second output of drinkMe and it shouldn't
        System.out.println(" 'How do you know I’m mad?' said Alice.");
        System.out.println(" 'You must be,' said the Cat, 'or you wouldn’t have come here.' ");
    }
}