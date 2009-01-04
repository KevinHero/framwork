package com.flyong.util.fileutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

	// file delete
	/**
	 * 删除指定目录(允许非空)或者文件
	 */
	public void deleteDirFile(String sDirFilePath) throws IOException {
		if (sDirFilePath != null && !sDirFilePath.trim().equals("")) {
			File tDirFile = new File(sDirFilePath);
			if (tDirFile.exists()) {
				if (tDirFile.isDirectory()) {
					File[] arrFiles = tDirFile.listFiles();
					// 循环删除目录下的子目录
					for (int i = 0; i < arrFiles.length; i++) {
						deleteDirFile(arrFiles[i].getAbsolutePath());
					}
					arrFiles = null;
					// 当目录下的所有删除后, 再把本目录删除
					tDirFile.delete();
				} else {
					tDirFile.delete();
				}
			}
			tDirFile = null;
		}

	}

	/** 修改文件名 */
	public static void modifyFileName(String srcFileName, String changedFileName) {
		File f = new File(srcFileName);
		File f2 = new File(changedFileName);
		f.renameTo(f2);
	}

	/** 创建广告文件夹 zhangyong 08/08/09 */
	public static void creatAdFile(String filePath) {
		File f = null;
		f = new File(filePath);
		if (!(f.exists()) && !(f.isDirectory())) {
			p("creatAdFile()", "文件夹不存在");
			boolean creadok = f.mkdirs();
			if (creadok) {
				p("creatAdFile()", "文件夹创建成功");
			} else {
				p("creatAdFile()", "文件夹创建失败");
			}
		} else {
			p("creatAdFile()", "文件夹存在");
		}
	}

	public static void p(String methodname, Object o) {
		boolean flag = true;
		if (flag) {
			System.out.println("com.fm1039.web.actions.AdvertismentAction "
					+ methodname + "‘msg : " + o);
		} else {
			;
		}
	}

	

	

	/** 创建文件或目录true:创建一个文件，flase创建一个目录 */
	public static void createFile(String path, boolean isFile) {
		createFile(new File(path), isFile);
	}

	public static void createFile(File file, boolean isFile) {
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				createFile(file.getParentFile(), false);
			} else {
				if (isFile) {
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					file.mkdir();
				}
			}
		}
	}

	
	public static String handNoThree(int adNo) {
		String result = null;
		String ads_order = String.valueOf(adNo);
		if (ads_order.length() < 3) {
			String head = "000".substring(ads_order.length());
			result = head + ads_order;
		} else {
			result = ads_order;
		}
		return result;
	}

	/** must use
	 * 复制目录到指定目录。targetDir是目标目录，path是源目录。
	 * 该方法会将path以及path下的文件和子目录全部复制到目标目录
	 * 如果首次复制目录：目标目录不存在，会自动创建；
	 * 如果第二次复制目录，相同文件名的文件不替换 注意！！！！！！！！
	 * 
	 * 
	 * @param targetDir：要把目录复制到什么地方，目标文件地址
	 * @param path:要复制目录文件的地址
	 */
	public static void copyDir(String targetDir, String path) {
		File targetFile = new File(targetDir);
		createFile(targetFile, false);
		File file = new File(path);
		if (targetFile.isDirectory() && file.isDirectory()) {
			copyFileToDir(targetFile.getAbsolutePath() + "/" + file.getName(),
					listFile(file));
		}
	}
	
	
	
	/** 返回某文件夹下的文件数目 */
	public static int getDirectoryFileNumber(String filePath) {
		// 查询路径
		File f = new File(filePath);
		// 存放所有查询结果
		File[] strList;

		int num = 0;
		strList = f.listFiles();
		for (int i = 0; i < strList.length; i++) {
			if (strList[i].isDirectory()) {
				// 判断是否是目录
				System.out.println("是目录");
			} else {
				//处理系统隐藏文件Thumbs.db的问题
				boolean isHidden=strList[i].isHidden();			
				if(isHidden!=true){
					num++;
				}
				
			}
		}
		return num;
	}
	/** 得到广告实体文件信息 参数意义 filePath 驱动器名+广告中的adpath，spilt 指定的分隔符 */
	public static String getDirectoryFileNumberAndFileNames(String filePath,
			String spilt) {
		// 查询路径
		File f = new File(filePath);
		// 存放所有查询结果
		File[] strList;

		int num = 0;
		String fileNames = "";
		strList = f.listFiles();

		String temp = filePath.substring(filePath.indexOf("advts/")
				+ "advts/".length(), filePath.length())
				+ "/";

		for (int i = 0; i < strList.length; i++) {
			if (strList[i].isDirectory()) { 
				//判断是否是目录
				System.out.println("是目录");
			} else {
				//处理系统隐藏文件Thumbs.db的问题
				boolean isHidden=strList[i].isHidden();			
				if(isHidden!=true){
					fileNames = handNoThree((temp + strList[i].getName()).length())
					+ temp + strList[i].getName() + spilt + fileNames;
					num++;
				}			
			}
		}

		String result = "";
		if (num != 0) {
			result = handNoThree(num) + fileNames;
		} else {
			result = "error";
		}

		return result;
	}
	
	
	public static void main(String[] args) {
		String path="C:/sitead/advts/0010001002001/200809220809211020069927";
		String r=getDirectoryFileNumberAndFileNames(path,",");
		System.out.println(r);		
	}

	
	
	
	/**
	 * 复制目录下的文件（不包含该目录和子目录，只复制目录下的文件）到指定目录。
	 * 
	 * @param targetDir
	 * @param path
	 */
	public static void copyFileOnly(String targetDir, String path) {
		File file = new File(path);
		File targetFile = new File(targetDir);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File subFile : files) {
				if (subFile.isFile()) {
					copyFile(targetFile, subFile);
				}
			}
		}
	}
	
	//	遍历文件
	public static String[] listFile(File dir) {
		String absolutPath = dir.getAbsolutePath();
		String[] paths = dir.list();
		String[] files = new String[paths.length];
		for (int i = 0; i < paths.length; i++) {
			files[i] = absolutPath + "/" + paths[i];
		}
		return files;
	}

	/**
	 * 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径
	 * 
	 * @param targetDir
	 * @param filePath
	 */
	public static void copyFileToDir(String targetDir, String... filePath) {
		if (targetDir == null || "".equals(targetDir)) {
			System.out.println("参数错误，目标路径不能为空");
			return;
		}
		File targetFile = new File(targetDir);
		if (!targetFile.exists()) {
			targetFile.mkdir();
		} else {
			if (!targetFile.isDirectory()) {
				System.out.println("参数错误，目标路径指向的不是一个目录！");
				return;
			}
		}
		for (String path : filePath) {
			File file = new File(path);
			if (file.isDirectory()) {
				copyFileToDir(targetDir + "/" + file.getName(), listFile(file));
			} else {
				copyFileToDir(targetDir, file, "");
			}
		}
	}

	/**
	 * 复制文件到指定目录。targetDir是目标目录，file是源文件名，newName是重命名的名字。
	 * 
	 * @param targetFile
	 * @param file
	 * @param newName
	 */
	public static void copyFileToDir(String targetDir, File file, String newName) {
		String newFile = "";
		if (newName != null && !"".equals(newName)) {
			newFile = targetDir + "/" + newName;
		} else {
			newFile = targetDir + "/" + file.getName();
		}
		File tFile = new File(newFile);
		copyFile(tFile, file);
	}

	/**
	 * 复制文件。targetFile为目标文件，file为源文件
	 * 
	 * @param targetFile
	 * @param file
	 */
	public static void copyFile(File targetFile, File file) {
		if (targetFile.exists()) {
			System.out.println("文件" + targetFile.getAbsolutePath()
					+ "已经存在，跳过该文件！");
			return;
		} else {
			createFile(targetFile, true);
		}
		System.out.println("复制文件" + file.getAbsolutePath() + "到"
				+ targetFile.getAbsolutePath());
		try {
			InputStream is = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(targetFile);
			byte[] buffer = new byte[1024];
			while (is.read(buffer) != -1) {
				fos.write(buffer);
			}
			is.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
