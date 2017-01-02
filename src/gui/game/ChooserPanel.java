package gui.game;

import controller.BackButtonListener;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;
import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class which creates panel to choose topic of current game
 * Contains every type of prepared words
 *
 * @version 1.0 28.12.2016
 * @author  Radosław Jajko on 28.12.2016
 *
 */
public class ChooserPanel extends EPanel {

    private EPanel panel01 = createSchoolButtons();
    private EPanel panel02 = createHealthButtons();
    private EPanel panel03 = createHouseButtons();
    private EPanel panel04 = createFamilyButtons();
    private EPanel panel05 = createWorkButtons();
    private EPanel panel06 = createTravelButtons();
    private EPanel panel07 = createFoodButtons();
    private EPanel panel08 = createHumanButtons();
    private EPanel panel09 = createCultureButtons();
    private EPanel panel10 = createSportButtons();
    private EPanel panel11 = createScienceButtons();
    private EPanel panel12 = createNatureButtons();
    private EPanel panel13 = createCountryButtons();

    public ChooserPanel() {


        EPanel mainPanel = new EPanel(new GridLayout(1,2));

        EPanel blPanel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(16, 0);

        buttonGridLayout.setVgap(2);
        blPanel.setLayout(buttonGridLayout);

        ELabel lLabel = new ELabel("Choose domain");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        String[] titles = {
                "School",
                "Health",
                "House",
                "Family life",
                "Work",
                "Tourism",
                "Food",
                "Human",
                "Culture",
                "Sport",
                "Science and Technology",
                "World of nature",
                "Country and Society"
        };

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);
        EButton b08 = new EButton(titles[7]);
        EButton b09 = new EButton(titles[8]);
        EButton b10 = new EButton(titles[9]);
        EButton b11 = new EButton(titles[10]);
        EButton b12 = new EButton(titles[11]);
        EButton b13 = new EButton(titles[12]);
        EButton bBack=new EButton("Back");

        blPanel.add(lLabel);
        blPanel.add(b01);
        blPanel.add(b02);
        blPanel.add(b03);
        blPanel.add(b04);
        blPanel.add(b05);
        blPanel.add(b06);
        blPanel.add(b07);
        blPanel.add(b08);
        blPanel.add(b09);
        blPanel.add(b10);
        blPanel.add(b11);
        blPanel.add(b12);
        blPanel.add(b13);
        blPanel.add(bBack);

        EPanel brPanel = new EPanel();
        panel01.setVisible(false);
        panel02.setVisible(false);
        panel03.setVisible(false);
        panel04.setVisible(false);
        panel05.setVisible(false);
        panel06.setVisible(false);
        panel07.setVisible(false);
        panel08.setVisible(false);
        panel09.setVisible(false);
        panel10.setVisible(false);
        panel11.setVisible(false);
        panel12.setVisible(false);
        panel13.setVisible(false);

        brPanel.add(panel01);
        brPanel.add(panel02);
        brPanel.add(panel03);
        brPanel.add(panel04);
        brPanel.add(panel05);
        brPanel.add(panel06);
        brPanel.add(panel07);
        brPanel.add(panel08);
        brPanel.add(panel09);
        brPanel.add(panel10);
        brPanel.add(panel11);
        brPanel.add(panel12);
        brPanel.add(panel13);

        mainPanel.add(blPanel);
        mainPanel.add(brPanel);

        this.add(mainPanel);

        b01.addActionListener(setVisible(1));
        b02.addActionListener(setVisible(2));
        b03.addActionListener(setVisible(3));
        b04.addActionListener(setVisible(4));
        b05.addActionListener(setVisible(5));
        b06.addActionListener(setVisible(6));
        b07.addActionListener(setVisible(7));
        b08.addActionListener(setVisible(8));
        b09.addActionListener(setVisible(9));
        b10.addActionListener(setVisible(10));
        b11.addActionListener(setVisible(11));
        b12.addActionListener(setVisible(12));
        b13.addActionListener(setVisible(13));
        bBack.addActionListener(new BackButtonListener());
    }

    /*
    This group of methods creates button panels to each of domain
    of translation sets.
     */


    private EPanel createSchoolButtons(){
        String[] titles = {
                "The school building",
                "School year",
                "School subjects and activities",
                "Teachers and students' characteristics",
                "Going to/leaving/finishing school",
                "School life",
                "Examinable",
                "The system of education",
                "Extra-curricular activities"};
        String path = "01";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);
        EButton b08 = new EButton(titles[7]);
        EButton b09 = new EButton(titles[8]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);
        panel.add(b08);
        panel.add(b09);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b08.addActionListener(e->{
            MainFrame.getCore().loadData(path+"08");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b09.addActionListener(e->{
            MainFrame.getCore().loadData(path+"09");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createHealthButtons(){

        String[] titles = {
                "Illnesses and symptoms",
                "Treatment",
                "Medical care",
                "Alternative medicine",
                "Modern addictions",
                "The disabled",
                "Healty lifestyle"
        };
        String path = "02";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createHouseButtons(){

        String[] titles = {
                "Flat sharing and flat renting",
                "Describing houses",
                "Leaving and returning to your house",
                "Jobs in the house"
        };
        String path = "03";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createFamilyButtons(){

        String[] titles = {
                "Daily routine",
                "Leisure time",
                "Stages of life",
                "Family members and acquaintances",
                "Family conflicts and problems",
                "Family and social relationships",
                "Festivals and celebrations"
        };
        String path = "04";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createWorkButtons(){

        String[] titles = {
                "Jobs",
                "At work",
                "People at work",
                "The job market/Working conditions",
                "Looking for a job",
                "Out of work"
        };
        String path = "05";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createTravelButtons(){

        String[] titles = {
                "Going on holiday",
                "Holiday activities",
                "At a hotel",
                "Travelling abroad",
                "Travel and transport",
                "Transport - accidents and problems",
                "At the airport/railway/coach stadion"
        };
        String path = "06";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createFoodButtons(){

        String[] titles = {
                "Food",
                "Meals and their preparation",
                "British food",
                "Diets",
                "Adjectives to describe healthy and unhealthy food",
                "Restaurants"
        };
        String path = "07";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createHumanButtons(){

        String[] titles = {
                "Personality",
                "Feelings",
                "Interests and hobbies",
                "Personal details",
                "Appearance",
                "Clothes",
                "Body parts",
                "Inside the body",
                "Idioms for success and failue"
        };
        String path = "08";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);
        EButton b08 = new EButton(titles[7]);
        EButton b09 = new EButton(titles[8]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);
        panel.add(b08);
        panel.add(b09);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b08.addActionListener(e->{
            MainFrame.getCore().loadData(path+"08");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b09.addActionListener(e->{
            MainFrame.getCore().loadData(path+"09");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createCultureButtons(){

        String[] titles = {
                "Mass Media",
                "Visual Arts",
                "Films",
                "Music",
                "Literature"
        };
        String path = "09";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createSportButtons(){

        String[] titles = {
                "Doing a sport",
                "Extreme sports",
                "People",
                "Places to do sports",
                "Sports equipment",
                "Competitive sports",
                "Sporting events"
        };
        String path = "10";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createScienceButtons(){

        String[] titles = {
                "Science",
                "Areas of science and scientists",
                "Information and communication technology",
                "Inventions and discoveries",
                "Machines and gadgets"
        };
        String path = "11";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createNatureButtons(){

        String[] titles = {
                "Environmental problems and solutions",
                "Space",
                "The Weather",
                "Natural disasters",
                "Animals",
                "Pets",
                "Plants",
                "Geographical features",
                "Animal idioms"
        };
        String path = "12";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);
        EButton b08 = new EButton(titles[7]);
        EButton b09 = new EButton(titles[8]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);
        panel.add(b08);
        panel.add(b09);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b08.addActionListener(e->{
            MainFrame.getCore().loadData(path+"08");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });
        b09.addActionListener(e->{
            MainFrame.getCore().loadData(path+"09");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
            MainFrame.getCore().generateNewOrder(MainFrame.getCore().getQuestions().size());
        });

        return panel;
    }
    private EPanel createCountryButtons(){

        String[] titles = {
                "Crime and punishment",
                "Country",
                "Politics",
                "Charity",
                "Economy",
                "Religion",
                "War and terrorism",
                "Describing trends"
        };
        String path = "13";

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(10, 0);
        buttonGridLayout.setVgap(4);
        panel.setLayout(buttonGridLayout);


        ELabel lLabel = new ELabel("Choose kind");
        lLabel.setHorizontalAlignment(SwingConstants.CENTER);

        EButton b01 = new EButton(titles[0]);
        EButton b02 = new EButton(titles[1]);
        EButton b03 = new EButton(titles[2]);
        EButton b04 = new EButton(titles[3]);
        EButton b05 = new EButton(titles[4]);
        EButton b06 = new EButton(titles[5]);
        EButton b07 = new EButton(titles[6]);
        EButton b08 = new EButton(titles[7]);

        panel.add(lLabel);
        panel.add(b01);
        panel.add(b02);
        panel.add(b03);
        panel.add(b04);
        panel.add(b05);
        panel.add(b06);
        panel.add(b07);
        panel.add(b08);

        b01.addActionListener(e->{
            MainFrame.getCore().loadData(path+"01");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b02.addActionListener(e->{
            MainFrame.getCore().loadData(path+"02");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b03.addActionListener(e->{
            MainFrame.getCore().loadData(path+"03");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b04.addActionListener(e->{
            MainFrame.getCore().loadData(path+"04");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b05.addActionListener(e->{
            MainFrame.getCore().loadData(path+"05");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b06.addActionListener(e->{
            MainFrame.getCore().loadData(path+"06");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b07.addActionListener(e->{
            MainFrame.getCore().loadData(path+"07");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });
        b08.addActionListener(e->{
            MainFrame.getCore().loadData(path+"08");
            MainFrame.getMainFrame().setContentPane(MainFrame.getGameMainPanel());
            MainFrame.getMainFrame().validate();
        });

        return panel;
    }

    /**
     * setVisible method hide currently visible panel and
     * shows selected by index panel
     *
     * @param i - index of panel to show
     * @return ActionListener which makes it visible
     */

    private ActionListener setVisible(int i){

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainFrame.getGameMainPanel().getlWord1b().setVisible(false);
                MainFrame.getGameMainPanel().getTfWord2().setVisible(false);
                panel01.setVisible(false);
                panel02.setVisible(false);
                panel03.setVisible(false);
                panel04.setVisible(false);
                panel05.setVisible(false);
                panel06.setVisible(false);
                panel07.setVisible(false);
                panel08.setVisible(false);
                panel09.setVisible(false);
                panel10.setVisible(false);
                panel11.setVisible(false);
                panel12.setVisible(false);
                panel13.setVisible(false);

                switch (i){
                    case 1:{panel01.setVisible(true); break;}
                    case 2:{panel02.setVisible(true); break;}
                    case 3:{panel03.setVisible(true); break;}
                    case 4:{panel04.setVisible(true); break;}
                    case 5:{panel05.setVisible(true); break;}
                    case 6:{panel06.setVisible(true); break;}
                    case 7:{panel07.setVisible(true); break;}
                    case 8:{panel08.setVisible(true); break;}
                    case 9:{panel09.setVisible(true); break;}
                    case 10:{panel10.setVisible(true); break;}
                    case 11:{panel11.setVisible(true); break;}
                    case 12:{panel12.setVisible(true); break;}
                    case 13:{panel13.setVisible(true); break;}
                }
            }
        };
        return al;
    }

}
