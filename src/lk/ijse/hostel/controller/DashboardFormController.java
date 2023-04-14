package lk.ijse.hostel.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashboardFormController {

    public Label lblDate;
    public Label lblTime;
    public AnchorPane home;
    public VBox NameSideAnchorPane;

    public void initialize(){
        loadDateAndTime();

        NameSideAnchorPane.setVisible(false);

     /*   txtNewPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            pwdPassword.setText(newValue);
        });

        txtUserName.setEditable(false);*/
    }

    private void loadDateAndTime() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour()+":"+currentTime.getMinute()+":"+currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void NameSideOnAction(MouseEvent mouseEvent) {
        NameSideAnchorPane.setVisible(true);
    }

    public void imgDashBoardOnAction(MouseEvent mouseEvent) {
        NameSideAnchorPane.setVisible(true);
    }

    public void btnRegistration(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.REGISTRATION,home);
    }

    public void btnStudents(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.MANAGE_STUDENTS,home);
    }

    public void btnRooms(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.MANAGE_ROOMS,home);
    }

    public void btnPaymentDetails(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.PAYMENT_DETAILS,home);
    }

    public void btnSettings(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.SETTING,home);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
            Navigation.navigate(Routes.LOGOUT,home);

    }

}
