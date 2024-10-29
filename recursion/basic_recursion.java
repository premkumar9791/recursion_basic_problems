package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class basic_recursion {

	public static void main(String[] args) {
	
		//p1();
		//System.out.println("name");
		//p2();
		//p3();
	    //p4();
		//p5();
		//p6();
		//p7();
	    //p8();
		//p9();
		//p10();
		//spider_printing();
		//merge_sort();
		//Quick_sort();
	}

	private static void Quick_sort() {
		int arr[]= {2,4,6,8,0,1,3,5,7,9};
		int low=0;
		int high=arr.length-1;
		
		Q_sort(arr,low,high);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

	private static void Q_sort(int[] arr, int low, int high) {
		if(low<=high) {
			int pivot=search_pivot(arr,low,high);
			Q_sort(arr,low,pivot-1);
			Q_sort(arr,pivot+1,high);
		}
		
	}

	private static int search_pivot(int[] arr, int low, int high) {
		int pivot=arr[low];
		int i=low;
		int j=high;
		
		while(i<j) {
			
			while(arr[i]<= pivot && i<=high-1) {
				i++;
			}
			
			while(arr[j] > pivot && j>= low+1) {
				j--;
			}
			
			if(i<j) {
				swaping(arr,i,j);	
			}
		}
		swaping(arr,low,j);	
		return j;
	}

	private static void swaping(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	private static void merge_sort() {
		
		int arr[]= {2,4,6,8,0,1,3,5,7,9};
		int low=0;
		int high=arr.length-1;
		
		m_sort(arr,low,high);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void m_sort(int[] arr, int low, int high) {
		if(low ==high) {
			return;
		}
		int mid=(low+high)/2;
		m_sort(arr,low,mid);
		m_sort(arr,mid+1,high);
		merg(arr,low,high,mid);
		
	}

	private static void merg(int[] arr, int low, int high, int mid) {
		
		int n1=mid-low+1;
		int n2=high-mid;
		
		int left[]=new int[n1];
		int right[]=new int[n2];
		
		for(int i=0;i<n1;i++) {
			left[i]=arr[low+i];
		}
		for(int i=0;i<n2;i++) {
			right[i]=arr[mid+1+i];
		}
		
		int i=0,j=0,k=low;
		
		while(i<n1 && j<n2) {
			if(left[i]<=right[j]) {
				arr[k]=left[i];
				i++;
			}
			else {
				arr[k]=right[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k]=left[i];
			i++;
			k++;
		}
		
		while(j<n2) {
			arr[k]=right[j];
			j++;
			k++;
		}
		
	}

	private static void spider_printing() {
		
		int a[][]= { {1,2,3,4},
				    {14,15,16,5},
				    {13,20,17,6},
				    {12,19,18,7},
				    {11,10,9,8}};
		
		int rowStart=0 ,rowEnd=a.length;
		int colStart=0, colEnd=a[0].length;
		
		while(rowStart<rowEnd || colStart < colEnd)
		{
			for(int i=colStart;i<colEnd;i++) {
				System.out.print(a[rowStart][i]+" ");
			}
			rowStart+=1;
			
			for(int i=rowStart;i<rowEnd;i++) {
				System.out.print(a[i][colEnd-1]+" ");
			}
			colEnd-=1;
			
			for(int i=colEnd-1;colStart<=i;i--) {
				System.out.print(a[rowEnd-1][i]+" ");
			}		
			rowEnd-=1;
			
			for(int i=rowEnd-1;rowStart<=i;i--) {
				System.out.print(a[i][colStart]+" ");
			}
			
			colStart+=1;
		}		
	}

	private static void p10() {
		int n=5;
		int i=0;
		int arr[]= {1,2,1,1,1};
		int sum=3;
		int ans=0;
		List<Integer> m=new ArrayList<>();
		int s=subseqance3(n,i,arr,m,sum,ans);
		System.out.println(s);
		
	}
	private static int subseqance3(int n, int i, int[] arr, List<Integer> m,int sum,int ans) {
		if(n==i) {
			if(sum == ans) {
				System.out.println(m);
				return 1;
			}
			else {
			    return 0;
			}
		}
		
		m.add(arr[i]);
		ans+=arr[i];
		int l=subseqance3(n,i+1,arr,m,sum,ans);
		m.remove(m.size()-1);
		ans-=arr[i];
		int r=subseqance3(n,i+1,arr,m,sum,ans);
		
		return l+r;
	}
	private static void p9() {
		int n=3;
		int i=0;
		int arr[]= {1,2,1};
		int sum=2;
		int ans=0;
		List<Integer> m=new ArrayList<>();
		boolean s=subseqance2(n,i,arr,m,sum,ans);
		System.out.println(s);
	}
	
	private static boolean subseqance2(int n, int i, int[] arr, List<Integer> m,int sum,int ans) {
		if(n==i) {
			if(sum == ans) {
				System.out.println(m);
				return true;
			}
			else {
			    return false;
			}
		}
		
		m.add(arr[i]);
		ans+=arr[i];
		if(subseqance2(n,i+1,arr,m,sum,ans)==true)return true;
		m.remove(m.size()-1);
		ans-=arr[i];
		if(subseqance2(n,i+1,arr,m,sum,ans)==true)return true;
		
		return false;
	}

	private static void p8() {
		int n=3;
		int i=0;
		int arr[]= {1,2,1};
		int sum=2;
		int ans=0;
		List<Integer> m=new ArrayList<>();
		subseqance(n,i,arr,m,sum,ans);
	}

	private static void subseqance(int n, int i, int[] arr, List<Integer> m,int sum,int ans) {
		if(n==i) {
			if(sum == ans) {
				System.out.println(m);
				return;
			}
			else {
			    return;
			}
		}
		
		m.add(arr[i]);
		ans+=arr[i];
		subseqance(n,i+1,arr,m,sum,ans);
		m.remove(m.size()-1);
		ans-=arr[i];
		subseqance(n,i+1,arr,m,sum,ans);
	}

	private static void p7() {
		int n=5;
		int index=0;
		List<Integer> m=new ArrayList<>();
		int arr[]= {1,2,3,4,5};
		List<Integer> l=new ArrayList<>();
		number2(n,index,arr,l,m);
		System.out.println("size =" +m.size());
		
	}

	private static void number2(int n, int index, int[] arr, List<Integer> l,List<Integer> m) {
		if(index == n) {
			System.out.println(l);
			m.add(1);
			return;
		}
		
		l.add(arr[index]);
		number2(n,index+1,arr,l,m);
		l.remove(l.size()-1);
		number2(n,index+1,arr,l,m);
		
	}

	private static void p6() {
		int n=3;
		int index=0;
		int arr[]= {3,2,1};
		List<Integer> l=new ArrayList<>();
		
		numbers(n,index,arr,l);
	}

	private static void numbers(int n, int index, int[] arr, List<Integer> l) {
		if(index == n) {
			System.out.println(l);
			return;
		}
	     l.add(arr[index]);
	     numbers(n,index+1,arr,l);
		 l.remove(l.size()-1);
		 numbers(n,index+1,arr,l);
	}



	private static void p5() {
		int n=4;
		int ANS=fab(n);
		System.out.println(ANS);
	}



	private static int fab(int n) {
		if(n<=1) {
			return n;
		}
		return fab(n-1)+fab(n-2);
	}



	private static void p4() {
		String a="mom";
		boolean k=check(a,0,a.length()-1);
		System.out.println(k);
		
	}



	private static boolean check(String a,int i,int j) {
		if(i>=j) {
			return true;
		}
		if(a.charAt(i)!=a.charAt(j)) {
			return false;
		}
		return check(a,i+1,j-1);
	}



	private static void p3() {
		int a[]= {1,2,3,4,5};
		swap(a,0,a.length-1);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}	
	}
	private static void swap(int[] a,int i,int j) {
		if(i>=j) {
			return ;
		}
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		swap(a,i+1,j-1);
		
	}



	private static void p2() {
		int n=sum(0,5);
		System.out.println(n);
		int l=f(3);
		System.out.println(l);
	}
	private static int f(int n) {
		if(n==0) {
			return 1;
		}
		return n*f(n-1);
		
	}

	private static int sum(int k ,int i) {
		if(i<1) {
			return k;
		}
		return sum(k+i,i-1) ;
	}

	private static void p1() {
		// print name 5 times
		int a=5;
		int n=1;
		//name(a);
		number(n,a);
	}
	private static void number(int n,int a) {
		if(n>a) {
			return;
		}
		System.out.println(a); 
		number(n,a-1);
	
	}

	private static void name(int a) {
		if(a<1) {
			return ;
		}
		a--;
		name(a);
		System.out.println("prem");
	}
	
}
