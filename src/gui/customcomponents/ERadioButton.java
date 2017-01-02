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
public class ERadioButton extends JRadioButton {

    public ERadioButton(String text){
        this.setBackground(Color.LIGHT_GRAY);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial",Font.PLAIN , 15));
        this.setText(text);
    }

}
