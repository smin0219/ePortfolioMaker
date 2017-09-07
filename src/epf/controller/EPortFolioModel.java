/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.controller;

import static com.sun.deploy.cache.Cache.reset;
import epf.LanguagePropertyType;
import epf.model.EPortFolio;
import javafx.collections.ObservableList;
import epf.view.EPortFolioMakerView;
import java.io.IOException;
import javafx.collections.FXCollections;
import properties_manager.PropertiesManager;

/**
 *
 * @author Apple
 */
public class EPortFolioModel {
    EPortFolioMakerView ui;
    String title;
    ObservableList<EPortFolio> portfolio;
    EPortFolio selectedPortFolio;
    
    public EPortFolioModel (EPortFolioMakerView initUI){
        ui = initUI;
        portfolio = FXCollections.observableArrayList();
        reset();
}
    public boolean isPortFolioSelected(){
        return selectedPortFolio != null;
    }
    
     public boolean isSelectedSlide(EPortFolio testPortfolio) {
	return selectedPortFolio == testPortfolio;
    }
     
     public ObservableList<EPortFolio> getSlides() {
	return portfolio;
    }
      public String getTitle() { 
	return title; 
    }
      
      public void setSelectedSlide(EPortFolio initSelectedPortFolio) {
	selectedPortFolio = initSelectedPortFolio;
    }
      
      public void reset() {
	portfolio.clear();
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	title = props.getProperty(LanguagePropertyType.DEFAULT_SLIDE_SHOW_TITLE);
	selectedPortFolio = null;
    }
      
        public void addPortfolio(   String initImageFileName,
			    String initImagePath,
			    String initCaption) throws IOException {
	EPortFolio slideToAdd = new EPortFolio(initImageFileName, initImagePath, initCaption);
	portfolio.add(slideToAdd);
	ui.reloadWorkSpace();
    }


}

