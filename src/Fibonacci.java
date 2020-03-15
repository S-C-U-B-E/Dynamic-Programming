import java.io.*;
public class Fibonacci {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        long[] f = new long[q]; // DON'T TAKE INTS ;)
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<q; i++){
            f[i] = f[i-1] + f[i-2];
        }

        System.out.println(f[q-1]);

    }
}
