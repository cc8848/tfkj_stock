package com.webService.xmlStr;

public class NetSpeedValChangeUtil {

	public static String getTeleSpeedByTf(String tfspeed) {
		String teleSpeed  = "";
		if("512K".equals(tfspeed)||"512k".equals(tfspeed)) {
			teleSpeed = "0";
		}else if("1M".equals(tfspeed)||"512k".equals(tfspeed)) {
			teleSpeed = "1";
		}else if("2M".equals(tfspeed)||"2m".equals(tfspeed)) {
			teleSpeed = "2";
		}else if("4M".equals(tfspeed)||"4m".equals(tfspeed)) {
			teleSpeed = "4";
		}else if("10M".equals(tfspeed)||"10m".equals(tfspeed)) {
			teleSpeed = "12"; //天房10M和12M对应电信都为12M
		}else if("8M".equals(tfspeed)||"8m".equals(tfspeed)) {
			teleSpeed = "8";
		}else if("12M".equals(tfspeed)||"12m".equals(tfspeed)) {
			teleSpeed = "12"; //天房10M和12M对应电信都为12M
		}else if("20M".equals(tfspeed)||"20m".equals(tfspeed)) {
			teleSpeed = "13";
		}else if("50M".equals(tfspeed)||"50m".equals(tfspeed)) {
			teleSpeed = "50";
		}else if("100M".equals(tfspeed)||"100m".equals(tfspeed)) {
			teleSpeed = "100";
		}
		return teleSpeed;
	}
	
}
