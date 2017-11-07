
package sp.code.qbic.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;


public class StrokedShapeSliderUI extends ShapeSliderUI{
    public StrokedShapeSliderUI(){
    }
    public static ComponentUI createUI(JComponent c){
        return new StrokedShapeSliderUI();
    }
    public void paintShape(Graphics2D g, double percent, boolean enabled){
        Shape s = getPrimaryShape();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);

        if(percent>0.0){
            g.setColor(enabled?getPrimaryColor():getSecondaryColor());
            g.fill(s);
            g.setColor(getSecondaryColor());
            g.draw(s);
        }else{
            if(!enabled)
                return;
            g.setColor(getSecondaryColor());
            g.draw(s);
        }
        
    }
    public void installColors(){
        setPrimaryColor(Color.YELLOW);
        setSecondaryColor(Color.BLACK);
        super.installColors();
    }
}
