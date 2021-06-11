package domain;

public abstract class Simulation {
    private int width;
    private int height;
    private boolean[][] grid;

    protected Simulation (int width, int height) {
        this.width = width;
        this.height = height;

        // First array is height, because in a nested for loop, I will draw the first inner array on one line,
        // then the next inner array on the next line, and so on.
        this.grid = new boolean[this.height][this.width];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void setGrid(boolean[][] newGrid) {
        this.grid = newGrid;
    }

    public abstract void step();

    public void setPointTrue(int x, int y) throws ArrayIndexOutOfBoundsException {
        if (x > this.width - 1 | y > this.height - 1) {
            throw new ArrayIndexOutOfBoundsException("Point is outside grid.");
        }
        grid[y][x] = true;
    }

    public void setPointFalse(int x, int y) throws ArrayIndexOutOfBoundsException {
        if (x > this.width - 1 | y > this.height - 1) {
            throw new ArrayIndexOutOfBoundsException("Point is outside grid.");
        }
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

        if (width >= this.width) {
            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    tempGrid[y][x] = this.grid[y][x];
                }
            }
        }
        else {
            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < width; x++) {
                    tempGrid[y][x] = this.grid[y][x];
                }
            }
        }

        this.width = width;
        this.grid = tempGrid;
    }

    public void setHeight(int height) {
        boolean[][] tempGrid = new boolean[height][this.width];

        if (height >= this.height) {
            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    tempGrid[y][x] = this.grid[y][x];
                }
            }
        }
        else {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    tempGrid[y][x] = this.grid[y][x];
                }
            }
        }

        this.height = height;
        this.grid = tempGrid;
    }

    public void printGrid() {
        for (int y = 0; y < this.height; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = 0; x < this.width; x++) {
                stringBuilder.append(this.grid[y][x]).append(" ");
            }
            System.out.println(stringBuilder);
        }
    }
}
