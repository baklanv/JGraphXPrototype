package task;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStyleRegistry;
import myPerimeter.UnaryTop;

import javax.swing.*;

public class task11 extends JFrame {
    public static void main(String[] args)
    {
        task11 frame = new task11();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
    public task11() {
        mxStyleRegistry.putValue("unaryTopPerimeter", new UnaryTop());
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            var v1 = graph.insertVertex(parent, null, "v1", 20, 20, 80, 30, "shape=ellipse;perimeter=ellipsePerimeter;labelBackgroundColor=#ffffff;indicatorDirection=south;align=right;fontStyle=0;");
            var v2 = graph.insertVertex(parent, null, "v2", 440, 20, 80, 30);
            var e1 = graph.insertEdge(parent, null, "", v1, v2,
                    "dashed=1;startArrow=oval;endArrow=block;sourcePerimeterSpacing=4;startFill=0;endFill=0;");
            var e11 = graph.insertVertex(e1, null, "Label", 0, 0, 20, 14,
                    "shape=message;labelBackgroundColor=#ffffff;labelPosition=left;spacingRight=2;align=right;fontStyle=0;");

            var v3 = graph.insertVertex(parent, null, "v3", 20, 120, 80, 30);
            var v4 = graph.insertVertex(parent, null, "v4", 440, 120, 80, 30);
            var e2 = graph.insertEdge(parent, null, "Label", v3, v4,
                    "startArrow=dash;startSize=12;endArrow=block;labelBackgroundColor=#FFFFFF;");

            var v5 = graph.insertVertex(parent, null, "v5", 40, 220, 40, 40, "shape=ellipse;perimeter=ellipsePerimeter;");
            var v6 = graph.insertVertex(parent, null, "v6", 460, 220, 40, 40, "shape=doubleEllipse;perimeter=ellipsePerimeter;");
            var e3 = graph.insertEdge(parent, null, "Link", v5, v6,
                    "shape=link;labelBackgroundColor=#FFFFFF;");
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);

    }
}
