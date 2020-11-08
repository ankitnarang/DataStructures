package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AttendMeetings {

    public static void main(String[] args) {
        ArrayList<MeetingInterval> intervals = new ArrayList<>();
        MeetingInterval interval = new MeetingInterval(17,10);
        intervals.add(interval);
        interval = new MeetingInterval(2,4);
        intervals.add(interval);
        /*
        MeetingInterval interval = new MeetingInterval(0,30);
        intervals.add(interval);
        interval = new MeetingInterval(5,10);
        intervals.add(interval);
        interval = new MeetingInterval(15,20);
        intervals.add(interval);
         */

        System.out.println("Can attend meetings? " + canAttendMeetings(intervals));
    }

    private static boolean canAttendMeetings(ArrayList<MeetingInterval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for(int i = 0; i < starts.length-1; i++){
            if(starts[i+1] < ends[i]){
                return false;
            }
        }
        return true;
    }
}
class MeetingInterval {
    int start;
    int end;
    MeetingInterval(){
        start = 0;
        end = 0;
    }
    MeetingInterval(int s, int e){
        this.start = s;
        this.end = e;
    }
}
