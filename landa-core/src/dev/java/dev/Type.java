package dev;

import java.util.Comparator;

public interface Type<T> extends Comparator<T>
{
	public T parse(String s);

	public String serialize(T t);
}
