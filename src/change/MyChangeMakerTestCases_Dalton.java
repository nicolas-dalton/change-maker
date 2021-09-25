package change;


import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyChangeMakerTestCases_Dalton
{
	private static void getDenominations()
	{
		System.out.println("****\tNow testing getDenominations()\t****");
		Set<Integer> setDenomination = new HashSet<Integer>();
		setDenomination.add(100); setDenomination.add(25); setDenomination.add(10); 
		setDenomination.add(1); setDenomination.add(5);
		ChangeMaker change_1 = new ChangeMakerImpl_Dalton(setDenomination);
		List<Integer> listDenomination = new ArrayList<Integer>();
		
		listDenomination.add(100); listDenomination.add(25); listDenomination.add(10);
		listDenomination.add(5); listDenomination.add(1);
		List<Integer> expectedRV = listDenomination;
		List<Integer> actualRV = change_1.getDenominations();
		String failureMessage = "denomination of changemaker supposed to be "+
				expectedRV + ", but instead it was " + actualRV;
		assert actualRV.equals(expectedRV): failureMessage;
		System.out.println("denomination was " + actualRV + " as expected");
		System.out.println("SUCCESS -- completed getDenominations() \n");
		
	}
	private static void canMakeExactChange()
	{
		System.out.println("****\tNow testing canMakeExactChange()\t****");
		Set<Integer> setDenomination = new HashSet<Integer>();
		setDenomination.add(100); setDenomination.add(25); setDenomination.add(10); 
		setDenomination.add(1); setDenomination.add(5);
		ChangeMaker change_1 = new ChangeMakerImpl_Dalton(setDenomination);
		int valueInCents = 65;
		boolean expectedRV = true;
		boolean actualRV = change_1.canMakeExactChange(valueInCents);
		String failureMessage = change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 0;
		expectedRV = true;
		actualRV = change_1.canMakeExactChange(valueInCents);
		failureMessage = change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 1008;
		expectedRV = true;
		actualRV = change_1.canMakeExactChange(valueInCents);
		failureMessage = change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = -6;
		expectedRV = false;
		actualRV = change_1.canMakeExactChange(valueInCents);
		failureMessage = change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_1.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		Set<Integer> setDenomination_2 = new HashSet<Integer>();
		setDenomination_2.add(7); setDenomination_2.add(11);
		ChangeMaker change_2 = new ChangeMakerImpl_Dalton(setDenomination_2);
		valueInCents = 22;
		expectedRV = true;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 29;
		expectedRV = true;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 1;
		expectedRV = false;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 2;
		expectedRV = false;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 6;
		expectedRV = false;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 7;
		expectedRV = true;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		valueInCents = 0;
		expectedRV = true;
		actualRV = change_2.canMakeExactChange(valueInCents);
		failureMessage = change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				")  was suppose to be " +  expectedRV + ", but instead it was "+ actualRV;
		assert actualRV == expectedRV : failureMessage;
		System.out.println(change_2.getDenominations()+".canMakeExactChange("+ valueInCents +
				") was "+ actualRV + ", as expected");
		
	}
	private static void getExactChange()
	{
		Set<Integer> setDenomination = new HashSet<Integer>();
		setDenomination.add(100); setDenomination.add(25); setDenomination.add(10); 
		setDenomination.add(1); setDenomination.add(5);
		ChangeMaker change_1 = new ChangeMakerImpl_Dalton(setDenomination);
		List <Integer> changeList = new ArrayList<Integer>();
		changeList.add(0); changeList.add(2); changeList.add(1);
		changeList.add(1); changeList.add(0);
		int valueInCents = 65;
		List <Integer> expectedRV = change_1.getExactChange(valueInCents);
		List <Integer> actualRV = changeList;
		String failureMessage =  change_1.getDenominations() + ".getExactChange("+ valueInCents +
				") should equal " + changeList +", but instead it was " + actualRV;
		assert actualRV.equals(expectedRV) : failureMessage;
		System.out.println( change_1.getDenominations() + ".getExactChange("+ valueInCents +
				") was " + actualRV + "as expected");
		
		
	}
	public static void main(String[]args)
	{
		//assert false;
		MyChangeMakerTestCases_Dalton.getDenominations();
		MyChangeMakerTestCases_Dalton.canMakeExactChange();
		getExactChange();
	}
}


