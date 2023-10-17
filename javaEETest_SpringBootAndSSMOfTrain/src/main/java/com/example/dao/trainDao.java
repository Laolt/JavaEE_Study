package com.example.dao;


import com.example.domain.train;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper//TODO 添加@Mapper注解
public interface trainDao {
    @Select("select * from train limit #{pageNumber},4")
    List<train> selectByPageNumber(int pageNumber);
    @Insert("insert into train (trainN,startTime,startAddress,endAddress,Dtime,Mnumber,Bnumber)" +
            "values(#{trainN},#{startTime},#{startAddress},#{endAddress},#{Dtime},#{Mnumber},#{Bnumber})")
    Boolean insertData(train t);
    @Update("update train set Bnumber=#{Number} where  trainN=#{name}")
    Boolean updateByName(int Number,String name);
    @Delete("delete from train where trainN=#{name}")
    Boolean deleteData(String name);
    @Select("select * from train where trainN=#{name}")
    train selectByName(String name);
    @Select("select count(*) from train")
    int getTrainCount();
    @Select("select * from train where endAddress like #{endAddress} limit #{pageNumber},4")
    List<train> selectByEndAddress(String endAddress,int pageNumber);
    @Select("select count(*) from train where endAddress like #{endAddress}")
    int selectAcuntByEndAddress(String endAddress);
}
