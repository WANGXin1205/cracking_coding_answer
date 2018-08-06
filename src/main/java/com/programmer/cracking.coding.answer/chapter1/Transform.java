package com.programmer.cracking.coding.answer.chapter1;

import java.util.Arrays;

/**
 * @Author : Growlithe
 * @Date : 2018/8/6 22:01
 * @Description
 */
public class Transform {
    /*
    有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
    给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。

    我估计这里是其他语言，Java是{}
    测试样例：
    [[1,2,3],[4,5,6],[7,8,9]],3
    返回：[[7,4,1],[8,5,2],[9,6,3]]
     */

    public static int[][] transformImage(int[][] mat, int n) {
        for (int i = 0; i < n / 2; ++i) {
            int first = i;
            int last = n - 1 - i;
            for (int j = first; j < last; ++j) {
                int offset = j - first;
                int top = mat[first][j];
                mat[first][j] = mat[last - offset][first];
                mat[last - offset][first] = mat[last][last - offset];
                mat[last][last - offset] = mat[j][last];
                mat[j][last] = top;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        mat = Transform.transformImage(mat, 2);
        for (int[] x : mat) {
            for (int y : x) {
                System.out.println(y);
            }
        }

    }
}
