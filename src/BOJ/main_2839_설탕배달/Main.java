package BOJ.main_2839_설탕배달;

import java.util.Scanner;

public class Main {

    private static final int[] arr1 = {0,-1,-1,1,-1,1,2,-1,2,3,2,3,4,3,4};
    private static final int[] arr2 = {0,4,5,-1,5,-1,-1,6,-1,-1,-1,-1,-1,-1,-1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int Q = N/15;
        int R = N%15;

        if(arr1[R]==-1){
            if(Q==0){
                System.out.print(-1);
            }else {
                System.out.println((Q-1)*3+arr2[R]);
            }
        }else{
            System.out.print(Q*3+arr1[R]);
        }
    }
}
