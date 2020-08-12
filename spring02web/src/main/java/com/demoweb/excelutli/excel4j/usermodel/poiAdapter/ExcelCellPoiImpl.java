package com.demoweb.excelutli.excel4j.usermodel.poiAdapter;


import com.demoweb.excelutli.excel4j.usermodel.ExcelCell;
import com.demoweb.excelutli.excel4j.usermodel.ExcelRow;
import com.demoweb.excelutli.excel4j.usermodel.ExcelSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:39
 */
public class ExcelCellPoiImpl  implements ExcelCell {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExcelCellPoiImpl.class);
	
	private final Cell toCell;
	private final ExcelRow toRow;

	public ExcelCellPoiImpl(Cell cell, ExcelRow toRow){
		if( null == cell || null == toRow ) {
			LOGGER.error("初始化ExcelCell失败，传入空的PoiCell对象！");
		}
		toCell = cell;
		this.toRow = toRow;
	}

	protected Cell getPoiCell() {
		return toCell;
	}
	/**
	 * Get the value of the cell as a boolean.
	 */
	public boolean getBooleanCellValue(){
		return toCell.getBooleanCellValue();
	}

	/**
	 * Return a formula for the cell, for example, SUM(C4:
	 * E4)
	 */
	public String getCellFormula(){
		return toCell.getCellFormula();
	}

	public int getCellType(){
		switch (toCell.getCellType()) {
		case Cell.CELL_TYPE_BLANK: return ExcelCell.CELL_TYPE_BLANK;
		case Cell.CELL_TYPE_BOOLEAN: return ExcelCell.CELL_TYPE_BOOLEAN;
		case Cell.CELL_TYPE_STRING: return ExcelCell.CELL_TYPE_STRING;
		case Cell.CELL_TYPE_NUMERIC:
				if(DateUtil.isCellDateFormatted(toCell))
					return ExcelCell.CELL_TYPE_DATE;
				else
					return ExcelCell.CELL_TYPE_NUMERIC;
		case Cell.CELL_TYPE_FORMULA:	return getFormulaCellValueType();
		default: return ExcelCell.CELL_TYPE_ERROR;
		}
	}

	private int getFormulaCellValueType() {
		switch(toCell.getCachedFormulaResultType()) {
		case Cell.CELL_TYPE_BLANK: return ExcelCell.CELL_TYPE_BLANK;
		case Cell.CELL_TYPE_BOOLEAN: return ExcelCell.CELL_TYPE_BOOLEAN;
		case Cell.CELL_TYPE_STRING: return ExcelCell.CELL_TYPE_STRING;
		case Cell.CELL_TYPE_NUMERIC:
				if(DateUtil.isCellDateFormatted(toCell))
					return ExcelCell.CELL_TYPE_DATE;
				else
					return ExcelCell.CELL_TYPE_NUMERIC;
		// 因公式的值类型不可能还是公式，所以将其算在default里面做错误处理
		default: return ExcelCell.CELL_TYPE_ERROR;
		}
	}
	/**
	 * Returns column index of this cell
	 */
	public int getColumnIndex(){
		return toCell.getColumnIndex();
	}

	/**
	 * Get the value of the cell as a date.
	 */
	public Date getDateCellValue(){
		return toCell.getDateCellValue();
	}

	/**
	 * Get the value of the cell as a number.
	 */
	public double getNumericCellValue(){
		return toCell.getNumericCellValue();
	}

	/**
	 * Returns the Row this cell belongs to
	 */
	public ExcelRow getRow(){
		return toRow;
	}

	/**
	 * Returns row index of a row in the sheet that contains
	 * this cell
	 */
	public int getRowIndex(){
		return toCell.getRowIndex();
	}

	/**
	 * Returns the sheet this cell belongs to
	 */
	public ExcelSheet getSheet(){
		return toRow.getSheet();
	}

	/**
	 * Get the value of the cell as a string
	 */
	public String getStringCellValue(){
		return toCell.getStringCellValue();
	}

	/**
	 * Sets formula for this cell.
	 * 
	 * @param formula
	 */
	public void setCellFormula(String formula){
		//toCell.setCellType(Cell.CELL_TYPE_FORMULA);
		toCell.setCellFormula(formula);
	}

	/**
	 * Set the cells type.If the cell currently contains a
	 * value, the value will be converted to match the new type, if possible.
	 * 
	 * 
	 * @param cellType
	 */
	public void setCellType(int cellType){
		switch (cellType) {
		case CELL_TYPE_BLANK: 
			toCell.setCellType(Cell.CELL_TYPE_BLANK);
			break;
		case CELL_TYPE_BOOLEAN:
			toCell.setCellType(Cell.CELL_TYPE_BOOLEAN);
			break;
		case CELL_TYPE_STRING:
			toCell.setCellType(Cell.CELL_TYPE_STRING);
			break;
		case CELL_TYPE_DATE:
		case CELL_TYPE_NUMERIC:
			toCell.setCellType(Cell.CELL_TYPE_NUMERIC);
			break;
		default:
			toCell.setCellType(Cell.CELL_TYPE_ERROR);
		}
	}

	/**
	 * Set a string value for the cell.
	 * 
	 * @param value
	 */
	public void setCellValue(String value){
		toCell.setCellValue(value);
	}

	/**
	 * Converts the supplied date to its equivalent Excel
	 * numeric value and sets that into the cell.
	 * 
	 * @param value
	 */
	public void setCellValue(Date value){
		toCell.setCellValue(value);
	}

	/**
	 * Set a boolean value for the cell
	 * 
	 * @param value
	 */
	public void setCellValue(boolean value){
		toCell.setCellValue(value);
	}

	/**
	 * Set a numeric value for the cell
	 * 
	 * @param value
	 */
	public void setCellValue(double value){
		toCell.setCellValue(value);
	}

	/**
	 * 不管什么类型都按照字符串形式返回值
	 * 
	 * @return 返回字符串形式的值,BLANK返回"NULL"，ERROR返回"ERROR"
	 */
	public String getCellValueAsString() {
		String v = getCellValue().toString();
		return v;	
	}

	public Object getCellValue() {
		Cell cell = toCell;
		Object v = null;
		int type = cell.getCellType() == Cell.CELL_TYPE_FORMULA ?  cell.getCachedFormulaResultType() : cell.getCellType();
		switch (type) {
		case Cell.CELL_TYPE_STRING:
			v = cell.getRichStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				v = cell.getDateCellValue();
			} else {
				v = cell.getNumericCellValue();
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			v = cell.getBooleanCellValue();
			break;
		default:
			// do nothing.
			LOGGER.debug("cell " + cell.getColumnIndex() + "convert fail...");
		}
		return v;
	}

	public void setCellValue(Object value) {
		if( null == value ) return;
		if( value instanceof Date) setCellValue(Date.class.cast(value));
		else if( value instanceof String) setCellValue(String.class.cast(value));
		else if( value instanceof Boolean) setCellValue(Boolean.class.cast(value).booleanValue());
		else if ( value instanceof Integer) setCellValue(Integer.class.cast(value).doubleValue());
	}

}