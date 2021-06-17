package com.samajackun.landa.population;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.samajackun.landa.model.ColumnDefinition;
import com.samajackun.landa.model.RecordDefinition;
import com.samajackun.landa.model.RecordSet;
import com.samajackun.landa.model.TypedValue;
import com.samajackun.landa.model.datatypes.DataType;
import com.samajackun.landa.model.datatypes.DataTypeManager;
import com.samajackun.landa.util.DistributionMap;

/**
 * @author Santi
 */
public class RecordSetPopulator
{
	private final RecordSet recordSet;

	private final RecordDefinition recordSetDefnition;

	private final Map<Integer, DistributionMap<DataType<?>>> pendingDataTypesMap=new HashMap<>();

	private DataTypeManager dataTypeManager;

	private final List<String> columnNames;

	public RecordSetPopulator(RecordSet recordSet, DataTypeManager dataTypeManager, List<String> columnNames)
	{
		super();
		this.recordSet=recordSet;
		this.recordSetDefnition=recordSet.getDefinition();
		this.columnNames=columnNames;
	}

	private DistributionMap<DataType<?>> getPendingRetytping(ColumnDefinition columnDefinition, int columnIndex)
	{
		return this.pendingDataTypesMap.computeIfAbsent(columnIndex, k -> new DistributionMap<>(columnDefinition.getDataTypesDistribution()));
	}

	public void add(List<String> row)
		throws ValueNotParseableException
	{
		Object[] values=new Object[this.recordSetDefnition.getColumnDefinitions().size()];
		Map<String, ColumnDefinition> columnDefinitions=this.recordSetDefnition.getColumnDefinitions();
		for (int columnIndex=0; columnIndex < row.size(); columnIndex++)
		{
			String serialValue=row.get(columnIndex);
			Object value;
			if (serialValue != null)
			{
				String columnName=getOrCreateColumn(columnIndex);
				ColumnDefinition columnDefinition=columnDefinitions.get(columnName);
				TypedValue selectedTypedValue=parseAsOneCandidateType(serialValue, this.pendingDataTypesMap.get(columnIndex));
				value=selectedTypedValue.getValue();
				// if (columnDefinition.getPreferredDataType(this.dataTypeManager) != selectedTypedValue.getDataType())
				{
					DataType<?> newDataType=selectedTypedValue.getDataType();
					DistributionMap<DataType<?>> retypingSet=getPendingRetytping(columnDefinition, columnIndex);
					retypingSet.add(newDataType);
				}
			}
			else
			{
				value=null;
			}
			values[columnIndex]=value;
		}
		this.recordSet.addRow(values);
	}

	/**
	 * To be called after a session of calling add(...).
	 * It will do the definetive retypings, normalize columns and re-compute indexes and primary keys.
	 */
	public void reformat()
	{
		recomputeRetypings();
		recomputeNormalizations();
	}

	private void recomputeRetypings()
	{
		for (Map.Entry<Integer, DistributionMap<DataType<?>>> entry : this.pendingDataTypesMap.entrySet())
		{
			ColumnDefinition columnDefinition=this.recordSetDefnition.getColumnDefinition(entry.getKey());
			columnDefinition.setDataTypesDistribution(entry.getValue());
		}
	}

	private void recomputeNormalizations()
	{
		// TODO
	}

	private String getOrCreateColumn(int columnIndex)
	{
		String columnName=this.recordSetDefnition.getColumnNamesMap().get(columnIndex);
		if (columnName == null)
		{
			// Añadir nueva columna
			columnName=this.columnNames.get(columnIndex);
			this.recordSetDefnition.add(columnName, this.dataTypeManager.getDefaultDataType());
		}
		return columnName;
	}

	private TypedValue parseAsOneCandidateType(String serialValue, DistributionMap<DataType<?>> newDataTypesMap)
		throws ValueNotParseableException
	{
		Object parsedValue=null;
		DataType<?> selectedType=null;
		// Primera alternativa: Probar con los tipos de los datos existentes en la columna actual:
		Set<DataType<?>> completeDataTypesSet=new LinkedHashSet<>(newDataTypesMap.getDataTypesInDescendingOrder());
		// Segunda alternativa: Probar con todos los tipos de datos registrados en el dataTypeManager:
		completeDataTypesSet.addAll(this.dataTypeManager.getAllDataTypes());
		for (Iterator<DataType<?>> iterator=completeDataTypesSet.iterator(); iterator.hasNext() && parsedValue == null;)
		{
			selectedType=iterator.next();
			parsedValue=selectedType.parseOrNull(serialValue);
		}
		if (parsedValue == null)
		{
			throw new ValueNotParseableException(serialValue);
		}
		else
		{
			newDataTypesMap.add(selectedType);
		}
		return new TypedValue(selectedType, parsedValue);
	}
}
