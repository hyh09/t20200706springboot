/**
 * @单位名称：科大国创—电信资源事业部
 *            USTC Sinovate Software Co.,Ltd.
 * 		      Copyright (c) 2013 All Rights Reserved.
 * @系统名称：NGRMS—下一代网络资源管理系统
 * @工程名称：
 * @文件名称: 
 * @类路径: 
 */

package com.sinovate.ngrms.gcbscsvr.mdl.db.gcdm.eother;

import com.utltl.exceltool.beansvc.Conf;
import com.utltl.exceltool.beansvc.FileShow;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * @see
 * @author 	liu.heng@ustcinfo.com
 * @date	2015-09-16 16:50:59 中国标准时间
 * @version	V0.1.0
 * @desc    TODO
 */
public class PmAssetMssback implements Serializable {
	
    public static final String TABLE_NAME = "PM_ASSET_MSSBACK";

	public static final String TABLE_ALIAS = "PmAssetMssback";
	
	public static final String COL_ID = "ID";
	
	public static final String COL_ZGDJ = "ZGDJ";
	
	public static final String COL_POSID = "POSID";
	
	public static final String COL_OSSZSEQ = "OSSZSEQ";
	
	public static final String COL_AGREEFLAG = "AGREEFLAG";
	
	public static final String COL_ZZKRZC = "ZZ_KRZC";
	
	public static final String COL_ZZYZCBM = "ZZ_YZCBM";

	public static final String COL_ZZLICENSE = "ZZ_LICENSE";

	public static final String COL_ZZFZ07 = "ZZ_FZ07";

	public static final String COL_ZZLDQRQ = "ZZ_LDQRQ";

	public static final String COL_ZZRJJSGLBM = "ZZ_RJJSGLBM";

	public static final String COL_ZZRJJSWHBM = "ZZ_RJJSWHBM";

	public static final String COL_ZZCBRQ = "ZZ_CBRQ";

	public static final String COL_ZZCBYDFL = "ZZ_CBYDFL";

	public static final String COL_ANLKL = "ANLKL";
	
	public static final String COL_ZZKEY = "ZZ_KEY";
	
	public static final String COL_TXT50 = "TXT50";
	
	public static final String COL_ANLHTXT = "ANLHTXT";
	
	public static final String COL_USEAREACODE = "USEAREACODE";
	
	public static final String COL_TXA50 = "TXA50";
	
	public static final String COL_MENGE = "MENGE";
	
	public static final String COL_MEINS = "MEINS";
	
	public static final String COL_AKTIV = "AKTIV";
	
	public static final String COL_HERST = "HERST";
	
	public static final String COL_ORD41 = "ORD41";
	
	public static final String COL_SPECTYPE = "SPECTYPE";
	
	public static final String COL_URWRT = "URWRT";
	
	public static final String COL_ZZKHZC = "ZZ_KHZC";
	
	public static final String COL_ZZKHMC = "ZZ_KHMC";
	
	public static final String COL_ORD43 = "ORD43";
	
	public static final String COL_ZZZCLB = "ZZ_ZCLB";
	
	public static final String COL_ZZYFYZC = "ZZ_YFYZC";
	
	public static final String COL_ZZYFGCBM = "ZZ_YFGCBM";
	
	public static final String COL_ZZSWGL = "ZZ_SWGL";
	
	public static final String COL_ZZGLY = "ZZ_GLY";
	
	public static final String COL_ZZSYBM = "ZZ_SYBM";
	
	public static final String COL_ZZBGY = "ZZ_BGY";
	
	public static final String COL_RAUMN = "RAUMN";
	
	public static final String COL_KOSTL = "KOSTL";
	
	public static final String COL_PHYSICALID = "PHYSICAL_ID";
	
	public static final String COL_ZZQYBM = "ZZ_QYBM";
	
	public static final String COL_ZZQXGS = "ZZ_QXGS";
	
	public static final String COL_ZZYXZX = "ZZ_YXZX";
	
	public static final String COL_ZZYYTID = "ZZ_YYTID";
	
	public static final String COL_ZZJZID = "ZZ_JZID";
	
	public static final String COL_BASESTATNAME = "BASESTATNAME";
	
	public static final String COL_ZZBANZ = "ZZ_BANZ";
	
	public static final String COL_ZURWRT4 = "ZURWRT4";
	
	public static final String COL_ZURWRT2 = "ZURWRT2";
	
	public static final String COL_ZURWRT3 = "ZURWRT3";
	
	public static final String COL_TOTAL = "TOTAL";
	
	public static final String COL_ANLN1 = "ANLN1";
	
	public static final String COL_PRCTR = "PRCTR";
	
	public static final String COL_ZZCHQNUM = "ZZ_CHQNUM";
	
	public static final String COL_ZZZJYY = "ZZ_ZJYY";
	
	public static final String COL_NDJAR = "NDJAR";
	
	public static final String COL_JZZB = "JZZB";
	
	public static final String COL_ZZFSSB = "ZZ_FSSB";
	
	public static final String COL_ZZBZ = "ZZ_BZ";
	
	public static final String COL_CREATEDATE = "CREATE_DATE";
	
	public static final String COL_EDITDATE = "EDIT_DATE";
	private static final long serialVersionUID = -9136569576241081838L;


	@Conf("341007000000042782308721")//初始化的默认值
	@FileShow(fieldName = "转固单据ID",datatype = "String",fieldSize = "24",selectType = "必填",notes = "转固单据id")
	private BigInteger id;
    @FileShow(fieldName = "转固单据ID",datatype = "CHAR",fieldSize = "255.0",selectType = "必填",notes = "null")
    private  String zgdj;
    @Conf("20AH000120201")
	@FileShow(fieldName = "工程编号",datatype = "CHAR",fieldSize = "24.0",selectType = "必填",notes = "null")
	private  String posid;
    @Conf("70000144683774")
	@FileShow(fieldName = "OSS转固资产序号",datatype = "CHAR",fieldSize = "17.0",selectType = "必填",notes = "资产在转固资产中的流水编码，在所有交资表中唯一,前2位是省编码，安徽是11，上海是03;统一目录的2位组织编码")
	private  Long osszseq;
	@FileShow(fieldName = "是否确认",datatype = "VARCHAR2",fieldSize = "1.0",selectType = "必填默认为1",notes = "1-是,0-否")
	private  String agreeflag;
	@FileShow(fieldName = "建卡方式",datatype = "CHAR",fieldSize = "null",selectType = "必填",notes = "创建卡片的方式，固定资产枚举值：0代表“新建”、1代表“扩容”、2代表“大修”；软件资产枚举值：0代表“0-新增软件/模块”，1代表“1-在原模块中新增功能”。")
	private  String zzKrzc;
	@FileShow(fieldName = "原卡片编号",datatype = "CHAR",fieldSize = "20.0",selectType = "固定资产建卡方式为“大修”、“扩容”时，此字段必填；软件资产建卡方式为“1-在原模块中新增功能”时，此字段必填。",notes = "null")
	private  String zzYzcbm;
	@FileShow(fieldName = "资产分类",datatype = "CHAR",fieldSize = "8.0",selectType = "必填",notes = "SAP中资产分类,MDM主数据")
	private  String anlkl;
	@FileShow(fieldName = "固定资产目录",datatype = "CHAR",fieldSize = "10.0",selectType = "必填",notes = "按照固定资产目录规定的“类”“项”“目”“节”“点”代码填写。管到“节”是8位；管到“点”是10位；MDM主数据")
	private  String zzKey;
	@FileShow(fieldName = "资产名称",datatype = "CHAR",fieldSize = "50.0",selectType = "必填",notes = "默认带出固定资产的实物名称,可人工修改")
	private  String txt50;
	@FileShow(fieldName = "所在地点",datatype = "CHAR",fieldSize = "50.0",selectType = "必填",notes = "资产存放的具体地点。")
    @Conf("蒲城县延红东巷居民点FTTH光分箱02")
	private  String anlhtxt;
	@FileShow(fieldName = "使用单位",datatype = "VARCHAR2",fieldSize = "12.0",selectType = "必填",notes = "计划建设的区域OU数据，后期不再填写")
	private  String useareacode;
	@FileShow(fieldName = "规格、型号、结构",datatype = "CHAR",fieldSize = "50.0",selectType = "必填",notes = "填写固定资产的型号规格等内容，房屋资产按其建筑结构，如“钢筋混凝土结构”“砖木结构”等填写")
	private  String txa50;
	@FileShow(fieldName = "数量（面积）",datatype = "QUAN",fieldSize = "13.0",selectType = "必填",notes = "按实际填写；软件资产默认1，不可编辑。")
	private  Double menge;
	@FileShow(fieldName = "计量单位",datatype = "UNIT",fieldSize = "3.0",selectType = "必填",notes = "固定资产目录的单位,MDM主数据，不可人工修改")
	private  String meins;

	@FileShow(fieldName = "资本化日期",datatype = "DATS",fieldSize = "8.0",selectType = "非必填",notes = "为资产开始计提资产折旧的依据,工辅系统填写。")
	private  Date aktiv;
	@FileShow(fieldName = "生产厂家",datatype = "CHAR",fieldSize = "30.0",selectType = "必填",notes = "填写主要设备的制造商全称")
	private  String herst;
	@FileShow(fieldName = "资产归属",datatype = "CHAR",fieldSize = "4.0",selectType = "必填",notes = "按照“A001一级干线”“A002二")
	private  String ord41;
	@FileShow(fieldName = "专业属性",datatype = "VARCHAR2",fieldSize = "64.0",selectType = "必填",notes = "枚举项包括（A001一级干线，A002二级干线，A003本地网及其他）")
	private  String spectype;
	@FileShow(fieldName = "设备采购合同价（元）（不含增值税）",datatype = "CURR",fieldSize = "13.0",selectType = "必填",notes = "固定资产的购置价值")
	private  Double urwrt;
	@FileShow(fieldName = "是否客户端资产",datatype = "CHAR",fieldSize = "1.0",selectType = "必填",notes = "客户端资产")
	private  String zzKhzc;
	@FileShow(fieldName = "客户端名称",datatype = "CHAR",fieldSize = "60.0",selectType = "是客户端资产则必填",notes = "客户端的名称")
	private  String zzKhmc;
	@FileShow(fieldName = "资产性质",datatype = "CHAR",fieldSize = "4.0",selectType = "必填",notes = "资产的使用状态,MDM主数据，默认C001生产用")
	private  String ord43;
	@FileShow(fieldName = "作业成本资产类别",datatype = "CHAR",fieldSize = "6.0",selectType = "必填",notes = "用于维护ABC作业成本法需要的资产类别，以识别资产的网络元素属性，具体类别参见集团公司作业成本核算办法")
	private  String zzZclb;
	@FileShow(fieldName = "是否研发用资产",datatype = "CHAR",fieldSize = "1.0",selectType = "非必填",notes = "资产用于研发项目")
	private  String zzYfyzc;
	@FileShow(fieldName = "研发用工程编码",datatype = "CHAR",fieldSize = "24.0",selectType = "非必填，若研发资产用有填，则必填",notes = "研发项目的WBS")
	private  String zzYfgcbm;
	@FileShow(fieldName = "资产管理部门",datatype = "CHAR",fieldSize = "10.0",selectType = "必填",notes = "对资产进行实物管理的部门全称,统一目录，软件资产交资表叫“软件管理部门”")
	private  String zzSwgl;
	@FileShow(fieldName = "资产管理员",datatype = "CHAR",fieldSize = "14.0",selectType = "必填",notes = "资产具体管理人员,统一目录8位数字编码+@AH；上海，就是@SH；外协人员可能是11位数字编码，软件资产交资表叫“管理责任人”")
	private  String zzGly;
	@FileShow(fieldName = "使用部门",datatype = "CHAR",fieldSize = "10.0",selectType = "必填",notes = "资产实际使用部门全称,统一目录，软件资产交资表叫“软件需求部门”")
	private  String zzSybm;
	@FileShow(fieldName = "保管员",datatype = "CHAR",fieldSize = "14.0",selectType = "必填",notes = "资产具体保管人员,统一目录8位数字编码+@AH；上海，就是@SH；外协人员可能是11位数字编码，软件资产叫“建设维护责任人”")
	private  String zzBgy;
	@FileShow(fieldName = "使用人",datatype = "CHAR",fieldSize = "14.0",selectType = "必填",notes = "资产具体使用人员,统一目录8位数字编码+@AH；上海，就是@SH；外协人员可能是11位数字编码，软件资产叫“需求部门责任人”")
	private  String raumn;
	@FileShow(fieldName = "实物ID",datatype = "VARCHAR",fieldSize = "255",selectType = "非必填",notes = "填写实物管理部门管理实物资产所使用的编号,是该资产全生命周期的唯一身份标识，不随位置变动发生变化；实物ID在全国范围内唯一。")
	private String physicalId;
	@FileShow(fieldName = "成本中心",datatype = "CHAR",fieldSize = "10.0",selectType = "必填",notes = "按照基础核算系统中成本中心模块的主数据规范填写,MDM主数据")
	private  String kostl;
	@FileShow(fieldName = "区域编码",datatype = "CHAR",fieldSize = "10.0",selectType = "非必填",notes = "划小字段，所在区域地点编码,资产的具体所在位置编码，相当于地址范围的标准化；MDM主数据")
	private  String zzQybm;
	@FileShow(fieldName = "区县分公司",datatype = "CHAR",fieldSize = "8.0",selectType = "非必填",notes = "MDM主数据")
	private  String zzQxgs;
	@FileShow(fieldName = "支局",datatype = "CHAR",fieldSize = "8.0",selectType = "非必填",notes = "MDM主数据")
	private  String zzYxzx;
	@FileShow(fieldName = "营业厅机构ID",datatype = "CHAR",fieldSize = "50.0",selectType = "非必填",notes = "MDM主数据")
	private  String zzYytid;
	@FileShow(fieldName = "基站（机房）编码",datatype = "CHAR",fieldSize = "30.0",selectType = "非必填",notes = "自动带出资源的基站编码，可人工编辑")
	private  String zzJzid;
	@FileShow(fieldName = "基站（机房）名称",datatype = "VARCHAR2",fieldSize = "256.0",selectType = "基站编码有填则必填",notes = "自动带出资源的基站名称，可人工编辑")
	private  String basestatname;
	@FileShow(fieldName = "班组",datatype = "CHAR",fieldSize = "50.0",selectType = "非必填",notes = "MDM主数据")
	private  String zzBanz;
	@FileShow(fieldName = "设备投资（元）",datatype = "CURR",fieldSize = "13.0",selectType = "不填",notes = "null")
	private  Double zurwrt4;
	@FileShow(fieldName = "建安投资（元）",datatype = "CURR",fieldSize = "13.0",selectType = "不填",notes = "null")
	private  Double zurwrt2;
	@FileShow(fieldName = "待摊投资（元）",datatype = "CURR",fieldSize = "13.0",selectType = "不填",notes = "null")
	private  Double zurwrt3;
	@FileShow(fieldName = "合计（元）",datatype = "CURR",fieldSize = "13.0",selectType = "不填",notes = "null")
	private  Long total;
	@FileShow(fieldName = "资产卡片号",datatype = "CHAR",fieldSize = "12.0",selectType = "不填",notes = "资产卡片的编号，财务核算系统自动填写")
	private  String anln1;
	@FileShow(fieldName = "利润中心（组）",datatype = "CHAR",fieldSize = "10.0",selectType = "必填",notes = "工辅系统填写,MDM主数据")
	private  String prctr;
	@FileShow(fieldName = "产权凭证",datatype = "CHAR",fieldSize = "60.0",selectType = "非必填",notes = "填写房屋及建筑物的房产证或土地使用证车辆行驶证号码。其他设备可不填写")
	private  String zzChqnum;
	@FileShow(fieldName = "增加原因",datatype = "CHAR",fieldSize = "2.0",selectType = "非必填",notes = "资产的增加原因,固定资产默认”01在建工程转入”,软件资产默认“02购置”")
	private  String zzZjyy;
	@FileShow(fieldName = "折旧年限",datatype = "CHAR",fieldSize = "3.0",selectType = "必填",notes = "固定资产根据资产目录带出，不可修改。无形资产默认”10”，可修改。")
	private  String ndjar;
	@FileShow(fieldName = "其中：减值准备",datatype = "NUMBER(17,4)",fieldSize = "null",selectType = "非必填",notes = "null")
	private  Float jzzb;
	@FileShow(fieldName = "附属设备及附件",datatype = "CHAR",fieldSize = "60.0",selectType = "非必填",notes = "资产的附属设备及附件")
	private  String zzFssb;
	@FileShow(fieldName = "备注",datatype = "CHAR",fieldSize = "60.0",selectType = "非必填",notes = "资产附加说明")
	private  String zzBz;
	@FileShow(fieldName = "License号",datatype = "CHAR",fieldSize = "50.0",selectType = "非必填",notes = "01通用类软件选填")
	private  String zzLicense;
	@FileShow(fieldName = "许可方式",datatype = "CHAR",fieldSize = "1.0",selectType = "非必填",notes = "01通用类软件选填")
	private  String zzFz07;
	@FileShow(fieldName = "License到期日期",datatype = "DATS",fieldSize = "8.0",selectType = "非必填",notes = "01通用类软件选填")
	private  Date zzLdqrq;
	@FileShow(fieldName = "软件建设管理部门",datatype = "CHAR",fieldSize = "16.0",selectType = "非必填",notes = "传输空值，工辅自动添加；MDM主数据")
	private  String zzRjjsglbm;
	@FileShow(fieldName = "软件建设维护部门",datatype = "CHAR",fieldSize = "16.0",selectType = "非必填",notes = "为软件建设维护责任人所属的人员组织机构的部门，需依据软件建设维护责任人自动带出。")
	private  String zzRjjswhbm;
	@FileShow(fieldName = "出保约定期限（月）",datatype = "CHAR",fieldSize = "8.0",selectType = "非必填",notes = "02应用类软件选填")
	private  String zzCbrq;
	@FileShow(fieldName = "出保约定费率",datatype = "DEC",fieldSize = "(5,2)",selectType = "非必填",notes = "02应用类软件选填，两位小数，不用带%")
	private  Double zzCbydfl;
	@FileShow(fieldName = "出保约定费率",datatype = "DEC",fieldSize = "(5,2)",selectType = "非必填",notes = "02应用类软件选填，两位小数，不用带%")
	private java.util.Date createDate;
	@FileShow(fieldName = "出保约定费率",datatype = "DEC",fieldSize = "(5,2)",selectType = "非必填",notes = "02应用类软件选填，两位小数，不用带%")
	private java.util.Date editDate;








	public PmAssetMssback() {


	}

	public PmAssetMssback(BigInteger id) {
		this.id = id;
	}

	public void setId(BigInteger value) {
		System.out.println("====value"+value);
		this.id = value;
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setZgdj(String value) {
		this.zgdj = value;
	}

	public String getZgdj() {
		return this.zgdj;
	}

	public void setPosid(String value) {
		this.posid = value;
	}

	public String getPosid() {
		return this.posid;
	}

	public void setOsszseq(Long value) {
		this.osszseq = value;
	}

	public Long getOsszseq() {
		return this.osszseq;
	}

	public void setAgreeflag(String value) {
		this.agreeflag = value;
	}

	public String getAgreeflag() {
		return this.agreeflag;
	}

	public void setZzKrzc(String value) {
		this.zzKrzc = value;
	}

	public String getZzKrzc() {
		return this.zzKrzc;
	}

	public void setZzYzcbm(String value) {
		this.zzYzcbm = value;
	}

	public String getZzYzcbm() {
		return this.zzYzcbm;
	}

	public String getZzLicense() {
		return zzLicense;
	}

	public void setZzLicense(String zzLicense) {
		this.zzLicense = zzLicense;
	}

	public String getZzFz07() {
		return zzFz07;
	}

	public void setZzFz07(String zzFz07) {
		this.zzFz07 = zzFz07;
	}

	public Date getZzLdqrq() {
		return zzLdqrq;
	}

	public void setZzLdqrq(Date zzLdqrq) {
		this.zzLdqrq = zzLdqrq;
	}

	public String getZzRjjsglbm() {
		return zzRjjsglbm;
	}

	public void setZzRjjsglbm(String zzRjjsglbm) {
		this.zzRjjsglbm = zzRjjsglbm;
	}

	public String getZzRjjswhbm() {
		return zzRjjswhbm;
	}

	public void setZzRjjswhbm(String zzRjjswhbm) {
		this.zzRjjswhbm = zzRjjswhbm;
	}

	public String getZzCbrq() {
		return zzCbrq;
	}

	public void setZzCbrq(String zzCbrq) {
		this.zzCbrq = zzCbrq;
	}

	public Double getZzCbydfl() {
		return zzCbydfl;
	}

	public void setZzCbydfl(Double zzCbydfl) {
		this.zzCbydfl = zzCbydfl;
	}

	public void setAnlkl(String value) {
		this.anlkl = value;
	}

	public String getAnlkl() {
		return this.anlkl;
	}

	public void setZzKey(String value) {
		this.zzKey = value;
	}

	public String getZzKey() {
		return this.zzKey;
	}

	public void setTxt50(String value) {
		this.txt50 = value;
	}

	public String getTxt50() {
		return this.txt50;
	}

	public void setAnlhtxt(String value) {
		this.anlhtxt = value;
	}

	public String getAnlhtxt() {
		return this.anlhtxt;
	}

	public void setUseareacode(String value) {
		this.useareacode = value;
	}

	public String getUseareacode() {
		return this.useareacode;
	}

	public void setTxa50(String value) {
		this.txa50 = value;
	}

	public String getTxa50() {
		return this.txa50;
	}

	public void setMenge(Double value) {
		this.menge = value;
	}

	public Double getMenge() {
		return this.menge;
	}

	public void setMeins(String value) {
		this.meins = value;
	}

	public String getMeins() {
		return this.meins;
	}

	public void setAktiv(java.util.Date value) {
		this.aktiv = value;
	}

	public java.util.Date getAktiv() {
		return this.aktiv;
	}

	public void setHerst(String value) {
		this.herst = value;
	}

	public String getHerst() {
		return this.herst;
	}

	public void setOrd41(String value) {
		this.ord41 = value;
	}

	public String getOrd41() {
		return this.ord41;
	}

	public void setSpectype(String value) {
		this.spectype = value;
	}

	public String getSpectype() {
		return this.spectype;
	}

	public void setUrwrt(Double value) {
		this.urwrt = value;
	}

	public Double getUrwrt() {
		return this.urwrt;
	}

	public void setZzKhzc(String value) {
		this.zzKhzc = value;
	}

	public String getZzKhzc() {
		return this.zzKhzc;
	}

	public void setZzKhmc(String value) {
		this.zzKhmc = value;
	}

	public String getZzKhmc() {
		return this.zzKhmc;
	}

	public void setOrd43(String value) {
		this.ord43 = value;
	}

	public String getOrd43() {
		return this.ord43;
	}

	public void setZzZclb(String value) {
		this.zzZclb = value;
	}

	public String getZzZclb() {
		return this.zzZclb;
	}

	public void setZzYfyzc(String value) {
		this.zzYfyzc = value;
	}

	public String getZzYfyzc() {
		return this.zzYfyzc;
	}

	public void setZzYfgcbm(String value) {
		this.zzYfgcbm = value;
	}

	public String getZzYfgcbm() {
		return this.zzYfgcbm;
	}

	public void setZzSwgl(String value) {
		this.zzSwgl = value;
	}

	public String getZzSwgl() {
		return this.zzSwgl;
	}

	public void setZzGly(String value) {
		this.zzGly = value;
	}

	public String getZzGly() {
		return this.zzGly;
	}

	public void setZzSybm(String value) {
		this.zzSybm = value;
	}

	public String getZzSybm() {
		return this.zzSybm;
	}

	public void setZzBgy(String value) {
		this.zzBgy = value;
	}

	public String getZzBgy() {
		return this.zzBgy;
	}

	public void setRaumn(String value) {
		this.raumn = value;
	}

	public String getRaumn() {
		return this.raumn;
	}

	public void setKostl(String value) {
		this.kostl = value;
	}

	public String getKostl() {
		return this.kostl;
	}

	public void setPhysicalId(String value) {
		this.physicalId = value;
	}

	public String getPhysicalId() {
		return this.physicalId;
	}

	public void setZzQybm(String value) {
		this.zzQybm = value;
	}

	public String getZzQybm() {
		return this.zzQybm;
	}

	public void setZzQxgs(String value) {
		this.zzQxgs = value;
	}

	public String getZzQxgs() {
		return this.zzQxgs;
	}

	public void setZzYxzx(String value) {
		this.zzYxzx = value;
	}

	public String getZzYxzx() {
		return this.zzYxzx;
	}

	public void setZzYytid(String value) {
		this.zzYytid = value;
	}

	public String getZzYytid() {
		return this.zzYytid;
	}

	public void setZzJzid(String value) {
		this.zzJzid = value;
	}

	public String getZzJzid() {
		return this.zzJzid;
	}

	public void setBasestatname(String value) {
		this.basestatname = value;
	}

	public String getBasestatname() {
		return this.basestatname;
	}

	public void setZzBanz(String value) {
		this.zzBanz = value;
	}

	public String getZzBanz() {
		return this.zzBanz;
	}

	public void setZurwrt4(Double value) {
		this.zurwrt4 = value;
	}

	public Double getZurwrt4() {
		return this.zurwrt4;
	}

	public void setZurwrt2(Double value) {
		this.zurwrt2 = value;
	}

	public Double getZurwrt2() {
		return this.zurwrt2;
	}

	public void setZurwrt3(Double value) {
		this.zurwrt3 = value;
	}

	public Double getZurwrt3() {
		return this.zurwrt3;
	}

	public void setTotal(Long value) {
		this.total = value;
	}

	public Long getTotal() {
		return this.total;
	}

	public void setAnln1(String value) {
		this.anln1 = value;
	}

	public String getAnln1() {
		return this.anln1;
	}

	public void setPrctr(String value) {
		this.prctr = value;
	}

	public String getPrctr() {
		return this.prctr;
	}

	public void setZzChqnum(String value) {
		this.zzChqnum = value;
	}

	public String getZzChqnum() {
		return this.zzChqnum;
	}

	public void setZzZjyy(String value) {
		this.zzZjyy = value;
	}

	public String getZzZjyy() {
		return this.zzZjyy;
	}

	public void setNdjar(String value) {
		this.ndjar = value;
	}

	public String getNdjar() {
		return this.ndjar;
	}

	public void setJzzb(Float value) {
		this.jzzb = value;
	}

	public Float getJzzb() {
		return this.jzzb;
	}

	public void setZzFssb(String value) {
		this.zzFssb = value;
	}

	public String getZzFssb() {
		return this.zzFssb;
	}

	public void setZzBz(String value) {
		this.zzBz = value;
	}

	public String getZzBz() {
		return this.zzBz;
	}

	public void setCreateDate(java.util.Date value) {
		this.createDate = value;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	public void setEditDate(java.util.Date value) {
		this.editDate = value;
	}

	public java.util.Date getEditDate() {
		return this.editDate;
	}
	

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Zgdj",getZgdj())
			.append("Posid",getPosid())
			.append("Osszseq",getOsszseq())
			.append("Agreeflag",getAgreeflag())
			.append("ZzKrzc",getZzKrzc())
			.append("ZzYzcbm",getZzYzcbm())
			.append("ZzLicense",getZzLicense())
			.append("ZzFz07",getZzFz07())
			.append("ZzLdqrq",getZzLdqrq())
			.append("ZzRjjsglbm",getZzRjjsglbm())
			.append("ZzRjjswhbm",getZzRjjswhbm())
			.append("ZzCbrq",getZzCbrq())
			.append("ZzCbydfl",getZzCbydfl())
			.append("Anlkl",getAnlkl())
			.append("ZzKey",getZzKey())
			.append("Txt50",getTxt50())
			.append("Anlhtxt",getAnlhtxt())
			.append("Useareacode",getUseareacode())
			.append("Txa50",getTxa50())
			.append("Menge",getMenge())
			.append("Meins",getMeins())
			.append("Aktiv",getAktiv())
			.append("Herst",getHerst())
			.append("Ord41",getOrd41())
			.append("Spectype",getSpectype())
			.append("Urwrt",getUrwrt())
			.append("ZzKhzc",getZzKhzc())
			.append("ZzKhmc",getZzKhmc())
			.append("Ord43",getOrd43())
			.append("ZzZclb",getZzZclb())
			.append("ZzYfyzc",getZzYfyzc())
			.append("ZzYfgcbm",getZzYfgcbm())
			.append("ZzSwgl",getZzSwgl())
			.append("ZzGly",getZzGly())
			.append("ZzSybm",getZzSybm())
			.append("ZzBgy",getZzBgy())
			.append("Raumn",getRaumn())
			.append("Kostl",getKostl())
			.append("PhysicalId",getPhysicalId())
			.append("ZzQybm",getZzQybm())
			.append("ZzQxgs",getZzQxgs())
			.append("ZzYxzx",getZzYxzx())
			.append("ZzYytid",getZzYytid())
			.append("ZzJzid",getZzJzid())
			.append("Basestatname",getBasestatname())
			.append("ZzBanz",getZzBanz())
			.append("Zurwrt4",getZurwrt4())
			.append("Zurwrt2",getZurwrt2())
			.append("Zurwrt3",getZurwrt3())
			.append("Total",getTotal())
			.append("Anln1",getAnln1())
			.append("Prctr",getPrctr())
			.append("ZzChqnum",getZzChqnum())
			.append("ZzZjyy",getZzZjyy())
			.append("Ndjar",getNdjar())
			.append("Jzzb",getJzzb())
			.append("ZzFssb",getZzFssb())
			.append("ZzBz",getZzBz())
			.append("CreateDate",getCreateDate())
			.append("EditDate",getEditDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof PmAssetMssback)){
			return false;
		} 
		if(this == obj){
			return true;
		} 
		PmAssetMssback other = (PmAssetMssback)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

