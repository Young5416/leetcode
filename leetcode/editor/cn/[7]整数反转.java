//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2510 👎 0

package leetcode.editor.cn;

class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(-123));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int reverse(int x) {
            boolean change = false;
            if (x == 0) {
                return x;
            }
            if (x < 0) {
                change = true;
                x = -x;
            }
            try {
                String str = String.valueOf(x);
                int[] temp = new int[str.length()];
                for (int i = str.length() - 1; i >= 0; i--) {
                    String tStr = String.valueOf(str.charAt(i));
                    if (i == str.length() && tStr.equals("0")) {
                        continue;
                    }
                    temp[i] = Integer.parseInt(tStr);
                }
                int result = 0;
                for (int i = str.length() - 1; i >= 0; i--) {
                    result = result * 10 + temp[i];
                }
                StringBuilder reverse = new StringBuilder(result + "").reverse();
                String compareStr = subFun(str);
                if (!reverse.toString().equals(compareStr)) {
                    return 0;
                }
                if (change) {
                    result = -result;
                }
                return result;
            } catch (Exception e) {
                return 0;
            }
        }

        String subFun(String str) {
            if (!str.endsWith("0")) {
                return str;
            } else {
                str = str.substring(0, str.length() - 1);
                return subFun(str);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}