//Codechef//Easy Tiling
import java.io.*;

public class EasyTiling {

    static long MOD = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            long n = Long.parseLong(br.readLine());

            if(n == 1) System.out.println(1);
            else if(n == 2) System.out.println(2);
            else{
                n--;
                long[][] M = {{1,1},{1,0}};
                long[][] Identity = {{1,0},{0,1}};
                long[] f = {1,1};
                while(n > 0){
                    if((n & 1) == 1){
                        Identity = multiply(Identity,M);
                    }
                    M = multiply(M,M);
                    n = n >> 1;
                }

                long ans = (Identity[0][0] + Identity[0][1])%MOD;
                System.out.println(ans);
            }

        }
    }

    private static long[][] multiply(long[][] A,long[][] B){
        long a = (A[0][0]*B[0][0] + A[0][1]*B[1][0])%MOD;
        long b = (A[0][0]*B[0][1] + A[0][1]*B[1][1])%MOD;
        long c = (A[1][0]*B[0][0] + A[1][1]*B[1][0])%MOD;
        long d = (A[1][0]*B[0][1] + A[1][1]*B[1][1])%MOD;

        A[0][0] = a;
        A[0][1] = b;
        A[1][0] = c;
        A[1][1] = d;

        return A;
    }
}
