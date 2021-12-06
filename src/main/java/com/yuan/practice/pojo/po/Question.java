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
public class Question {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 问题
     */
    @TableField("question")
    private String question;

    /**
     * 选项A
     */
    @TableField("option_a")
    private String optionA;

    /**
     * 选项B
     */
    @TableField("option_b")
    private String optionB;

    /**
     * 选项C
     */
    @TableField("option_c")
    private String optionC;

    /**
     * 选项D
     */
    @TableField("option_d")
    private String optionD;

    /**
     * 答案
     */
    @TableField("answer")
    private String answer;

    /**
     * 解释
     */
    @TableField("question_explain")
    private String questionExplain;

    /**
     * 所属模块
     */
    @TableField("module")
    private Integer module;


}
