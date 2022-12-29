package com.plus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.plus.po.Plane;

/**航班信息的dao层
 */
@Repository
@Mapper
public interface PlaneDao {

	public List<Plane> selectAllPlane();
	public Plane selectPlaneById(int id);
	public List<Plane> selectPlaneByName(String planeName);
	public int updatePlaneDNumber(@Param("planeId")int planeId,@Param("number")int number);
	public int updatePlaneINumber(@Param("planeId")int planeId,@Param("number")int number);
	
	public int insertPlane(Plane plane);
	
	public int deletePlane(int id);
	
}
