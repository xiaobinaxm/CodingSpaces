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
public class Mp_user extends Model<Mp_user> {

    private static final long serialVersionUID = 1L;

    /**
     * user主键
     */
    @TableId(value = "pk_mp_user", type = IdType.ID_WORKER)
    private String pk_mp_user;
    /**
     * 用户名
     */
    private String username;
    /**
     * 别名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
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


    public String getPk_mp_user() {
        return pk_mp_user;
    }

    public void setPk_mp_user(String pk_mp_user) {
        this.pk_mp_user = pk_mp_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return this.pk_mp_user;
    }

    @Override
    public String toString() {
        return "Mp_user{" +
        ", pk_mp_user=" + pk_mp_user +
        ", username=" + username +
        ", name=" + name +
        ", password=" + password +
        ", dr=" + dr +
        ", version=" + version +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
