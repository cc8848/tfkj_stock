package com.stock.huidan;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.Constant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.DataSet;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class PhotoService  extends BusinessService {
	private Log log = LogFactory.getLog(this.getClass());	
	private CommonDao dao = new CommonDao();
	
	public DataSet<DataRow> getPhotoUploadList(PhotoUploadForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQuery("getPhotoUploadInfoList", getParameterSetPhotoUpload(form,"0"), first, rows);
	}
	public DataRow getPhotoUploadList(PhotoUploadForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", form.getUUID());
		return dao.executeQueryToDataRow("getPhotoUploadInfo",set);
	}
	public int getPhotoUploadTaocan(PhotoUploadForm form) throws Exception {
		ParameterSet set = new ParameterSet();
		set.add("uuid", "@uuid", form.getUUID());
		return dao.executeQueryToCount("getPhotoUploadTaocanNum",set);
	}
	public int getPhotoUploadListCount(PhotoUploadForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getPhotoUploadInfoListCount", getParameterSetPhotoUpload(f,"0"));
	}
	public String update_hedui(String uuid,String text) throws Exception {
		try {
		    openTransaction();
		    ParameterSet set = new ParameterSet();
		    String beizhu = "/（"+text+")/";
		    	set.add("uuid", "@uuid", uuid);
		    	set.add("beizhu", "@beizhu", beizhu);
		    	dao.execute("auditPhotoUploadHeduiBeizhuByuuid", set);
		    commit();
		} catch (Exception e) {
		    e.printStackTrace();
		    rollback();
		}
		return Constant.SUCCESS;
	}
	public DataSet<DataRow> getPhotoAuditList(PhotoUploadForm form,
			int first, int rows) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQuery("getPhotoUploadInfoList", getParameterSetPhotoUpload(form,"1"), first, rows);
	}
	public int getPhotoAuditListCount(PhotoUploadForm f) throws Exception {
		ParameterSet set = new ParameterSet();
		return dao.executeQueryToCount("getPhotoUploadInfoListCount", getParameterSetPhotoUpload(f,"1"));
	}
	
    /**
     * 核对提交的update
     * 
     * @param f
     * @param request
     * @param life_to
     * @return
     * @throws Exception
     */
    public String update_tijiao(PhotoUploadForm f,String newjti,String operater) throws Exception {
	try {
	    openTransaction();
	    ParameterSet set = new ParameterSet();
	    set.add("Lifecycle_sta", "@Lifecycle_sta", newjti);
	    String[] selectuuids = f.getUUIDS();
	    String operation = "";
	    if("0".equals(newjti)) {
	    	operation = "错误退回";
	    }else if("1".equals(newjti)) {
	    	operation = "审核提交";
	    }else if("2".equals(newjti)) {
	    	operation = "提交FTP";
	    }else if("删除".equals(newjti)) {
	    	operation = "删除信息";
	    }
	    String time =  Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
	    String beizhu = "/（"+operation+"，操作人："+operater+" 操作时间："+time+")/";
	    for(int i=0;i<selectuuids.length;i++) {
	    	set.add("uuid", "@uuid", selectuuids[i]);
	    	set.add("beizhu", "@beizhu", beizhu);
	    	dao.execute("auditPhotoUploadJtiByuuid", set);
	    }
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	}
	return Constant.SUCCESS;
    }
    /**
     * 更改上传状态的update
     * 
     * @param f
     * @param request
     * @param life_to
     * @return
     * @throws Exception
     */
    public String update_jti(PhotoUploadForm f,String newjti,String operater) throws Exception {
	try {
	    openTransaction();
	    ParameterSet set = new ParameterSet();
	    set.add("yonghuzhuangtai", "@yonghuzhuangtai", newjti);
	    String[] selectuuids = f.getUUIDS();
	    String operation = "";
	    if("已上传".equals(newjti)) {
	    	operation = "上传照片";
	    }else if("未上传".equals(newjti)) {
	    	operation = "删除照片";
	    }else if("套餐包含".equals(newjti)) {
	    	operation = "套餐包含";
	    }
	    String time =  Common.formatDate(new Date(), "yyyy/MM/dd  HH:mm:ss");
	    String beizhu = "/（"+operation+"，操作人："+operater+" 操作时间："+time+")/";
	    for(int i=0;i<selectuuids.length;i++) {
	    	set.add("uuid", "@uuid", selectuuids[i]);
	    	set.add("beizhu", "@beizhu", beizhu);
	    	dao.execute("changePhotoUploadJtiByuuid", set);
	    }
	    commit();
	} catch (Exception e) {
	    e.printStackTrace();
	    rollback();
	}
	return Constant.SUCCESS;
    }
	
	
    private ParameterSet getParameterSetPhotoUpload(PhotoUploadForm form,String lifecycle) {
	String shijianleixing = form.getShijianleixing();
	ParameterSet set = new ParameterSet();
	if (!(form.getQuyuCode() == null) && !(form.getQuyuCode().trim().equals(""))) {
	    set.add("xiaoqu", "@xiaoqu", "%" + form.getQuyuCode() + "%");
	}
	if (!(form.getAddressCode() == null) && !(form.getAddressCode().trim().equals(""))) {
	    set.add("dizhi", "@dizhi", "%" + form.getAddressCode() + "%");
	}
	if (shijianleixing.equals("1")) {
	    set.add("kaijis", "@kaijis", form.getSen1());
	    set.add("kaijie", "@kaijie", form.getSen2());
	}
	if (shijianleixing.equals("2")) {
	    set.add("tingjis", "@tingjis", form.getSen1());
	    set.add("tingjie", "@tingjie", form.getSen2());
	}
	if (shijianleixing.equals("3")) {
	    set.add("shoukuanshijians", "@shoukuanshijians", form.getSen1());
	    set.add("shoukuanshijiane", "@shoukuanshijiane", form.getSen2());
	}
	set.add("yonghuzhuangtai", "@yonghuzhuangtai", form.getStateCode());
	set.add("Lifecycle_sta", "@Lifecycle_sta",lifecycle);
	return set;
    }
}
