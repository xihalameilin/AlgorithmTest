package offer.leetcode.editor.cn;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 98 👎 0

class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:35.3 MB,击败了55.73% 的Java用户
     */
    public int numWays(int n) {
        if(n <= 1)
            return 1;
        int num1 = 1;
        int num2 = 1;
        while(n >= 2){
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp % 1000000007;
            n--;
        }
        return num2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}