package summer2019;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return "[null]";
        List<String> trees = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode != null){
                trees.add(String.valueOf(treeNode.val));
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
            }
            else
                trees.add(null);
        }
        return "["+String.join(",",trees)+"]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String data1 = data.substring(1,data.length()-1);
        String[] trees = data1.split(",");
        if(trees[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(trees[0]));
        int size = trees.length;
        int i = 1;
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(i <= size && !queue.isEmpty()){
            cur = queue.poll();
            if(trees[i].equals("null")){
                cur.left = null;
            }
            else {
                cur.left = new TreeNode(Integer.valueOf(trees[i]));
                queue.offer(cur.left);
            }
            i++;
            if(trees[i].equals("null")){
                cur.right = null;
            }
            else {
                cur.right = new TreeNode(Integer.valueOf(trees[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Codec().serialize(null));
    }

    public static void main(String[] args) {
       new Codec().test();
    }
}
