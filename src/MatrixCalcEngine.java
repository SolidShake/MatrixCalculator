/**
 * Created by Уткин Артем on 01.07.2018.
 */

import java.util.Scanner;

public class MatrixCalcEngine {

    void matrixAdd() {}

    void matrixSubtract() {}

    void matrixMultiply() {}

    void matrixDivide() {}

    public static void main(String[] args) {
        Matrix m = new Matrix(3, 3);
        m.matrixInput();
        m.matrixOutput();
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

    void matrixInput() {

        Scanner in = new Scanner(System.in);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        in.close();
    }

    void matrixOutput() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
