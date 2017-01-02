package gui.user;

import controller.BackButtonListener;
import controller.UserPanelController.AddButtonListener;
import controller.UserPanelController.DeleteButtonListener;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;
import main.User;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UserPanel creates panel to choose/add/delete user
 * In this panel possible is level and score check
 *
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 14.12.2016
 * Updated 02.01.2016
 */

public class UserPanel extends EPanel implements ListSelectionListener {

    private JList list;

    private ELabel tfActiveUser;
    private JTextField      tfUsername;
    private ELabel          tfLevel;
    private ELabel          tfScore;
    private ELabel          tfLastActivity;
    private DefaultListModel listModel;
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private EButton bSaveUser = null;
    private EButton bRemoveUser = null;
    private EButton bSetUSer = null;
    private EButton bBack = null;


    public UserPanel() {

        Border border = BorderFactory.createEmptyBorder(10,10,10,10);

        this.setLayout(new BorderLayout());


        listModel = new DefaultListModel();


        //Create the list and put it into a scroll pane
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(-1);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(100, 200));
        listScrollPane.setAlignmentX(LEFT_ALIGNMENT);
        listScrollPane.setBorder(border);

        //Create right panel
        EPanel rightPanel = new EPanel(new GridLayout(2,1));
        rightPanel.setBorder(border);

        //Create active user info
        EPanel activeUserPanel = new EPanel(new GridLayout(2,1,5,5));

        ELabel lActiveUser = new ELabel("Active user:");
        tfActiveUser    = new ELabel("test");
        tfActiveUser.setHorizontalAlignment(SwingConstants.CENTER);
        tfActiveUser.setFont(new Font("Arial",Font.BOLD,15));
        tfActiveUser.setForeground(Color.DARK_GRAY);

        activeUserPanel.add(lActiveUser);
        activeUserPanel.add(tfActiveUser);

        //Create user info panel
        EPanel userInfoPanel = new EPanel(new GridLayout(0,2));

        ELabel lUsername = new ELabel("Username:");
        tfUsername  = new JTextField();

        ELabel lActive = new ELabel("Last activity:");
        tfLastActivity  = new ELabel("00.00.0000");


        ELabel lLevel = new ELabel("Level:");
        tfLevel     = new ELabel("0");

        ELabel lScore = new ELabel("User score:");
        tfScore     = new ELabel("0000");

        tfUsername.addActionListener(new AddButtonListener());


        userInfoPanel.add(activeUserPanel);
        userInfoPanel.add(new EPanel());
        userInfoPanel.add(lUsername);
        userInfoPanel.add(tfUsername);
        userInfoPanel.add(lActive);
        userInfoPanel.add(tfLastActivity);
        userInfoPanel.add(lLevel);
        userInfoPanel.add(tfLevel);
        userInfoPanel.add(lScore);
        userInfoPanel.add(tfScore);
        userInfoPanel.setBorder(border);

        //Create buttons panel
        EPanel buttonsPanel = new EPanel(new BorderLayout());

        EPanel removeSavePanel = new EPanel(new GridLayout(0,2));
        bSaveUser   = new EButton("Save User");
        bRemoveUser = new EButton("Remove User");
        bSetUSer    = new EButton("Set as active user");
        bBack       = new EButton("Back to menu");


        bSaveUser.addActionListener(new AddButtonListener());

        bRemoveUser.addActionListener(new DeleteButtonListener());


        removeSavePanel.add(bSaveUser);
        removeSavePanel.add(bRemoveUser);
        removeSavePanel.setBorder(border);

        buttonsPanel.add(removeSavePanel, BorderLayout.PAGE_START);
        buttonsPanel.add(bSetUSer, BorderLayout.CENTER);
        buttonsPanel.add(bBack, BorderLayout.PAGE_END);
        buttonsPanel.setBorder(border);

        //Add to right panel
        rightPanel.add(userInfoPanel);
        rightPanel.add(buttonsPanel);

        this.add(listScrollPane,BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.CENTER);

        bSetUSer.addActionListener(e -> {

            MainFrame.getCore().setActiveUser(MainFrame.getCore().getUsers().get(list.getSelectedIndex()));
            MainFrame.getCore().getActiveUser().setLastActive(new Date());
            tfActiveUser.setText(MainFrame.getCore().getActiveUser().getUsername());
        });

        bBack.addActionListener(new BackButtonListener());


    }

    public JList getList(){
        return list;
    }

    public DefaultListModel getListModel(){
        return listModel;
    }

    public EButton getRemoveUserButton(){
        return bRemoveUser;
    }

    public EButton getSetUserButton(){
        return bSetUSer;
    }

    public JTextField getTfUsername(){
        return tfUsername;
    }

    public ELabel getTfLevel() { return tfLevel; }

    public void initialize(){

        for ( User user: MainFrame.getCore().getUsers() ) {
            listModel.addElement(user.getUsername());
        }

        list.updateUI();
        tfUsername.setText(MainFrame.getCore().getActiveUser().getUsername());
        tfScore.setText(String.valueOf(MainFrame.getCore().getActiveUser().getLevel().getScore()));
        tfLevel.setText(MainFrame.getCore().getActiveUser().getLevel().getCurrentLevel());
        tfActiveUser.setText(MainFrame.getCore().getActiveUser().getUsername());
        tfLastActivity.setText(dateFormat.format(MainFrame.getCore().getActiveUser().getLastActive()));

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        try {
            tfUsername.setText(MainFrame.getCore().getUsers().get(list.getSelectedIndex()).getUsername());
            tfLastActivity.setText(dateFormat.format(MainFrame.getCore().getUsers().get(list.getSelectedIndex()).getLastActive()));
            tfLevel.setText(MainFrame.getCore().getUsers().get(list.getSelectedIndex()).getLevel().getCurrentLevel());
            tfScore.setText(String.valueOf(MainFrame.getCore().getUsers().get(list.getSelectedIndex()).getLevel().getScore()));
        } catch (Exception e1){
            e1.printStackTrace();
        }

        }
}