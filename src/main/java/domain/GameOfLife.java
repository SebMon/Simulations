package domain;

public class GameOfLife extends Simulation {
    boolean[][] temporaryGrid;

    GameOfLife(int width, int height) {
        super(width, height);
    }

    @Override
    public void step() {
        //TODO Implement game of life rules.
        // - Any live cell with fewer than two neighbours dies
        // - Any live cell with more than three neighbours dies
        // - Any live cell with two or three neighbours lives
        // - Any dead cell with exactly three live neighbours lives
        // - Borders should be considered dead cells (maybe implement wrap around later)

    }

    public boolean evaluateLiveCell(int x, int y) {
        return false;
    }

    public boolean evaluateDeadCell(int x, int y) {
        return false;
    }

    public static void main(String[] args) {
        Simulation gameOfLife = new GameOfLife(10, 5);

        gameOfLife.setPointTrue(2, 1);
        gameOfLife.setPointTrue(8, 3);
        gameOfLife.setWidth(8);
        gameOfLife.setPointTrue(7, 3);
        gameOfLife.setWidth(10);
        gameOfLife.printGrid();
    }
}
