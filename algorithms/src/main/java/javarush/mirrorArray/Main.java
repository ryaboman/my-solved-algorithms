package javarush.mirrorArray;

public class Main {
    private static final int SIDE = 4;
    private static int[][] gameField = {{12,2,7,2}, {4,4,4,18}, {8,10,8,8}, {0,0,0,0}};

    public static void main(String[] args) {
        System.out.println("До поворота:");
        printArray(gameField);
        rotateClockwise();
        System.out.println("После поворота:");
        printArray(gameField);
    }

    private static void mirrorArray() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE-1-x; y++) {
                int tmpValue = gameField[x][y];
                gameField[x][y] = gameField[SIDE-1-y][SIDE-1-x];
                gameField[SIDE-1-y][SIDE-1-x] = tmpValue;
            }
        }
    }

    private static void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                result[x][SIDE-1-y] = gameField[y][x];
            }
        }
        gameField = result;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
