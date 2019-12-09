package com.ylsq.frame.sys.secu.custobj;

import java.util.List;

import com.ylsq.frame.sys.secu.dao.model.SecuOrg;

public class CustOrg {
	private Long id;
	private String orgName;
	private int order;
	
	private List<CustOrg> subOrgs;

	public CustOrg(SecuOrg dao) {
		setId(dao.getId());
		setOrgName(dao.getOrgName());
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<CustOrg> getSubOrgs() {
		return subOrgs;
	}

	public void setSubOrgs(List<CustOrg> subOrgs) {
		this.subOrgs = subOrgs;
	}
	
}
