package com.plus.dao;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.plus.po.WaitPlane;

@Repository
@Mapper
public interface WaitPlaneDao {
	
	public int insertWaitPlane(WaitPlane waitPlane);

}
