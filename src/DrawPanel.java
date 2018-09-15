import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class DrawPanel extends JPanel implements ActionListener {


    int mouthWidth = 30;
    int bodyHeight = 150;
    int mouthHeight = (bodyHeight / 2) * 3;

    int startX=100;
    int startY=20;

    int velX=5,velY=5;

    //properties of the rectangle
    int startXRect=50;
    int startYRect=50;
    int widthRect=100;
    int heightRect=20;

    public int liquidFillRate=1;
    public boolean filled=false;
    public boolean isEmpty=true;

    Liquid cl=new Liquid(
            startX,startY+mouthHeight,
            startX,startY+mouthHeight,
            startX - mouthWidth * 2,startY + mouthHeight + bodyHeight,
            startX + mouthWidth * 3,startY + mouthHeight + bodyHeight,
            startX + mouthWidth,startY + mouthHeight,
            startX + mouthWidth,startY+mouthHeight);

    LiquidTemp currentLiquidTemp =new LiquidTemp(200,400,50,100);

    static Timer timer;

    Image ballImage;
    Ball currentBall=new Ball();

    DrawPanel() {

        try{
            ImageIcon ballImg = new ImageIcon("./resources/ball.png");
            ballImage = ballImg.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);; // get ImageIcon ballImg
        }
        catch(Exception ex){
            System.out.println("Error Occurred Wile Loading The Image!");
        }

        this.startX=100;
        this.startY=10;

        prepareImage(ballImage, this);
        currentBall.setX(10);
        currentBall.setY(10); // set currentBall's X and Y Position
        setDoubleBuffered(true);


        timer=new Timer(10,this);
        timer.start();


    }

    public void startTimer(){
        new Timer(10,this).start();
    }
    public void stopTimer(){
        new Timer(10,this).stop();
    }

    void drawFlask(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawLine(startX, startY, startX, startY + mouthHeight);
        g2d.drawLine(startX + mouthWidth, startY, startX + mouthWidth, startY + mouthHeight);
        g2d.drawLine(startX, startY + mouthHeight, startX - mouthWidth * 2, startY + mouthHeight + bodyHeight);
        g2d.drawLine(startX + mouthWidth, startY + mouthHeight, startX + mouthWidth * 3, startY + mouthHeight + bodyHeight);
        g2d.drawLine(startX - mouthWidth * 2, startY + mouthHeight + bodyHeight, startX + mouthWidth * 3, startY + mouthHeight + bodyHeight);
    }

    void drawLiquid(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

//        int startX = (getWidth() - (mouthWidth / 2), startY = 30;

        // draw GeneralPath (polyline)
        int xPoints[] = {startX, startX, startX - mouthWidth * 2, startX + mouthWidth * 3, startX + mouthWidth, startX + mouthWidth};
        int yPoints[] = {startY, startY + mouthHeight, startY + mouthHeight + bodyHeight, startY + mouthHeight + bodyHeight, startY + mouthHeight, startY};
        GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);

        polygon.moveTo(xPoints[0], yPoints[0]);

        for (int index = 1; index < xPoints.length; index++) {
            polygon.lineTo(xPoints[index], yPoints[index]);
        }
        polygon.closePath();
        g2d.draw(polygon);


        g2d.setColor(new Color(154, 44, 34));
        g2d.fill(polygon);

        g2d.drawImage(ballImage, currentBall.getX(), currentBall.getY(),currentBall.getWidth(),currentBall.getHeight(), this); //Draws the ball Image at the correct X and Y co-ordinates.
        Toolkit.getDefaultToolkit().sync(); // necessary for linux users to draw  and animate image correctly
        g.dispose();

    }
    void drawLiquid2(Graphics g){

        Graphics2D g2d=(Graphics2D) g;

        g2d.setColor(new Color(74,146,23));
        g2d.fillRect(currentLiquidTemp.getCodX(), currentLiquidTemp.getCodY(), currentLiquidTemp.getWidth(), currentLiquidTemp.getHeight());
        Toolkit.getDefaultToolkit().sync(); // necessary for linux users to draw  and animate image correctly
        //g.dispose();
    }

    void drawLiquid3(Graphics g){

        Graphics2D g2d=(Graphics2D) g;

        // draw GeneralPath (polyline)
        int xPoints[] = {cl.getP1(0), cl.getP2(0), cl.getP3(0),cl.getP4(0),cl.getP5(0),cl.getP6(0)};
        int yPoints[] = {cl.getP1(1), cl.getP2(1), cl.getP3(1),cl.getP4(1),cl.getP5(1),cl.getP6(1)};
        GeneralPath liquidShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);

        liquidShape.moveTo(xPoints[0], yPoints[0]);

        for (int index = 1; index < xPoints.length; index++) {
            liquidShape.lineTo(xPoints[index], yPoints[index]);
        }
        liquidShape.closePath();
        g2d.draw(liquidShape);
        Toolkit.getDefaultToolkit().sync();

        g2d.setColor(new Color(203, 19, 14));
        g2d.fill(liquidShape);

        g.dispose();

    }

/*    void drawRectangle(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // draw GeneralPath (polygon)
        int x2Points[] = {startXRect,startXRect,startXRect+widthRect,startXRect+widthRect};
        int y2Points[] = {startYRect,startYRect+heightRect,startYRect+heightRect,startYRect};

        GeneralPath myRect = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x2Points.length);
        myRect.moveTo(x2Points[0],y2Points[0]);

        for (int index = 1; index < x2Points.length; index++) {
            myRect.lineTo(x2Points[index], y2Points[index]);
        }
        myRect.closePath();
        g2d.draw(myRect);
        Toolkit.getDefaultToolkit().sync();

        g2d.setColor(new Color(84, 98, 203));
        g2d.fill(myRect);

        g.dispose();

    }*/


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawFlask(g);
        //drawLiquid2(g);
        drawLiquid3(g);

    }
    @Override
    public void actionPerformed(ActionEvent e){


        int p1x= cl.getP1(0);
        int p1y= cl.getP1(1);
        int p2x= cl.getP2(0);
        int p2y= cl.getP2(1);
        int p3x= cl.getP3(0);
        int p3y= cl.getP3(1);
        int p4x= cl.getP4(0);
        int p4y= cl.getP4(1);
        int p5x= cl.getP5(0);
        int p5y= cl.getP5(1);
        int p6x= cl.getP6(0);
        int p6y= cl.getP6(1);

        int liguidHeight=p1y-p3y;

        cl.setP1(p1x,p1y-liquidFillRate);
        cl.setP6(p6x,p6y-liquidFillRate);
        repaint();
    }

/*    @Override
    public void actionPerformed(ActionEvent e){

        int currentHeight= currentLiquidTemp.getHeight();
        if(currentHeight>300){
            filled=true;
        }
        else if(currentHeight<0){
            filled=false;
        }
        if(filled){
            liquidFillRate=-5;
        }
        else{
            liquidFillRate=5;
        }

        currentLiquidTemp.setCodY(currentLiquidTemp.getCodY()-liquidFillRate);
        currentLiquidTemp.setHeight(currentLiquidTemp.getHeight()+liquidFillRate);
        repaint();
    }*/

/*    @Override
    public void actionPerformed(ActionEvent e) {
        // set X and Y co-ordinates that will then be fetched when drawing
        // the ball Image on the JPanel.
        int bX=currentBall.getWidth();
        int bY=currentBall.getHeight();
        int currentFrameWidth=getWidth();
        int currentFrameHeight=getHeight();

        if((bX<0)||(bX>currentFrameWidth-50)){
            velX=-velX;
        }
        if((bY<0)||(bY>currentFrameHeight-50)){
            velY=-velY;
        }
        currentBall.setWidth(currentBall.getWidth() + velX);
        currentBall.setHeight(currentBall.getHeight() + velY);
        repaint();
    }*/
}
