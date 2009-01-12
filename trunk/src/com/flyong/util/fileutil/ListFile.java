package com.flyong.util.fileutil;

import java.io.File;

public class ListFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		File f=new File("E:/topic");
			
		listFileByTree(f,1);//以树状的形式遍历文件目录
		System.out.println("\n");
		
		renameFileExtensionNameOfDirectory(f,"txt");//重命名指定目录所有文件扩展名
		listFileByTree(f,1);//以树状的形式遍历文件目录
	}

	
	
	
	
	
	
	
	
	/**
	 * 递归重命名目录所有文件的扩展名
	 */
	public static void renameFileExtensionNameOfDirectory(File f,String fileExtensionName){
			
		File[] childs=f.listFiles();
		for(int i=0;i<childs.length;i++){		
			if(!childs[i].isDirectory()){			
				renameFileExtensionName(childs[i],fileExtensionName);
			}else{
				renameFileExtensionNameOfDirectory(childs[i],fileExtensionName);			
			}					
		}		
	}
	
	
	
	/**
	 * 重命名文件扩展名：
	 * 参数：File对象和想要修改的文件扩展名
	 */
	public static void renameFileExtensionName(File f,String fileExtensionName) {
		
		String filename = f.getAbsolutePath();
		if (filename.indexOf(".") >= 0) {
			filename = filename.substring(0, filename.lastIndexOf("."));
			filename=filename+"."+fileExtensionName;
		}else{
			filename=filename+"."+fileExtensionName;
		}
		//重命名文件名
		f.renameTo(new File(filename));    
		 
		
	}
	
	

	
	
	
	
//*********************************************************************************************
	
	/**
	 * 递归遍历目录下所有文件，以树状的形式显示
	 */
	public static void listFileByTree(File f,int level){
		System.out.println(f.getName());
		String preStr="";
		for(int i=0;i<level;i++){
			preStr+="    ";			
		}	
		File[] childs=f.listFiles();
		for(int i=0;i<childs.length;i++){
			System.out.println(preStr+childs[i].getName());
			if(childs[i].isDirectory()){
				listFileByTree(childs[i],level+1);
			}			
		}
	}
}
