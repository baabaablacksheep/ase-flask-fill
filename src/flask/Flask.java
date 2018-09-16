package flask;

public class Flask extends Container {

    private int flaskHeight;
    private int flaskWidth;

    private int mouthHeight;
    private int bodyHeight;

    private int baseStartPointX;
    private int baseStartPointY;

    public Flask(int flaskHeight, int flaskWidth, int baseStartPointX,int baseStartPointY) {
        this.flaskHeight = flaskHeight;
        this.flaskWidth = flaskWidth;
        this.baseStartPointX=baseStartPointX;
        this.baseStartPointY=baseStartPointY;

        deriveDimensions();
        setFlask();

    }

    public int getFlaskWidth() {
        return flaskWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public int getBaseStartPointX() {
        return baseStartPointX;
    }

    public int getBaseStartPointY() {
        return baseStartPointY;
    }

    private void deriveDimensions(){
        this.mouthHeight=flaskHeight*3/4;
        this.bodyHeight=flaskHeight/3;
    }

    private void setFlask() {

        setPoint(3,baseStartPointX,baseStartPointY);
        setPoint(4,baseStartPointX+flaskWidth,baseStartPointY);

        setPoint(2,p3.getCordX()+bodyHeight/2,p3.getCordY()-bodyHeight);
        setPoint(5,p4.getCordX()-bodyHeight/2,p4.getCordY()-bodyHeight);

        setPoint(1,p2.getCordX(),p2.getCordY()-mouthHeight);
        setPoint(6,p5.getCordX(),p5.getCordY()-mouthHeight);

    }


}
