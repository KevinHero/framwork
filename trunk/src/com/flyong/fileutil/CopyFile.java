package com.flyong.fileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
	public static void main(String[] args) {
		String sourceFile = "C:/sitead/places/0010001010010.info";
		String destFile = "d:/copySitead/sitead/places/0010001010010.info";
		CopyFile.copyFile(sourceFile, destFile);
	}
	/**
	 * 具体执行文件拷贝操作
	 * @param fileFrom
	 * @param fileTo
	 * @param rewrite
	 * @return
	 */
	private static boolean copyFile(File fileFrom, File fileTo,
			boolean rewrite) {
		if (!fileFrom.exists()) {
			System.out.println("文件不存在");
			return false;
		}
		if (!fileFrom.isFile()) {
			System.out.println("不能够复制文件夹");
			return false;
		}
		if (!fileFrom.canRead()) {
			System.out.println("不能够读取需要复制的文件");
			return false;
		}
		if (!fileTo.getParentFile().exists()) {
			fileTo.getParentFile().mkdirs();
		}
		if (fileTo.exists() && rewrite) {
			fileTo.delete();
		}
		try {
			System.out.println("复制源文件路径："+fileFrom.getPath()+fileFrom.getName()+"\n"+"复制源文件名长度="+fileFrom.length());
			FileInputStream fisFrom = new FileInputStream(fileFrom);
			FileOutputStream fosTo = new FileOutputStream(fileTo);
			byte bt[] = new byte[(int)fileFrom.length()];
			int c;
			while ((c = fisFrom.read(bt)) > 0) {
				fosTo.write(bt, 0, c);
			}
			fisFrom.close();
			fosTo.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * 拷贝文件到另外目录下
	 * @param from 源文件
	 * @param to 目的文件
	 * @return
	 */
	public static boolean copyFile(String from, String to) {
		java.io.File filefrom = new java.io.File(from);
		java.io.File fileto = new java.io.File(to);
		return copyFile(filefrom, fileto, true);
	}
	/**
	 * 将filePath文件重新命名扩展名为processed
	 * @param filePath
	 */
	public static void rename(String filePath) {
		File file = new File(filePath); //指定文件名及路径   
		String filename = file.getAbsolutePath();
		if (filename.indexOf(".") >= 0) {
			filename = filename.substring(0, filename.lastIndexOf("."));
		}
		file.renameTo(new File(filename + ".processed")); //改名   
	}

}

