package com.example.hr1.model.regions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.regions.entity.RegionsEntity;



//Interger은 RegionsEntity의 기본키
@Repository
public interface RegionsRepository extends JpaRepository<RegionsEntity, Integer> {

    // find - select * from reginds
    // by - where

    RegionsEntity findByRegionId(Integer regionId);

    //region_name은 유니크하지 않기 때문에 여러개를 가져올 수 있다.
    //그렇기떄문에 id와 다르게 List타입으로 가져와야 한다.
    List<RegionsEntity> findByRegionName(String regionName);

    // region_id와 region_name이 둘다 조건이 맞을 때 == 단일값
    // find - select * from regions
    // by - where
    // and - and
    RegionsEntity findByRegionIdAndRegionName(Integer regionId, String regionName);
    
}
