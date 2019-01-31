package com.backjun.standardIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("test"));
		System.out.println(isCarNumber("13하1345"));
	}

	public static String reverse(String input) {

		char[] msgArr = input.toCharArray();

		for (int i = 0; i < msgArr.length / 2; i++) {
			// System.out.println(input.charAt(i));
			char temp = msgArr[i];
			msgArr[i] = msgArr[msgArr.length - 1 - i];
			msgArr[msgArr.length - 1 - i] = temp;
		}

		return new String(msgArr);
	}

	public static boolean isCarNumber(String carNum) {
		boolean result = true;

		if (carNum.length() != 7)
			result = false;
		else {
			for (int i = 0; i < carNum.length(); i++) {

				if (i == 0 || i == 1 || (i >= 3 && i <= 6)) {
					if (!Character.isDigit(carNum.charAt(i))) {
						result = false;
						break;
					}
				}

				if (i == 2) {
					if (!Character.isLetter(carNum.charAt(i))) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}

}
