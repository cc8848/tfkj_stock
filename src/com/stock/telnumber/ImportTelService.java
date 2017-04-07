package com.stock.telnumber; 

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
import com.takucin.aceeci.frame.model.ParameterModel;
import com.takucin.aceeci.util.Common;

/** 
 * @author wangdl 
 * @version ����ʱ�䣺2012-6-14 ����09:44:35 
 * ��˵�� 
 */
public class ImportTelService extends BusinessService{
	
	private Log log = LogFactory.getLog(this.getClass());
	private ImportService service = new ImportService();
	private CommonDao dao = new CommonDao();
	private TelValidator  validator = new TelValidator();
	
	/**
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public List<EntityTel> parse(InputStream input) throws Exception{
		List<EntityTel> list = new ArrayList<EntityTel>();
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int i = 1;//��excel�����п�ʼȡ����
		while (true) {
			HSSFRow hssfRow = sheet.getRow(i);
			if (hssfRow == null) {
				break;
			}
			EntityTel entityTel = new EntityTel();
				String[] values = service.convertRow(hssfRow, 6);//excel ��ȡ������
				//entityPGD.setXiaoquname(values[1]);//ȡexcel��ڶ�������ΪС������
				entityTel.setQuyu(values[0]);
				entityTel.setTelNo(values[1]);
				entityTel.setXiaoqu(values[2]);
				entityTel.setDizhi(values[3]);
				entityTel.setBeizhu(values[4]);
				entityTel.setState(values[5]);
			//	entityPGD.setCreatedt(Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
				
			list.add(entityTel);
			i++;
		}
		return list;
	}
	/**
	 * �����ɹ���
	 * @param classid
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public CommonMessage insert(InputStream input) throws Exception{
		List<EntityTel> list = new ArrayList<EntityTel>();
		list = parse(input);
		if(null==list||list.size()==0){
			return new CommonMessage(ErrorConstant.IMPORT_PGD_EXECL_SAMECARDID);
		}
		
		try {
			openTransaction();
			int i = 1;
			for(EntityTel pgd : list){
			//����У��
			String error = validator.insertValidate(pgd);
			if(error != null){
				return new CommonMessage(error,String.valueOf(i));
			}
			
			ParameterModel model = new ParameterModel();
			//model.put("xiaoquname", pgd.getXiaoquname());
			model.put("quyu", pgd.getQuyu());
			model.put("telno", pgd.getTelNo());
			model.put("xiaoqu", pgd.getXiaoqu());
			model.put("dizhi", pgd.getDizhi());
			model.put("beizhu", pgd.getBeizhu());
			model.put("state", pgd.getState());
			
			model.put("createdt", Common.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			model.put("createby", getUserInfo().getEmployeeName());
			
			dao.insert("telnumber",model);
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

