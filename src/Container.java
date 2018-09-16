public abstract class Container implements ContainerSuper{

    Point p1;
    Point p2;
    Point p3;
    Point p4;
    Point p5;
    Point p6;

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
                System.out.println("Invalid Point");
                break;

        }
    }

    @Override
    public Point getPoint(int index) {
        switch(index){
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
            case 4:
                return p4;
            case 5:
                return p5;
            case 6:
                return p6;
            default:
                System.out.println("Invalid Point");
                return null;
        }
    }
}
