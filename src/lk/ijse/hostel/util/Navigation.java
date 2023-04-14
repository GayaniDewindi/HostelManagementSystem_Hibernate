package lk.ijse.hostel.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane anchorPane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.anchorPane = pane;
        Navigation.anchorPane.getChildren().clear();
        Stage window = (Stage) Navigation.anchorPane.getScene().getWindow();

        switch (route) {
            case MANAGE_ROOMS:
                window.setTitle("Manage Rooms Form");
                initUI("ManageRoomForm.fxml");
                break;
            case REGISTRATION:
                window.setTitle("Registration Form");
                initUI("RegistrationForm.fxml");
                break;
            case ADD_STUDENT:
                window.setTitle("Add Student Form");
                initUI("AddStudentForm.fxml");
                break;
            case MANAGE_STUDENTS:
                window.setTitle("Manage Customer Form");
                initUI("ManageStudentForm.fxml");
                break;
            case PAYMENT_DETAILS:
                window.setTitle("Payment Details Form");
                initUI("PaymentDetailsForm.fxml");
                break;
            case SETTING:
                window.setTitle("Setting Form");
                initUI("SettingForm.fxml");
                break;
            case LOGOUT:
                initUI("LoginForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.anchorPane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hostel/view/" + location)));
    }
}
