public class Liquid {

    int[] p1=new int[2];
    int[] p2=new int[2];
    int[] p3=new int[2];
    int[] p4=new int[2];
    int[] p5=new int[2];
    int[] p6=new int[2];

    public Liquid(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int x5,int y5,int x6,int y6) {
        this.p1[0] = x1;
        this.p1[1] = y1;
        this.p2[0] = x2;
        this.p2[1] = y2;
        this.p3[0] = x3;
        this.p3[1] = y3;
        this.p4[0] = x4;
        this.p4[1] = y4;
        this.p5[0] = x5;
        this.p5[1] = y5;
        this.p6[0] = x6;
        this.p6[1] = y6;

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
