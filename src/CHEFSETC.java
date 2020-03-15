//BIT-MASK

import java.io.*;
public class CHEFSETC {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] s = br.readLine().split(" ");

            int len = s.length;
            int[] a = new int[len];
            for(int i=0; i<len; i++){a[i] = Integer.parseInt(s[i]);}

            int tot = 1 << len;

            int done = 0;
            for(int i=1; i<tot ; i++){
                int sum = 0;
                for(int j=0; j<4; j++){
                    int chck = 1 << j;
                    if((i & chck) != 0){
                        sum += a[j];
                    }
                }
                if(sum == 0){done = 1;break;}
            }

            if(done == 1) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
