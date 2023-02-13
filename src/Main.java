import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int sum = 0;
            int[] items = new int[n];
            for (int i = 0; i < n; i++) {
                items[i] = sc.nextInt();
                sum += items[i];
            }

            int target = sum / 2;
            boolean[][] dp = new boolean[n + 1][target + 1];
            dp[0][0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= target; j++) {
                    if (j >= items[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - items[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            int result = 0;
            for (int i = target; i >= 0; i--) {
                if (dp[n][i]) {
                    result = i;
                    break;
                }
            }

            System.out.println(sum - result + " " + result);
        }
    }
}