
     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.view;


import com.sun.javafx.scene.control.behavior.TabPaneBehavior;
import com.sun.javafx.scene.control.skin.TabPaneSkin;
import epf.LanguagePropertyType;
import static epf.LanguagePropertyType.LABEL_SLIDESHOW_TITLE;
import static epf.LanguagePropertyType.TOOLTIP_EXIT;
import static epf.LanguagePropertyType.TOOLTIP_LOAD_SLIDE_SHOW;
import static epf.LanguagePropertyType.TOOLTIP_NEW_SLIDE_SHOW;
import static epf.LanguagePropertyType.TOOLTIP_SAVE_SLIDE_SHOW;
import static epf.LanguagePropertyType.TOOLTIP_VIEW_SLIDE_SHOW;
import static epf.StartupConstants.CSS_CLASS_FONT;
import static epf.StartupConstants.CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON;
import static epf.StartupConstants.CSS_CLASS_HORIZONTAL_TOOLBAR_PANE;
import static epf.StartupConstants.CSS_CLASS_TITLE_PANE;
import static epf.StartupConstants.CSS_CLASS_TITLE_PROMPT;
import static epf.StartupConstants.CSS_CLASS_TITLE_TEXT_FIELD;
import static epf.StartupConstants.CSS_CLASS_VERTICAL_TOOLBAR_BUTTON;
import static epf.StartupConstants.CSS_CLASS_VERTICAL_TOOLBAR_PANE;
import static epf.StartupConstants.CSS_CLASS_WORKSPACE;
import static epf.StartupConstants.ICON_ADD_SLIDE;
import static epf.StartupConstants.ICON_EDIT;
import static epf.StartupConstants.ICON_EXIT;
import static epf.StartupConstants.ICON_EXPORT_SLIDE_SHOW;
import static epf.StartupConstants.ICON_FIVE;
import static epf.StartupConstants.ICON_FOUR;
import static epf.StartupConstants.ICON_HEADER;
import static epf.StartupConstants.ICON_IMAGE;
import static epf.StartupConstants.ICON_LIST;
import static epf.StartupConstants.ICON_LOAD_SLIDE_SHOW;
import static epf.StartupConstants.ICON_MOVE_DOWN;
import static epf.StartupConstants.ICON_MOVE_UP;
import static epf.StartupConstants.ICON_NEW_SLIDE_SHOW;
import static epf.StartupConstants.ICON_NEXT;
import static epf.StartupConstants.ICON_ONE;
import static epf.StartupConstants.ICON_PAGEADD;
import static epf.StartupConstants.ICON_PAGEREMOVE;
import static epf.StartupConstants.ICON_PARAGRAPH;
import static epf.StartupConstants.ICON_PAUSE;
import static epf.StartupConstants.ICON_PLAY;
import static epf.StartupConstants.ICON_PREVIOUS;
import static epf.StartupConstants.ICON_REMOVE_SLIDE;
import static epf.StartupConstants.ICON_SAVEAS_SLIDE_SHOW;
import static epf.StartupConstants.ICON_SAVE_SLIDE_SHOW;
import static epf.StartupConstants.ICON_SITE_VIEW;
import static epf.StartupConstants.ICON_SLIDESHOW;
import static epf.StartupConstants.ICON_THREE;
import static epf.StartupConstants.ICON_TWO;
import static epf.StartupConstants.ICON_VIDEO;
import static epf.StartupConstants.ICON_VIEW;
import static epf.StartupConstants.PATH_ICONS;
import static epf.StartupConstants.PATH_SLIDE_SHOWS;
import static epf.StartupConstants.STYLE_SHEET_UI_B;
import static epf.StartupConstants.STYLE_SHEET_UI_Y;
import static epf.StartupConstants.STYLE_SHEET_UI_G;
import static epf.StartupConstants.STYLE_SHEET_UI_BL;
import static epf.StartupConstants.STYLE_SHEET_UI_R;

import epf.controller.ColorController;
import epf.controller.FileController;
import epf.error.ErrorHandler;
import epf.file.EPortFolioFileManager;
import epf.file.EPortFolioSiteExporter;
import epf.model.EPortFolioModel;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.CENTER;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author Apple
 */
public class EPortFolioMakerView {
    
    Stage primaryStage;
    Scene primaryScene;
    
    // THIS PANE ORGANIZES THE BIG PICTURE CONTAINERS FOR THE
    // APPLICATION GUI
    BorderPane borderPane;
    GridPane grid;
    
    // THIS IS THE TOP TOOLBAR AND ITS CONTROLS
    FlowPane fileToolbarPane;
    BorderPane siteToolbarPane;
    FlowPane workspacePane;
    FlowPane pageEditPane;
    BorderPane paragraph;
   
    Button newPortFolioButton;
    Button loadPortFolioButton;
    Button savePortFolioButton;
    Button saveAsPortFolioButton;
    Button exportPortFolioButton;
    Button exitButton;
    Button pageAddButton;
    Button pageRemoveButton;
    Button pageEditButton;
    Button pageViewButton;
    Button layoutOneButton;
    Button layoutTwoButton;
    Button layoutThreeButton;
    Button layoutFourButton;
    Button layoutFiveButton;
    Button pageParagraphButton;
    Button pageHeaderButton;
    Button pageVideoButton;
    Button pageSlideshowButton;
    Button pageImageButton;
    Button pageListButton;
    Button compRemoveButton;

    
    Button siteViewButton;
    Button bannerAddButton;
    Button bannerRemoveButton;
    
    Image image;
    ImageView bannerSelectionView;
    
    SiteViewer viewer;
    
    // WORKSPACE
    BorderPane workspace;
    
    FlowPane layout; 

    // THIS WILL GO IN THE LEFT SIDE OF THE SCREEN
    FlowPane slideEditToolbar;
    FlowPane portFolioEditToolbar;
    Button addSlideButton;
    Button removeSlideButton;
    Button moveSlideUpButton;
    Button moveSlideDownButton;
  
    
    // FOR THE SLIDE SHOW TITLE
    FlowPane titlePane;
    TabPane pageSelection;
    
    FlowPane title;
    FlowPane name;
    FlowPane font;
    FlowPane color;
    FlowPane footerPane;
    Label titleLabel;
    TextField titleTextField;
    
    BorderPane topPane;
    // AND THIS WILL GO IN THE CENTER
    
    ScrollPane slidesEditorScrollPane;
    ScrollPane portFolioEditorScrollPane;
    VBox portFolioEditorPane;
    VBox slidesEditorPane;
    
    FlowPane heading;
    
    Text titleText;
    Text nameText; 
    Text footerText; 
    Text fontText; 
    Text colorText;
    
     // THIS IS FOR SAVING AND LOADING SLIDE SHOWS
    EPortFolioFileManager fileManager;
    
    // THIS IS FOR EXPORTING THE SLIDESHOW SITE
    EPortFolioSiteExporter siteExporter;
    
    // THIS IS FOR HANDLING ERRORS
    
    ErrorHandler errorHandler;
    
    // THIS IS FOR EDITING WORKSPACE
    
    ColorController colorController;
    
    FileController fileController;
    
    EPortFolioMakerView makerView;
    
    private EPortFolioEditWorkspace editWorkspace;
    
    public EPortFolioMakerView(EPortFolioFileManager initFileManager,
				EPortFolioSiteExporter initSiteExporter) {
	// FIRST HOLD ONTO THE FILE MANAGER
	fileManager = initFileManager;
	
	// AND THE SITE EXPORTER
	siteExporter = initSiteExporter;
	
	// MAKE THE DATA MANAGING MODEL
	//slideShow = new SlideShowModel(this);

	// WE'LL USE THIS ERROR HANDLER WHEN SOMETHING GOES WRONG
	errorHandler = new ErrorHandler(this);
    }
    
    public void startUI(Stage initStage) throws MalformedURLException, IOException{
    
       initFileToolbar();
       workSiteToolBar();
       initSiteToolBar();
       pageEditToolBar();
       
       initPage();
       addBanner();
      
       layoutToolBar();
       
       pageEditPane.setVisible(false);
       layout.setVisible(false);
       
    
        
       primaryStage = initStage;
       //initWorkspace();
       
       initWindow();
     
    }
    
    
    public void initWindow() throws MalformedURLException, IOException{
       

	// GET THE SIZE OF THE SCREEN
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();

	// AND USE IT TO SIZE THE WINDOW
	primaryStage.setX(bounds.getMinX());
	primaryStage.setY(bounds.getMinY());
	primaryStage.setWidth(bounds.getWidth());
	primaryStage.setHeight(bounds.getHeight());
        
        borderPane = new BorderPane();
        borderPane.getStyleClass().add(CSS_CLASS_WORKSPACE);
	borderPane.setTop(topPane);
        borderPane.setLeft(workspacePane);
        borderPane.setRight(pageEditPane);
        borderPane.setBottom(siteToolbarPane);
        borderPane.setCenter(workspace);
        
       primaryScene = new Scene(borderPane);
      
        // NOW TIE THE SCENE TO THE WINDOW, SELECT THE STYLESHEET
	// WE'LL USE TO STYLIZE OUR GUI CONTROLS, AND OPEN THE WINDOW
      
	primaryStage.setScene(primaryScene);
        
        //Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
       // Scene scene = new Scene(root);
       // primaryStage.setScene(scene);
      //  primaryStage.addScene(primaryScene);
       
        primaryScene.getStylesheets().add(STYLE_SHEET_UI_Y);
	primaryStage.show();
        
       
    }
    
    public Scene getScene(){
        return primaryScene;
    }
   
    
    private void initFileToolbar(){
        
        topPane = new BorderPane();
  
        fileController = new FileController(this, fileManager, siteExporter);
        
       fileToolbarPane = new FlowPane();
      

        // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
	// START AS ENABLED (false), WHILE OTHERS DISABLED (true)
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	newPortFolioButton = initChildButton(fileToolbarPane, ICON_NEW_SLIDE_SHOW,	TOOLTIP_NEW_SLIDE_SHOW,	    CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
	loadPortFolioButton = initChildButton(fileToolbarPane, ICON_LOAD_SLIDE_SHOW,	TOOLTIP_LOAD_SLIDE_SHOW,    CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
	savePortFolioButton = initChildButton(fileToolbarPane, ICON_SAVE_SLIDE_SHOW,	TOOLTIP_SAVE_SLIDE_SHOW,    CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, true);
        saveAsPortFolioButton = initChildButton(fileToolbarPane, ICON_SAVEAS_SLIDE_SHOW,	TOOLTIP_VIEW_SLIDE_SHOW,    CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, true);
        exportPortFolioButton = initChildButton(fileToolbarPane, ICON_EXPORT_SLIDE_SHOW,	TOOLTIP_VIEW_SLIDE_SHOW,    CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, true);
	exitButton = initChildButton(fileToolbarPane, ICON_EXIT, TOOLTIP_EXIT, CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
        
        newPortFolioButton.setOnAction(e->{
            fileController.handleNewPortFolioRequest();
        });
        
        loadPortFolioButton.setOnAction(e->{
            fileController.handleLoadPortFolioRequest();
        });
        
        savePortFolioButton.setOnAction(e->{
            fileController.handleSavePortFolioRequest();
        });
                
        saveAsPortFolioButton.setOnAction(e->{
            fileController.handleSaveAsPortFolioRequest();
        });
        
        exportPortFolioButton.setOnAction(e->{
            fileController.handleExportPortFolioRequest();
        });
        
        exitButton.setOnAction(e->{
            fileController.handleExitRequest();
        });
        
    
        topPane.setLeft(fileToolbarPane);
       
        
    }
    
    
    private void layoutToolBar(){
        
        SiteViewer viewer = new SiteViewer();
        
        layoutOneButton = this.initChildButton(workspacePane, ICON_ONE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = this.initChildButton(workspacePane, ICON_TWO,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = this.initChildButton(workspacePane, ICON_THREE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
        layoutFourButton = this.initChildButton(workspacePane, ICON_FOUR,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
        layoutFiveButton = this.initChildButton(workspacePane, ICON_FIVE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_HORIZONTAL_TOOLBAR_BUTTON, false);
                
       
        layoutOneButton.setOnAction(e->{
            try {
                viewer.startEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutTwoButton.setOnAction(e->{
            try {
                viewer.startEPortFolio2();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutThreeButton.setOnAction(e->{
            try {
                viewer.startEPortFolio3();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutFourButton.setOnAction(e->{
            try {
                viewer.startEPortFolio4();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutFiveButton.setOnAction(e->{
            try {
                viewer.startEPortFolio5();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
    
        layout = new FlowPane();
        layout.getChildren().add(layoutOneButton);
        layout.getChildren().add(layoutTwoButton);
        layout.getChildren().add(layoutThreeButton);
        layout.getChildren().add(layoutFourButton);
        layout.getChildren().add(layoutFiveButton);
        //portFolioEditorPane.getChildren().addAll(new Label("Layout: "), layout);
        layout.getStyleClass().add(CSS_CLASS_WORKSPACE);
        topPane.setRight(layout);
        
            
        layoutOneButton = this.initChildButton(workspacePane, ICON_ONE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = this.initChildButton(workspacePane, ICON_TWO,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
         layoutThreeButton = this.initChildButton(workspacePane, ICON_THREE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
         layoutFourButton = this.initChildButton(workspacePane, ICON_FOUR,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
         layoutFiveButton = this.initChildButton(workspacePane, ICON_FIVE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
    
                   
        FlowPane layout = new FlowPane();
        layout.getChildren().add(layoutOneButton);
        layout.getChildren().add(layoutTwoButton);
        layout.getChildren().add(layoutThreeButton);
        layout.getChildren().add(layoutFourButton);
        layout.getChildren().add(layoutFiveButton);
       
    
    }
    
    private void workSiteToolBar(){
        
        workspacePane = new FlowPane();
        workspacePane.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_PANE);
        pageEditButton = this.initChildButton(workspacePane, ICON_EDIT,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        pageViewButton = this.initChildButton(workspacePane, ICON_VIEW,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        siteViewButton = this.initChildButton(workspacePane, ICON_SITE_VIEW,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        
         SiteViewer viewer = new SiteViewer();
         
        pageEditButton.setOnAction(e->{
            
            if(!(pageEditPane.isVisible())){
                pageEditPane.setVisible(true);
                layout.setVisible(true);
                pageEditPane.getChildren().add(pageEditPane);
                //fileToolbarPane.setVisible(true);
                
                fileToolbarPane.getChildren().add(layout);
            }
            else{
                layout.setVisible(false);
                pageEditPane.setVisible(false);
                pageEditPane.getChildren().remove(pageEditPane);
                
            }
          
        });
        
        pageViewButton.setOnAction(e->{
            
            if(pageEditPane.isVisible()){
      
                layout.setVisible(false);
                pageEditPane.setVisible(false);
                pageEditPane.getChildren().remove(pageEditPane);
                
            }
          
        });
        
        
        siteViewButton.setOnAction(e->{
            try {
                viewer.startEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        siteViewButton.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);

    }

    private void pageEditToolBar(){
        
       pageEditPane = new FlowPane();
       pageEditPane.setVisible(true);
       pageEditPane.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_PANE);
       pageHeaderButton = this.initChildButton(pageEditPane, ICON_HEADER,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       pageParagraphButton = this.initChildButton(pageEditPane, ICON_PARAGRAPH,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       pageListButton = this.initChildButton(pageEditPane, ICON_LIST,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
      pageImageButton = this.initChildButton(pageEditPane, ICON_IMAGE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       pageSlideshowButton = this.initChildButton(pageEditPane, ICON_SLIDESHOW,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
      pageVideoButton = this.initChildButton(pageEditPane, ICON_VIDEO,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
      compRemoveButton = this.initChildButton(pageEditPane, ICON_REMOVE_SLIDE,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       
       pageHeaderButton.setOnAction(e->{
           addHeader();
       });
       pageParagraphButton.setOnAction(e->{
           addParagraph();
       });
       pageListButton.setOnAction(e->{
           addList();
       });
       pageImageButton.setOnAction(e->{
           addImages();
       });
         
       pageSlideshowButton.setOnAction(e->{
          addSlideshow();
       });

       pageVideoButton.setOnAction(e->{
          addVideo();
       });
    }
    
    private void initSiteToolBar(){
        siteToolbarPane = new BorderPane();
        pageSelection = new TabPane();
        FlowPane pageControl = new FlowPane();
        siteToolbarPane.setCenter(pageSelection);
        siteToolbarPane.setLeft(pageControl);
        siteToolbarPane.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_PANE);
        
        pageAddButton = this.initChildButton(pageControl, ICON_PAGEADD,TOOLTIP_NEW_SLIDE_SHOW,	 CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        
        pageAddButton.setOnAction(e->{
            
                addPageSelection("Curren Page");
                addPageSelection("New Page");
                addPage();
           
        });
        
        pageRemoveButton = this.initChildButton(pageControl, ICON_PAGEREMOVE,TOOLTIP_NEW_SLIDE_SHOW, CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        pageControl.getStyleClass().add(CSS_CLASS_HORIZONTAL_TOOLBAR_PANE);

        pageRemoveButton.setOnAction(e->{
            
            
            //removePageSelection("Default");
               
        });

    }
    
    private void addPageSelection(String name){
        
        Tab tab = new Tab();
        tab.setText(name);
        tab.setId(name);
        tab.setClosable(false);
      
        pageSelection.getTabs().add(tab);
       
    }
    
    private void addPage(){
      
    }
   
    private void removePageSelection(){
       
       // TabPaneBehavior behavior = getCurrentTab();
      
        
    }
    
    //private TabPaneBehavior getCurrentTab(){
       // return ((TabPaneSkin) this.getSkin()).getBehavior();
      
    //}
    
    public Button initChildButton(
	Pane toolbar, 
	String iconFileName, 
	LanguagePropertyType tooltip, 
	String cssClass,
	boolean disabled) {
	PropertiesManager props = PropertiesManager.getPropertiesManager();
	String imagePath = "file:" + PATH_ICONS + iconFileName;
	Image buttonImage = new Image(imagePath);
	Button button = new Button();
	button.getStyleClass().add(cssClass);
	button.setDisable(disabled);
	button.setGraphic(new ImageView(buttonImage));
	Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip.toString()));
	button.setTooltip(buttonTooltip);
	toolbar.getChildren().add(button);
	return button;
    }
    
       public void updateFileToolbarControls(boolean saved) {
	
	// NEXT ENABLE/DISABLE BUTTONS AS NEEDED IN THE FILE TOOLBAR
        
        savePortFolioButton.setDisable(false);
        saveAsPortFolioButton.setDisable(false);
        exportPortFolioButton.setDisable(false);

    }
       
       
       public void reloadWorkSpace() throws MalformedURLException, IOException{
           
           primaryStage.close();
            primaryStage = new Stage();
            
            startUI(primaryStage);
     
       }
       
       public ErrorHandler getErrorHandler(){
           return errorHandler;
       }
       
        public Stage getWindow() {
	return primaryStage;
    }

    public void initPage(){
        workspace = new BorderPane();
        
        portFolioEditorPane = new VBox(40);
	portFolioEditorScrollPane = new ScrollPane(portFolioEditorPane);
	portFolioEditorScrollPane.setFitToWidth(true);
	portFolioEditorScrollPane.setFitToHeight(true);
        portFolioEditorPane.setPadding(new Insets(70));

        initPageControls();

        workspace.setBottom(footerPane);
        workspace.setLeft(portFolioEditToolbar);
        workspace.setTop(titlePane);
	workspace.setCenter(portFolioEditorScrollPane);
 
    }
    
    public void addBanner() throws MalformedURLException{
         viewer = new SiteViewer();
        File file = new File("./images/slide_show_images/DefaultStartSlide.png");

         URL fileURL = file.toURI().toURL();

        
        BorderPane banner = new BorderPane();
        FlowPane bannerPane = new FlowPane();
        
        
        image = new Image(fileURL.toExternalForm());
         bannerSelectionView = new ImageView(image);
        
        bannerSelectionView.setFitWidth(400);
        bannerSelectionView.setFitHeight(200);
        
        banner.setLeft(bannerSelectionView);
        banner.setTop(bannerPane);
   
        portFolioEditorPane.getChildren().addAll(new Label("Banner: "),banner);
        
        bannerAddButton = this.initChildButton(banner, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        bannerRemoveButton = this.initChildButton(banner, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        
        bannerPane.getChildren().add(bannerAddButton);
        bannerPane.getChildren().add(bannerRemoveButton);
 
        bannerAddButton.setOnAction(e->{
            System.out.println("fuckedup");
          FileChooser bannerImage = new FileChooser();
         bannerImage.setInitialDirectory(new File(PATH_SLIDE_SHOWS));
         File selectedFile = bannerImage.showOpenDialog(this.getWindow());
         
            
             });
/**
        URL fileURL2 = null;
             try {
                 fileURL2 = selectedFile.toURI().toURL();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
             }
           

         image = new Image(fileURL2.toExternalForm());
         bannerSelectionView = new ImageView(image);
        
        bannerSelectionView.setFitWidth(400);
        bannerSelectionView.setFitHeight(200);
        banner.setLeft(bannerSelectionView);
      **/
       
    
    }
    
    public void addHeader(){
        
        heading = new FlowPane();
        TextField headerTextField = new TextField();
        heading.getChildren().add(headerTextField);
        
        portFolioEditorPane.getChildren().addAll(new Label("Header: "), heading);

    }
    
    public void removeHeader(){
       
    }
    
    public void addParagraph(){
          
        // Paragraph
        paragraph = new BorderPane();
        TextArea paraTextField = new TextArea();
        
        paraTextField.setMinSize(250,200);
        paraTextField.setMaxSize(650,550);

	ObservableList<String> languageChoices = FXCollections.observableArrayList();
        languageChoices.add("Times New Roman");
        languageChoices.add("Roboto");
        languageChoices.add("Ubuntu");
        languageChoices.add("Lato");
        languageChoices.add("Indie Flower");
        
        Label label = new Label("Select Font");
        
     
        ComboBox combo2 = new ComboBox(languageChoices);
        combo2.setValue("Roboto");
            
        GridPane gridPane = new GridPane();
	gridPane.add(combo2, 0, 0, 2, 1);
        gridPane.add(label,0,1,1,1);
        
        paragraph.setLeft(paraTextField);
        paragraph.setBottom(combo2);
        
        portFolioEditorPane.getChildren().addAll(new Label("Paragraph: "), paragraph);
        
    }
 
    public void addList(){
        
        ObservableList<String> languageChoices1 = FXCollections.observableArrayList();
        languageChoices1.add("None");
        languageChoices1.add("Numbered");
        languageChoices1.add("Unordered");
        
        ObservableList<String> names = FXCollections.observableArrayList(
          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        ListView list = new ListView(names);
        
        list.setMinSize(200,200);
        list.setMaxSize(525,425);
        
        Label label1 = new Label("Select Font");
        ComboBox combo1 = new ComboBox(languageChoices1);
        combo1.setValue("None");
        
            
        GridPane gridPane1 = new GridPane();
	gridPane1.add(combo1, 0, 0, 2, 1);
        gridPane1.add(label1,0,1,1,1);
        
        
        BorderPane layout1 = new BorderPane();
        layout1.setLeft(list);
        layout1.setBottom(combo1);
        
         portFolioEditorPane.getChildren().addAll(new Label("List: "), layout1);
    }
    
    public void addImages(){
         // Images
        
        FlowPane imageButton = new FlowPane();
        BorderPane images = new BorderPane();
      
        TextField imagesTextField = new TextField();
        imagesTextField.setMaxWidth(400);
        
        imagesTextField.setPromptText("Caption");
        ImageView imageSelectionView = new ImageView(image);
        
        imageSelectionView.setFitWidth(500);
        imageSelectionView.setFitHeight(500);
        
        
        
        images.setMinSize(600,600);
        images.setMaxSize(725,825);
     
        ObservableList<String> imageControl = FXCollections.observableArrayList();
        imageControl.add("None");
        imageControl.add("Add Caption");
        imageControl.add("Set Width/Height");
        
        
        
        Label imageLabel = new Label("\n");
        
     
        ComboBox imageCombo = new ComboBox(imageControl);
        imageCombo.setValue("None");
        
   
        GridPane imageGrid2 = new GridPane();
 
	imageGrid2.add(imageCombo, 0, 0, 2, 1);
        imageGrid2.add(imageLabel,0,1,1,1);
        
       
      
        TextField imageTextField = new TextField();
        imageTextField.setMaxWidth(400);
        
        imageTextField.setPromptText("Caption");
        ImageView imageSelectionView2 = new ImageView(image);
        
        imageSelectionView2.setFitWidth(500);
        imageSelectionView2.setFitHeight(500);
        
        
        images.setMinSize(600,600);
        images.setMaxSize(725,825);
     
        BorderPane imageToolBar = new BorderPane();
        
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        

        TextField username = new TextField();
        username.setPromptText("Height");
        TextField password = new TextField();
        password.setPromptText("Width");

        grid.add(new Label("Width:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Height:"), 0, 1);
        grid.add(password, 1, 1);
        
         imageToolBar.setTop(imageGrid2);
        imageToolBar.setCenter(grid);
        
        images.setLeft(imageSelectionView);
        images.setRight(imageToolBar);
        images.setBottom(imagesTextField);
        images.setTop(imageButton);
        
        
        
        layoutOneButton = this.initChildButton(imageButton, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = this.initChildButton(imageButton, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = this.initChildButton(imageButton, ICON_PREVIOUS,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = this.initChildButton(imageButton, ICON_NEXT,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
  
        imageButton.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);
        imageButton.getStyleClass().add(CSS_CLASS_FONT);
        portFolioEditorPane.getChildren().addAll(new Label("Images: "), images);
    }
    
    public void addSlideshow(){
         // SlideShow
        
        BorderPane slideshow = new BorderPane();
        FlowPane slideshowToolBar = new FlowPane();
        FlowPane slideshowImage = new FlowPane();
        BorderPane slideshowImage1 = new BorderPane();
        BorderPane slideshowImage2 = new BorderPane();
        
        slideshow.setMinSize(500,600);
        slideshow.setMaxSize(725,705);
        
        slideshowToolBar.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_PANE);
        slideshowToolBar.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);
        
        ImageView slideShowView1 = new ImageView(image);
        ImageView slideShowView2 = new ImageView(image);
        
        slideShowView1.setFitWidth(300);
        slideShowView1.setFitHeight(300);
        
        slideShowView2.setFitWidth(300);
        slideShowView2.setFitHeight(300);

        
        TextField slideText1 = new TextField();
        
        slideText1.setMaxWidth(400);
        
        slideText1.setPromptText("Caption");
        
        TextField slideText2 = new TextField();
        
        slideText2.setMaxWidth(400);
        
        slideText2.setPromptText("Caption");
        
        slideshowImage1.setCenter(slideShowView1);
        slideshowImage1.setRight(slideText1);
        slideshowImage2.setCenter(slideShowView2);
        slideshowImage2.setRight(slideText2);
        
       
        slideshowImage.getChildren().add(slideshowImage1);
        slideshowImage.getChildren().add(slideshowImage2);
        
         // public static String ICON_ADD_SLIDE = "Add.png";
        //public static String ICON_REMOVE_SLIDE = "Remove.png";
        //public static String ICON_MOVE_UP = "MoveUp.png";
        //public static String ICON_MOVE_DOWN = "MoveDown.png";
        
        layoutOneButton = this.initChildButton(slideshowToolBar, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = this.initChildButton(slideshowToolBar, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = this.initChildButton(slideshowToolBar, ICON_MOVE_UP,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = this.initChildButton(slideshowToolBar, ICON_MOVE_DOWN,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       
        
         layoutOneButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
        slideshow.setCenter(slideshowImage);
        
        slideshow.setLeft(slideshowToolBar);
        
       portFolioEditorPane.getChildren().addAll(new Label("Slideshow: "), slideshow);
    }
 
    public void addVideo(){
          
        // Video
        
        FlowPane videoButton = new FlowPane();
        BorderPane video = new BorderPane();
        
        
        
        ObservableList<String> videoControl = FXCollections.observableArrayList();
        videoControl.add("None");
        videoControl.add("Add Caption");
        videoControl.add("Set Width/Height");
        
        Label videoLabel = new Label("\n");
        
     
        ComboBox videoCombo = new ComboBox(videoControl);
        videoCombo.setValue("None");
        
   
        GridPane videoGrid2 = new GridPane();
 
	videoGrid2.add(videoCombo, 0, 0, 2, 1);
        videoGrid2.add(videoLabel,0,1,1,1);
        
       
      
        TextField videoTextField = new TextField();
        videoTextField.setMaxWidth(400);
        
        videoTextField.setPromptText("Caption");
        ImageView videoSelectionView = new ImageView(image);
        
        videoSelectionView.setFitWidth(500);
        videoSelectionView.setFitHeight(500);
        
        
        video.setMinSize(600,600);
        video.setMaxSize(725,825);
     
        BorderPane videoToolBar = new BorderPane();
  
        GridPane videoGrid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        

        TextField width = new TextField();
        width.setPromptText("Height");
        TextField height = new TextField();
        height.setPromptText("Width");

        videoGrid .add(new Label("Width:"), 0, 0);
        videoGrid .add(width, 1, 0);
        videoGrid .add(new Label("Height:"), 0, 1);
        videoGrid .add(height, 1, 1);
        
        videoToolBar.setTop(videoGrid2);
        videoToolBar.setCenter(videoGrid);
        

        
        video.setLeft(videoSelectionView);
        video.setRight(videoToolBar);
        video.setTop(videoTextField);
        video.setBottom(videoButton);
        
        
        layoutOneButton = this.initChildButton(videoButton, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = this.initChildButton(videoButton, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = this.initChildButton(videoButton, ICON_PLAY,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = this.initChildButton(videoButton, ICON_PAUSE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
     
        
         layoutOneButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         videoButton.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);
        videoButton.getStyleClass().add(CSS_CLASS_FONT);
        
        portFolioEditorPane.getChildren().addAll(new Label("Video: "), video);
    }
    public void initWorkspace() throws MalformedURLException{
    
       
        layoutOneButton.setOnAction(e->{
            try {
                viewer.startEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutTwoButton.setOnAction(e->{
            try {
                viewer.startEPortFolio2();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutThreeButton.setOnAction(e->{
            try {
                viewer.startEPortFolio3();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutFourButton.setOnAction(e->{
            try {
                viewer.startEPortFolio4();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        layoutFiveButton.setOnAction(e->{
            try {
                viewer.startEPortFolio5();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        

     
        
        
        //******************************************************* workspace component ******************************************************
        
        
      
     
        

        //portFolioEditorPane.getChildren().addAll(new Label("List: "), layout1);
       
        
       // portFolioEditorPane.getChildren().addAll(new Label("Images: "), images);
        
        
       // portFolioEditorPane.getChildren().addAll(new Label("Video: "), video);
        
        
       // portFolioEditorPane.getChildren().addAll(new Label("Slideshow: "), slideshow);
        
        
        
        
  
    }
        private void changeFont(String font, int size){
            titleText.setFont(new Font(font, size));
            nameText.setFont(new Font(font, size));
            footerText.setFont(new Font(font, size));
            fontText.setFont(new Font(font, size));
            colorText.setFont(new Font(font, size));
        }
    
   
        private void initPageControls() {
         
	PropertiesManager props = PropertiesManager.getPropertiesManager();
        titleText = new Text(30,30,"Title: ");
        nameText = new Text(30,30,"Name: ");
        footerText = new Text(30,30,"Footer: ");
        fontText = new Text(30,30,"Select Font: ");
        colorText = new Text(30,30,"Select Color: ");
 
        
        titleText.setFont(Font.font("Arial",30));
        nameText.setFont(Font.font("Arail",30));
        colorText.setFont(Font.font("Arial",30));
        fontText.setFont(Font.font("Arial",30));
        footerText.setFont(Font.font("Arial",30));
    
	String labelPrompt = props.getProperty(LABEL_SLIDESHOW_TITLE);
	
        ObservableList<String> languageChoices = FXCollections.observableArrayList();
        languageChoices.add("Arial");
        languageChoices.add("Times New Roman");
        languageChoices.add("Verdana");
        languageChoices.add("Comic Sans MS");
        languageChoices.add("Lucida Consol");
        
 
        Label label = new Label("Select Font");
        ComboBox <String> combo = new ComboBox(languageChoices);
        combo.setValue("Arial");
            
        GridPane gridPane = new GridPane();
	gridPane.add(combo, 0, 0, 2, 1);
        gridPane.add(label,0,1,1,1);
        
        combo.setOnAction(e->{
            String selectedLang = (String) combo.getSelectionModel().getSelectedItem();
                changeFont(selectedLang,30);
        });
        
        
        ObservableList<String> colorChoices = FXCollections.observableArrayList();
       
        colorChoices.add("Blue");
        colorChoices.add("Yellow");
        colorChoices.add("Green");
        colorChoices.add("Red");
        colorChoices.add("Black&White");
        
        
        System.setProperty("glass.accessible.force", "false");
     
       
        ComboBox colorCombo = new ComboBox(colorChoices);
        
         colorCombo.setValue("Yellow");
        
        colorCombo.setOnAction(e->{
            String selected = (String) colorCombo.getSelectionModel().getSelectedItem();
            if(selected == "Blue"){
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_R);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_Y);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_G);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_BL);
                primaryScene.getStylesheets().add(STYLE_SHEET_UI_B);
            }
            
            else if(selected == "Black&White"){
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_R);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_Y);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_G);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_B);
                primaryScene.getStylesheets().add(STYLE_SHEET_UI_BL);
            }
    
            else if(selected == "Green"){
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_R);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_Y);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_B);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_BL);
                primaryScene.getStylesheets().add(STYLE_SHEET_UI_G);
                
            }
            
             else if(selected == "Yellow"){
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_R);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_G);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_B);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_BL);
                primaryScene.getStylesheets().add(STYLE_SHEET_UI_Y);

            }
            
            else{
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_Y);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_G);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_B);
                primaryScene.getStylesheets().remove(STYLE_SHEET_UI_BL);
                primaryScene.getStylesheets().add(STYLE_SHEET_UI_R);
            }
         });
        
        GridPane colorGrid = new GridPane();
	colorGrid.add(colorCombo, 0, 0, 2, 1);
        colorGrid.add(label,0,1,1,1);

        
        
        
        titlePane = new FlowPane();
        title = new FlowPane();
        name = new FlowPane();
        font = new FlowPane();
        color = new FlowPane();
        
        BorderPane fontName = new BorderPane(); 
        
        fontName.setLeft(font);
        fontName.setRight(color);
        
        footerPane = new FlowPane();
        
        ObservableList<String> compChoices = FXCollections.observableArrayList();
       
        compChoices.add("Add/Remove Banner");
        compChoices.add("Add/Remove Header");
        compChoices.add("Add/Remove Paragraph");
        compChoices.add("Add/Remove List");
        compChoices.add("Add/Remove Image");
        compChoices.add("Add/Remove Video");
        compChoices.add("Add/Remove SlideShow");
        
        Label compLabel = new Label("Select Font");
     
        ComboBox compCombo = new ComboBox(compChoices);
        compCombo.setValue("Components Control");
            
        GridPane compGrid = new GridPane();
	compGrid.add(compCombo, 0, 0, 2, 1);
        compGrid.add(compLabel,0,1,1,1);
        
	titleLabel = new Label(labelPrompt);
	titleTextField = new TextField();
        TextField titleTextField2 = new TextField();
        TextField titleTextField3 = new TextField();
	
	title.getChildren().add(titleLabel);
        title.getChildren().add(titleText);
	title.getChildren().add(titleTextField);
       
        font.getChildren().add(fontText);
        font.getChildren().add(combo);
        
        color.getChildren().add(colorText);
        color.getChildren().add(colorCombo);
       
        
        name.getChildren().add(nameText);
	name.getChildren().add(titleTextField2);
       
        titlePane.getChildren().add(title);
        titlePane.getChildren().add(color);
        titlePane.getChildren().add(font);
        titlePane.getChildren().add(name);
  
      
        footerPane.getChildren().add(footerText);
	footerPane.getChildren().add(titleTextField3);
        footerPane.getChildren().add(compCombo);
	
        
    }
    

}
