package com.flyong.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIps {
	public static int isInnerIP(long a_ip)//���ip��ַ�Ƿ�������ip
	{
		int bValid = -1;
		if ((a_ip >> 24 == 0xa) || (a_ip >> 16 == 0xc0a8)
				|| (a_ip >> 22 == 0x2b0)) {
			bValid = 0;
		}
		return bValid;
	}

	// ��127.0.0.1 ��ʽ��IP��ַת����10������������û�н����κδ�����
	public static long ipToLong(String strIP) {
		long[] ip = new long[4];
		//���ҵ�IP��ַ�ַ���.��λ��
		int position1 = strIP.indexOf(".");
		int position2 = strIP.indexOf(".", position1 + 1);
		int position3 = strIP.indexOf(".", position2 + 1);
		//��ÿ��.֮����ַ�ת��������
		ip[0] = Long.parseLong(strIP.substring(0, position1));
		ip[1] = Long.parseLong(strIP.substring(position1 + 1, position2));
		ip[2] = Long.parseLong(strIP.substring(position2 + 1, position3));
		ip[3] = Long.parseLong(strIP.substring(position3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	public static void main(String[] args) {
		String ip;
		try {
			InetAddress in = InetAddress.getLocalHost();
			InetAddress[] all = InetAddress.getAllByName(in.getHostName());
			//ͨ�������������ip   
			for (int i = 0; i < all.length; i++) {
				String tmp = null;
				tmp = ip = all[i].getHostAddress().toString();
				System.out.println("IP =  " + tmp);//����������е�ip��ַ
				if (isInnerIP(ipToLong(tmp)) == -1)//����ǲ�������ip������Ǿͱ����ļ�
				{
					/*WriteFile(ip);//��ip��ַд���ļ�
					System.out.println("IP������ͬĿ¼IP.txt�ļ���");

					System.out.println("ͬĿ¼IP.txt�ļ��е�IP�ǣ�" + ReadFile());*/
					System.out.println(ip);

				}
			}
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
	}

}
