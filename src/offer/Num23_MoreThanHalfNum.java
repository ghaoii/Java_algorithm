package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num23_MoreThanHalfNum {
    //摩尔排序法
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int val = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(count == 0){
                val = array[i];
                count = 1;
            }else if(array[i] == val){
                count++;
            }else{
                count--;
            }
        }

        int times = 0;
        for (int i : array) {
            if (i == val) {
                times++;
            }
        }
        return times > array.length / 2 ? val : 0;
    }

    //排序找中间位置
//    public int MoreThanHalfNum_Solution(int [] array) {
//        Arrays.sort(array);
//        int pos = array.length / 2;
//        return array[pos];
//    }

    //Map
//    public int MoreThanHalfNum_Solution(int [] array) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i : array){
//            map.put(i,map.getOrDefault(i, 0) + 1);
//        }
//        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//            if(entry.getValue() > array.length / 2){
//                return entry.getKey();
//            }
//        }
//        return -1;
//    }
}
