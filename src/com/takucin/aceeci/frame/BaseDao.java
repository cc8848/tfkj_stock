package com.takucin.aceeci.frame;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.employee.Employee;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.SQLBuilder;
import com.takucin.aceeci.frame.sql.SQLCommand;

/**
 * 数据访问层的基类，提供对数据库增删改查和调用存储过程的支持.
 */
public abstract class BaseDao {

	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * 获得当前的Connection.
	 * 
	 * @return 当前的Connection.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			conn = ContainerManager.currentConnection();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return conn;
	}

	/**
	 * 返回一个CallableStatement对象，用于调用存储过程.
	 * 
	 * 使用此方法返回的CallableStatement对象，需要在使用完毕后调用close()方法来保证其正常关闭.
	 * @return 一个可以执行存储过程的CallableStatement对象.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected CallableStatement call(String sql) throws Exception {
		try {

		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return getConnection().prepareCall(sql);
	}

	/**
	 * 执行一个分页查询语句，返回查询后的离线数据集.
	 * 
	 * @param sql 预处理sql语句，参数列表使用"?"留出.
	 * @param params 对应sql语句的参数数组.
	 * @param first 分页的起始记录数.
	 * @param rows 分页的每页显示行数.
	 * @return 查询后的离线数据集.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(String sql, Object[] params,
			int first, int rows) throws Exception {
		DataSet<DataRow> dataSet = null;
		try {
			dataSet = executeQuery(sql, params, first, rows, "");
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return dataSet;
	}

	/**
	 * 执行一个分页查询语句，返回查询后的离线数据集.
	 * @param cmd 查询语句
	 * @param first 分页的起始记录数
	 * @param rows 分页的每页显示行数
	 * @return 查询后的离线数据集
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(SQLCommand cmd,int first, int rows)throws Exception {
		//Object [] paras=;
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return executeQuery(sql,list.toArray(),first,rows);
	}
	
	/**
	 * 带#的sql执行此方法。自定义sqlState替换掉#
	 * @param cmd 查询语句
	 * @param first 分页的起始记录数
	 * @param rows 分页的每页显示行数
	 * @return 查询后的离线数据集
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(SQLCommand cmd, String sqlState, int first, int rows)throws Exception {
		//Object [] paras=;
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		sql = sql.replaceAll("#", sqlState);
		return executeQuery(sql,list.toArray(),first,rows);
	}
	
	/**
	 * 执行一个分页查询语句，返回查询后的离线数据集，此方法可以指定分页数据的排序.
	 * 
	 * @param sql 预处理sql语句，参数列表使用"?"留出.
	 * @param params 对应sql语句的参数数组.
	 * @param first 分页的起始记录数.
	 * @param rows 分页的每页显示行数.
	 * @param orderBy 排序字段列表，不需要指定order by，直接出入待排序的字段和排序方式即可.
	 * @return 查询后的离线数据集.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(String sql, Object[] params,
			int first, int rows, String orderBy) throws Exception {
		DataSet<DataRow> dataSet = null;
		DataSet<DataRow> finalDataSet = new DataSet<DataRow>();
		try {
//			String HEADER = "SELECT * FROM (SELECT PAGINATION_TEMP_RS.*,ROWNUM RN FROM(";
//			String FOOTER = ") PAGINATION_TEMP_RS WHERE ROWNUM < ?+1) WHERE RN >= ?+1 ";
//			String psql = HEADER + sql + FOOTER;
			String psql = sql;

			if (rows>0 ) {
				psql += "  limit " + first+","+rows;
			}
			System.out.println(psql);
			PreparedStatement sta = getConnection().prepareStatement(psql);
			setParameters(sta, params);
//			int size = 0;
//			if (params != null) {
//				size = params.length;
//			}
//			sta.setInt(size + 1, first + rows);
//			sta.setInt(size + 2, first);
			ResultSet rs = sta.executeQuery();
			dataSet = getDataSet(rs);
			
//			int start = first;
//			int last = (first + rows) > dataSet.size() ? dataSet.size() : (first + rows);
//
//			for(int i=start;i<last;i++){
//				finalDataSet.add(dataSet.get(i));
//			}
			
			rs.close();
			sta.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return dataSet;
	}
	/**
	 * 执行一个查询语句，返回查询后的离线数据集.
	 * @param cmd 查询命令
	 * @return 查询后的离线数据集.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(SQLCommand cmd) throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return this.executeQuery(sql,list.toArray());
	}
	
	protected DataSet<DataRow> executeQueryEndClose(SQLCommand cmd) throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return this.executeQueryEndClose(sql,list.toArray());
	}
	
	
	protected DataSet<DataRow> executeQuery(SQLCommand cmd , String sqlState) throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		sql = sql.replaceAll("#", sqlState);
		return this.executeQuery(sql,list.toArray());
	}

	/**
	 * 执行一个查询语句，返回查询后的离线数据集.
	 * 
	 * @param sql 预处理sql语句，参数列表使用"?"留出.
	 * @param params 对应sql语句的参数数组.
	 * @return 查询后的离线数据集.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> executeQuery(String sql, Object[] params)
			throws Exception {
		DataSet<DataRow> dataSet = null;
		try {
			PreparedStatement sta = getConnection().prepareStatement(sql);
			setParameters(sta, params);
			ResultSet rs = sta.executeQuery();
			dataSet = getDataSet(rs);
			rs.close();
			sta.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return dataSet;
	}
	
	protected DataSet<DataRow> executeQueryEndClose(String sql, Object[] params)
			throws Exception {
		DataSet<DataRow> dataSet = null;
		try {
			PreparedStatement sta = getConnection().prepareStatement(sql);
			setParameters(sta, params);
			ResultSet rs = sta.executeQuery(); 
			dataSet = getDataSet(rs);
			rs.close();
			sta.close();
			ContainerManager.closeConnection();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
		return dataSet;
	}

	/**
	 * 执行一个insert，update或delete的sql语句.
	 * @param sql 预处理sql语句，参数列表使用"?"留出.
	 * @param params 对应sql语句的参数数组.
	 * @return 返回影响的记录数.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected int execute(String sql, Object[] params) throws Exception {
		int count = 0;
		try {
			PreparedStatement sta = getConnection().prepareStatement(sql);
			setParameters(sta, params);
			count = sta.executeUpdate();
			sta.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

		return count;
	}
	/**
	 * 执行一个insert，update或delete的sql语句.
	 * @param cmd 执行语句及参数
	 * @return 返回影响的记录数.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected int execute(SQLCommand cmd)throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return execute(sql,list.toArray());
	}
	
	/**
	 * 根据ResultSet结果集封装离线数据集.
	 * @param rs 一个ResultSet对象.
	 * @return 返回封装的离线数据集.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected DataSet<DataRow> getDataSet(ResultSet rs) throws Exception {
		DataSet<DataRow> dataSet = null;
		try {
			dataSet = new DataSet<DataRow>();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				DataRow row = new DataRow();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String key = rsmd.getColumnName(i);
					String value = rs.getString(key);
					row.addDataElement(key, new DataElement(key, value));
					row.addKeys(key);
					if(key.equals("PK_ID")){
						row.setId(value);
					}
				}
				dataSet.add(row);
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

		return dataSet;
	}

	/**
	 * 根据传入的参数列表向出入的PreparedStatement对象中封装参数.
	 * @param sta 一个PreparedStatement对象.
	 * @param params 对应sql语句的参数数组.
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	private void setParameters(PreparedStatement sta, Object[] params)
			throws Exception {
		try {
			if (params == null || params.length == 0) {
				return;
			}
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof String) {
					String value = String.valueOf(params[i]);
					sta.setString(i + 1, value);
					continue;
				}
				if (params[i] instanceof Integer) {
					Integer value = Integer.parseInt(String.valueOf(params[i]));
					sta.setInt(i + 1, value);
					continue;
				}
				if (params[i] instanceof Double) {
					Double value = Double
							.parseDouble(String.valueOf(params[i]));
					sta.setDouble(i + 1, value);
					continue;
				}
				if (params[i] instanceof Long) {
					Long value = Long.parseLong(String.valueOf(params[i]));
					sta.setLong(i + 1, value);
					continue;
				}
				if (params[i] instanceof Float) {
					Float value = Float.parseFloat(String.valueOf(params[i]));
					sta.setFloat(i + 1, value);
					continue;
				}
				if (params[i] instanceof Boolean) {
					Boolean value = Boolean.parseBoolean(String
							.valueOf(params[i]));
					sta.setBoolean(i + 1, value);
					continue;
				}
				if (params[i] instanceof Byte) {
					Byte value = Byte.parseByte(String.valueOf(params[i]));
					sta.setByte(i + 1, value);
					continue;
				}
				if (params[i] == null) {
					sta.setNull(i + 1, Types.NULL);
					continue;
				}
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}
	/**
	 * 取得序列值
	 * @param sequenceName 序列名称
	 * @return 新的序列值
	 * @throws Exception 如果发生任何错误抛出此异常.
	 */
	protected long nextSequence(String sequenceName) throws Exception{
		String sql = "SELECT " + sequenceName + ".NEXTVAL SEQ FROM DUAL";
		return executeQuery(sql, null).iterator().next().getDataElement("SEQ").getLong();
	}
	
	protected Employee getUserInfo(){
		return ContainerManager.currentUser(null);
	}
	
	protected Employee getUserInfo(HttpServletRequest request){
		return ContainerManager.currentUser(request);
	}
	
	protected int[] executeBatch(String sql,List<Object[]> paramses) throws Exception{
		int[] count = null;
		try {
			PreparedStatement sta = getConnection().prepareStatement(sql);
			for(int i=0;i<paramses.size();i++){
				setParameters(sta, paramses.get(i));
				sta.addBatch();
			}
			
			count = sta.executeBatch();
			sta.close();
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

		return count;
	}
	
	protected String getXmlPathHeader(){
		throw new IllegalStateException();
	}
	
	protected SQLCommand getSQLCommand(String xmlPath, String id)
			throws Exception {
		SQLBuilder builder = new SQLBuilder(getXmlPathHeader() + xmlPath);
		return builder.getSql(id);
	}
	
	public int update(String tableName,ParameterModel model,ParameterModel conds) throws Exception{
		String sql = "UPDATE {tableName} set {values} WHERE {conds}";
		sql = sql.replace("{tableName}", tableName);
		Iterator<String> it = model.keySet().iterator();
		String vs = "";
		List<Object> vsl = new ArrayList<Object>();
		while(it.hasNext()){
			String key = it.next();
			Object value = model.get(key);
			vsl.add(value);
			vs += key + "= ?,";
		}
		vs = vs.substring(0,vs.length()-1);
		sql = sql.replace("{values}", vs);
		
		String cs = "";
		it = conds.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			Object value = conds.get(key);
			vsl.add(value);
			cs += key + "= ? AND ";
		}
		cs = cs.substring(0,cs.length()-4);
		sql = sql.replace("{conds}", cs);
		
		return execute(sql, vsl.toArray());
	}
	
	public int insert(String tableName,ParameterModel model) throws Exception{
		String sql = "INSERT INTO {tableName} ({columns})values({values})";
		sql = sql.replace("{tableName}", tableName);
		Iterator<String> it = model.keySet().iterator();
		String cs = "";
		String vs = "";
		List<Object> vsl = new ArrayList<Object>();
		while(it.hasNext()){
			String key = it.next();
			Object value = model.get(key);
			vsl.add(value);
			cs += key + ",";
			vs += "?"+ ",";
		}
		cs = cs.substring(0,cs.length()-1);
		vs = vs.substring(0,vs.length()-1);
		sql = sql.replace("{columns}", cs);
		sql = sql.replace("{values}", vs);
		
		return execute(sql, vsl.toArray());
	}
	protected DataSet<DataRow> executeQuery(SQLCommand cmd, String[] sqlState, int first, int rows)throws Exception {
		//Object [] paras=;
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		String[] strings = sql.split("#");
		sql="";
		for (int i = 0; i < sqlState.length; i++) {
			sql+=strings[i];
			sql+=sqlState[i];
		}
		return executeQuery(sql,list.toArray(),first,rows);
	}
	protected DataSet<DataRow> executeQuery(SQLCommand cmd , String[] sqlState) throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		String[] strings = sql.split("#");
		sql="";
		for (int i = 0; i < sqlState.length; i++) {
			sql+=strings[i];
			sql+=sqlState[i];
		}
		return this.executeQuery(sql,list.toArray());
	}
}
