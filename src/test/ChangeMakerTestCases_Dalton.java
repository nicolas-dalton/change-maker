package test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import change.ChangeMaker;
import change.ChangeMakerImpl_Dalton;

public class ChangeMakerTestCases_Dalton
{
	//Student note (ask me about this) -
	//The following debugging switch is not typically found in Test Cases:
	final static boolean DEBUGGING = false;
	
	final static int DESIRED_TIMEOUT_IN_MILLISECONDS = (3)*1000;
	final static int TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS = (10*((60)*1000));
	final static int TIMEOUT_IN_MILLISECONDS = (DEBUGGING ? TIMEOUT_USED_FOR_DEBUGGING_IN_MILLISECONDS : DESIRED_TIMEOUT_IN_MILLISECONDS);
	
	@Rule
	public Timeout timeoutForAllTestMethods = new Timeout(TIMEOUT_IN_MILLISECONDS);
	
	protected static ChangeMaker changeMaker_STUDENT;
	
	protected static String TEST_GOAL_MESSAGE;
	
	@Retention(value=RUNTIME)
	@Target(value=METHOD)
	public @interface Points {
		int value();
	}
	
	private static Set<Integer> getUSCoinDenominationSet()
	{
		return getDenominationSet(new Integer[]{1, 5, 10, 25, 100});
	}

	private static Set<Integer> getDenominationSet(Integer[] values)
	{
		Set<Integer> denominationSet = new HashSet<Integer>(Arrays.asList(values));
		assert denominationSet.size() == values.length : "The Integer array values has duplicates! : values = " + getPrettyString(values);
		//STUDENT: add check for null

		return denominationSet;
	}
	
	private static String getPrettyString(Set<Integer> set)
	{
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		Collections.reverse(list);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
			if(i < list.size() - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	private static String getPrettyString(Integer[] integerArray)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < integerArray.length; i++)
		{
			sb.append(integerArray[i]);
			if(i < integerArray.length - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	private static String getPrettyString(List<Integer> list)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
			if(i < list.size() - 1)
			{
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	protected ChangeMaker getChangeMaker(Set<Integer> denominations)
	{
		return new ChangeMakerImpl_Dalton(denominations);
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__65()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 65;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__USCoins__65()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 65;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 2, 1, 1, 0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__55()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 55;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__10()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 10;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__11()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 11;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__USCoins__180004()
	{
		Set<Integer> usCoinDenominationSet = getUSCoinDenominationSet();
		int valueInCents = 180004;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(usCoinDenominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(usCoinDenominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__32_16_8_4_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{32, 16, 8, 4, 2, 1});
		int valueInCents = 0;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__32_16_8_4_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{32, 16, 8, 4, 2, 1});
		int valueInCents = 0;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void canMakeExactChange__10E8_10E7_10E6_10E5_10E4_10E3_10E2_10E1_10E0__123456789()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{100000000, 10000000, 1000000, 100000, 10000,1000,100, 10, 1});
		int valueInCents = 123456789;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__10E8_10E7_10E6_10E5_10E4_10E3_10E2_10E1_10E0__123456789()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{100000000, 10000000, 1000000, 100000, 10000,1000,100, 10, 1});
		int valueInCents = 123456789;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__144_89_55_34_21_13_8_5_3_2_1__0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1});
		int valueInCents = 0;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__144_89_55_34_21_13_8_5_3_2_1__201()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1});
		int valueInCents = 201;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__144_89_55_34_21_13_8_5_3_2_1__201()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1});
		int valueInCents = 201;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0 });
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__16777216_2097152_262144_32768_4096_512_64_8_1__88888888()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16777216, 2097152, 262144, 32768, 4096, 512, 64, 8, 1});
		int valueInCents = 88888888;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__16777216_2097152_262144_32768_4096_512_64_8_1__88888888()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16777216, 2097152, 262144, 32768, 4096, 512, 64, 8, 1});
		int valueInCents = 88888888;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{5, 2, 3, 0, 5, 3, 0, 7, 0 });
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__537824_38416_2744_196_14_1__0_0_0_0_0_0()
	{

		Set<Integer> denominationSet = getDenominationSet(new Integer[]{537824, 38416, 2744, 196, 14, 1});		
		List<Integer> changeList = Arrays.asList(0,0,0,0,0,0);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  0;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	
	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__144_89_55_34_21_13_8_5_3_2_1__0_0_0_0_0_0_0_3_2_1_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{144, 89, 55, 34, 21, 13, 8, 5, 3, 2, 1});		
		List<Integer> changeList = Arrays.asList(0,0,0,0,0,0,0,3,2,1,0);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  (0 *1) +( 1*2) + (2*3) + (3*5);
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	
	@Points(value=5)
	@Test
	public void canMakeExactChange__8000_400_20_1__492()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{800, 400, 20, 1});
		int valueInCents = 492;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertTrue("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Points(value=5)
	@Test
	public void getExactChange__8000_400_20_1__492()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{800, 400, 20, 1});
		int valueInCents = 492;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 1, 4, 12});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	
	@Points(value=5)
	@Test
	public void calculateValueOfChangeList__USCoinSet__0_0_0_0_28()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = Arrays.asList(0,0,0,0, 28);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  28;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void canMakeExactChange__13_7__14()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{13,7});
		
		int valueInCents = 14;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertFalse("ChangeMaker should NOT be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Test
	public void canMakeExactChange__USCoinSet__Negative42()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		
		int valueInCents = -42;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertFalse("ChangeMaker should NOT be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	
	@Test
	public void getExactChange__HexaDecimalSet__FACE()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16*16*16, 16*16, 16, 1});
		int valueInCents = 0xFACE;
		//int value = F*16^3+A*16^2+C+16^1+E*16^0;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0xF,0xA,0xC,0xE});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void getExactChange__HexaDecimalSet__34F()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16*16*16, 16*16, 16, 1});
		int valueInCents = 0x34F;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0,3,4,15});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void getExactChange__HexaDecimalSet__19AE()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{16*16*16, 16*16, 16, 1});
		int valueInCents = 0x19AE;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1,9,10,14});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void getExactChange__BinarySet__15()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{2*2*2, 2*2, 2, 1});
		int valueInCents = 0b1111;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1,1,1,1});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void getExactChange__BinarySet__9()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{2*2*2, 2*2, 2, 1});
		int valueInCents = 0b1001;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{1,0,0,1});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void calculateValueOfChangeList__BinarySet__0_1_1_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{2*2*2, 2*2, 2, 1});
		List<Integer> changeList = Arrays.asList(0,1,1,0);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  6;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void calculateValueOfChangeList__BinarySet__1_1_1_0_1()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{2*2*2*2, 2*2*2, 2*2, 2, 1});
		List<Integer> changeList = Arrays.asList(1,1,1,0,1);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  29;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void getExactChange__OctalSet__374()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{8*8*8, 8*8, 8, 1});
		int valueInCents = 374;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0,5,6,6});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}

	@Test
	public void getExactChange__OctalSet__1552()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{8*8*8, 8*8, 8, 1});
		int valueInCents = 1552;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{3,0,2,0});
		
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void calculateValueOfChangeList__OctalSet__3_1_5_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{8*8*8, 8*8, 8, 1});
		List<Integer> changeList = Arrays.asList(7,0,4,6);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  3622;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void calculateValueOfChangeList__OctalSet__1_3_1_5_0()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{8*8*8*8,8*8*8, 8*8, 8, 1});
		List<Integer> changeList = Arrays.asList(1, 3, 1, 5, 0);
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  5736;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void calculateValueOfChangeList__empty__empty()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{});
		List<Integer> changeList = Arrays.asList();
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + getPrettyString(changeList) + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int correctValue =  0;
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
		
		assertEquals("Calculated value disagrees with expected!", correctValue, actualValue);
	}
	@Test
	public void canMakeExactChange__emptyDenomination__888()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{});
		int valueInCents = 888;
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".canMakeExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		assertFalse("ChangeMaker should be able to make change for " + valueInCents, changeMaker_STUDENT.canMakeExactChange(valueInCents));
	}
	@Test(expected = AssertionError.class)
	public void getDenominations__0_1_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{0, 1, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test(expected = AssertionError.class)
	public void getDenominations__1_Negative2_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{1, -2, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test(expected = AssertionError.class)
	public void getDenominations__1_null_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{1, null, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test(expected = AssertionError.class)
	public void getDenominations__null()
	{
		Set<Integer> denominationSet = null;
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test(expected = AssertionError.class)
	public void getExactChange__USCoins__Negative59()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		int valueInCents = -59;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
	}
	@Test(expected = AssertionError.class)
	public void getExactChange__2_4_6__15()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{2,4,6});
		int valueInCents = 15;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
	}
	@Test(expected = AssertionError.class)
	public void getExactChange__7_13__14()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{7,13});
		int valueInCents = 14;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
	}
	@Test(expected = AssertionError.class)
	public void calculateValueOfChangeList__100_25_10_5_1__1_2_2()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = Arrays.asList(1, 2, 2);
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
	}
	@Test(expected = AssertionError.class)
	public void calculateValueOfChangeList__100_25_10_5_1__emptyChangeList()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = Arrays.asList();
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
	}
	@Test(expected = AssertionError.class)
	public void calculateValueOfChangeList__100_25_10_5_1__null()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = null;
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
	}
	@Test(expected = AssertionError.class)
	public void calculateValueOfChangeList__100_25_10_5_1__1_2_null()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = Arrays.asList(1, 2, null);
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
	}
	@Test(expected = AssertionError.class)
	public void calculateValueOfChangeList__100_25_10_5_1__1_5_Negative2_1_1()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		List<Integer> changeList = Arrays.asList(1, 5, -2, 1, 1);
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		int actualValue =  changeMaker_STUDENT.calculateValueOfChangeList(changeList);
	}
}
