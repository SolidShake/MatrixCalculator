/**
 * Created by Уткин Артем on 01.07.2018.
 */

import java.util.Scanner;

public class MatrixCalcEngine {

    static Matrix matrixAdd(Matrix matrix1, Matrix matrix2) {

        Matrix matrix3;
        if (matrix1.getColumn() == matrix2.getColumn() && matrix1.getRow() == matrix2.getColumn()) {

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

    void matrixSubtract() {}

    void matrixMultiply() {}

    void matrixDivide() {}

    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 3);
        Matrix m2 = new Matrix(3, 3);
        m1.matrixInput();
        m1.matrixOutput();

        m2.matrixInput();
        m2.matrixOutput();

        Matrix m3 = matrixAdd(m1, m2);
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
