package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class Controller {

    private double bmrCalories;
    private double calories;

    @FXML
    private TextField ageInput;
    @FXML
    private TextField weightInput;
    @FXML
    private TextField heightInput;
    @FXML
    private ChoiceBox<String> genderInput;
    @FXML
    private ChoiceBox<String> activityLevelInput;
    @FXML
    private TextArea resultTextArea;

    public void initialize() {
        ObservableList<String> genderChoice = FXCollections.observableArrayList("Male", "Female");
        ObservableList<String> levels = FXCollections.observableArrayList("Little", "Light", "Medium", "Hard", "Intense");
        genderInput.setItems(genderChoice);
        activityLevelInput.setItems(levels);
    }

    public void calculateButtonClicked() {
        System.out.println("Calculating");
        int age = Integer.parseInt(ageInput.getText());
        double weight = Double.parseDouble(weightInput.getText());
        double height = Double.parseDouble(heightInput.getText());

        //Determine BMR
        if (genderInput.getSelectionModel().getSelectedItem().equals("Male")) {
            bmrCalories = 66 + (6.23 * weight) + (12.7 * height * 12) - (6.76 * age);
        }else {
            bmrCalories = 65.5 + (4.35 * weight) + (4.7 * height * 12) - (4.7 * age);
        }

        //Determine Calories from activity level
        String activityLevelChoice = activityLevelInput.getSelectionModel().getSelectedItem();
        if (activityLevelChoice.equals("Little")) {
            calories = bmrCalories * 1.2;
        }else if (activityLevelChoice.equals("Light")) {
            calories = bmrCalories * 1.375;
        }else if (activityLevelChoice.equals("Medium")) {
            calories = bmrCalories * 1.55;
        }else if (activityLevelChoice.equals("Hard")) {
            calories = bmrCalories * 1.725;
        }else if (activityLevelChoice.equals("Intense")) {
            calories = bmrCalories * 1.9;
        }

        resultTextArea.setText("Calories: " + Math.round(calories));
    }

}
