package Codeforces;
import java.io.*;
import java.util.Arrays;

public class GivenLengthandSumofDigits {
    static int map ;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*int t = Integer.parseInt(br.readLine());
        while(t-- > 0){*/
            String[] st = br.readLine().split(" ");
            int m = Integer.parseInt(st[0]);
            int s = Integer.parseInt(st[1]);
            map = m*9;

            if(m > 1 && s == 0)System.out.println(-1+" "+-1);  // Edge case
            else if(m == 1 && s == 0)System.out.println(0+" "+0); // Edge case
            else {
                int[] min = minimum(m, s);
                int[] max = maximum(m, s);
                if (min != null) {
                    for (int i : min) System.out.print(i);
                } else {
                    System.out.print(-1);
                }
                System.out.print(" ");
                if (max != null) {
                    for (int i : max) System.out.print(i);
                } else {
                    System.out.print(-1);
                }
                System.out.println();
            }
        /*}*/
    }

    /*
    * fill all the places with zeros
    * start from least significant position
    * fill up starting from that position with largest number possible in 1 to 9 such that the required sum is NOT meet
    * If at any position, putting a value meets the sum.. then
    * 1). if (the position is not 0th index) --> the value is 1 .. put it at the 0th index .. making all the numbers in between 0
    * 2). if (the position is 0th indedx) --> put the value remaining to complete the sum
    *
    * */
    private static int[] minimum(int m, int s){
        if(s > map)return null; // if putting all positions with 9 can't reach the sum... then how any smaller
                                            //number will reach it.. hence return null.

        int currentval = 0;

        int[] min = new int[m];
        Arrays.fill(min,0);
        int i;
        for(i=m-1; i>=0; i--){
            int increase = s - currentval;
            if(increase == 1)break;
            else{
                if(increase >= 9 && increase-9 != 0){min[i] = 9;}
                else if(i>0){ min[i] = (increase-1);}
                else {min[i] = increase;}
                currentval += min[i];
            }
        }

        if(i>=0)min[0] = 1;
        return min;
    }

    /*
    * this part is easier but similar
    * figure it out yourself!!!
    *
    * enjoy
    * */
    private static int[] maximum(int m, int s){
        if(s > map)return null;

        int currentval = m*9;

        int[] max = new int[m];
        Arrays.fill(max,9);
        for(int i=m-1; i>=0; i--){
            if(s == currentval)break;
            else{
                int decrease = currentval-s;
                if(decrease > 9)max[i] = 0;
                else max[i] -= decrease;
                currentval = currentval - 9 + max[i];
            }
        }

        return max;
    }
}
