package wy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {

   static class TreeNode{
    int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
      this.val = val;
    }
  }
  static List<Integer> res = new ArrayList<>();
   static int min = Integer.MAX_VALUE;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String ori = sc.nextLine();
    int x = Integer.parseInt(sc.nextLine());
    String[] arr = ori.substring(1,ori.length() - 1).split(",");
    TreeNode[] nodes = new TreeNode[arr.length];
    for(int i = 0 ; i < arr.length ; i ++){
      if(arr[i].equals("null") || arr[i] == null) {
        nodes[i] = null;
        continue;
      }
      nodes[i] = new TreeNode(Integer.parseInt(arr[i]));
    }

    for(int i = 0 ; i <= nodes.length / 2 ; i++){
      if(nodes[i] == null)
        continue;
      if( i * 2 + 1 < arr.length)
        nodes[i].left = nodes[i * 2 + 1];
      if(i * 2 + 2 < arr.length)
        nodes[i].right = nodes[i * 2 + 2];
    }

    backtrace(nodes[0],x,new ArrayList<>());
    System.out.print("[");
    for(int i = 0 ; i < res.size() ; i++){
      if(i == res.size() - 1){
        System.out.print(res.get(i));
      }
      else{
        System.out.print(res.get(i) + ",");
      }
    }
    System.out.println("]");
  }

  private static void backtrace(TreeNode root, int x, List<Integer> path){
     if(x == 0){
       if(path.size() < min){
         res = new ArrayList<>(path);
         min = path.size();
         return;
       }
     }
     if(root != null) {
       path.add(root.val);
       backtrace(root.left, x - root.val, path);
       backtrace(root.right, x - root.val, path);
       path.remove(path.size() - 1);
     }
  }
}
