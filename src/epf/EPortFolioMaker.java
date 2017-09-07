/*
 * Sample
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf;


import static epf.LanguagePropertyType.TITLE_WINDOW;
import epf.file.EPortFolioFileManager;
import epf.file.EPortFolioSiteExporter;
import epf.view.EPortFolioMakerView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Apple
 */
public class EPortFolioMaker extends Application {
    
    EPortFolioFileManager fileManager = new EPortFolioFileManager();
    
    // THIS WILL EXPORT THE WEB SITES
    EPortFolioSiteExporter siteExporter = new EPortFolioSiteExporter();

    // THIS HAS THE FULL USER INTERFACE AND ONCE IN EVENT
    // HANDLING MODE, BASICALLY IT BECOMES THE FOCAL
    // POINT, RUNNING THE UI AND EVERYTHING ELSE
    EPortFolioMakerView ui = new EPortFolioMakerView(fileManager, siteExporter);
  
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String appTitle = props.getProperty(TITLE_WINDOW);
        ui.startUI(primaryStage);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
