package com.utltl.exceltool.excel4j.usermodel.poiAdapter;


import com.demoweb.excelutli.excel4j.usermodel.ExcelBook;
import com.demoweb.excelutli.excel4j.usermodel.ExcelSheet;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author zszhang
 * @version 1.0
 * @created 13-四月-2015 17:34:38
 */
public class ExcelBookPoiImpl implements ExcelBook {
	private final static Logger LOGGER = LoggerFactory.getLogger(ExcelBookPoiImpl.class);
	
	private Workbook toBook;

	/**
	 * release resouces.
	 */
	@Override
	public void close() {
		if( null != toBook ) {
			try {
				toBook.close();
			} catch (IOException e) {
				LOGGER.warn("关闭excel文件出错：", e);
			}
			toBook = null;
		}
	}

	/**
	 * Called by the garbage collector on an object when garbage collection
	 * determines that there are no more references to the object.
	 * A subclass overrides the {@code finalize} method to dispose of
	 * system resources or to perform other cleanup.
	 * <p>
	 * The general contract of {@code finalize} is that it is invoked
	 * if and when the Java&trade; virtual
	 * machine has determined that there is no longer any
	 * means by which this object can be accessed by any thread that has
	 * not yet died, except as a result of an action taken by the
	 * finalization of some other object or class which is ready to be
	 * finalized. The {@code finalize} method may take any action, including
	 * making this object available again to other threads; the usual purpose
	 * of {@code finalize}, however, is to perform cleanup actions before
	 * the object is irrevocably discarded. For example, the finalize method
	 * for an object that represents an input/output connection might perform
	 * explicit I/O transactions to break the connection before the object is
	 * permanently discarded.
	 * <p>
	 * The {@code finalize} method of class {@code Object} performs no
	 * special action; it simply returns normally. Subclasses of
	 * {@code Object} may override this definition.
	 * <p>
	 * The Java programming language does not guarantee which thread will
	 * invoke the {@code finalize} method for any given object. It is
	 * guaranteed, however, that the thread that invokes finalize will not
	 * be holding any user-visible synchronization locks when finalize is
	 * invoked. If an uncaught exception is thrown by the finalize method,
	 * the exception is ignored and finalization of that object terminates.
	 * <p>
	 * After the {@code finalize} method has been invoked for an object, no
	 * further action is taken until the Java virtual machine has again
	 * determined that there is no longer any means by which this object can
	 * be accessed by any thread that has not yet died, including possible
	 * actions by other objects or classes which are ready to be finalized,
	 * at which point the object may be discarded.
	 * <p>
	 * The {@code finalize} method is never invoked more than once by a Java
	 * virtual machine for any given object.
	 * <p>
	 * Any exception thrown by the {@code finalize} method causes
	 * the finalization of this object to be halted, but is otherwise
	 * ignored.
	 *
	 * @throws Throwable the {@code Exception} raised by this method
	 * @jls 12.6 Finalization of Class Instances
	 * @see WeakReference
	 * @see PhantomReference
	 */
	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}

	/**
     * Sheets of this Book keyed by their sheet indexes.
     * The TreeMap ensures that the sheets are ordered by sheetIndex in the ascending order.
     */
	private final List<ExcelSheet> sheets = new ArrayList<ExcelSheet>();

	public ExcelBookPoiImpl(Workbook book){
		toBook = book;
		if( null == book ) {
			LOGGER.error("初始化ExcelBook失败，传入空的PoiWorkbook对象");
			return;
		}
		for(int i=0; i<toBook.getNumberOfSheets(); i++) {
			Sheet sh = toBook.getSheetAt(i);
			ExcelSheet es = new ExcelSheetPoiImpl(sh, this);
			sheets.add(es);
		}
	}

	/**
	 * Create an Sheet from an existing sheet in the Workbook.
	 * 
	 * 
	 * @param sheetNum
	 */
	public ExcelSheet cloneSheet(int sheetNum){
		Sheet cs = toBook.cloneSheet(sheetNum);
		if( null == cs ) return null;
		
		ExcelSheet es = new ExcelSheetPoiImpl(cs,this);
		sheets.add(es);
		
		return es;
	}

	/**
	 * Use this to create new sheets.
	 */
	public ExcelSheet createSheet(){
		Sheet s = toBook.createSheet();
		if(null == s) return null;
		
		ExcelSheet es = new ExcelSheetPoiImpl(s,this);
		sheets.add(es);
		
		return es;
	}

	/**
	 * Use this to create new sheets.<font
	 * color="#3f5fbf">Note that Excel allows sheet names up to 31 chars in length
	 * but other applications (such as OpenOffice) allow more. Some versions of Excel
	 * crash with names longer than 31 chars,others <font
	 * color="#7f7f9f">- truncate such names to
	 * 31 character.
	 * 
	 * @param sheetname
	 */
	public ExcelSheet createSheet(String sheetname){
		Sheet s = toBook.createSheet(sheetname);
		if(null == s) return null;
		
		ExcelSheet es = new ExcelSheetPoiImpl(s,this);
		sheets.add(es);

		return es;
	}

	/**
	 * 获取当前活动的sheet页编号(0-based)
	 */
	public int getActiveSheetIndex(){
		return toBook.getActiveSheetIndex();
	}

	/**
	 * Get the number of spreadsheets in the
	 * workbook
	 */
	public int getNumberOfSheets(){
		return toBook.getNumberOfSheets();
	}

	/**
	 * Get sheet with the given name
	 * 
	 * @param name
	 */
	public ExcelSheet getSheet(String name){
		for(ExcelSheet sh : sheets) {
			if(sh.getSheetName().equals(name)) return sh;
		}
		return null;
	}

	/**
	 * Get the Sheet object at the given index.
	 * 
	 * @param index
	 */
	public ExcelSheet getSheetAt(int index){
		if( index < 0 || index >= sheets.size()) return null;
		return sheets.get(index);
	}

	/**
	 * Returns the index of the given sheet
	 * @retrun -1 if not found
	 * @param sheet
	 */
	public int getSheetIndex(ExcelSheet sheet){
		int index = 0; 
		for(ExcelSheet sh : sheets) {
			if(sh == sheet) return index;
			index++;
		}
		return -1;
	}

	/**
	 * Returns the index of the sheet by his name
	 * 
	 * @param name
	 * @retrun -1 if not found
	 */
	public int getSheetIndex(String name){
		int index=0;
		for(ExcelSheet sh : sheets) {
			if(sh.getSheetName().equals(name)) return index;
			index++;
		}
		return -1;
	}

	/**
	 * Get the sheet name
	 * 
	 * @param sheet
	 */
	public String getSheetName(int sheet){
		ExcelSheet sh= sheets.get(sheet);
		if( null == sh ) return null;
		return sh.getSheetName();
	}

	/**
	 * Check whether a sheet is hidden.Note that a sheet
	 * could instead be set to be very hidden, which is different
	 * 
	 * @param sheetIx
	 */
	public boolean isSheetHidden(int sheetIx){
		return toBook.isSheetHidden(sheetIx);
	}

	/**
	 * Check whether a sheet is very hidden.This is different
	 * from the normal hidden status.
	 * 
	 * @param sheetIx
	 */
	public boolean isSheetVeryHidden(int sheetIx){
		return toBook.isSheetVeryHidden(sheetIx);
	}

	/**
	 * Removes sheet at the given index.
	 * 
	 * @param index
	 */
	public void removeSheetAt(int index){
		toBook.removeSheetAt(index);
		sheets.remove(index);
	}

	/**
	 * 设置活动Sheet页
	 * 
	 * @param sheetIndex
	 */
	public void setActiveSheet(int sheetIndex){
		toBook.setActiveSheet(sheetIndex);
	}

	/**
	 * Hide or unhide a sheet
	 * 
	 * @param sheetIx
	 * @param hidden    0 - visible. 1 - hidden. 2 - very hidden.
	 */
	public void setSheetHidden(int sheetIx, int hidden){
		toBook.setSheetHidden(sheetIx, hidden);
	}

	/**
	 * Hide or unhide a sheet
	 * 
	 * @param sheetIx
	 * @param hidden
	 */
	public void setSheetHidden(int sheetIx, boolean hidden){
		toBook.setSheetHidden(sheetIx, hidden);
	}

	/**
	 * Set the sheet name. 
	 * if the name is null or invalid, do nothing.
	 * 
	 * @param sheet
	 * @param name
	 */
	public void setSheetName(int sheet, String name){
		toBook.setSheetName(sheet, name);
	}

	/**
	 * Write out this workbook to an Outputstream.
	 * 
	 * Throw IOException if anything can't be written.
	 * 
	 * 
	 * @exception  -- 异常情况发生时日志中记录，不向业务层抛异常。
	 * @return  -- 失败返回false
	 * @param filename
	 */
	public boolean write(String filename) {
		try {
			filename =filenameFilter(filename);

			OutputStream out = new FileOutputStream(filename);
			toBook.write(out);
			out.close();
		} catch (FileNotFoundException fne) {
			LOGGER.error("写入excel时发现文件不存在:"+filename);
			LOGGER.error(fne.getMessage());
			return false;
		} catch (IOException ioe) {
			LOGGER.error("写入excel时发生IO异常:"+filename);
			LOGGER.error(ioe.getMessage());
			return false;
		}
		return true;
	}

	private String filenameFilter(String path) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		map.put("e", "e");
		map.put("f", "f");
		map.put("g", "g");
		map.put("h", "h");
		map.put("i", "i");
		map.put("j", "j");
		map.put("k", "k");
		map.put("l", "l");
		map.put("m", "m");
		map.put("n", "n");
		map.put("o", "o");
		map.put("p", "p");
		map.put("q", "q");
		map.put("r", "r");
		map.put("s", "s");
		map.put("t", "t");
		map.put("u", "u");
		map.put("v", "v");
		map.put("w", "w");
		map.put("x", "x");
		map.put("y", "y");
		map.put("z", "z");

		map.put("A", "A");
		map.put("B", "B");
		map.put("C", "C");
		map.put("D", "D");
		map.put("E", "E");
		map.put("F", "F");
		map.put("G", "G");
		map.put("H", "H");
		map.put("I", "I");
		map.put("J", "J");
		map.put("K", "K");
		map.put("L", "L");
		map.put("M", "M");
		map.put("N", "N");
		map.put("O", "O");
		map.put("P", "P");
		map.put("Q", "Q");
		map.put("R", "R");
		map.put("S", "S");
		map.put("T", "T");
		map.put("U", "U");
		map.put("V", "V");
		map.put("W", "W");
		map.put("X", "X");
		map.put("Y", "Y");
		map.put("Z", "Z");

		map.put(":", ":");
		map.put("/", "/");
		map.put("\\", "\\");
		map.put(".", ".");
		map.put("-", "-");
		map.put("_", "_");

		map.put("0", "0");
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		map.put("9", "9");

//		StringBuilder temp = new StringBuilder();
//		for (int i = 0; i < path.length(); i++) {
//			String tmpStr = map.get(String.valueOf(path.charAt(i)));
//			if (tmpStr != null) {
//				temp.append(tmpStr);
////                temp += map.get(path.charAt(i) + "");
//			}
//		}
//
//		String resultPath = temp.toString();
//
//		if(resultPath.length() != path.length()){
//			LOGGER.error("发现路径操纵嫌疑：原路径{}，过滤后路径{}",path,resultPath);
//
//		}

		String temp = new String();
//        for (int i = 0; i < path.length(); i++) {
//            String tmpStr="";
//            if(isChineseChar(path.charAt(i))){
//                tmpStr = String.valueOf(path.charAt(i));
//            }else{
//                tmpStr = map.get(String.valueOf(path.charAt(i)));
//            }
//
//            if (tmpStr != null) {
//                temp.append(tmpStr);
////                temp += map.get(path.charAt(i) + "");
//            }
//        }
		temp =   path.replace("*","").replace("？","").replace("?","").replace("../","./");
		String resultPath = temp.toString();

		if(resultPath.length() != path.length()){
			LOGGER.error("发现路径操纵嫌疑：原路径{}，过滤后路径{}",path,resultPath);

		}

		return resultPath;
	}

	/**
     * Alias for {@link #sheetIterator()} to allow  foreach loops:
     * 
     * for(ExcelCell cell : row){
     *     ...
     * }
     * 
     *
     * @return an iterator over cells in this row.
     */
	public Iterator<ExcelSheet> iterator() {
		return sheetIterator();
	}
	
    /**
     * Cell iterator over the physically defined cells:
     * 
     * for (Iterator<Cell> it = row.cellIterator(); it.hasNext(); ) {
     *     Cell cell = it.next();
     *     ...
     * }
     * 
     *
     * @return an iterator over cells in this row.
     */
    @SuppressWarnings("unchecked")
	public Iterator<ExcelSheet> sheetIterator() {
    	return (Iterator<ExcelSheet>)(Iterator<? extends ExcelSheet>)sheets.iterator();
	}
	/**
	 * 写入到输出流
	 *
	 * @param     outputStream
	 */
	public void write2Stream(OutputStream outputStream) {
		try {
			toBook.write(outputStream);
		} catch (IOException e) {
			LOGGER.warn("写入文件失败："+ e.getMessage());
		}
	}

}