package Programmers.HIndex;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        if(len == 1){
            return citations[0];
        }

        for (int i = 0; i < len; i++) {
            int hIndex = citations[i];
            int overHIndex = len-i;
            int underHIndex = i;
            System.out.println("overHIndex = " + overHIndex+ " hIndex = " + hIndex + "// underHIndex = " + underHIndex+ " hIndex = " + hIndex);
            if(overHIndex<hIndex || underHIndex >hIndex){
                return citations[i-1];
            }
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        int [] citations = {3,0,6,1,5};
//        int[] citations = {1,2};
//        int[] citations={777};
//        int[] citations={3,1,1,1,4};

        Solution solution = new Solution();
        System.out.println(solution.solution(citations));
    }
}
