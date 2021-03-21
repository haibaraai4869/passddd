package com.qys.filetransfer.mapper;

import com.qys.filetransfer.domain.FileInformation;
import com.qys.filetransfer.domain.FileInformationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface FileInformationMapper {
    int countByExample(FileInformationExample example);

    int deleteByExample(FileInformationExample example);

    int deleteByPrimaryKey(String uid);

    int insert(FileInformation record);

    int insertSelective(FileInformation record);

    List<FileInformation> selectByExample(FileInformationExample example);

    FileInformation selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") FileInformation record, @Param("example") FileInformationExample example);

    int updateByExample(@Param("record") FileInformation record, @Param("example") FileInformationExample example);

    int updateByPrimaryKeySelective(FileInformation record);

    int updateByPrimaryKey(FileInformation record);
}