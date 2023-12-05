public class CarVideoGame {
    private String gameTitle;
    private int copiesSold;

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public CarVideoGame(String gameTitle, int copiesSold) {
        this.gameTitle = gameTitle;
        this.copiesSold = copiesSold;
    }

}
