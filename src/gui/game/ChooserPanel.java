package gui.game;

import controller.BackButtonListener;
import controller.GameContorller.AllQuestionsSetListener;
import controller.GameContorller.CustomQuestionListener;
import controller.GameContorller.SetChooserListener;
import gui.MainFrame;
import gui.customcomponents.EButton;
import gui.customcomponents.ELabel;
import gui.customcomponents.EPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class which creates panel to choose topic of current game
 * Contains every type of prepared words
 *
 * @version 1.1
 * @author  Radosław Jajko
 *
 * created 28.12.2016
 * updated 04.01.2017
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
        GridLayout buttonGridLayout = new GridLayout(0, 1);

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
                "Country and Society",
                "All words from database",
                "Custom - open from file"
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
        EButton b14 = new EButton(titles[13]);
        EButton b15 = new EButton(titles[14]);
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
        blPanel.add(b14);
        blPanel.add(b15);
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
        b14.addActionListener(new AllQuestionsSetListener(0));
        b15.addActionListener(new CustomQuestionListener());
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
                "Extra-curricular activities",
                "All words from School"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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
        EButton b10 = new EButton(titles[9]);

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
        panel.add(b10);

        b01.addActionListener(new SetChooserListener(0));
        b02.addActionListener(new SetChooserListener(1));
        b03.addActionListener(new SetChooserListener(2));
        b04.addActionListener(new SetChooserListener(3));
        b05.addActionListener(new SetChooserListener(4));
        b06.addActionListener(new SetChooserListener(5));
        b07.addActionListener(new SetChooserListener(6));
        b08.addActionListener(new SetChooserListener(7));
        b09.addActionListener(new SetChooserListener(8));
        b10.addActionListener(new AllQuestionsSetListener(1));

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
                "Healthy lifestyle",
                "All words from Health"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(9));
        b02.addActionListener(new SetChooserListener(10));
        b03.addActionListener(new SetChooserListener(11));
        b04.addActionListener(new SetChooserListener(12));
        b05.addActionListener(new SetChooserListener(13));
        b06.addActionListener(new SetChooserListener(14));
        b07.addActionListener(new SetChooserListener(15));
        b08.addActionListener(new AllQuestionsSetListener(2));

        return panel;
    }
    private EPanel createHouseButtons(){

        String[] titles = {
                "Flat sharing and flat renting",
                "Describing houses",
                "Leaving and returning to your house",
                "Jobs in the house",
                "All words from Houses"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(16));
        b02.addActionListener(new SetChooserListener(17));
        b03.addActionListener(new SetChooserListener(18));
        b04.addActionListener(new SetChooserListener(19));
        b05.addActionListener(new AllQuestionsSetListener(3));

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
                "Festivals and celebrations",
                "All words connected with Family"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(20));
        b02.addActionListener(new SetChooserListener(21));
        b03.addActionListener(new SetChooserListener(22));
        b04.addActionListener(new SetChooserListener(23));
        b05.addActionListener(new SetChooserListener(24));
        b06.addActionListener(new SetChooserListener(25));
        b07.addActionListener(new SetChooserListener(26));
        b08.addActionListener(new AllQuestionsSetListener(4));

        return panel;
    }
    private EPanel createWorkButtons(){

        String[] titles = {
                "Jobs",
                "At work",
                "People at work",
                "The job market/Working conditions",
                "Looking for a job",
                "Out of work",
                "All words connected with work"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(27));
        b02.addActionListener(new SetChooserListener(28));
        b03.addActionListener(new SetChooserListener(29));
        b04.addActionListener(new SetChooserListener(30));
        b05.addActionListener(new SetChooserListener(31));
        b06.addActionListener(new SetChooserListener(32));
        b07.addActionListener(new AllQuestionsSetListener(5));

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
                "At the airport/railway/coach stadium",
                "All words connected with Travel"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(33));
        b02.addActionListener(new SetChooserListener(34));
        b03.addActionListener(new SetChooserListener(35));
        b04.addActionListener(new SetChooserListener(36));
        b05.addActionListener(new SetChooserListener(37));
        b06.addActionListener(new SetChooserListener(38));
        b07.addActionListener(new SetChooserListener(39));
        //TODO
        //Missing one of data element '40'
        b08.addActionListener(new AllQuestionsSetListener(6));

        return panel;
    }
    private EPanel createFoodButtons(){

        String[] titles = {
                "Food",
                "Meals and their preparation",
                "British food",
                "Diets",
                "Adjectives to describe healthy and unhealthy food",
                "Restaurants",
                "All words connected with Food"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(41));
        b02.addActionListener(new SetChooserListener(42));
        b03.addActionListener(new SetChooserListener(43));
        b04.addActionListener(new SetChooserListener(44));
        b05.addActionListener(new SetChooserListener(45));
        b06.addActionListener(new SetChooserListener(46));
        b07.addActionListener(new AllQuestionsSetListener(7));

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
                "Idioms for success and failure",
                "All words connected with Human"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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
        EButton b10 = new EButton(titles[9]);

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
        panel.add(b10);

        b01.addActionListener(new SetChooserListener(47));
        b02.addActionListener(new SetChooserListener(48));
        b03.addActionListener(new SetChooserListener(49));
        b04.addActionListener(new SetChooserListener(50));
        b05.addActionListener(new SetChooserListener(51));
        b06.addActionListener(new SetChooserListener(52));
        b07.addActionListener(new SetChooserListener(53));
        b08.addActionListener(new SetChooserListener(54));
        b09.addActionListener(new SetChooserListener(55));
        b10.addActionListener(new AllQuestionsSetListener(8));

        return panel;
    }
    private EPanel createCultureButtons(){

        String[] titles = {
                "Mass Media",
                "Visual Arts",
                "Films",
                "Music",
                "Literature",
                "All words connected with Culture"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(56));
        b02.addActionListener(new SetChooserListener(57));
        b03.addActionListener(new SetChooserListener(58));
        b04.addActionListener(new SetChooserListener(59));
        b05.addActionListener(new SetChooserListener(60));
        b06.addActionListener(new AllQuestionsSetListener(9));

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
                "Sporting events",
                "All words connected with Sport"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(61));
        b02.addActionListener(new SetChooserListener(62));
        b03.addActionListener(new SetChooserListener(63));
        b04.addActionListener(new SetChooserListener(64));
        b05.addActionListener(new SetChooserListener(65));
        b06.addActionListener(new SetChooserListener(66));
        b07.addActionListener(new SetChooserListener(67));
        b08.addActionListener(new AllQuestionsSetListener(10));

        return panel;
    }
    private EPanel createScienceButtons(){

        String[] titles = {
                "Science",
                "Areas of science and scientists",
                "Information and communication technology",
                "Inventions and discoveries",
                "Machines and gadgets",
                "All words connected with Science"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(68));
        b02.addActionListener(new SetChooserListener(69));
        b03.addActionListener(new SetChooserListener(70));
        b04.addActionListener(new SetChooserListener(71));
        b05.addActionListener(new SetChooserListener(72));
        //TODO
        // Missing one of the elements - 73!
        b06.addActionListener(new AllQuestionsSetListener(11));

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
                "Animal idioms",
                "All words connected with Nature"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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
        EButton b10 = new EButton(titles[9]);

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
        panel.add(b10);

        b01.addActionListener(new SetChooserListener(74));
        b02.addActionListener(new SetChooserListener(75));
        b03.addActionListener(new SetChooserListener(76));
        b04.addActionListener(new SetChooserListener(77));
        b05.addActionListener(new SetChooserListener(78));
        b06.addActionListener(new SetChooserListener(79));
        b07.addActionListener(new SetChooserListener(80));
        b08.addActionListener(new SetChooserListener(81));
        b09.addActionListener(new SetChooserListener(82));
        b10.addActionListener(new AllQuestionsSetListener(12));

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
                "Describing trends",
                "All words connected with Country"
        };

        EPanel panel = new EPanel();
        GridLayout buttonGridLayout = new GridLayout(0, 1);
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

        b01.addActionListener(new SetChooserListener(83));
        b02.addActionListener(new SetChooserListener(84));
        b03.addActionListener(new SetChooserListener(85));
        b04.addActionListener(new SetChooserListener(86));
        b05.addActionListener(new SetChooserListener(87));
        b06.addActionListener(new SetChooserListener(88));
        b07.addActionListener(new SetChooserListener(89));
        b08.addActionListener(new SetChooserListener(90));
        b09.addActionListener(new AllQuestionsSetListener(13));

        return panel;
    }

    /**
     * setVisible method hide currently visible panel and
     * shows selected by index panel
     *
     * @param i - index of panel to show
     * @return ActionPerformed (lambda expression)
     */

    private ActionListener setVisible(int i){

        return e -> {

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
        };
    }

}
