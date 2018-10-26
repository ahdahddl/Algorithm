import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class binomial_coefficient {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	int[][] cache = new int[30][30];
	int bino(int n, int r){
		if(r == 0 || n == r) return 1;
		if(cache[n][r] != -1){
			return cache[n][r];
		}
		return bino(n - 1, r - 1) + bino(n - 1 , r);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
