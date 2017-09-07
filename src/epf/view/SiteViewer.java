package epf.view;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import epf.LanguagePropertyType;
import static epf.StartupConstants.CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON;
import static epf.StartupConstants.DEFAULT_SLIDE_SHOW_HEIGHT;
import static epf.StartupConstants.ICON_NEXT;
import static epf.StartupConstants.ICON_PREVIOUS;
import static epf.StartupConstants.LABEL_SLIDE_SHOW_TITLE;


/**
 * This class provides the UI for the slide show viewer, note that this class is
 * a window and contains all controls inside.
 *
 * @author McKilla Gorilla & _____________
 */
public class SiteViewer extends Stage {

    EPortFolioMakerView parentView;
    ScrollPane scrollPane;
    WebView webView;
    WebEngine webEngine;

    /**
     * This constructor just initializes the parent and slides references, note
     * that it does not arrange the UI or start the slide show view window.
     *
     * @param initParentView Reference to the main UI.
     *
    /**
     * This method initializes the UI controls and opens the window with the
     * first slide in the slideshow displayed.
     */
    
    
    public void imageEPortFolio() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./images/slide_show_images/ArchesUtah.jpg";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
    
    
    public void startEPortFolio() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./EPortfolioSites/public_html/html/index1.html";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
    
     public void startEPortFolio2() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./EPortfolioSites/public_html/html/index2.html";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
     
      public void startEPortFolio3() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./EPortfolioSites/public_html/html/index3.html";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
      
       public void startEPortFolio4() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./EPortfolioSites/public_html/html/index4.html";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
       
        public void startEPortFolio5() throws MalformedURLException {
	// SETUP THE UI
	webView = new WebView();
	scrollPane = new ScrollPane(webView);
	
	// GET THE URL
	String indexPath =  "./EPortfolioSites/public_html/html/index5.html";
	File indexFile = new File(indexPath);
	URL indexURL = indexFile.toURI().toURL();
	
	// SETUP THE WEB ENGINE AND LOAD THE URL
	webEngine = webView.getEngine();
	webEngine.load(indexURL.toExternalForm());
	webEngine.setJavaScriptEnabled(true);
        
        Scene scene = new Scene(webView, 1100, 650);
	setScene(scene);
	this.showAndWait();
	
	
    }
    
}
