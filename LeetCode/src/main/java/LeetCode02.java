/**
 * 回文数
 * 给一个整数，若121 = 121 则是回文数 返回true，否则false
 * -123 不是回文数因为 -121 != 121-
 */
public class LeetCode02 {
    public static void main(String[] args){
        isHuiWen(121);
    }
   static Boolean isHuiWen(int num){
        if (num> 0){
            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder(str).reverse();
            String newStr = new String(sb);
            return str.equals(newStr);
        }
       return false;
   }
}
