package domain;

public class GameOfLife extends Simulation {
    private boolean[][] temporaryGrid;
    private final int[] neighbourX;
    private final int[] neighbourY;
    // x - 1, y - 1
    // x    , y - 1
    // x + 1, y - 1
    // x - 1, y
    // x + 1, y
    // x - 1, y + 1
    // x    , y + 1
    // x + 1, y + 1

    public GameOfLife(int width, int height) {
        super(width, height);
        this.neighbourX = new int[]{-1,  0,  1, -1,  1, -1,  0,  1};
        this.neighbourY = new int[]{-1, -1, -1,  0,  0,  1,  1,  1};
    }

    @Override
    public void step() {
        //TODO Implement game of life rules.
        // - Borders should be considered dead cells (maybe implement wrap around later)

        temporaryGrid = new boolean[this.getHeight()][this.getWidth()];

        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (this.getGrid()[y][x]) {
                    this.temporaryGrid[y][x] = evaluateLiveCell(x, y);
                }
                else {
                    this.temporaryGrid[y][x] = evaluateDeadCell(x, y);
                }
            }
        }
        this.setGrid(temporaryGrid);
    }

    public boolean evaluateLiveCell(int x, int y) {
        // - Any live cell with fewer than two neighbours dies
        // - Any live cell with more than three neighbours dies
        // - Any live cell with two or three neighbours lives

        int liveNeighbours = 0;
        for (int i = 0; i < neighbourY.length; i++) {
            try {
                if (this.getGrid()[y + neighbourY[i]][x + neighbourX[i]]) {
                    liveNeighbours++;
                }
            }
            catch (IndexOutOfBoundsException ignored) {
            }
        }
        if (liveNeighbours < 2) {
            return false;
        }
        else return liveNeighbours <= 3;
    }

    public boolean evaluateDeadCell(int x, int y) {
        // - Any dead cell with exactly three live neighbours lives

        int liveNeighbours = 0;
        for (int i = 0; i < neighbourY.length; i++) {
            try {
                if (this.getGrid()[y + neighbourY[i]][x + neighbourX[i]]) {
                    liveNeighbours++;
                }
            }
            catch (IndexOutOfBoundsException ignored) {
            }
        }

        return liveNeighbours == 3;
    }

    /*
    public static void main(String[] args) {
        Simulation gameOfLife = new GameOfLife(10, 10);

        gameOfLife.setPointTrue(2, 2);
        gameOfLife.setPointTrue(3, 2);
        gameOfLife.setPointTrue(2, 3);
        gameOfLife.printGrid();
        System.out.println();
        gameOfLife.step();
        gameOfLife.printGrid();



    }

     */
}
