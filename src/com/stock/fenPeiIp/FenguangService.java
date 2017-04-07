package com.stock.fenPeiIp;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.stock.huidan.HuidanEntityForm;
import com.stock.huidan.PhotoUploadForm;
import com.stock.yonghushuju.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class FenguangService extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());
	private CommonDao dao = new CommonDao();
	private ImportService service = new ImportService();
	private String check_huidan="";
	public DataSet<DataRow> getFenguangList(FenPeiFenGuangGuiZeForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQuery("getFenguangInfoList",
				getParameterSetFenguangGuize(form), first, rows);
	}

	public int getFenguangListCount(FenPeiFenGuangGuiZeForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getFenguangInfoListCount",
				getParameterSetFenguangGuize(f));
	}

	private ParameterSet getParameterSetFenguangGuize(
			FenPeiFenGuangGuiZeForm form) {
		ParameterSet set = new ParameterSet();
		if (!(form.getUUID() == null)
				&& !(form.getUUID().trim().equals(""))) {
			set.add("uuid", "@uuid", form.getUUID());
		}
		if (!(form.getXiaoqu() == null)
				&& !(form.getXiaoqu().trim().equals(""))) {
			set.add("xiaoqu", "@xiaoqu", "%" + form.getXiaoqu() + "%");
		}
		if (!(form.getLouhao() == null)
				&& !(form.getLouhao().trim().equals(""))) {
			set.add("louhao", "@louhao",  "%" + form.getLouhao() + "%");
		}
		if (!(form.getLoumen() == null)
				&& !(form.getLoumen().trim().equals(""))) {
			set.add("loumen", "@loumen",  "%" + form.getLoumen() + "%");
		}
		if (!(form.getLouceng() == null)
				&& !(form.getLouceng().trim().equals(""))) {
			set.add("louceng", "@louceng", "%" + form.getLouceng() + "%");
		}
		if (!(form.getDanyuan() == null)
				&& !(form.getDanyuan().trim().equals(""))) {
			set.add("danyuan", "@danyuan",  "%" + form.getDanyuan() + "%");
		}
		if (!(form.getFenguangID() == null)
				&& !(form.getFenguangID().trim().equals(""))) {
			set.add("fenguangID", "@fenguangID",  "%" + form.getFenguangID() + "%");
		}
		if (!(form.getBeizhu() == null)
				&& !(form.getBeizhu().trim().equals(""))) {
			set.add("beizhu", "@beizhu",  "%" + form.getBeizhu() + "%");
		}
		return set;
	}
	
	public void updateJti(String uuid,String newjti) throws Exception {
		ParameterSet set = new ParameterSet();
		ParameterModel model = new ParameterModel();
	    model.put("Lifecycle_sta", "9");
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		dao.update("fenguangguize", model, conds);
	}
	public void updateGuize(String uuid,FenPeiFenGuangGuiZeForm newbean) throws Exception {
		ParameterModel model = new ParameterModel();
		model.put("xiaoqu", newbean.getXiaoqu());
		model.put("louhao", newbean.getLouhao());
		model.put("loumen", newbean.getLoumen());
		model.put("louceng", newbean.getLouceng());
		model.put("danyuan", newbean.getDanyuan());
		model.put("fenguangID", newbean.getFenguangID());
		model.put("beizhu", newbean.getBeizhu());
	    ParameterModel conds = new ParameterModel();
	    conds.put("uuid", uuid);
		dao.update("fenguangguize", model, conds);
	}
	
	public DataRow getFenguang(String uuid) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", uuid);
		return dao.executeQueryToDataRow("queryfenguang", set);
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
		List<FenPeiFenGuangGuiZeForm> list = new ArrayList<FenPeiFenGuangGuiZeForm>();

		try {
			list = parse(input);
			if (check_huidan.equals("error2")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"格式输入有误！");
			} else if (check_huidan.equals("error3")) {
				return new CommonMessage(ErrorConstant.IMPORT_YIXUFEI_ERROR0,"小区名不存在，请检查后重新输入！");
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
			for (FenPeiFenGuangGuiZeForm huidan : list) {
				ParameterModel model = new ParameterModel();
				model.put("xiaoqu", huidan.getXiaoqu());
				model.put("louhao", huidan.getLouhao());
				model.put("loumen", huidan.getLoumen());
				model.put("louceng", huidan.getLouceng());
				model.put("danyuan", huidan.getDanyuan());
				model.put("fenguangID", huidan.getFenguangID());
				model.put("beizhu", huidan.getBeizhu());
				model.put("Lifecycle_sta", "0");
				dao.insert("fenguangguize", model);
			}
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}
	public List<FenPeiFenGuangGuiZeForm> parse(InputStream input) throws Exception {
		List<FenPeiFenGuangGuiZeForm> list = new ArrayList<FenPeiFenGuangGuiZeForm>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		DataSet<DataRow> xiaoqus = dao.executeQuery("getcode1", new ParameterSet());
		
		int i = 1;// 从excel第一行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			FenPeiFenGuangGuiZeForm huidanentity = new FenPeiFenGuangGuiZeForm();
			String[] values = service.convertRow(hssfRow, 36);// excel 读取的列数
			for(int x=0;x<values.length;x++){
				if(values[x] == null){
					check_huidan = "error2";
					break;
				}
			}
			for (int m = 0; m < xiaoqus.size(); m++) {
				check_huidan = "error3";
				if (xiaoqus.get(m).getDataElement("xiaoqu").getString().equals(values[0])) {
					check_huidan = "";
					break;
				} 
			}
			huidanentity.setXiaoqu(values[0]);//小区
			huidanentity.setLouhao(values[1]);//楼号
			huidanentity.setLoumen(values[2]);//楼门
			huidanentity.setLouceng(values[3]);//楼层
			huidanentity.setDanyuan(values[4]);//单元
			huidanentity.setFenguangID(values[5]);//分光ID
			huidanentity.setBeizhu(values[6]);//备注
			list.add(huidanentity);
			i++;
		}

		return list;
	}
}
