import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

class SquareMatrix{
	
}

public class fastsum {

	int fastSum(int n){
		if(n == 1) return 1;
		if(n % 2 == 1) return fastSum(n - 1) + n;
		return 2 * fastSum(n / 2) + (n / 2) * (n / 2);
	}
	
	/*SquareMatrix identity(int n){
		return new SquareMatrix();
	}
	
	SquareMatrix pow(SquareMatrix A, int n){
		if(n == 0) return identity(n);
		if(n % 2 > 0) return pow(A - 1) * A;
		return pow(A, n / 2) * pow(A, n / 2); 
	}*/
	
	
	
	
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
