package com.plus.dao;



import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.plus.po.WaitPlane;

/**
预定机票等待队列的dao层
 */
@Repository
@Mapper
public interface WaitPlaneDao {
	
	public int insertWaitPlane(WaitPlane waitPlane);

}
