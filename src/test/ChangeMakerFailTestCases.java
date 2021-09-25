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

public class ChangeMakerFailTestCases
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
	@Test
	public void getExactChange__USCoins__Negative59()
	{
		Set<Integer> denominationSet = getUSCoinDenominationSet();
		int valueInCents = -59;
		
		TEST_GOAL_MESSAGE = "Test " + getPrettyString(denominationSet) + ".getExactChange(" + valueInCents + ")";
		changeMaker_STUDENT = getChangeMaker(denominationSet);
		
		List<Integer> changeList = changeMaker_STUDENT.getExactChange(valueInCents);
		List<Integer> correctChangeList = Arrays.asList(new Integer[]{0, 0, 0, 0, 0, -59});
		assertEquals("Calculated changeList disagrees with expected!", correctChangeList, changeList);
	}
	@Test
	public void getDenominations__0_1_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{0, 1, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test
	public void getDenominations__1_Negative2_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{1, -2, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test
	public void getDenominations__1_null_10_50_100()
	{
		Set<Integer> denominationSet = getDenominationSet(new Integer[]{1, null, 10, 50, 100});
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
	@Test
	public void getDenominations__null()
	{
		Set<Integer> denominationSet = null;
		changeMaker_STUDENT = getChangeMaker(denominationSet);
	}
}

