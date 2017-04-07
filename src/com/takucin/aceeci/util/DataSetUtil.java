package com.takucin.aceeci.util;

import java.util.ArrayList;
import java.util.List;

import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * ����һ����DataSet��ش���Ĺ�����.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class DataSetUtil {
	
	/**
	 * �����DataSet���󣬺ϲ���һ��.
	 * 
	 * @param dataSets DataSet���󼯺�.
	 * @return ����һ���Ѻϲ���DataSet����.
	 */
	public static DataSet<DataRow> unionDataSet(List<DataSet<DataRow>> dataSets){
		DataSet<DataRow> dataSet = new DataSet<DataRow>();
		for(int i=0;i<dataSets.size();i++){
			DataSet<DataRow> ds = dataSets.get(i);
			for(int j=0;j<ds.size();j++){
				DataRow row = ds.get(j);
				dataSet.add(row);
			}
		}
		return dataSet;
	}
	
	/**
	 * ��һ��DataSet����ת����List<CommonModule>����.
	 * 
	 * @param dataSet һ��DataSet����.
	 * @return ����һ��List<CommonModule>����.
	 */
	public static List<CommonModule> toCommonModuleList(DataSet<DataRow> dataSet){
		List<CommonModule> modules = new ArrayList<CommonModule>();
		for(int i=0;i<dataSet.size();i++){
			CommonModule module = new CommonModule();
			module.setKey(dataSet.get(i).getDataElement(CommonModule.KEY).getString());
			module.setValue(dataSet.get(i).getDataElement(CommonModule.VALUE).getString());
			modules.add(module);
		}
		return modules;
	}
	
}
