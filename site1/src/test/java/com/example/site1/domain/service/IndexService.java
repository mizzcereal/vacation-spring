package com.example.site1.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.DTO.IndexDTO;
import com.example.site1.model.IndexEntity;
import com.example.site1.model.IndexRespository;

@Service
public class IndexService {
    
    @Autowired
    private IndexRespository indexRespository;

    public List<IndexDTO> getMaingPageData(){

        List<IndexEntity> indexEntityList = indexRespository.findAll();

        List<IndexDTO> indexDTOList = indexEntityList
        .stream()
        .map((indexEntityList) -> IndexDTO.fromEntity(indexEntity))
        .toList();

        return indexDTOList;
        
    }

}
