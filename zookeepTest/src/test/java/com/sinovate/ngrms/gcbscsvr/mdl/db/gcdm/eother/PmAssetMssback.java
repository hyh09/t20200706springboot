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
	@Length(max=255)

	private String zgdj;
//	@Length(max=32)
	private String posid;

	@Conf("70000144683774")//初始化的默认值
	@FileShow(fieldName = "OSS转固资产序号",fieldSize = "17",selectType = "必填",notes = "资产在转固资产中的流水编码，在OSS的所有交资表中唯一,前2位省编码,安徽11,上海30")
	private Long osszseq;
	@Length(max=1)
	private String agreeflag;
	@Length(max=1)
	private String zzKrzc;
	@Length(max=32)
	private String zzYzcbm;
	@Length(max=50)
	private String zzLicense;
	@Length(max=1)
	private String zzFz07;

	private java.util.Date zzLdqrq;
	@Length(max=16)
	private String zzRjjsglbm;
	@Length(max=16)
	private String zzRjjswhbm;

	@Conf("")//初始化的默认值
	@FileShow(fieldName = "出保約定期限（月）",datatype = "CHAR",fieldSize = "8",selectType = "非必填",notes = "02应用类软件选填")
	private String zzCbrq;

	private Double zzCbydfl;
	@Length(max=16)
	private String anlkl;
	@Length(max=24)
	private String zzKey;
	@Length(max=64)
	private String txt50;
	@Length(max=64)
	private String anlhtxt;
	@Length(max=24)
	private String useareacode;
	@Length(max=64)
	private String txa50;

	private Double menge;
	@Length(max=32)
	private String meins;

	private java.util.Date aktiv;
	@Length(max=48)
	private String herst;
	@Length(max=16)
	private String ord41;
	@Length(max=64)
	private String spectype;

	private Double urwrt;
	@Length(max=1)
	private String zzKhzc;
	@Length(max=64)
	private String zzKhmc;
	@Length(max=16)
	private String ord43;
	@Length(max=16)
	private String zzZclb;
	@Length(max=1)
	private String zzYfyzc;
	@Length(max=32)
	private String zzYfgcbm;
	@Length(max=16)
	private String zzSwgl;
	@Length(max=16)
	private String zzGly;
	@Length(max=16)
	private String zzSybm;
	@Length(max=16)
	private String zzBgy;
	@Length(max=16)
	private String raumn;
	@Length(max=16)
	private String kostl;
	@Length(max=32)
	private String physicalId;
	@Length(max=16)
	private String zzQybm;
	@Length(max=16)
	private String zzQxgs;
	@Length(max=16)
	private String zzYxzx;
	@Length(max=64)
	private String zzYytid;
	@Length(max=32)
	private String zzJzid;
	@Length(max=256)
	private String basestatname;
	@Length(max=50)
	private String zzBanz;

	private Double zurwrt4;

	private Double zurwrt2;

	private Double zurwrt3;

	private Long total;
	@Length(max=16)
	private String anln1;
	@Length(max=16)
	private String prctr;
	@Length(max=64)
	private String zzChqnum;
	@Length(max=16)
	private String zzZjyy;
	@Length(max=4)
	private String ndjar;

	private Float jzzb;
	@Length(max=64)
	private String zzFssb;
	@Length(max=128)
	private String zzBz;

	private java.util.Date createDate;

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

