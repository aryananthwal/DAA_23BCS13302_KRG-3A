import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        System.out.println(smallestWindow(s, t));
    }

    public static int smallestWindow(String s, String t) {
        int[] freq = new int[256];
        int reqd = t.length(); 

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < s.length()) {
            char c = s.charAt(j);

            if (freq[c] > 0) {
                reqd--;
            }

            freq[c]--;
            j++;

            while (reqd == 0) {

                minLen = Math.min(minLen, j - i);

                char left = s.charAt(i);
                freq[left]++;

                if (freq[left] > 0) {
                    reqd++;
                }

                i++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}
