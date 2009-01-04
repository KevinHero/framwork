package com.flyong.ip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class GetIp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String host = "java.e800.com.cn";
		//String ip = getIpAddressByHost(host);
		//System.out.println(host + " : " + ip);

		
	}

	

	public static String getIpAddressByHost(String host) {
		String ip = "";
		InetAddress address;
		try {
			address = InetAddress.getByName(host);
			ip = address.getHostAddress();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;

	}

	public static String getLocalIP() {
		String localIp = "";
		try {
			localIp = InetAddress.getLocalHost().toString();
			System.out.println("local ip ---"
					+ InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return localIp;
	}

	
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;

	}
}