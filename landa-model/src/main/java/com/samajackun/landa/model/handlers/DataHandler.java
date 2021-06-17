package com.samajackun.landa.model.handlers;

import java.util.Comparator;

public interface DataHandler<K, I> extends Comparator<K>
{
	public K parse(I image);

	public I serialize(K key);
}
