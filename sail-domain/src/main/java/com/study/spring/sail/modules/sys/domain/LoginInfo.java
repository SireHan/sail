package com.study.spring.sail.modules.sys.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String loginName;       // 登录名
    private String password;        // 密码
    private String loginStatus;      // 登录状态
    private String loginType;       // 账户类型
    private String phone;           // 手机号
    private String email;           // 邮箱
    private Long photoId;           // 头像id
    private Long userId;            // 用户id
    private String loginIp;         // 最后一次登录ip
    private Date loginDate;         // 最后一次登录时间
    private Long createBy;          // 创建人
    private Date createDate;        // 创建时间
    private Long updateBy;          // 修改人
    private Date updateDate;        // 修改时间
    private String remarks;         // 备注
    private String delFlag;         // 删除标志

    public LoginInfo() {
    }

    public LoginInfo(Long id, String loginName, String password, String loginStatus, String loginType, String phone, String email, Long photoId, Long userId, String loginIp, Date loginDate, Long createBy, Date createDate, Long updateBy, Date updateDate, String remarks, String delFlag) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.loginStatus = loginStatus;
        this.loginType = loginType;
        this.phone = phone;
        this.email = email;
        this.photoId = photoId;
        this.userId = userId;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.remarks = remarks;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginSttus) {
        this.loginStatus = loginSttus;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

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
