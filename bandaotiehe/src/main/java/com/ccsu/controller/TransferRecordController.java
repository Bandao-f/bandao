package com.ccsu.controller;
import com.alibaba.fastjson.JSONObject;
import com.ccsu.common.TransferRecord;
import com.ccsu.service.TransferRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("transferRecordController")
public class TransferRecordController {

    @Autowired
    private TransferRecordService transferRecordService;

    @GetMapping("/transfer")
    public String createTransferRecord(@RequestParam String param) {
        // 生成10以内的随机数字
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        TransferRecord transferRecord = new TransferRecord();
        transferRecord.setAlipayAccount(param);
        transferRecord.setTransferTime(new Date());
        transferRecord.setTransferStatus(0);
        // 设置随机金额并插入转账记录
        transferRecord.setAmount(randomNumber);

        System.out.println(JSONObject.toJSONString(transferRecord));
        // 查询当天已插入的转账记录数量
        Integer transCount = transferRecordService.getTransferRecordsByAccount(new Date(),param);
        if(transCount > 0){
            return "今天你已经申请过啦，请把机会让给其他人吧~或者加我的vx";
        }
        Integer todayAmount = transferRecordService.getTransferRecordsByDate(new Date());

        if (todayAmount >= 30) {
            return "今天的额度已经发完啦，请明天再试。😞";
        }

        transferRecordService.insertTransferRecord(transferRecord);

        return "我已经收到请求啦~ 等我看见消息以后就会给你转个"+randomNumber+"块钱的小红包，你迟一些你再去看叭~！😊";
    }
}