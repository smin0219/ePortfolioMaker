/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.model;

    
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import properties_manager.PropertiesManager;
import epf.LanguagePropertyType;
import epf.view.EPortFolioMakerView;

/**
 *
 * @author Apple
 */
public class EPortFolioModel {

/**
 * This class manages all the data associated with a slideshow.
 * 
 * @author McKilla Gorilla & _____________
 */

    EPortFolioMakerView ui;
    String title;
    ObservableList<EPortFolio> slides;
    EPortFolio selectedSlide;
    
    public EPortFolioModel(EPortFolioMakerView initUI) {
	ui = initUI;
	slides = FXCollections.observableArrayList();
	reset();	
    }

    // ACCESSOR METHODS
    public boolean isPageSelected() {
	return selectedSlide != null;
    }
    
    public boolean isSelectedSlide(EPortFolio testSlide) {
	return selectedSlide == testSlide;
    }
    
    public ObservableList<EPortFolio> getSlides() {
	return slides;
    }
    
    public EPortFolio getSelectedPage() {
	return selectedSlide;
    }

    public String getTitle() { 
	return title; 
    }
    
    // MUTATOR METHODS
    public void setSelectedSlide(EPortFolio initSelectedSlide) {
	selectedSlide = initSelectedSlide;
    }
    
    public void setTitle(String initTitle) { 
	title = initTitle; 
    }

    // SERVICE METHODS
    
    /**
     * Resets the slide show to have no slides and a default title.
     */
    public void reset() {
	slides.clear();
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	title = props.getProperty(LanguagePropertyType.DEFAULT_SLIDE_SHOW_TITLE);
	selectedSlide = null;
    }

    /**
     * Adds a slide to the slide show with the parameter settings.
     * @param initImageFileName File name of the slide image to add.
     * @param initImagePath File path for the slide image to add.
     * @param initCaption Caption for the slide image to add.
     */
    public void addSlide(   String initImageFileName,
			    String initImagePath,
			    String initCaption) {
	EPortFolio slideToAdd = new EPortFolio(initImageFileName, initImagePath, initCaption);
	slides.add(slideToAdd);
	//ui.reloadSlideShowPane();
    }

    /**
     * Removes the currently selected slide from the slide show and
     * updates the display.
     */
    public void removeSelectedSlide() {
	if (isPageSelected()) {
	    slides.remove(selectedSlide);
	    selectedSlide = null;
	    //ui.reloadSlideShowPane();
	}
    }
 
    /**
     * Moves the currently selected slide up in the slide
     * show by one slide.
     */
    public void moveSelectedSlideUp() {
	if (isPageSelected()) {
	    moveSlideUp(selectedSlide);
	   // ui.reloadSlideShowPane();
	}
    }
    
    // HELPER METHOD
    private void moveSlideUp(EPortFolio slideToMove) {
	int index = slides.indexOf(slideToMove);
	if (index > 0) {
	    EPortFolio temp = slides.get(index);
	    slides.set(index, slides.get(index-1));
	    slides.set(index-1, temp);
	}
    }
    
    /**
     * Moves the currently selected slide down in the slide
     * show by one slide.
     */
    public void moveSelectedSlideDown() {
	if (isPageSelected()) {
	    moveSlideDown(selectedSlide);
	   // ui.reloadSlideShowPane();
	}
    }
    
    // HELPER METHOD
    private void moveSlideDown(EPortFolio slideToMove) {
	int index = slides.indexOf(slideToMove);
	if (index < (slides.size()-1)) {
	    EPortFolio temp = slides.get(index);
	    slides.set(index, slides.get(index+1));
	    slides.set(index+1, temp);
	}
    }
    
    /**
     * Changes the currently selected slide to the previous slide
     * in the slide show.
     */
    public void previous() {
	if (selectedSlide == null)
	    return;
	else {
	    int index = slides.indexOf(selectedSlide);
	    index--;
	    if (index < 0)
		index = slides.size() - 1;
	    selectedSlide = slides.get(index);
	}
    }

    /**
     * Changes the currently selected slide to the next slide
     * in the slide show.
     */    
    public void next() {
    	if (selectedSlide == null)
	    return;
	else {
	    int index = slides.indexOf(selectedSlide);
	    index++;
	    if (index >= slides.size())
		index = 0;
	    selectedSlide = slides.get(index);
	}
    }    
}