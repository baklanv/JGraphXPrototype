package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;

import javax.swing.*;

public class task1 extends JFrame
{
    public task1 ()
    {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v1 = graph.insertVertex(parent, null, "v1", 50, 80,
                    50, 50, "arcSize=50;");
            Object v2 = graph.insertVertex(parent, null, "v2", 240, 150,
                    80, 30, "rounded=true;");
            Object v3 = graph.insertVertex(parent, null, "v3", 240, 80,
                    80, 30, "rounded=true;");
            graph.insertEdge(parent, null, "e1", v1, v2, "startArrow=false;endArrow=false");

        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        graph.addListener(mxEvent.CONNECT_CELL, (sender, evt) -> {
            mxGraph sm = (mxGraph) sender;
            mxCell cell = (mxCell) sm.getSelectionModel().getCell();
            if (cell != null && cell.getSource() != null && cell.getTarget() != null && cell.isEdge()) {
                System.out.println("redirection edge with value '" + cell.getValue().toString()
                        + "' source is '" + cell.getSource().getValue().toString()
                        + "' target is '" + cell.getTarget().getValue().toString() + "'");
            }
        });

        graph.getSelectionModel().addListener(mxEvent.CHANGE, (sender, evt) -> {
            mxGraphSelectionModel sm = (mxGraphSelectionModel) sender;
            mxCell cell = (mxCell) sm.getCell();
            if (cell != null && cell.isVertex()) {
                System.out.println("select vertex with value '" + cell.getValue().toString() + "'");
            }
            else if (cell != null && cell.isEdge()) {
                System.out.println("select edge with value '" + cell.getValue().toString() + "'");
            }
        });
    }

    public static void main(String[] args)
    {
        task1 frame = new task1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}

