package com.example.croutalgorithm.controller;

public class CroutAlgorithm {
    private double[][] lu;

    private double[][] lowerMatrix;
    private double[][] upperMatrix;

    public double[][] croutAlgorithm(double[][] A) {
        int n = A.length;
        lowerMatrix = new double[n][n];
        upperMatrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            // Decomposition of L
            for (int j = 0; j <= i; j++) {
                double sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += lowerMatrix[i][k] * upperMatrix[k][j];
                }
                lowerMatrix[i][j] = A[i][j] - sum;
            }
            // Decomposition of U
            for (int j = i; j < n; j++) {
                if (i == j) {
                    upperMatrix[i][j] = 1;
                } else {
                    double sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += lowerMatrix[j][k] * upperMatrix[k][i];
                    }
                    upperMatrix[j][i] = (A[j][i] - sum) / lowerMatrix[i][i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    lu[i][j] = lowerMatrix[i][j];
                } else {
                    lu[i][j] = upperMatrix[i][j];
                }
            }
        }
        return lu;
    }

    public double[][] getL() {
        int n = lu.length;
        double[][] L = new double[n][n];

        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
            for (int j = 0; j < i; j++) {
                L[i][j] = lu[i][j];
            }
        }

        return L;
    }

    public double[][] getU() {
        int n = lu.length;
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                U[i][j] = lu[i][j];
            }
        }

        return U;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public double[][] getLu() {
        return lu;
    }

    public double[][] getLowerMatrix() {
        return lowerMatrix;
    }

    public double[][] getUpperMatrix() {
        return upperMatrix;
    }
}
