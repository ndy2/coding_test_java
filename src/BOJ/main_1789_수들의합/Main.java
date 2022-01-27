package BOJ.main_1789_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Long in = Long.parseLong(br.readLine());

        long n =1;
        long sum=0;
        while(sum < 4294967295L && sum<=in){
            sum = (n*n+n)/2;
//            System.out.println(n +" " + sum);
            n++;
        }
        System.out.println(n-2);
        br. close();
    }
}
