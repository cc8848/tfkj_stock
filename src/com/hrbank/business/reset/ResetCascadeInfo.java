package com.hrbank.business.reset;

import com.takucin.aceeci.cascade.CascadeSource;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;

public class ResetCascadeInfo implements CascadeSource {

	private ResetService service = new ResetService();

	public DataSet<DataRow> getSource(String[] params) throws Exception {
		return service.getEmployeeById(params[0]);
	}

}
