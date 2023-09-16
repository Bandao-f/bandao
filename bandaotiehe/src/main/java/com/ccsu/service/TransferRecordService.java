package com.ccsu.service;


import com.ccsu.common.TransferRecord;

import java.util.Date;
import java.util.List;

public interface TransferRecordService {
    void insertTransferRecord(TransferRecord transferRecord);

    void updateTransferRecord(TransferRecord transferRecord);

    void deleteTransferRecord(int recordId);

    TransferRecord getTransferRecordById(int recordId);

    Integer getTransferRecordsByDate(Date date);
    Integer getTransferRecordsByAccount(Date date,String account);
}