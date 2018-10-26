import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AlgorithmApplication.class)
@WebAppConfiguration
public class AlgorithmApplicationTests {

	//@Test
	public void contextLoads() {		
		
	}
	

	
	
	

	
	
	
	//@Test
	public void test_선형시간_이동평균_구하기(){
		List<Double> ret = new ArrayList<Double>();
		Double[] A = new Double[1000000]; 
		int M = 100;
		
		for(int i = 0; i < A.length; i++){
			A[i] = Math.random() * (180 - 100 + 1);
		}
		
		double partialSum = 0;
		for(int i = 0; i < M; i++){
			partialSum += A[i];
		}
		
		for(int i = M - 1; i < A.length; i++){
			partialSum += A[i];
			ret.add(partialSum);
			partialSum -= A[i - (M - 1)];			
		}
		
		assertThat(1, is(4));
	}
	
	
	//@Test
	public void test_선택정렬(){
		int[] A = new int[10];
		for(int i = 0; i < 10; i++){
			A[i] = (int)Math.random() * (20 - 1 + 1);
		}
		for(int i = 0; i < 10; i++){
			int minIndex = i;
			for(int j = i + 1; j < 10; j++){
				if(A[minIndex] > A[j]){
					minIndex = j;
				}
			}
			int temp = A[minIndex];
			A[minIndex] = A[i];
			A[i] = temp;	
			
		}
	}
	
	//@Test
	public void test_삽입정렬(){
		int[] A = new int[10];
		for(int i = 0; i < 10; i++){
			A[i] = (int)Math.random() * (20 - 1 + 1);
		}
		for(int i = 0; i < A.length; i++){
			int j = i;
			while(j > 0 && A[j - 1] > A[j]){
				int temp = A[j - 1];
				A[j - 1] = A[j];
				A[j] = temp;				
				--j;
			}
		}
	}
	
	public int recursiveSum(int n){
		if(n == 1) return 1;
		return n + recursiveSum(n - 1);
	}
	
	//@Test
	public void test_메뉴고르기(){
		
	}
}
