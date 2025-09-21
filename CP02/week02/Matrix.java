package week02;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] arr)
    {
        this.matrix = arr;
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if(m1.matrix[0].length != m2.matrix[0].length ||
                m1.matrix.length != m2.matrix.length) {
            System.out.println("두 행렬의 행과 열의 길이가 같아야 합니다.");
            return null;
        } else {
            double[][] result = new double[m1.matrix.length][m1.matrix[0].length];
            for(int i = 0; i < result.length; i++)
                for(int j = 0; j < result[0].length; j++) {
                    result[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
                }
            return new Matrix(result);
        }
    }

    public static Matrix subtract(Matrix m1, Matrix m2) {
        if(m1.matrix[0].length != m2.matrix[0].length ||
                m1.matrix.length != m2.matrix.length) {
            System.out.println("두 행렬의 행과 열의 길이가 같아야 합니다.");
            return null;
        } else {
            double[][] result = new double[m1.matrix.length][m1.matrix[0].length];
            for(int i = 0; i < result.length; i++)
                for(int j = 0; j < result[0].length; j++) {
                    result[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
                }
            return new Matrix(result);
        }
    }
    public static Matrix multiply(Matrix m1, Matrix m2) {
        if(m1.matrix[0].length != m2.matrix.length){
            System.out.println("두 행렬의 행과 열의 길이가 같아야 합니다.");
            return null;
        } else {
            double[][] result = new double[m1.matrix.length][m2.matrix[0].length];
            for(int i = 0; i < m1.matrix.length; i++)
                for(int j = 0; j < m2.matrix[0].length; j++) {
                    for(int k=0 ; k < m1.matrix[0].length ; k++) {
                        result[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                    }
                }
            return new Matrix(result);
        }
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i<this.matrix.length; i++) {
            temp.append(Arrays.toString(this.matrix[i]));
            if(i != this.matrix.length - 1)
                temp.append("\n");
        }
        return "[" + temp +"]";
    }
    public static void main(String[] args) {

        Matrix mat1 = new Matrix(new double[][]{{1, -2}, {3, 4}, {5, 6}});
        Matrix mat2 = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}});

        System.out.println("첫번째 행렬");
        System.out.println(mat1);
        System.out.println("\n두번째 행렬");
        System.out.println(mat2);

        System.out.println("\n첫번째 행렬 + 첫번째 행렬");
        System.out.println(Matrix.add(mat1, mat1));
        System.out.println("\n두번째 행렬 - 두번째 행렬");
        System.out.println(Matrix.subtract(mat2, mat2));
        System.out.println("\n첫번째 행렬 * 두번째 행렬");
        System.out.println(Matrix.multiply(mat1, mat2));

        System.out.println("\n첫번째 행렬 + 두번째 행렬");
        System.out.println(Matrix.add(mat1, mat2));
        System.out.println("\n첫번째 행렬 - 두번째 행렬");
        System.out.println(Matrix.subtract(mat1, mat2));
        System.out.println("\n첫번째 행렬 * 첫번째 행렬");
        System.out.println(Matrix.multiply(mat1, mat1));
    }
}
