package com.example.coolparking.dao;

import com.example.coolparking.dataobject.ParkingCarport;
import com.example.coolparking.utils.TableNameProviderUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ParkingCarportDao {
    @Results(id="carportMap",value = {
            @Result(column = "carport_num",property = "carportNum",id=true),
            @Result(column = "car_state",property = "carState"),
            @Result(column = "able_state",property = "ableState")
    })
    @SelectProvider(type = TableNameProviderUtil.class,method = "selectCarportSQL")
    List<ParkingCarport> parkingFindAllCarports(String parkingCarportTableName);

    @UpdateProvider(type = TableNameProviderUtil.class,method = "updateCarportAbleSQL")
    boolean parkingCarportEdit(String parkingCarportTableName,String parkingCarportNum,boolean ableState);

    @ResultMap("carportMap")
    @SelectProvider(type = TableNameProviderUtil.class,method = "selectFreeCarportSQL")
    List<ParkingCarport> parkingFindFreeCarports(String parkingCarportTableName);

    @UpdateProvider(type = TableNameProviderUtil.class,method = "updateCarportUseSQL")
    boolean parkingCarportUseEdit(String parkingCarportTableName,String parkingCarportNum,boolean carState);

    @UpdateProvider(type = TableNameProviderUtil.class,method = "createParkingSQL")
    void createParking(String tablename);

    @InsertProvider(type = TableNameProviderUtil.class,method = "insertParkingSQL")
    void insertTable(String tablename, int carportnum);
}
