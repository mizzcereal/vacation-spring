package com.example.site1.domain.DTO;

import com.example.site1.model.IndexEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IndexDTO {
    private Integer idx;
    private String id;
    private String password;

    public static IndexDTO fromEntity(IndexEntity indexEntity){
        return new IndexDTO(indexEntity.getIdx(), indexEntity.getId(), indexEntity.getPassword());
    }
}
