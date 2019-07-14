/**
 * File Name: Stock1.java 
 * Stock1 concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Stock1.java Stock1Base.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Stock1 extends Stock1Base{
	//You can have any number of private data members here
	//You can have any number of private functions here
    IntUtil u = new IntUtil();

	Stock1() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}
	
	@Override
	void NSquareTimeConstantSpace() {
		//NOTHING CAN BE CHANGED HERE
    nsquareTimeConstantSpace() ;
	}
	
	@Override
  void NlognTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    nlognTimelognSpace() ;
	}
	
	@Override
  void NTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    nTimelognSpace() ;
	}
	
	/*
	 * Time: O(n^2)
	 * Space: THETA(1)
	 * All your routine should match this answer
	 * Nothing can be changed in this routine
	 */
	private void nsquareTimeConstantSpace() {
		int gp = 0 ;
		int l = size() ;
		for (int buy = 0; buy < l-1; ++buy) {
			for (int sell = buy + 1; sell < l; ++sell) {
				++numSteps;
				int p = profit(sell,buy);
				if (p >= gp) { //So that I can make profit by keeping stock for less time
					gp = p ;
					buyDay = buy ;
					sellDay = sell ;
				}
			}
		}
	}
	
	/*
	maximum sum subarray
	https://en.wikipedia.org/wiki/Maximum_subarray_problem
	https://www.youtube.com/watch?v=ohHWQf1HDfU

	//https://stackoverflow.com/questions/7086464/maximum-single-sell-profit
	 * Time: O(nlogn)
	 * Space: O(logn)
	 * side effect : updates numSteps, buyDay and sellDay
	 */
	private void nlognTimelognSpace() {
		u.myassert(size() > 0);
		if (size() == 1) {
			numSteps = 1;
			buyDay = 0;
			sellDay = 0;
			return;
		}

		int tot[] = recur(0,size()-1);
		buyDay = tot[0];
		sellDay = tot[1];
	}


	int[] recur(int lo, int hi) {
        u.myassert(lo<=hi);

        if (lo==hi) {
            return new int[]{lo,lo};
        }
        numSteps++;

        // todo - our recursion provides the max and min can optimize
        int mid = lo + ((hi-lo)/2);
		int leftBS[] = recur(lo,mid);
		int rightBS[] = recur(mid+1, hi);

        int buyLowLeft = min(lo,mid);
        int sellHiRight = max(mid+1, hi);
        int crossProfit = profit(sellHiRight, buyLowLeft);

        int leftProfit = profit(leftBS[1], leftBS[0]);
		int rightProfit = profit(rightBS[1], rightBS[0]);
        int rv[] = new int[2];
        if ((crossProfit > leftProfit) && (crossProfit > rightProfit)){
			rv[0]=buyLowLeft;
			rv[1]=sellHiRight;
		} else if (rightProfit >= leftProfit) {
            rv[0]=rightBS[0];
            rv[1]=rightBS[1];
		} else if ((leftProfit > rightProfit)) {
            rv[0]=leftBS[0];
            rv[1]=leftBS[1];
		}  else {
            u.myassert(false);
        }
		return  rv;
	}

	// return INDEX of min from lo to hi
	private int min(int lo, int hi) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = lo;
		int i=lo;
		while (i<=hi) {
		    numSteps++;
			if (price(i) < minValue) {
				minValue = price(i);
				minIndex = i;
			}
			i++;
		}
		return minIndex;
	}

	private int max(int lo, int hi) {
		int maxValue = Integer.MIN_VALUE;
		int maxInx = lo;
		int i=lo;
		while (i<=hi){
		    numSteps++;
		    if (price(i) > maxValue) {
		        maxValue = price(i);
		        maxInx = i;
            }
            i++;
        }
		return maxInx;
	}

	private void nTimelognSpace() {
		//NOT required this time
	}
	
	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Stock1 problem STARTS");
		Stock1 m = new Stock1() ;
		System.out.println("All Stock1 tests passed. Now you can pass interviews");
		System.out.println("Stock1 problem ENDS");
	}
}