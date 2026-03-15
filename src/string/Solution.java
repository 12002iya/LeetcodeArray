package string;

import java.util.*;

class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {

                k = k * 10 + (ch - '0');
            } else if (ch == '[') {

                counts.push(k);
                resultStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {

                int count = counts.pop();
                StringBuilder temp = resultStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {

                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("3[a2[b]]")); // Output: abbabbabb
       // System.out.println(sol.decodeString("2[ab]"));    // Output: abab
      //  System.out.println(sol.decodeString("3[a]2[bc]")); // Output: aaabcbc
    }
}