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
		// ���û�д���codeֵ����ôֱ�ӷ��ؿս����.
		if(Common.isNull(code)){
			builder.append("<results></results>");
			return builder.toString();
		}
		// ���ݲ����������Դ.
		Object dataSource = Class.forName(className).newInstance();
		Method method = dataSource.getClass().getMethod("getSource", new Class[]{String[].class});
		Object object = method.invoke(dataSource, new Object[]{new String[]{code}});
		// TODO ������һ��δ�����ľ���.
		DataSet<DataRow> dataSet = (DataSet<DataRow>)object;
		// ��������Դ��װXML�ı�.
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
			// ��֤�������һ����¼���������һ��ϵͳ������Ժ���ļ�¼.
			break;
		}
		builder.append("</results>");
		// ���ط�װ��XML�ı�.
		return builder.toString();
	}
}
