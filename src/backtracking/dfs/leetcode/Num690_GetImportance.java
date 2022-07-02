package backtracking.dfs.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class Num690_GetImportance {

    //直接使用线性表的方法
//    public int getImportance(List<Employee> employees, int id) {
//        if(employees == null) {
//            return 0;
//        }
//        for(Employee e : employees) {
//            if(e.id == id) {
//                int sum = e.importance;
//                for(int subId : e.subordinates) {
//                    sum += getImportance(employees, subId);
//                }
//                return sum;
//            }
//        }
//        return 0;
//    }

    // 方法的语义：传入员工的id，就能将该员工及其所有下属的重要度之和返回
    private int dfs(Map<Integer, Employee> info, int id) {
        Employee curE = info.get(id);
        if(curE.subordinates == null || curE.subordinates.size() == 0) {
            return curE.importance;
        }
        int sum = curE.importance;

        for(int subId : curE.subordinates) {
            sum += dfs(info, subId);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) {
            return 0;
        }
        Map<Integer, Employee> info = new HashMap<>();
        for(Employee e : employees) {
            info.put(e.id, e);
        }
        return dfs(info, id);
    }
}
