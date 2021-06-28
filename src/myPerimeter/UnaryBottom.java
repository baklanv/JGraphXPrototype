package myPerimeter;

        import com.mxgraph.util.mxPoint;
        import com.mxgraph.util.mxRectangle;
        import com.mxgraph.view.mxCellState;
        import com.mxgraph.view.mxPerimeter;

public class UnaryBottom implements mxPerimeter.mxPerimeterFunction {
    @Override
    public mxPoint apply(mxRectangle bounds, mxCellState vertex, mxPoint next, boolean orthogonal) {
        double cx = bounds.getCenterX();
        double cy = bounds.getCenterY();
        double dx = next.getX() - cx;
        double dy = next.getY() - cy;
        double alpha = Math.atan2(dy, dx);

        double b1 = next.getX();
        double b2 = next.getY();
        mxPoint p = new mxPoint();


        if (cx > next.getX()){
            p.setX(cx - bounds.getWidth() / 4 );
            p.setY((cy + bounds.getHeight() / 2));
        }
        else if (cx < next.getX()){
            p.setX(cx + bounds.getWidth() / 4 );
            p.setY((cy + bounds.getHeight() / 2));
        }
        else {
            p.setX(cx);
            p.setY(cy - bounds.getHeight() / 2);
        }
        // Left edge
        //p.setX(cx - bounds.getWidth() / 4 );
        //p.setY((cy + bounds.getHeight() / 2));//-3 благодаря 3 все привязки идут к краю, если будет фиксированное число будет проще)))

        //mxCell v = (mxCell)vertex.getCell();
        //mxCell e = (mxCell)v.getEdgeAt(0);
        //e.getVertex();
        return p;
    }

}
