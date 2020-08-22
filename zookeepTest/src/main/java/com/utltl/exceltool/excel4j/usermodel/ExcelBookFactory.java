package com.utltl.exceltool.excel4j.usermodel;

import com.utltl.exceltool.excel4j.usermodel.poiAdapter.ExcelBookPoiImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zszhang
 * @version 1.0
 * @created 13-04-2015 17:59:25
 */
public class ExcelBookFactory {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExcelBookFactory.class);

	/**
	 * 通过已有的Excel文件创建工作薄对象，此方法长用于读取excel文件时。
	 * 
	 * @param file    file
	 */
	public static ExcelBook openBook(File file) {
		if( null == file ) {
			LOGGER.warn("Open NULL file Exception!");
			return null;
		}
		
		if( !file.exists() ) {
			return null;
		}
		
		try {
			InputStream inputStream = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(inputStream);
			inputStream.close();
			return new ExcelBookPoiImpl(wb);
		} catch (IOException ioe) {
			LOGGER.warn("文件【'" + file.getName() + "'】IOException:"
					+ ioe.getMessage());
			return null;
		} catch (InvalidFormatException ife) {
			LOGGER.warn("文件【'" + file.getName() + "'】InvalidFormatException:"
					+ ife.getMessage());
			return null;
		}
	}

	/**
	 * 内存中创建工作薄对象，此方法长用于写入excel文件前。
	 * 
	 * @param type    -- 2003表示excel2003格式；2007表示2007及以上格式
	 */
	public static ExcelBook create(int type) {
		Workbook wb = null;
		if( 2003 == type ) {
			wb = new HSSFWorkbook();
		} else {
			wb = new XSSFWorkbook();
		}
		
		return new ExcelBookPoiImpl(wb);
	}

}