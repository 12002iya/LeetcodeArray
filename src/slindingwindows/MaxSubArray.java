package slindingwindows;

public class MaxSubArray {
    public static void main(String[] args) {

        int[] nums = {2, -1, 3,4};

        int ans = divide(nums, 0, nums.length - 1);
        System.out.println(ans);
    }


    private static int divide(int[] nums, int left, int right) {

        // ✅ Base Case
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // ✅ Divide
        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid + 1, right);

        // ✅ Conquer (Cross sum)
        int crossMax = crossSum(nums, left, mid, right);

        // ✅ Return best of three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private  static int crossSum(int[] nums, int left, int mid, int right) {

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        // Go from mid → left
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        // Go from mid+1 → right
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

}
