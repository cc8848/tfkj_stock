package com.takucin.aceeci.async;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.util.Common;

public class CascadeInfoService {
	
	@SuppressWarnings("unchecked")
	public String getCascadeInfoXml(String code,String className) throws Exception{
		StringBuilder builder = new StringBuilder();
		builder.append(Constant.XML_DECLARE);
		// 如果没有传递code值，那么直接返回空结果集.
		if(Common.isNull(code)){
			builder.append("<results></results>");
			return builder.toString();
		}
		// 根据参数获得数据源.
		Object dataSource = Class.forName(className).newInstance();
		Method method = dataSource.getClass().getMethod("getSource", new Class[]{String[].class});
		Object object = method.invoke(dataSource, new Object[]{new String[]{code}});
		// TODO 这里有一个未消除的警告.
		DataSet<DataRow> dataSet = (DataSet<DataRow>)object;
		// 迭代数据源封装XML文本.
		builder.append("<results code=\"" + code + "\">");
		for(int i=0;i<dataSet.size();i++){
			DataRow row = dataSet.get(i);
			Set<String> keys = row.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()){
				String key = it.next();
				builder.append("<result key=\"" + key + "\">");
				builder.append(row.getDataElement(key).getString());
				builder.append("</result>");
			}
			// 保证结果集是一条记录，如果多于一条系统将会忽略后面的记录.
			break;
		}
		builder.append("</results>");
		// 返回封装的XML文本.
		return builder.toString();
	}
}
