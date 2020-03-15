import java.io.*;

public class StairCase {
    private static long MOD = (long)Math.pow(10,9)+7;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            long ans = stair(n);
            System.out.println(ans);
        }
    }

    private static long stair(int n){
        long[] st = new long[n+1];
        if(n == 0) return 1;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        st[0] = 1;
        st[1] = 1;
        st[2] = 2;

        for(int i=3;i<=n;i++){
            st[i] = (st[i-1]+st[i-2]+st[i-3])%MOD;
        }

        return st[n];
    }
}
