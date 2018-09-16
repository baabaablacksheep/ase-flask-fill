public class Point implements PointSuper {

    private int cordX;
    private int cordY;

    public Point(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
    }

    @Override
    public int getCordX() {
        return cordX;
    }

    @Override
    public int getCordY() {
        return cordY;
    }

    @Override
    public void setCordX(int x) {
        this.cordX=x;
    }

    @Override
    public void setCordY(int y) {
        this.cordY=y;
    }
}
