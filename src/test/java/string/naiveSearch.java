package string;


import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class naiveSearch {

    private String Haystack = "adfdsasafaefadfaef";
    private String Search = "faef";

    @Test
    public void test(){
        List<Integer> locationMatched = new ArrayList<Integer>();
        search(Haystack, Search, locationMatched);
        assertThat(locationMatched.get(0), Is.is(8));
    }

    public static void search(String haystack, String search, List<Integer> locationMatched){
        for(int i = 0; i + search.length() < haystack.length(); i++){
            boolean matched = true;
            for(int j = 0; j < search.length(); j++){
                if(haystack.charAt(i + j) != search.charAt(j)){
                    matched = false;
                    break;
                }
            }
            if(matched) {
                locationMatched.add(i);
            }
        }
    }
}
