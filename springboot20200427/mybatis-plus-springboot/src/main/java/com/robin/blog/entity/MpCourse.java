package com.robin.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 肖斌
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MpCourse对象", description="")
public class MpCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学科主键")
    @TableId(value = "pk_mp_course", type = IdType.ID_WORKER)
    private String pkMpCourse;

    @ApiModelProperty(value = "名称")
    private String course;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private String dr;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private String version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
