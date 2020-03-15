//SPOJ
/*
*
* INTERESTING FORMULA LEARNED
* BINET'S FORMULA FOR SUM OF A RANGE OF FIBONACCI NUMBERS
*
* S(N) = F(N+2) - 1 ;
*
* AND
*
* S(L,R) = F(R+2) - F(L+1) ;
*
*
*
*
* */

import java.io.*;

public class FIBOSUM {

    static long MOD = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] s = br.readLine().split(" ");
            long n = Long.parseLong(s[0]);
            long m = Long.parseLong(s[1]);
            m+=2;
            n+=1;


            m--;
            long[][] M = {{1,1},{1,0}};
            long[][] IdentityM = {{1,0},{0,1}};

            while(m > 0){
                if((m & 1) == 1){
                    IdentityM = multiply(IdentityM,M);
                }
                M = multiply(M,M);
                m = m >> 1;
            }

            long ansM = (IdentityM[0][0])%MOD;

            n--;
             long[][] N = {{1,1},{1,0}};
             long[][] IdentityN = {{1,0},{0,1}};

            while(n > 0){
                if((n & 1) == 1){
                    IdentityN = multiply(IdentityN,N);
                }
                N = multiply(N,N);
                n = n >> 1;
            }

                long ansN = (IdentityN[0][0])%MOD;
                long sum = (ansM - ansN + MOD)%MOD;

            System.out.println(sum);

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
