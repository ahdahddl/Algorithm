import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class bino {

	int[][] cache = new int[30][30];
	
	int bino2(int n, int r){
		if(cache[n][r] != -1)
			return cache[n][r]; 
		
		return bino2(n - 1, r - 1) + bino2(n - 1, r);
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
