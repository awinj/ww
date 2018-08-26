package test;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

public class SocialProcessResult {

	protected List<SocialDispatchDetail> socialDispatchDetail;
	protected String businessId;
	protected String workFlowNo;
	protected String workFlowType;
	protected String result;
	protected String reason;

	/**
	 * Gets the value of the socialDispatchDetail property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the socialDispatchDetail property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSocialDispatchDetail().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SocialDispatchDetail }
	 * 
	 * 
	 */
	public List<SocialDispatchDetail> getSocialDispatchDetail() {
		if (socialDispatchDetail == null) {
			socialDispatchDetail = new ArrayList<SocialDispatchDetail>();
		}
		return this.socialDispatchDetail;
	}

	/**
	 * Gets the value of the businessId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * Sets the value of the businessId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBusinessId(String value) {
		this.businessId = value;
	}

	/**
	 * Gets the value of the workFlowNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkFlowNo() {
		return workFlowNo;
	}

	/**
	 * Sets the value of the workFlowNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkFlowNo(String value) {
		this.workFlowNo = value;
	}

	/**
	 * Gets the value of the workFlowType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getWorkFlowType() {
		return workFlowType;
	}

	/**
	 * Sets the value of the workFlowType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setWorkFlowType(String value) {
		this.workFlowType = value;
	}

	/**
	 * Gets the value of the result property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the value of the result property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setResult(String value) {
		this.result = value;
	}

	/**
	 * Gets the value of the reason property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the value of the reason property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReason(String value) {
		this.reason = value;
	}

}
