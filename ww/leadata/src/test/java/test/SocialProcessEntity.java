package test;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

public class SocialProcessEntity {

	protected List<SocialProcessResult> socialProcessResultList;
	protected String socialDispatchType;
	
	public List<SocialProcessResult> getSocialProcessResultList() {
		return socialProcessResultList;
	}
	public void setSocialProcessResultList(
			List<SocialProcessResult> socialProcessResultList) {
		this.socialProcessResultList = socialProcessResultList;
	}
	public String getSocialDispatchType() {
		return socialDispatchType;
	}
	public void setSocialDispatchType(String socialDispatchType) {
		this.socialDispatchType = socialDispatchType;
	}

	

}
