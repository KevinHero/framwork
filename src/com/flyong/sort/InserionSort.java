package com.flyong.sort;
/*插入排序的算法是将一个数据项插入到已排好序的有序数组(部分有序)中，从而得到一个新的、数据项个数增1的有序数组。 
插入排序的比较次数实际上大约是N*(N-1)/4 次。复制的次数大致等于比较的次数，由于一次复制与一次交换的时间耗费不同，所以相对于随机数据，这个算法比冒泡排序快一倍，比选择排序略快。 
如果数据基本有序，插入排序几乎只需要O(N)的时间；然后对于逆序排列的数据，每次比较和移动都会执行，所以这时插入排序并不比冒泡快。 
*/

public class InserionSort {
	public void inserionSort(int a[]){   
	    int temp;   
	    for (int out=1;out < a.length;out++){   
	        temp = a[out];   
	        int in = out;   
	        while (in >0 && a[in-1] >= temp){   
	            a[in] = a[in-1];   
	            in--;   
	        }   
	        a[in] = temp;   
	    }   
	}  


}
