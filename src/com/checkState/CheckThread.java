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
                //间隔时间为15分钟
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
                System.out.println("停复机线程执行错误，请查看系统");
                break;
            }
        }

    }

    /**
     * 检查时间是否与类型相符
     * @return
     */
    private boolean checkTime() {
        String flag = "";
        String timeStr = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String[] timeArray = timeStr.split(":");
        //晚上11点运行电信的自动停机接口
        if (type.equals("1")&&"23".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 40 && Integer.parseInt(timeArray[1]) <= 55) {
                return true;
            }
        }
        //晚上12点运行电信的自动复机
        if (type.equals("2")&&"00".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 0 && Integer.parseInt(timeArray[1]) <= 15) {
                return true;
            }
        }
        //早上10点运行redius的自动停机
        if (type.equals("3")&&"10".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) > 0 && Integer.parseInt(timeArray[1]) <= 15) {
                return true;
            }
        }
//		早上十点半运行redius的自动复机
        if (type.equals("4")&&"10".equals(timeArray[0])) {
            if (Integer.parseInt(timeArray[1]) >30 && Integer.parseInt(timeArray[1]) <= 45) {
                return true;
            }
        }
        return false;
    }


}
