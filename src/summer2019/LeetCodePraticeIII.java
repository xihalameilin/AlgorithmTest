package summer2019;

import java.util.*;

public class LeetCodePraticeIII {
    public static void main(String[] args) {
        String s = new LeetCodePraticeIII().shortestPalindrome("abcd");
        System.out.println(s);

    }
    //214 前面补齐字符 使成为最短的回文
    public String shortestPalindrome(String s) {
       String reverse = new StringBuilder(s).reverse().toString();
       for(int i=0;i<s.length();i++){
           if(s.startsWith(reverse.substring(i)))
               return reverse.substring(0,i)+s;
       }
       return "";
    }

    public String shortestPalindromeII(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int begin = 0;
        int length = s.length();
        while(true) {
            if (reverse.substring(begin).equals(s.substring(0, length - begin))) {
                break;
            }
            begin++;
        }
        return reverse.substring(0,begin)+s;
    }


    //215
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[k-1];
    }

    private void quickSort(int[] nums,int l,int r){
        if(l>=r)
            return;
        int pivot = nums[r];
        int left = l;
        int right = r-1;
        while(left<=right){
            while(left<=right && nums[left]<pivot)
                left++;
            while(left<=right && nums[right]>=pivot)
                right--;
            if(left<right)
                swap(nums,left,right);
        }
        nums[r] = nums[left];
        nums[left] = pivot;

        quickSort(nums,l,left-1);
        quickSort(nums,left+1, r);
    }

    private void swap(int[] nums,int l,int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }


    //216
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help216(k,n,res,temp,1);
        return res;
    }

    private void help216(int times,int left,List<List<Integer>> res,List<Integer> temp,int start){
        if(times == 0 && left == 0)
            res.add(new ArrayList<>(temp));
        if(times ==0 || left == 0)
            return;
        for(int i=start;i<=9;i++){
            if(!temp.contains(i)){
                temp.add(i);
                help216(times-1,left-i,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }


    //217
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(!set.add(n))
                return false;
        }
        return true;
    }


}
