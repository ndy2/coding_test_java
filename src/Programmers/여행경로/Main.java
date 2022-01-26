package Programmers.여행경로;

import java.util.*;


class Solution {

    static Map<String,Queue<String>> tickets;
    static int targetDepth;
    static Deque<String> flightOrders = new ArrayDeque<>();


    private static void setTickets(String[][] ticketsArr){
        int l = ticketsArr.length;
        tickets = new HashMap<>();

        for(int i = 0 ; i < l ; i++){
            String from = ticketsArr[i][0];
            String to = ticketsArr[i][1];

            if(!tickets.containsKey(from)){
                tickets.put(from, new PriorityQueue<>());
            }

            tickets.get(from).add(to);
        }
    }

    private static void printTickets(){
        Set<String> keySet = tickets.keySet();
        Iterator<String> iter = keySet.iterator();

        while(iter.hasNext()){
            String from = iter.next();
            System.out.print("From : " + from +" ");

            Iterator<String> qIter = tickets.get(from).iterator();
            System.out.print("Dest : ");
            while(qIter.hasNext()){
                System.out.print(qIter.next()+" ");
            }
            System.out.println();
        }
    }

    public static void setAnswer(){
        Iterator<String> iter = flightOrders.iterator();
        answer = new String[targetDepth+2];
        int idx = targetDepth+1;
        while(iter.hasNext()){
            answer[idx--] = iter.next();
        }
    }

    private static void dfs(String from, int depth){
        flightOrders.push(from);
        if(depth == targetDepth+1){
            setAnswer();
            flightOrders.pop();

            return;
        }

        if(tickets.get(from).isEmpty()){
            return;
        }

//        String next = tickets.get(from).poll();
//        dfs(next, depth+1);
//        tickets.get(from).add(next);

        Queue<String> dests = tickets.get(from);
        Iterator<String> iter = dests.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            System.out.println("next = " + next);
            dests.remove(next);
            dfs(next,depth+1);
            dests.add(next);
        }

        flightOrders.pop();
    }

    static String[] answer;
    public String[] solution(String[][] ticketsArr) {

        targetDepth = ticketsArr.length-1;
        setTickets(ticketsArr);
        printTickets();

        dfs("ICN",0);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] ticketsArr =
                {
                        {"ICN", "JFK"},
                        {"HND", "IAD"},
                        {"JFK", "HND"}
                };

        String[][] ticketsArr2 = {
                {"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}
        };
        for(String s : solution.solution(ticketsArr2)){
            System.out.println(s);
        }
    }
}
