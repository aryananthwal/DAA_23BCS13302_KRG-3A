import java.util.*;

public class Experiment_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter elements in the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // LinkedHashMap maintains insertion order like vector 'order' in C++
        Map<Integer, Integer> freq = new LinkedHashMap<>();

        for (int element : arr) {
            freq.put(element, freq.getOrDefault(element, 0) + 1);
        }

        System.out.println("\nFrequency of elements:");
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        sc.close();
    }
}
