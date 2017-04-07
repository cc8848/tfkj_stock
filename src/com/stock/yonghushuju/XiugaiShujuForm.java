/*
 * TianFang science corporation (c)2012 all rights reserved.
 * Description: XiugaiShujuFrom get/set xiugaishuju info.
 * Update:
 * Date         Name                  Reason
 * ============ ===================== ==========
 * 2012-11-23   Li.Hai-Han(**)        Create
 */
package com.stock.yonghushuju;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.takucin.aceeci.common.CommonModule;

/**
 * get/set xiugaishuju info.
 * 
 * @author Li.Hai-Han(**)
 */
@SuppressWarnings("serial")
public class XiugaiShujuForm  extends ActionForm {
	
	private List<CommonModule> xiaoquList = new ArrayList<CommonModule>();
	private List<CommonModule> ztList = new ArrayList<CommonModule>();

	public void setHidden() {
		this.xx_dizhiHidden = this.xx_dizhi;
		this.xx_xiaoquHidden = this.xx_xiaoqu;
		this.xiugaidatesHidden = this.xiugaidates;
		this.yh_zhuangtaiHidden = this.yh_zhuangtai;
	}

	//�û�״̬
	private String yh_zhuangtai;
	private String yh_zhuangtaiHidden;
	
	//�û�����
	private String yh_name;
	
	//�û����֤��
	private String yh_shenfenzhengNum;
	
	//�û��վݺ�
	private String yh_shoujuhao;
	
	//�ֹ��ߺ�
	private String yh_fenguangxianNum;
	
	//����λ��
	private String yh_xujieweizhi;
	
	//�û�����ʱ��
	private String yh_kaijiDate ;
	
	//�û�ͣ��ʱ��
	private String yh_tingjiDate ;
	
	//�û���Чʱ��
	private String yh_youxiaoDate ;
	
	//С����Ϣ
	private String xx_xiaoqu ;
	private String xx_xiaoquHidden = "" ;
	
	//��ַ��Ϣ
	private String xx_dizhi ;
	private String xx_dizhiHidden ="";
	
	//�绰��
	private String xx_dianhuaNum ;
	
	//�������
	private String xx_wangluo ;
	
	//������Ϣ
	private String xx_dianshi;
	
	//�绰��Ϣ
	private String xx_dianhua ;
	
	//ҵ����Ϣ
	private String xx_yewu ;
	
	//�ֹ�
	private String fw_fenguang ;
	
	//onumac
	private String fw_onu_mac;
	
	//STB MCID
	private String fw_stb_mcid ;
	
	//����IP
	private String fw_dianshi_ip ;

	//����IP
	private String fw_wangluo_ip ;
	
	//�绰IP
	private String fw_dianhua_ip ;
	
	//�绰VLAN
	private String fw_dianhua_vlan ;
	
	//����VLAN
	private String fw_wangluo_vlan ;
	
	//����ʱ��
	private String fw_shangmen_date ;
	
	//��֤
	private String fw_danzheng ;
	
	//��ѡ�绰����
	private String fw_chose_dianhuaNum ;
	
	//onuѺ��
	private String fy_onu;
	
	//������Ѻ��
	private String fy_jidinghe;
	
	//���ӷ�
	private String fy_shoushi ;
	
	//�����
	private String fy_kuandai ;
	
	//��װ��
	private String fy_chuzhuang ;
	
	//��Ӫ��
	private String fy_yunyingshang ;
	
	//�����¹���
	private String fy_buzuyuegou ;
	
	//���
	private String fy_nianfei ;
	
	//���ñ�ע
	private String fy_beizhu ;
	
	//���շ�
	private String qt_zongshoufei ;
	
	//�վݺ�
	private String qt_shoujuNum ;
	
	//�����豸ʹ�����
	private String qt_shebeishiyong ;
	
	//�����Ĳ�
	private String qt_haocai ;
	
	//������
	private String qt_jiexianzi ;
	
	//rj11
	private String qt_rj11 ;
	
	//rj45
	private String qt_rj45 ;
	
	//ģ��
	private String qt_mokuai ;
	
	//���
	private String qt_mianban ;
	
	//����
	private String qt_wangxian ;
	
	//ʩ����
	private String qt_shigongren ;
	
	//�ֳ���ע
	private String qt_xianchangbeizhu ;
	
	//��ע����
	private String beizhuhuizong ;
	
	//�޸���
	private String xiugai_ren ;
	
	//�޸�ʱ��
	private String xiugai_date ;
	private String xiugaidates ;
	private String xiugaidatesHidden = "";
	public String getYh_zhuangtai() {
		return yh_zhuangtai;
	}

	public void setYh_zhuangtai(String yh_zhuangtai) {
		this.yh_zhuangtai = yh_zhuangtai;
	}

	public String getYh_name() {
		return yh_name;
	}

	public void setYh_name(String yh_name) {
		this.yh_name = yh_name;
	}

	public String getYh_shenfenzhengNum() {
		return yh_shenfenzhengNum;
	}

	public void setYh_shenfenzhengNum(String yh_shenfenzhengNum) {
		this.yh_shenfenzhengNum = yh_shenfenzhengNum;
	}

	public String getYh_shoujuhao() {
		return yh_shoujuhao;
	}

	public void setYh_shoujuhao(String yh_shoujuhao) {
		this.yh_shoujuhao = yh_shoujuhao;
	}

	public String getYh_fenguangxianNum() {
		return yh_fenguangxianNum;
	}

	public void setYh_fenguangxianNum(String yh_fenguangxianNum) {
		this.yh_fenguangxianNum = yh_fenguangxianNum;
	}

	public String getYh_xujieweizhi() {
		return yh_xujieweizhi;
	}

	public void setYh_xujieweizhi(String yh_xujieweizhi) {
		this.yh_xujieweizhi = yh_xujieweizhi;
	}

	public String getYh_kaijiDate() {
		return yh_kaijiDate;
	}

	public void setYh_kaijiDate(String yh_kaijiDate) {
		this.yh_kaijiDate = yh_kaijiDate;
	}

	public String getYh_tingjiDate() {
		return yh_tingjiDate;
	}

	public void setYh_tingjiDate(String yh_tingjiDate) {
		this.yh_tingjiDate = yh_tingjiDate;
	}

	public String getXx_xiaoqu() {
		return xx_xiaoqu;
	}

	public void setXx_xiaoqu(String xx_xiaoqu) {
		this.xx_xiaoqu = xx_xiaoqu;
	}

	public String getXx_dizhi() {
		return xx_dizhi;
	}

	public void setXx_dizhi(String xx_dizhi) {
		this.xx_dizhi = xx_dizhi;
	}

	public String getXx_dianhuaNum() {
		return xx_dianhuaNum;
	}

	public void setXx_dianhuaNum(String xx_dianhuaNum) {
		this.xx_dianhuaNum = xx_dianhuaNum;
	}

	public String getXx_wangluo() {
		return xx_wangluo;
	}

	public void setXx_wangluo(String xx_wangluo) {
		this.xx_wangluo = xx_wangluo;
	}

	public String getXx_dianshi() {
		return xx_dianshi;
	}

	public void setXx_dianshi(String xx_dianshi) {
		this.xx_dianshi = xx_dianshi;
	}

	public String getXx_dianhua() {
		return xx_dianhua;
	}

	public void setXx_dianhua(String xx_dianhua) {
		this.xx_dianhua = xx_dianhua;
	}

	public String getXx_yewu() {
		return xx_yewu;
	}

	public void setXx_yewu(String xx_yewu) {
		this.xx_yewu = xx_yewu;
	}

	public String getFw_fenguang() {
		return fw_fenguang;
	}

	public void setFw_fenguang(String fw_fenguang) {
		this.fw_fenguang = fw_fenguang;
	}

	public String getFw_onu_mac() {
		return fw_onu_mac;
	}

	public void setFw_onu_mac(String fw_onu_mac) {
		this.fw_onu_mac = fw_onu_mac;
	}

	public String getFw_stb_mcid() {
		return fw_stb_mcid;
	}

	public void setFw_stb_mcid(String fw_stb_mcid) {
		this.fw_stb_mcid = fw_stb_mcid;
	}

	public String getFw_dianshi_ip() {
		return fw_dianshi_ip;
	}

	public void setFw_dianshi_ip(String fw_dianshi_ip) {
		this.fw_dianshi_ip = fw_dianshi_ip;
	}

	public String getFw_dianhua_ip() {
		return fw_dianhua_ip;
	}

	public void setFw_dianhua_ip(String fw_dianhua_ip) {
		this.fw_dianhua_ip = fw_dianhua_ip;
	}

	public String getFw_dianhua_vlan() {
		return fw_dianhua_vlan;
	}

	public void setFw_dianhua_vlan(String fw_dianhua_vlan) {
		this.fw_dianhua_vlan = fw_dianhua_vlan;
	}

	public String getFw_wangluo_vlan() {
		return fw_wangluo_vlan;
	}

	public void setFw_wangluo_vlan(String fw_wangluo_vlan) {
		this.fw_wangluo_vlan = fw_wangluo_vlan;
	}

	public String getFw_shangmen_date() {
		return fw_shangmen_date;
	}

	public void setFw_shangmen_date(String fw_shangmen_date) {
		this.fw_shangmen_date = fw_shangmen_date;
	}

	public String getFw_danzheng() {
		return fw_danzheng;
	}

	public void setFw_danzheng(String fw_danzheng) {
		this.fw_danzheng = fw_danzheng;
	}

	public String getFw_chose_dianhuaNum() {
		return fw_chose_dianhuaNum;
	}

	public void setFw_chose_dianhuaNum(String fw_chose_dianhuaNum) {
		this.fw_chose_dianhuaNum = fw_chose_dianhuaNum;
	}

	public String getFy_onu() {
		return fy_onu;
	}

	public void setFy_onu(String fy_onu) {
		this.fy_onu = fy_onu;
	}

	public String getFy_jidinghe() {
		return fy_jidinghe;
	}

	public void setFy_jidinghe(String fy_jidinghe) {
		this.fy_jidinghe = fy_jidinghe;
	}

	public String getFy_shoushi() {
		return fy_shoushi;
	}

	public void setFy_shoushi(String fy_shoushi) {
		this.fy_shoushi = fy_shoushi;
	}

	public String getFy_kuandai() {
		return fy_kuandai;
	}

	public void setFy_kuandai(String fy_kuandai) {
		this.fy_kuandai = fy_kuandai;
	}

	public String getFy_chuzhuang() {
		return fy_chuzhuang;
	}

	public void setFy_chuzhuang(String fy_chuzhuang) {
		this.fy_chuzhuang = fy_chuzhuang;
	}

	public String getFy_yunyingshang() {
		return fy_yunyingshang;
	}

	public void setFy_yunyingshang(String fy_yunyingshang) {
		this.fy_yunyingshang = fy_yunyingshang;
	}

	public String getFy_buzuyuegou() {
		return fy_buzuyuegou;
	}

	public void setFy_buzuyuegou(String fy_buzuyuegou) {
		this.fy_buzuyuegou = fy_buzuyuegou;
	}

	public String getFy_nianfei() {
		return fy_nianfei;
	}

	public void setFy_nianfei(String fy_nianfei) {
		this.fy_nianfei = fy_nianfei;
	}

	public String getFy_beizhu() {
		return fy_beizhu;
	}

	public void setFy_beizhu(String fy_beizhu) {
		this.fy_beizhu = fy_beizhu;
	}

	public String getQt_zongshoufei() {
		return qt_zongshoufei;
	}

	public void setQt_zongshoufei(String qt_zongshoufei) {
		this.qt_zongshoufei = qt_zongshoufei;
	}

	public String getQt_shoujuNum() {
		return qt_shoujuNum;
	}

	public void setQt_shoujuNum(String qt_shoujuNum) {
		this.qt_shoujuNum = qt_shoujuNum;
	}

	public String getQt_shebeishiyong() {
		return qt_shebeishiyong;
	}

	public void setQt_shebeishiyong(String qt_shebeishiyong) {
		this.qt_shebeishiyong = qt_shebeishiyong;
	}

	public String getQt_haocai() {
		return qt_haocai;
	}

	public void setQt_haocai(String qt_haocai) {
		this.qt_haocai = qt_haocai;
	}

	public String getQt_jiexianzi() {
		return qt_jiexianzi;
	}

	public void setQt_jiexianzi(String qt_jiexianzi) {
		this.qt_jiexianzi = qt_jiexianzi;
	}

	public String getQt_rj11() {
		return qt_rj11;
	}

	public void setQt_rj11(String qt_rj11) {
		this.qt_rj11 = qt_rj11;
	}

	public String getQt_rj45() {
		return qt_rj45;
	}

	public void setQt_rj45(String qt_rj45) {
		this.qt_rj45 = qt_rj45;
	}

	public String getQt_mokuai() {
		return qt_mokuai;
	}

	public void setQt_mokuai(String qt_mokuai) {
		this.qt_mokuai = qt_mokuai;
	}

	public String getQt_mianban() {
		return qt_mianban;
	}

	public void setQt_mianban(String qt_mianban) {
		this.qt_mianban = qt_mianban;
	}

	public String getQt_wangxian() {
		return qt_wangxian;
	}

	public void setQt_wangxian(String qt_wangxian) {
		this.qt_wangxian = qt_wangxian;
	}

	public String getQt_shigongren() {
		return qt_shigongren;
	}

	public void setQt_shigongren(String qt_shigongren) {
		this.qt_shigongren = qt_shigongren;
	}

	public String getQt_xianchangbeizhu() {
		return qt_xianchangbeizhu;
	}

	public void setQt_xianchangbeizhu(String qt_xianchangbeizhu) {
		this.qt_xianchangbeizhu = qt_xianchangbeizhu;
	}

	public String getBeizhuhuizong() {
		return beizhuhuizong;
	}

	public void setBeizhuhuizong(String beizhuhuizong) {
		this.beizhuhuizong = beizhuhuizong;
	}

	public String getXiugai_ren() {
		return xiugai_ren;
	}

	public void setXiugai_ren(String xiugai_ren) {
		this.xiugai_ren = xiugai_ren;
	}

	public String getXiugai_date() {
		return xiugai_date;
	}

	public void setXiugai_date(String xiugai_date) {
		this.xiugai_date = xiugai_date;
	}

	public List<CommonModule> getXiaoquList() {
		return xiaoquList;
	}

	public void setXiaoquList(List<CommonModule> xiaoquList) {
		this.xiaoquList = xiaoquList;
	}



	public String getXx_xiaoquHidden() {
		return xx_xiaoquHidden;
	}

	public void setXx_xiaoquHidden(String xx_xiaoquHidden) {
		this.xx_xiaoquHidden = xx_xiaoquHidden;
	}

	public String getXx_dizhiHidden() {
		return xx_dizhiHidden;
	}

	public void setXx_dizhiHidden(String xx_dizhiHidden) {
		this.xx_dizhiHidden = xx_dizhiHidden;
	}

	public String getFw_wangluo_ip() {
		return fw_wangluo_ip;
	}

	public void setFw_wangluo_ip(String fw_wangluo_ip) {
		this.fw_wangluo_ip = fw_wangluo_ip;
	}

	public String getXiugaidates() {
		return xiugaidates;
	}

	public void setXiugaidates(String xiugaidates) {
		this.xiugaidates = xiugaidates;
	}

	public String getXiugaidatesHidden() {
		return xiugaidatesHidden;
	}

	public void setXiugaidatesHidden(String xiugaidatesHidden) {
		this.xiugaidatesHidden = xiugaidatesHidden;
	}



	public List<CommonModule> getZtList() {
		return ztList;
	}

	public void setZtList(List<CommonModule> ztList) {
		this.ztList = ztList;
	}

	public String getYh_zhuangtaiHidden() {
		return yh_zhuangtaiHidden;
	}

	public void setYh_zhuangtaiHidden(String yh_zhuangtaiHidden) {
		this.yh_zhuangtaiHidden = yh_zhuangtaiHidden;
	}

	public String getYh_youxiaoDate() {
		return yh_youxiaoDate;
	}

	public void setYh_youxiaoDate(String yh_youxiaoDate) {
		this.yh_youxiaoDate = yh_youxiaoDate;
	}
	
}
