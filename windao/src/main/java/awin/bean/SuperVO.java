package awin.bean;

import awin.bean.util.BeanHelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class SuperVO extends ValueObject implements IStateful{


	private boolean dirty = false;
	private int status = 0;

	public Object clone()
	{
		SuperVO vo = null;
		try {
			vo = (SuperVO)getClass().newInstance();
		}
		catch (Exception e) {
		}
		String[] fieldNames = getAttrNames();
		if (fieldNames != null) {
			for (int i = 0; i < fieldNames.length; i++) {
				try {
					vo.setAttrValue(fieldNames[i], getAttrValue(fieldNames[i]));
				}
				catch (Exception ex)
				{
				}
			}
		}
		vo.setDirty(isDirty());
		vo.setStatus(getStatus());
		return vo;
	}


	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



}
