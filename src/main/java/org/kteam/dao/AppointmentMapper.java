package org.kteam.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.kteam.entity.Appointment;
import org.kteam.entity.AppointmentExample;

public interface AppointmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int countByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int deleteByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int insert(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int insertSelective(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    List<Appointment> selectByExample(AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    Appointment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int updateByPrimaryKeySelective(Appointment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the dbserivce table appointment
     *
     * @mbggenerated Sun Aug 13 23:51:55 CST 2017
     */
    int updateByPrimaryKey(Appointment record);
}