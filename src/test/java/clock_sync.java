import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class clock_sync {

	final int CLOCKS = 16;
	final int SWITCHES = 10;
	final int[] Clocks = new int[CLOCKS];
	final char[][] Linked = new char[SWITCHES][CLOCKS];
//	final char[][] Linked = 
//		{
//				"XXX.............",
//				"...X...X.X.X....",
//				"....X.....X...XX",
//				"X...XXXX........",
//				"......XXX.X.X...",
//				"X.X...........XX",
//				"...X..........XX",
//				"....XX.X......XX",
//				".XXXXX..........",
//				"...XXX...X...X.."
//		};
	
	void push(int swtch){
		for(int clock = 0; clock < CLOCKS; clock++){
			if(Linked[swtch][clock] == 1){
				Clocks[clock] += 3;
				if(Clocks[clock] == 15) Clocks[clock] = 3;
			}
		}
	}
	
	boolean areAligned(){		
		int cnt = 0;
		for(int clock = 0; clock < CLOCKS; clock++){
			if(Clocks[clock] == 12){
				cnt++;
			}
		}
		if(cnt == CLOCKS) return true;
		
		return false;
	}
	
	int solve(int swtch){
		// 12시에 aligned 되어 있는지 확인한다.
		if(swtch == SWITCHES){
			if(areAligned()){
				return 0;
			}else{
				return 1000000000;
			}			
		}
		
		int ret = 1000000000;
		for(int push = 0; push < 4; push++){			
			ret = Math.min(ret, push + solve(swtch +1));
			push(swtch);
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
		fail("Not yet implemented");
	}

}
