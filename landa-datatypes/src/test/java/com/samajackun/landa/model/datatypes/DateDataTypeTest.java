package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateDataTypeTest
{
	private final DateDataType dataType=new DateDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(Date.class, this.dataType.getJavaType());
	}

	@Test
	public void parseRightDate()
	{
		try
		{
			Date date=this.dataType.parse("2018-05-15");
			Calendar calendar=new GregorianCalendar();
			calendar.setTime(date);
			assertEquals(15, calendar.get(Calendar.DATE));
			assertEquals(5, 1 + calendar.get(Calendar.MONTH));
			assertEquals(2018, calendar.get(Calendar.YEAR));
			assertEquals(0, calendar.get(Calendar.HOUR));
			assertEquals(0, calendar.get(Calendar.MINUTE));
			assertEquals(0, calendar.get(Calendar.SECOND));
		}
		catch (DataTypeParseException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void parseWrongDate()
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
	public void parseOrNullWrongDate()
	{
		assertNull(this.dataType.parseOrNull("x"));
	}

	@Test
	public void parseOrNullRightDate()
	{
		Date date=this.dataType.parseOrNull("2018-05-15");
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		assertEquals(15, calendar.get(Calendar.DATE));
		assertEquals(5, 1 + calendar.get(Calendar.MONTH));
		assertEquals(2018, calendar.get(Calendar.YEAR));
		assertEquals(0, calendar.get(Calendar.HOUR));
		assertEquals(0, calendar.get(Calendar.MINUTE));
		assertEquals(0, calendar.get(Calendar.SECOND));
	}

	@Test
	public void serialize()
	{
		Calendar calendar=new GregorianCalendar(2018, 5 - 1, 15);
		assertEquals("2018-05-15", this.dataType.serialize(calendar.getTime()));
	}

}
