package presentation;

import domain.GameOfLife;
import domain.Simulation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MainController {

    @FXML
    public Canvas canvas;
    @FXML
    public ToggleGroup simulationTypeRadio;
    @FXML
    public RadioButton radioButtonGameOfLife;
    @FXML
    public RadioButton radioButton2;
    @FXML
    public RadioButton radioButton3;
    @FXML
    public TextField simSize;
    @FXML
    public Button sizeButton;

    public GraphicsContext graphicsContext;
    public Simulation simulation;

    public static final int defaultSimWidth = 20;
    public static final int defaultSimHeight = 20;

    public int cellSize;



    @FXML
    public void initialize() {
        canvas.setHeight(500);
        canvas.setWidth(500);
        graphicsContext = canvas.getGraphicsContext2D();

        simulationTypeRadio.selectedToggleProperty().addListener((observable, oldValue, newValue) -> onToggleGroupChange());
        onToggleGroupChange();

        cellSize = (int) (canvas.getWidth() / simulation.getWidth());

        drawNewGrid();
    }

    public void drawNewGrid() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphicsContext.setLineWidth(1);
        graphicsContext.setStroke(Color.DARKGRAY);
        for (int i = 0; i <= simulation.getWidth(); i++) {
            graphicsContext.strokeLine(cellSize * i, 0, cellSize * i, canvas.getHeight());
        }

        for (int i = 0; i <= simulation.getHeight(); i++) {
            graphicsContext.strokeLine(cellSize * i, 0, cellSize * i, canvas.getHeight());
            graphicsContext.strokeLine(0, cellSize * i, canvas.getWidth(), cellSize * i);
        }

        for (int y = 0; y < simulation.getHeight(); y++) {
            for (int x = 0; x < simulation.getWidth(); x++) {
                if (simulation.isCellAlive(x, y)) {
                    graphicsContext.setFill(Color.WHITE);
                    graphicsContext.fillRect(x * cellSize + 1, y * cellSize + 1, cellSize - 2, cellSize - 2);
                }
            }
        }
    }

    public void onToggleGroupChange() {
        if (radioButtonGameOfLife.isSelected()) {
            simulation = new GameOfLife(defaultSimWidth, defaultSimHeight);
        }
        else if (radioButton2.isSelected()) {
            simulation = null;
        }
        else {
            simulation = null;
        }
    }

    public void toggleCell(MouseEvent mouseEvent) {

    }

    public void changeSize(ActionEvent actionEvent) {
        int widthAndHeight;
        try {
            widthAndHeight = Integer.parseInt(simSize.getText());
            simulation.setWidth(widthAndHeight);
            simulation.setHeight(widthAndHeight);
            cellSize = (int) (canvas.getWidth() / simulation.getWidth());
            drawNewGrid();
        } catch (NumberFormatException e) {
            System.out.println("Idiot, use ints");
        }
    }
}
