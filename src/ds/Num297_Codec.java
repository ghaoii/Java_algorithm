package ds;



public class Num297_Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        stringify(root, sb);
        return sb.toString();
    }

    // 按照先序遍历进行序列化
    private void stringify(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        stringify(root.left, sb);
        stringify(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return build(values);
    }

    private TreeNode build(String[] values) {
        if(index >= values.length) {
            return null;
        }
        String str = values[index];
        if("#".equals(str)) {
            return null;
        }
        int val = Integer.parseInt(str);
        TreeNode root = new TreeNode(val);
        index++;
        root.left = build(values);
        index++;
        root.right = build(values);
        return root;
    }

    public static void main(String[] args) {
        Num297_Codec test = new Num297_Codec();
        String str = "1,2,3,#,#,4,#,#,5,#,#";
        TreeNode root = test.deserialize(str);
    }
}
