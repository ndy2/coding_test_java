package Programmers.가장큰수;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Comp implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String s1 = o1.toString() + o2.toString();
        String s2 = o2.toString() + o1.toString();
        return s2.compareTo(s1);
    }
}

class Solution {
    public String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();
        List<Integer> nums = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        int sum = IntStream.of(numbers).sum();
        if(sum == 0){
            return "0";
        }
        nums.sort(new Comp());
        nums.forEach(n->sb.append(n.toString()));
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        int [] numbers1 = {6,10,2};
        int [] numbers2 = {3,30,34,5,9};

        Solution solution = new Solution();
        System.out.println("solution = " + solution.solution(numbers1));
        System.out.println("solution = " + solution.solution(numbers2));

    }
}
