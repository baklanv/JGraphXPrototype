package task;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;

import javax.swing.*;

public class task5 extends JFrame {

    public task5(){
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try

        {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v1 = graph.insertVertex(parent, null, "Hello", 50, 30,
                    50, 50, "perimeter=ellipsePerimeter;");
            // снаружи
            Object v2 = graph.insertVertex(parent, null, "Name", 180, 50,
                    80, 30, "shape=ellipse;perimeter=ellipsePerimeter;");
            graph.insertEdge(parent, null, "", v1, v2, "startArrow=oval;endArrow=block");
        }
        finally

        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);

        graphComponent.getGraph().addListener(mxEvent.CELLS_ADDED, (sender, evt) -> System.out.println("event add"));

    }
    public static void main(String[] args)
    {
        task5 frame = new task5();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}