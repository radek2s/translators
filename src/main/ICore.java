package main;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 29.12.2016
 * Updated 04.01.2017
 */
public interface ICore {

    /**
     * Load data from files to open database of words
     *
     */

    void loadAllData();

    /**
     * Load data from Selected file and set as activeQuestionSet
     *
     * @param path - path to file which should be opened
     */
    void loadCustomData(String path);

    /**
     * Try to initialize application by reading loaded data
     * from binary file and set last saved values to gui
     *
     * @param core - current core
     * @return core - loaded core
     */

    Core initialize(Core core);

    /**
     * Save application data to file
     *
     * @param core
     */

    void saveSession(Core core);
}
