package p;

import java.util.Arrays;

public class Custom<E> {
	private int s = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object ele[];
    public Custom() {
        ele = new Object[DEFAULT_CAPACITY];
        for(int i=0;i<10;i++)
        {
        	ele[s++] = i+1;
        }
    }
    public void add(E e) {
        if (s == ele.length) {
            ensureCapacity();
        }
        ele[s++] = e;
    }
    public E  fetch(int i) {
        if (i >= s || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) ele[i];
    }
    public E remove(int i) {
        if (i >= s || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = ele[i];
        int numElts = ele.length - ( i + 1 ) ;
        System.arraycopy( ele, i + 1, ele, i, numElts ) ;
        s--;
        return (E) item;
    }
    
    public int s() {
        return s;
    }
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         for(int i = 0; i < s ;i++) {
             sb.append(ele[i].toString());
             if(i<s-1){
                 sb.append(" ");
             }
         }
         return sb.toString();
    }
     
    private void ensureCapacity() {
        int newSize = ele.length * 2;
        ele = Arrays.copyOf(ele, newSize);
    }


	

}
