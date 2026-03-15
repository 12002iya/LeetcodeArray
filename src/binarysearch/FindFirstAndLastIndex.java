package binarysearch;

public class FindFirstAndLastIndex {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int first = findIndex(nums, target, true);
        int last = findIndex(nums, target, false);
        System.out.println(first + " " + last);


    }

    private static int findIndex(int[] nums, int target, boolean firstIndex) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (firstIndex) {

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }


        }

        return result;

    }

}



