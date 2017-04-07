package com.checkState;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckThread implements  Runnable {

    private String type;
    public CheckThread(String type){
        this.type=type;
    }
    public void run() {
        while (true) {
            try {
                //���ʱ��Ϊ15����
                Thread.sleep(15 * 60 * 1000);
                boolean goodtime = checkTime();
                if ("1".equals(type)&&goodtime) {
                    CheckService.checkDianxinStop();
                }
                if ("2".equals(type)&&goodtime) {
                    CheckService.checkDianxinStart();
                }
                if ("3".equals(type)&&goodtime) {
                    CheckService.checkRediusStop();
                }
                if ("4".equals(type)&&goodtime) {
                    CheckService.checkRediusStart();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ͣ�����߳�ִ�д�����鿴ϵͳ");
                break;
            }
        }

    }

    /**
     * ���ʱ���Ƿ����������
     * @return
     */
    private boolean checkTime() {
        String flag = "";
        String timeStr = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String[] timeArray = timeStr.split(":");
        //����11�����е��ŵ��Զ�ͣ���ӿ�
        if (type.equals("1")&&"23".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 40 && Integer.parseInt(timeArray[1]) <= 55) {
                return true;
            }
        }
        //����12�����е��ŵ��Զ�����
        if (type.equals("2")&&"00".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 0 && Integer.parseInt(timeArray[1]) <= 15) {
                return true;
            }
        }
        //����10������redius���Զ�ͣ��
        if (type.equals("3")&&"10".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 0 && Integer.parseInt(timeArray[1]) <= 15) {
                return true;
            }
        }
//		����ʮ�������redius���Զ�����
        if (type.equals("4")&&"10".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) >30 && Integer.parseInt(timeArray[1]) <= 45) {
                return true;
            }
        }
        return false;
    }


}
