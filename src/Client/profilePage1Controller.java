package Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Movahed on 6/23/2017.
 */
public class profilePage1Controller implements Initializable{




    @FXML
    private Circle profilePicture;
    @FXML
    private Label fullName;
    @FXML
    private Label biography;
    @FXML
    private Label followingNum;
    @FXML
    private Label followerNum;
    @FXML
    private Label postNum;
    @FXML
    private Label username;

    public void goToProfile1() throws IOException, ClassNotFoundException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("profilePage1.fxml")));
        scene.getStylesheets().add("Stylesheet/style.css");
        ClientUI.sceneChanger(scene, "Set ProfilePicture");
        Client.clientOutputStream.writeUTF("Profile1");
        Client.clientOutputStream.flush();
        Client.refreshOwner();
    }
    public void goToProfile2() throws IOException, ClassNotFoundException
    {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("profilePage2.fxml")));
        scene.getStylesheets().add("Stylesheet/style.css");
        ClientUI.sceneChanger(scene, "Set ProfilePicture");
        Client.clientOutputStream.writeUTF("Profile2");
        Client.clientOutputStream.flush();
        Client.refreshOwner();
        profilePicture.setFill(new ImagePattern(new Image(Client.profileOwner.profilePicture.getAbsolutePath())));
        fullName.setText(Client.profileOwner.fullName);
        biography.setText(Client.profileOwner.biography);
        followerNum.setText(Integer.toString(Client.profileOwner.followers.size()));
        followingNum.setText(Integer.toString(Client.profileOwner.following.size()));
        postNum.setText(Integer.toString(Client.profileOwner.posts.size()));
        username.setText(Client.profileOwner.username);
    }

    public void goToHome() throws IOException, ClassNotFoundException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("homePage.fxml")));
        scene.getStylesheets().add("Stylesheet/style.css");
        ClientUI.sceneChanger(scene, "Set ProfilePicture");
        Client.clientOutputStream.writeUTF("Home");
        Client.clientOutputStream.flush();
        Client.refreshOwner();


    }

    public void goToSearch() throws IOException, ClassNotFoundException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("searchPage.fxml")));
        scene.getStylesheets().add("Stylesheet/style.css");
        ClientUI.sceneChanger(scene, "Search");
        Client.clientOutputStream.writeUTF("Search");
        Client.clientOutputStream.flush();
        Client.refreshOwner();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        profilePicture.setFill(new ImagePattern(new Image(Client.profileOwner.profilePicture.toURI().toString())));
        fullName.setText(Client.profileOwner.fullName);
        biography.setText(Client.profileOwner.biography);
        followerNum.setText(Integer.toString(Client.profileOwner.followers.size()));
        followingNum.setText(Integer.toString(Client.profileOwner.following.size()));
        postNum.setText(Integer.toString(Client.profileOwner.posts.size()));
        username.setText(Client.profileOwner.username);
    }
}
