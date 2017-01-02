package gui.customcomponents;

import javax.swing.*;
import java.awt.*;

/**
 * Custom UI design
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 02.01.2017.
 */
public class EPanel extends JPanel {

    public EPanel(){
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public EPanel(LayoutManager layoutManager){
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.setLayout(layoutManager);
    }

    public void changeBackgroundColor(Color color){
        this.setBackground(color);
    }
}
