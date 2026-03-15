package string;


public class MultiplyString {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String ans = multiplyString(num1, num2);
        System.out.println(ans);

    }

    private static String multiplyString(String num1, String num2) {

        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + res[p2];

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int num : res) {
            if (!(sb.isEmpty() && num == 0)) {
                sb.append(num);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}

