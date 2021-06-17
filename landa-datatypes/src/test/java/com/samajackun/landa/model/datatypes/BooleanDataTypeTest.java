package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class BooleanDataTypeTest
{
	private final BooleanDataType dataType=new BooleanDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(Boolean.class, this.dataType.getJavaType());
	}

	@Test
	public void parseTrueLowerCase()
	{
		assertTrue(this.dataType.parse("true"));
	}

	@Test
	public void parseTrueUpperCase()
	{
		assertTrue(this.dataType.parse("true"));
	}

	@Test
	public void parseOne()
	{
		assertTrue(this.dataType.parse("1"));
	}

	@Test
	public void parseFalseLowerCase()
	{
		assertFalse(this.dataType.parse("false"));
	}

	@Test
	public void parseFalseUpperCase()
	{
		assertFalse(this.dataType.parse("FALSE"));
	}

	@Test
	public void parseZero()
	{
		assertFalse(this.dataType.parse("0"));
	}

	@Test
	public void parseEmpty()
	{
		assertFalse(this.dataType.parse(""));
	}

	@Test
	public void parseNumber()
	{
		assertTrue(this.dataType.parse("123"));
	}

	@Test
	public void parseMinusOne()
	{
		assertTrue(this.dataType.parse("-1"));
	}

	@Test
	public void parseText()
	{
		assertTrue(this.dataType.parse("january"));
	}

	@Test
	public void parseOrNull()
	{
		assertFalse(this.dataType.parseOrNull(""));
	}

	@Test
	public void serializeTrue()
	{
		assertEquals("true", this.dataType.serialize(true));
	}

	@Test
	public void serializeFalseLiterals()
	{
		BooleanDataType dataType=new BooleanDataType(null);
		assertTrue(dataType.parse("si"));
		assertTrue(dataType.parse("no"));
		assertTrue(dataType.parse("nanay"));
		dataType.getMetadata().put("false-literals", new HashSet<>(Arrays.asList("no", "nanay")));
		assertTrue(dataType.parse("si"));
		assertFalse(dataType.parse("no"));
		assertFalse(dataType.parse("nanay"));
	}
}
