package Programmers.다리를지나는트럭;

import java.util.*;

class Truck{
    int weight;

    public Truck(int weight){
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "weight=" + weight +
                '}';
    }
}

class Bridge{
    int length;
    int tolarance;
    Queue<Truck> bridge;

    public Bridge(int length, int tolarance){
        this.length = length;
        this.tolarance = tolarance;
        this.bridge = new LinkedList<>();
        for(int i = 0 ; i < length ; i++){
            bridge.add(null);
        }
    }

    public boolean canLoad(Truck truck){
        return tolarance-truck.weight>0;
    }

    public void moveForward(Queue<Truck> arrivedQ){
        Truck arrivedTruck = bridge.poll();
        if(arrivedTruck!=null){
            tolarance+=arrivedTruck.weight;
            arrivedQ.add(arrivedTruck);
        }
    }

    public void load(Truck truck){
        bridge.add(truck);
        if(truck!=null){
            tolarance-=truck.weight;
        }
        else{
            bridge.remove();
        }
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> arrivedQ = new LinkedList<>();

        int l = truck_weights.length;
        for(int i =0 ; i < l ; i ++){
            waitQ.add(new Truck(truck_weights[i]));
        }

        int time = 0;
        Bridge bridge = new Bridge(bridge_length, weight);

        while(arrivedQ.size()<l){
            time+=1;
            Truck frontTruck = waitQ.peek();
            System.out.println("frontTruck = " + frontTruck);

            bridge.moveForward(arrivedQ);
            if(frontTruck==null||!bridge.canLoad(frontTruck)) bridge.load(null);
            else{
                bridge.load(frontTruck);
                waitQ.remove();
            }
        }
        return time;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int l =2;
        int w =10;
        int[] t = {7,4,5,6};

        System.out.println(solution.solution(l,w,t));
    }


}
