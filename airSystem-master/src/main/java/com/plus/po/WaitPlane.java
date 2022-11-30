package com.plus.po;

/**当机票数量不够的时候，便进入等待队列
 */
public class WaitPlane {

	private int id;
	private int userid;
	private int planeid;
	private int result;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPlaneid() {
		return planeid;
	}
	public void setPlaneid(int planeid) {
		this.planeid = planeid;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
