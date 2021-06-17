package dev;

import java.util.HashMap;
import java.util.Map;

public class IndexedStringType implements Type<Integer>
{
	private static final Map<String, Integer> map=new HashMap<>();

	private static final Map<Integer, String> reverseMap=new HashMap<>();

	private static int id=0;

	@Override
	public Integer parse(String s)
	{
		return map.computeIfAbsent(s, k -> {
			reverseMap.put(id, s);
			return id++;
		});
	}

	@Override
	public String serialize(Integer t)
	{
		return reverseMap.get(t);
	}

	@Override
	public int compare(Integer o1, Integer o2)
	{
		return reverseMap.get(o1).compareTo(reverseMap.get(o2));
	}

	public static Map<String, Integer> getMap()
	{
		return map;
	}

	public static Map<Integer, String> getReversemap()
	{
		return reverseMap;
	}

	public static int getId()
	{
		return id;
	}
}
