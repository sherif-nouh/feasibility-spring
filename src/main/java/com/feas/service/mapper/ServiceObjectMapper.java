package com.feas.service.mapper;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ServiceObjectMapper {

    <S, T> Page<T> mapPage(Page<S> source, Class<T> targetClass);

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass);

    <D> D map(Object source, Class<D> destinationType);

    void map(Object source, Object destination);

}
