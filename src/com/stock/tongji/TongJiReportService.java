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
		// ���ɲ�������һ����ʽ
        biduistyle.setColor(HSSFColor.BLUE.index);
        biduistyle.setBlod(true);
        CellStyle yichustyle = new CellStyle();
		// ���ɲ�������һ����ʽ
        yichustyle.setColor(HSSFColor.BROWN.index);
        yichustyle.setBlod(true);
		excel.setSheetName("��װͳ��");
		Row header = new Row();
		//Cell cell = new Cell("����ѧϰ����ͳ�Ʊ�");
		//header.addCell(cell);
		header.addCell("�û�����");
		header.addCell("���֤");
		header.addCell("����");
		
		header.addCell("ͣ��ʱ��");
		header.addCell("С��");
		header.addCell("��ַ");
		header.addCell("�绰");
		
		header.addCell("����");
		//header.addCell("����ʱ��");
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
		header.addCell("ҵ������");
		//header.addCell("��Ʊ��Ϣ");
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
		set.add("xiangmu", "@xiangmu", "��װ");
		return set;
	}
}
