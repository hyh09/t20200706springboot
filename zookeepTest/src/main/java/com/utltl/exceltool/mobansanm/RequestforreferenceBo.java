package com.utltl.exceltool.mobansanm;

import com.utltl.exceltool.beansvc.ColumnConfig;
import com.utltl.exceltool.beansvc.TableConFiG;

/**
 * Created by dell on 2020/8/21.
 */
@TableConFiG(value = "请求入参")
public class RequestforreferenceBo {


    @ColumnConfig(descriptionyun = "字段名称")
    private  String fieldName;

    @ColumnConfig(descriptionyun = "技术字段名")
    private String TechnicalfieldName;

    @ColumnConfig(descriptionyun = "数据类型")
    private String  datatype;
    @ColumnConfig(descriptionyun = "字段长度")
    private  String fieldSize;

    @ColumnConfig(descriptionyun = "是否必填")
    private  String selectType;

    @ColumnConfig(descriptionyun = "字段解释")
    private  String notes;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTechnicalfieldName() {
        return TechnicalfieldName;
    }

    public void setTechnicalfieldName(String technicalfieldName) {
        TechnicalfieldName = technicalfieldName;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(String fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Override
    public String toString() {
        return "RequestforreferenceBo{" +
                "fieldName='" + fieldName + '\'' +
                ", TechnicalfieldName='" + TechnicalfieldName + '\'' +
                ", datatype='" + datatype + '\'' +
                ", fieldSize='" + fieldSize + '\'' +
                ", selectType='" + selectType + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
