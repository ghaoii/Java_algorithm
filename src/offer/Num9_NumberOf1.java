package offer;

public class Num9_NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
