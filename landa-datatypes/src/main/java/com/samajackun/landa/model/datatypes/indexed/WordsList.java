package com.samajackun.landa.model.datatypes.indexed;

import java.util.ArrayList;
import java.util.List;

public final class WordsList
{
	private static final WordsList INSTANCE=new WordsList();

	public static WordsList getInstance()
	{
		return INSTANCE;
	}

	private WordsList()
	{
	}

	private final List<String> list=new ArrayList<>();

	public int add(String word)
	{
		this.list.add(word);
		return this.list.size();
	}

	public String get(int index)
	{
		return this.list.get(index);
	}
}
