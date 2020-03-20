package Codeforces;

import java.io.*;
import java.util.ArrayList;

public class CutRibbon {
    static ArrayList<Integer> ls;
    static int[] dp;
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            int c = Integer.parseInt(s[3]);
            ls = new ArrayList<>();
            ls.add(a);
            ls.add(b);
            ls.add(c);


            dp = new int[n + 1];
            for(int i=1; i<=n; i++){
                if(i%a == 0 || i%b == 0 || i%c == 0)dp[i] = 1; //Initialize the dp values to 1 for all the multiples of a , b, c
            }                                                  //since this are the only values we will use
            int ans = ribbonCutting(n, ls);                    //and this pieces can finally reduce to smaller a, b, c values.
            System.out.println(ans);

    }

    private static int ribbonCutting(int n, ArrayList<Integer> ls){

        for(int i=1; i<=n; i++){
            for(int j:ls){
                if(i-j >= 0 && dp[i-j] != 0){
                    dp[i] = Math.max(dp[i], dp[i-j]+1);
                }
            }
        }


        return dp[n];
    }
}
