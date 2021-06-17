package dev;

public class StringType implements Type<String>
{
	@Override
	public String parse(String s)
	{
		return s;
	}

	@Override
	public String serialize(String t)
	{
		return t;
	}

	@Override
	public int compare(String o1, String o2)
	{
		return o1.compareTo(o2);
	}
}
