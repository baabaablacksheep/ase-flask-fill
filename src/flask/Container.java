package flask;

import cordinate.point.Point;

public abstract class Container implements ContainerSuper {

    public Point p1;
    public Point p2;
    public Point p3;
    public Point p4;
    public Point p5;
    public Point p6;

    @Override
    public void setPoint(int index, int x, int y) {

        switch(index){
            case 1:
                p1=new Point(x,y);
                break;
            case 2:
                p2=new Point(x,y);
                break;
            case 3:
                p3=new Point(x,y);
                break;
            case 4:
                p4=new Point(x,y);
                break;
            case 5:
                p5=new Point(x,y);
                break;
            case 6:
                p6=new Point(x,y);
                break;
            default:
                System.out.println("Invalid Coordinate Point");
                break;

        }
    }
}
