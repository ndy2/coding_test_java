package BOJ.main_1931_회의실배정;

import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting>{
    int begin,end;

    public Meeting(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        return end==o.end?begin-o.begin:end-o.end;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static List<Meeting> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        int numMeeting = 0;
        Meeting confirmed= new Meeting(0,0);

        for (int i = 0; i < list.size(); i++) {
            Meeting curMeeting = list.get(i);
            if(confirmed.end<= curMeeting.begin){
                confirmed = curMeeting;
                numMeeting+=1;
            }
        }
        System.out.println(numMeeting);
    }
}
