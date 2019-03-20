package DataWhale.Leetcode;

import java.util.*;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, his
 * importance value and his direct subordinates' id.
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They
 * have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15,
 * [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3
 * is also a subordinate of employee 1, the relationship is not direct.
 * <p>
 * Note:
 * One employee has at most one direct leader and may have several subordinates.
 * The maximum number of employees won't exceed 2000.
 */
public class _0690_EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees)
            map.put(e.id, e);
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            sum += e.importance;
            for (int num : e.subordinates)
                queue.add(num);
        }
        return sum;
    }
}
