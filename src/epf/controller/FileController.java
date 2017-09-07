/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.controller;

import epf.LanguagePropertyType;
import static epf.LanguagePropertyType.LABEL_SAVE_UNSAVED_WORK;
import epf.error.ErrorHandler;
import epf.file.EPortFolioFileManager;
import epf.file.EPortFolioSiteExporter;
import epf.view.EPortFolioEditWorkspace;
import epf.view.EPortFolioMakerView;
import epf.view.YesNoCancelDialog;
import java.io.IOException;
import properties_manager.PropertiesManager;

/**
 *
 * @author Apple
 */
public class FileController {
    
    // WE WANT TO KEEP TRACK OF WHEN SOMETHING HAS NOT BEEN SAVED
    private boolean saved;
    
    private EPortFolioEditWorkspace workspace;

    // THE APP UI
    private EPortFolioMakerView ui;
    
    // THIS GUY KNOWS HOW TO READ AND WRITE SLIDE SHOW DATA
    private EPortFolioFileManager portfolioIO;
    
    // THIS ONE EXPORTS OUR SITE
    private EPortFolioSiteExporter siteExporter;
    
    public FileController(EPortFolioMakerView initUI, 
	    EPortFolioFileManager initSlideShowIO, 
	    EPortFolioSiteExporter initSiteExporter){
        
        
            saved = true;
            ui = initUI;
            portfolioIO = initSlideShowIO;
            siteExporter = initSiteExporter;
    }
    
      public void markAsEdited() {
        saved = false;
        ui.updateFileToolbarControls(saved);
    }
      
    public void handleNewPortFolioRequest(){
        try {
            // WE MAY HAVE TO SAVE CURRENT WORK
            boolean continueToMakeNew = true;
            if (!saved) {
                // THE USER CAN OPT OUT HERE WITH A CANCEL
                continueToMakeNew = promptToSave();
            }

            // IF THE USER REALLY WANTS TO MAKE A NEW COURSE
            if (continueToMakeNew) {
                // RESET THE DATA, WHICH SHOULD TRIGGER A RESET OF THE UI

                // REFRESH THE GUI, WHICH WILL ENABLE AND DISABLE
                // THE APPROPRIATE CONTROLS
                ui.updateFileToolbarControls(saved);
                
		// MAKE SURE THE TITLE CONTROLS ARE ENABLED
		ui.reloadWorkSpace();
            }
        } catch (IOException ioe) {
            ErrorHandler eH = ui.getErrorHandler();
            eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
        }
        
    }
    
    public void handleLoadPortFolioRequest(){
        
    }
    
    public void handleSavePortFolioRequest(){
        
    }
    
    public void handleSaveAsPortFolioRequest(){
        
    }
    
    public void handleExportPortFolioRequest(){
        
    }
    public void handleExitRequest() {
        try {
            // WE MAY HAVE TO SAVE CURRENT WORK
            boolean continueToExit = true;
            if (!saved) {
                // THE USER CAN OPT OUT HERE
                continueToExit = promptToSave();
            }

            // IF THE USER REALLY WANTS TO EXIT THE APP
            if (continueToExit) {
                // EXIT THE APPLICATION
                System.exit(0);
            }
        } catch (IOException ioe) {
            ErrorHandler eH = ui.getErrorHandler();
            eH.processError(LanguagePropertyType.ERROR_UNEXPECTED);
        }
    }

    
    private boolean promptToSave() throws IOException {
        // PROMPT THE USER TO SAVE UNSAVED WORK
	YesNoCancelDialog yesNoCancelDialog = new YesNoCancelDialog(ui.getWindow());
	PropertiesManager props = PropertiesManager.getPropertiesManager();
        yesNoCancelDialog.show(props.getProperty(LABEL_SAVE_UNSAVED_WORK));
        
        // AND NOW GET THE USER'S SELECTION
        String selection = yesNoCancelDialog.getSelection();	
	boolean saveWork = selection.equals(YesNoCancelDialog.YES);

        // IF THE USER SAID YES, THEN SAVE BEFORE MOVING ON
        if (saveWork) {
           // EPortFolioModel portFolio = ui.getPortFolio();
           // portfolioIO.saveSlideShow(portFolio);
            saved = true;
        } // IF THE USER SAID CANCEL, THEN WE'LL TELL WHOEVER
        // CALLED THIS THAT THE USER IS NOT INTERESTED ANYMORE
        else if (!true) {
            return false;
        }

        // IF THE USER SAID NO, WE JUST GO ON WITHOUT SAVING
        // BUT FOR BOTH YES AND NO WE DO WHATEVER THE USER
        // HAD IN MIND IN THE FIRST PLACE
        return true;
    }

    
}
