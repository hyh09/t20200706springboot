package com.utltl.exceltool.excel4j.normal.reader.impl;


import com.utltl.exceltool.excel4j.normal.reader.SheetData;
import com.utltl.exceltool.excel4j.normal.reader.SimpleReader;
import com.utltl.exceltool.excel4j.othertool.ExclesrcToollcheck;
import com.utltl.exceltool.excel4j.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zszhang
 * @version 1.0
 * @created 12-四月-2015 19:25:34
 */
public class SimpleReaderImpl implements SimpleReader {
	private final static Logger LOGGER = LoggerFactory.getLogger(SimpleReaderImpl.class);


	private SheetData readSheet(ExcelSheet sheet) {
		if (sheet == null) {
			LOGGER.warn("传入参数为null !");
			return null;
		}

		SheetDataImpl data = new SheetDataImpl();
		for (ExcelRow row : sheet) {
			data.addRow();
			for (ExcelCell cell : row) {
				String value = cell.getCellValueAsString();
				data.addColData(data.getRowCount()-1, value);
			}
		}

		return data;
	}

	/**
	 * 将文件中读出所有sheet的数据
	 * 
	 * @param filename
	 */
	public List<SheetData> read(String filename) {
		return this.read(filename, 0, Integer.MAX_VALUE);
	}

	/**
	 * 将文件中读出第sheetNo页的数据
	 * 
	 * @param filename
	 * @param sheetNo
	 */
	public SheetData read(String filename, int sheetNo) {

		filename= ExclesrcToollcheck.filenameFilter(filename);
		ExcelBook wb = ExcelBookFactory.openBook(new File(filename));
		if (wb == null)
			return null;

		ExcelSheet sheet = wb.getSheetAt(sheetNo);
		SheetData sd = readSheet(sheet);

		return sd;
	}

	/**
	 * 从beginSheetNo页开始，共读count页
	 * 
	 * @param filename
	 * @param beginSheetNo
	 * @param count
	 */
	public List<SheetData> read(String filename, int beginSheetNo, int count) {
		 filename = ExclesrcToollcheck.filenameFilter(filename);
		ExcelBook wb = ExcelBookFactory.openBook(new File(filename));
		if (wb == null)
			return null;

		List<SheetData> result = new ArrayList<SheetData>();
		int endSheetNo = beginSheetNo + count < wb.getNumberOfSheets() ? beginSheetNo + count  : wb.getNumberOfSheets();
		for (int i = beginSheetNo; i < endSheetNo; i++) {
			ExcelSheet sheet = wb.getSheetAt(i);
			SheetData sd = readSheet(sheet);
			result.add(sd);
		}

		return result;
	}

	/**
	 * 将sheets数组中的所有sheetNo页读入进来
	 * 
	 * @param filename
	 * @param sheets
	 */
	public List<SheetData> read(String filename, int[] sheets) {

		filename=ExclesrcToollcheck.filenameFilter(filename);

		ExcelBook wb = ExcelBookFactory.openBook(new File(filename));
		if (wb == null || sheets == null)
			return null;

		List<SheetData> result = new ArrayList<SheetData>();
		for (int i = 0; i < sheets.length; i++) {
			ExcelSheet sheet = wb.getSheetAt(sheets[i]);
			SheetData sd = readSheet(sheet);
			result.add(sd);
		}

		return result;
	}

}