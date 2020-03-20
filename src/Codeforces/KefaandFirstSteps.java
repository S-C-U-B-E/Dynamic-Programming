package Codeforces;
import java.io.*;
import java.util.Arrays;

public class KefaandFirstSteps {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] a = new int[s.length];

        for(int i=0; i<s.length; i++)a[i] = Integer.parseInt(s[i]);
        int[] dp = new int[s.length];
        Arrays.fill(dp,1);

        int ans = longestSubsegment(a,dp);
        System.out.println(ans);
    }

    private static int longestSubsegment(int[] a, int[] dp){
        int max = 1;
        for(int i=1; i<a.length; i++){
            if(a[i] >= a[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            if(max < dp[i])max = dp[i];
        }

        return max;
    }
}
