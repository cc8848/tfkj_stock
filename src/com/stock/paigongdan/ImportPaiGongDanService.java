package com.stock.paigongdan; 

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import sun.security.krb5.internal.PAData;

import com.hrbank.business.common.CommonDao;
import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.Constant;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version 创建时间：2012-6-14 上午09:44:35 
 * 类说明 
 */
public class ImportPaiGongDanService extends BusinessService{
	
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private PGDValidator  validator = new PGDValidator();
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<EntityPGD> parse(InputStream input) throws Exception{
		List<EntityPGD> list = new ArrayList<EntityPGD>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		//Set<String> set = new HashSet<String>();
		int i = 4;//从excel第四行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			EntityPGD entityPGD = new EntityPGD();
				String[] values = service.convertRow(hssfRow, 12);//excel 读取的行数
				entityPGD.setXiaoquname(values[1]);//取excel表第二个数据为小区名称
				entityPGD.setUserplace(values[2]);
				entityPGD.setUsertel(values[3]);
				entityPGD.setKuandai(values[4]);
				entityPGD.setTV(values[5]);
				entityPGD.setTel(values[6]);
				entityPGD.setUseryaoqiu(values[7]);
				entityPGD.setONU(values[8]);
				entityPGD.setJidinghe(values[9]);
				entityPGD.setBeizhu(values[10]);
				
				entityPGD.setPaigongrenString(values[11]);
				
				entityPGD.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				entityPGD.setState("1");
				
			list.add(entityPGD);
			i++;
		}
		return list;
	}
	/**
	 * 插入派工单
	 * @param classid
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insert(String date,InputStream input) throws Exception{
		List<EntityPGD> list = new ArrayList<EntityPGD>();
		list = parse(input);
		if(null==list||list.size()==0){
			return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
		}
		//获取所有单位
		//List<String> bunlist = getBigUnitNameList();
		
		try {
			openTransaction();
			int i = 1;
			for(EntityPGD pgd : list){
			//空行校验
			String error = validator.insertValidate(pgd);
			if(error != null){
				return new CommonMessage(error,String.valueOf(i));
			}
			//单位校验
			//if(!bunlist.contains(student.getS_unit_type())){
			//	return new CommonMessage(ErrorConstant.IMPORT_STUDENT_NO_UNITTYPE,String.valueOf(i));
			//}
			
			ParameterModel model = new ParameterModel();
			model.put("xiaoquname", pgd.getXiaoquname());
			model.put("userplace",pgd.getUserplace());
			model.put("usertel",pgd.getUsertel());
			model.put("kuandai", pgd.getKuandai());
			model.put("tv", pgd.getTV());
			model.put("tel",pgd.getTel());
			model.put("useryaoqiu", pgd.getUseryaoqiu());
			model.put("onu", pgd.getONU());
			model.put("jidinghe",pgd.getJidinghe());
			model.put("beizhu", pgd.getBeizhu());
			model.put("state", pgd.getState());
			model.put("createdt",pgd.getCreatedt());
			
			model.put("paigongren", pgd.getPaigongrenString());
		
			model.put("paigongriqi", date);	//派工单日期
			
			dao.insert("paigongdan",model);
			i++;
			}
			commit();
		}
		catch (Exception e) {
			rollback();
			log.error(e);
			return new CommonMessage(ErrorConstant.PGD_DATA_ERROR);
		}
			return new CommonMessage(Constant.SUCCESS);
		}
}

