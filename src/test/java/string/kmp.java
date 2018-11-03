package string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class kmp {

    // naive patial match
    public ArrayList<Integer> getPartialMathchNaive(String N){
        int m = N.length();
        ArrayList<Integer> pi = new ArrayList<Integer>(Collections.nCopies(m, 0));

        for(int begin = 1; begin < m; begin++){
          for(int i = 0; i + begin < m; i++){
            if(N.charAt(i) != N.charAt(i + begin)) break;
            // 현재보다 왼쪽에 있는 시작 위치에서 이 위치에 값을 이미 갱신했을지도 모르기 때문
            pi.set(i + begin, Math.max((Integer) pi.get(i + begin), i + 1));
          }
        }

        return pi;
    }

    @Test
    public void test(){
        ArrayList<Integer> pi = getPartialMathchNaive("aabaabac");
        System.out.println(pi);

    }


}
