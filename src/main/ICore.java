package main;

/**
 * @version 1.0
 * @author Radosław Jajko
 *
 * Created 29.12.2016
 */
public interface ICore {

    /**
     * Check answer which user has written
     * and compare it with correct answer at index i
     *
     * @param i - index of question correct answer
     * @param input - user answer
     * @return True if correct, False if not
     */
    boolean checkAnswer(int i, String input );

    /**
     * Load data from files to open database of words
     *
     * @param pathToFile - index for example "0102"
     *                   to specific file in database
     */

    void loadData( String pathToFile );

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
