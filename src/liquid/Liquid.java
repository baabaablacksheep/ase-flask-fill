package liquid;

import flask.Container;
import flask.Flask;

public class Liquid extends Container {

    public Liquid(Flask flask) {

        setPoint(3,flask.getBaseStartPointX(),flask.getBaseStartPointY());
        setPoint(4,p3.getCordX()+flask.getFlaskWidth(),p3.getCordY());

        setPoint(1,p3.getCordX(),p3.getCordY());
        setPoint(2,p3.getCordX(),p3.getCordY());

        setPoint(5,p4.getCordX(),p4.getCordY());
        setPoint(6,p4.getCordX(),p4.getCordY());

    }
}
