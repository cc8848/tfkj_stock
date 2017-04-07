package com.webService.webServiceTools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hub.chinatelecom.DEPService;

public class WSTools {

    /**
     * ����XML���ģ�����ȡ���
     * 
     * @param xmlString
     * @return
     */
    public static String SyncMess(String xmlString) throws Exception {
	DEPService dep = new DEPService();
	Map<String, String> resutlMap = analyzeRsultXML(dep.getDEPServiceHttpPort().exchange(xmlString));
	return resutlMap.get("backMess");
    }
    public static Map<String, String> SyncMessGetMap(String xmlString) throws Exception {
   	DEPService dep = new DEPService();
   	Map<String, String> resutlMap = analyzeRsultXML(dep.getDEPServiceHttpPort().exchange(xmlString));
   	return resutlMap;
      }

    /**
     * �������ؽ��
     * @param resultXml
     * @return
     * @throws Exception
     */
    public static Map<String, String> analyzeRsultXML(String resultXml) throws Exception {
	Map<String, String> resutlMap = new HashMap<String, String>();
	Document doc = null;
	doc = DocumentHelper.parseText(resultXml);
	Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�
	Iterator iter = rootElt.elementIterator("TcpCont");
	// ����head�ڵ�
	while (iter.hasNext()) {
	    Element recordEle = (Element) iter.next();
	    Iterator iter1 = recordEle.elementIterator("Response");
	    while (iter1.hasNext()) {
		Element backEle = (Element) iter1.next();
		resutlMap.put("backMess", backEle.elementText("RspType"));
		resutlMap.put("RspCode", backEle.elementText("RspCode"));
		resutlMap.put("RspDesc", backEle.elementText("RspDesc"));
	    }
	}
	return resutlMap;
    }

}
