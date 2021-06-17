package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

public class IntegerDataTypeTest
{
	private final IntegerDataType dataType=new IntegerDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(Long.class, this.dataType.getJavaType());
	}

	@Test
	public void parseRightInteger()
	{
		try
		{
			assertEquals((Long)120L, this.dataType.parse("120"));
		}
		catch (DataTypeParseException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void parseWrongInteger()
	{
		try
		{
			this.dataType.parse("x");
		}
		catch (DataTypeParseException e)
		{
			assertEquals(this.dataType, e.getDataType());
			assertEquals("x", e.getSerialValue());
		}
	}

	@Test
	public void parseOrNullRightInteger()
	{
		assertEquals((Long)120L, this.dataType.parseOrNull("120"));
	}

	@Test
	public void parseOrNullWrongInteger()
	{
		assertNull(this.dataType.parseOrNull("x"));
	}

	@Test
	public void serialize()
	{
		assertEquals("120", this.dataType.serialize(120L));
	}
}
