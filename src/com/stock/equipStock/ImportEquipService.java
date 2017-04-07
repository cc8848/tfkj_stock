package com.stock.equipStock;

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
import com.stock.paigongdan.ImportService;
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.frame.sql.DataRow;
import com.takucin.aceeci.frame.sql.ParameterSet;
import com.takucin.aceeci.util.Common;

public class ImportEquipService extends BusinessService{
		
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private EquipValidator validator = new EquipValidator();
	
	/**
	 * 组装数据
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<EntityEquip> parse(InputStream input) throws Exception{
		List<EntityEquip> list = new ArrayList<EntityEquip>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		//Set<String> set = new HashSet<String>();
		int i = 1;//从excel第2行开始取数据
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			EntityEquip entityEquip = new EntityEquip();
			//for (int j = 1; j < 2; j++) {
				String[] values = service.convertRow(hssfRow, 6);//excel 读取的行数
				entityEquip.setType(values[0]);//第一行开始取数据
				entityEquip.setXianghao(values[1]);
				entityEquip.setRukuperson(values[2]);
				entityEquip.setXinghao(values[3]);
				entityEquip.setMac(values[4]);
				entityEquip.setKu(values[5]);
			list.add(entityEquip);
			i++;
		}
		return list;
	}
	
	public CommonMessage insert(InputStream input) throws Exception{
		List<EntityEquip> list = new ArrayList<EntityEquip>();
		list = parse(input);
		if(null==list||list.size()==0){
			return new CommonMessage(ErrorConstant.IMPORT_EQU_EXECL_SAMECARDID);
		}
		
		for (EntityEquip entityEquip : list) {
			DataRow data = getEquipByUUID(entityEquip.getMac());
			if(data!=null){
				return new CommonMessage(ErrorConstant.CHONGFUMAC,entityEquip.getMac());
			}
		}
		//DataRow datarow = 
		//获取所有单位
		//List<String> bunlist = getBigUnitNameList();
		
		try {
			openTransaction();
			int i = 1;
			for(EntityEquip equ : list){
			//空行校验
			String error = validator.insertValidate(equ);
			if(error != null){
				return new CommonMessage(error,String.valueOf(i));
			}
			//单位校验
			//if(!bunlist.contains(student.getS_unit_type())){
			//	return new CommonMessage(ErrorConstant.IMPORT_STUDENT_NO_UNITTYPE,String.valueOf(i));
			//}
			
			ParameterModel model = new ParameterModel();
			model.put("type", equ.getType());
			model.put("state", "1");
			model.put("xianghao", equ.getXianghao());
			model.put("rukuperson",equ.getRukuperson());
			model.put("mac",equ.getMac() );
			model.put("chukuplace",equ.getKu() );
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));	
			model.put("xinghao", equ.getXinghao());
			model.put("rukudate", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			dao.insert("equipmentstock",model);
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

	//查学员by身份证号
	public DataRow getEquipByUUID(String mac) throws Exception{
		ParameterSet set = new ParameterSet();
		set.add("mac", "@mac",mac);
		return dao.executeQueryToDataRow("GetEquipByMac", set);
	}
}
