package sample;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.io.*;
import java.util.ArrayList;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView<DefaultMember> tableOfGymMemList = new TableView<DefaultMember>();
        ObservableList<DefaultMember> dataList;{
            dataList = FXCollections.observableArrayList(MyGymManager.listOfMembers);
        }

        Scene gymManagement = new Scene(new Group());   // set a new scene
        stage.setTitle("Gym Member List");      // set the name of the application
        stage.setWidth(1100);                   // set the width of the stage
        stage.setHeight(600);                   // set the height of the stage

        final Label label = new Label("Gym Member List");
        label.setFont(new Font("Arial", 20));

        tableOfGymMemList.setEditable(true);

        // create columns,set headings of the columns, give id to the each column and set the width of each column

        // create membership no column
        TableColumn membershipNoCol = new TableColumn("Membership No");
        membershipNoCol.setMinWidth(200);
        membershipNoCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("membershipNo"));

        // create full name column
        TableColumn fullNameCol = new TableColumn("Full Name");
        fullNameCol.setMinWidth(200);
        fullNameCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("fullName"));

        // create start membership date column
        TableColumn startMembershipNoCol = new TableColumn("Start Membership Date");
        startMembershipNoCol.setMinWidth(200);
        startMembershipNoCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("startMembershipDate"));

        // create contact no column
        TableColumn contactNoCol = new TableColumn("Contact No");
        contactNoCol.setMinWidth(200);
        contactNoCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("memContactNo"));

        // create member height column
        TableColumn memHeightCol = new TableColumn("Height (cm)");
        memHeightCol.setMinWidth(100);
        memHeightCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("memHeight"));

        // create member weight column
        TableColumn memWeightCol = new TableColumn("Weight (kg)");
        memWeightCol.setMinWidth(100);
        memWeightCol.setCellValueFactory(
                new PropertyValueFactory<DefaultMember, String>("memWeight"));


        //Pass the data of the array to a filtered list
        FilteredList<DefaultMember> filteredList = new FilteredList(dataList, p -> true);
        tableOfGymMemList.setItems(filteredList);
        tableOfGymMemList.getColumns().addAll(membershipNoCol, fullNameCol, startMembershipNoCol, contactNoCol, memHeightCol, memWeightCol);

        // add the items of check box
        ChoiceBox<String> choiceBox = new ChoiceBox();
        choiceBox.getItems().addAll("Membership No", "Full Name");
        choiceBox.setValue("First Name");

        TextField textField = new TextField();
        textField.setPromptText("Search items here ");
        // switch the values of the check box
        textField.setOnKeyReleased(keyEvent -> {
            switch (choiceBox.getValue()) {
                // set membership no as an item of the check box
                case "Membership No":
                    filteredList.setPredicate(p -> p.getMembershipNo().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
                // set full name as an item of the check box
                case "Full Name":
                    filteredList.setPredicate(p -> p.getFullName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                    break;
            }
        });

        // reset the checkbox and textfeild when the user input a new value
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                textField.setText("");
                filteredList.setPredicate(null);
            }
        });
        //add textField and choiceBox to a hBox
        HBox hBoxGymManagement = new HBox(choiceBox, textField);
        hBoxGymManagement.setAlignment(Pos.CENTER);         // set the hbox position to be center

        // add a vbox
        final VBox vboxGymManagement = new VBox();
        vboxGymManagement.setSpacing(5);
        vboxGymManagement.setPadding(new Insets(10, 0, 0, 10));
        // add chilren to the vbox
        vboxGymManagement.getChildren().addAll(label, tableOfGymMemList, hBoxGymManagement);
        ((Group) gymManagement.getRoot()).getChildren().addAll(vboxGymManagement);

        stage.setScene(gymManagement);
        stage.show();
    }

    // read the data of the array list
    public ArrayList<DefaultMember> readMemList (){
        ArrayList<DefaultMember> defaultMemberArrList = new ArrayList<DefaultMember>();
        try {
            FileInputStream readFileData = new FileInputStream("GymMemberDetails.txt");   // read the data from text file
            ObjectInputStream readStreamGymManagement = null;

            boolean check = true;
            while (check){
                try {
                    readStreamGymManagement = new ObjectInputStream(readFileData);


                } catch (EOFException ex) {
                    check = false;
                }
            }
            readStreamGymManagement .close();
            System.out.println(defaultMemberArrList.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return defaultMemberArrList;
        }
    }
}

