package DataWhale.Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple
 * of points (i, j, k) such that the distance between i and j equals the distance
 * between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates
 * of points are all in the range [-10000, 10000] (inclusive).
 */
public class _0447_NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int dist = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (map.containsKey(dist))
                    map.put(dist, map.get(dist) + 1);
                else
                    map.put(dist, 1);
            }
            for (int value : map.values())
                count += value * (value - 1);
            map.clear();
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] point = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new _0447_NumberOfBoomerangs().numberOfBoomerangs(point));
    }
}
