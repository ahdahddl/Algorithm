package greedy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 문제 :
 * 회사에 회의실이 하나밖에 없는데, n( <=100)개의 팀이 각각 회의하고 싶은 시간을 제출했다.
 * 두 침이 회의실을 같이 쓸 수는 없기에 이 중 겹치지 않는 회의들만을 골라서 진행해야 한다.
 * 최대 몇 개나 선택할 수 있을까?
 */
public class scheduleMeetingRoom {

    private MeetingSchedule[] schedules = null;


    class MeetingSchedule implements Comparable<MeetingSchedule>{
       private int begin;
       private int end;

       public MeetingSchedule(int begin, int end){
           this.setBegin(begin);
           this.setEnd(end);
       }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(MeetingSchedule o) {
            if(this.end < o.getEnd()){
                return -1;
            } else if(this.end > o.getEnd()){
                return 1;
            }
            return 0;
        }
    }


    public int schedule(){

        int earliest = 0;
        int selected = 0;
        for(int i = 0; i < schedules.length; i++){
            int meetingBegin = schedules[i].getBegin();
            int meetingEnd = schedules[i].getEnd();

            if(earliest <= meetingBegin){
                earliest = meetingEnd;
                selected++;
            }
        }

        return selected;
    }

    @Test
    public void test(){

        Arrays.sort(schedules);
        System.out.print(schedules);

        int rslt = schedule();
    }


    @Before
    public void set(){
        schedules = new MeetingSchedule[11];

        schedules[0] = new MeetingSchedule(2,4);
        schedules[1] = new MeetingSchedule(2,7);
        schedules[2] = new MeetingSchedule(1,4);
        schedules[3] = new MeetingSchedule(5,9);
        schedules[4] = new MeetingSchedule(3,5);
        schedules[5] = new MeetingSchedule(8,10);
        schedules[6] = new MeetingSchedule(2,4);
        schedules[7] = new MeetingSchedule(6,9);
        schedules[8] = new MeetingSchedule(1,7);
        schedules[9] = new MeetingSchedule(8,9);
        schedules[10] = new MeetingSchedule(9,10);
    }
}
