package com.Interview.SF;

public class Main {
	
	
	public static void main(String[] args) {
		
		String[] ret = transformList(new int[] {1, 2, 3, 5, 6, 9});
		System.out.println(ret);
		
	}

	private static String[] transformList(int[] arr) {
				
		int cur = 0;
		String ret = String(arr[0]);
		String[] results = new String[]{};
		int index = 0;
		for (int i = 0; i < arr.length-1; i++) {
			
			if(arr[i + 1] - arr[i] == 1) {
				ret += arr[i] + '-';
				cur++;
			}else {
				i = cur+1;
				results[index++] = ret;
				ret = "";
			}
		}
		return results;
		
	}

	private static String String(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
