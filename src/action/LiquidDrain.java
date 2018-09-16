package action;

import liquid.Liquid;
import panels.CenterPanel;

public class LiquidDrain extends CenterPanel implements Runnable {

    private CenterPanel panel;
    private Liquid liquid;
    private boolean isEmpty;

    private int liquidFillRate;
    private int angleRate;

    public LiquidDrain(CenterPanel panel) {
        this.panel=panel;
        this.flask=panel.flask;
        this.liquid=panel.liquid;
        this.isEmpty=panel.isEmpty;
        this.liquidFillRate=panel.liquidFillRate;
        this.angleRate=panel.angleRate;
    }

    @Override
    public void run() {
        int liquidHeight = liquid.p3.getCordY() - liquid.p1.getCordY();

        panel.isFilled = false;

        if (liquidHeight <= 0) {
            isEmpty = true;
        }

        if (!isEmpty) {

            if (liquid.p1.getCordY() < liquid.p2.getCordY()) {
                liquid.p1.setCordY(liquid.p1.getCordY() + liquidFillRate);
                liquid.p6.setCordY(liquid.p6.getCordY() + liquidFillRate);
            } else if (liquid.p2.getCordY() < liquid.p3.getCordY()) {

                liquid.p1.setCordX(liquid.p1.getCordX() - angleRate);
                liquid.p1.setCordY(liquid.p1.getCordY() + liquidFillRate);
                liquid.p2.setCordX(liquid.p2.getCordX() - angleRate);
                liquid.p2.setCordY(liquid.p2.getCordY() + liquidFillRate);

                liquid.p5.setCordX(liquid.p5.getCordX() + angleRate);
                liquid.p5.setCordY(liquid.p5.getCordY() + liquidFillRate);
                liquid.p6.setCordX(liquid.p6.getCordX() + angleRate);
                liquid.p6.setCordY(liquid.p6.getCordY() + liquidFillRate);

            }
        }

        repaint();
    }
}
