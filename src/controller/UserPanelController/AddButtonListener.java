package controller.UserPanelController;

import gui.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author Radosław Jajko
 *
 * created 29.12.2016
 * updated 29.12.2016
 */
public class AddButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getUserPanel().getTfUsername().getText().equals("")){
            Toolkit.getDefaultToolkit().beep();
            return;
        }

        int index = MainFrame.getUserPanel().getList().getSelectedIndex();
        int size =  MainFrame.getUserPanel().getListModel().getSize();

        if (size != -1 ){
            MainFrame.getUserPanel().getRemoveUserButton().setEnabled(true);
            MainFrame.getUserPanel().getSetUserButton().setEnabled(true);
        }

        if (index == -1 || (index+1 == size)){
            MainFrame.getUserPanel().getListModel().addElement(MainFrame.getUserPanel().getTfUsername().getText());
            MainFrame.getUserPanel().getList().setSelectedIndex(size);
        } else {
            MainFrame.getUserPanel().getListModel().insertElementAt(MainFrame.getUserPanel().getTfUsername().getText(), size);
            MainFrame.getUserPanel().getList().setSelectedIndex(size+1);
        }

        MainFrame.getCore().addUsers(MainFrame.getUserPanel().getTfUsername().getText());
    }
}
