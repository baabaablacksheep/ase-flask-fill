public class LiquidTemp {

    private int codX;
    private int codY;
    private int height;
    private int width;

    public LiquidTemp(int startX, int startY, int height, int width) {
        this.codX = startX;
        this.codY = startY;
        this.height = height;
        this.width = width;
    }

    public int getCodX() {
        return codX;
    }

    public void setCodX(int codX) {
        this.codX = codX;
    }

    public int getCodY() {
        return codY;
    }

    public void setCodY(int codY) {
        this.codY = codY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
