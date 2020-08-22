package com.utltl.exceltool.excel4j.binding.impl;


import com.demoweb.excelutli.excel4j.binding.Excel4JavaRowMapper;
import com.demoweb.excelutli.excel4j.usermodel.ExcelRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 缺省的ExcelRowMapper实现，采用反射机制。
 * 
 * @author zszhang
 * @version 1.0
 * @updated 16-四月-2015 19:37:20
 */
public class DefaultExcel4JavaRowMapper<T> implements Excel4JavaRowMapper<T> {
	private final static Logger LOGGER = LoggerFactory.getLogger(DefaultExcel4JavaRowMapper.class);

	/**
	 * 将一个bean转到一行数据。失败返回null。
	 * 
	 * @param bean
	 *            要转换为ExcelRow的bean
	 * @param row
	 *            转换到的row对象
	 */
	public final ExcelRow bean2Row(T bean, ExcelRow row) {
		Class<?> beanType = bean.getClass();
		Field[] fields = beanType.getDeclaredFields();
		Field field = null;
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			// 内部类的this属性判断
			if( beanType.isMemberClass()  && "this$0".equals(field.getName())) continue;
			// 外部类的this属性判断
			if(field.getType().getSimpleName().equals(bean.getClass().getSimpleName())) {
				// 如果是this属性就取下一个字段； 此类判断对内部类无法生效
				continue;
			}
			// 如果是static字段，取下一个字段

			if(Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			try {
				row.createCell(i).setCellValue(field.get(bean));
			} catch (IllegalAccessException e) {
				LOGGER.warn("取字段值时出现非法访问异常:" + field.getName());
				LOGGER.warn("Cause:" + e.getCause());
				continue;
			}
		}
		return row;
	}

	/**
	 * 将一行数据转到一个bean中
	 * 
	 * @return 转换后的bean
	 * 
	 * @param row
	 *            待转换的行记录
	 */
	public final T row2Bean(ExcelRow row) {
		T bean = createBean();
		Class<?> beanType = bean.getClass();
		Field[] fields = beanType.getDeclaredFields();
		Field field = null;
		for (int i = 0; i < fields.length; i++) {
			field = fields[i];
			// 内部类的this属性判断
			if( beanType.isMemberClass()  && "this$0".equals(field.getName())) continue;
			// 外部类的this属性判断
			if(field.getType().getSimpleName().equals(bean.getClass().getSimpleName())) {
				// 如果是this属性就取下一个字段； 此类判断对内部类无法生效
				continue;
			}
			if(null == row.getCell(i)){
				continue;
			}
			Object v = row.getCell(i).getCellValue();
			if( null == v ) continue;
			LOGGER.debug(v.getClass().getName() + v.toString() + field.getType());
			setFieldValue(bean, field, v);
			LOGGER.debug(field.getName());
		}
		bean = postRow2Bean(bean);
		return bean;
	}

	/**
	 *  创建一个bean实例，子类中必须实现。
	 * 
	 * @return succ -- bean ; fail -- null
	 * 
	 */
	protected T createBean( ) {
		return null;
	}
	
	/**
	 *  读取excel后，调整一些bean属性。
	 * 
	 * @return bean
	 * 
	 */
	protected T postRow2Bean( T bean ) {
		return bean;
	}
	
	private void setFieldValue(T bean, Field field, Object value) {
		if( null == value ) return;
		Class<?> type = field.getType();
		String typeName = type.getSimpleName();
		field.setAccessible(true);
		try {
			if( value instanceof String)
				field.set(bean, value);
			else if( !type.isPrimitive()) 
				field.set(bean, value.toString());
			else if( "int".equals(typeName) )
				field.set(bean,((Double)value).intValue());
			else if( "short".equals(typeName) )
				field.set(bean,((Double)value).shortValue());
			else if( "long".equals(typeName) )
				field.set(bean,((Double)value).longValue());
			else if( "float".equals(typeName) )
				field.set(bean,((Double)value).floatValue());
			else if( "double".equals(typeName) )
				field.set(bean,((Double)value).doubleValue());
			else if( "boolean".equals(typeName) )
				field.set(bean,value);
			else {
				LOGGER.warn("set field [" + field.getName() + "] fail....");
			}
		} catch (IllegalAccessException e) {
			LOGGER.warn("设置字段值时出现非法访问异常:" + field.getName());
			LOGGER.warn("Cause:" + e.getCause());
		}
	}

}