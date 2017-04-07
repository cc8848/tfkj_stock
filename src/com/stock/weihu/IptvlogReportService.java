package com.stock.weihu;

import java.util.ArrayList;
import java.util.List;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.excel.Cell;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.excel.ExcelUtil;
import com.takucin.aceeci.excel.Row;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class IptvlogReportService extends BusinessService{

	private CommonDao dao = new CommonDao();
	
	public Excel getExportExcel(IptvlogEidtForm form)throws Exception{
		DataSet<DataRow> dateSet = getResult(form);
		
		
		Excel excel = new Excel();
		excel.setSheetName("iptv接口日志");
		Row header = new Row();
		header.addCell("停机帐号");
		header.addCell("有效时间");
		header.addCell("是否成功");
		header.addCell("服务器ip");
		excel.set(header);
		List<String> list = new ArrayList<String>();
		list.add("tingjizhanghao");
		list.add("tingjishijian");
		list.add("shifouchenggong");
		list.add("serverip");
		excel.set(ExcelUtil.toExcelRowList(dateSet,list),1,0);
		return excel;
	}
	
	public DataSet<DataRow> getResult(IptvlogEidtForm form)throws Exception {
		return dao.executeQuery("getIptvlogInfo",getConditionParameterSet(form));
		}
	
	private ParameterSet getConditionParameterSet(IptvlogEidtForm form){
		ParameterSet set = new ParameterSet();
		set.add("tingjishijian", "@tingjishijian", form.getTingjishijian());
		set.add("tingjizhanghao", "@tingjizhanghao", form.getTingjizhanghao());
		set.add("shifouchenggong", "@shifouchenggong", form.getShifouchenggong());
		set.add("serverip", "@serverip", form.getServerip());
		return set;
	}
}
