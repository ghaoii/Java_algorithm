package offer;

public class Num5_MinNumberInRotateArray {
    //利用二分查找的思路解决问题
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(array[left] >= array[right]){
            mid = (left + right) >> 1;
            if(right - left == 1){
                mid = right;
                return array[mid];
            }
            //无法判断最小值在前半部分还是后半部分
            if(array[left] == array[right] && array[left] == array[mid]){
                //线性遍历寻找
                int ret =  array[left];
                for (int i = left + 1; i < right; i++) {
                    //因为left和right的值相等，所以没必要判断right处的元素值
                    if(array[i] < ret){
                        ret = array[i];
                    }
                }
                return ret;
            }

            if(array[mid] >= array[left]){
                //如果mid属于前半部分，则最小值一定在右侧
                left = mid;
            }else{
                //如果mid属于右半部分，则，最小值一定在左侧
                right = mid;
            }
        }
        return array[mid];
    }


    //线性遍历，找到前一个元素大于当前元素的值
//    public int minNumberInRotateArray(int [] array) {
//        if(array == null || array.length == 0){
//            return -1;
//        }
//        for (int i = 0; i < array.length - 1; i++) {
//            if(array[i] > array[i + 1]){
//                return array[i + 1];
//            }
//        }
//        return array[0];
//    }
}
