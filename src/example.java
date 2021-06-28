import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStyleRegistry;
import myPerimeter.UnaryBottom;
import myPerimeter.UnaryLeft;
import myPerimeter.UnaryRight;
import myPerimeter.UnaryTop;

import javax.swing.*;
import java.util.Map;

public class example extends JFrame {
    public static void main(String[] args) {
        example frame = new example();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }

    public example() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            mxStyleRegistry.putValue("unaryTopPerimeter", new UnaryTop());
            mxStyleRegistry.putValue("unaryLeftPerimeter", new UnaryLeft());
            mxStyleRegistry.putValue("unaryRightPerimeter", new UnaryRight());
            mxStyleRegistry.putValue("unaryBottomPerimeter", new UnaryBottom());

            Object v1 = graph.insertVertex(parent, "2", "Person", 50, 100,
                    50, 30, "rounded=true;perimeter=ellipsePerimeter;arcSize=30;");
            Object v2 = graph.insertVertex(parent, "2", "Sport", 300, 100,
                    50, 30, "rounded=true;perimeter=ellipsePerimeter;arcSize=30;");
            Object v3 = graph.insertVertex(parent, "2", "SkillLevel", 250, 50,
                    50, 30, "rounded=true;perimeter=ellipsePerimeter;arcSize=30;");

            Object grandParent = graph.insertVertex(parent, null, "", 125, 100, 56, 25, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent = graph.insertVertex(grandParent, null, "", 3, 7, 50, 15, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryBottomPerimeter");
            graph.insertVertex(grandParent, null, "plays", 5, 1, 46, 5, "shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;");
            Object _parent1 = graph.insertVertex(_parent, null, "", 0, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryLeftPerimeter;");
            ((mxCell)grandParent).setConnectable(false);
            Object _parent2 = graph.insertVertex(_parent, null, "", 25, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryRightPerimeter;");

            Object grandParent2 = graph.insertVertex(parent, null, "", 50, 180, 56, 25, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent21 = graph.insertVertex(grandParent2, null, "", 3, 7, 50, 15, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent22 = graph.insertVertex(_parent21, null, "", 0, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryLeftPerimeter;");
            ((mxCell)grandParent).setConnectable(false);
            Object _parent23 = graph.insertVertex(_parent21, null, "", 25, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryRightPerimeter;");
            graph.insertVertex(grandParent2, null, "is by", 30, 1, 21, 5, "shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;");

            Object grandParent3 = graph.insertVertex(parent, null, "", 150, 50, 56, 25, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            graph.insertVertex(grandParent3, null, "is at", 5, 1, 21, 5, "shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;");
            Object _parent31 = graph.insertVertex(grandParent3, null, "", 3, 7, 50, 15, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent32 = graph.insertVertex(_parent31, null, "", 0, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryLeftPerimeter;");
            ((mxCell)grandParent).setConnectable(false);
            Object _parent33 = graph.insertVertex(_parent31, null, "", 25, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryRightPerimeter;");

            Object grandParent4 = graph.insertVertex(parent, null, "", 250, 180, 56, 25, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            graph.insertVertex(grandParent4, null, "is of", 5, 1, 46, 5, "opacity=0;shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;");
            graph.insertVertex(grandParent4, null, "", 5, 1, 21, 5, "shape=line;;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;");
            Object _parent41 = graph.insertVertex(grandParent4, null, "", 3, 7, 50, 15, "opacity=0;foldable=false;verticalLabelPosition=top;resizable=false;connectable=false;perimeter=unaryTopPerimeter");
            Object _parent42 = graph.insertVertex(_parent41, null, "", 0, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryLeftPerimeter;");
            ((mxCell)grandParent).setConnectable(false);
            Object _parent43 = graph.insertVertex(_parent41, null, "", 25, 0, 25, 15, "editable=0;deletable=false;verticalLabelPosition=top;movable=false;resizable=false;perimeter=unaryRightPerimeter;");


            graph.insertEdge(parent, null, "", v1, _parent1, "endArrow=");
            graph.insertEdge(parent, null, "", v1, _parent22, "endArrow=");
            graph.insertEdge(parent, null, "", v3, _parent33, "endArrow=");
            graph.insertEdge(parent, null, "", v2, _parent2, "endArrow=");
            graph.insertEdge(parent, null, "", v2, _parent43, "endArrow=");
            graph.insertEdge(parent, null, "", _parent23, _parent, "endArrow=");
            graph.insertEdge(parent, null, "", _parent, _parent42, "endArrow=");
            graph.insertEdge(parent, null, "", _parent, _parent32, "endArrow=");


        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);
    }
}
