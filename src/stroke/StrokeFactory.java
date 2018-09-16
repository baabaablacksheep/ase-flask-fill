package stroke;

import java.awt.*;

public class StrokeFactory implements IStrokeFactory {

    @Override
    public BasicStroke createStroke(StrokeType strokeType) {
        switch(strokeType){
            case FlaskStroke:return new FlaskStroke().getStroke();
            case LiquidStroke:return new LiquidStroke().getStroke();
            default:return null;
        }
    }
}
