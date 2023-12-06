public class CarVideoGame {
    private String gameTitle;
    private final int copiesSold;

    // private int soldAfterTwoYrs;

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public int getSoldAfterTwoYrs() {
        return getCopiesSold() * 2;
    }

    public CarVideoGame(String gameTitle, int copiesSold) {
        this.gameTitle = gameTitle;
        this.copiesSold = copiesSold;
    }

}
