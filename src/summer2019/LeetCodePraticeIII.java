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

    //219
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length&&j<=i+k;j++){
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateI(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }


    //滑动窗口
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if(set.size()>k)
                set.remove(nums[i-k]);
        }
        return false;
    }



    //220
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long successor = set.ceiling((long)nums[i]);
            if(successor!=null&&(long)nums[i]+t>=successor)
                return true;
            Long predecessor = set.floor((long)nums[i]);
            if(predecessor!=null&&(long)nums[i]-t<=predecessor)
                return true;
            set.add((long)nums[i]);
            if(set.size()>k)
                set.remove((long)nums[i-k]);
        }
        return false;
    }

    //223
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(A);
        list1.add(C);
        list1.add(E);
        list1.add(G);

        List<Integer> list2 = new ArrayList<>();
        list2.add(B);
        list2.add(D);
        list2.add(F);
        list2.add(H);
        List<Integer> res1 = getMedia(list1);
        List<Integer> res2 = getMedia(list2);
        int off = 0;
        if(E>=C||G<=A||F>=D||H<=B){
        }
        else{
            off = Math.abs(res1.get(0)-res1.get(1)) * Math.abs(res2.get(0)-res2.get(1));
        }
        return (C-A)*(D-B) + (G-E)*(H-F) - off;

    }

    private List<Integer> getMedia(List<Integer> list){
        int max = list.get(0);
        int min = list.get(0);
        for(int i : list){
            if( i > max)
                max = i;
            if( i < min)
                min = i;
        }
        list.remove(list.indexOf(max));
        list.remove(list.indexOf(min));
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0));
        res.add(list.get(1));
        return res;
    }

    //224
    public int calculate(String s) {
        String[] items = s.split(" ");
        return 0;
    }
}
