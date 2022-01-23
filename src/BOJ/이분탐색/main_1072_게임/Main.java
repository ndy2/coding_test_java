package BOJ.이분탐색.main_1072_게임;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long x,y;
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        y = scan.nextInt();

        long z = y*100L/x;
        if(z >=99){
            System.out.println(-1);
            return;
        }

        long begin = 1;
        long end =2*x;
        long ans = 2*x;
//        System.out.println("z : " + z);
        while(begin<=end){
            long mid = (begin+end)/2;
            long z2 = (y+mid)*100/(x+mid);

//            System.out.println("begin : " + begin + " mid : " + mid + " end : " + end + " z2 : " + z2);

            //답의 가능성이 있다. 더 줄여본다.
            if(z2>z){
                ans = Long.min(ans, mid);
                end = mid-1;
            }
            //찾는 범위를 더 위로 올려야함
            else{
                begin = mid+1;
            }
        }
        System.out.println(ans);
        scan.close();
    }
}
