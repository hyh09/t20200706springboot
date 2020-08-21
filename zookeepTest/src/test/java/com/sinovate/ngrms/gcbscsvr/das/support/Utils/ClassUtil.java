package com.sinovate.ngrms.gcbscsvr.das.support.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassUtil {
	private final static Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);
	/**
	 *  创建一个bean实例。
	 * 
	 * @return succ -- bean ; fail -- null
	 * 
	 */
	public static <T> T createBean(Class<T> clazz ) {
		try {
			T bean = clazz.newInstance();
			return bean;
		} catch (IllegalAccessException e) {
			LOGGER.warn("创建" + clazz.getName() + "的实例失败："+e.getMessage());
			return null;
		} catch (InstantiationException e) {
			LOGGER.warn("创建" + clazz.getName() + "的实例失败："+e.getMessage());
			return null;
		}
	}
}
