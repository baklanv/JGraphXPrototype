package task;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import javax.swing.*;

public class task6 extends JFrame{
    public static void main(String[] args)
    {
        task6 frame = new task6();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
    public task6() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v1 = graph.insertVertex(parent, null, "Hello", 180, 50,
                    50, 50, "shape=triangle;perimeter=trianglePerimeter");
            Object v2 = graph.insertVertex(parent, null, "", 50, 50, 60, 30,
                    "shape=ellipse;perimeter=ellipsePerimeter");
            Object v3 = graph.insertVertex(parent, null, "", 180, 180, 60, 30,
                    "shape=rhombus;perimeter=rhombusPerimeter");
            Object v4 = graph.insertVertex(parent, null, "", 50, 100, 60, 30,
                    "shape=hexagon;perimeter=hexagonPerimeter");
            graph.insertEdge(parent, null, "", v1, v2);
            graph.insertEdge(parent, null, "", v1, v3);
            graph.insertEdge(parent, null, "", v1, v4);


        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);

    }
}
