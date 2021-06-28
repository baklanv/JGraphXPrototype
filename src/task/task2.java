package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.*;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;

import javax.swing.*;

public class task2 extends JFrame {
    public static void main(String[] args) {
        task2 frame = new task2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }

    public task2() {

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v1 = graph.insertVertex(parent, null, "1", 50, 80,
                    50, 50, "rounded=true;arcSize=50;resizable=false");
            Object v2 = graph.insertVertex(parent, null, "2", 240, 150,
                    80, 30, "rounded=true;");
            graph.insertEdge(parent, null, "3", v1, v2);

        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        graph.getSelectionModel().addListener(mxEvent.CHANGE, (sender, evt) -> {
            mxGraphSelectionModel sm = (mxGraphSelectionModel) sender;
            mxCell cell = (mxCell) sm.getCell();
            if (cell != null && cell.isVertex()) {
                System.out.println("select vertex with value " + cell.getValue().toString());
            }
            else if (cell != null && cell.isEdge()) {
                System.out.println("select egle with value " + cell.getValue().toString());
            }
        });
    }
}
