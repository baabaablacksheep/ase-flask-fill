package stroke;

import java.awt.*;

public class FlaskStroke extends BasicStroke implements IStroke {

    private int strokeWidth=7;
    @Override
    public BasicStroke getStroke() {
        return new BasicStroke(strokeWidth,BasicStroke.CAP_ROUND,BasicStroke.CAP_ROUND);
    }

    @Override
    public void setStokeWidth(int width) {
        this.strokeWidth=width;

    }
}
