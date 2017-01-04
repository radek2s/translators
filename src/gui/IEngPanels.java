package gui;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * created 03.01.2017
 * updated --.--.----
 */
public interface IEngPanels {

    /**
     * Create and show Graphic User Interface
     * Every panel should be firstly initialized
     *
     */

    void createAndShowGUI();

    /**
     * And after creation should be initialized
     * which means - filled with existing data
     */

    void initializeGUI();

}
