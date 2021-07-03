package com.samajackun.landa.model.datatypes.names;

import static com.samajackun.landa.model.datatypes.names.AppendStringUtils.appendWithBlank;

public class DirectFullNameForm implements NameForm
{
	@Override
	public String format(String part0, String part1, String part2, String part3, String part4)
	{
		int len=(part0 == null)
			? 0
			: part0.length();
		len+=(part1 == null)
			? 0
			: 1 + part1.length();
		len+=(part2 == null)
			? 0
			: 1 + part2.length();
		len+=(part3 == null)
			? 0
			: 1 + part3.length();
		len+=(part4 == null)
			? 0
			: 1 + part4.length();
		StringBuilder stb=new StringBuilder(len);
		appendWithBlank(stb, part0);
		appendWithBlank(stb, part1);
		appendWithBlank(stb, part2);
		appendWithBlank(stb, part3);
		appendWithBlank(stb, part4);
		return stb.toString();
	}

}
