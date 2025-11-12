import java.util.Scanner;

public class Experiment_2 {

    // Power function using O(log n) approach (Exponentiation by Squaring)
    public static int power(int x, int y) {
        int result = 1;

        while (y > 0) {
            if (y % 2 == 1) {   // If exponent is odd
                result *= x;
            }
            x = x * x;  // Square the base
            y = y / 2;  // Halve the exponent
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Base value: ");
        int base = sc.nextInt();

        System.out.print("Enter Exponent value: ");
        int exponent = sc.nextInt();

        int ans = power(base, exponent);

        System.out.println("Result (base^exponent): " + ans);

        sc.close();
    }
}
