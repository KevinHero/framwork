package com.flyong.test;

import java.util.ArrayList;
import java.util.List;

public class ACL {

	/**
	 * @author zhangyong
	 */
	public static void main(String[] args) {
		Integer[] w = build(23);
		for(int i=0;i<w.length;i++){
				System.out.println(w[i]);
			
		}
	}
	
	/**
	 * @author zhangyong
	 * @return Integer[] 分解权限值
	 * @param int max=32 min=1
	 */
	public static Integer[] build(int mask) {
		List<Integer> masks = new ArrayList<Integer>();
		for (int i = 0; i < 32; i++) {
	        int permissionToCheck = 1 << i;
	        if ((mask & permissionToCheck) == permissionToCheck) {
	        	masks.add(permissionToCheck);
	        }
		}
		return masks.toArray(new Integer[masks.size()]);
	}

}
