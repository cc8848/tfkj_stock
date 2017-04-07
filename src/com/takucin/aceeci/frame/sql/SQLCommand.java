package com.takucin.aceeci.frame.sql;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SQLCommand {

	private String sql = null;
	//private List<Object> paramValue = new ArrayList<Object>();
	private HashMap<String,SQLParameter> paras = new HashMap<String,SQLParameter>();
	private Log log = LogFactory.getLog(this.getClass());
	public SQLCommand(String sqlContext) {
		sql = sqlContext;
	}
	private void filterParamters(){
		HashMap<String,SQLParameter> temp = new HashMap<String,SQLParameter>();
		for(String key : paras.keySet()){
			if(!paras.get(key).isFilter()){
				temp.put(key, paras.get(key));
			}
		}
		paras = temp;
	}
	
	public void setParameter (String parameterName,Object parameterValue){
		SQLParameter para = new SQLParameter();
		para.setParameterName(parameterName);
		para.setParameterValue(parameterValue);
		paras.put(parameterName, para);
	}
	
	public void setParameter(SQLParameter para){
		paras.put(para.getParameterName(), para);

	}
	public void setInjectStatment(String key,String statment){
		sql = sql.replaceFirst(key, statment);
	}
//	public Object[] getRunParameter(){
//		return paramValue.toArray();
//	}
//	public void test(){
//		filterParamters();
//		String resultSql = sql;
//		log.info(sql);
//		Pattern p = Pattern.compile("\\[.*\\]");
//		
//		Matcher m = p.matcher(sql);
//		
//		while(m.find()){
//			String oldSql = m.group();
//			SQLFilterStatement statement = new SQLFilterStatement(oldSql);
//			resultSql = resultSql.replace(oldSql, statement.getNewSql(paras,paramValue));
//		}
//		System.out.println(resultSql);
//		System.out.println(paramValue.size());
//	}
	public String getRunScriptAndParameter(List<Object> list){
		String tmpSql = getRunScript();
		
		Pattern p = Pattern.compile("@[\\w]*");
		Matcher m = p.matcher(tmpSql);
		String resultSql = tmpSql;
		//List<Object> temp = new ArrayList<Object>();
		while(m.find()){
			String oldSql = m.group();
			resultSql = resultSql.replaceFirst(oldSql, "?");
			list.add(paras.get(oldSql).getParameterValue());
		}
		//resultParas = temp.toArray();
		printParameterLog();
		return resultSql;
	}
	private void printSqlLog(String sql){
		StringBuilder tmp = new StringBuilder();
		tmp.append("\t\n");
		tmp.append(sql);
		log.info(tmp.toString());		
	}
	private void printParameterLog(){
		Iterator<String> it = paras.keySet().iterator();
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		
		while(it.hasNext()){
			String name = (String)it.next();
			SQLParameter value = paras.get(name);
			builder.append(name);
			builder.append("=");
			builder.append(value.getParameterValue());
			builder.append("\n");
		}
		log.info(builder.toString());
	}
	private String getRunScript(){
		filterParamters();
		String resultSql = sql;
		
		Pattern p = Pattern.compile("\\[.*\\]");
		
		Matcher m = p.matcher(sql);
		
		while(m.find()){
			String oldSql = m.group();
			SQLFilterStatement statement = new SQLFilterStatement(oldSql);
			//resultSql = resultSql.replace(oldSql, statement.getNewSql(paras,paramValue));
			resultSql = resultSql.replace(oldSql, statement.getNewSql(paras));
		}
		//printSqlLog(resultSql);
		return resultSql;
	}
//	public String getRunScript(){
//		filterParamters();
//		String resultSql = sql;
//		log.info(sql);
//		Pattern p = Pattern.compile("\\[[^\\[|\\]]*[\\|\\|]*[^\\[|\\]]*\\]");
//		
//		Matcher m = p.matcher(sql);
//		
//		while(m.find()){
//			String oldSql = m.group();
//			log.info(oldSql);
//			String newSql = oldSql;
//			boolean isFilter = true;
//			for(String key : paras.keySet()){
//				if(!oldSql.contains(key)){
//					continue;
//				}else{
//					newSql = oldSql.replace(key, "?");
//					paramValue.add(paras.get(key).getParameterValue());
//					isFilter = false;
//					break;
//				}
//			}
//			if(!isFilter){
//				resultSql = resultSql.replace(oldSql, newSql);
//			}else{
//				resultSql = resultSql.replace(oldSql, "");
//			}
//		}
//		resultSql = resultSql.replace("[", "");
//		resultSql = resultSql.replace("]", "");
//		log.info(resultSql);
//		return resultSql;		
//	}
	public void setParameterSet(ParameterSet set) {
		for(SQLParameter para : set.values()){
			setParameter(para);
		}
		
	}
	/**
	 * »ñµÃSQLÓï¾ä
	 * add by zfs 2010-03-01
	 * @return
	 */
	public String getSql() {
		return sql;
	}
}
