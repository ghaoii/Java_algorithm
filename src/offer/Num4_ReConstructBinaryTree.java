package offer;

public class Num4_ReConstructBinaryTree {
    int index = 0;
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if(pre.length == 0 || vin.length == 0 || pre.length != vin.length){
            return null;
        }
        return reBuild(pre, vin, 0, vin.length - 1);
    }

    /**
     * 传入前序遍历和中序遍历的结果集和该树所有结点在中序遍历的范围，就能将这颗数构建好，并返回树根结点
     * @param pre
     * @param vin
     * @param start
     * @param end
     */
    private TreeNode reBuild(int[] pre, int[] vin, int start, int end) {
        if(start > end){
            return null;
        }
        int val = pre[index];
        index++;
        TreeNode root = new TreeNode(val);
        int root_index = findIndex(vin, val, start, end);
        root.left = reBuild(pre, vin, start, root_index - 1);
        root.right = reBuild(pre, vin, root_index + 1, end);
        return root;
    }

    private int findIndex(int[] vin, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if(vin[i] == val){
                return i;
            }
        }
        return -1;
    }


}
