package summer2019;


public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().help213(new int[]{1,2,3,1},0));
    }

    private int help213(int[] nums,int start){
        if(nums.length==0||nums==null)
            return 0;
        if(nums.length==1)
            return nums[0];
        int index = start+2;
        int length = nums.length;
        int time = 0;
        int[] dp = new int[length];
        dp[0] = nums[start];
        dp[1] = nums[start+1];
        while(time+2<length){
            if(time==0)
                dp[index] = nums[index];
            else {
                int innerTime = 0;
                while(innerTime<time){
                    dp[index] = Math.max(nums[index]+dp[(start+innerTime-2+length)%length],dp[(start+innerTime-1+length)%length]);
                    innerTime++;
                    System.out.println(dp[index]);
                }
            }
            time++;
            index = (index+1)%length;
        }
        return dp[(length+index-1)%length];
    }

}
