package com.robin.automp.entity;

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
public class Mp_course extends Model<Mp_course> {

    private static final long serialVersionUID = 1L;

    /**
     * 学科主键
     */
    @TableId(value = "pk_mp_course", type = IdType.ID_WORKER)
    private String pk_mp_course;
    /**
     * 名称
     */
    private String course;
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


    public String getPk_mp_course() {
        return pk_mp_course;
    }

    public void setPk_mp_course(String pk_mp_course) {
        this.pk_mp_course = pk_mp_course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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
        return this.pk_mp_course;
    }

    @Override
    public String toString() {
        return "Mp_course{" +
        ", pk_mp_course=" + pk_mp_course +
        ", course=" + course +
        ", dr=" + dr +
        ", version=" + version +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
