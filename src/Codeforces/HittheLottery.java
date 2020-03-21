package Codeforces;
/*
*
*NO NEED OF A DP TAG I GUESS
* */
import java.io.*;
public class HittheLottery {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long hb = n/100;
        long hbr = n%100;
        long twb = hbr/20;
        long twr = hbr%20;
        long teb = twr/10;
        long ter = twr%10;
        long fb = ter/5;
        long fr = ter%5;
        long ob = fr;

        System.out.println(hb+twb+teb+fb+ob);
    }
}
