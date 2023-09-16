package com.ccsu.service.impl;

import com.ccsu.common.TransferRecord;
import com.ccsu.dal.TransferRecordMapper;
import com.ccsu.service.TransferRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("transferRecordService")
public class TransferRecordServiceImpl implements TransferRecordService {

    @Autowired
    private TransferRecordMapper transferRecordMapper;


    @Override
    public void insertTransferRecord(TransferRecord transferRecord) {
        transferRecordMapper.insertTransferRecord(transferRecord);
    }

    @Override
    public void updateTransferRecord(TransferRecord transferRecord) {
        transferRecordMapper.updateTransferRecord(transferRecord);
    }

    @Override
    public void deleteTransferRecord(int recordId) {
        transferRecordMapper.deleteTransferRecord(recordId);
    }

    @Override
    public TransferRecord getTransferRecordById(int recordId) {
        return transferRecordMapper.getTransferRecordById(recordId);
    }

    @Override
    public Integer getTransferRecordsByDate(Date date) {
        return transferRecordMapper.getTransferRecordsByDate(date);
    }

    @Override
    public Integer getTransferRecordsByAccount(Date date, String account) {
        return transferRecordMapper.getTransferRecordsByAccount(date,account);
    }
}