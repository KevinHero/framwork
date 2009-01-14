package com.flyong.sort;

import java.util.Comparator;

public class DemoComparator implements Comparator<DataBean> {   
    
    private static DemoComparator demoComparator = null;   
       
    public static DemoComparator getInstance(){   
        if(demoComparator==null){   
            demoComparator = new DemoComparator();   
        }   
        return demoComparator;   
    }   
  
    @Override  
    public int compare(DataBean o1, DataBean o2) {   
        if (o1.getId() < o2.getId()) {   
            return -1;   
        } else if (o1.getId() > o2.getId()) {   
            return 1;   
        } else {   
            return 0;   
        }   
    }   
}  

