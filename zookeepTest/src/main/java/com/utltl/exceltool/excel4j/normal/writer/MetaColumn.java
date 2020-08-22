package com.utltl.exceltool.excel4j.normal.writer;

/**
 * 描述抽象的excel列信息；这些描述信息通常包括取值范围、公式、展现方式
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:39
 */
public class MetaColumn {

	/**
	 * 背景颜色
	 */
	private String backgroundColor;
	/**
	 * 字体颜色
	 */
	private String fontColor;
	/**
	 * 计算公式，excel的计算公式，用于根据用户输入由excel自动生成相应数据。
	 */
	private String formula;
	/**
	 * 纵向占用单元格数量；除表头外，数据部分很少用到占用多个单元格的情况，所以此字段暂时不实现。
	 */
	private short heightByCells = 1;
	/**
	 * ','分割的字符串。对应excel中的数据有效性串。
	 */
	private String range;
	/**
	 * 横向占用单元格数量
	 */
	private short widthByCells = 1;


}