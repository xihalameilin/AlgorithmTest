# AlgorithmTest
## 小陆的算法练习 太难了
###### 239 滑动窗口的最大值 o(n)时间复杂度 双端队列
###### 240 从左到右，从上到下递增数组中找元素 从右上角开始找
###### 241 给表达式增加括号求值 分治法 递归  *看看！！！！！！！！！！！！！！！！！！*
###### 257 二叉树找所有根到叶节点的路径     多看看
###### 258 正数逐位相加到一位数 (num-1)%9+1
###### 260 数组中只有两个数出现一次 其他两次 找出来 异或操作
###### 264 求丑数(2，3，5乘积) 三指针法 动态规划bug尚未解决
###### 268 找n维数组未出现的唯一值 异或  公式求和减去每个数
###### 274 排序数组H指数 二分法 条件判断(l<=r) l=mid+1 r=mid-1
###### 278 第一个错误版本 l<r 注意:l = mid + 1 (结果一定在右边) r = mid(结果可能就是自己,不能减1)
```java
class Solution{
    public int firstBadVersion(int n) {
            int left = 1;
            int right = n ;
            while(left < right){
                int mid = left + ((right - left) >> 1);
                if(!isBadVersion(mid)){
                    left = mid;
                }
                else{
                    right = mid - 1;
                }
    
            }
            return left;
        }
}
```

###### 287 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。 环的思想
```java
class Solution{
     //287
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            do{
                slow = nums[slow];
                fast = nums[fast];
                fast = nums[fast];
            }while (slow != fast);
            slow = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow; 
        }
}
```
###### 301 删除括号 BFS 每次删除一个左括号或者右括号 精髓在于有结果了就返回 判断表达式是是否合理不一定是栈