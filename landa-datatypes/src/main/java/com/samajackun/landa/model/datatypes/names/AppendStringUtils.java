package com.samajackun.landa.model.datatypes.names;

import lombok.experimental.UtilityClass;

@UtilityClass
class AppendStringUtils
{
	public void appendWithBlank(StringBuilder stb, String part)
	{
		if (part != null)
		{
			if (stb.length() > 0)
			{
				stb.append(' ');
			}
			stb.append(part);
		}
	}

}
