package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

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


    public ArrayList<Integer> getPartialMatch(String N){
        int m = N.length();
        ArrayList<Integer> pi = new ArrayList<Integer>(Collections.nCopies(m, 0));

        int j = 0;
        for(int i = 1; i < m; i++){
            while (j > 0 && N.charAt(j) != N.charAt(i)){
                j = pi.get(j - 1);
            }
            if(N.charAt(j) == N.charAt(i)){
                pi.set(i, ++j);
            }
        }
        return pi;
    }

    public List<Integer>  kmp(String text, String pattern){

        List<Integer> rt = new ArrayList<Integer>();
        ArrayList<Integer> pi = getPartialMatch(pattern);

        int patternSize = pattern.length();
        int matched = 0;
        for(int i = 0; i < text.length(); i++){
            while(matched > 0 && text.charAt(i) != pattern.charAt(matched)){
                matched = pi.get(matched - 1);
            }
            if (text.charAt(i) == pattern.charAt(matched)){
                ++matched;
                if(matched == patternSize) {
                    rt.add(i - patternSize + 1);
                    matched = pi.get(matched - 1);
                }
            }
        }
        return rt;
    }


    @Test
    public void test(){
//        ArrayList<Integer> pi = getPartialMathchNaive("aabaabac");
//        ArrayList<Integer> pi = getPartialMatch("aabaabac");
        String text = "abcabccadeabcdefgdefgabcabcdefg";
        String pattern = "abcdefg";

        List<Integer> rslt = kmp(text, pattern);

        Assert.assertThat(rslt.get(0), is(10));
        Assert.assertThat(rslt.get(1), is(24));

        System.out.println(rslt.get(0));
        System.out.println(rslt.get(1));
//        System.out.println(pi);
    }


}
