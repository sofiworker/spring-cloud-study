package me.sofiworker.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;
import me.sofiworker.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sofiworker
 * @date 2020/7/13  17:28
 */
@RestController
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    private static final String SERVER_URL = "http://payment-service";

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback", fallback = "handleFallback") //只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "handleBlock") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handleFallback",
            blockHandler = "handleBlock", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> paymentInfo(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(SERVER_URL + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("参数非法异常！！");
        }else if (result.getData() == null){
            throw new NullPointerException("id没有对应记录，空指针异常");
        }
        return result;
    }

    public CommonResult handleBlock(Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(445, "handleBlock，异常信息为："+e.getMessage(), payment);
    }

    public CommonResult handleFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "handleFallback，异常信息为："+e.getMessage(), payment);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {
        return paymentService.paymentSQL(id);
    }
}
