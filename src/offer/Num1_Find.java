package offer;

public class Num1_Find {
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[0].length - 1;
        while(i < array.length && j >= 0){
            if(array[i][j] < target){
                i++;
            }else if(array[i][j] > target){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
