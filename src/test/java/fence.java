import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class fence {

	int[] fenceHeights = {7,1,5,9,6,7,3};
	
	int getMaxRectangleArea(int index, int maxCurrentRectArea){
		if(index == fenceHeights.length){
			return -1; 
		}
		
		for(int i = 0; i < fenceHeights.length; i++){
			
		}
		return -1;
		
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
