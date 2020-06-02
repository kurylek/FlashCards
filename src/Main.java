import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.Optional;


public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    private Scene scMenu, scPreview, scGame;
    private TableView<FlashCardsSet> tvFlashCardsSets;

    @Override
    public void start(Stage stage) throws Exception{
        GridPane gpMenu = new GridPane();

        TableColumn<FlashCardsSet, String> tcName = new TableColumn<>("Name");
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<FlashCardsSet, String> tcDescription = new TableColumn<>("Description");
        tcDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<FlashCardsSet, Integer> tcCount = new TableColumn<>("Count");
        tcCount.setCellValueFactory(new PropertyValueFactory<>("count"));

        tvFlashCardsSets = new TableView();
        tvFlashCardsSets.setItems(flashCardsSets());
        tvFlashCardsSets.getColumns().addAll(tcName, tcDescription, tcCount);

        gpMenu.add(tvFlashCardsSets, 0 ,0, 5, 1);


        Button bCreate = new Button("Create");
        bCreate.setOnAction(e -> addNewSet());
        gpMenu.add(bCreate, 0, 1);

        Button bDelete = new Button("Delete");
        bDelete.setOnAction(e -> {
            FlashCardsSet selected = tvFlashCardsSets.getSelectionModel().getSelectedItem();
            if(selected != null)
                deleteSet(selected);
        });
        gpMenu.add(bDelete, 1, 1);

        Button bEdit = new Button("Edit");
        bEdit.setOnAction(e -> editSet());
        gpMenu.add(bEdit, 2, 1);

        Button bPreview = new Button("Preview");
        bPreview.setOnAction(e -> previewSet());
        gpMenu.add(bPreview, 3, 1);

        Button bStart = new Button("Start");
        bStart.setOnAction(e -> startSet());
        gpMenu.add(bStart, 4, 1);


        scMenu= new Scene(gpMenu);
        stage.setScene(scMenu);
        stage.show();
    }

    public ObservableList<FlashCardsSet> flashCardsSets(){
        ObservableList<FlashCardsSet> flashCardsSets = FXCollections.observableArrayList();
        flashCardsSets.add(new FlashCardsSet("A","Aa"));
        flashCardsSets.add(new FlashCardsSet("B","Bb"));
        return flashCardsSets;
    }


    private void addNewSet(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add new Flash Card set");
        dialog.setHeaderText(null);

        ButtonType bAdd = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(bAdd, ButtonType.CANCEL);

        GridPane gpDialog = new GridPane();

        TextField tfName = new TextField();
        TextField tfDescription = new TextField();

        gpDialog.add(new Label("Name:"), 0, 0);
        gpDialog.add(tfName, 1, 0);
        gpDialog.add(new Label("Description:"), 0, 1);
        gpDialog.add(tfDescription, 1, 1);

        Node addButton = dialog.getDialogPane().lookupButton(bAdd);
        addButton.setDisable(true);

        tfName.textProperty().addListener((observable, oldValue, newValue) -> {
            addButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(gpDialog);

        dialog.setResultConverter(dialogButton -> {
            if(dialogButton == bAdd){
                FlashCardsSet newSet;
                if(tfDescription.getLength() > 0){
                    newSet = new FlashCardsSet(tfName.getText(), tfDescription.getText());
                }else{
                    newSet = new FlashCardsSet(tfName.getText());
                }

                tvFlashCardsSets.getItems().add(newSet);
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });
    }

    private void deleteSet(FlashCardsSet set){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Flash Cards Set");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to delete this set: "+set.getName()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            tvFlashCardsSets.getItems().remove(set);
        }
    }

    private void editSet(){

    }

    private void previewSet(){

    }

    private void startSet(){

    }
}
