package ru.ryaboman.algorithms.binominalCoefficient;

public class BinominalCoefficient {
    public static void main(String[] args) {
        generate(6);
        for(int i = 1; i <= 6; i++) {
            for(int j = 1; j <= 6; j++) {
                System.out.print(getBinominalCoefficient(i, j) + "\t");
            }
            System.out.println();
        }

    }

    private static long bc[][];

    public static long getBinominalCoefficient(int n, int m) {
        if(m > n) {
            return bc[m - 1][n - 1];
        }

        return bc[n - 1][m - 1];
    }

    public static void generate(int n) {
        if(bc != null && bc.length >= n) {
            return;
        }

        bc = new long[n][0];

        bc[0] = new long[1];
        bc[0][0] = 1;

        for(int i = 1; i < n; i++) {
            bc[i] = new long[i + 1];
            bc[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    bc[i][j] = bc[i][j - 1] * 2;
                } else {
                    bc[i][j] = bc[i][j - 1] + bc[i - 1][j];
                }
            }
        }
    }
}
