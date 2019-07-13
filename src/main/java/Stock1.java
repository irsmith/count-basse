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

	// return int[0] BUYlow day an int[1] SELLhi day
	// or return idx[0,1] of indices for highest profit?
	int[] recur(int lo, int hi) {
        if (lo>hi) throw  new RuntimeException("lo is greater than hi");
        int mid = lo + ((hi-lo)/2);
        System.out.printf("RECUR sz=%d lo=%d hi=%d mid=%d %n",size(),lo,hi, mid);

        if (lo==hi) {
            return new int[]{lo,lo}; //base case
        }
        numSteps++;

        if (numSteps > 100) {
            System.out.printf("");
        }
        int rv[] = new int[2];
		int buyLowLeft = min(lo,mid);
		int sellHiRight = max(mid+1, hi);

		if  (sellHiRight < buyLowLeft) {
			throw new IllegalArgumentException("sell idx must be > = buy idx");
		}
		int crossProfit = profit(sellHiRight, buyLowLeft);

		int leftBS[] = recur(0,mid);
		int rightBS[] = recur(mid+1, hi);

		int leftProfit = profit(leftBS[1], leftBS[0]);
		int rightProfit = profit(rightBS[1], rightBS[0]);
		//total profit is choice of 3 situations: left-only, right-only or cross
		if ((crossProfit > leftProfit) && (crossProfit > rightProfit)){
			//cross wins.  Buy low sell hi
			buyDay = buyLowLeft;
			sellDay = sellHiRight;
			rv[0]=buyLowLeft;
			rv[1]=sellHiRight;
		} else if ((rightProfit > crossProfit)  && (rightProfit > leftProfit)) {
            // right fragment wins.
            rv[0]=rightBS[0];
            rv[1]=rightBS[1];

		} else {
            // left fragment wins.
            rv[0]=leftBS[0];
            rv[1]=leftBS[1];
		}
		return  rv;
	}

	// return INDEX of min from lo to hi
	private int min(int lo, int hi) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = lo;
		int i=lo;
		while (i<=hi) {
			if (price(i) < minValue) {
				minValue = price(i);
				minIndex = i;
			}
			i++;
		}
        if (minIndex >= size()) {
            throw new IllegalArgumentException("max idx too hi");
        }
		return minIndex;
	}

	private int max(int lo, int hi) {
		int maxValue = Integer.MIN_VALUE;
		int maxInx = lo;
		int i=lo;
		while (i<=hi){
		    if (price(i) > maxValue) {
		        maxValue = price(i);
		        maxInx = i;
            }
            i++;
        }
        if (maxInx >= size()) {
		    throw new IllegalArgumentException("max idx too hi");
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