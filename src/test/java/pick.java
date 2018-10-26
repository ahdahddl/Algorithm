import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class pick {

	final int PICK = 4;
	final int N = 5;
	List<Integer> buf = new ArrayList<Integer>();
	
	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void test_완전탐색(){
		pickSome(N, PICK);
	}	

	void pickSome(int n, int index){
		if(index == 0){
			System.out.println(buf);
			return;
		}
		
		int smallest = buf.isEmpty() ? 0 : buf.get(buf.size() - 1) + 1; 
		for(int i = smallest; i < N; i++){
			buf.add(i);
			pickSome(n, index - 1);
			buf.remove(buf.size() - 1);
		}
	}
	
}
