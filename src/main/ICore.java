package main;

/**
 * @version 1.1
 * @author Radosław Jajko
 *
 * Created 29.12.2016
 * Updated 03.01.2017
 */
public interface ICore {

    /**
     * Load data from files to open database of words
     *
     */

    void loadAllData();

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
