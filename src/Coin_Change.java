//LEET CODE

import java.io.*;
import java.util.Arrays;

public class Coin_Change {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] s = br.readLine().split(" ");

            int len = s.length;
            int[] a = new int[len];
            for(int i=0; i<len; i++){a[i] = Integer.parseInt(s[i]);}

            int sum = Integer.parseInt(br.readLine());

            int ans = coinChange(a, sum);
            System.out.println(ans);
        }
    }

    private static int coinChange(int[] a, int sum){
        int[] dp = new int[sum+1];
        Arrays.fill(dp,sum+1);
        dp[0] = 0;

        for(int i=0; i<=sum; i++){
            for(int j:a){
                if(j <= i)
                    dp[i] = Math.min(dp[i - j]+1,dp[i]);}

        }

        return dp[sum] > sum ? -1 : dp[sum] ;
    }
}