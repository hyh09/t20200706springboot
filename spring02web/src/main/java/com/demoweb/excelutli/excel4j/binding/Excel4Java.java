package com.demoweb.excelutli.excel4j.binding;


import com.demoweb.excelutli.excel4j.usermodel.ExcelBook;

/**
 * @author zszhang
 * @version 1.0
 * @updated 17-四月-2015 11:39:27
 */
public interface Excel4Java extends Excel2Bean, Bean2Excel {

    public ExcelBook getBook();

}