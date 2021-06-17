package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

public class DateTimeDataTypeTest
{
	private final DateTimeDataType dataType=new DateTimeDataType(null);

	@Test
	public void getJavaType()
	{
		assertSame(Date.class, this.dataType.getJavaType());
	}

	@Test
	public void parseRightDateTime()
	{
		try
		{
			Date date=this.dataType.parse("2018-05-15 14:20:22 +0200");
			Calendar calendar=new GregorianCalendar();
			calendar.setTimeZone(TimeZone.getTimeZone("GMT+02"));
			calendar.setTime(date);
			assertEquals(15, calendar.get(Calendar.DATE));
			assertEquals(5, 1 + calendar.get(Calendar.MONTH));
			assertEquals(2018, calendar.get(Calendar.YEAR));
			assertEquals(14, calendar.get(Calendar.HOUR_OF_DAY));
			assertEquals(20, calendar.get(Calendar.MINUTE));
			assertEquals(22, calendar.get(Calendar.SECOND));
		}
		catch (DataTypeParseException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void parseWrongDateTime()
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
	public void parseOrNullWrongDateTime()
	{
		assertNull(this.dataType.parseOrNull("x"));
	}

	@Test
	public void parseOrNullRightDateTime()
	{
		Date date=this.dataType.parseOrNull("2018-05-15 14:20:22 +0200");
		Calendar calendar=new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("GMT+02"));
		calendar.setTime(date);
		assertEquals(15, calendar.get(Calendar.DATE));
		assertEquals(5, 1 + calendar.get(Calendar.MONTH));
		assertEquals(2018, calendar.get(Calendar.YEAR));
		assertEquals(14, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(20, calendar.get(Calendar.MINUTE));
		assertEquals(22, calendar.get(Calendar.SECOND));
	}

	@Test
	public void serialize()
	{
		Calendar calendar=new GregorianCalendar(2018, 5 - 1, 15, 14, 20, 22);
		calendar.setTimeZone(TimeZone.getTimeZone("GMT+02"));
		assertEquals("2018-05-15 14:20:22 +0200", this.dataType.serialize(calendar.getTime()));
	}

}
