package summer2019;


import java.util.ArrayList;
import java.util.List;

public class Trie {
    private class TreeNode {
        private List<TreeNode> links; //使用偏移计算
        private Integer val;
        private boolean isend;
        public TreeNode(){
            links = new ArrayList<>();
        }
        public TreeNode(int val){
            this.val = val;
            links = new ArrayList<>();
        }
    }

    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(-1);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int index = 0;
        TreeNode cur = root;
        while(index<word.length()){
            int offset = word.charAt(index)-'a';
            boolean flag = false;
            for(TreeNode treeNode:cur.links){
                if(treeNode.val==offset){
                    flag = true;
                    cur = treeNode;
                    break;
                }
            }
            if(!flag){
                TreeNode treeNode = new TreeNode(offset);
                cur.links.add(treeNode);
                cur = treeNode;
            }
            index++;
            if(index==word.length()){
                cur.isend = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = root;
        for(int i=0;i<word.length();i++){
            List<TreeNode> treeNodes = cur.links;
            int offset = word.charAt(i)-'a';
            boolean flag = false;
            for(TreeNode treeNode:treeNodes){
                if(treeNode.val == offset){
                    flag = true;
                    cur = treeNode;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return cur.isend;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(int i=0;i<prefix.length();i++){
            List<TreeNode> treeNodes = cur.links;
            int offset = prefix.charAt(i)-'a';
            boolean flag = false;
            for(TreeNode treeNode:treeNodes){
                if(treeNode.val == offset){
                    flag = true;
                    cur = treeNode;
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return true;
    }
}
