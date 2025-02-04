package michael.gui;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import michael.Michael;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Michael michael;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image michaelImage = new Image(this.getClass().getResourceAsStream("/images/DaMichael.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Start Up Message when Michael is run.
     */
    @FXML
    public void startUpMessage() {
        dialogContainer.getChildren().addAll(
                DialogBox.getMichaelDialog(Michael.START, michaelImage)
        );
    }

    /**
     * Setter for Michael.
     *
     * @param d Michael.
     */
    public void setMichael(Michael d) {
        michael = d;
        startUpMessage();
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Michael's reply and then
     * appends them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String fromUser = "MICHAEEELLLL!! \n\t";
        String userMsg = fromUser + input;
        String response = michael.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userMsg, userImage),
                DialogBox.getMichaelDialog(response, michaelImage)
        );
        userInput.clear();

        if (input.equals("bye")) {
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
    }
}
