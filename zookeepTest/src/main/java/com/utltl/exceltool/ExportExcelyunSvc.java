package com.utltl.exceltool;

import org.apache.poi.ss.formula.functions.T;
import org.directwebremoting.io.FileTransfer;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @单位名称：科大国创—电信资源事业部
 * @创建人：hu.yunhui
 * @创建时间: on 2020/3/23.
 * @by: DELL)
 */
public interface ExportExcelyunSvc {

    public   <T> FileTransfer exportExcel(HttpServletResponse response, String fileName, List<T> voList, T beans) throws Exception;


    public   <T> FileTransfer exportExcel(HttpServletResponse response, String fileName, String tablename, List<T> voList, T beans) throws Exception;

    /**
     * 写入文件
     * @param fileName
     * @param voList
     * @param beans
     * @param <T>
     * @return
     * @throws Exception
     */
    public   void write2File(String fileName, List<T> voList , T beans) throws Exception;



     String encodeFileName(String fileName, String agent);

    }
