package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.model.mxICell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;

import javax.swing.*;
import java.util.List;

public class task3 extends JFrame {

    public task3() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();

        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);
            // внутри
            Object v1 = graph.insertVertex(parent, null, "Hello", 50, 30,
                    50, 50, "rounded=true;arcSize=50;autosize=true;resizable=false");
            // снаружи
            Object v4 = graph.insertVertex(parent, null, "Name", 180, 50,
                    80, 30, "rounded=true;;verticalLabelPosition=top;resizable=false");


            // несколько первый вариант
            Object grandParent = graph.insertVertex(parent, null, "Title", 50, 150, 60, 60, "foldable=false;resizable=false;connectable=false");
            Object _parent = graph.insertVertex(grandParent, null, "", 5, 5, 50, 50, "deletable=false;foldable=false;resizable=false;movable=false;opacity=0;");
            Object valueCell = graph.insertVertex(_parent, null, "Value", 0, 0, 50, 25, "movable=false;opacity=0;resizable=false");
            Object labelCell = graph.insertVertex(_parent, null, "Label", 0, 25, 50, 25, "movable=false;opacity=0;resizable=false");

            ((mxCell)_parent).setConnectable(false);
            ((mxCell)valueCell).setConnectable(false);
            ((mxCell)labelCell).setConnectable(false);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);

        graph.getSelectionModel().addListener(mxEvent.CHANGE, (sender, evt) -> {
            mxGraphSelectionModel sm = (mxGraphSelectionModel) sender;
            mxCell cell = (mxCell) sm.getCell();
            System.out.println(evt.getProperties().keySet());
            var ujj = (evt.getProperties().get("added"));
            List<mxCell> arr = ((List<mxCell>) ujj);
            if (!arr.isEmpty() && cell == null) {
                mxCell arr1 = ((List<mxCell>) ujj).get(0);
                System.out.println("renamed a cell with the old name '" + arr1.getValue() + "'");
            }
        });
    }

    public static void main(String[] args) {
        task3 frame = new task3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
}
