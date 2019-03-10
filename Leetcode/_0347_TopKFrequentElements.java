package DataWhale.Leetcode;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _0347_TopKFrequentElements {
    // 使用HashMap，存储数字和次数的映射
    // 然后使用堆排序，找到出现次数前K个的元素
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> total = new HashMap<>();
        for (int num : nums)
            if (total.containsKey(num))
                total.put(num, total.get(num) + 1);
            else
                total.put(num, 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : total.entrySet())
            pq.add(entry);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++)
            list.add(pq.poll().getKey());
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.print(topKFrequent(nums, k).toString());
    }
}
