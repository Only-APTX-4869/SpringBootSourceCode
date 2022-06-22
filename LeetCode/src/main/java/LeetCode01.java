import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求两数之和
 * 1、数字不允许重复
 * 2、若数组中两个数字相加等于目标值，则返回下标（index）
 */
public class LeetCode01 {
    public static void main(String[] args){
        int nums[] = {2,3,5,7};
        int[] num = twoSum(nums,9);
        System.out.println(Arrays.toString(num));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            if (map.containsKey(target - nums[i]) ){
                return new int[]{map.get(target - nums[i]),i};
            }
        }
        return new int[]{};
    }

//    private static int[] twoSum(int[] nums,int target) {
//        int len = nums.length;
//        for (int i =0;i<len;i++){
//            for (int j = i+1;j<len;j++){
//                if (nums[i] + nums[j] == target){
//                    System.out.println("i="+i+"j="+j);
//                    return new int[]{i,j};
//                }
//            }
//        }
//       return new int[0];
//    }

}
