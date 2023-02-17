package packageGUI;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Scene1 {
	private Stage Window;

	private Label Headline;
	
	private Scene DefaultScene,NewsScene, WeatherScene;
	
	
	public void start(Stage stage) throws Exception{
		Window = stage;
		Headline = new Label("The Daily Reporter");
		Button NewsPage = new Button("News");
		Button WeatherPage = new Button("Weather");
		
		//Button Action
		NewsPage.setOnAction(e -> Window.setScene(NewsScene));
		WeatherPage.setOnAction(e -> Window.setScene(WeatherScene));
		
		
		//Setting up Page 1
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(Headline, NewsPage, WeatherPage);
		layout1.setAlignment(Pos.CENTER);
		DefaultScene = new Scene(layout1, 300, 300);
		
		Text text = new Text("Coming soon");
		text.setTextOrigin(VPos.CENTER);
		
		//Back Button
		Button back1 = new Button("Back");
		back1.setOnAction(e -> Window.setScene(DefaultScene));
		
		Button back2 = new Button("Back");
		back2.setOnAction(e -> Window.setScene(DefaultScene));
		
		//Setting up NewsPage
		VBox layout2 = new VBox(20);
		layout2.getChildren().add(back1);
		layout2.getChildren().add(text);
		NewsScene = new Scene(layout2, 600, 600);
		
		//Setting up WeatherPage
		VBox layout3 = new VBox(20);
		layout3.getChildren().add(back2);
		WeatherScene = new Scene(layout3, 600, 600);
		
		Window.setScene(DefaultScene);
		Window.show();
	}

}
