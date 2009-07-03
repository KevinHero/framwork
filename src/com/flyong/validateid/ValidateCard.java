package com.flyong.validateid;

/*public class ValidateCard {

 }*/

/*
 * IDCard.java Created on 2004-11-5 17:03:37
 * 
 */

/**
 * @author violin 2004-11-5 17:03:37 Copyright www.yz21.org 2003-2004
 */

public class ValidateCard {
	// wi =2(n-1)(mod 11)
	final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };

	// verify digit
	final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };

	private int[] ai = new int[18];

	public ValidateCard() {
	}

	// verify
	public boolean Verify(String idcard) {
		if (idcard.length() == 15) {
			idcard = uptoeighteen(idcard);
		}
		if (idcard.length() != 18) {
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equals(getVerify(idcard))) {
			return true;
		}
		return false;
	}

	// get verify
	public String getVerify(String eightcardid) {
		int remaining = 0;
		int ai = 0;
		int wi = 0;
		if (eightcardid.length() == 18) {
			eightcardid = eightcardid.substring(0, 17);
		}

		if (eightcardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eightcardid.substring(i, i + 1);
				ai = Integer.parseInt(k);
			}

			for (int i = 0; i < 17; i++) {
				sum = sum + wi * ai;
			}
			remaining = sum % 11;
		}

		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	// 15 update to 18
	public String uptoeighteen(String fifteencardid) {
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}
	
	public static void main(String[] agrs){
		ValidateCard v=new ValidateCard();
		//String id="37060219820319071X";
		String id="610425198207181531";
		boolean flag = v.Verify(id);
		System.out.println(flag);
	}

}
