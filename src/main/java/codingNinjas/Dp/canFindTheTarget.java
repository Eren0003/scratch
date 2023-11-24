package codingNinjas.Dp;

public class canFindTheTarget {

    public static void main(String args[]) {
        int arr[] = { 2 , 3 , 1 , 1 };
        int k = 4;
        int n = arr.length;
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
    static boolean subsetSumToK(int n, int tar, int[] arr) {
        boolean dp[][] = new boolean[n][tar + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= tar) {
            dp[0][arr[0]] = true;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= tar; target++) {
                boolean notTaken = dp[ind - 1][target];
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][tar];
    }
}
