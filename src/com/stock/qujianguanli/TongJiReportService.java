package com.stock.qujianguanli;

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

public class TongJiReportService extends BusinessService{

	private CommonDao dao = new CommonDao();
	
	public Excel getExportExcel(TongjiForm form)throws Exception{
		DataSet<DataRow> dateSet = getResult(form);
		
		
		Excel excel = new Excel();
		excel.setSheetName("�ռ�ͳ��");
		Row header = new Row();
		//Cell cell = new Cell("����ѧϰ����ͳ�Ʊ�");
		//header.addCell(cell);
		header.addCell("��Ŀ");
		
		header.addCell("����");
		header.addCell("С��");
		header.addCell("��ַ");
		header.addCell("�绰");
		
		header.addCell("����");
		header.addCell("����");
		header.addCell("�绰");
		header.addCell("ҵ��");
		
		header.addCell("�ֹ�");
		header.addCell("onumac");
		header.addCell("STB MCID");
		header.addCell("����ip");
		
		header.addCell("����ip");
		header.addCell("�绰ip");
		header.addCell("�绰valn");
		header.addCell("����valn");
		//---new add
		header.addCell("����ʱ��");
		header.addCell("��֤");
		header.addCell("��ѡ�绰����");
		header.addCell("ONUѺ��");
		header.addCell("������Ѻ��");
		header.addCell("���ӷ�");
		header.addCell("�����");
		header.addCell("��װ��");
		header.addCell("�豸���۷�");
		header.addCell("���Ϸ�");
		header.addCell("��Ӫ��");
		header.addCell("�����¹��� ");
		header.addCell("��� ");
		
		header.addCell("��ע");
		header.addCell("��Ʊ��Ϣ ");
		excel.set(header);
		List<String> list = new ArrayList<String>();
		list.add("xiangmu");
		
		list.add("paigongriqi");
		list.add("xiaoquname");
		list.add("userplace");
		list.add("usertel");
		
		list.add("tfkuandaidaikuan");
		list.add("tfiptv");
		list.add("dianhua");
		list.add("qtye");
		
		list.add("fenguang");
		list.add("OUMMAC");
		list.add("STBMAC");
		list.add("tvip");
		list.add("netip");
		
		list.add("telip");
		list.add("telvaln");
		list.add("netvaln");
		
		list.add("anzhuangshijian");
		list.add("danzheng");//��֤
		list.add("telhaoma");//��ѡ����
		list.add("onu");//onuѺ��
		list.add("jidinghe");
		list.add("shoushifei");
		list.add("kuaidaifei");//�����
		list.add("chuzhuangfei");
		list.add("shebeixiaoshou");
		list.add("cailiaofei");
		list.add("yuyingshang");
		list.add("buzuyue");
		list.add("nianfei");
		
		
		list.add("beizhu");
		list.add("kaipiaoxinxi");
		excel.set(ExcelUtil.toExcelRowList(dateSet,list),1,0);
		return excel;
	}
	
	public DataSet<DataRow> getResult(TongjiForm form)throws Exception {
		return dao.executeQuery("GetPGDList",getConditionParameterSet(form));
		}
	
	private ParameterSet getConditionParameterSet(TongjiForm form){
		ParameterSet set = new ParameterSet();
		set.add("paigongriqi", "@paigongriqi", form.getPaigongriqi());
		set.add("xiaoquname", "@xiaoquname", form.getXiaoqu());
		set.add("state", "@nostate", "15");
		set.add("xiangmu", "@xiangmu", "�ռ�");
		return set;
	}
}
