public class LiquidOld {

    int[] p1=new int[2];
    int[] p2=new int[2];
    int[] p3=new int[2];
    int[] p4=new int[2];
    int[] p5=new int[2];
    int[] p6=new int[2];

    int mouthWidth = 30;
    int bodyHeight = 150;
    int mouthHeight = (bodyHeight / 2) * 3;

    int startX=0;
    int startY=0;

    public LiquidOld(int startX, int startY, int mouthwidth, int bodyHeight) {

        this.bodyHeight=bodyHeight;
        this.mouthWidth=mouthwidth;
        this.mouthHeight=(bodyHeight / 2) * 3;

        this.startX=startX;
        this.startY=startY;

/*        startX,startY+mouthHeight,
                startX,startY+mouthHeight,
                startX - mouthWidth * 2,startY + mouthHeight + bodyHeight,
                startX + mouthWidth * 3,startY + mouthHeight + bodyHeight,
                startX + mouthWidth,startY + mouthHeight,
                startX + mouthWidth,startY+mouthHeight);*/

        this.p1[0] = startX - mouthWidth * 2;
        this.p1[1] = startY + mouthHeight + bodyHeight;
        this.p2[0] = startX - mouthWidth * 2;
        this.p2[1] = startY + mouthHeight + bodyHeight;
        this.p3[0] = startX - mouthWidth * 2;
        this.p3[1] = startY + mouthHeight + bodyHeight;
        this.p4[0] = startX + mouthWidth * 3;
        this.p4[1] = startY + mouthHeight + bodyHeight;
        this.p5[0] = startX + mouthWidth * 3;
        this.p5[1] = startY + mouthHeight + bodyHeight;
        this.p6[0] = startX + mouthWidth * 3;
        this.p6[1] = startY + mouthHeight + bodyHeight;

    }

    public int getP1(int index) {
        if(index==0){
            return p1[0];
        }
        return p1[1];
    }

    public void setP1(int x,int y) {
        this.p1[0] = x;
        this.p1[1] = y;
    }

    public int getP2(int index) {
        if(index==0){
            return p2[0];
        }
        return p2[1];
    }

    public void setP2(int x,int y) {
        this.p2[0] = x;
        this.p2[1] = y;
    }

    public int getP3(int index) {
        if(index==0){
            return p3[0];
        }
        return p3[1];
    }

    public void setP3(int x,int y) {
        this.p3[0] = x;
        this.p3[1] = y;
    }

    public int getP4(int index) {
        if(index==0){
            return p4[0];
        }
        return p4[1];
    }

    public void setP4(int x,int y) {
        this.p4[0] = x;
        this.p4[1] = y;
    }

    public int getP5(int index) {
        if(index==0){
            return p5[0];
        }
        return p5[1];
    }

    public void setP5(int x,int y) {
        this.p5[0] = x;
        this.p5[1] = y;
    }

    public int getP6(int index) {
        if(index==0){
            return p6[0];
        }
        return p6[1];
    }

    public void setP6(int x,int y) {
        this.p6[0] = x;
        this.p6[1] = y;
    }
}
