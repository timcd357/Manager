package com.apixel.manager.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * <p>
 * 用户业务表
 * </p>
 *
 * @author shixianyu
 * @since 2020-07-09
 */
public class UserBusiness implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type= IdType.ASSIGN_UUID)
    private String id;
    /**
     * 日期
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    /**
     * 物品名称
     */
    private String itemname;

    /**
     * 批号/流水号
     */
    private String batch;

    /**
     * 数量
     */
    private Float num;

    /**
     * 单价
     */
    private Float price;

    /**
     * 厂家
     */
    private String factory;

    /**
     * 做了什么
     */
    private String did;

    /**
     * 位置（起点）
     */
    private String start;

    /**
     * 位置（终点）
     */
    private String end;

    /**
     * 用户主键
     */
    private String userid;

    private Integer flag;

    /**
     * 备注
     */
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
