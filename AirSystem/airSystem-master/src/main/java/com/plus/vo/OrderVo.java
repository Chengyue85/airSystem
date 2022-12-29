package com.plus.vo;

import com.plus.po.Order;
import com.plus.po.Plane;

/**订单的扩展类,订单绑定商品
 */
public class OrderVo extends Order {

	private Plane plane;

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	
	
}
