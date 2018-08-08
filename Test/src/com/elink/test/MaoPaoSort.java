package com.elink.test;

public class MaoPaoSort {
	public static void main(String[] args) {    
        int a[] = {3,1,5,7,2,4,9,6,10,8};      
        MaoPaoSort  obj=new MaoPaoSort();    
        System.out.println("初始值：");    
        obj.print(a);    
        obj.bubbleSort(a, a.length);    
        System.out.println("\n排序后：");    
        obj.print(a);    
    
    }    
    
    public void print(int a[]){    
        for(int i=0;i<a.length;i++){    
            System.out.print(a[i]+" ");    
        }    
    }    
    
	void bubbleSort(int a[], int n){  
	    for(int i =0 ; i< n-1; ++i) {  
	    	if(i > 1) {
	    		break;
	    	}
	        for(int j = 0; j < n-i-1; ++j) {  
	            if(a[j] > a[j+1])  
	            {  
	                int tmp = a[j] ; a[j] = a[j+1] ;  a[j+1] = tmp;  
	            }  
	        }  
	    }  
	}  
}	
