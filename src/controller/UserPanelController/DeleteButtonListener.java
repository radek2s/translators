package controller.UserPanelController;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.0
 * @author Radosław Jajko
 *
 * created 29.12.2016
 * updated 29.12.2016
 */
public class DeleteButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getCore().getUsers().remove(MainFrame.getUserPanel().getList().getSelectedIndex());
        MainFrame.getUserPanel().getListModel().remove(MainFrame.getUserPanel().getList().getSelectedIndex());

        int size = MainFrame.getUserPanel().getListModel().size();

        if (size == 0) {
            //List is empty!
            MainFrame.getUserPanel().getRemoveUserButton().setEnabled(false);
            MainFrame.getUserPanel().getSetUserButton().setEnabled(false);
        } else {
            MainFrame.getUserPanel().getList().setSelectedIndex(MainFrame.getUserPanel().getList().getFirstVisibleIndex());
        }
    }
}
