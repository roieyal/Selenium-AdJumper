package ui;
import common.Pane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by eyal on 29/11/2016.
 */
public class MainWindow extends Pane {

    private WebDriver driver;
//    private ProjectsPanel projectsPanel;
    private By window = By.xpath(".//html/body");
    private LoginArea loginArea;
    private PersonalAreaPage personalAreaPage;

    public MainWindow(WebDriver driver){
        this.driver=driver;
//        this.projectsPanel = new ProjectsPanel(driver);
    }

}
