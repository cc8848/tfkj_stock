package com.stock.userInfomation;

import java.io.InputStream;
import java.util.ArrayList;
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
import com.stock.paigongdan.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;

public class ImportUserService extends BusinessService {

	private Log log = LogFactory.getLog(this.getClass());
	
	private CommonDao dao = new CommonDao();
	private ImportService service = new ImportService();
	private UserValidator validator = new UserValidator();
	
	public List<UserInfomation> parse(InputStream input) throws Exception{
		List<UserInfomation> list = new ArrayList<UserInfomation>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int i = 1;
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			UserInfomation user = new UserInfomation();
				String[] values = service.convertRow(hssfRow, 27);
				user.setXiaoquname(values[0]);
				user.setYonghu(values[1]);
				user.setZhenjianno(values[2]);
				user.setShoujuno(values[3]);
				user.setFenguang(values[4]);
				user.setOnuzcwz(values[5]);
				user.setDizi(values[6]);
				user.setKaijishijian(values[7]);
				user.setTijishijian(values[8]);
				user.setDaikuan(values[9]);
				user.setTv(values[10]);
				user.setTel(values[11]);
				user.setUsername(values[12]);
				user.setPasswords(values[13]);
				user.setGuhuahaoma(values[14]);
				user.setUsertel(values[15]);
				user.setJiguiweizhi(values[16]);
				user.setOnumac(values[17]);
				user.setStbmac(values[18]);
				user.setTvip(values[19]);
				user.setNetip(values[20]);
				user.setTel(values[21]);
				user.setTelvaln(values[22]);
				user.setNetvaln(values[23]);
				user.setTvvaln(values[24]);
				user.setQtvaln(values[25]);
				user.setBeizhu(values[26]);
				
			list.add(user);
			i++;
		}
		return list;
	}
	
	public CommonMessage insert(InputStream input) throws Exception{
		List<UserInfomation> list = new ArrayList<UserInfomation>();
		list = parse(input);
		
		try {
			openTransaction();
			
			int i = 1;
			for(UserInfomation user : list){
				String error = validator.insertValidate(user);
				if(error != null){
					return new CommonMessage(error,String.valueOf(i+1));
				}
				
				ParameterModel model = new ParameterModel();
				model.put("xiaoquname", user.getXiaoquname());
				model.put("yonghu", user.getYonghu());
				model.put("zhenjianno", user.getZhenjianno());
				model.put("shoujuno", user.getShoujuno());
				//if(null!=user.getS_brithday()&&!"".equals(user.getS_brithday())){
				model.put("fenguang", user.getFenguang());
				//}
				model.put("onuzcwz", user.getOnuzcwz());
				model.put("dizi", user.getDizi());
				model.put("kaijishijian", user.getKaijishijian());
				model.put("tijishijian", user.getTijishijian());
				model.put("daikuan", user.getDaikuan());
				model.put("tv", user.getTv());
				model.put("tel", user.getTel());
				model.put("username", user.getUsername());
				model.put("passwords", user.getPasswords());
				model.put("guhuahaoma", user.getGuhuahaoma());
				model.put("usertel", user.getUsertel());
				model.put("jiguiweizhi", user.getJiguiweizhi());
				model.put("onumac", user.getOnumac());
				model.put("stbmac", user.getStbmac());
				model.put("tvip", user.getTvip());
				model.put("netip", user.getNetip());
				model.put("telip", user.getTelip());
				model.put("telvaln", user.getTelvaln());
				model.put("netvaln", user.getNetvaln());
				model.put("tvvaln", user.getTvvaln());
				model.put("qtvaln", user.getQtvaln());
				model.put("beizhu", user.getBeizhu());
				dao.insert("kehuziliao",model);
			i++;
			}
			
			
		
			commit();
		}
		catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.IMPORT_USER_DATA_ERROR);
		}
		return new CommonMessage(Constant.SUCCESS);
	}
	
	
	/**
	 * 根据UUID查询配工单详情
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataRow getUserinfoByUUID(String code) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("UUID", "@UUID", code);
		return dao.executeQueryToDataRow("GetUserinfoByUUID",set);
	}
	
	/**
	 * 更新
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public String update(UserInfoForm form) throws Exception {
		
		try {
			openTransaction();
			
			ParameterSet set = new ParameterSet();
			
			set.add("xiaoquname","@xiaoquname", form.getXiaoquname());
			set.add("yonghu","@yonghu", form.getYonghu());
			set.add("zhenjianno","@zhenjianno", form.getZhenjianno());
			set.add("shoujuno","@shoujuno", form.getShoujuno());
			set.add("fenguang","@fenguang", form.getFenguang());
			set.add("onuzcwz","@onuzcwz", form.getOnuzcwz());
			set.add("dizi","@dizi", form.getDizi());
			set.add("kaijishijian","@kaijishijian", form.getKaijishijian());
			set.add("tijishijian","@tijishijian", form.getTijishijian());
			set.add("daikuan","@daikuan", form.getDaikuan());
			set.add("tv","@tv", form.getTv());
			set.add("tel","@tel", form.getTel());
			set.add("username","@username", form.getUsername());
			set.add("passwords","@passwords", form.getPasswords());
			set.add("guhuahaoma","@guhuahaoma", form.getGuhuahaoma());
			set.add("usertel","@usertel", form.getUsertel());
			set.add("jiguiweizhi","@jiguiweizhi", form.getJiguiweizhi());
			set.add("onumac","@onumac", form.getOnumac());
			set.add("stbmac","@stbmac", form.getStbmac());
			set.add("tvip","@tvip", form.getTvip());
			set.add("netip","@netip", form.getNetip());
			set.add("telip","@telip", form.getTelip());
			set.add("telvaln","@telvaln", form.getTelvaln());
			set.add("netvaln","@netvaln", form.getNetvaln());
			set.add("tvvaln","@tvvaln", form.getTvvaln());
			set.add("qtvaln","@qtvaln", form.getQtvaln());
			set.add("beizhu","@beizhu", form.getBeizhu());
			set.add("UUID","@UUID", form.getUUID());
			
			dao.execute("updateUserInfoById",set);
			
			commit();
		} catch (Exception e) {
			rollback();
			log.error(e);
			throw e;
		}
		return Constant.SUCCESS;
	}
}