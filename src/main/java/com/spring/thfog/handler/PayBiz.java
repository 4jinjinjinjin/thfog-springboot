package com.spring.thfog.handler;

import com.spring.thfog.entity.*;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.MemberRepository;
import com.spring.thfog.repository.OrderRepository;
import com.spring.thfog.repository.PayRepository;
import com.spring.thfog.repository.RoomRepository;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Title
 * @ClassName PayBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/20 19:49
 * @Version 1.0
 **/
@Component
public class PayBiz {
    @Autowired
    PayRepository payRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    MemberRepository memberRepository;

    public Object creatPay(Pay pay) {
        ReturnObject returnObject = new ReturnObject();
        pay.setOpertime(new Date());
        payRepository.saveAndFlush(pay);
        return returnObject;
    }

    public ReturnObject doPay(Integer flag, BigDecimal amount, Integer orderId, Integer memberId, String remark, Integer operator) {
        ReturnObject returnObject = new ReturnObject();
        RoomOrder order = orderRepository.findById(orderId).orElse(null);
        if (null == order) {
            returnObject.setState(-1);
            returnObject.setErrmsg("未查询到订单编号为【" + orderId + "】的订单信息");
            return returnObject;
        }
        Pay orderPay = new Pay();
        orderPay.setType(1);
        orderPay.setFlag(flag);
        orderPay.setAmount(amount);
        orderPay.setOrderId(orderId);
        orderPay.setOperator(operator);
        orderPay.setOpertime(new Date());
        orderPay.setRemark(remark);
        order.setRealPay(order.getRealPay().add(amount));
        orderRepository.save(order);
        if (flag == 4) {//会员支付
            Member member = memberRepository.findById(memberId).orElse(null);
            if (null == member) {
                returnObject.setState(-1);
                returnObject.setErrmsg("未查询到会员编号为【" + memberId + "】的会员信息");
                return returnObject;
            }
            if (member.getBalance().compareTo(amount) >= 0) {//余额充足
                orderPay.setMemberId(memberId);
                BigDecimal newBalance = member.getBalance().subtract(amount);
                member.setBalance(newBalance);
                memberRepository.save(member);

                Pay memberPay = new Pay();
                BeanUtils.copyProperties(orderPay, memberPay);
                memberPay.setType(2);
                memberPay.setAmount(amount.negate());
                payRepository.save(memberPay);
            } else {
                returnObject.setState(-1);
                returnObject.setErrmsg("会员【" + memberId + "】余额不足，无法完成结算。" + member.getBalance() + "||" + amount);
                return returnObject;
            }
        } else {
            orderPay.setMemberId(-1);
        }
        payRepository.save(orderPay);
        payRepository.flush();
        memberRepository.flush();
        orderRepository.flush();
        return returnObject;
    }

    public ReturnObject addMemBalance(Integer flag, BigDecimal amount, Integer memberId, String remark, Integer operator) {
        ReturnObject returnObject = new ReturnObject();
        Member member = memberRepository.findById(memberId).orElse(null);
        if (null == member) {
            returnObject.setState(-1);
            returnObject.setErrmsg("未查询到会员编号为【" + memberId + "】的会员信息");
            return returnObject;
        }
        Pay memberPay= new Pay();
        memberPay.setType(2);
        memberPay.setFlag(flag);
        memberPay.setAmount(amount);
        memberPay.setOrderId(-1);
        memberPay.setMemberId(memberId);
        memberPay.setOperator(operator);
        memberPay.setOpertime(new Date());
        memberPay.setRemark(remark);
        payRepository.save(memberPay);

        member.setBalance(member.getBalance().add(amount));
        memberRepository.save(member);
        memberRepository.flush();
        payRepository.flush();
        return returnObject;
    }

    public Object getPayByOrderId(Integer orderId) {
        List<Pay> pay=payRepository.getPayByOrderId(orderId);
        return pay;
    }

    public ReturnObject say886(Integer orderId,Integer operator) {
        ReturnObject returnObject=new ReturnObject();
        Optional<RoomOrder> roomOrder=orderRepository.findById(orderId);
        Optional<Room> room=roomRepository.findById(roomOrder.get().getRoomId());
        if (room.get().getOrderId().equals(orderId)){
            roomOrder.get().setState(1);
            roomOrder.get().setPayTime(new Date());
            roomOrder.get().setPayOperator(operator);
            orderRepository.saveAndFlush(roomOrder.get());
            room.get().setIsUse(0);
            room.get().setStartTime(null);
            room.get().setOrderId(null);
            roomRepository.saveAndFlush(room.get());
            return returnObject;
        }else {
            returnObject.setState(-1);
            returnObject.setErrmsg("房间号对应订单【"+room.get().getOrderId()+"】与订单号【"+orderId+"】不一致");
            return returnObject;
        }
    }
}
