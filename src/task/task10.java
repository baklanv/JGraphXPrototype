package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphSelectionModel;
import com.mxgraph.view.mxStyleRegistry;
import myPerimeter.UnaryTop;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Stack;

public class task10 extends JFrame {
    public static void main(String[] args)
    {
        task10 frame = new task10();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }
    public task10() {
        Stack stack = new Stack();
        mxStyleRegistry.putValue("unaryTopPerimeter", new UnaryTop());
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            graph.getStylesheet().getDefaultEdgeStyle().put("movable", false);

            Object grand = graph.insertVertex(parent, null, "", 190,20,50,50, "shape=ellipse;perimeter=ellipsePerimeter");
            Object _parent = graph.insertVertex(parent, null, "", 0,0, 25, 25, "fillColor=green");
            Object v4 = graph.insertVertex(parent, null, "", 300,80, 25, 25, "fillColor=lightgreen");
            Object v5 = graph.insertVertex(parent, null, "", 120,130, 25, 25, "fillColor=lightgreen");

            Object e1 = graph.insertEdge(parent, null, "", v5, v4, "dashed=1;endArrow=false;");
            Object e2 = graph.insertEdge(parent, null, "", e1, _parent, "dashed=1;endArrow=false;");
            Object e3 = graph.insertEdge(parent, null, "", grand, e1, "dashed=1;endArrow=false;");

        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        getContentPane().add(graphComponent);

        graph.getSelectionModel().addListener(mxEvent.CHANGE, (sender, evt) -> {
            mxGraphSelectionModel sm = (mxGraphSelectionModel) sender;
            mxCell cell = (mxCell) sm.getCell();
            mxCell vertex;
            if (cell != null && cell.isVertex()) {
                if (!stack.empty()) {
                    stack.clear();
                }

                stack.push(cell);
                stack.push("ok_1");
            }
            else if (cell != null && cell.isEdge()) {
                if (!stack.empty())
                    if ("ok_2" == stack.pop()) {
                        vertex = (mxCell) stack.pop();
                        graph.insertEdge(parent, null, "New edge", vertex, cell, "dashed=1;endArrow=false;");
                    }
            }
        });
        graphComponent.addKeyListener(new KeyAdapter(){//регестрируем KeyListener
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_C){//Если нажата кнопка C
                    if (!stack.empty())
                        if ("ok_1" == stack.pop()) {
                            stack.push("ok_2");
                        }
                        else {
                            stack.clear();
                        }
                }
            }
        });
        graph.addListener(mxEvent.CELL_CONNECTED, (sender, evt) -> {
            System.out.println("Yes");
            Map<String, Object> properties = evt.getProperties();
            Object edge = properties.get("edge");
            Map<String, Object> properties2 = evt.getProperties();
            Object vertex = properties.get("vertex");
            System.out.println(edge);
            System.out.println(vertex);
        });
    }
}
