package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Test;

public class DecimalDataTypeTest
{
	private final DecimalDataType dataType=new DecimalDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(Double.class, this.dataType.getJavaType());
	}

	@Test
	public void parseRightDecimal()
	{
		try
		{
			assertEquals(1.2d, this.dataType.parse("1.2"), 0.01d);
		}
		catch (DataTypeParseException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void parseWrongDecimal()
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
	public void parseOrNullRightDecimal()
	{
		assertEquals(1.2d, this.dataType.parseOrNull("1.2"), 0.01d);
	}

	@Test
	public void parseOrNullWrongDecimal()
	{
		assertNull(this.dataType.parseOrNull("x"));
	}

	@Test
	public void serialize()
	{
		assertEquals("1.2", this.dataType.serialize(1.2d));
	}
}
