package myPerimeter;

        import com.mxgraph.util.mxPoint;
        import com.mxgraph.util.mxRectangle;
        import com.mxgraph.view.mxCellState;
        import com.mxgraph.view.mxPerimeter;

public class UnaryLeft implements mxPerimeter.mxPerimeterFunction {
    @Override
    public mxPoint apply(mxRectangle bounds, mxCellState vertex, mxPoint next, boolean orthogonal) {
        double cx = bounds.getCenterX();
        double cy = bounds.getCenterY();
        double dx = next.getX() - cx;
        double dy = next.getY() - cy;
        double alpha = Math.atan2(dy, dx);

        mxPoint p = new mxPoint();

        // Left edge
        p.setX(cx - bounds.getWidth() / 2);
        p.setY(cy);//-3 благодаря 3 все привязки идут к краю, если будет фиксированное число будет проще)))

        //mxCell v = (mxCell)vertex.getCell();
        //mxCell e = (mxCell)v.getEdgeAt(0);
        //e.getVertex();
        return p;
    }

}
