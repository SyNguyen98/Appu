package Command;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WebFrame extends JFrame {
    private static JFXPanel javafxPanel;
    private static WebView webComponent;
    private static JPanel mainPanel;
    
    public WebFrame(String Url) {
        javafxPanel = new JFXPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,600);
        this.setLocationRelativeTo(null);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                BorderPane borderPane = new BorderPane();
                webComponent = new WebView();

                webComponent.getEngine().load(Url);

                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane,450,450);
                javafxPanel.setScene(scene);
            }
        });
    }
    public static void main(String [] args){
        JFrame mainFrame = new WebFrame("http://facebook.com/");
        mainFrame.setVisible(true);
    }
}