package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.bo.BOFactory;
import lk.ijse.hostel.bo.BOType;
import lk.ijse.hostel.bo.custom.LogInBO;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.util.ValidationUtil;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

import static javafx.scene.paint.Color.RED;

public class LoginFormController {
    public AnchorPane apnMain;
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public JFXTextField txtPassword;
    public JFXButton btnLog;
    public FontAwesomeIconView icnEye;

    private final LogInBO logInBO= (LogInBO) BOFactory.getInstance().getBOType(BOType.LOGIN);
    public Label lblUserName;
    public Label lblPassword;

    LinkedHashMap<JFXTextField, Pattern> map = new LinkedHashMap<>();
    Pattern usernamePattern = Pattern.compile("^[A-z0-9]{3,10}$");
    LinkedHashMap<JFXPasswordField, Pattern> map1 = new LinkedHashMap<>();
    Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$");


    public void initialize(){
        txtPassword.setVisible(false);

        //copy values for passwordField
        txtPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            pwdPassword.setText(newValue);
        });

        storeValidation();
    }
    private void storeValidation() {
        map.put(txtUsername, usernamePattern);
        map1.put(pwdPassword, passwordPattern);
    }

   /* public void lordWindow() throws IOException {

        Stage stage = (Stage) apnMain.getScene().getWindow();
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/lk/d24/hostel/view/HomeForm.fxml"));

        Parent root1 = loader1.load();
        Scene scene1 = new Scene(root1);

        stage.setScene(scene1);

        HomeFormController controller = loader1.getController();
        controller.getAllData(txtUsername.getText(),pwdPassword.getText());

        stage.centerOnScreen();

    }*/

    public void textFieldValidationOnAction(KeyEvent keyEvent) {
        Object response = ValidationUtil.validateJFXTextFields(map, btnLog);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof JFXTextField) {
                JFXTextField errorText = (JFXTextField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {

            }
        }
    }

    public void passwordFieldValidationOnAction(KeyEvent keyEvent) {
/*
        Object response = ValidationUtil.validateJFXPasswordField(map1, btnLog);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (response instanceof JFXPasswordField) {
                JFXPasswordField errorText = (JFXPasswordField) response;
                errorText.requestFocus();
            } else if (response instanceof Boolean) {

            }
        }
*/

    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
    /*    URL resource = getClass().getResource("/lk/ijse/hostel/view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();*/
        String password = txtPassword.getText();
        String userName = txtUsername.getText();
        String pswdFildPassword = pwdPassword.getText();
        clearAll();
        try{
            UserDTO user = logInBO.getUser(userName);
            if (password.equals(user.getPassword()) || pswdFildPassword.equals(user.getPassword())) {
                if (userName.equals(user.getUserName())) {
                    Stage stage = (Stage) apnMain.getScene().getWindow();
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostel/view/DashboardForm.fxml"))));
                    stage.centerOnScreen();
                }else {
                    txtUsername.requestFocus();
                    txtUsername.setFocusColor(RED);
                    txtUsername.setText("Username does not match");
                }
            }else {
                txtPassword.requestFocus();
                txtPassword.setFocusColor(RED);
                pwdPassword.requestFocus();
                pwdPassword.setFocusColor(RED);
                lblPassword.setText("Password does not match");
            }
        }catch (Exception e){
            txtUsername.requestFocus();
            txtUsername.setFocusColor(RED);
            lblUserName.setText("Username does not match");
        }

    }

    private void clearAll(){
        lblPassword.setText("");
        lblUserName.setText("");
    }
    public void eyeClickOnAction(MouseEvent mouseEvent) {
        if(icnEye.getGlyphName().equals("EYE_SLASH")){ // must show password
            icnEye.setGlyphName("EYE");

            txtPassword.setText(pwdPassword.getText()); //copy PwdPassword data to  txtPW
            pwdPassword.setVisible(false);  //PWField hidden
            txtPassword.setVisible(true);   //txtField Shown

        }else if(icnEye.getGlyphName().equals("EYE")){  // must hide  password
            icnEye.setGlyphName("EYE_SLASH");

            pwdPassword.setText(txtPassword.getText());
            txtPassword.setVisible(false); //txtField hide
            pwdPassword.setVisible(true);  //PWField shown

        }
    }


}
