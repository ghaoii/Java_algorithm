package dp.nowcoder;

import java.util.ArrayList;
import java.util.Map;

public class CC31_MinimumTotal {
    //方法一，开辟新的空间
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.isEmpty()){
            return 0;
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                int temp = 0;
                //先判断边界，然后再处理中间
                if(j == 0){
                    temp = ret.get(i - 1).get(j);
                }else if(j == i){
                    temp = ret.get(i - 1).get(j - 1);
                }else{
                    temp = Math.min(ret.get(i - 1).get(j - 1), ret.get(i - 1).get(j));
                }
                ret.get(i).add(temp + triangle.get(i).get(j));
            }
        }
        int row = triangle.size();
        int min = ret.get(row - 1).get(0);
        for (int i = 0; i < row; i++) {
            min = Math.min(min, ret.get(row - 1).get(i));
        }
        return min;
    }

    //方法一，不开辟新空间
//    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//        if(triangle == null){
//            return 0;
//        }
//        //初始化
//        int row = triangle.size();
//        for (int i = 1; i < row; i++) {
//            int tmp = 0;
//            for (int j = 0; j <= i; j++) {
//                if(j == 0){
//                    tmp = triangle.get(i - 1).get(0);
//                }else if(j == i){
//                    tmp = triangle.get(i - 1).get(j - 1);
//                }else{
//                    tmp = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
//                }
//                triangle.get(i).set(j, triangle.get(i).get(j) + tmp);
//            }
//        }
//        int min = triangle.get(row - 1).get(0);
//        for (int i = 1; i < row; i++) {
//            min = Math.min(triangle.get(row - 1).get(i), min);
//        }
//        return min;
//    }
}
