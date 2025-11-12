import java.util.*;

public class Experiment_9 {

    // Function to find all occurrences of pattern P in string S
    static List<Integer> findOccurrences(String S, String P) {
        List<Integer> positions = new ArrayList<>();
        int n = S.length();
        int m = P.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (S.charAt(i + j) != P.charAt(j))
                    break;
            }
            if (j == m)
                positions.add(i);
        }
        return positions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String S = sc.nextLine();

        System.out.print("Enter pattern: ");
        String P = sc.nextLine();

        List<Integer> result = findOccurrences(S, P);

        if (result.isEmpty()) {
            System.out.println("Pattern not found");
        } else {
            System.out.print("Pattern found at indices: ");
            for (int pos : result)
                System.out.print(pos + " ");
            System.out.println();
        }

        sc.close();
    }
}
