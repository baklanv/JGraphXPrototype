package task;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

public class task9 extends JFrame{
    public static void main(String[] args)
    {
        task9 frame = new task9();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
    public task9() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        ORM_mxMultiplicity[] mxMultiplicity = new ORM_mxMultiplicity[1];

        mxMultiplicity[0] = new ORM_mxMultiplicity();

        graph.setMultiplicities(mxMultiplicity);

        graph.getModel().beginUpdate();
        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v1 = graph.insertVertex(parent, "2", "Hello", 50, 50,
                    50, 30, "shape=ellipse;perimeter=ellipsePerimeter");
            Object v2 = graph.insertVertex(parent, "3", "World", 80, 100,
                    50, 30, "shape=ellipse;perimeter=ellipsePerimeter");
            Object v3 = graph.insertVertex(parent, "4", "World", 180, 50,
                    50, 30, "");

        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);
    }
}
