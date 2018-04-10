package range;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZipRangeTest {

	private ArrayList<ZipRange> expectedResult;

	ModifiedRange exec;
	int[][] expected = new int[][] {     new int[] { 85101, 85500 },
										new int[] { 85600, 85640 }
									};
	int[][] input =  new int[][] {     new int[] { 85101, 85302 },
										new int[] { 85300, 85500 },
										new int[] { 85600, 85640 }
								};
	//int[][] actual;
	int[][] mergedExpecteds;
	int[][] mergedActuals;	
	
	@Before
	public void before(){
		exec = new ModifiedRange(input);
		mergedExpecteds = expected;
	}
	
	@Test
	public void testCase() {
		mergedActuals = new int[][] {};
		mergedActuals = exec.getModifiedRange();
		for (int i = 0; i < mergedActuals.length; i++) {
			Assert.assertEquals(mergedExpecteds[i].toString(), mergedActuals[i].toString());
		}
	}
	
	@After
	public void after() {
		exec = null;
		expected = null;
	}

}
