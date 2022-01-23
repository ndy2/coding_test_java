package Programmers.베스트앨범;

import java.util.*;
import java.io.*;

class PlayInfo implements Comparable<PlayInfo>{
    int play;
    int idx;

    public PlayInfo(int play, int idx){
        this.play = play;
        this.idx= idx;
    }

    @Override
    public int compareTo(PlayInfo o){
        return o.play-play;
    }
}

class PQ extends PriorityQueue<PlayInfo>{

    public void addData(int play, int idx){
        add(new PlayInfo(play,idx));
    }
}

class Info implements Comparable<Info>{
    String genre;
    int plays;

    public Info(String genre, int plays){
        this.genre = genre;
        this.plays = plays;
    }

    @Override
    public int compareTo(Info o){
        return o.plays-plays;
    }
}


class Data{

    Queue<Info> pq = new PriorityQueue<>();
    HashMap<String,Integer> map = new HashMap<>();
    HashMap<String,PQ> playsMap = new HashMap<>();

    void addData(String genre, int play, int idx){
        if(map.containsKey(genre)){
            map.replace(genre,map.get(genre)+play);
        }else{
            map.put(genre,play);
            playsMap.put(genre, new PQ());
        }
        playsMap.get(genre).addData(play,idx);
    }

    void initPQ(){
        for(String key : playsMap.keySet()){
            pq.add(new Info(key,map.get(key)));
        }
    }

    List<String> getGenres(){
        initPQ();
        List<String> genres = new ArrayList<>();
        while(!pq.isEmpty()){
            genres.add(pq.poll().genre);
        }
        return genres;
    }

    int[] getAns(){
        List<Integer> ansList = new ArrayList<>();

        for(String genre : getGenres()){
            PQ playInfos = playsMap.get(genre);
            int count = 0;
            while(!playInfos.isEmpty()&&count<2){
                ansList.add(playInfos.poll().idx);
                count+=1;
            }
        }
        return ansList.stream().mapToInt(i->i).toArray();
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        int size = genres.length;
        Data data = new Data();
        for(int i= 0 ; i < size ; i++){
            data.addData(genres[i],plays[i],i);
        }

        int[] ans = data.getAns();
        return ans;
    }
}

public class Main {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] my = solution.solution(genres,plays);
        for(int i = 0 ; i < my.length; i++){
            System.out.println(my[i]);
        }
    }
}
