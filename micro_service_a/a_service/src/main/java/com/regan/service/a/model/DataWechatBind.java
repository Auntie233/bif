package com.regan.service.a.model;

import com.bif.db.mapper.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "data_wechat_bind")
public class DataWechatBind extends BaseEntity {
    /**
     * 绑定ID
     */
    @Id
    @Column(name = "bind_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bindId;

    /**
     * 用户类型：1-理财师；2-客户
     */
    private String type;

    /**
     * openid
     */
    private String openid;

    /**
     * 客户号
     */
    @Column(name = "customer_number")
    private String customerNumber;

    /**
     * 账户ID
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 公众号关注状态：0-取消关注；1-已关注
     */
    private String status;

    /**
     * 记录时间
     */
    @Column(name = "record_time")
    private Date recordTime;

    /**
     * 获取绑定ID
     *
     * @return bind_id - 绑定ID
     */
    public Integer getBindId() {
        return bindId;
    }

    /**
     * 设置绑定ID
     *
     * @param bindId 绑定ID
     */
    public void setBindId(Integer bindId) {
        this.bindId = bindId;
    }

    /**
     * 获取用户类型：1-理财师；2-客户
     *
     * @return type - 用户类型：1-理财师；2-客户
     */
    public String getType() {
        return type;
    }

    /**
     * 设置用户类型：1-理财师；2-客户
     *
     * @param type 用户类型：1-理财师；2-客户
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取客户号
     *
     * @return customer_number - 客户号
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * 设置客户号
     *
     * @param customerNumber 客户号
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * 获取账户ID
     *
     * @return account_id - 账户ID
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置账户ID
     *
     * @param accountId 账户ID
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取公众号关注状态：0-取消关注；1-已关注
     *
     * @return status - 公众号关注状态：0-取消关注；1-已关注
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置公众号关注状态：0-取消关注；1-已关注
     *
     * @param status 公众号关注状态：0-取消关注；1-已关注
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取记录时间
     *
     * @return record_time - 记录时间
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * 设置记录时间
     *
     * @param recordTime 记录时间
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}