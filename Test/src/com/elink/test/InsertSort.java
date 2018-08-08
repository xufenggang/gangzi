package com.elink.test;
public class InsertSort {      
    public static void main(String[] args) {    
        int a[] = {3,1,5,7,2,4,9,6,10,8};      
        InsertSort  obj=new InsertSort();    
        System.out.println("初始值：");    
        obj.print(a);    
        obj.insertSort(a);    
        System.out.println("\n排序后：");    
        obj.print(a);    
    
    }    
    
    public void print(int a[]){    
        for(int i=0;i<a.length;i++){    
            System.out.print(a[i]+" ");    
        }    
    }    

    /**
     * 插入排序
     * @param a
     */
    public void insertSort(int[] a) {   
    	for(int i = 1; i < a.length; i++) {
    		int temp = a[i];
    		int j;
    		for(j=i; j>0 && temp < a[j-1]; j--) {
    			a[j] = a[j-1];
    		}
    		a[j] = temp;
    	}
    }
}  