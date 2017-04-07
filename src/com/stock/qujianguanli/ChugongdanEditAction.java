package com.stock.qujianguanli;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.hrbank.business.common.CommonMessage;
import com.hrbank.business.common.ErrorConstant;
import com.hrbank.business.frame.BusinessAction;
import com.stock.paigongdan.PaiGongDanEntiyForm;
import com.takucin.aceeci.frame.sql.DataRow;

public class ChugongdanEditAction extends BusinessAction{
	TongjiService service = new TongjiService();
	
	/**
	 * 跳转到结单页面
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initEdit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		DataRow dataPGD = service.getPGDByUUID(f.getUUID());
		
		CommonMessage message = xiugaicheck(dataPGD.getDataElement("state").getString());
		if(saveMessage(message, request)){
			return mapping.findForward(FW_SUCCESS);
		}else{
			
		f.setUUID(dataPGD.getDataElement("PK_ID").getString());
		
		f.setXiaoquname(dataPGD.getDataElement("xiaoquname").getString());
		f.setXingming(dataPGD.getDataElement("username").getString());
		f.setZhengjianhao("");
		f.setShoujuhao("");
		f.setFenguangqihao(dataPGD.getDataElement("fenguang").getString());
		f.setOnuzhuce("");
		f.setFanghao(dataPGD.getDataElement("userplace").getString());
		f.setKaijishijian("");
		f.setTingjishijian("");
		f.setKandai(dataPGD.getDataElement("tfkuandaidaikuan").getString());
		f.setDianshi(dataPGD.getDataElement("tfiptv").getString());
		f.setDianhua("");
		f.setYonghuming("");
		f.setMima("");
		f.setGuhua(dataPGD.getDataElement("telhaoma1").getString());
		f.setLainxidianhua(dataPGD.getDataElement("usertel").getString());
		f.setJiguiweizhi("");
		f.setOnumac(dataPGD.getDataElement("OUMMAC").getString());
		f.setJidinghemac(dataPGD.getDataElement("STBMAC").getString());
		f.setDianshiip("");
		f.setDianshiip2("");
		f.setDianshiip3("");
		f.setDianshiip4("");
		
		f.setDianhuaip(dataPGD.getDataElement("telip").getString());
		f.setKuandaiip(dataPGD.getDataElement("netip").getString());
		f.setDianhuavlan(dataPGD.getDataElement("telvaln").getString());
		f.setWangluovlan(dataPGD.getDataElement("netvaln").getString());
		f.setDianshivlan("");
		f.setQitivlan("");
		f.setBeizhu(dataPGD.getDataElement("beizhu").getString());
		}
		return mapping.findForward(FW_INIT_EDIT);
	}
	
	/**
	 * 派工单插入
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String result = service.insert((ChugongdanEditForm)form);
		if(saveMessage(result,request)){
			return mapping.findForward(FW_ERROR_INSERT);
		}
		return mapping.findForward(FW_SUCCESS);
		
	}
	
	/**
	 * 结单校验
	 * @param UUID
	 * @return
	 * @throws Exception
	 */
	public CommonMessage xiugaicheck(String state)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		//DataRow data =  service.getPGDByUUID(UUID);
	//	String state = data.getDataElement("state").getString();
		if(!state.equals("5")){
			return new CommonMessage(ErrorConstant.HUIDAN_PGD_STATE);
		}else{
			return new CommonMessage("SUCCESS");
		}
	}
	
	
	public Boolean checkShuju(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("1")){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean checkshigong(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("9")){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean checkgongbi(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("10")){
			return true;
		}else{
			return false;
		}
	}
	public Boolean checkjiedan(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("11")){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean checkshangchuan(String UUID)throws Exception{
		//DataRow daterow = service.getEquipByUUID(UUID);
		DataRow data =  service.getPGDByUUID(UUID);
		String state = data.getDataElement("state").getString();
		if(state.equals("12")){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 状态操作
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward operate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String type = request.getParameter("type");
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String[] uuids =  f.getUUIDS();
		if(type.equals("1")){
			for (String uuid : uuids) {
				if(!checkShuju(uuid)){
					if(saveMessage(ErrorConstant.QUJIANSTATE_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operateShuJu(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("2")){
			for (String uuid : uuids) {
				if(!checkshigong(uuid)){
					if(saveMessage(ErrorConstant.SHOUJIANSTATE_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
				
			}
			
			String result = service.operateshigong(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("3")){
			for (String uuid : uuids) {
				if(!checkgongbi(uuid)){
					if(saveMessage(ErrorConstant.SHUJUSHANGCHUANSTATE_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operategongbi(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("4")){
			for (String uuid : uuids) {
				if(!checkjiedan(uuid)){
					if(saveMessage(ErrorConstant.DIANXINXIADAN_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operatejiedan(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		else if(type.equals("5")){
			for (String uuid : uuids) {
				if(!checkshangchuan(uuid)){
					if(saveMessage(ErrorConstant.KEFUSHUJUSTATE_ERRORY,request)){
						return mapping.findForward(FW_SUCCESS);
					}
				}
			}
			
			String result = service.operateshangchuan(uuids);
			if(saveMessage(result,request)){
				return mapping.findForward(FW_SUCCESS);
			}
		}
		return mapping.findForward(FW_SUCCESS);
	}
	
	/**
	 * 退单
	 * @return
	 * @throws Exception
	 */
	public ActionForward tuidan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ChugongdanEditForm f = (ChugongdanEditForm) form;
		String result = service.tuidan(f.getUUIDS());
		if(saveMessage(result,request)){
			return mapping.findForward(FW_SUCCESS);
		}
		return mapping.findForward(FW_SUCCESS);
	}
}
