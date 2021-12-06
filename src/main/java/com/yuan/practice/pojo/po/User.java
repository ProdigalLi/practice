package com.yuan.practice.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Yuan
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_name")
    private String userName;

    @TableField("user_password")
    private String password;

}
