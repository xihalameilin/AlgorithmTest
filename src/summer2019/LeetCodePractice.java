package summer2019;

import java.util.*;

public class LeetCodePractice {
    static int[] nums = {1, 0, -1, 0, -2, 2};

    public static void main(String[] args) {
        System.out.println(fourSum(nums,0).size());
    }

    //20
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='{'||c=='('||c=='[')
                stack.push(c);
            else if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{')
                    return false;
            }
            else if(c==')'){
                if(stack.isEmpty()||stack.pop()!='(')
                    return false;
            }
            else if(c==']'){
                if(stack.isEmpty()||stack.pop()!='[')
                    return false;
            }
        }
        return stack.isEmpty();

    }

    //19
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        ListNode before = head;
        ListNode current = head;
        int i=0;
        while(current.next!=null){
            current = current.next;
            if(i<n)
                i++;
            else{
                before = before.next;
            }
        }
        if(i!=n){
            head=head.next;
        }
        else{
            before.next = before.next.next;
        }

        return head;
    }

    //18
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int i=0;
        int j=0;
        int length = nums.length;
        for(i=0;i<length-3;i++){
            for(j=i+3;j<length;j++){
                int remainder = target - nums[i] - nums[j];
                int l = i+1;
                int r = j-1;
                while(l<r){
                    if(nums[l]+nums[r]==remainder){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        temp.add(nums[j]);
                        result.add(temp);
                        while(l+1<length&&nums[l]==nums[l+1])
                            l++;
                        while(r-1>0&&nums[r]==nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else if(nums[l]+nums[r]<remainder){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    //990 并查集
    public boolean equationsPossible(String[] equations) {
        int[] array = new int[26];
        for(int i=0;i<26;i++){
            array[i]=i;
        }
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0;i<equations.length;i++) {
            String s = equations[i];
            if(s.charAt(1)=='='){
                union(array,s.charAt(0)-'a',s.charAt(3)-'a');
            }
            else {
                temp.add(s);
            }
        }

        for(int i=0;i<temp.size();i++){
            int index1 = temp.get(i).charAt(0)-'a';
            int index2 = temp.get(i).charAt(3)-'a';
            if(array[index1]==array[index2])
                return false;
        }

        return true;
    }

    private int[] union(int[] array,int index1,int index2){
        int standard = array[index1];
        for(int i=0;i<array.length;i++){
            if(array[i]==standard){
                array[i]=array[index2];
            }
        }
        return array;
    }


}
