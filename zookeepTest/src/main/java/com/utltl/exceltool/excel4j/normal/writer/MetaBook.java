package com.utltl.exceltool.excel4j.normal.writer;

/**
 * 描述excel工作薄WorkBook信息
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:39
 */
public class MetaBook {

	/**
	 * 从第beginSheet页开始处理sheet页。
	 */
	private short beginSheet = 0;
	/**
	 * 总共需要处理的sheet数量
	 */
	private short sheetCnt = 1;
	public MetaSheet mMetaSheet;


}