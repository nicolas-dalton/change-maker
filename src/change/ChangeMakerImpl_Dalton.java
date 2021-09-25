package change;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Dalton implements ChangeMaker
{

	private List <Integer> denomination;
	private static boolean containsNegativeZero(Set<Integer> aSet)
	{
		boolean hasNegativeZero = false;
		List <Integer> setToList= new ArrayList<Integer>(aSet);
		for(int i = 0 ; i< setToList.size(); i++ )
		{
			if(setToList.get(i)<=0)
			{
				hasNegativeZero = true;
			}
		}
		return hasNegativeZero;
	}
	private static boolean containsNegative(List<Integer> aList)
	{
		boolean containsNegative = false;
		for(int i = 0 ; i< aList.size(); i++ )
		{
			if(aList.get(i) < 0)
			{
				containsNegative = true;
			}
		}
		return containsNegative;
	}
	public ChangeMakerImpl_Dalton(Set<Integer> denominations)
	{
		assert denominations != null : "denominations set cannot be null!";
		assert !denominations.contains(null) : "denominations set cannot contain null!";
		assert !containsNegativeZero(denominations) : "denominations set cannot have negatives or zeros";
		List <Integer> setToList= new ArrayList<Integer>(denominations);
		Collections.sort(setToList,  Collections.reverseOrder());
		this.denomination = setToList;
	}
	
	public List<Integer> getDenominations()
	{
		return this.denomination;
	}
	
	//pre: nothing
	//post: (rv== true) <=> valueInCents = 0 || valueInCents - this.denomination.get(i) = 0
	//example (STRAIGHTFORWARD) : [100,25,10,5,1].canMakeExactChange(65) -> true
	//example (EXTREME) : [100,25,10,5,1].canMakeExactChange(0) -> true
	//example (BIZZARE/EXOTIC) : [100,25,10,5,1].canMakeExactChange(-6) -> false
	public boolean canMakeExactChange(int valueInCents)
	{
		int changeRemaining = valueInCents;
		int indexDenomination = 0;
		if(valueInCents > 0)
		{
			while(indexDenomination != denomination.size())
			{
				int currentCoin = denomination.get(indexDenomination);
				if(changeRemaining % currentCoin == changeRemaining)
				{
					indexDenomination++;
				}
				else
				{
					while(changeRemaining % currentCoin != changeRemaining)
					{
						changeRemaining = changeRemaining - currentCoin;
					}
				}
			}
		}
		boolean canMakeExactChangeBoolean= (changeRemaining == 0);
		return canMakeExactChangeBoolean;
	}

	//post: rv == ([valueInCents-= getDenominations.get(i), valueInCents-= getDenominations.get(i), ......])
	//example (STRAIGHTFORWARD) : [100,25,10,5,1].getExactChange(65) -> [0, 2, 1, 1, 0]
	//example (EXTREME) : [32,16,8,4,2].getExactChange(0) -> [0, 0, 0, 0, 0]
	//example (BIZZARE/EXOTIC) : [32,16,8,4,2].getExactChange(-6) -> NB
	public List<Integer> getExactChange(int valueInCents)
	{
		assert canMakeExactChange(valueInCents) : "cannot make exact change for " + valueInCents;
		List <Integer> changeList= new ArrayList<Integer>();
		int changeRemaining = valueInCents;
		int indexDenomination = 0;
		int countCoins = 0;
		while(indexDenomination != this.denomination.size())
		{
			int currentCoin = this.denomination.get(indexDenomination);
			if(changeRemaining % currentCoin == changeRemaining)
			{
				changeList.add(countCoins);
				indexDenomination++;
			}
			else
			{
				while(changeRemaining % currentCoin != changeRemaining)
				{
					countCoins++;
					changeRemaining = changeRemaining - currentCoin;
				}
				changeList.add(countCoins);
				indexDenomination++;
			}
			countCoins=0;
		}
		assert changeList != null : "changeList cannot be null!";
		assert changeList.size() == this.getDenominations().size() :"changeList is not the same size as denominations";
		return changeList;
	}

	//post: rv += (getDenominations.get(i) * changeList.get(i) ...... )
	//example (STRAIGHTFORWARD) : [100,25,10,5,1].calculateValueOfChangeList([0,2,1,1,0]) -> 65
	//example (EXTREME) : [100,25,10,5,1].calculateValueOfChangeList([0,0,0,0,0]) -> 0
	//example (BIZZARE/EXOTIC) : [100,25,10,5,1].calculateValueOfChangeList([1,2,3,-4,1]) -> NB
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		assert changeList != null : "changeList cannot be null!";
		assert !changeList.contains(null) : "changeList cannot contain null!";
		assert changeList.size() == this.getDenominations().size() : "changeList.size() = " 
				+ changeList.size();
		assert !containsNegative(changeList) : "changeList cannot contain negatives ";
		int valueInCents = 0;
		int result = 0;
		for(int i =0 ; i< this.getDenominations().size(); i++ )
		{
			result = this.getDenominations().get(i) * changeList.get(i);
			valueInCents += result;
			result = 0;
		}
		return valueInCents;
	}
	
	public String toString()
	{
		String temp = "[";
		for(int i = 0 ; i< this.getDenominations().size(); i++ )
		{
			if(i == this.getDenominations().size()-1)
			{
				temp += this.getDenominations().get(i);
			}
			else
			{
				temp +=  this.getDenominations().get(i)+", ";
			}
		}
		temp += "]";
		return temp;
	}
}

