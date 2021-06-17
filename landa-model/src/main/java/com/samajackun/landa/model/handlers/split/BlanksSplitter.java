package com.samajackun.landa.model.handlers.split;

import java.util.Arrays;
import java.util.List;

public class BlanksSplitter implements Splitter
{
	@Override
	public List<String> split(String input)
	{
		return Arrays.asList(input.split(" +"));
	}
}
