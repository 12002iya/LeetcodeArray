package binarysearch;

import java.util.Arrays;

public class TwoSum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {

      /*  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

                Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

        The tests are generated such that there is exactly one solution. You may not use the same element twice.

        Your solution must use only constant extra space.*/


        int[] numbers = {2,3,4};
        int target = 6;
        int[] ans = findTarget(numbers, target);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] findTarget(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {

                left++;
            } else {
                right--;
            }

        }
        return new int[]{-1, -1};
    }
}
