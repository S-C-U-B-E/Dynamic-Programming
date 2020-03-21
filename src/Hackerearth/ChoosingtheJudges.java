/*
* SIMILAR AND EASIER
* than Codeforces Boredom
*
* */

package Hackerearth;
import java.io.*;

public class ChoosingtheJudges {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int j=1;j<=t;j++){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            long[] dp = new long[n+1];
            for(int i=1;i<=n;i++)dp[i] = Integer.parseInt(s[i-1]);

            long ans = points(dp, n);
            System.out.println("Case "+j+": "+ans);
        }
    }

    private static long points(long[] dp, int n){
        for(int i=1;i<=n;i++){
            dp[i] = Math.max(dp[i-1], dp[Math.max(i-2,0)]+dp[i]);
        }
        return dp[n];
    }
}
