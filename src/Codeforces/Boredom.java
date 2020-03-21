package Codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Boredom {
    static long[] dp;   // Don't take integer ... got 5 WA.. I'm stupid!!
    static int size = 100001;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       /* int t = Integer.parseInt(br.readLine());
        while(t-- > 0){*/
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i=0; i<n ;i++)a[i] = Integer.parseInt(s[i]);
            dp = new long[size];
            Arrays.fill(dp,0);
            for(int i=0; i<n; i++){
                dp[a[i]]++;
            }


            long ans = interesting(n);
            System.out.println(ans);
        /*}*/
    }

    private static long interesting(int n){
        for(int i=2; i<size; i++){
            dp[i] = Math.max(dp[i-1] , dp[i-2]+dp[i]*i);
        }

        return dp[size-1];
    }
}
