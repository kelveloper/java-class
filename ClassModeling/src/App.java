public class App {
    public static void main(String[] args) {
        CarInventory carInventory = new CarInventory();
        CarInventory carInventory1 = new CarInventory("Nissan", 8);
        CarVideoGame carVideoGame = new CarVideoGame("Forza Motorsport 7", 20);


        carVideoGame.setGameTitle("Mario Kart");
        carInventory1.setCarModel("BMW");

        System.out.println(carInventory1.getInStock());
        System.out.println(carInventory.getCarModel());
        System.out.println(carVideoGame.getGameTitle());
        System.out.println(carInventory1.getCarModel());

        // Multiply by 2 in CarVideoGame class :)
        System.out.println(carVideoGame.getSoldAfterTwoYrs());
    }
}

//explain and print out