import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0, j = 0;
        int sum = 0, count = 0;

        while (j < n) {
            sum += arr[j];
            while (i <= j && sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                count++;
            }
            j++;
        }
        System.out.println(count);
    }
}
