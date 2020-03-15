//LEET CODE
/*
*
* very much similar concept as coin change!!
*
* */
import java.io.*;

public class MinimumCostForTickets {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] s = br.readLine().split(" ");
            int[] days = new int[s.length];
            for(int i=0;i<s.length;i++)days[i] = Integer.parseInt(s[i]);

            s = br.readLine().split(" ");int[] cost = new int[s.length];
            for(int i=0;i<s.length;i++)cost[i] = Integer.parseInt(s[i]);

            int ans = mincostTickets(days,cost);
            System.out.println(ans);

        }
    }

    private static int mincostTickets(int[] days, int[] costs) {

        int maxday = days[days.length - 1];

        int[] dp = new int[maxday + 1];
        boolean[] dpb = new boolean[maxday + 1];

        for (int i : days) dpb[i] = true;

        for (int i = 1; i <= maxday; i++) {
            if (!dpb[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]);
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]);
        }
        return dp[maxday];
    }
}
