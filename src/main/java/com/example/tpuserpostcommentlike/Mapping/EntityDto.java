package com.example.tpuserpostcommentlike.Mapping;

public interface EntityDto <D,E>{

    public D convertToDto(E entity);
    public E convertToEntity(D dto);

}
