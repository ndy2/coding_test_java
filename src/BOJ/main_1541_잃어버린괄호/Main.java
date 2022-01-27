package BOJ.main_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String expression = br.readLine();
        String[] sums = expression.split("-");
        int l = sums.length;

        int[] vals = new int[l];
        for (int i = 0; i < l; i++) {
            vals[i] = calcSum(sums[i]);
        }
        int ans = vals[0];
        for (int i = 1; i < l; i++) {
            ans -= vals[i];
        }
        System.out.println(ans);
    }

    private static int calcSum(String sum) {

        String[] sums = sum.split("\\+");
        int ret = 0;
        for (int i = 0; i < sums.length; i++) {
            ret += Integer.parseInt(sums[i]);
        }
        return ret;

    }
}
