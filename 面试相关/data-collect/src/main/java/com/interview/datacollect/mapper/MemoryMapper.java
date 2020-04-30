package com.interview.datacollect.mapper;

import com.interview.datacollect.pojo.Memory;
import com.interview.datacollect.pojo.MemoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    long countByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int deleteByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int insert(Memory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int insertSelective(Memory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    List<Memory> selectByExample(MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    Memory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int updateByExampleSelective(@Param("record") Memory record, @Param("example") MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int updateByExample(@Param("record") Memory record, @Param("example") MemoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int updateByPrimaryKeySelective(Memory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_memory
     *
     * @mbg.generated Wed Apr 29 22:34:42 CST 2020
     */
    int updateByPrimaryKey(Memory record);
}