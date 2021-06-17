package com.samajackun.landa.population;

final class RetypingUtils
{
	// private RetypingUtils()
	// {
	// }
	//
	// public static DataType<?> findMostCommonType(Set<DataType<?>> set)
	// throws UncompatibleDatatypesException
	// {
	// if (set.isEmpty())
	// {
	// throw new IllegalArgumentException("Empty set not allowed");
	// }
	// else
	// {
	// Iterator<DataType<?>> iterator=set.iterator();
	// DataType<?> type1=iterator.next();
	// DataType<?> mostCommonType=findMostCommonType(type1, iterator);
	// return mostCommonType;
	// }
	// }
	//
	// static DataType<?> findMostCommonType(DataType<?> initial, Iterator<DataType<?>> rest)
	// throws UncompatibleDatatypesException
	// {
	// DataType<?> mostCommonType=initial;
	// while (rest.hasNext())
	// {
	// DataType<?> second=rest.next();
	// mostCommonType=findNearestCommonAncestor(mostCommonType, second);
	// }
	// return mostCommonType;
	// }
	//
	// static DataType<?> findNearestCommonAncestor(DataType<?> initial, DataType<?> second)
	// throws UncompatibleDatatypesException
	// {
	// DataType<?> tmp=second;
	// if (initial != tmp)
	// {
	// // Bucles anidados para combinar todos los antecesores de initial con todos los de second,
	// // hasta que en alguna combinación coincidan ambos, o se agote la jerarquía.
	// while (tmp != null && initial != tmp)
	// {
	// do
	// {
	// tmp=tmp.getParentDataType();
	// }
	// while (tmp != null && initial != tmp);
	// if (tmp == null && initial != tmp)
	// {
	// initial=initial.getParentDataType();
	// if (initial != null)
	// {
	// tmp=second;
	// }
	// }
	// }
	// }
	// if (initial != tmp)
	// {
	// throw new UncompatibleDatatypesException(initial, second);
	// }
	// return initial;
	// }
}
