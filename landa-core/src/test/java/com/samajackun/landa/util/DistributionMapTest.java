package com.samajackun.landa.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DistributionMapTest
{
	@Test
	public void empty()
	{
		DistributionMap<String> map=new DistributionMap<>();
		assertTrue(map.keySet().isEmpty());
		assertTrue(map.getFrequenciesMapInDescendingOrder().isEmpty());
	}

	@Test
	public void oneItem()
	{
		DistributionMap<String> map=new DistributionMap<>();
		map.add("enero");
		assertEquals(1, map.keySet().size());
		assertNotNull(map.getFrequenciesMapInDescendingOrder().get(1));
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(1).contains("enero"));
	}

	@Test
	public void twoItems()
	{
		DistributionMap<String> map=new DistributionMap<>();

		map.add("enero");
		map.add("febrero");
		assertEquals(2, map.keySet().size());
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(1).contains("enero"));
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(1).contains("febrero"));
	}

	@Test
	public void oneItemTwice()
	{
		DistributionMap<String> map=new DistributionMap<>();

		map.add("enero");
		map.add("enero");
		assertEquals(1, map.keySet().size());
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(2).contains("enero"));
	}

	@Test
	public void firstItemTwiceSecondItemOnce()
	{
		DistributionMap<String> map=new DistributionMap<>();

		map.add("enero");
		map.add("enero");
		map.add("febrero");
		assertEquals(2, map.keySet().size());
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(2).contains("enero"));
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(1).contains("febrero"));
	}

	@Test
	public void firstItemOnceSecondItemTwice()
	{
		DistributionMap<String> map=new DistributionMap<>();

		map.add("enero");
		map.add("febrero");
		map.add("febrero");
		assertEquals(2, map.keySet().size());
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(1).contains("enero"));
		assertTrue(map.getFrequenciesMapInDescendingOrder().get(2).contains("febrero"));
	}

	// @Test
	// public void testLinkedHashSet()
	// {
	// Set<String> set=new LinkedHashSet<>();
	// set.add("enero");
	// set.add("febrero");
	// set.add("marzo");
	// set.add("enero");
	// System.out.println(set);
	// }
}