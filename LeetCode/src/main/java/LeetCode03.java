import java.util.HashMap;

/**
 * 罗马数转整数
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode03 {
    public static void main(String[] args){
    ramonToInt("XCIII");
    }

    private static int ramonToInt(String s) {
        HashMap<Character, Integer> ramonVal = new HashMap<>();
        ramonVal.put('I',1);
        ramonVal.put('V',5);
        ramonVal.put('X',10);
        ramonVal.put('L',50);
        ramonVal.put('C',100);
        ramonVal.put('D',500);
        ramonVal.put('M',1000);
        int num =0;
        for (int i = 0;i< s.length();i++){
            int val = ramonVal.get(s.charAt(i));
            if (i< s.length() -1 && val < ramonVal.get(s.charAt(i+1))){
                num -= val;
            }else {
                num += val;
            }
        }
        return num;
    }


}
