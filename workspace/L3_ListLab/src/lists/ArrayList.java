package lists;

import utility.Iterator;
import utility.List;
import java.lang.StringBuilder;
import java.util.Arrays;

public class ArrayList<E> {
	private int size;
	private E[] data;
	
	public static final int DEFAULT_CAPACITY = 10;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Capacity cannot be negative");
		size = capacity;
		data = (E[]) new Object[size];
	}
	
//	@SuppressWarnings("unchecked")
//	public ArrayList(List<E> other) {
//		for (int i = 0; i < other.size(); i++) {
//			data[other(i)];
//		}
//			
//	}
	
	public boolean add (E element) {
		int oldSize = size;
		data = Arrays.copyOf(data,size+1);
		data[size++] = element;
		return oldSize + 1 == size;
	};
	
//	public void add(int index, E element);
	private void checkIndex(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index is invalid");		
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}
	
	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}
	
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
//		size *= 2;
	}
	
	public boolean equals(List<E> other) {
		if (size == other.size()) {
			for (int i = 0; i < size; i++) {
				if (!(data[i].equals(other.get(i))))
					return false;
			}
			return true;
		}
		return false;
	}
	
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (data[i] == null)
					return i;
			}			
		}
		else {
			for (int i = 0; i < size; i++) {
				if (element.equals(data[i]))
					return i;
			}
		}		
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
//	public Iterator<E> iterator();
//	public E remove(int index);
//	public boolean remove (E element);
	
	public E set(int index, E element) {
		checkIndex(index);
		data[index] = element;
		return element;
	}
	
//	private void shiftRight(int index) {
//		for (int i = 0; i <size; i++) {
//			
//		}
//	}
	
//	private void shiftLeft(int index) {
//		
//	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < size; i++) {
			s.append(data[i]);
			if (i != size -1) 
				s.append(" , ");
		}
		s.append("]");
		return s.toString();
	}
}
