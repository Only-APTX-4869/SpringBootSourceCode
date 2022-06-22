/**
 * 求(返回)最大前缀 (字符串)
 * strs.length<200 ,strs[i].length<200
 */
public class LeetCode04 {
    public static void main(String[] args){
        String[] strs = {"strbuffer","string","stringbulider"};
        longestCommonPrefix(strs);
    }
    public static String longestCommonPrefix(String[] strs) {

        String str = strs[0];
        for (String string:strs){
            while (!string.startsWith(str)){
                if (str == "")return "";
                str =str.substring(0,str.length()-1);


            }
        }

        return str;
    }

}
