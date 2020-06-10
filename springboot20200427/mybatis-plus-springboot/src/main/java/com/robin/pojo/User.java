package com.robin.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/25 15:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //@TableId(type = IdType.ID_WORKER)//雪花算法，现在不推荐使用这个了
    //@TableId(type = IdType.ASSIGN_ID)//目前在3.3.0版本，推荐使用这个版本
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version//代表是一个乐观锁
    private Integer version;

    @TableLogic//逻辑删除
    private Integer dr;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
