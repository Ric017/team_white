package FunnyCalculator;

// By Team White (Trent, Brayden, & Eric)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StartupAccumulatorCalculator_JavaFX extends Application {

	private TextField txtOutput = new TextField();
	private TextField txtFace = new TextField();
	private float inputValue;
	private Calculator calculator = new Calculator();
	private Face face = new Face();

	public static void main(String[] args) {
		launch(args);
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene by calling the getPane() method and place it in the stage
		Scene scene = new Scene(getPane(), 200, 250);
		primaryStage.setTitle("Fun Calculator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

  /**
   * getPane() returns a pane to be used with the scene of this calculator.
   * In this method, you will need to generate the GUI of this calculator. Use different kinds of panes for alignment
   * This method will also implement the event handlers for each button press. You may elect to divide the load among multiple methods if you prefer.
   */

	protected BorderPane getPane() {
	    BorderPane mainPane = new BorderPane();
	    mainPane.setPadding(new Insets(10)); // Padding for the pane.
	    GridPane gridPane = new GridPane(); // GridPane for laying out buttons
	    gridPane.setAlignment(Pos.CENTER); // Set alignment of the grid to center
	    gridPane.setHgap(10); // Set horizontal gap
	    gridPane.setVgap(10); // Set Vertical gap

	    // Create number buttons 0-9 and add them to the grid
	    // Traditional calculator layout: numbers 1-9 arranged from top to bottom, left to right, with 0 at the bottom
	    int num = 1;
	    for (int row = 0; row < 3; row++) {
	        for (int col = 0; col < 3; col++) {
	            Button btn = new Button(String.valueOf(num));
	            btn.setOnAction(e -> {
	                inputValue = Float.parseFloat(btn.getText());
	                txtOutput.setText(Float.toString(inputValue)); // Show current input in txtOutput
	            });
	            gridPane.add(btn, col, row); // Add button in grid
	            num++;
	        }
	    }
	    Button zeroBtn = new Button("0");
	    zeroBtn.setOnAction(e -> {
	        inputValue = Float.parseFloat(zeroBtn.getText());
	        txtOutput.setText(Float.toString(inputValue)); // Show current input in txtOutput
	    });
	    gridPane.add(zeroBtn, 1, 3); // Zero button at the bottom center

	    // Operation buttons and their actions.
	    Button ButtonAdd = new Button("+");
	    ButtonAdd.setOnAction(e -> {
	        calculator.add(inputValue);
	        display(); //updates display
	    });

	    Button buttonSub = new Button("-");
	    buttonSub.setOnAction(e -> {
	        calculator.subtract(inputValue);
	        display();
	    });

	    Button buttonMult = new Button("*");
	    buttonMult.setOnAction(e -> {
	        calculator.multiply(inputValue);
	        display();
	    });

	    Button buttonDivide = new Button("/");
	    buttonDivide.setOnAction(e -> {
	        if (inputValue == 0) {
	            showErrorDialog();
	        } else {
	            calculator.divide(inputValue);
	            display();
	        }
	    });

	    // Clear calculator.
	    Button buttonClear = new Button("C");
	    buttonClear.setOnAction(e -> {
	        calculator.clearAccum(); // Clear calculator 
	        txtOutput.setText("");   // Clear display
	        txtFace.setText(":-)");  // Reset face
	    });

	    HBox operationBox = new HBox(10); // HBox for laying out operation buttons
	    operationBox.getChildren().addAll(ButtonAdd, buttonSub, buttonMult, buttonDivide, buttonClear);
	    operationBox.setAlignment(Pos.CENTER); // Make Buttons be center.

	    // Setup for width and position of face and output
	    txtOutput.setEditable(false);
	    txtOutput.setAlignment(Pos.CENTER_RIGHT); // Align numbers right
	    txtFace.setEditable(false);
	    txtFace.setAlignment(Pos.CENTER);
	    txtFace.setPrefWidth(45);
	    txtFace.setText(":-)");

	    // Set positions of operations 
	    mainPane.setTop(txtOutput);
	    mainPane.setCenter(gridPane);
	    mainPane.setBottom(operationBox);
	    mainPane.setRight(txtFace);

	    return mainPane;
	}

 /**
  * This method checks the accumulator value and by calling getAccumValue(). based on this value it either calls the 
  * face.makeHappy() or face.makeSad() and sets the face to happy/sad in txtFace
  * Will be called whenever one of the operation buttons is pressed
  */
	public void display() {
		float result = calculator.getAccumValue();
		txtOutput.setText(String.valueOf(result));
		if (result < 0) {
			face.makeSad();
			txtFace.setText(":-(");
		}
		else {
			face.makeHappy();
			txtFace.setText(":-)");
		}
	}

	// Error alert if user decides to divide by 0 
	private void showErrorDialog() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("You cannot divide by zero!");
		alert.showAndWait();
	}
}

class Calculator
{
    private float currentAccumValue;
    public Calculator (){
        currentAccumValue = 0.0f;
    }

    public void add(float inputValue){
        currentAccumValue+= inputValue;
    }

    public void subtract(float inputValue){
        currentAccumValue-= inputValue;
    }

    public void multiply(float inputValue){
        currentAccumValue*= inputValue;
    }

    public void divide(float inputValue){
        if(inputValue == 0) {
            // Push an alert to the user that they cannot divide by 0
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("You cannot divide by zero!");
            alert.showAndWait();
	  }
      else {
      	  currentAccumValue /= inputValue;
	  }
}

  public void clearAccum(){
      currentAccumValue = 0;
  }
  public float getAccumValue(){
      return currentAccumValue;
  }
}
//*********************************************************

class Face
{
    private boolean faceState;

    public Face(){
        makeHappy();
    }

    public void makeHappy(){
        faceState = true;
    }

    public void makeSad(){
        faceState = false;
    }

    public boolean getFaceState(){
        return faceState;
    }
}