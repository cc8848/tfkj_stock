package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.takucin.aceeci.frame.sql.DataElement;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.webService.WebServiceMethods;
import com.webService.xmlStr.BaseString;

public class TestXml extends BaseString {
    public static void main(String[] args) {
	
	DataSet<DataRow> query = new DataSet<DataRow>();
	DataRow o = new DataRow();
	DataElement de = null;
	de = new DataElement();
	de.setColumnValue("888888");
	o.addDataElement("uuid", de);
	
	de = new DataElement();
	de.setColumnValue("赵兴华");
	o.addDataElement("xingming", de);
	
	de = new DataElement();
	de.setColumnValue("371122198710216338");
	o.addDataElement("shenfenzheng", de);
	
	de = new DataElement();
	de.setColumnValue("13163033587");
	o.addDataElement("lianxidianhua", de);
	
	de = new DataElement();
	de.setColumnValue("美域豪庭");
	o.addDataElement("xiaoqu", de);
	de = new DataElement();
	de.setColumnValue("36-2-0112");
	o.addDataElement("dizhi", de);
	de = new DataElement();
	de.setColumnValue("已安装");
	o.addDataElement("yonghuzhuangtai", de);
	de = new DataElement();
	de.setColumnValue("电信网络");
	o.addDataElement("yewu", de);
	de = new DataElement();
	de.setColumnValue("12M");
	o.addDataElement("wangluo", de);
	de = new DataElement();
	de.setColumnValue("016z3620112");
	o.addDataElement("wangluoip", de);
	
	query.add(o);
	//WebServiceMethods.AnZhuang(query, "");
	//WebServiceMethods.ChangeSL(query, "22", "24");
	//WebServiceMethods.ChangePwd(query);
	//WebServiceMethods.Tingji(query.get(0));
	//WebServiceMethods.Fuji(query.get(0));
	WebServiceMethods.TuiDing(query);
    }
}
