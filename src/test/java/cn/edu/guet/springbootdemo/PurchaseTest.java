package cn.edu.guet.springbootdemo;

import cn.edu.guet.springbootdemo.bean.PurchaseContract;
import cn.edu.guet.springbootdemo.bean.PurchasePaymentContract;
import cn.edu.guet.springbootdemo.mapper.PurchaseMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author 钟荣钊
 * @Date 2023/02/12
 * @Version 1.0
 */
@SpringBootTest
public class PurchaseTest {

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Test
    public void getAllTest(){
//        List<PurchaseContract> purchaseContractList = purchaseMapper.getPurchasePaymentContract();
//        Gson gson=new Gson();
//        System.out.println(gson.toJson(purchaseContractList));

        List list = purchaseMapper.getPurchaseDirectorState();
        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
    }

    @Test
    public void getOneTest(){
        List<PurchaseContract> purchaseContractList = purchaseMapper.getPurchaseContractById(197);
        System.out.println(purchaseContractList);
    }

    @Test
    public void addTest(){
//        Date inboundTime = new Date(System.currentTimeMillis());
//        BigDecimal goodsCount = new BigDecimal(2000);
//        BigDecimal paymentAmount = new BigDecimal(3020000.00);
//        BigDecimal unpaidAmount = new BigDecimal(3020000.00);
//        Timestamp createTime = new Timestamp(System.currentTimeMillis());
//        Timestamp lastUpdateTime = new Timestamp(System.currentTimeMillis());
//        PurchaseContract purchaseContract=new PurchaseContract(347,"addtest2","龙州南华糖业有限责任公司",
//                "广西永湘贸易有限责任公司","2022/2023",inboundTime,"甘蔗糖蜜",goodsCount,"吨",null, paymentAmount,
//                unpaidAmount,"http://120.77.28.123:9000/static/images/9ccc6bb8b69441b79ffc155fa98700c4.jpg",
//                1,0,0,0,createTime,"韩娜",lastUpdateTime,"韩娜");
//        purchaseMapper.addPurchaseContract(purchaseContract);

        PurchasePaymentContract purchasePaymentContract = new PurchasePaymentContract();
        purchasePaymentContract.setPurchaseContractNo("addTest");
        purchaseMapper.addPurchasePaymentContract(purchasePaymentContract);
    }

    @Test
    public void Test(){
        Date inboundTime = new Date(System.currentTimeMillis());
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        System.out.println(inboundTime);
        System.out.println(createTime);
    }

    @Test
    public void updateTest(){
        PurchaseContract purchaseContract=new PurchaseContract();
        purchaseContract.setId(347);
        purchaseContract.setPurchaseContractNo("updateTest");
        purchaseMapper.updatePurchaseContract(purchaseContract);
    }

    @Test
    public void deleteTest(){
        //purchaseMapper.deletePurchaseContractById(346);
        purchaseMapper.deletePurchasePaymentContractById(27);
    }
}
