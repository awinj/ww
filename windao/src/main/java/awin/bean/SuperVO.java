package awin.bean;

import awin.lang.BooleanExt;

public abstract class SuperVO extends ValueObject implements IStateful{



	private boolean dirty = false;
	private int status = 0;
	private String ts;
	private BooleanExt dr;

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
					ex.printStackTrace();
				}
			}
		}
		vo.setDirty(isDirty());
		vo.setStatus(getStatus());
		return vo;
	}

	public  String getParentPk()
	{
		return null;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	/**
	 * VOState
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * VOState
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public BooleanExt getDr() {
		return dr;
	}

	public void setDr(BooleanExt dr) {
		this.dr = dr;
	}
}
