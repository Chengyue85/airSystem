package com.plus.service;

import java.util.List;

import com.plus.po.Plane;


public interface PlaneService {

	public List<Plane> selectAllPlane();
	public List<Plane> selectPlaneByName(int orderId); //由订单号得出航班名称
}
