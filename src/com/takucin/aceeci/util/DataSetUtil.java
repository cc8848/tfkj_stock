package com.takucin.aceeci.util;

import java.util.ArrayList;
import java.util.List;

import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

/**
 * 这是一个和DataSet相关处理的工具类.
 * 
 * @author aceeci
 * @date 2009-08-25
 */
public class DataSetUtil {
	
	/**
	 * 将多个DataSet对象，合并成一个.
	 * 
	 * @param dataSets DataSet对象集合.
	 * @return 返回一个已合并的DataSet对象.
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
	 * 将一个DataSet对象转换成List<CommonModule>对象.
	 * 
	 * @param dataSet 一个DataSet对象.
	 * @return 返回一个List<CommonModule>对象.
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
