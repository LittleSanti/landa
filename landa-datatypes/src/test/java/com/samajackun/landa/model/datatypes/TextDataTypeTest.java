package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TextDataTypeTest
{
	private final TextDataType dataType=new TextDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(String.class, this.dataType.getJavaType());
	}

	@Test
	public void testToString()
	{
		assertNotNull(this.dataType.toString());
	}

	@Test
	public void getParentDataTypeNull()
	{
		assertNull(this.dataType.getParentDataType());
	}

	@Test
	public void getParentDataTypeNonNull()
	{
		TextDataType dataType1=new TextDataType(null);
		TextDataType dataType2=new TextDataType(dataType1);
		assertSame(dataType1, dataType2.getParentDataType());
	}

	@Test
	public void parseRightText()
	{
		try
		{
			assertEquals("january", this.dataType.parse("january"));
		}
		catch (DataTypeParseException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void parseOrNullRightText()
	{
		assertEquals("jaunuary", this.dataType.parseOrNull("jaunuary"));
	}

	@Test
	public void serialize()
	{
		assertEquals("jaunuary", this.dataType.serialize("jaunuary"));
	}
}
