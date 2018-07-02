/**
 * Created by Уткин Артем on 01.07.2018.
 */

import java.util.Scanner;

public class MatrixCalcEngine {

    static Matrix matrixAdd(Matrix matrix1, Matrix matrix2) {

        Matrix matrix3;
        if (matrix1.getColumn() == matrix2.getColumn() && matrix1.getRow() == matrix2.getRow()) {

            matrix3 = new Matrix(matrix1.getRow(),matrix1.getColumn());
            for(int i = 0; i < matrix1.getColumn(); i++) {
                for(int j = 0; j < matrix1.getRow(); j++) {
                    matrix3.matrixChangeValue(i, j, matrix1.matrixGetValue(i, j) + matrix2.matrixGetValue(i, j));
                }
            }
        } else {
            matrix3 = null;
            System.out.println("It's impossible to add different sizes matrices");
        }

        return matrix3;
    }

    static Matrix matrixSubtract(Matrix matrix1, Matrix matrix2) {

        Matrix matrix3;
        if (matrix1.getColumn() == matrix2.getColumn() && matrix1.getRow() == matrix2.getRow()) {

            matrix3 = new Matrix(matrix1.getRow(),matrix1.getColumn());
            for(int i = 0; i < matrix1.getColumn(); i++) {
                for(int j = 0; j < matrix1.getRow(); j++) {
                    matrix3.matrixChangeValue(i, j, matrix1.matrixGetValue(i, j) - matrix2.matrixGetValue(i, j));
                }
            }
        } else {
            matrix3 = null;
            System.out.println("It's impossible to add different sizes matrices");
        }

        return matrix3;
    }

    static Matrix matrixMultiplyByNumber(Matrix matrix, int number) {
        for(int i = 0; i < matrix.getColumn(); i++) {
            for(int j = 0; j < matrix.getRow(); j++) {
                matrix.matrixChangeValue(i, j, matrix.matrixGetValue(i, j) * number);
            }
        }

        return matrix;
    }

    static Matrix matrixMultiply(Matrix matrix1, Matrix matrix2) {
        Matrix matrix3;
        if (matrix1.getRow() == matrix2.getColumn()) {

            matrix3 = new Matrix(matrix1.getColumn(),matrix2.getRow());
            for(int i = 0; i < matrix3.getColumn(); i++) {
                for(int j = 0; j < matrix3.getRow(); j++) {
                    int sum = 0;
                    for(int k = 0; k < matrix1.getColumn(); k++) {
                        sum += matrix1.matrixGetValue(i,k) * matrix2.matrixGetValue(k,j);
                    }
                    matrix3.matrixChangeValue(i,j, sum);
                }
            }
        } else {
            matrix3 = null;
            System.out.println("The number of row of matrix №1 should be equal to the number of columns of matrix №2");
        }

        return matrix3;
    }

    public static void main(String[] args) {
        Matrix m1 = new Matrix(2, 2);
        Matrix m2 = new Matrix(2, 2);
        m1.matrixInput();
        m1.matrixOutput();

        m2.matrixInput();
        m2.matrixOutput();

        Matrix m3 = matrixAdd(m1, m2);
        m3.matrixOutput();
        m3 = matrixMultiplyByNumber(m1, 2);
        m3.matrixOutput();
        m3 = matrixMultiply(m1, m2);
        m3.matrixOutput();
    }
}

class Matrix {
    private int[][] matrix;
    private int row;
    private int column;

    Matrix(int row, int colomn) {
        matrix = new int[row][colomn];
        this.row = row;
        this.column = colomn;
    }

    int[][] getMatrix() {
        return matrix;
    }

    int getRow() {
        return row;
    }
    int getColumn() {
        return column;
    }

    void matrixChangeValue(int row, int column, int value) {
        matrix[row][column] = value;
    }

    int matrixGetValue(int row, int column) {
        return matrix[row][column];
    }

    void matrixInput() {

        Scanner in = new Scanner(System.in);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    void matrixOutput() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
