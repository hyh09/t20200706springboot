package com.demoweb.excelutli.excel4j.binding;


import com.demoweb.excelutli.excel4j.usermodel.ExcelRow;

/**
 * 将excel中的每条数据转换到java对象的接口。
 * @author zszhang
 * @version 1.0
 * @updated 17-四月-2015 11:31:09
 */
public interface Excel4JavaRowMapper<T> extends Excel2BeanRowMapper<T>, Bean2ExcelRowMapper<T> {

	/**
	 * 将一个bean转到一行数据。失败返回null。
	 * 
	 * @param bean    要转换为ExcelRow的bean
	 * @param row    转换到的row对象
	 */
	public ExcelRow bean2Row(T bean, ExcelRow row);

	/**
	 * 将一行数据转到一个bean中
	 * @return 转换后的bean
	 * 
	 * @param row    row
	 */
	public T row2Bean(ExcelRow row);

}