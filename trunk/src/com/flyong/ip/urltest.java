package com.flyong.ip;

import java.net.*;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

public class urltest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String ip=returnLocalHostInWWWIp();
		System.out.println("ip=="+ip);	
		
		
		String host = "java.e800.com.cn";
		String ipHost = getIpAddressByHost(host);
		System.out.println(host + " : " + ipHost);
		
		String localIp=getLocalIP();
		System.out.println("localIp "+localIp);
	}
	
	
	public static String returnLocalHostInWWWIp() throws Exception{
		DataInputStream is;
		// www.ip138.com www.whatismyip.com
		URL url = new URL("http://www.whatismyip.com");
		URLConnection connection = url.openConnection();

		is = new DataInputStream(connection.getInputStream());
		String inputline;
		String yourIP = new String();
		while ((inputline = is.readLine()) != null) {

			if (inputline.indexOf("Your IP Address Is") != -1) {
				int tail = inputline.indexOf("</h1>");		
				int head = inputline.indexOf("Your IP Address Is");
				String temp = inputline.substring(head, tail);
				temp = temp.replaceAll("span", "");
				temp = temp.replaceAll("<>", "");
				temp = temp.replaceAll("</>", "");
				temp = temp.substring(temp.indexOf("Is") + 2);
				temp=temp.trim();
				yourIP = temp;
			}		
		}	
		return yourIP;
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

}