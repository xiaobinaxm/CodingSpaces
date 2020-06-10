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
public class Mp_role extends Model<Mp_role> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键
     */
    @TableId(value = "pk_mp_role", type = IdType.ID_WORKER)
    private String pk_mp_role;
    /**
     * 角色名字
     */
    private String name;
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


    public String getPk_mp_role() {
        return pk_mp_role;
    }

    public void setPk_mp_role(String pk_mp_role) {
        this.pk_mp_role = pk_mp_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return this.pk_mp_role;
    }

    @Override
    public String toString() {
        return "Mp_role{" +
        ", pk_mp_role=" + pk_mp_role +
        ", name=" + name +
        ", dr=" + dr +
        ", version=" + version +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
