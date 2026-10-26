package complexity;

public class EditDistance {

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";

        int minSteps = findMinSteps(str1, str2);
        System.out.println(minSteps);
    }

    private static int findMinSteps(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <=n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }

        return dp[m][n];

    }
}
