package panels;

import action.LiquidDrain;
import action.LiquidFill;
import flask.Flask;
import liquid.Liquid;
import liquid.LiquidShape;
import liquid.LiquidTexture;
import stroke.StrokeFactory;
import stroke.StrokeType;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;


public class CenterPanel extends JPanel {

    protected int flaskHeight = 500;
    private int flaskWidth = 200;

    private int startX = 200;
    private int startY = 600;

    public final int angleRate = 1;
    public final int liquidFillRate = 2;
    private final int timerDelay = 5;

    private boolean isFilling = true;

    public boolean isFilled = false;
    public boolean isEmpty = true;

    public Flask flask;
    public Liquid liquid;

    private StrokeFactory strokeFactory;

    private Timer timer = new Timer(timerDelay, e -> {
        if (isFilling) {
            performFill();
        } else {
            performDrain();
        }
    });


    protected CenterPanel() {

        setDoubleBuffered(true);

        flask = new Flask(flaskHeight, flaskWidth, startX, startY);
        liquid = new Liquid(flask);

        strokeFactory = new StrokeFactory();

    }

    void startAction(boolean status) {
        this.isFilling = status;
        timer.start();
    }

    void stopAction() {
        timer.stop();
    }

    private void drawFlask(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke flaskStroke = strokeFactory.createStroke(StrokeType.FlaskStroke);
        g2d.setStroke(flaskStroke);

        //Draw Bottom Line
        g2d.drawLine(flask.p3.getCordX() - 3, flask.p3.getCordY() + 3, flask.p4.getCordX() + 3, flask.p4.getCordY() + 3);

        //Draw 2 side lines of the body
        g2d.drawLine(flask.p3.getCordX() - 4, flask.p3.getCordY() + 3, flask.p2.getCordX() - 3, flask.p2.getCordY() - 3);
        g2d.drawLine(flask.p4.getCordX() + 4, flask.p4.getCordY() + 3, flask.p5.getCordX() + 3, flask.p5.getCordY() - 3);

        //Draw 2 side lines of the mouth
        g2d.drawLine(flask.p2.getCordX() - 4, flask.p2.getCordY() - 4, flask.p1.getCordX() - 4, flask.p1.getCordY() - 4);
        g2d.drawLine(flask.p5.getCordX() + 3, flask.p5.getCordY() - 3, flask.p6.getCordX() + 3, flask.p6.getCordY() - 3);

    }

    private void drawLiquid(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        GeneralPath liquidShape = new LiquidShape(liquid).getLiquidShape();

        //Draw liquid.Liquid Outline
        BasicStroke liqStroke = strokeFactory.createStroke(StrokeType.LiquidStroke);
        g2d.setStroke(liqStroke);

        g2d.draw(liquidShape);
        Toolkit.getDefaultToolkit().sync();

        //Draw liquid.Liquid Color
        TexturePaint liquidTexture = new LiquidTexture().getTexture();
        g2d.setPaint(liquidTexture);
        g2d.fill(liquidShape);

        g.dispose();

    }

    private void performFill() {

        new Thread(new LiquidFill(this)).start();
        repaint();

    }

    private void performDrain() {

        new Thread(new LiquidDrain(this)).start();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawFlask(g);
        drawLiquid(g);

    }

}
