import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class DrawPanel extends JPanel {


    int mouthWidth = 30;
    int bodyHeight = 150;
    int mouthHeight = (bodyHeight / 2) * 3;

    int startX = 100;
    int startY = 20;

    public int liquidFillRate = 2;
    Liquid cl = new Liquid(100, 70, 50, 200);

    Timer timer;

    DrawPanel() {

        this.startX = 100;
        this.startY = 10;

        setDoubleBuffered(true);


    }

    public void  buttonClick(boolean isFill){
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDraw();
            }
        });
        timer.start();
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

        // draw GeneralPath (polyline)
        int xPoints[] = {cl.getP1(0), cl.getP2(0), cl.getP3(0), cl.getP4(0), cl.getP5(0), cl.getP6(0)};
        int yPoints[] = {cl.getP1(1), cl.getP2(1), cl.getP3(1), cl.getP4(1), cl.getP5(1), cl.getP6(1)};
        GeneralPath liquidShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);

        liquidShape.moveTo(xPoints[0], yPoints[0]);

        for (int index = 1; index < xPoints.length; index++) {
            liquidShape.lineTo(xPoints[index], yPoints[index]);
        }
        liquidShape.closePath();
        g2d.draw(liquidShape);
        Toolkit.getDefaultToolkit().sync();

        g2d.setColor(new Color(34, 32, 166));
        g2d.fill(liquidShape);

        g.dispose();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawFlask(g);
        drawLiquid(g);
    }

    public void performDraw(){


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
        int bodyHeight = p3y - p2y;

        int tempAngleRate = 1;

        if (liquidHeight > bodyHeight + mouthHeight) {
            liquidFillRate = -2;
        } else if (liquidHeight <= 0) {
            liquidFillRate = 2;
        }

        if (liquidFillRate > 0) {


            if (cl.getP2(0) < cl.getP5(0) - mouthWidth) {
                cl.setP1(p1x + tempAngleRate, p1y - liquidFillRate);
                cl.setP2(p2x + tempAngleRate, p2y - liquidFillRate);
                cl.setP5(p5x - tempAngleRate, p5y - liquidFillRate);
                cl.setP6(p6x - tempAngleRate, p6y - liquidFillRate);
            } else {
                cl.setP1(p1x, p1y - liquidFillRate);
                cl.setP6(p6x, p6y - liquidFillRate);
            }
        }
        else{

            if (cl.getP1(1)==cl.getP2(1)) {
                cl.setP1(p1x - tempAngleRate, p1y - liquidFillRate);
                cl.setP2(p2x - tempAngleRate, p2y - liquidFillRate);
                cl.setP5(p5x + tempAngleRate, p5y - liquidFillRate);
                cl.setP6(p6x + tempAngleRate, p6y - liquidFillRate);
            } else {
                cl.setP1(p1x, p1y - liquidFillRate);
                cl.setP6(p6x, p6y - liquidFillRate);
            }
        }

        repaint();
    }
}
