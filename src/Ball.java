public class Ball {
    /*
     * Simple Object class to store the ball's co-ordinates.
     */
    private int x;
    private int y;
    private int width;
    private int height;

    Ball() {

    } // default constructor

    public int getX() { // accessor/GET method for data
        return x;
    }

    public void setX(int x2) { // mutator/SET method for data
        x = x2;
    }

    public int getY() {
        return y;
    }

    public void setY(int y2) {
        y = y2;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

