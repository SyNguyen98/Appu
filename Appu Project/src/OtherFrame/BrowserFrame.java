package OtherFrame;

import java.awt.BorderLayout;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrowserFrame extends JFrame {
    private static JFXPanel javafxPanel;
    private static WebView webComponent;
    private static JPanel mainPanel;
    
    public BrowserFrame(String Url) {
        javafxPanel = new JFXPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);
        
        try {
            setIconImage(ImageIO.read(BrowserFrame.class.getResource("/Pictures/Icon.png")));
        } catch (IOException ex) {}
        setSize(800, 600);
        setLocationRelativeTo(null);
        add(mainPanel);

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
}