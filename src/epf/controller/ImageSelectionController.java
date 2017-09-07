/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.controller;

import static epf.StartupConstants.PATH_SLIDE_SHOW_IMAGES;
import epf.model.EPortFolio;
import epf.view.EPortFolioEditView;
import javafx.stage.FileChooser;
import epf.view.EPortFolioMakerView;
import java.io.File;

/**
 *
 * @author SJM
 */
public class ImageSelectionController {
    EPortFolioMakerView ui;

    public ImageSelectionController(EPortFolioMakerView initUi) {   
	ui = initUi;
    }
    
    public void processSelectImage(EPortFolio portfolioToEdit, EPortFolioEditView view) {
	FileChooser imageFileChooser = new FileChooser();
	
	// SET THE STARTING DIRECTORY
	imageFileChooser.setInitialDirectory(new File(PATH_SLIDE_SHOW_IMAGES));
	
	// LET'S ONLY SEE IMAGE FILES
	FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	FileChooser.ExtensionFilter gifFilter = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
	imageFileChooser.getExtensionFilters().addAll(jpgFilter, pngFilter, gifFilter);
	
	// LET'S OPEN THE FILE CHOOSER
	File file = imageFileChooser.showOpenDialog(null);
	if (file != null) {
	    String path = file.getPath().substring(0, file.getPath().indexOf(file.getName()));
	    String fileName = file.getName();
	    portfolioToEdit.setImage(path, fileName);
	    view.updateSlideImage();
	    ui.updateFileToolbarControls(false);
	}
    
}
}