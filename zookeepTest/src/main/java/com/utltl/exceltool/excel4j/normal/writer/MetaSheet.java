package com.utltl.exceltool.excel4j.normal.writer;

import java.util.List;

/**
 * 描述一个sheet页的信息；
 * sheet页由header+data组成，暂不考虑tail.
 * header下面紧接data,暂不考虑间隔空行的情况。
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:39
 */
public class MetaSheet {

	/**
	 * 数据部分的描述信息
	 */
	private List<MetaColumn> data;
	/**
	 * 标题的描述信息
	 */
	private List<List<MetaColumn>> header;
	/**
	 * 标题的高度，以单元格计算。当header不为空时，且此字段小于header中的实际高度时，以header高度为准；否则以此字段为准。
	 */
	private short heightOfHeader = 1;
	public MetaColumn mMetaColumn;

}