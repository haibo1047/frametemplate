package com.ylsq.frame.sys.secu.custobj;

import com.ylsq.frame.sys.secu.dao.model.SecuMenu;

public class MenuObject {
	private Long id;
	private String name;
	private String url;
	private String module;
	private int menuOrder;
	private int moduleOrder;
	
	public MenuObject(SecuMenu menu) {
		setId(menu.getId());
		setName(menu.getMenuName());
		setUrl(menu.getMenuUrl());
		setModule(menu.getMenuModule());
		setMenuOrder(menu.getMenuOrder());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public int getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}
	public int getModuleOrder() {
		return moduleOrder;
	}
	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}
	
}
