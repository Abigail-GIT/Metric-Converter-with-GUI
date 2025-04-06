import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MetricConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter a value");

        ComboBox<String> conversionBox = new ComboBox<>();
        conversionBox.getItems().addAll(
                "Centimeters to Inches",
                "Meters to Feet",
                "Kilometers to Miles",
                "Kilograms to Pounds"
        );
        conversionBox.setValue("Centimeters to Inches");

        Button convertButton = new Button("Convert");

        Label resultLabel = new Label();

        convertButton.setOnAction(e -> {
            try {
                double inputValue = Double.parseDouble(inputField.getText());
                String selectedConversion = conversionBox.getValue();
                double result = 0;
                String unit = "";

                switch (selectedConversion) {
                    case "Centimeters to Inches":
                        result = inputValue * 0.393701;
                        unit = "inches";
                        break;
                    case "Meters to Feet":
                        result = inputValue * 3.28084;
                        unit = "feet";
                        break;
                    case "Kilometers to Miles":
                        result = inputValue * 0.621371;
                        unit = "miles";
                        break;
                    case "Kilograms to Pounds":
                        result = inputValue * 2.20462;
                        unit = "pounds";
                        break;
                }

                resultLabel.setText(String.format("%.2f %s = %.2f %s", inputValue, selectedConversion.split(" ")[0], result, unit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        });

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        layout.getChildren().addAll(
                new Label("Metric Converter"),
                inputField,
                conversionBox,
                convertButton,
                resultLabel
        );

        Scene scene = new Scene(layout, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
