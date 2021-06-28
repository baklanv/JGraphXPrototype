package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStyleRegistry;
import myPerimeter.LinePerimeter;
import myPerimeter.UnaryTop;

import javax.swing.*;

public class task4 extends JFrame {

    public task4(){
        //регистрация новой формы и нового периметра
        mxStyleRegistry.putValue("linePerimeter", new LinePerimeter());
        mxStyleRegistry.putValue("unaryTopPerimeter", new UnaryTop());
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object grandParent = graph.insertVertex(parent, null, "", 30, 30, 56, 25, "editable=0;opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;foldable=false;");
            Object v1 = graph.insertVertex(grandParent, null, "Hello", 5, 1, 46, 5, "shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;=false;foldable=false;");
            Object v2 = graph.insertVertex(grandParent, null, "", 2, 8, 52, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;connector=false;");
            ((mxCell)grandParent).setConnectable(false);
            ((mxCell)v1).setConnectable(false);
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
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
        task4 frame = new task4();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}