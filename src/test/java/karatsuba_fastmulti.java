import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class karatsuba_fastmulti {

	
	int[] A = {3,2,1};
	int[] B = {6,5,4};
	int[] C;	
	
	void normalize(){
		for(int i = 0; i < C.length; i++){
			C[i + 1] += C[i] / 10;
			C[i] %= 10;
		}
	}
	
	int[] multiply(int[] A, int[] B){
		C = new int[A.length + B.length + 1];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B.length; j++){
				C[i + j] += A[i] * B[j];
			}			
		}
		normalize();
		return C;
	}	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
