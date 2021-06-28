package task;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStyleRegistry;
import myPerimeter.UnaryTop;

import javax.swing.*;

public class task7 extends JFrame{
    public static void main(String[] args)
    {
        task7 frame = new task7();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
    public task7() {
        mxStyleRegistry.putValue("unaryTopPerimeter", new UnaryTop());
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            Object v3 = graph.insertVertex(parent, null, "Hello", 180, 50,
                    50, 50, "rounded=true;arcSize=50;");
            Object grandParent = graph.insertVertex(parent, null, "", 50, 180, 56, 21, "foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent = graph.insertVertex(grandParent, null, "", 3, 3, 50, 15, "foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object v1 = graph.insertVertex(_parent, null, "", 0, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryTopPerimeter;");
            //((mxCell)grandParent).setConnectable(false);
            boolean result = graph.isCellEditable(v1);
            System.out.println(result);
            Object v2 = graph.insertVertex(_parent, null, "", 25, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryTopPerimeter;");

            graph.insertEdge(parent, null, "", v3, _parent, "startArrow=arrowConnector");

        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);

    }
}
