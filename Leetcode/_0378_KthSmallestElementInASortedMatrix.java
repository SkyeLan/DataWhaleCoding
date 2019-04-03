package DataWhale.Leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest
 * element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class _0378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int i = 0, j = matrix[0].length - 1;
        int start = matrix[i][i], end = matrix[j][j];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int rank = count(matrix, mid);
            if (rank < k)
                start = mid;
            else
                end = mid;
        }
        if (count(matrix, start) >= k)
            return start;
        return end;
    }

    private int count(int[][] matrix, int val) {
        int i = 0, j = matrix[0].length - 1;
        int rank = 0;
        while (i < matrix.length && j >= 0) {
            while (j >= 0 && matrix[i][j] > val)
                j--;
            rank += j + 1;
            i++;
        }
        return rank;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(new _0378_KthSmallestElementInASortedMatrix().kthSmallest(matrix, k));
    }
}
