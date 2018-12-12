package com.study.spring.sail.config.jpa;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 *  jpa audit 基类
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditEntity implements Serializable {

    @Column(nullable = false,updatable = false, name = "create_by")
    @CreatedBy
    private Long createBy;          // 创建人

    @Column(nullable = false,updatable = false, name = "create_date")
    @CreatedDate
    private Date createDate;        // 创建时间

    @Column(name = "update_by")
    @LastModifiedBy
    private Long updateBy;          // 修改人

    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateDate;        // 修改时间

    @Column(name = "remarks")
    private String remarks;         // 备注

    @Column(nullable = false, name = "del_flag")
    private String delFlag;         // 删除标志

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
