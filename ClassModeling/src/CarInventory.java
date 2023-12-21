public class CarInventory {

    /* 1. Model a car as if the class were to be part of an inventory system
     for a car dealership. (how many in stock; name of the cars in stock)
       2. Model a car as if the class were to be part of a video game.
       (name of the video game; how many sold copies
    */

    private String carModel;
    private int inStock;

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }



    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    public CarInventory() {

    }
    public CarInventory(String carModel, int inStock) {
        this.carModel = carModel;
        this.inStock = inStock;
    }


}
