package domain;

public abstract class Simulation {
    private int width;
    private int height;
    private boolean[][] grid;

    Simulation (int width, int height) {
        this.width = width;
        this.height = height;

        // First array is height, because in a nested for loop, I will draw the first inner array on one line,
        // then the next inner array on the next line, and so on.
        this.grid = new boolean[this.height][this.width];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public abstract void step();

    public void setPointTrue(int x, int y) {
        grid[y][x] = true;
    }

    public void setPointFalse(int x, int y) {
        grid[y][x] = false;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        boolean[][] tempGrid = new boolean[this.height][width];

        // Nested for loop going through the original grid, and copying the points to the new grid.
        // All other points should be false.

    }

    public void setWHeight(int height) {
        boolean[][] tempGrid = new boolean[height][this.width];

        // Nested for loop going through the original grid, and copying the points to the new grid.
        // All other points should be false.

    }


}
