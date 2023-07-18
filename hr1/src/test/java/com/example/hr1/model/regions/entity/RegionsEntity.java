package com.example.hr1.model.regions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// DB테이블명 + Entity 


@Entity // Entity임을 명시 
@Table(name = "regions") // 데이터베이스 테이블이름과 연동
@NoArgsConstructor
@AllArgsConstructor
@Getter
// 엔티티에서 setter는 꼭 필요할 때만 직접 만드는 것을 추천
public class RegionsEntity {
    
    @Id// 기본이 (PK)에 @Id를 붙인다.
    
    @Column(name = "region_id", nullable = false, unique = true) // 데이터베이스에 있는 컬럼명을 연결 기존 컬럼의 속성을 맞춰주는 것이 좋다
    private Integer regionId;

    @Column(name = "region_name", nullable = true)
    private String regionName;

    @Override
    public String toString(){
        return "RegionsEntity [regionId = " + regionId + ", regionName = " + regionName + "]";
    }
}
