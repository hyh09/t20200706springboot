package com.utltl.exceltool.excel4j.binding.impl;


import com.utltl.exceltool.excel4j.binding.Bean2ExcelRowMapper;
import com.utltl.exceltool.excel4j.binding.Excel2BeanRowMapper;
import com.utltl.exceltool.excel4j.binding.Excel4Java;
import com.utltl.exceltool.excel4j.usermodel.ExcelBook;
import com.utltl.exceltool.excel4j.usermodel.ExcelBookFactory;
import com.utltl.exceltool.excel4j.usermodel.ExcelRow;
import com.utltl.exceltool.excel4j.usermodel.ExcelSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.OutputStream;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


/**
 * @author zszhang
 * @version 1.0
 * @created 15-四月-2015 0:32:36
 */
public class Excel4JavaImpl implements Excel4Java {
	private final static Logger LOGGER = LoggerFactory.getLogger(Excel4JavaImpl.class);

	public ExcelBook getBook() {
		return book;
	}

	private ExcelBook book;

	public Excel4JavaImpl(){
		book = null;
	}

	/**
	 * 设置数据有效性序列，本方法支持的为输入序列，采用公式引用方式的，请采用下一个setDataValidation方法。
	 * 
	 * @param sequence    -- 字符串序列
	 * @param sheetName
	 * @param firstRow    -- 开始行
	 * @param lastRow    -- 结束行
	 * @param firstCol    -- 开始列
	 * @param lastCol    --  结束列
	 */
	public void addDataValidation(String[] sequence, String sheetName, int firstRow, int lastRow, int firstCol, int lastCol){
		ExcelSheet sh = book.getSheet(sheetName);
		sh.addDataValidation(sequence, firstRow, lastRow, firstCol, lastCol);
	}

	/**
	 * 设置数据有效性序列，本方法采用公式引用方式，直接输入值方式的请使用上一个setDataValidation方法。
	 * 
	 * @param formula    -- 引用数据源的公式
	 * @param sheetName
	 * @param firstRow    -- 开始行
	 * @param lastRow    -- 结束行
	 * @param firstCol    -- 开始列
	 * @param lastCol    --  结束列
	 */
	public void addDataValidation(String formula, String sheetName, int firstRow, int lastRow, int firstCol, int lastCol){
		ExcelSheet sh = book.getSheet(sheetName);
		sh.addDataValidation(formula, firstRow, lastRow, firstCol, lastCol);
	}

	/**
	 * 设置数据有效性序列，本方法采用公式引用方式，直接输入值方式的请使用上一个setDataValidation方法。
	 * 
	 * @param formula    -- 引用数据源的公式
	 * @param sheetNo
	 * @param firstRow    -- 开始行
	 * @param lastRow    -- 结束行
	 * @param firstCol    -- 开始列
	 * @param lastCol    --  结束列
	 */
	public void addDataValidation(String formula, int sheetNo, int firstRow, int lastRow, int firstCol, int lastCol){
		ExcelSheet sh = book.getSheetAt(sheetNo);
		sh.addDataValidation(formula, firstRow, lastRow, firstCol, lastCol);
	}

	/**
	 * 设置数据有效性序列，本方法支持的为输入序列，采用公式引用方式的，请采用下一个setDataValidation方法。
	 * 
	 * @param sequence    -- 字符串序列
	 * @param sheetNo
	 * @param firstRow    -- 开始行
	 * @param lastRow    -- 结束行
	 * @param firstCol    -- 开始列
	 * @param lastCol    --  结束列
	 */
	public void addDataValidation(String[] sequence, int sheetNo, int firstRow, int lastRow, int firstCol, int lastCol){
		ExcelSheet sh = book.getSheetAt(sheetNo);
		sh.addDataValidation(sequence, firstRow, lastRow, firstCol, lastCol);
	}

	/**
	 * 写入到文件
	 * 
	 * @param filename
	 */
	public void write2File(String filename){
		book.write(filename);
	}

	/**
	 * 打开一个excel工作薄对象，多次调用将关闭上次打开的工作薄对象。
	 * 
	 * @param type 2003-excel2003格式； other - excel2007以上格式
	 */
	public void createExcelBook(int type) {
		close();
		book = ExcelBookFactory.create(type);
	}

	/**
	 * Called by the garbage collector on an object when garbage collection
	 * determines that there are no more references to the object.
	 * A subclass overrides the {@code finalize} method to dispose of
	 * system resources or to perform other cleanup.
	 * <p>
	 * The general contract of {@code finalize} is that it is invoked
	 * if and when the Java&trade; virtual
	 * machine has determined that there is no longer any
	 * means by which this object can be accessed by any thread that has
	 * not yet died, except as a result of an action taken by the
	 * finalization of some other object or class which is ready to be
	 * finalized. The {@code finalize} method may take any action, including
	 * making this object available again to other threads; the usual purpose
	 * of {@code finalize}, however, is to perform cleanup actions before
	 * the object is irrevocably discarded. For example, the finalize method
	 * for an object that represents an input/output connection might perform
	 * explicit I/O transactions to break the connection before the object is
	 * permanently discarded.
	 * <p>
	 * The {@code finalize} method of class {@code Object} performs no
	 * special action; it simply returns normally. Subclasses of
	 * {@code Object} may override this definition.
	 * <p>
	 * The Java programming language does not guarantee which thread will
	 * invoke the {@code finalize} method for any given object. It is
	 * guaranteed, however, that the thread that invokes finalize will not
	 * be holding any user-visible synchronization locks when finalize is
	 * invoked. If an uncaught exception is thrown by the finalize method,
	 * the exception is ignored and finalization of that object terminates.
	 * <p>
	 * After the {@code finalize} method has been invoked for an object, no
	 * further action is taken until the Java virtual machine has again
	 * determined that there is no longer any means by which this object can
	 * be accessed by any thread that has not yet died, including possible
	 * actions by other objects or classes which are ready to be finalized,
	 * at which point the object may be discarded.
	 * <p>
	 * The {@code finalize} method is never invoked more than once by a Java
	 * virtual machine for any given object.
	 * <p>
	 * Any exception thrown by the {@code finalize} method causes
	 * the finalization of this object to be halted, but is otherwise
	 * ignored.
	 *
	 * @throws Throwable the {@code Exception} raised by this method
	 * @jls 12.6 Finalization of Class Instances
	 * @see WeakReference
	 * @see PhantomReference
	 */
	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}

	/**
	 * 将beans写入到指定的sheet页的指定位置
	 * 
	 * @param beans
	 * @param sheetName
	 * @param firstRow
	 * @param rowMapper -- 行映射信息，必须实现其中的bean2Row方法
	 */
	public <T> void toSheet(List<T> beans, String sheetName, int firstRow, Bean2ExcelRowMapper<T> rowMapper) {
		if( null == book ) return;
		int sheetNo = book.getSheetIndex(sheetName);
		if( -1 == sheetNo ) {
			book.createSheet(sheetName);
			sheetNo = book.getSheetIndex(sheetName);
		}
		toSheet(beans, sheetNo, firstRow, rowMapper);
	}

	/**
	 * 将beans写入到指定的sheet页的指定位置
	 * 
	 * @param beans
	 * @param sheetNo
	 * @param firstRow
	 * @param rowMapper -- 行映射信息， 必须实现其中的row2Bean方法
	 */
	public <T> void toSheet(List<T> beans, int sheetNo, int firstRow, Bean2ExcelRowMapper<T> rowMapper) {
		if( null == book ) return;
		ExcelSheet sh = book.getSheetAt(sheetNo);
		if( sh == null ) {
			sh = book.createSheet(); 
		}
		int rownum = firstRow;
		for(T bean : beans) {
			ExcelRow row = sh.createRow(rownum++);
			rowMapper.bean2Row(bean, row);
		}
	}
	/**
	 * 读取一个excel文件, 多次调用将丢弃上次读取的文件。
	 * @param file
	 */
	public void createExcelBook(File file)  {
		try {
			close();
			book = ExcelBookFactory.openBook(file);
		} catch (Exception e) {
//			e.printStackTrace();
			LOGGER.info(e.toString());
		}
		if( null == book ) createExcelBook(2007);
	}
	/**
	 * @author wang.jie
	 * @created 6-12月-2016
	 * 读取一个excel文件, 多次调用将丢弃上次读取的文件。
	 * @param file
	 */
	public boolean createExcelBook2(File file)  {
		try {
			close();
			book = ExcelBookFactory.openBook(file);
		} catch (Exception e) {
//			e.printStackTrace();
			LOGGER.info(e.toString());
		}
		if( null == book ) {
			createExcelBook(2007);
			return false;
		}
		return true;
	}
	private void close() {
		if(null != book) {
			book.close();
			book = null;
		}
	}
	/**
	 * 读取指定页面中指定范围的数据
	 * 
	 * @return  -- 如果指定的sheet页不存在，返回NULL
	 * @param sheetNo
	 * @param firstRow
	 * @param lastRow
	 * @param rowMapper -- 行映射信息，必须实现row2Bean方法
	 */
	public <T> List<T> toBeans(int sheetNo, int firstRow, int lastRow, Excel2BeanRowMapper<T> rowMapper) {
		if ( null == book ) {
			LOGGER.warn("调用本方法前，要先调用read(file)方法将Excel文件内容读取进来！");
			return null;
		}
		ExcelSheet sh = book.getSheetAt(sheetNo);
		if( null == sh ) {
			LOGGER.warn("指定的sheetNo不存在:"+ sheetNo);
			return null;
		}
		return toBeans(sh, firstRow, lastRow, rowMapper);
	}

	/**
	 * 读取指定页面中指定范围的数据
	 * 
	 * @return  -- 如果指定的sheet页不存在，返回NULL
	 * @param sheetName
	 * @param firstRow
	 * @param lastRow
	 * @param rowMapper -- 行映射信息，必须实现row2Bean方法
	 */
	public <T> List<T> toBeans(String sheetName, int firstRow, int lastRow, Excel2BeanRowMapper<T> rowMapper) {
		if ( null == book ) {
			LOGGER.warn("调用本方法前，要先调用read(file)方法将Excel文件内容读取进来！");
			return null;
		}
		ExcelSheet sh = book.getSheet(sheetName);
		if( null == sh ) {
			LOGGER.warn("指定的sheetName不存在:"+ sheetName);
			return null;
		}
		return toBeans(sh, firstRow, lastRow, rowMapper);
		
	}

	private <T> List<T> toBeans(ExcelSheet sheet, int firstRow, int lastRow, Excel2BeanRowMapper<T> rowMapper) {
		lastRow = lastRow <= sheet.getLastRowNum() ? lastRow : sheet.getLastRowNum();
		if( firstRow > lastRow ) return null;
		
		List<T> beans  = new ArrayList<T>(lastRow-firstRow+1);
		
		for(int i = firstRow; i <= lastRow ; i++) {
			ExcelRow row = sheet.getRow(i);
			if( null == row ) continue;
			T bean = rowMapper.row2Bean(row);
			if( null == bean ) continue;
			beans.add(bean);
		}
		
		return beans;
	}	
	/**
	 * Hide or unhide a sheet
	 * 
	 * @param sheetIndex
	 * @param hidden    0 - visible. 1 - hidden. 2 - very hidden.
	 */
	public void setSheetHidden(int sheetIndex, int hidden) {
		book.setSheetHidden(sheetIndex, hidden);
	}

	/**
	 * Hide or unhide a sheet
	 * 
	 * @param sheetName
	 * @param hidden    0 - visible. 1 - hidden. 2 - very hidden.
	 */
	public void setSheetHidden(String sheetName, int hidden) {
		int sheetIx = book.getSheetIndex(sheetName);
		if( sheetIx < 0 ) 	return;
		book.setSheetHidden(sheetIx, hidden);
	}
	/**
	 * 写入到输出流
	 *
	 * @param     outputStream
	 */
	public void write2Stream(OutputStream outputStream){
		book.write2Stream(outputStream);
	}

}