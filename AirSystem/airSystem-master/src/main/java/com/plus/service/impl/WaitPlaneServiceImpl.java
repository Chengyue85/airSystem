package com.plus.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plus.dao.WaitPlaneDao;
import com.plus.po.WaitPlane;
import com.plus.service.WaitPlaneService;

@Service
public class WaitPlaneServiceImpl implements WaitPlaneService {

	@Autowired 
	private WaitPlaneDao waitdao;
	@Override
	public String insertWaitPlane(WaitPlane plane) {
		try{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		plane.setTime(time);
		int result = waitdao.insertWaitPlane(plane);
		System.out.println(result);
		return "success";
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
