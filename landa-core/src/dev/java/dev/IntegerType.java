package dev;

public class IntegerType implements Type<Integer>
{
	@Override
	public Integer parse(String s)
	{
		return Integer.parseInt(s);
	}

	@Override
	public String serialize(Integer t)
	{
		return Integer.toString(t);
	}

	@Override
	public int compare(Integer o1, Integer o2)
	{
		return o1.compareTo(o2);
	}

}
