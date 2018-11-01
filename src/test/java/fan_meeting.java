import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class fan_meeting {
	
	void normalize(int[] C){
		for(int i = 0; i < C.length - 1; i++){
			C[i + 1] += C[i] / 10;
			C[i] %= 10;
		}
	}
	
	
	int[] multiply(int[] A, int[] B){
		int[] C = new int[A.length + B.length + 1];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B.length; j++){
				C[i + j] += A[i] * B[j];
			}
		}
		normalize(C);
		return C;
	}
	
	int hug(String member, String fan){
		int[] M = new int[member.length()];
		int[] F = new int[fan.length()];
		for(int i = 0; i < M.length; i++){
			if(member.charAt(i) == 'M') M[i] = 1;
		}
		for(int i = 0; i < F.length; i++){
			if(fan.charAt(i) == 'M') F[i] = 1;
		}
		
		int[] C = multiply(M, F);
		
		int ret = 0;
		for(int i = member.length() - 1; i < fan.length(); ++i){
			if(C[i] == 0){
				ret++;
			}	
		}
		return ret;		
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String member = "FFFFM";
		String fan = "FFFFFMMMMF";
		
		int ret = hug(member, fan);
	}

}
