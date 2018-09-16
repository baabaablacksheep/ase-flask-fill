package liquid;

import java.awt.geom.GeneralPath;

public class LiquidShape {

    private GeneralPath liquidShape;

    private int xPoints[];
    private int yPoints[];

    public LiquidShape(Liquid liquid) {

        xPoints = new int[]{liquid.p1.getCordX(), liquid.p2.getCordX(), liquid.p3.getCordX(), liquid.p4.getCordX(), liquid.p5.getCordX(), liquid.p6.getCordX()};
        yPoints = new int[]{liquid.p1.getCordY(), liquid.p2.getCordY(), liquid.p3.getCordY(), liquid.p4.getCordY(), liquid.p5.getCordY(), liquid.p6.getCordY()};

        drawLiquidOutLine();

    }

    private void drawLiquidOutLine(){

        //Draw the Path of the liquid.Liquid
        liquidShape = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);

        liquidShape.moveTo(xPoints[0], yPoints[0]);
        for (int index = 1; index < xPoints.length; index++) {
            liquidShape.lineTo(xPoints[index], yPoints[index]);
        }

        liquidShape.closePath();
    }

    public GeneralPath getLiquidShape() {
        return liquidShape;
    }
}
