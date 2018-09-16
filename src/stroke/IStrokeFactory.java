package stroke;

import java.awt.*;

public interface IStrokeFactory {
    BasicStroke createStroke(StrokeType strokeType);
}
