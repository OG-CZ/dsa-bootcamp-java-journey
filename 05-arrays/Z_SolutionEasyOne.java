import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Z_SolutionEasyOne {
    public static void main(String[] args) {
        int arr1[] = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(arr1)));
    
        int arr2[] = {0, 5, 0};
        System.out.println(Arrays.toString( concatArray(arr2)));

        int arr3[] = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(arr3)));

        int arr5[][] = {
            {2,8,7},
            {7,1,3},
            {1,9,5}
        };
        System.out.println(maximumWealth(arr5));
        
        int arr6[] = {12,1,12};
        System.out.println(kidsWithCandies(arr6, 3));

        int arr7[] = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(arr7));
        
        int arr8[] = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr8)));
    
        int arr9nums[] = {0,1,2,3,4};
        int arr9index[] = {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(arr9nums, arr9index)));

        int arr10[] = {1, 1, 2, 2};
        int number = 2;
        System.out.println(Arrays.toString(shuffle(arr10, number)));



    }

    static int[] buildArray(int[] nums) {
        int result[] = new int[nums.length];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[nums[i]];
        }

        return result;
    }

    static int[] concatArray(int[] nums) {
        int ans[] = new int[nums.length * 2];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i + n] = nums[i];
        }
        
        return ans;
    }

    //  1 2 3 4
    static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        return sum;
    }

        static int maximumWealth(int[][] accounts) {
            int maxWealth = 0;

            //  [[1,5],[7,3],[3,5]]
            //  [[2,8,7],[7,1,3],[1,9,5]] // 17 12 15

            for (int i = 0; i < accounts.length; i++) {
                int sum = 0;

                for (int j = 0; j < accounts[i].length; j++) {
                    sum += accounts[i][j];
                }

                if (maxWealth < sum) {
                    maxWealth = sum;
                }
            }
            
            return maxWealth;
        }

        //  {2,3,5,1,3}; + 3
        static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            ArrayList<Boolean> list = new ArrayList<>(); 

            int max = candies[0];
            
            for (int m : candies) {
                if (m > max) {
                    max = m;
                }
            }

            for (int i = 0; i < candies.length; i++) {
                candies[i] += extraCandies;
                if (candies[i] >= max) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }

            return list; 
        }

        static int numIdenticalPairs(int[] nums) {
            int count = 0;

            // int arr7[] = {1,2,3,1,1,3};

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length ; j++) {
                  //  System.out.println(nums[i] + " " + nums[j]);
                    if (i < j && nums[i] == nums[j]) {
                        count++;
                    }
                }
            }

            return count;
        }

        static int[] smallerNumbersThanCurrent(int[] nums) {
            int[] result = new int[nums.length];
        
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
            //        System.out.println(nums[i] + " " + nums[j]);
                    if (j != i && nums[j] < nums[i]) {
                        result[i]++;
                    }
                }
            }
        
            return result;
    }

    //        int arr9nums[] = {0,1,2,3,4};
    //        int arr9index[] = {0,1,2,2,1};
    static int[] createTargetArray(int[] nums, int[] index) {
       
        int target[] = new int[index.length];


        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < index.length; i++) {
            int insert = index[i];
            int value = nums[i];

            list.add(insert, value);
        }

        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        

        return target;

        /*
         *    int target[] = new int[index.length];


        for (int i = 0; i < target.length; i++) { // outer process all elements in order
            // inner loop shifting elemetns
            int insert = index[i];
            int value = nums[i];

            for (int j = target.length - 1; j > insert; j--) {
                target[j] = target[j - 1];
            }
            target[insert] = value;
        }

        return target;
         */

    }


    /*
        = x1 y1 x2 y2 .... Xn Yn so on
        1  2  1  2 // (x1 = 1, y1 = 2) (x2 = 1, y2 = 2)
    // 1 1 2 2
     */

    static int[] shuffle(int[] nums, int n) {
        int result[] = new int[nums.length];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[(2 * i) + 1] = nums[i + n];
        }

        
        return result;
    }


}
