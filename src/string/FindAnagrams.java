package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";

        String p = "abc";

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> ans = findAnagram(s, p);
        System.out.println(ans);


    }

    private static List<Integer> findAnagram(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];


        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {


            sCount[s.charAt(i) - 'a']++;


            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }


            if (Arrays.equals(pCount, sCount)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;


    }
}
