package com.demoweb.excelutli.excel4j.binding;


import com.demoweb.excelutli.excel4j.usermodel.ExcelRow;

/**
 * 从Excel中提取出bean对象的rowmapper接口
 * @author zszhang
 * @version 1.0
 * @created 17-四月-2015 11:30:49
 */
public interface Excel2BeanRowMapper<T> {

	/**
	 * 将一行数据转到一个bean中
	 * @return 转换后的bean
	 * 
	 * @param row    待转换的Excel行记录
	 */
	public T row2Bean(ExcelRow row);

}