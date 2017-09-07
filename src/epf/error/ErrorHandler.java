/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.error;


    
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import properties_manager.PropertiesManager;
import epf.LanguagePropertyType;
import epf.view.EPortFolioMakerView;

/**
 * This class provides error messages to the user when the occur. Note
 * that error messages should be retrieved from language-dependent XML files
 * and should have custom messages that are different depending on
 * the type of error so as to be informative concerning what went wrong.
 * 
 * @author SJM
 */
public class ErrorHandler {
    // APP UI
    private EPortFolioMakerView ui;
    
    // KEEP THE APP UI FOR LATER
    public ErrorHandler(EPortFolioMakerView initUI) {
	ui = initUI;
    }
    
    /**
     * This method provides all error feedback. It gets the feedback text,
     * which changes depending on the type of error, and presents it to
     * the user in a dialog box.
     * 
     * @param errorType Identifies the type of error that happened, which
     * allows us to get and display different text for different errors.
     */
    public void processError(LanguagePropertyType errorType)
    {
        // GET THE FEEDBACK TEXT
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String errorFeedbackText = props.getProperty(errorType);
             
        // POP OPEN A DIALOG TO DISPLAY TO THE USER
        Alert alertDialog = new Alert(AlertType.WARNING, errorFeedbackText);
	alertDialog.showAndWait();
    }    
}
