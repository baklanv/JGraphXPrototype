package myPerimeter;

import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxPerimeter;

public class LinePerimeter implements mxPerimeter.mxPerimeterFunction{
    @Override
    public mxPoint apply(mxRectangle bounds, mxCellState vertex, mxPoint next, boolean orthogonal) {
        double cx = bounds.getCenterX();
        double cy = bounds.getCenterY();
        double dx = next.getX() - cx;
        double dy = next.getY() - cy;
        double alpha = Math.atan2(dy, dx);

        mxPoint p = new mxPoint();
        double pi = Math.PI;
        double pi2 = Math.PI / 2;
        double beta = pi2 - alpha;
        double t = Math.atan2(bounds.getHeight(), bounds.getWidth());

        if (alpha < -pi + t || alpha > pi - t)
        {
            // Left edge
            p.setX(bounds.getX());
            p.setY(cy - bounds.getWidth() * Math.tan(alpha) / 2 );
        }
        else if (alpha < -t)
        {
            // Top Edge
            p.setY(bounds.getY() + bounds.getHeight() / 2);
            p.setX(cx - bounds.getHeight() * Math.tan(beta) / 2);
        }
        else if (alpha < t)
        {
            // Right Edge
            p.setX(bounds.getX() + bounds.getWidth());
            p.setY(cy + bounds.getWidth() * Math.tan(alpha) / 2);
        }
        else
        {
            // Bottom Edge
            p.setY(bounds.getY() + bounds.getHeight() / 2);
            p.setX(cx + bounds.getHeight() * Math.tan(beta) / 2);
        }
        return p;
    }

    private double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }
}
