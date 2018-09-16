import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel{

    private int flaskHeight=500;
    private int flaskWidth=200;

    private int startX = 200;
    private int startY = 600;

    private boolean isFill=false;

    BufferedImage liquidImg;
    TexturePaint liquidTexture;

    Flask flask;
    Liquid liquid;

    Timer fillTimer = new Timer(40, e -> performFill());

    Timer drainTimer = new Timer(40, e -> performDrain());

    public int liquidFillRate = 2;

    DrawPanel() {

        setDoubleBuffered(true);
        loadImages();

        flask=new Flask(flaskHeight,flaskWidth,startX,startY);
        liquid=new Liquid(flask);

    }

    public void startFill(boolean isFill) {
        this.isFill=isFill;
        fillTimer.start();
    }
    public void stopFill(boolean isFill){
        this.isFill=isFill;
        fillTimer.stop();
    }
    public void startDrain(boolean isFill){
        this.isFill=isFill;
        drainTimer.start();
    }
    public void stopDrain(boolean isFill){
        this.isFill=isFill;
        drainTimer.stop();
    }

    private void loadImages() {

        try {

            liquidImg = ImageIO.read(new File("./resources/liquid_texture.jpg"));

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,"Could not load images", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }


    void drawFlask(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke bStroke1 = new BasicStroke(7, BasicStroke.CAP_ROUND,BasicStroke.CAP_ROUND);
        g2d.setStroke(bStroke1);

        //Draw Bottom Line
        g2d.drawLine(flask.p3.getCordX(),flask.p3.getCordY(),flask.p4.getCordX(),flask.p4.getCordY());

        //Draw 2 side lines of the body
        g2d.drawLine(flask.p3.getCordX(),flask.p3.getCordY(),flask.p2.getCordX(),flask.p2.getCordY());
        g2d.drawLine(flask.p4.getCordX(),flask.p4.getCordY(),flask.p5.getCordX(),flask.p5.getCordY());

        //Draw 2 side lines of the mouth
        g2d.drawLine(flask.p2.getCordX(),flask.p2.getCordY(),flask.p1.getCordX(),flask.p1.getCordY());
        g2d.drawLine(flask.p5.getCordX(),flask.p5.getCordY(),flask.p6.getCordX(),flask.p6.getCordY());

    }


    void drawLiquid(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int xPoints[] = {liquid.p1.getCordX(), liquid.p2.getCordX(), liquid.p3.getCordX(), liquid.p4.getCordX(), liquid.p5.getCordX(), liquid.p6.getCordX()};
        int yPoints[] = {liquid.p1.getCordY(), liquid.p2.getCordY(), liquid.p3.getCordY(), liquid.p4.getCordY(), liquid.p5.getCordY(), liquid.p6.getCordY()};

        //Draw the Path of the Liquid
        GeneralPath liquidShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
        liquidShape.moveTo(xPoints[0], yPoints[0]);
        for (int index = 1; index < xPoints.length; index++) {
            liquidShape.lineTo(xPoints[index], yPoints[index]);
        }
        liquidShape.closePath();

        //Draw Liquid Outline
        BasicStroke bStroke2 = new BasicStroke(2, BasicStroke.CAP_ROUND,BasicStroke.CAP_ROUND);
        g2d.setStroke(bStroke2);

        g2d.draw(liquidShape);
        Toolkit.getDefaultToolkit().sync();

        //Draw Liquid Color
        liquidTexture = new TexturePaint(liquidImg, new Rectangle(0, 0, 250, 500));
        g2d.setPaint(liquidTexture);
        g2d.fill(liquidShape);

        g.dispose();

        /*
        // draw GeneralPath (polyline)
        int xPoints[] = {cl.getP1(0), cl.getP2(0), cl.getP3(0), cl.getP4(0), cl.getP5(0), cl.getP6(0)};
        int yPoints[] = {cl.getP1(1), cl.getP2(1), cl.getP3(1), cl.getP4(1), cl.getP5(1), cl.getP6(1)};
        GeneralPath liquidShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);

        liquidShape.moveTo(xPoints[0], yPoints[0]);

        for (int index = 1; index < xPoints.length; index++) {
            liquidShape.lineTo(xPoints[index], yPoints[index]);
        }
        liquidShape.closePath();

        BasicStroke bStroke2 = new BasicStroke(2, BasicStroke.CAP_ROUND,BasicStroke.CAP_ROUND);
        g2d.setStroke(bStroke2);

        g2d.draw(liquidShape);
        Toolkit.getDefaultToolkit().sync();

        liquidTexture = new TexturePaint(liquidImg, new Rectangle(0, 0, 250, 500));

        //g2d.setColor(new Color(34, 32, 166));
        g2d.setPaint(liquidTexture);
        g2d.fill(liquidShape);

        g.dispose();

        */

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawFlask(g);
        drawLiquid(g);

    }

    public void performFill(){

/*      int p1x = cl.getP1(0);
        int p1y = cl.getP1(1);
        int p2x = cl.getP2(0);
        int p2y = cl.getP2(1);
        int p3x = cl.getP3(0);
        int p3y = cl.getP3(1);
        int p4x = cl.getP4(0);
        int p4y = cl.getP4(1);
        int p5x = cl.getP5(0);
        int p5y = cl.getP5(1);
        int p6x = cl.getP6(0);
        int p6y = cl.getP6(1);*/

        int liquidHeight = liquid.p3.getCordY() - liquid.p1.getCordY();
        //int bodyHeight = p3y - p2y;

        int tempAngleRate = 1;

        liquidFillRate = 2;

        if (liquidHeight > flaskHeight+40) {
            liquidFillRate = 0;
        }

            if (liquidHeight < flask.getBodyHeight()) {
                liquid.p1.setCordX(liquid.p1.getCordX()+tempAngleRate);
                liquid.p1.setCordY(liquid.p1.getCordY()-liquidFillRate);
                liquid.p2.setCordX(liquid.p2.getCordX()+tempAngleRate);
                liquid.p2.setCordY(liquid.p2.getCordY()-liquidFillRate);

                liquid.p5.setCordX(liquid.p5.getCordX()-tempAngleRate);
                liquid.p5.setCordY(liquid.p5.getCordY()-liquidFillRate);
                liquid.p6.setCordX(liquid.p6.getCordX()-tempAngleRate);
                liquid.p6.setCordY(liquid.p6.getCordY()-liquidFillRate);
//                cl.setP1(p1x + tempAngleRate, p1y - liquidFillRate);
//                cl.setP2(p2x + tempAngleRate, p2y - liquidFillRate);
//                cl.setP5(p5x - tempAngleRate, p5y - liquidFillRate);
//                cl.setP6(p6x - tempAngleRate, p6y - liquidFillRate);
            } else {

                liquid.p1.setCordY(liquid.p1.getCordY()-liquidFillRate);
                liquid.p6.setCordY(liquid.p6.getCordY()-liquidFillRate);
//                cl.setP1(p1x, p1y - liquidFillRate);
//                cl.setP6(p6x, p6y - liquidFillRate);
            }

        repaint();
    }

    public void performDrain(){

/*        int p1x = cl.getP1(0);
        int p1y = cl.getP1(1);
        int p2x = cl.getP2(0);
        int p2y = cl.getP2(1);
        int p3x = cl.getP3(0);
        int p3y = cl.getP3(1);
        int p4x = cl.getP4(0);
        int p4y = cl.getP4(1);
        int p5x = cl.getP5(0);
        int p5y = cl.getP5(1);
        int p6x = cl.getP6(0);
        int p6y = cl.getP6(1);*/

        int liquidHeight = liquid.p3.getCordY() - liquid.p1.getCordY();
        //int bodyHeight = p3y - p2y;

        int tempAngleRate = 1;
        liquidFillRate = 2;

        if (liquidHeight <= 0) {
            liquidFillRate = 0;
        }

        if(liquid.p1.getCordY()<liquid.p2.getCordY()) {
            liquid.p1.setCordY(liquid.p1.getCordY()+liquidFillRate);
            liquid.p6.setCordY(liquid.p6.getCordY()+liquidFillRate);
//            cl.setP1(p1x, p1y - liquidFillRate);
//            cl.setP6(p6x, p6y - liquidFillRate);
        }
        else if(liquid.p2.getCordY()<liquid.p3.getCordY()){

            liquid.p1.setCordX(liquid.p1.getCordX()-tempAngleRate);
            liquid.p1.setCordY(liquid.p1.getCordY()+liquidFillRate);
            liquid.p2.setCordX(liquid.p2.getCordX()-tempAngleRate);
            liquid.p2.setCordY(liquid.p2.getCordY()+liquidFillRate);

            liquid.p5.setCordX(liquid.p5.getCordX()+tempAngleRate);
            liquid.p5.setCordY(liquid.p5.getCordY()+liquidFillRate);
            liquid.p6.setCordX(liquid.p6.getCordX()+tempAngleRate);
            liquid.p6.setCordY(liquid.p6.getCordY()+liquidFillRate);
//            cl.setP1(p1x - tempAngleRate, p1y - liquidFillRate);
//            cl.setP2(p2x - tempAngleRate, p2y - liquidFillRate);
//            cl.setP5(p5x + tempAngleRate, p5y - liquidFillRate);
//            cl.setP6(p6x + tempAngleRate, p6y - liquidFillRate);
        }

        repaint();
    }
}
