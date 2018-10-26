import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class permutation {
	
	static int[] arr = {1,2,3,4};
	final int N = 4;
	final int R = 4;
	
	
	public static void print(int k) {

		for (int i = 0; i < k; i++) {
			if (i == k - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}
	
	void swap(int depth, int i){
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
		
	}
	
	void perm(int depth){
		if(depth == R){
			print(R);
			return;
		}
		
		for(int i = depth; i < N; i++){
			swap(depth, i);
			perm(depth + 1);
			swap(depth, i);
		}
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		perm(0);
	}

}
