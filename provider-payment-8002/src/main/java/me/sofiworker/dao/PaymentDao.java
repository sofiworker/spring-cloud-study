package me.sofiworker.dao;

import me.sofiworker.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2020/5/3 18:03
 */
@Mapper
public interface PaymentDao {
    @Insert("insert into payment (serial) values (#{serial})")
    int create(Payment payment);
    @Select("select * from payment where id = #{id}")
    Payment getPaymentById(Long id);
}
