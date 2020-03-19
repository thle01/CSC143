package lists;

import utility.Iterator;
import utility.List;
import java.lang.StringBuilder;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
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
		data = (E[]) new Object[capacity];
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public ArrayList(List<E> other) {
		ensureCapacity(size + other.size());
		for (int i = 0; i < other.size(); i++) {
			add(other.get(i));
		}
	}

	public boolean add(E element) {
		int oldSize = size;
		data[size++] = element;
		return oldSize + 1 == size;
	};

	public void add(int index, E element) {
		checkIndex(index);
		shiftRight(index);
		data[index] = element;
		size++;
		
	}

	private void checkIndex(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("index is invalid");
	}

	public void clear() {
		size = 0;
	}

	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		if (minCapacity > data.length) {
			int newCapacity = data.length * 2 + 1;
			if (minCapacity > newCapacity) {
				newCapacity = minCapacity;				
			}
			E[] newList = (E[]) new Object[newCapacity];
			for (int i = 0; i < size; i++) {
				newList[i] = data[i];
			}
			data = newList;
		}
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
		} else {
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

	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	public E remove(int index) {
		checkIndex(index);
		E e = data[index];
		shiftLeft(index);
		size--;
		return e;
	}

	public boolean remove(E element) {
		int index = indexOf(element);
		shiftLeft(index);
		remove(index);
		return true;
	}

	public E set(int index, E element) {
		checkIndex(index);
		data[index] = element;
		return element;
	}

	private void shiftRight(int index) {
		for (int i = size; i >= index + 1; i--) {
			data[i] = data[i - 1];
		}
	}

	private void shiftLeft(int index) {
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		if (size == 0)
			return "[]";
		else {
			StringBuilder s = new StringBuilder();
			s.append("[" + data[0]);

			for (int i = 1; i < size; i++) {
				s.append(" , ");
				s.append(data[i]);
			}
			s.append("]");
			return s.toString();
		}
	}
	
	private class ArrayIterator implements Iterator<E>{
		private int position;
		private boolean isRemovable;
		public ArrayIterator() {
			position = 0;
			isRemovable = false;
		}
		
		public boolean hasNext() {
			return position < size();
		}
		
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = get(position++);
			isRemovable = true;
			return result;
		}
		
		public void remove() {
			if(!isRemovable) {
				throw new IllegalStateException();
			}
			ArrayList.this.remove(position-- - 1);
			isRemovable = false;
		}
	}
}
