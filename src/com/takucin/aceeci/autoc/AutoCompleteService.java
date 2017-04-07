package com.takucin.aceeci.autoc;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.common.CommonModule;
import com.takucin.aceeci.common.Constant;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;
import com.takucin.aceeci.util.DataSetUtil;

public class AutoCompleteService extends BusinessService {
	
	private CommonDao dao = new CommonDao();
	
	public JSONObject toJsonObject(List<CommonModule> modules){
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < modules.size(); i++) {
			JSONObject subJson = new JSONObject();
			CommonModule module = modules.get(i);
			String value = Common.fillText(module.getKey(), 13,"&nbsp;",Common.FILL_RIGHT) + module.getValue();
			subJson.put(Constant.LIST, value);
			jsonArray.put(i, subJson);
		}
		json.put(Constant.RESULT_LIST, jsonArray);
		return json;
	}
	
	public List<CommonModule> getDepartments(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("departmentId", "@departmentId", (code == null ? "" : code) + "%");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetDepartmentSource", set, 0, 10));
	}
	
	public List<CommonModule> getEmployees(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("employeeId", "@employeeId", (code == null ? "" : code) + "%");
		return DataSetUtil.toCommonModuleList(dao.executeQuery("GetEmployeeSource", set, 0, 10));
	}
}
