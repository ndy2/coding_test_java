package Programmers.K번째수;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int numCommands = commands.length;
        int[] answer = new int[numCommands];

        for (int c = 0; c < numCommands; c++) {
            int from = commands[c][0];
            int to = commands[c][1];
            int targetIdx = commands[c][2];

            int[] subArray = Arrays.copyOfRange(array, from-1, to);
            Arrays.sort(subArray);
            answer[c] = subArray[targetIdx-1];
        }


        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = {1,5,2,6,3,7,4};
        int[][]commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer = solution.solution(array, commands);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
