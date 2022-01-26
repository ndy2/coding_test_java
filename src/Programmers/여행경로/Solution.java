import java.util.*;

class Ticket{
    String dest;
    int idx;

    public Ticket(String dest, int idx){
        this.dest = dest;
        this.idx = idx;
    }
}

class Solution {
    static int numTickets;
    static int targetDepth;
    static List<String> flightOrders;
    static Set<String> airports;
    static Map<String,Set<Ticket>> visited;
    static Map<String,List<Ticket>> tickets;


    private static void initAirports(String[][] ticketsArr){
        airports = new HashSet<>();
        for(String[] ticket : ticketsArr){
            airports.add(ticket[0]);
            airports.add(ticket[1]);
        }
    }

    private static void initTickets(String[][] ticketsArr){
        tickets = new HashMap<>();
        Iterator<String> iter = airports.iterator();
        while(iter.hasNext()){
            String next = iter.next();
            tickets.put(next, new ArrayList<>());
        }

        int ticketIdx = 0;
        for(String[] ticket : ticketsArr){
            tickets.get(ticket[0]).add(new Ticket(ticket[1],ticketIdx));
        }
    }

    private void initVisited(){
        visited = new HashMap<>();

        Iterator<String> iter = airports.iterator();
        while(iter.hasNext()){
            visited.put(iter.next(), new HashSet<>());
        }

    }

    private void dfs(String from, String flightOrder, int depth){
        if(depth==numTickets){
            flightOrders.add(flightOrder.toString());
            return;
        }
        for(Ticket ticket : tickets.get(from)){
            if(!visited.get(ticket.dest).contains(ticket)){
                visited.get(ticket.dest).add(ticket);
                dfs(ticket.dest , flightOrder+" "+ticket.dest , depth+1);
                visited.get(ticket.dest).remove(ticket);
            }
        }
    }

    public String[] solution(String[][] ticketsArr) {
        String[] answer = {};
        numTickets = ticketsArr.length;
        targetDepth = numTickets+1;
        flightOrders = new ArrayList<>();
        initAirports(ticketsArr);
        initTickets(ticketsArr);
        initVisited();

        dfs("ICN","ICN" , 0);
        Collections.sort(flightOrders);



        // return answer;
        return flightOrders.get(0).split(" ");
    }
}