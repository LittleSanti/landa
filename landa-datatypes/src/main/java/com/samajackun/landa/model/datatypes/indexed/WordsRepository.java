package com.samajackun.landa.model.datatypes.indexed;

import java.util.HashMap;
import java.util.Map;

public final class WordsRepository
{
	private static final WordsRepository INSTANCE=new WordsRepository();

	public static WordsRepository getInstance()
	{
		return INSTANCE;
	}

	private WordsRepository()
	{
	}

	private static final Map<String, Integer> map=new HashMap<>();

	private static final Map<Integer, String> reverseMap=new HashMap<>();

	private static int id=0;

	public Integer put(String s)
	{
		return map.computeIfAbsent(s, k -> {
			reverseMap.put(id, s);
			return id++;
		});
	}

	public String serialize(Integer t)
	{
		return reverseMap.get(t);
	}

}
