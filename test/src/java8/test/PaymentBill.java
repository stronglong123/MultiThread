package java8.test;

import java.io.Serializable;
import java.util.Date;

/**
 * 付款单实体
 * 
 * @author hc
 */
public class PaymentBill implements Serializable{
	
	public PaymentBill() {
		
	}

	public PaymentBill(String id) {
		super();
		this.id = id;
	}

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 付款类型
	 */
	private Long paymentTypeId;

	/**
	 * 付款金额
	 */
	private Double paymentMoney;

	/**
	 * 付款金额本位币
	 */
	private Double paymentCurrency;

	/**
	 * 核销金额
	 */
	private Double verificationAmount;

	/**
	 * 应付余额
	 */
	private Double remainderAmount;

	/**
	 * 应付未核销金额
	 */
	private Double rbNotAccMoney;

	/**
	 * 应付本次付款金额
	 */
	private Double curPaymentAmount;

	/**
	 * 到期日
	 */
	private Date dueDate;

	/**
	 * 采购性质:组织间采购0、供应商采购1
	 */
	private Long purtype;

	/**
	 * 汇率
	 */
	private Double exchangerate;
	
	
	
	private String[] strs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Double getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	public Double getPaymentCurrency() {
		return paymentCurrency;
	}

	public void setPaymentCurrency(Double paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Double getVerificationAmount() {
		return verificationAmount;
	}

	public void setVerificationAmount(Double verificationAmount) {
		this.verificationAmount = verificationAmount;
	}

	public Double getRemainderAmount() {
		return remainderAmount;
	}

	public void setRemainderAmount(Double remainderAmount) {
		this.remainderAmount = remainderAmount;
	}

	public Double getRbNotAccMoney() {
		return rbNotAccMoney;
	}

	public void setRbNotAccMoney(Double rbNotAccMoney) {
		this.rbNotAccMoney = rbNotAccMoney;
	}

	public Double getCurPaymentAmount() {
		return curPaymentAmount;
	}

	public void setCurPaymentAmount(Double curPaymentAmount) {
		this.curPaymentAmount = curPaymentAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getPurtype() {
		return purtype;
	}

	public void setPurtype(Long purtype) {
		this.purtype = purtype;
	}

	public Double getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(Double exchangerate) {
		this.exchangerate = exchangerate;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}
}
