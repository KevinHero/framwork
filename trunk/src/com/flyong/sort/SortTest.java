package com.flyong.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
	
	public static void main(String args){
		
		List<DataBean> dataBeans = new ArrayList<DataBean>();   
        dataBeans.add(new DataBean(23, "b", "w"));   
        dataBeans.add(new DataBean(34, "e", "w"));   
        dataBeans.add(new DataBean(12, "s", "w"));   
        dataBeans.add(new DataBean(10, "c", "w"));   
        dataBeans.add(new DataBean(19, "g", "w"));   
        dataBeans.add(new DataBean(78, "a", "w"));   
        dataBeans.add(new DataBean(66, "w", "w"));   
        dataBeans.add(new DataBean(50, "r", "w"));   
  
        System.out.println("排序前==========");   
        for (DataBean bean : dataBeans) {   
            System.out.println(bean);   
        }   
  
        DemoComparator comparator = DemoComparator.getInstance();   
  
        System.out.println("排序后==========");   
        Collections.sort(dataBeans, comparator);   
  
        for (DataBean bean : dataBeans) {   
            System.out.println(bean);   
        }   
    }   

		
	}


