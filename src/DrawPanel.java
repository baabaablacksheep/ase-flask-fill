import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawPanel extends JPanel{


    int mouthWidth = 30;
    int bodyHeight = 220;
    int mouthHeight = (bodyHeight / 2) * 3;

    int startX = 100;
    int startY = 20;

    boolean isFill=false;

    BufferedImage liquidImg;
    TexturePaint liquidTexture;

    Timer fillTimer = new Timer(40, e -> performFill());

    Timer drainTimer = new Timer(40, e -> performDrain());

    public int liquidFillRate = 2;
    Liquid cl = new Liquid(100, 70, 50, 200);

    DrawPanel() {

        this.startX = 100;
        this.startY = 10;

        setDoubleBuffered(true);

        loadImages();


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

        int fP3X=cl.getP3(0);
        int fP3Y=cl.getP3(1);
        int fP4X=cl.getP4(0);
        int fP4Y=cl.getP4(1);

        int fP2Y=fP3Y-bodyHeight;
        int fP2X=fP3X+bodyHeight/2;

        int fP5Y=fP4Y-bodyHeight;
        int fP5X=fP4X-bodyHeight/2;

        int fP1X=fP2X;
        int fP1Y=fP2Y-mouthHeight;

        int fP6X=fP5X;
        int fP6Y=fP5Y-mouthHeight;

        BasicStroke bStroke1 = new BasicStroke(7, BasicStroke.CAP_ROUND,BasicStroke.CAP_ROUND);

        g2d.setStroke(bStroke1);

        g2d.drawLine(fP3X-3,fP3Y+3,fP4X+3,fP4Y+3);
        g2d.drawLine(fP3X-3,fP3Y,fP2X-3,fP2Y);
        g2d.drawLine(fP4X+3,fP4Y,fP5X+3,fP5Y);
        g2d.drawLine(fP2X-4,fP2Y,fP1X-4,fP1Y-4);
        g2d.drawLine(fP5X+3,fP5Y,fP6X+3,fP6Y-4);
    }


    void drawLiquid(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

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

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawFlask(g);
        drawLiquid(g);

    }

    public void performFill(){

        int p1x = cl.getP1(0);
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
        int p6y = cl.getP6(1);

        int liquidHeight = p3y - p1y;
        //int bodyHeight = p3y - p2y;

        int tempAngleRate = 1;

        liquidFillRate = 2;

        if (liquidHeight > bodyHeight+mouthHeight) {
            liquidFillRate = 0;
        }

            if (liquidHeight < bodyHeight) {
                cl.setP1(p1x + tempAngleRate, p1y - liquidFillRate);
                cl.setP2(p2x + tempAngleRate, p2y - liquidFillRate);
                cl.setP5(p5x - tempAngleRate, p5y - liquidFillRate);
                cl.setP6(p6x - tempAngleRate, p6y - liquidFillRate);
            } else {
                cl.setP1(p1x, p1y - liquidFillRate);
                cl.setP6(p6x, p6y - liquidFillRate);
            }

        repaint();
    }

    public void performDrain(){

        int p1x = cl.getP1(0);
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
        int p6y = cl.getP6(1);

        int liquidHeight = p3y - p1y;
        //int bodyHeight = p3y - p2y;

        int tempAngleRate = 1;

        liquidFillRate = -2;

        if (liquidHeight <= 0) {
            liquidFillRate = 0;
        }

        if(cl.getP1(1)<cl.getP2(1)) {
            cl.setP1(p1x, p1y - liquidFillRate);
            cl.setP6(p6x, p6y - liquidFillRate);
        }
        else if(cl.getP2(1)<cl.getP3(1)){
            cl.setP1(p1x - tempAngleRate, p1y - liquidFillRate);
            cl.setP2(p2x - tempAngleRate, p2y - liquidFillRate);
            cl.setP5(p5x + tempAngleRate, p5y - liquidFillRate);
            cl.setP6(p6x + tempAngleRate, p6y - liquidFillRate);
        }

        repaint();
    }
}
