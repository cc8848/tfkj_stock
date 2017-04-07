package com.hrbank.business.frame;

import com.hrbank.business.common.Constant;
import com.takucin.aceeci.frame.BaseDao;
import com.takucin.aceeci.frame.GlobalInfo;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.frame.sql.SQLCommand;

public abstract class BusinessDao extends BaseDao {

	protected String getXmlPathHeader() {
		return GlobalInfo.getInstance().getContextPath() + Constant.SQL_XML_PATH;
	}

	/**
	 * 返回SQL配置的文件路径.
	 * 
	 * @return SQL配置的文件路径.
	 */
	protected String getXmlPath() {
		return "business.xml";
	}

	public DataSet<DataRow> executeQuery(String sqlQueryName, ParameterSet set) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQuery(cmd);
	}
	
	public DataSet<DataRow> executeQueryEndClose(String sqlQueryName, ParameterSet set) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQueryEndClose(cmd);
	}

	public DataSet<DataRow> executeQuery(String sqlQueryName, ParameterSet set, String sqlState) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQuery(cmd, sqlState);
	}

	public DataSet<DataRow> executeQuery(String sqlQueryName, ParameterSet set, int first, int rows) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQuery(cmd, first, rows);
	}

	public DataSet<DataRow> executeQuery(String sqlQueryName, ParameterSet set, String sqlState, int first, int rows) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQuery(cmd, sqlState, first, rows);
	}

	public int executeQueryToCount(String sqlQueryName, ParameterSet set, String cnt) throws Exception {
		DataSet<DataRow> ds = executeQuery(sqlQueryName, set);
		if (ds != null && ds.size() > 0) {
			return ds.iterator().next().getDataElement(cnt).getInt();
		}
		return 0;
	}

	public int executeQueryToCount(String sqlQueryName, ParameterSet set, String cnt, String sqlState) throws Exception {
		DataSet<DataRow> ds = executeQuery(sqlQueryName, set, sqlState);
		if (ds != null && ds.size() > 0) {
			return ds.iterator().next().getDataElement(cnt).getInt();
		}
		return 0;
	}

	public int executeQueryToCount(String sqlQueryName, ParameterSet set) throws Exception {
		return executeQueryToCount(sqlQueryName, set, "CNT");
	}

	public DataRow executeQueryToDataRow(String sqlQueryName, ParameterSet set) throws Exception {
		DataSet<DataRow> ds = executeQuery(sqlQueryName, set);
		if (ds.size() > 0) {
			return ds.iterator().next();
		}
		return null;
	}

	public int execute(String sqlQueryName, ParameterSet set) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return execute(cmd);
	}
	
	public DataSet<DataRow> executeQuerySQL(String sqlString,Object[] obj,int first,int rows)
	throws Exception{
		return executeQuery(sqlString, obj, first, rows);
	}
	
	public DataSet<DataRow> executeQuerySQL(String sqlString,Object[] obj)
	throws Exception{
		return executeQuery(sqlString, obj);
	}
	public DataSet<DataRow> executeQuery(String sqlQueryName, ParameterSet set, String[] sqlState, int first, int rows) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		return executeQuery(cmd, sqlState, first, rows);
	}
	public int executeQueryToCount(String sqlQueryName, ParameterSet set, String cnt, String[] sqlState) throws Exception {
		SQLCommand cmd = getSQLCommand(getXmlPath(), sqlQueryName);
		cmd.setParameterSet(set);
		DataSet<DataRow> ds = executeQuery(cmd, sqlState);
		if (ds != null && ds.size() > 0) {
			return ds.iterator().next().getDataElement(cnt).getInt();
		}
		return 0;
	}
}
