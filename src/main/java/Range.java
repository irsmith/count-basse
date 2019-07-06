/**
 * File Name: Range.java 
 * Range concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Range.java RangeBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Range extends RangeBase{
	Range() {
		//NOTHING CAN BE CHANGED HERE
		///////////////////////////////////////////  testBench();
	}
	
	@Override
	int[] Range(int [] a, int n)  {
		//NOTHING CAN BE CHANGED HERE
		numSteps = 0 ; //MUST update this data. Without this assert fails
		return alg(a,n) ;
	}

	enum EdgeType {LEFT, RIGHT}
	
	int[] alg(int [] a, int k) {
		int leftEdge = binsearch_it(EdgeType.LEFT, a, 0, a.length-1, k);
		int rightEdge = -1;

		if (leftEdge != -1) {
			rightEdge = binsearch_it(EdgeType.RIGHT, a, leftEdge, a.length-1, k);

		}
		return (rightEdge == -1) ?  new int[]{-1,-1} : new int[]{leftEdge, rightEdge};
		}

	/*
	Jon Bentley's  Programming Pearls went undetected for 20 years.
	https://math.stackexchange.com/questions/1696011/computing-midpoint-of-an-interval-overflow
    	alt is, int mid = (low + high) >>> 1;
	 */

	private int binsearch_it(EdgeType type, int[] a, int lo, int hi, int k) {

		while (hi >= lo) {
		    numSteps++;
            int mid = lo + ((hi - lo) / 2);
            if (a[mid] == k) {
                switch (type) {
                    case LEFT: {
                        if (mid == 0) {
                            return mid; // beginning of array
                        } else if (a[mid - 1] != k) {
                            return mid;
                        }
                        hi = mid-1;
                        break;
                    }
                    case RIGHT: {
                        if (mid == a.length - 1) {
                            return  mid; // end of array
                        } else if (a[mid + 1] != k) {
                            return mid;
                        }
                        lo = mid+1;
                        break;
                    }
                }
            } else {
                if (k > a[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
		return -1;
	}

	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Range problem STARTS");
		Range m = new Range() ;
		System.out.println("All Range tests passed. Get me a bar of candy");
		System.out.println("Range problem ENDS");
	}
}