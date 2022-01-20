package Programmers.타겟넘버;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    static int len;
    static int ans;
    static int targetNumber;
    static List<Integer> list = new ArrayList<>();

    public int solution(int[] numbers, int target) {
        len = numbers.length;
        targetNumber = target;
        list.add(0);
        IntStream.of(numbers).forEach(list::add);
        dfs(1,0);
        return ans;
    }

    private void dfs(int depth, int val) {
//        System.out.println("depth = " + depth + ", val = " + val);
        if(depth == len+1){
            if(val == targetNumber){
                ans+=1;
            }
        }else{
            dfs(depth+1, val+list.get(depth));
            dfs(depth+1, val-list.get(depth));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        Solution solution = new Solution();
        System.out.println(solution.solution(numbers,target));
    }
}
