package com.itguigu.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 部门规章制度
 * <p>Table name:tb_dept_rule</p>
 * <p>Create time:2020-08-25 14:51:16</p>
 *
 * @author eros
 */
@Data
@TableName("rules")
public class Rules implements Serializable {
    /**
     * 规章制度id
     */
    private String id;

    /**
     * 制度名称
     */
    private String rulesName;

    /**
     * 机构id
     */
    private Long mechanismId;

    /**
     * 逻辑删除标识。1：删除；0：未删除
     */
    private Boolean markDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 更新时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 更新人
     */
    private String modifiedUser;

    /**
     * 规章详情
     */
    private String rulesDetail;

    private static final long serialVersionUID = 1L;

    public Rules withId(String id) {
        this.setId(id);
        return this;
    }

    public Rules withRulesName(String rulesName) {
        this.setRulesName(rulesName);
        return this;
    }

    public Rules withMechanismId(Long mechanismId) {
        this.setMechanismId(mechanismId);
        return this;
    }

    public Rules withMarkDelete(Boolean markDelete) {
        this.setMarkDelete(markDelete);
        return this;
    }

    public Rules withCreateTime(LocalDateTime createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    public Rules withCreateUser(String createUser) {
        this.setCreateUser(createUser);
        return this;
    }

    public Rules withModifiedTime(LocalDateTime modifiedTime) {
        this.setModifiedTime(modifiedTime);
        return this;
    }

    public Rules withModifiedUser(String modifiedUser) {
        this.setModifiedUser(modifiedUser);
        return this;
    }

    public Rules withRulesDetail(String rulesDetail) {
        this.setRulesDetail(rulesDetail);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rulesName=").append(rulesName);
        sb.append(", mechanismId=").append(mechanismId);
        sb.append(", markDelete=").append(markDelete);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifiedUser=").append(modifiedUser);
        sb.append(", rulesDetail=").append(rulesDetail);
        sb.append("]");
        return sb.toString();
    }
}