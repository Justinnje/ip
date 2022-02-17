package duke;

import javafx.stage.Stage;

/**
 * Main class of Duke
 * Prints the introduction text of Duke
 *
 * @author Justin Ng Jie Ern
 */
public class Duke {
    private static final String FROM_DUKE = "From Duke: \n\n";
    private static final String BREAK_LINE = "__________________________________________";
    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Stage stage;

    private String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n\n";

    private String start = "Hello! I am Duke.\n"
            + "Your Personal Assistant.\n\n"
            + "Input 'help' for the Command Manual!!\n\n"
            + "What can I do for you?\n"
            + BREAK_LINE;

    /**
     * Constructor for Duke.
     */
    public Duke(Stage stage) {
        System.out.println(logo + start);
        this.taskList = new TaskList();
        this.storage = new Storage(taskList);
        this.ui = new Ui(taskList, storage);
        this.stage = stage;
    }

    /**
     * Getter for Stage Object.
     *
     * @return Stage Object.
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Method to get Reply for User input.
     *
     * @param input User input command.
     * @return A reply from duke for the respective commands.
     */
    public String getResponse(String input) {
        String reply = ui.run(input);
        return FROM_DUKE + reply + BREAK_LINE;
    }
}
