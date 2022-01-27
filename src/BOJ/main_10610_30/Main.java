package BOJ.main_10610_30;

import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String in = br.readLine();
        int[] counts = new int[10];
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for (int i = 0; i < in.length(); i++) {
            int val = in.charAt(i) - '0';
            sum+=val;
            counts[val] +=1;
        }

        if(counts[0]==0|| sum%3!=0){
            sb.append("-1");
        }else{
            for (int i = 9; i >=0 ; i--) {
                for (int j = 0; j < counts[i]; j++) {
                    sb.append((char)(i+'0'));
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
