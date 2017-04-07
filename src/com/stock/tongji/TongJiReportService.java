package com.stock.tongji;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.excel.CellStyle;
import com.takucin.aceeci.excel.Excel;
import com.takucin.aceeci.excel.ExcelUtil;
import com.takucin.aceeci.excel.Row;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class TongJiReportService extends BusinessService{

	private CommonDao dao = new CommonDao();
	
	public Excel getExportExcel(TongjiForm form)throws Exception{
		DataSet<DataRow> dateSet = getResult(form);
		
		
		Excel excel = new Excel();
		HSSFWorkbook pgdworkbook = excel.getWorkbook();
		CellStyle biduistyle = new CellStyle();
		// 生成并设置另一个样式
        biduistyle.setColor(HSSFColor.BLUE.index);
        biduistyle.setBlod(true);
        CellStyle yichustyle = new CellStyle();
		// 生成并设置另一个样式
        yichustyle.setColor(HSSFColor.BROWN.index);
        yichustyle.setBlod(true);
		excel.setSheetName("安装统计");
		Row header = new Row();
		//Cell cell = new Cell("网上学习进度统计表");
		//header.addCell(cell);
		header.addCell("用户姓名");
		header.addCell("身份证");
		header.addCell("日期");
		
		header.addCell("停机时间");
		header.addCell("小区");
		header.addCell("地址");
		header.addCell("电话");
		
		header.addCell("网络");
		//header.addCell("网络时长");
		header.addCell("电视");
		header.addCell("电话");
		header.addCell("业务");
		
		header.addCell("分光");
		header.addCell("onumac");
		header.addCell("STB MCID");
		header.addCell("电视ip");
		
		header.addCell("网络ip");
		header.addCell("电话ip");
		header.addCell("电话valn");
		header.addCell("网络valn");
		//---new add
		header.addCell("上门时间");
		header.addCell("单证");
		header.addCell("所选电话号码");
		header.addCell("ONU押金");
		header.addCell("机顶盒押金");
		header.addCell("收视费");
		header.addCell("宽带费");
		header.addCell("初装费");
		header.addCell("设备销售费");
		header.addCell("材料费");
		header.addCell("运营商");
		header.addCell("不足月够费 ");
		header.addCell("年费 ");
		
		
		header.addCell("备注");
		header.addCell("业务类型");
		//header.addCell("开票信息");
		excel.set(header);
		List<String> list = new ArrayList<String>();
		list.add("username");
		list.add("shenfenzheng");
		list.add("newkaijishijian");
		
		list.add("newtingjishijian");
		list.add("xiaoquname");
		list.add("userplace");
		list.add("usertel");
		
		list.add("tfkuandaidaikuan");
		//list.add("tfkdnianxian");
		list.add("tfiptv");
		list.add("tfsfyewu");
		list.add("qtye");
		
		list.add("fenguangD");
		list.add("onumacD");
		list.add("stbmcidD");
		list.add("dianshiipD");
		list.add("netip");
		
		list.add("telip");
		list.add("telvaln");
		list.add("netvaln");
		
		list.add("anzhuangshijian");
		list.add("danzheng");//单证
		list.add("telhaoma");//所选号码
		list.add("onu");//onu押金
		list.add("jidinghe");
		list.add("shoushifei");
		list.add("kuaidaifei");//宽带费
		list.add("chuzhuangfei");
		list.add("shebeixiaoshou");
		list.add("cailiaofei");
		list.add("yuyingshang");
		list.add("buzuyue");
		list.add("nianfei");
		
		
		list.add("beizhu");
		list.add("yewuleixing");
		//list.add("kaipiaoxinxi");
		excel.set(ExcelUtil.toExcelRowList1(dateSet,list,biduistyle,yichustyle,pgdworkbook),1,0);
		return excel;
	}
	
	public DataSet<DataRow> getResult(TongjiForm form)throws Exception {
		return dao.executeQuery("GetPGDListExcel",getConditionParameterSet(form));
		}
	
	private ParameterSet getConditionParameterSet(TongjiForm form){
		ParameterSet set = new ParameterSet();
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqi());
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqu());
		set.add("state", "@nostate", "14");
		set.add("xiangmu", "@xiangmu", "安装");
		return set;
	}
}
