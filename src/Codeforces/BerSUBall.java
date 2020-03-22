package Codeforces;
import java.io.*;
import java.util.Arrays;

/*
*
* No idea ... why this is tagged DP!!!!
*
* */

public class BerSUBall {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i=0;i<n;i++){a[i] = Integer.parseInt(s[i]);}
        int m = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        int[] b = new int[m];
        for(int i=0;i<m;i++){b[i] = Integer.parseInt(s[i]);}

        Arrays.sort(a);Arrays.sort(b);

        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (Math.abs(a[i] - b[j]) <= 1) {
                    b[j] = 1000;
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
