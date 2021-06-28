package myPerimeter;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxPerimeter;

public class UnaryTop implements mxPerimeter.mxPerimeterFunction {
    @Override
    public mxPoint apply(mxRectangle bounds, mxCellState vertex, mxPoint next, boolean orthogonal) {
        double cx = bounds.getCenterX();
        double cy = bounds.getCenterY();
        double dx = next.getX() - cx;
        double dy = next.getY() - cy;
        double alpha = Math.atan2(dy, dx);

        mxPoint p = new mxPoint();

        // Left edge
        p.setX(cx);
        p.setY(cy - bounds.getHeight() / 2);//-3 благодаря 3 все привязки идут к краю, если будет фиксированное число будет проще)))

        //mxCell v = (mxCell)vertex.getCell();
        //mxCell e = (mxCell)v.getEdgeAt(0);
        //e.getVertex();
        return p;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
