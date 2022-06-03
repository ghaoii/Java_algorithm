package offer;

public class Num10_ReOrderArray {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if((array[i] & 1) == 1){
                int v = array[i];
                int j = i;
                for( ; j > k; j--){
                    array[j] = array[j - 1];
                }
                array[j] = v;
                k++;
            }
        }
    }
}
