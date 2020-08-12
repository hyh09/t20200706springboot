package com.demoweb.excelutli.excel4j.usermodel.poiAdapter;


import com.demoweb.excelutli.excel4j.usermodel.ExcelBook;
import com.demoweb.excelutli.excel4j.usermodel.ExcelRow;
import com.demoweb.excelutli.excel4j.usermodel.ExcelSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:39
 */
public class ExcelSheetPoiImpl implements ExcelSheet {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExcelSheetPoiImpl.class);
	
	private final Sheet toSheet;
	private final ExcelBook toBook;
	// 为了保证按rowIndex升序且快速增删采用TreeMap
	private final TreeMap<Integer,ExcelRow> rows = new TreeMap<Integer,ExcelRow>();

	public ExcelSheetPoiImpl(Sheet sheet, ExcelBook toBook){
		toSheet = sheet;
		this.toBook = toBook;
		if(null == sheet || null == toBook) {
			LOGGER.error("初始化ExcelSheet失败，传入空的PoiSheet对象！");
			return;
		}
		for(Row r : sheet) {
			ExcelRow er = new ExcelRowPoiImpl(r, this);
			rows.put(r.getRowNum(), er);
		}
	}

	protected Sheet getPoiSheet() {
		return toSheet;
	}
	
	/**
	 * Create a new row within the sheet and return the high
	 * level representation.
	 * 
	 * @param rownum
	 */
	public ExcelRow createRow(int rownum){
		Row row = toSheet.createRow(rownum);
		if( null == row ) return null;
		
		ExcelRow er = new ExcelRowPoiImpl(row, this);
		rows.put(row.getRowNum(), er);
		return er;
	}

	/**
	 * Return the toBook workbook
	 */
	public ExcelBook getBook(){
		return toBook;
	}

	/**
	 * Gets the first row on the sheet.<font
	 * color="#7f9fbf">return the number of the
	 * first logical row on the sheet (0-
	 * based).
	 */
	public int getFirstRowNum(){
		return toSheet.getFirstRowNum();
	}

	/**
	 * Gets the last row on the sheet.
	 */
	public int getLastRowNum(){
		return toSheet.getLastRowNum();
	}

	/**
	 * The left col in the visible view when the sheet is
	 * first viewed after opening it in a viewer
	 */
	public int getLeftCol(){
		return toSheet.getLeftCol();
	}

	/**
	 * Returns the logical row (not physical)
	 * 0-based.
	 *  If you ask for a row that is not defined
	 * you get a null.
	 * 
	 * @param rownum
	 */
	public ExcelRow getRow(int rownum){
		return rows.get(rownum);
	}

	/**
	 * Returns the name of this sheet
	 */
	public String getSheetName(){
		return toSheet.getSheetName();
	}

	/**
	 * The top row in the visible view when the sheet is
	 * first viewed after opening it in a viewer
	 */
	public int getTopRow(){
		return toSheet.getTopRow();
	}

	/**
	 * Get the hidden state for a given column
	 * 
	 * @param columnIndex
	 */
	public boolean isColumnHidden(int columnIndex){
		return toSheet.isColumnHidden(columnIndex);
	}

	/**
	 * Remove a row from this sheet.  All cells contained in
	 * the row are removed as well.
	 * 
	 * @param row
	 */
	public void removeRow(ExcelRow row){
		if( null == row || row.getSheet() != this ) {
			LOGGER.warn("删除行失败：传入的行为NULL或非本Sheet页的行");
			return;
		}
		toSheet.removeRow(((ExcelRowPoiImpl)row).getPoiRow());
		rows.remove(row.getRowNum());
	}

	/**
	 * Set the visibility state for a given column
	 * 
	 * @param columnIndex
	 * @param hidden
	 */
	public void setColumnHidden(int columnIndex, boolean hidden){
		toSheet.setColumnHidden(columnIndex, hidden);
	}

    /**
     * Alias for {@link #rowIterator()} to
     *  allow foreach loops
     */
	public Iterator<ExcelRow> iterator() {
		return rowIterator();
	}

    /**
     * @return an iterator of the PHYSICAL rows.  Meaning the 3rd element may not
     * be the third row if say for instance the second row is undefined.
     * Call getRowNum() on each row if you care which one it is.
     */
	public Iterator<ExcelRow> rowIterator() {
		return rows.values().iterator();
	}
	/**
	 * 设置数据有效性序列，本方法支持的为输入序列，采用公式引用方式的，请采用下一个setDataValidation方法。
	 * 
	 * @param sequence  -- 字符串序列
	 * @param firstRow -- 开始行
	 * @param lastRow -- 结束行
	 * @param firstCol  -- 开始列
	 * @param lastCol  --  结束列
	 */
    public void addDataValidation(String[] sequence, int firstRow, int lastRow, int firstCol, int lastCol){
    	DataValidationHelper helper = toSheet.getDataValidationHelper();
    	DataValidationConstraint constraint = helper.createExplicitListConstraint(sequence);
    	CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow,firstCol, lastCol);
    	DataValidation dataValidation = helper.createValidation(constraint, region);
    	toSheet.addValidationData(dataValidation);
    }
	/**
	 * 设置数据有效性序列，本方法采用公式引用方式，直接输入值方式的请使用上一个setDataValidation方法。
	 * 
	 * @param formula  -- 引用数据源的公式
	 * @param firstRow -- 开始行
	 * @param lastRow -- 结束行
	 * @param firstCol  -- 开始列
	 * @param lastCol  --  结束列
	 */
    public void addDataValidation(String formula, int firstRow, int lastRow, int firstCol, int lastCol){
    	DataValidationHelper helper = toSheet.getDataValidationHelper();
    	DataValidationConstraint constraint = helper.createFormulaListConstraint(formula);
    	CellRangeAddressList region = new CellRangeAddressList(firstRow, lastRow,firstCol, lastCol);
    	DataValidation dataValidation = helper.createValidation(constraint, region);
    	toSheet.addValidationData(dataValidation);
    }

}