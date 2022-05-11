package com.jachs.commons.io;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FileUtilsTest {
	
	//转换字节大小为kb,mb,gb..
	@Test
	public void test1() {
		System.out.println(FileUtils.byteCountToDisplaySize(new BigInteger("1023")));
		System.out.println(FileUtils.byteCountToDisplaySize(new BigInteger("1024")));
		System.out.println(FileUtils.byteCountToDisplaySize(new BigInteger(FileUtils.ONE_GB+"")));
	}
	
	@Test
	public void test2() throws IOException {
		Checksum cSum=FileUtils.checksum(new File("d:/a.docx"), new CRC32());
		
		System.out.println(cSum.getValue());
	}
	//清空文件夹
	@Test
	public void test3() throws IOException {
		FileUtils.cleanDirectory(new File("D:\\sucai"));
	}
	//判断俩文件是否一致
	@Test
	public void test5() throws IOException {
		System.out.println(
				FileUtils.contentEquals(new File("d:/a.docx"), new File("d:/c.docx")));
	}
	@Test
	public void test6() throws IOException {
		System.out.println(
		FileUtils.contentEqualsIgnoreEOL(
				new File("d:/a.docx"), new File("d:/b.docx"),"UTF-8"));
	}
	//转换集合为数组
	@Test
	public void test7() {
		List<File>fLi=new ArrayList<File>();
		
		fLi.add(new File("d:/a.docx"));
		fLi.add(new File("d:/b.docx"));
		fLi.add(new File("d:/c.docx"));
		
		File[]  fileList=FileUtils.convertFileCollectionToFileArray(fLi);
		
		for (File file : fileList) {
			System.out.println(file.getName());
		}
	}
	//复制文件a,备份为b
	@Test
	public void test8() throws IOException {
		FileUtils.copyDirectory(new File("D:/sucai"), new File("D:/a"));
	}
	//复制文件夹a,到文件夹b
	@Test
	public void test9() throws IOException {
		FileUtils.copyDirectoryToDirectory(new File("D:/sucai"), new File("D:/a"));
	}
	//复制文件
	@Test
	public void test10() throws IOException {
		FileUtils.copyFile(new File("d:/a.docx"), new File("d:/aa.docx"));
	}
}
