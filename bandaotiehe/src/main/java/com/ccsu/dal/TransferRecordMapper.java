package com.ccsu.dal;

import com.ccsu.common.TransferRecord;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TransferRecordMapper {

    // 定义返回结果的映射
    @Results(id = "transferRecordMap", value = {
            // 根据数据库字段和TransferRecord的属性做映射
            @Result(property = "id", column = "record_id"),
            @Result(property = "transferDate", column = "transfer_date"),
            @Result(property = "amount", column = "amount"),
            // 其他属性映射
            // ...
    })
    @Select("SELECT * FROM transfer_records WHERE id = #{id}")
    TransferRecord getTransferRecordById(@Param("id") int id);

    // 插入转账记录
    @Insert("INSERT INTO transfer_records (alipay_account, transfer_status, transfer_time, amount) " +
            "VALUES (#{alipayAccount}, #{transferStatus}, #{transferTime}, #{amount})")
    void insertTransferRecord(TransferRecord transferRecord);

    // 根据日期查询转账记录
    @Select("SELECT sum(amount) FROM transfer_records WHERE DATE(transfer_time) = CURDATE()")
    Integer getTransferRecordsByDate(@Param("date") Date date);

    @Select("SELECT count(1) FROM transfer_records WHERE DATE(transfer_time) = CURDATE() and alipay_account = #{alipayAccount}")
    Integer getTransferRecordsByAccount(@Param("date") Date date,@Param("alipayAccount") String alipayAccount);

    // 更新转账记录
    @Update("UPDATE transfer_records SET alipay_account = #{alipayAccount}, " +
            "transfer_status = #{transferStatus}, transfer_time = #{transferTime}, " +
            "amount = #{amount} WHERE id = #{id}")
    void updateTransferRecord(TransferRecord transferRecord);

    // 删除转账记录
    @Delete("DELETE FROM transfer_records WHERE id = #{id}")
    void deleteTransferRecord(@Param("id") int id);
}