/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epf.view;

import static epf.LanguagePropertyType.LABEL_SLIDESHOW_TITLE;
import static epf.LanguagePropertyType.TOOLTIP_NEW_SLIDE_SHOW;
import static epf.StartupConstants.CSS_CLASS_FONT;
import static epf.StartupConstants.CSS_CLASS_TITLE_PANE;
import static epf.StartupConstants.CSS_CLASS_TITLE_PROMPT;
import static epf.StartupConstants.CSS_CLASS_TITLE_TEXT_FIELD;
import static epf.StartupConstants.CSS_CLASS_VERTICAL_TOOLBAR_BUTTON;
import static epf.StartupConstants.CSS_CLASS_VERTICAL_TOOLBAR_PANE;
import static epf.StartupConstants.ICON_ADD_SLIDE;
import static epf.StartupConstants.ICON_FIVE;
import static epf.StartupConstants.ICON_FOUR;
import static epf.StartupConstants.ICON_MOVE_DOWN;
import static epf.StartupConstants.ICON_MOVE_UP;
import static epf.StartupConstants.ICON_NEXT;
import static epf.StartupConstants.ICON_ONE;
import static epf.StartupConstants.ICON_PAUSE;
import static epf.StartupConstants.ICON_PLAY;
import static epf.StartupConstants.ICON_PREVIOUS;
import static epf.StartupConstants.ICON_REMOVE_SLIDE;
import static epf.StartupConstants.ICON_THREE;
import static epf.StartupConstants.ICON_TWO;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import properties_manager.PropertiesManager;

/**
 *
 * @author Apple
 * 
 * 
 **/


public class EPortFolioEditWorkspace {
    
     // WORKSPACE
    BorderPane workspace;
    
    // Button
    Button siteViewButton;
    Button bannerAddButton;
    Button bannerRemoveButton;
    Button layoutOneButton;
    Button layoutTwoButton;
    Button layoutThreeButton;
    Button layoutFourButton;
    Button layoutFiveButton;
    
    // Pane
    
    BorderPane titlePane;
    FlowPane workspacePane;
    FlowPane footerPane;
    FlowPane portFolioEditToolbar;
    FlowPane title;
    FlowPane name;
    FlowPane font;
    FlowPane color;
    
  
    // Text
    
    TextField titleTextField;
    
    // Label
    
    Label titleLabel;
    
    // Image
    Image image;
    ImageView bannerSelectionView;
    
    // SlideEditor
    
    ScrollPane slidesEditorScrollPane;
    VBox slidesEditorPane;
    
    // PortFolioEditor
    
    ScrollPane portFolioEditorScrollPane;
    VBox portFolioEditorPane;
    
    // Class
    
    EPortFolioMakerView makerView;
    
    
    public void initWorkspace() throws MalformedURLException{
        
        
        SiteViewer viewer = new SiteViewer();
        File file = new File("./images/slide_show_images/DefaultStartSlide.png");
        URL fileURL = file.toURI().toURL();
        
        workspace = new BorderPane();
        
        BorderPane banner = new BorderPane();
        FlowPane bannerPane = new FlowPane();
        
        
        image = new Image(fileURL.toExternalForm());
        bannerSelectionView = new ImageView(image);
        
        bannerSelectionView.setFitWidth(400);
        bannerSelectionView.setFitHeight(200);
        
        portFolioEditorPane = new VBox(20);
	portFolioEditorScrollPane = new ScrollPane(portFolioEditorPane);
	portFolioEditorScrollPane.setFitToWidth(true);
	portFolioEditorScrollPane.setFitToHeight(true);
        
        banner.setLeft(bannerSelectionView);
        banner.setTop(bannerPane);
        
       
        
         ObservableList<String> names = FXCollections.observableArrayList(
          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        ListView list = new ListView(names);
        
        list.setMinSize(200,200);
        list.setMaxSize(525,425);
        

        ObservableList<String> languageChoices1 = FXCollections.observableArrayList();
        languageChoices1.add("None");
        languageChoices1.add("Numbered");
        languageChoices1.add("Unordered");
   
        
        Label label1 = new Label("Select Font");
     
        ComboBox combo1 = new ComboBox(languageChoices1);
        combo1.setValue("None");
        
            
        GridPane gridPane1 = new GridPane();
	gridPane1.add(combo1, 0, 0, 2, 1);
        gridPane1.add(label1,0,1,1,1);
        
        
         
        BorderPane layout1 = new BorderPane();
        layout1.setLeft(list);
        layout1.setBottom(combo1);
        
        portFolioEditorPane.getChildren().addAll(new Label("Banner: "),banner);
        
        
        
        bannerAddButton = makerView.initChildButton(banner, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        bannerRemoveButton = makerView.initChildButton(banner, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        
        bannerPane.getChildren().add(bannerAddButton);
        bannerPane.getChildren().add(bannerRemoveButton);
        
        
        bannerAddButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    
     
        
        
        //******************************************************* workspace component ******************************************************
        
        
        // Heading
        
        FlowPane heading = new FlowPane();
        TextField headerTextField = new TextField();
        heading.getChildren().add(headerTextField);
        
        portFolioEditorPane.getChildren().addAll(new Label("Header: "), heading);
        
      
        
        // Paragraph
        BorderPane paragraph = new BorderPane();
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
        
        GridPane grid = new GridPane();
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
        
        
        
        layoutOneButton = makerView.initChildButton(imageButton, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = makerView.initChildButton(imageButton, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = makerView.initChildButton(imageButton, ICON_PREVIOUS,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = makerView.initChildButton(imageButton, ICON_NEXT,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        
        layoutOneButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
        
        imageButton.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);
        imageButton.getStyleClass().add(CSS_CLASS_FONT);
        
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
        
        
        layoutOneButton = makerView.initChildButton(videoButton, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = makerView.initChildButton(videoButton, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = makerView.initChildButton(videoButton, ICON_PLAY,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = makerView.initChildButton(videoButton, ICON_PAUSE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
     
        
         layoutOneButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         videoButton.getStyleClass().add(CSS_CLASS_VERTICAL_TOOLBAR_BUTTON);
        videoButton.getStyleClass().add(CSS_CLASS_FONT);
        
        
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
        
        layoutOneButton = makerView.initChildButton(slideshowToolBar, ICON_ADD_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutTwoButton = makerView.initChildButton(slideshowToolBar, ICON_REMOVE_SLIDE,TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutThreeButton = makerView.initChildButton(slideshowToolBar, ICON_MOVE_UP,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
        layoutFourButton = makerView.initChildButton(slideshowToolBar, ICON_MOVE_DOWN,	TOOLTIP_NEW_SLIDE_SHOW,	CSS_CLASS_VERTICAL_TOOLBAR_BUTTON, false);
       
        
         layoutOneButton.setOnAction(e->{
            try {
                viewer.imageEPortFolio();
            } catch (MalformedURLException ex) {
                Logger.getLogger(EPortFolioMakerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         
        slideshow.setCenter(slideshowImage);
        
        slideshow.setLeft(slideshowToolBar);

        
        
        portFolioEditorPane.getChildren().addAll(new Label("Paragraph: "), paragraph);
        
        
        portFolioEditorPane.getChildren().addAll(new Label("List: "), layout1);
       
        
        portFolioEditorPane.getChildren().addAll(new Label("Images: "), images);
        
        
        portFolioEditorPane.getChildren().addAll(new Label("Video: "), video);
        
        
        portFolioEditorPane.getChildren().addAll(new Label("Slideshow: "), slideshow);
        
        
        initTitleControls();
        
        workspace.setTop(titlePane);
        workspace.setBottom(footerPane);
        workspace.setLeft(portFolioEditToolbar);
	workspace.setCenter(portFolioEditorScrollPane);
        
  
    }
    
        private void initTitleControls() {
         
	PropertiesManager props = PropertiesManager.getPropertiesManager();
        Text titleText = new Text(30,30,"Title: ");
        Text nameText = new Text(30,30,"Name: ");
        Text footerText = new Text(30,30,"Footer: ");
        Text fontText = new Text(30,30,"Select Font: ");
        Text colorText = new Text(30,30,"Select Color: ");
        
        titleText.setFont(new Font("Arial", 30));
        nameText.setFont(new Font("Arial", 30));
        footerText.setFont(new Font("Arial", 30));
        fontText.setFont(new Font("Arial", 30));
        colorText.setFont(new Font("Arial", 30));
        
        
	String labelPrompt = props.getProperty(LABEL_SLIDESHOW_TITLE);
	
        ObservableList<String> languageChoices = FXCollections.observableArrayList();
        languageChoices.add("Times New Roman");
        languageChoices.add("Roboto");
        languageChoices.add("Ubuntu");
        languageChoices.add("Lato");
        languageChoices.add("Indie Flower");
        
        Label label = new Label("Select Font");
     
        ComboBox combo = new ComboBox(languageChoices);
        combo.setValue("Indie Flower");
            
        GridPane gridPane = new GridPane();
	gridPane.add(combo, 0, 0, 2, 1);
        gridPane.add(label,0,1,1,1);
        
        
        ObservableList<String> colorChoices = FXCollections.observableArrayList();
        colorChoices.add("Blue");
        colorChoices.add("Red");
        colorChoices.add("Gold");
        colorChoices.add("Green");
        colorChoices.add("Black");
        
     
        ComboBox colorCombo = new ComboBox(colorChoices);
        colorCombo.setValue("Blue");
            
        GridPane colorGrid = new GridPane();
	colorGrid.add(colorCombo, 0, 0, 2, 1);
        colorGrid.add(label,0,1,1,1);
        
        
        titlePane = new BorderPane();
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
       
      
        footerPane.getChildren().add(footerText);
	footerPane.getChildren().add(titleTextField3);
        footerPane.getChildren().add(compCombo);
	
        titlePane.setLeft(title);
        titlePane.setCenter(fontName);
        
        titlePane.setRight(name);
	titlePane.getStyleClass().add(CSS_CLASS_TITLE_PANE);
	titleLabel.getStyleClass().add(CSS_CLASS_TITLE_PROMPT);
	titleTextField.getStyleClass().add(CSS_CLASS_TITLE_TEXT_FIELD);
    }
    
}


