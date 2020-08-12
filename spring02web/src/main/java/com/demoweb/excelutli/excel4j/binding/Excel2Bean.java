package com.demoweb.excelutli.excel4j.binding;

import java.io.File;
import java.util.List;

/**
 * 从excel转换到Bean的接口
 * @author zszhang
 * @version 1.0
 * @updated 16-四月-2015 15:26:22
 */
public interface Excel2Bean {

	/**
	 * 打开一个excel工作薄对象，多次调用createExcelBook同名方法将关闭上次打开的工作薄对象。
	 * 
	 * @param file    file
	 */
	public void createExcelBook(File file);
	/**
	 * @author wang.jie
	 * @created 6-12月-2016
	 * 打开一个excel工作薄对象，多次调用createExcelBook同名方法将关闭上次打开的工作薄对象。
	 * 文件打开成功则返回true，打开失败则返回false
	 * @param file    file
	 */
	public boolean createExcelBook2(File file);

	/**
	 * 读取指定页面中指定范围的数据
	 * @return  -- 如果指定的sheet页不存在，返回NULL
	 * 
	 * @param sheetNo
	 * @param firstRow
	 * @param lastRow
	 * @param rowMapper    -- 行映射信息，必须实现row2Bean方法
	 */
	public <T> List<T> toBeans(int sheetNo, int firstRow, int lastRow, Excel2BeanRowMapper<T> rowMapper);

	/**
	 * 读取指定页面中指定范围的数据
	 * @return  -- 如果指定的sheet页不存在，返回NULL
	 * 
	 * @param sheetName
	 * @param firstRow
	 * @param lastRow
	 * @param rowMapper    -- 行映射信息，必须实现row2Bean方法
	 */
	public <T> List<T> toBeans(String sheetName, int firstRow, int lastRow, Excel2BeanRowMapper<T> rowMapper);

}