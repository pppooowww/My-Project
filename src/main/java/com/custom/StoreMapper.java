package com.custom;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    void insertStoreByLikeCount(String storeName);
    StoreDTO selectStoreByLikeCount(String storeName);
}
