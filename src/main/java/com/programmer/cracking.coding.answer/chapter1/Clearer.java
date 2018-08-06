package com.programmer.cracking.coding.answer.chapter1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 22:55
 * @Description
 */
public class Clearer {

    /*
    请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
    给定一个N阶方阵int[][](C++中为vector<vector><int>>)mat和矩阵的阶数n，
    请返回完成操作后的int[][]方阵(C++中为vector<vector><int>>)，保证n小于等于300，
    矩阵中的元素为int范围内。</int></vector></int></vector>
    测试样例：
    [[1,2,3],[0,1,2],[0,0,1]]
    返回：[[0,0,3],[0,0,0],[0,0,0]]
     */

    /**
     * @param mat
     * @param n
     * @return
     */
    public static int[][] clearZero(int[][] mat, int n) {
        List<Matrix> matrixList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    Matrix matrix = new Matrix(i, j);
                    matrixList.add(matrix);
                }
            }
        }

        if (!matrixList.isEmpty()) {
            for (Matrix x : matrixList) {
                int row = x.getRow();
                for (int j = 0; j < n; j++) {
                    mat[row][j] = 0;
                }
                int cow = x.getCow();
                for (int i = 0; i < n; i++) {
                    mat[i][cow] = 0;
                }
            }

        }

        return mat;
    }

    public static class Matrix {
        private Integer row;
        private Integer cow;

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public Integer getCow() {
            return cow;
        }

        public void setCow(Integer cow) {
            this.cow = cow;
        }

        public Matrix(Integer row, Integer cow) {
            this.row = row;
            this.cow = cow;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {0, 1, 2}, {0, 0, 1}};
        mat = Clearer.clearZero(mat, 3);
        System.out.println(mat);
    }
}
