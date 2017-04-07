package com.stock.fenPeiIp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.stock.yonghushuju.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class FenguangKeService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	private ImportService service = new ImportService();
	private String check_huidan="";
	public DataSet<DataRow> getFenguangKeList(KeFenPeiFenGuangForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQuery("getFenguangFenpeiList", getParameterSetFenguangKe(form), first, rows);
	}
	public int getFenguangKeListCount(KeFenPeiFenGuangForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getFenguangFenpeiListCount", getParameterSetFenguangKe(f));
	}
    private ParameterSet getParameterSetFenguangKe(KeFenPeiFenGuangForm form) {
	ParameterSet set = new ParameterSet();
	if (!(form.getFenguangID() == null) && !(form.getFenguangID().trim().equals(""))) {
	    set.add("fenguangID", "@fenguangID", "%" + form.getFenguangID() + "%");
	}
	if (!(form.getKuang() == null) && !(form.getKuang().trim().equals(""))) {
	    set.add("kuang", "@kuang", "%" + form.getKuang() + "%");
	}
	if (!(form.getFenguang() == null) && !(form.getFenguang().trim().equals(""))) {
	    set.add("fenguang", "@fenguang", "%" + form.getFenguang() + "%");
	}
	if (!(form.getRemark() == null) && !(form.getRemark().trim().equals(""))) {
	    set.add("remark", "@remark", "%" + form.getRemark() + "%");
	}
	if (!(form.getUUID() == null) && !(form.getUUID().trim().equals(""))) {
	    set.add("uuid", "@uuid", form.getUUID());
	}
	set.add("mask", "@mask", form.getMask());
	return set;
    }
    public void updateJti(String uuid,String newjti,HttpServletRequest request) throws Exception {
    	String name = getUserInfo(request).getEmployeeName();
		String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
		ParameterSet set = new ParameterSet();
		ParameterModel model = new ParameterModel();
	    model.put("Lifecycle_sta", "9");
	    DataRow existdata = getFenguang(uuid);
	    model.put("remark", "（分光分配删除，操作人：" + name + " 操作时间：" + time + ")"+existdata.getDataElement("remark").getString());
	    if(model.get("remark").toString().length()>2000) {
	    	model.put("remark",model.get("remark").toString().substring(0,2000));
	    }
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		dao.update("fenguangfenpei", model, conds);
	}
    public void updateMask(String uuid,HttpServletRequest request,String newmask) throws Exception {
		String name = getUserInfo(request).getEmployeeName();
		String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
		ParameterModel model = new ParameterModel();
	    model.put("mask", newmask);
	    DataRow existdata = getFenguang(uuid);
	    if("1".equals(newmask)) {
	    	model.put("remark", "（手动分配分光，操作人：" + name + " 操作时间：" + time + ")"+existdata.getDataElement("remark").getString());
	    }else{
	    	model.put("remark", "（分光回收使用，操作人：" + name + " 操作时间：" + time + ")"+existdata.getDataElement("remark").getString());
	    }
	    if(model.get("remark").toString().length()>2000) {
	    	model.put("remark",model.get("remark").toString().substring(0,2000));
	    }
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		dao.update("fenguangfenpei", model, conds);
	}
	public void updateGuize(String uuid,KeFenPeiFenGuangForm newbean,HttpServletRequest request) throws Exception {
		String name = getUserInfo(request).getEmployeeName();
		String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
		ParameterModel model = new ParameterModel();
		model.put("fenguangID", newbean.getFenguangID());
		model.put("kuang", newbean.getKuang());
		model.put("fenguang", newbean.getFenguang());
		model.put("remark", "（分光分配编辑，操作人：" + name + " 操作时间：" + time + ")"+newbean.getRemark());
		    if(model.get("remark").toString().length()>2000) {
		    	model.put("remark",model.get("remark").toString().substring(0,2000));
		    }
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		dao.update("fenguangfenpei", model, conds);
	}
	
	public DataRow getFenguang(String uuid) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", uuid);
		return dao.executeQueryToDataRow("queryfenguangfenpei", set);
	}
	
	/**
	 * 插入用户数据
	 * 
	 * @param classid
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage importGuize(InputStream input) throws Exception {
		List<KeFenPeiFenGuangForm> list = new ArrayList<KeFenPeiFenGuangForm>();

		try {
			list = parse(input);
			if (check_huidan.equals("error2")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"格式输入有误！");
			} else if (null == list || list.size() == 0) {
				return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new CommonMessage(ErrorConstant.UP_DATA_ERROR);
		}

		try {
			openTransaction();
			// int i = 1;
			for (KeFenPeiFenGuangForm huidan : list) {
				ParameterModel model = new ParameterModel();
				model.put("fenguangID", huidan.getFenguangID());
				model.put("kuang", huidan.getKuang());
				model.put("fenguang", huidan.getFenguang());
				if(huidan.getMask()==null||"".equals(huidan.getMask())) {
					huidan.setMask("0");
				}
				model.put("mask", huidan.getMask());
				model.put("remark", huidan.getRemark());
				model.put("Lifecycle_sta", "0");
				dao.insert("fenguangfenpei", model);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}
	public List<KeFenPeiFenGuangForm> parse(InputStream input) throws Exception {
		List<KeFenPeiFenGuangForm> list = new ArrayList<KeFenPeiFenGuangForm>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int i = 1;// 从excel第一行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			KeFenPeiFenGuangForm huidanentity = new KeFenPeiFenGuangForm();
			String[] values = service.convertRow(hssfRow, 36);// excel 读取的列数
			for(int x=0;x<values.length;x++){
				if(values[x] == null){
					check_huidan = "error2";
					break;
				}
			}
			huidanentity.setFenguangID(values[0]);//分光ID
			huidanentity.setKuang(values[1]);//框
			huidanentity.setFenguang(values[2]);//分光
			huidanentity.setMask(values[3]);//掩码
			huidanentity.setRemark(values[4]);//备注
			list.add(huidanentity);
			i++;
		}

		return list;
	}
	public String pipeipgd(String xiaoqu,String dizhi,HttpServletRequest request) throws Exception {
		ParameterSet set = new ParameterSet();
		String name = getUserInfo(request).getEmployeeName();
		String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
		dizhi = dizhi.replaceAll("别墅", "0000");
		try{
			set.add("xiaoqu", "@xiaoqu", "%" + xiaoqu + "%");
			set.add("louhao", "@louhao",  "%" + dizhi.substring(0, 2) + "%");
			set.add("loumen", "@loumen",  "%" + dizhi.substring(3, 4) + "%");
			set.add("louceng", "@louceng", "%" + dizhi.substring(5, 7) + "%");
			set.add("danyuan", "@danyuan",  "%" + dizhi.substring(7, 9) + "%");
		}catch(Exception e) {
			return "NOGUIZE";
		}
		DataSet<DataRow> guizeRows = dao.executeQuery("getFenguangInfoList",set, 0, 999);
		if(guizeRows==null||guizeRows.size()==0) {
			return "NOGUIZE";
		}
		ParameterSet set2 = new ParameterSet();
		set2.add("fenguangID", "@fenguangID", "%" + guizeRows.get(0).getDataElement("fenguangID").getString() + "%");
		set2.add("mask", "@mask", "0");
		DataSet<DataRow> fenguangRows = dao.executeQuery("getFenguangFenpeiList", set2, 0, 999);
		if(fenguangRows==null||fenguangRows.size()==0) {
			return "NOFENGUANG";
		}
		ParameterModel model = new ParameterModel();
	    model.put("mask", "1");
	    DataRow existdata = getFenguang(fenguangRows.get(0).getDataElement("PK_ID").getString());
	    model.put("remark", "（分光分配，操作人：" + name + " 操作时间：" + time + ","+xiaoqu+dizhi+")"+existdata.getDataElement("remark").getString());
	    if(model.get("remark").toString().length()>2000) {
	    	model.put("remark",model.get("remark").toString().substring(0,2000));
	    }
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", fenguangRows.get(0).getDataElement("PK_ID").getString());
		dao.update("fenguangfenpei", model, conds);
		return fenguangRows.get(0).getDataElement("fenguang").getString()+"@"+fenguangRows.get(0).getDataElement("PK_ID").getString();
	}
	public int updatepgdfenguang(String uuid,String fenguang,String fenguangID) throws Exception {
		ParameterModel model = new ParameterModel();
	    model.put("fenguangD", fenguang);
	    model.put("fenguangID", fenguangID);
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		return dao.update("paigongdan", model, conds);
	}
	public int updatePreImportfenguang(String uuid,String fenguang,String fenguangID) throws Exception {
		ParameterModel model = new ParameterModel();
	    model.put("fenguangD", fenguang);
	    model.put("fenguangID", fenguangID);
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		return dao.update("paigongdanpreimport", model, conds);
	}
	public int updateJiucuofenguang(String uuid,String fenguang,String fenguangID) throws Exception {
		ParameterModel model = new ParameterModel();
	    model.put("fenguang", fenguang);
	    model.put("fenguangID", fenguangID);
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		return dao.update("huidandata", model, conds);
	}
	public int updatewxfenguang(String uuid,String fenguang,String fenguangID) throws Exception {
		ParameterModel model = new ParameterModel();
	    model.put("fenguang", fenguang);
	    model.put("fenguangID", fenguangID);
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		return dao.update("yonghushuju", model, conds);
	}
	public void recyclefenguang(String fenguanguuid,HttpServletRequest request) throws Exception {
		String name = getUserInfo(request).getEmployeeName();
		String time = Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
		ParameterSet set2 = new ParameterSet();
		set2.add("uuid", "@uuid", fenguanguuid);
		DataSet<DataRow> fenguangRows = dao.executeQuery("getFenguangFenpeiList", set2, 0, 999);
		if(fenguangRows!=null&&fenguangRows.size()!=0) {
			ParameterModel model = new ParameterModel();
		    model.put("mask", "0");
		    model.put("remark", "（分光回收，操作人：" + name + " 操作时间：" + time + ")"+fenguangRows.get(0).getDataElement("remark").getString());
		    ParameterModel conds = new ParameterModel();
		    conds.put("uuid",fenguanguuid);
			dao.update("fenguangfenpei", model, conds);
		}
	}
}
