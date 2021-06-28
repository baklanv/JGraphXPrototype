package myPerimeter;

import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxPerimeter;

public class myMxPerimeter extends mxPerimeter {


    /**
     * Describes a rectangular perimeter for the given bounds.
     */

    public static mxPerimeterFunction MyEllipsePerimeter = new mxPerimeterFunction()
    {

        /* (non-Javadoc)
         * @see com.mxgraph.view.mxPerimeter.mxPerimeterFunction#apply
         */
        public mxPoint apply(mxRectangle bounds, mxCellState vertex,
                             mxPoint next, boolean orthogonal)
        {
            double x = bounds.getX();
            double y = bounds.getY();
            double a = bounds.getWidth() / 2;
            double b = bounds.getHeight() / 2;
            double cx = x + a;
            double cy = y + b;
            double px = next.getX();
            double py = next.getY();

            // Calculates straight line equation through
            // point and ellipse center y = d * x + h
            double dx = px - cx;
            double dy = py - cy;

            if (dx == 0 && dy != 0)
            {
                return new mxPoint(cx, cy + b * dy / Math.abs(dy));
            }
            else if (dx == 0 && dy == 0)
            {
                return new mxPoint(px, py);
            }

            if (orthogonal)
            {
                if (py >= y && py <= y + bounds.getHeight())
                {
                    double ty = py - cy;
                    double tx = Math.sqrt(a * a * (1 - (ty * ty) / (b * b)));

                    if (Double.isNaN(tx))
                    {
                        tx = 0;
                    }

                    if (px <= x)
                    {
                        tx = -tx;
                    }

                    return new mxPoint(cx + tx, py);
                }

                if (px >= x && px <= x + bounds.getWidth())
                {
                    double tx = px - cx;
                    double ty = Math.sqrt(b * b * (1 - (tx * tx) / (a * a)));

                    if (Double.isNaN(ty))
                    {
                        ty = 0;
                    }

                    if (py <= y)
                    {
                        ty = -ty;
                    }

                    return new mxPoint(px, cy + ty);
                }
            }

            // Calculates intersection
            double d = dy / dx;
            double h = cy - d * cx;
            double e = a * a * d * d + b * b;
            double f = -2 * cx * e;
            double g = a * a * d * d * cx * cx + b * b * cx * cx - a * a * b
                    * b;
            double det = Math.sqrt(f * f - 4 * e * g);

            // Two solutions (perimeter points)
            double xout1 = (-f + det) / (2 * e);
            double xout2 = (-f - det) / (2 * e);
            double yout1 = d * xout1 + h;
            double yout2 = d * xout2 + h;
            double dist1 = Math.sqrt(Math.pow((xout1 - px), 2)
                    + Math.pow((yout1 - py), 2));
            double dist2 = Math.sqrt(Math.pow((xout2 - px), 2)
                    + Math.pow((yout2 - py), 2));

            // Correct solution
            double xout = 0;
            double yout = 0;

            if (dist1 < dist2)
            {
                xout = xout1;
                yout = yout1;
            }
            else
            {
                xout = xout2;
                yout = yout2;
            }

            return new mxPoint(xout, yout);
        }

    };
}
