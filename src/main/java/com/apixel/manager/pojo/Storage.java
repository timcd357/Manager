package com.apixel.manager.pojo;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.apixel.manager.config.annotation.ExcelAnnotation;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓库状态
 * </p>
 *
 * @author shixianyu
 * @since 2020-08-11
 */
@EqualsAndHashCode(callSuper = false)
public class Storage implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type= IdType.ASSIGN_UUID)
//    @ExcelAnnotation(columnIndex = 0,columnName = "编号")
    private String id;
    /**
     * 品名规格
     */
    @ExcelAnnotation(columnIndex = 3,columnName = "品名规格")
    private String name;

    /**
     * 厂家名称
     */
    @ExcelAnnotation(columnIndex = 4,columnName = "生产厂家")
    private String factory;

    /**
     * 包装数量
     */
    @ExcelAnnotation(columnIndex = 8,columnName = "包装数量")
//    @ExcelAnnotation(columnIndex = 7,columnName = "包装数量")
    private Integer qty;

    /**
     * 批号
     */
    @ExcelAnnotation(columnIndex = 11,columnName = "批号")
//    @ExcelAnnotation(columnIndex = 9,columnName = "批号")
    private String lot;

    /**
     * 可分配数量
     */
    @ExcelAnnotation(columnIndex = 15,columnName = "库存数量")
//    @ExcelAnnotation(columnIndex = 13,columnName = "库存数量")
    private Integer num;

    /**
     * 可分配件数
     */
    @ExcelAnnotation(columnIndex = 16,columnName = "可分配数量")  //正式用
//    @ExcelAnnotation(columnIndex = 13,columnName = "可分配数量")
    private Integer assignable;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime modifyTime;

    private String userId;

    private Date realTime;

    //用于判断是不同的物品
    @ExcelAnnotation(columnIndex = 14,columnName = "批次号")
//    @ExcelAnnotation(columnIndex = 29,columnName = "批次号")
    private String batch;

    @ExcelAnnotation(columnIndex = 28,columnName = "货位名称")
//    @ExcelAnnotation(columnIndex = 41,columnName = "货位名称")
    private String site;

    @ExcelAnnotation(columnIndex = 27,columnName = "货位代码")
//    @ExcelAnnotation(columnIndex = 42,columnName = "货位代码")
    private String siteCode;

    /**
     * 标志位
     */
    private Integer flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getRealTime() {
        return realTime;
    }

    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getAssignable() {
        return assignable;
    }

    public void setAssignable(Integer assignable) {
        this.assignable = assignable;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }
}
