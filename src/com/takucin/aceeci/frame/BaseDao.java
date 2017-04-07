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
 * ���ݷ��ʲ�Ļ��࣬�ṩ�����ݿ���ɾ�Ĳ�͵��ô洢���̵�֧��.
 */
public abstract class BaseDao {

	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * ��õ�ǰ��Connection.
	 * 
	 * @return ��ǰ��Connection.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ����һ��CallableStatement�������ڵ��ô洢����.
	 * 
	 * ʹ�ô˷������ص�CallableStatement������Ҫ��ʹ����Ϻ����close()��������֤�������ر�.
	 * @return һ������ִ�д洢���̵�CallableStatement����.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ����ҳ��ѯ��䣬���ز�ѯ����������ݼ�.
	 * 
	 * @param sql Ԥ����sql��䣬�����б�ʹ��"?"����.
	 * @param params ��Ӧsql���Ĳ�������.
	 * @param first ��ҳ����ʼ��¼��.
	 * @param rows ��ҳ��ÿҳ��ʾ����.
	 * @return ��ѯ����������ݼ�.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ����ҳ��ѯ��䣬���ز�ѯ����������ݼ�.
	 * @param cmd ��ѯ���
	 * @param first ��ҳ����ʼ��¼��
	 * @param rows ��ҳ��ÿҳ��ʾ����
	 * @return ��ѯ����������ݼ�
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected DataSet<DataRow> executeQuery(SQLCommand cmd,int first, int rows)throws Exception {
		//Object [] paras=;
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return executeQuery(sql,list.toArray(),first,rows);
	}
	
	/**
	 * ��#��sqlִ�д˷������Զ���sqlState�滻��#
	 * @param cmd ��ѯ���
	 * @param first ��ҳ����ʼ��¼��
	 * @param rows ��ҳ��ÿҳ��ʾ����
	 * @return ��ѯ����������ݼ�
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected DataSet<DataRow> executeQuery(SQLCommand cmd, String sqlState, int first, int rows)throws Exception {
		//Object [] paras=;
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		sql = sql.replaceAll("#", sqlState);
		return executeQuery(sql,list.toArray(),first,rows);
	}
	
	/**
	 * ִ��һ����ҳ��ѯ��䣬���ز�ѯ����������ݼ����˷�������ָ����ҳ���ݵ�����.
	 * 
	 * @param sql Ԥ����sql��䣬�����б�ʹ��"?"����.
	 * @param params ��Ӧsql���Ĳ�������.
	 * @param first ��ҳ����ʼ��¼��.
	 * @param rows ��ҳ��ÿҳ��ʾ����.
	 * @param orderBy �����ֶ��б�����Ҫָ��order by��ֱ�ӳ����������ֶκ�����ʽ����.
	 * @return ��ѯ����������ݼ�.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ����ѯ��䣬���ز�ѯ����������ݼ�.
	 * @param cmd ��ѯ����
	 * @return ��ѯ����������ݼ�.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ����ѯ��䣬���ز�ѯ����������ݼ�.
	 * 
	 * @param sql Ԥ����sql��䣬�����б�ʹ��"?"����.
	 * @param params ��Ӧsql���Ĳ�������.
	 * @return ��ѯ����������ݼ�.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ��insert��update��delete��sql���.
	 * @param sql Ԥ����sql��䣬�����б�ʹ��"?"����.
	 * @param params ��Ӧsql���Ĳ�������.
	 * @return ����Ӱ��ļ�¼��.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ִ��һ��insert��update��delete��sql���.
	 * @param cmd ִ����估����
	 * @return ����Ӱ��ļ�¼��.
	 * @throws Exception ��������κδ����׳����쳣.
	 */
	protected int execute(SQLCommand cmd)throws Exception{
		List<Object> list = new ArrayList<Object>();
		String sql = cmd.getRunScriptAndParameter(list);
		return execute(sql,list.toArray());
	}
	
	/**
	 * ����ResultSet�������װ�������ݼ�.
	 * @param rs һ��ResultSet����.
	 * @return ���ط�װ���������ݼ�.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ���ݴ���Ĳ����б�������PreparedStatement�����з�װ����.
	 * @param sta һ��PreparedStatement����.
	 * @param params ��Ӧsql���Ĳ�������.
	 * @throws Exception ��������κδ����׳����쳣.
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
	 * ȡ������ֵ
	 * @param sequenceName ��������
	 * @return �µ�����ֵ
	 * @throws Exception ��������κδ����׳����쳣.
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
