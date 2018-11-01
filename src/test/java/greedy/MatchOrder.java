package greedy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatchOrder {

    private int[] russians = null;
    private int[] koreans = null;

    private int max_k = 0;
    private int min_k = 0;

    public int matchOrder(){

        for(int i = 0; i < russians.length; i++){
            // 해당 순서에서 가장 점수가 많은 한국 선수가 이길 수 없을 때,
            // 가장 점수가 낮은 한국 선수를 경기시킨다.
//            if(russians[i] > koreans){
//                // 지는 경우
//
//            }else{
//
//            }
        }

        return -1;
    }

    @Before
    public void set(){

        russians = new int[6];
        russians[0] = 3000;
        russians[1] = 2700;
        russians[2] = 2800;
        russians[3] = 2200;
        russians[4] = 2500;
        russians[5] = 1900;

        koreans = new int[6];
        koreans[0] = 2800;
        koreans[1] = 2750;
        koreans[2] = 2995;
        koreans[3] = 1800;
        koreans[4] = 2600;
        koreans[5] = 2000;


    }


    @Test
    public void test(){
        int result = -1;
//        Assert.assertThat(result, CoreMatchers.is(10));
    }
}


