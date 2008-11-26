package com.flyong.fileutil;

import java.io.*;


/*实现向指定文件读写string类型的内容*/

public class TextFile extends File {
	public TextFile(File filename) {
		super(filename.toString());
	}

	public TextFile(String filename) {
		super(filename);
	}

	public String getText() {
		String lineEnd = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(this));
			String line = "NOTNULL";
			while (line != null) {
				line = br.readLine();
				if (line != null)
					sb.append(line + lineEnd);
			}
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return sb.toString();
	}

	/**参数意义：body写入文件的实际内容，fileName 文件路径*/
	public static void setText(String body,String fileName) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(body);
			bw.flush();
			bw.close();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//写入文件路径及文件名
		
		String writeFilePath="c:/sitead/advts/0010001009009/200809150809111245039777/a.msg";
		FileUtil.createFile(writeFilePath,true);
			
			
		//写入文件内容
		String writeContent="sitead/advts/0010001009009/200809150809111245039777yyyyyyyy sjidsaoidf";
	
		TextFile tf=new TextFile(writeFilePath);
		setText(writeContent,writeFilePath);
		
	
		

	}
}
