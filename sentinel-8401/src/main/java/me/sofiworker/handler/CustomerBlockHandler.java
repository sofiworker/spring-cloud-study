package me.sofiworker.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import me.sofiworker.entities.CommonResult;
import me.sofiworker.entities.Payment;

/**
 * @author sofiworker
 * @date 2020/7/15  20:54
 */
public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException e) {
        return new CommonResult(4444, "按客户自定义的全局限流异常处理------------>1");
    }

    public static CommonResult handleException2(BlockException e) {
        return new CommonResult(4444, "按客户自定义的全局限流异常处理------------>2");
    }
}
