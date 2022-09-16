package sep16;

public class Sep16B {

	/*
	 * b) Write a function that returns true if you can partition an array into one element and the rest, 
	 * 		such that this element is equal to the product of all other elements excluding itself.

		Examples:
		canPartition([2, 8, 4, 1]) ➞ true
		// 8 = 2 x 4 x 1
		
		canPartition([-1, -10, 1, -2, 20]) ➞ false
		
		canPartition([-1, -20, 5, -1, -2, 2]) ➞ true
		
		Notes:
		The array may contain duplicates.
		Multiple solutions can exist, any solution is sufficient to return true.
	 */
	
	public static void main(String[] args) {
		int[] test1 = {2, 8, 4, 1};
		int[] test2 = {-1, -10, 1, -2, 20};
		int[] test3 = {-1, -20, 5, -1, -2, 2};
		
		System.out.println(canPartition(test1)); //true
		System.out.println(canPartition(test2)); //false
		System.out.println(canPartition(test3)); //true

	}
	
	public static boolean canPartition(int[] elements) {
		int product = 1;
		boolean canPartition = false;
		
		for(int i = 0; i < elements.length; i++) {
			product *= elements[i];
		}
		
		for(int i = 0; i < elements.length; i++) {
			int subProduct = product / elements[i];
			if(subProduct == elements[i]) {
				return true;
			}
		}
		
		return canPartition;
	}

}
