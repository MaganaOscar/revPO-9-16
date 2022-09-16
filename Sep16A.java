package sep16;

import java.util.HashMap;
import java.util.Map;

public class Sep16A {

	/*
	 * a) Create a function that reorders the digits of each numerical element in an array based on ascending (asc) or descending (desc) order.

			Examples:
			reorderDigits([515, 341, 98, 44, 211], "asc") ➞ [155, 134, 89, 44, 112]
			
			reorderDigits([515, 341, 98, 44, 211], "desc") ➞ [551, 431, 98, 44, 211]
			
			reorderDigits([63251, 78221], "asc") ➞ [12356, 12278]
			
			reorderDigits([63251, 78221], "desc") ➞ [65321, 87221]
			
			reorderDigits([1, 2, 3, 4], "asc") ➞ [1, 2, 3, 4]
			
			reorderDigits([1, 2, 3, 4], "desc") ➞ [1, 2, 3, 4]
			
			Notes:
			Single-digit numbers should be ordered the same regardless of direction.
			Numbers in the array should be kept the same order.
	 */
	public static void main(String[] args) {
		int [] test1 = {515, 341, 98, 44, 211};
		int [] test2 = {63251, 78221};
		int [] test3 = {1, 2, 3, 4};
		
		String asc = "asc";
		String desc = "desc";
		
		reorderDigits(test1, asc); //[155, 134, 89, 44, 112]
		reorderDigits(test1, desc); //[551, 431, 98, 44, 211]
		reorderDigits(test2, asc); //[12356, 12278]
		reorderDigits(test2, desc); //[65321, 87221]
		reorderDigits(test3, asc); //[1, 2, 3, 4]
		reorderDigits(test3, desc); //[1, 2, 3, 4]

	}
	
	public static void reorderDigits(int[] nums, String directions) {
		
		Map<Integer, Integer> digitCount = new HashMap<>();
		String numStr = "";
		int [] newNums = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			int number = nums[i];
			digitCount.clear();
			numStr = "";
			
			while (number > 0) {
				int digit = number % 10;
				
				if(!digitCount.containsKey(digit)) {
					digitCount.put(digit, 1);
				} else {
					digitCount.put(digit, digitCount.get(digit) + 1);
				}
				
				number /= 10;
			}
			
			if(directions.equalsIgnoreCase("asc")) {
				for(int j = 0; j < 10; j++) {
					if(digitCount.containsKey(j)) {
						int count = digitCount.get(j);
						while(count > 0) {
							numStr += j + "";
							count--;
						}						
					}
				}				
			} else if(directions.equalsIgnoreCase("desc")) {
				for(int j = 9; j >= 0; j--) {
					if(digitCount.containsKey(j)) {
						int count = digitCount.get(Integer.valueOf(j));
						while(count > 0) {
							numStr += j + "";
							count--;
						}						
					}
				}	
			}
			
			int newNum = Integer.parseInt(numStr);
			newNums[i] = newNum;
		}
		String result = "[";
		for(int i = 0; i < newNums.length; i++) {
			if(i == newNums.length - 1) {
				result += newNums[i] + "]";
			} else {
				result += newNums[i] + ", ";
			}
		}
		System.out.println(result);
	}

}
