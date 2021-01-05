package offer.leetcode.editor.cn;
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 81 👎 0
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
        solution.findNthDigit(11);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findNthDigit(int n) {
        if(n == 0)
            return 0;
        int k = 1;
        int count = 9;
        while (n >= 0) {
            n -= k * count;
            count *= 10;
            k++;
        }
        // 落到几位的数
        k--;
        count /= 10;
        n += count * k;
        count /= 9;
        System.out.println("count"+count);
        while (n >= 0) {
            count++;
            n -= k;
        }
        n += k;
        count--;
        System.out.println("count" + count + "n" + n);
        return Integer.valueOf(String.valueOf(count).charAt(n));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}