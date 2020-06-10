package com.robin.automp.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Robin
 * @since 2020-04-27
 */
public class Mp_book extends Model<Mp_book> {

    private static final long serialVersionUID = 1L;

    /**
     * book主键
     */
    @TableId(value = "pk_mp_book", type = IdType.ID_WORKER)
    private String pk_mp_book;
    /**
     * book名字
     */
    private String book_name;
    /**
     * book价格
     */
    private BigDecimal book_price;
    /**
     * book作者
     */
    private String book_author;
    /**
     * 逻辑删除
     */
    private String dr;
    /**
     * 乐观锁
     */
    private String version;
    /**
     * 创建时间
     */
    private Date gmt_create;
    /**
     * 更新时间
     */
    private Date gmt_modified;


    public String getPk_mp_book() {
        return pk_mp_book;
    }

    public void setPk_mp_book(String pk_mp_book) {
        this.pk_mp_book = pk_mp_book;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public BigDecimal getBook_price() {
        return book_price;
    }

    public void setBook_price(BigDecimal book_price) {
        this.book_price = book_price;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    protected Serializable pkVal() {
        return this.pk_mp_book;
    }

    @Override
    public String toString() {
        return "Mp_book{" +
        ", pk_mp_book=" + pk_mp_book +
        ", book_name=" + book_name +
        ", book_price=" + book_price +
        ", book_author=" + book_author +
        ", dr=" + dr +
        ", version=" + version +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
