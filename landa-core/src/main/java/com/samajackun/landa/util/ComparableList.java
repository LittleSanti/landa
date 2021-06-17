package com.samajackun.landa.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ComparableList<T extends Comparable<T>> implements List<T>, Comparable<ComparableList<T>>
{

	private final List<T> src;

	public ComparableList(List<T> src)
	{
		super();
		this.src=src;
	}

	@Override
	public int compareTo(ComparableList<T> o)
	{
		Iterator<T> i1=this.src.iterator();
		Iterator<T> i2=o.iterator();
		int x=0;
		while (x == 0 && i1.hasNext() && i2.hasNext())
		{
			T item1=i1.next();
			T item2=i2.next();
			x=(item1.compareTo(item2));
		}
		if (x == 0)
		{
			x=i1.hasNext()
				? 1
				: -1;
		}
		return x;
	}

	@Override
	public int size()
	{
		return this.src.size();
	}

	@Override
	public boolean isEmpty()
	{
		return this.src.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return this.src.contains(o);
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.src.iterator();
	}

	@Override
	public Object[] toArray()
	{
		return this.src.toArray();
	}

	@Override
	public <K> K[] toArray(K[] a)
	{
		return this.src.toArray(a);
	}

	@Override
	public boolean add(T e)
	{
		return this.src.add(e);
	}

	@Override
	public boolean remove(Object o)
	{
		return this.src.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.src.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return this.src.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		return this.src.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return this.src.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return this.src.retainAll(c);
	}

	@Override
	public void clear()
	{
		this.src.clear();
	}

	@Override
	public boolean equals(Object o)
	{
		return this.src.equals(o);
	}

	@Override
	public int hashCode()
	{
		return this.src.hashCode();
	}

	@Override
	public T get(int index)
	{
		return this.src.get(index);
	}

	@Override
	public T set(int index, T element)
	{
		return this.src.set(index, element);
	}

	@Override
	public void add(int index, T element)
	{
		this.src.add(index, element);
	}

	@Override
	public T remove(int index)
	{
		return this.src.remove(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return this.src.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return this.src.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return this.src.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return this.src.listIterator(index);
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return this.src.subList(fromIndex, toIndex);
	}

}
