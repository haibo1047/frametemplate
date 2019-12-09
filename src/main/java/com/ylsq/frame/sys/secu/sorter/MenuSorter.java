package com.ylsq.frame.sys.secu.sorter;

import java.util.Comparator;

import com.ylsq.frame.sys.secu.custobj.MenuObject;

public class MenuSorter implements Comparator<MenuObject> {

	@Override
	public int compare(MenuObject o1, MenuObject o2) {
		// TODO Auto-generated method stub
		if(o1 == null && o2 == null)
			return 0;
		if( o2 == null )
			return 1;
		if (o1 == null)
			return -1;
		if(o1.getId() == o2.getId())
			return 0;
		
		if(o1.getModuleOrder() == o2.getModuleOrder() && !o1.getModule().equals(o2.getModule()))
			return o1.getMenuOrder() - o2.getMenuOrder();
		
		return o1.getModuleOrder() - o2.getModuleOrder();
	}


}
