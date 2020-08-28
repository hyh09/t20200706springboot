package com.utltl.exceltool.mobansanm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.utltl.exceltool.beansvc.Conf;
import com.utltl.exceltool.beansvc.FileShow;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 资产卡片信息同步接口
 * Created by luyangran on 2019/8/30.
 * 本类Bo仅用于Dcoos接口传参，字段需跟数据库保持一致
 */
public class AssetCardBo implements Serializable {

    private static final long serialVersionUID = -2580534208976641903L;

    public static final String TABLE_NAME = "RM_ASSET";

    public static final String TABLE_ALIAS = "RmAsset";

    public static final String COL_ID = "ID";

    public static final String COL_SPECID = "SPEC_ID";

    public static final String COL_CREATORID = "CREATOR_ID";

    public static final String COL_CREATEDATE = "CREATE_DATE";

    public static final String COL_MODIFIERID = "MODIFIER_ID";

    public static final String COL_MODIFYDATE = "MODIFY_DATE";

    public static final String COL_VERSION = "VERSION";

    public static final String COL_SHARDINGID = "SHARDING_ID";

    public static final String COL_BUKRS = "BUKRS";

    public static final String COL_OSSZSEQ = "OSSZSEQ";

    public static final String COL_ASSETSCARDCODE = "ASSETSCARDCODE";

    public static final String COL_SECONDARYASSETSCARDCODE = "SECONDARYASSETSCARDCODE";

    public static final String COL_ISESTIMATE = "ISESTIMATE";

    public static final String COL_ASSETCATALOGUE = "ASSET_CATALOGUE";

    public static final String COL_ASSETSTYPE = "ASSETSTYPE";

    public static final String COL_DESCRIPTION = "DESCRIPTION";

    public static final String COL_WORKCOSTTYPE = "WORKCOSTTYPE";

    public static final String COL_NAMBERUNIT = "NAMBERUNIT";

    public static final String COL_PNUMBER = "PNUMBER";

    public static final String COL_MANUFACTURER = "MANUFACTURER";

    public static final String COL_STANDARD = "STANDARD";

    public static final String COL_ADDRESS = "ADDRESS";

    public static final String COL_MANAGEDEPARTMENT = "MANAGEDEPARTMENT";

    public static final String COL_USEDEPARTMENT = "USEDEPARTMENT";

    public static final String COL_COSTCENTER = "COSTCENTER";

    public static final String COL_SUPERVISOR = "SUPERVISOR";

    public static final String COL_ASSETCUSTODIAN = "ASSETCUSTODIAN";

    public static final String COL_ASSETKEEPER = "ASSETKEEPER";

    public static final String COL_CAPITALDATE = "CAPITALDATE";

    public static final String COL_WBS = "WBS";

    public static final String COL_ASSETSRELEGATION = "ASSETSRELEGATION";

    public static final String COL_ISCLIENTASSET = "ISCLIENTASSET";

    public static final String COL_CLIENTNAME = "CLIENTNAME";

    public static final String COL_ASSETSNATURE = "ASSETSNATURE";

    public static final String COL_NOTES = "NOTES";

    public static final String COL_ABCTYPE = "ABCTYPE";

    public static final String COL_ADDTIONREASON = "ADDTIONREASON";

    public static final String COL_ACCESSORY = "ACCESSORY";

    public static final String COL_PGYZ = "PGYZ";

    public static final String COL_PGLJZJ = "PGLJZJ";

    public static final String COL_PGLJJZ = "PGLJJZ";

    public static final String COL_ISHELDFORSALE = "ISHELDFORSALE";

    public static final String COL_ISOVERAGE = "ISOVERAGE";

    public static final String COL_ISFORSRCAP = "ISFORSRCAP";

    public static final String COL_ISIDLE = "ISIDLE";

    public static final String COL_ISDEVELOPASSET = "ISDEVELOPASSET";

    public static final String COL_AREACODE = "AREACODE";

    public static final String COL_COUNTYOFFICES = "COUNTYOFFICES";

    public static final String COL_BRANCH = "BRANCH";

    public static final String COL_BUSINESSOFFICEID = "BUSINESSOFFICEID";

    public static final String COL_BTSCODE = "BTSCODE";

    public static final String COL_TEAM = "TEAM";

    public static final String COL_ISEXPANSION = "ISEXPANSION";

    public static final String COL_ISIMPAIRMENT = "ISIMPAIRMENT";

    public static final String COL_DEPRECIAERANGE1 = "DEPRECIAERANGE1";

    public static final String COL_DEPRECIAECODE1 = "DEPRECIAECODE1";

    public static final String COL_DEPRECIAERANGE2 = "DEPRECIAERANGE2";

    public static final String COL_DEPRECIAECODE2 = "DEPRECIAECODE2";

    public static final String COL_USEFULLIFE1 = "USEFULLIFE1";

    public static final String COL_PERIOD1 = "PERIOD1";

    public static final String COL_USEFULLIFE2 = "USEFULLIFE2";

    public static final String COL_PERIOD2 = "PERIOD2";

    public static final String COL_COSTVALUE = "COSTVALUE";

    public static final String COL_DEPRECIATION = "DEPRECIATION";

    public static final String COL_IMPAIRMENTSUM = "IMPAIRMENTSUM";

    public static final String COL_NETVALUE = "NETVALUE";

    public static final String COL_POSITIONCODE = "POSITIONCODE";

    public static final String COL_INACTIVEDATE = "INACTIVEDATE";

    public static final String COL_PURCHASEDATE = "PURCHASEDATE";

    public static final String COL_PURCHASEYEAR = "PURCHASEYEAR";

    public static final String COL_FIRSTBILLING = "FIRSTBILLING";

    public static final String COL_ISDISABLE = "ISDISABLE";

    public static final String COL_ORIGINALASSET = "ORIGINALASSET";

    public static final String COL_DEVELOPASSET = "DEVELOPASSET";

    public static final String COL_ISRENT = "ISRENT";

    public static final String COL_ISLEASE = "ISLEASE";

    public static final String COL_CREDENTIALS = "CREDENTIALS";

    public static final String COL_DEMOLITIONSTATU = "DEMOLITIONSTATU";

    public static final String COL_WBSELEMENT = "WBSELEMENT";

    public static final String COL_USEFULMONTHS = "USEFULMONTHS";

    public static final String COL_SOURCEASSETNO = "SOURCEASSETNO";

    public static final String COL_ZZLICENSE = "ZZ_LICENSE";

    public static final String COL_ZZFZ07 = "ZZ_FZ07";

    public static final String COL_ZZLDQRQ = "ZZ_LDQRQ";

    public static final String COL_ZZRJJSGLBM = "ZZ_RJJSGLBM";

    public static final String COL_ZZRJJSWHBM = "ZZ_RJJSWHBM";

    public static final String COL_ZZPGZ = "ZZ_PGZ";

    public static final String COL_ZZCBRQ = "ZZ_CBRQ";

    public static final String COL_ZZCBYDFL = "ZZ_CBYDFL";



    //添加三个字段,并将出保日期  date改为 String  ZZ_CBRQ  zzCbrq
    public  static  final String COL_ASSETCUSTODIANACCOUNT="assetcustodianAccount";


    public  static  final String COL_ASSETKEEPERACCOUNT="assetkeeperAccount";


    public  static  final String COL_ZZFPZC="zzfpzc";




    @Conf("341033000000000427382272")
    @FileShow(fieldName = "ID",datatype = "Integer",fieldSize = "24.0",selectType = "必填",notes = "ID")
    private  BigInteger id;

    @Conf("2920100001")
    @FileShow(fieldName = "规格ID",datatype = "Integer",fieldSize = "13.0",selectType = "null",notes = "规格ID")
    private  Long specId;

    @Conf("1")
    @FileShow(fieldName = "创建人ID",datatype = "Integer",fieldSize = "24.0",selectType = "必填",notes = "创建人ID")
    private  BigInteger creatorId;

    @FileShow(fieldName = "创建时间",datatype = "DATE",fieldSize = "null",selectType = "必填",notes = "创建时间")
    private  Date createDate;
    @FileShow(fieldName = "修改人ID",datatype = "Integer",fieldSize = "24.0",selectType = "必填",notes = "修改人ID")
    private  BigInteger modifierId;
    @FileShow(fieldName = "修改时间",datatype = "DATE",fieldSize = "null",selectType = "必填",notes = "修改时间")
    private  Date modifyDate;
    @FileShow(fieldName = "版本",datatype = "Integer",fieldSize = "24.0",selectType = "必填",notes = "版本")
    private  BigInteger version;
    @FileShow(fieldName = "分片ID",datatype = "Integer",fieldSize = "24.0",selectType = "必填",notes = "分片ID")
    private  BigInteger shardingId;
    @FileShow(fieldName = "公司代码",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "公司代码")
    private  BigInteger bukrs;
    @FileShow(fieldName = "OSS转固资产序号",datatype = "String",fieldSize = "17.0",selectType = "null",notes = "OSS转固资产序号")
    private  String osszseq;
    @FileShow(fieldName = "资产卡片号",datatype = "String",fieldSize = "100.0",selectType = "必填",notes = "资产卡片号")
    private  String assetscardcode;
    @FileShow(fieldName = "资产次级编号",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "资产次级编号")
    private  String secondaryassetscardcode;
    @FileShow(fieldName = "是否暂估资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否暂估资产")
    private  Integer isestimate;
    @FileShow(fieldName = "资产目录",datatype = "String",fieldSize = "64.0",selectType = "null",notes = "资产目录")
    private  String assetCatalogue;
    @FileShow(fieldName = "资产分类",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "资产分类")
    private  BigInteger assetstype;
    @FileShow(fieldName = "描述",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "描述")
    private  String description;
    @FileShow(fieldName = "作业成本资产类别",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "作业成本资产类别")
    private  BigInteger workcosttype;
    @FileShow(fieldName = "单位",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "单位")
    private  BigInteger namberunit;
    @FileShow(fieldName = "数量",datatype = "String",fieldSize = "20.0",selectType = "null",notes = "数量")
    private  String pnumber;
    @FileShow(fieldName = "制造商",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "制造商")
    private  String manufacturer;
    @FileShow(fieldName = "结构规格程式",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "结构规格程式")
    private  String standard;
    @FileShow(fieldName = "地址",datatype = "String",fieldSize = "null",selectType = "null",notes = "地址")
    private  String address;
    @FileShow(fieldName = "实物管理部门",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "实物管理部门")
    private  BigInteger managedepartment;
    @FileShow(fieldName = "使用部门",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "使用部门")
    private  BigInteger usedepartment;
    @FileShow(fieldName = "成本中心",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "成本中心")
    private  BigInteger costcenter;
    @FileShow(fieldName = "责任人（姓名）",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "责任人（姓名）")
    private  String supervisor;
    @FileShow(fieldName = "资产管理员",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "资产管理员")
    private  String assetcustodian;
    @FileShow(fieldName = "保管员",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "保管员")
    private  String assetkeeper;
    @FileShow(fieldName = "资本化日期",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "资本化日期")
    private  String capitaldate;
    @FileShow(fieldName = "WBS号",datatype = "String",fieldSize = "24.0",selectType = "null",notes = "WBS号")
    private  String wbs;
    @FileShow(fieldName = "资产归属",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "资产归属")
    private  BigInteger assetsrelegation;
    @FileShow(fieldName = "是否客户端资产",datatype = "String",fieldSize = "10.0",selectType = "null",notes = "是否客户端资产")
    private  String isclientasset;
    @FileShow(fieldName = "客户名称",datatype = "String",fieldSize = "120.0",selectType = "null",notes = "客户名称")
    private  String clientname;
    @FileShow(fieldName = "资产性质",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "资产性质")
    private  String assetsnature;
    @FileShow(fieldName = "备注",datatype = "String",fieldSize = "200.0",selectType = "null",notes = "备注")
    private  String notes;
    @FileShow(fieldName = "ABC类",datatype = "String",fieldSize = "1.0",selectType = "null",notes = "ABC类")
    private  String abctype;
    @FileShow(fieldName = "增加原因",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "增加原因")
    private  BigInteger addtionreason;
    @FileShow(fieldName = "附属设备及附件",datatype = "String",fieldSize = "500.0",selectType = "null",notes = "附属设备及附件")
    private  String accessory;
    @FileShow(fieldName = "评估前原值",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "评估前原值")
    private  Double pgyz;
    @FileShow(fieldName = "评估累计折旧",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "评估累计折旧")
    private  Double pgljzj;
    @FileShow(fieldName = "评估累计减值",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "评估累计减值")
    private  Double pgljjz;
    @FileShow(fieldName = "是否持有待售资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否持有待售资产")
    private  Integer isheldforsale;
    @FileShow(fieldName = "是否逾龄资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否逾龄资产")
    private  Integer isoverage;
    @FileShow(fieldName = "是否待报废",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否待报废")
    private  Integer isforsrcap;
    @FileShow(fieldName = "是否闲置资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否闲置资产")
    private  Integer isidle;
    @FileShow(fieldName = "是否研发产生资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否研发产生资产")
    private  Integer isdevelopasset;
    @FileShow(fieldName = "区域编码",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "区域编码")
    private  BigInteger areacode;
    @FileShow(fieldName = "区县分公司",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "区县分公司")
    private  BigInteger countyoffices;
    @FileShow(fieldName = "支局",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "支局")
    private  BigInteger branch;
    @FileShow(fieldName = "营业厅机构ID",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "营业厅机构ID")
    private  BigInteger businessofficeid;
    @FileShow(fieldName = "基站（机房）",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "基站（机房）")
    private  BigInteger btscode;
    @FileShow(fieldName = "班组",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "班组")
    private  BigInteger team;
    @FileShow(fieldName = "是否扩容资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否扩容资产")
    private  Integer isexpansion;
    @FileShow(fieldName = "是否减值资产",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否减值资产")
    private  Integer isimpairment;
    @FileShow(fieldName = "折旧范围1",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "折旧范围1")
    private  BigInteger depreciaerange1;
    @FileShow(fieldName = "折旧码1",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "折旧码1")
    private  BigInteger depreciaecode1;
    @FileShow(fieldName = "折旧范围2",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "折旧范围2")
    private  BigInteger depreciaerange2;
    @FileShow(fieldName = "折旧码2",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "折旧码2")
    private  BigInteger depreciaecode2;
    @FileShow(fieldName = "使用年限1",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "使用年限1")
    private  String usefullife1;
    @FileShow(fieldName = "期间1",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "期间1")
    private  String period1;
    @FileShow(fieldName = "使用年限2",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "使用年限2")
    private  String usefullife2;
    @FileShow(fieldName = "期间2",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "期间2")
    private  String period2;
    @FileShow(fieldName = "资产原值",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "资产原值")
    private  Double costvalue;
    @FileShow(fieldName = "累计折旧",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "累计折旧")
    private  Double depreciation;
    @FileShow(fieldName = "减值金额",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "减值金额")
    private  Double impairmentsum;
    @FileShow(fieldName = "资产净值",datatype = "Integer",fieldSize = "(19,4)",selectType = "null",notes = "资产净值")
    private  Double netvalue;
    @FileShow(fieldName = "科目定位码",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "科目定位码")
    private  BigInteger positioncode;
    @FileShow(fieldName = "不活动日期",datatype = "DATE",fieldSize = "null",selectType = "null",notes = "不活动日期")
    private  Date inactivedate;
    @FileShow(fieldName = "首次购置日期",datatype = "DATE",fieldSize = "null",selectType = "null",notes = "首次购置日期")
    private  Date purchasedate;
    @FileShow(fieldName = "购置年度",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "购置年度")
    private  String purchaseyear;
    @FileShow(fieldName = "首次购置记帐的期间",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "首次购置记帐的期间")
    private  String firstbilling;
    @FileShow(fieldName = "是否资产停用",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否资产停用")
    private  Integer isdisable;
    @FileShow(fieldName = "原资产号码",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "原资产号码")
    private  String originalasset;
    @FileShow(fieldName = "研发用资产",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "研发用资产")
    private  String developasset;
    @FileShow(fieldName = "是否出租",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否出租")
    private  Integer isrent;
    @FileShow(fieldName = "是否融资租入",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否融资租入")
    private  Integer islease;
    @FileShow(fieldName = "产权凭证",datatype = "String",fieldSize = "120.0",selectType = "null",notes = "产权凭证")
    private  String credentials;
    @FileShow(fieldName = "折旧状况",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "折旧状况")
    private  String demolitionstatu;
    @FileShow(fieldName = "WBS元素",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "WBS元素")
    private  String wbselement;
    @FileShow(fieldName = "评估尚可使用月份",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "评估尚可使用月份")
    private  String usefulmonths;
    @FileShow(fieldName = "源资产号码",datatype = "String",fieldSize = "24.0",selectType = "null",notes = "源资产号码")
    private  String sourceassetno;
    @FileShow(fieldName = "是否父卡",datatype = "Integer",fieldSize = "8.0",selectType = "null",notes = "是否父卡")
    private  String isparent;
    @FileShow(fieldName = "耐用年限",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "耐用年限")
    private  String durablelife;
    @FileShow(fieldName = "父资产ID",datatype = "Integer",fieldSize = "24.0",selectType = "null",notes = "父资产ID")
    private  String parentAssetId;
    @FileShow(fieldName = "License号",datatype = "String",fieldSize = "100.0",selectType = "null",notes = "License号")
    private  String zzLicense;
    @FileShow(fieldName = "许可方式",datatype = "String",fieldSize = "2.0",selectType = "null",notes = "许可方式")
    private  String zzFz07;
    @FileShow(fieldName = "License到期日期",datatype = "DATE",fieldSize = "null",selectType = "null",notes = "License到期日期")
    private  Date zzLdqrq;
    @FileShow(fieldName = "软件建设管理部门",datatype = "String",fieldSize = "32.0",selectType = "null",notes = "软件建设管理部门")
    private  String zzRjjsglbm;
    @FileShow(fieldName = "软件建设维护部门",datatype = "String",fieldSize = "32.0",selectType = "null",notes = "软件建设维护部门")
    private  String zzRjjswhbm;
    @FileShow(fieldName = "评估值",datatype = "Integer",fieldSize = "(13,2)",selectType = "null",notes = "评估值")
    private  Double zzPgz;
    @FileShow(fieldName = "出保约定期限（月）",datatype = "String",fieldSize = "8.0",selectType = "null",notes = "出保约定期限（月）")
    private  String zzCbrq;
    @FileShow(fieldName = "出保约定费率",datatype = "Integer",fieldSize = "(5,2)",selectType = "null",notes = "出保约定费率")
    private  Double zzCbydfl;
    @FileShow(fieldName = "sap资产分类",datatype = "String",fieldSize = "255.0",selectType = "null",notes = "sap资产分类")
    private  String anlkl;
    @FileShow(fieldName = "资产管理员账号",datatype = "String",fieldSize = "25.0",selectType = "null",notes = "资产管理员账号")
    private  String assetcustodianAccount;
    @FileShow(fieldName = "资产保管员账号",datatype = "String",fieldSize = "25.0",selectType = "null",notes = "资产保管员账号")
    private  String assetkeeperAccount;
    @FileShow(fieldName = "是否扶贫资产",datatype = "String",fieldSize = "25.0",selectType = "null",notes = "是否扶贫资产")
    private  String zzfpzc;



    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public BigInteger getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(BigInteger creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigInteger getModifierId() {
        return modifierId;
    }

    public void setModifierId(BigInteger modifierId) {
        this.modifierId = modifierId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getShardingId() {
        return shardingId;
    }

    public void setShardingId(BigInteger shardingId) {
        this.shardingId = shardingId;
    }

    public BigInteger getBukrs() {
        return bukrs;
    }

    public void setBukrs(BigInteger bukrs) {
        this.bukrs = bukrs;
    }

    public String getOsszseq() {
        return osszseq;
    }

    public void setOsszseq(String osszseq) {
        this.osszseq = osszseq;
    }

    public String getAssetscardcode() {
        return assetscardcode;
    }

    public void setAssetscardcode(String assetscardcode) {
        this.assetscardcode = assetscardcode;
    }

    public String getSecondaryassetscardcode() {
        return secondaryassetscardcode;
    }

    public void setSecondaryassetscardcode(String secondaryassetscardcode) {
        this.secondaryassetscardcode = secondaryassetscardcode;
    }

    public Integer getIsestimate() {
        return isestimate;
    }

    public void setIsestimate(Integer isestimate) {
        this.isestimate = isestimate;
    }

    public String getAssetCatalogue() {
        return assetCatalogue;
    }

    public void setAssetCatalogue(String assetCatalogue) {
        this.assetCatalogue = assetCatalogue;
    }

    public BigInteger getAssetstype() {
        return assetstype;
    }

    public void setAssetstype(BigInteger assetstype) {
        this.assetstype = assetstype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getWorkcosttype() {
        return workcosttype;
    }

    public void setWorkcosttype(BigInteger workcosttype) {
        this.workcosttype = workcosttype;
    }

    public BigInteger getNamberunit() {
        return namberunit;
    }

    public void setNamberunit(BigInteger namberunit) {
        this.namberunit = namberunit;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getManagedepartment() {
        return managedepartment;
    }

    public void setManagedepartment(BigInteger managedepartment) {
        this.managedepartment = managedepartment;
    }

    public BigInteger getUsedepartment() {
        return usedepartment;
    }

    public void setUsedepartment(BigInteger usedepartment) {
        this.usedepartment = usedepartment;
    }

    public BigInteger getCostcenter() {
        return costcenter;
    }

    public void setCostcenter(BigInteger costcenter) {
        this.costcenter = costcenter;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAssetcustodian() {
        return assetcustodian;
    }

    public void setAssetcustodian(String assetcustodian) {
        this.assetcustodian = assetcustodian;
    }

    public String getAssetkeeper() {
        return assetkeeper;
    }

    public void setAssetkeeper(String assetkeeper) {
        this.assetkeeper = assetkeeper;
    }

    public String getCapitaldate() {
        return capitaldate;
    }

    public void setCapitaldate(String capitaldate) {
        this.capitaldate = capitaldate;
    }

    public String getWbs() {
        return wbs;
    }

    public void setWbs(String wbs) {
        this.wbs = wbs;
    }

    public BigInteger getAssetsrelegation() {
        return assetsrelegation;
    }

    public void setAssetsrelegation(BigInteger assetsrelegation) {
        this.assetsrelegation = assetsrelegation;
    }

    public String getIsclientasset() {
        return isclientasset;
    }

    public void setIsclientasset(String isclientasset) {
        this.isclientasset = isclientasset;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getAssetsnature() {
        return assetsnature;
    }

    public void setAssetsnature(String assetsnature) {
        this.assetsnature = assetsnature;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAbctype() {
        return abctype;
    }

    public void setAbctype(String abctype) {
        this.abctype = abctype;
    }

    public BigInteger getAddtionreason() {
        return addtionreason;
    }

    public void setAddtionreason(BigInteger addtionreason) {
        this.addtionreason = addtionreason;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public Double getPgyz() {
        return pgyz;
    }

    public void setPgyz(Double pgyz) {
        this.pgyz = pgyz;
    }

    public Double getPgljzj() {
        return pgljzj;
    }

    public void setPgljzj(Double pgljzj) {
        this.pgljzj = pgljzj;
    }

    public Double getPgljjz() {
        return pgljjz;
    }

    public void setPgljjz(Double pgljjz) {
        this.pgljjz = pgljjz;
    }

    public Integer getIsheldforsale() {
        return isheldforsale;
    }

    public void setIsheldforsale(Integer isheldforsale) {
        this.isheldforsale = isheldforsale;
    }

    public Integer getIsoverage() {
        return isoverage;
    }

    public void setIsoverage(Integer isoverage) {
        this.isoverage = isoverage;
    }

    public Integer getIsforsrcap() {
        return isforsrcap;
    }

    public void setIsforsrcap(Integer isforsrcap) {
        this.isforsrcap = isforsrcap;
    }

    public Integer getIsidle() {
        return isidle;
    }

    public void setIsidle(Integer isidle) {
        this.isidle = isidle;
    }

    public Integer getIsdevelopasset() {
        return isdevelopasset;
    }

    public void setIsdevelopasset(Integer isdevelopasset) {
        this.isdevelopasset = isdevelopasset;
    }

    public BigInteger getAreacode() {
        return areacode;
    }

    public void setAreacode(BigInteger areacode) {
        this.areacode = areacode;
    }

    public BigInteger getCountyoffices() {
        return countyoffices;
    }

    public void setCountyoffices(BigInteger countyoffices) {
        this.countyoffices = countyoffices;
    }

    public BigInteger getBranch() {
        return branch;
    }

    public void setBranch(BigInteger branch) {
        this.branch = branch;
    }

    public BigInteger getBusinessofficeid() {
        return businessofficeid;
    }

    public void setBusinessofficeid(BigInteger businessofficeid) {
        this.businessofficeid = businessofficeid;
    }

    public BigInteger getBtscode() {
        return btscode;
    }

    public void setBtscode(BigInteger btscode) {
        this.btscode = btscode;
    }

    public BigInteger getTeam() {
        return team;
    }

    public void setTeam(BigInteger team) {
        this.team = team;
    }

    public Integer getIsexpansion() {
        return isexpansion;
    }

    public void setIsexpansion(Integer isexpansion) {
        this.isexpansion = isexpansion;
    }

    public Integer getIsimpairment() {
        return isimpairment;
    }

    public void setIsimpairment(Integer isimpairment) {
        this.isimpairment = isimpairment;
    }

    public BigInteger getDepreciaerange1() {
        return depreciaerange1;
    }

    public void setDepreciaerange1(BigInteger depreciaerange1) {
        this.depreciaerange1 = depreciaerange1;
    }

    public BigInteger getDepreciaecode1() {
        return depreciaecode1;
    }

    public void setDepreciaecode1(BigInteger depreciaecode1) {
        this.depreciaecode1 = depreciaecode1;
    }

    public BigInteger getDepreciaerange2() {
        return depreciaerange2;
    }

    public void setDepreciaerange2(BigInteger depreciaerange2) {
        this.depreciaerange2 = depreciaerange2;
    }

    public BigInteger getDepreciaecode2() {
        return depreciaecode2;
    }

    public void setDepreciaecode2(BigInteger depreciaecode2) {
        this.depreciaecode2 = depreciaecode2;
    }

    public String getUsefullife1() {
        return usefullife1;
    }

    public void setUsefullife1(String usefullife1) {
        this.usefullife1 = usefullife1;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getUsefullife2() {
        return usefullife2;
    }

    public void setUsefullife2(String usefullife2) {
        this.usefullife2 = usefullife2;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public Double getCostvalue() {
        return costvalue;
    }

    public void setCostvalue(Double costvalue) {
        this.costvalue = costvalue;
    }

    public Double getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(Double depreciation) {
        this.depreciation = depreciation;
    }

    public Double getImpairmentsum() {
        return impairmentsum;
    }

    public void setImpairmentsum(Double impairmentsum) {
        this.impairmentsum = impairmentsum;
    }

    public Double getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(Double netvalue) {
        this.netvalue = netvalue;
    }

    public BigInteger getPositioncode() {
        return positioncode;
    }

    public void setPositioncode(BigInteger positioncode) {
        this.positioncode = positioncode;
    }

    public Date getInactivedate() {
        return inactivedate;
    }

    public void setInactivedate(Date inactivedate) {
        this.inactivedate = inactivedate;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getPurchaseyear() {
        return purchaseyear;
    }

    public void setPurchaseyear(String purchaseyear) {
        this.purchaseyear = purchaseyear;
    }

    public String getFirstbilling() {
        return firstbilling;
    }

    public void setFirstbilling(String firstbilling) {
        this.firstbilling = firstbilling;
    }

    public Integer getIsdisable() {
        return isdisable;
    }

    public void setIsdisable(Integer isdisable) {
        this.isdisable = isdisable;
    }

    public String getOriginalasset() {
        return originalasset;
    }

    public void setOriginalasset(String originalasset) {
        this.originalasset = originalasset;
    }

    public String getDevelopasset() {
        return developasset;
    }

    public void setDevelopasset(String developasset) {
        this.developasset = developasset;
    }

    public Integer getIsrent() {
        return isrent;
    }

    public void setIsrent(Integer isrent) {
        this.isrent = isrent;
    }

    public Integer getIslease() {
        return islease;
    }

    public void setIslease(Integer islease) {
        this.islease = islease;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getDemolitionstatu() {
        return demolitionstatu;
    }

    public void setDemolitionstatu(String demolitionstatu) {
        this.demolitionstatu = demolitionstatu;
    }

    public String getWbselement() {
        return wbselement;
    }

    public void setWbselement(String wbselement) {
        this.wbselement = wbselement;
    }

    public String getUsefulmonths() {
        return usefulmonths;
    }

    public void setUsefulmonths(String usefulmonths) {
        this.usefulmonths = usefulmonths;
    }

    public String getSourceassetno() {
        return sourceassetno;
    }

    public void setSourceassetno(String sourceassetno) {
        this.sourceassetno = sourceassetno;
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

    public Double getZzPgz() {
        return zzPgz;
    }

    public void setZzPgz(Double zzPgz) {
        this.zzPgz = zzPgz;
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

    public String getIsparent() {
        return isparent;
    }

    public void setIsparent(String isparent) {
        this.isparent = isparent;
    }

    public String getDurablelife() {
        return durablelife;
    }

    public void setDurablelife(String durablelife) {
        this.durablelife = durablelife;
    }

    public String getParentAssetId() {
        return parentAssetId;
    }

    public void setParentAssetId(String parentAssetId) {
        this.parentAssetId = parentAssetId;
    }

    public String getAnlkl() {
        return anlkl;
    }

    public void setAnlkl(String anlkl) {
        this.anlkl = anlkl;
    }

    public String getAssetcustodianAccount() {
        return assetcustodianAccount;
    }

    public void setAssetcustodianAccount(String assetcustodianAccount) {
        this.assetcustodianAccount = assetcustodianAccount;
    }

    public String getAssetkeeperAccount() {
        return assetkeeperAccount;
    }

    public void setAssetkeeperAccount(String assetkeeperAccount) {
        this.assetkeeperAccount = assetkeeperAccount;
    }

    public String getZzfpzc() {
        return zzfpzc;
    }

    public void setZzfpzc(String zzfpzc) {
        this.zzfpzc = zzfpzc;
    }


    @Override
    public String toString() {
        return "AssetCardBo{" +
                "id=" + id +
                ", specId=" + specId +
                ", creatorId=" + creatorId +
                ", createDate=" + createDate +
                ", modifierId=" + modifierId +
                ", modifyDate=" + modifyDate +
                ", version=" + version +
                ", shardingId=" + shardingId +
                ", bukrs=" + bukrs +
                ", osszseq='" + osszseq + '\'' +
                ", assetscardcode='" + assetscardcode + '\'' +
                ", secondaryassetscardcode='" + secondaryassetscardcode + '\'' +
                ", isestimate=" + isestimate +
                ", assetCatalogue='" + assetCatalogue + '\'' +
                ", assetstype=" + assetstype +
                ", description='" + description + '\'' +
                ", workcosttype=" + workcosttype +
                ", namberunit=" + namberunit +
                ", pnumber='" + pnumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", standard='" + standard + '\'' +
                ", address='" + address + '\'' +
                ", managedepartment=" + managedepartment +
                ", usedepartment=" + usedepartment +
                ", costcenter=" + costcenter +
                ", supervisor='" + supervisor + '\'' +
                ", assetcustodian='" + assetcustodian + '\'' +
                ", assetkeeper='" + assetkeeper + '\'' +
                ", capitaldate='" + capitaldate + '\'' +
                ", wbs='" + wbs + '\'' +
                ", assetsrelegation=" + assetsrelegation +
                ", isclientasset='" + isclientasset + '\'' +
                ", clientname='" + clientname + '\'' +
                ", assetsnature='" + assetsnature + '\'' +
                ", notes='" + notes + '\'' +
                ", abctype='" + abctype + '\'' +
                ", addtionreason=" + addtionreason +
                ", accessory='" + accessory + '\'' +
                ", pgyz=" + pgyz +
                ", pgljzj=" + pgljzj +
                ", pgljjz=" + pgljjz +
                ", isheldforsale=" + isheldforsale +
                ", isoverage=" + isoverage +
                ", isforsrcap=" + isforsrcap +
                ", isidle=" + isidle +
                ", isdevelopasset=" + isdevelopasset +
                ", areacode=" + areacode +
                ", countyoffices=" + countyoffices +
                ", branch=" + branch +
                ", businessofficeid=" + businessofficeid +
                ", btscode=" + btscode +
                ", team=" + team +
                ", isexpansion=" + isexpansion +
                ", isimpairment=" + isimpairment +
                ", depreciaerange1=" + depreciaerange1 +
                ", depreciaecode1=" + depreciaecode1 +
                ", depreciaerange2=" + depreciaerange2 +
                ", depreciaecode2=" + depreciaecode2 +
                ", usefullife1='" + usefullife1 + '\'' +
                ", period1='" + period1 + '\'' +
                ", usefullife2='" + usefullife2 + '\'' +
                ", period2='" + period2 + '\'' +
                ", costvalue=" + costvalue +
                ", depreciation=" + depreciation +
                ", impairmentsum=" + impairmentsum +
                ", netvalue=" + netvalue +
                ", positioncode=" + positioncode +
                ", inactivedate=" + inactivedate +
                ", purchasedate=" + purchasedate +
                ", purchaseyear='" + purchaseyear + '\'' +
                ", firstbilling='" + firstbilling + '\'' +
                ", isdisable=" + isdisable +
                ", originalasset='" + originalasset + '\'' +
                ", developasset='" + developasset + '\'' +
                ", isrent=" + isrent +
                ", islease=" + islease +
                ", credentials='" + credentials + '\'' +
                ", demolitionstatu='" + demolitionstatu + '\'' +
                ", wbselement='" + wbselement + '\'' +
                ", usefulmonths='" + usefulmonths + '\'' +
                ", sourceassetno='" + sourceassetno + '\'' +
                ", zzLicense='" + zzLicense + '\'' +
                ", zzFz07='" + zzFz07 + '\'' +
                ", zzLdqrq=" + zzLdqrq +
                ", zzRjjsglbm='" + zzRjjsglbm + '\'' +
                ", zzRjjswhbm='" + zzRjjswhbm + '\'' +
                ", zzPgz=" + zzPgz +
                ", zzCbrq='" + zzCbrq + '\'' +
                ", zzCbydfl=" + zzCbydfl +
                ", isparent='" + isparent + '\'' +
                ", durablelife='" + durablelife + '\'' +
                ", parentAssetId='" + parentAssetId + '\'' +
                ", anlkl='" + anlkl + '\'' +
                ", assetcustodianAccount='" + assetcustodianAccount + '\'' +
                ", assetkeeperAccount='" + assetkeeperAccount + '\'' +
                ", zzfpzc='" + zzfpzc + '\'' +
                '}';
    }
}
