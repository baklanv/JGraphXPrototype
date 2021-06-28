package task;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxMultiplicity;

import javax.swing.*;
import java.util.Collection;

public class ORM_mxMultiplicity extends mxMultiplicity {

    public ORM_mxMultiplicity() {
        super(true, null, null, null, 0, null, null, null, "", false);
    }


    @Override
    public String check(mxGraph graph, Object edge, Object source,
                        Object target, int sourceOut, int targetIn) {

        String result = "";

        if ( source != null && target != null) {
            if (((mxCell)source).getId() == "2" && ((mxCell)target).getId() == "4"){
                //result = "Соединены узлы " + ((mxCell)source).getValue() + " и " + ((mxCell)target).getValue();
            }
            else {
                graph.removeCells(new Object[]{edge});
                result = "Невозможно соединить узлы";
            }
        }

        return result;
    }
}
