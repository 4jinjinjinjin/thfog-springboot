package com.spring.thfog.handler;

import com.spring.thfog.entity.OrderDetail;
import com.spring.thfog.entity.RoomOrder;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.OrderDetailRepository;
import com.spring.thfog.repository.OrderRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Title
 * @ClassName OrderBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/12 22:23
 * @Version 1.0
 **/
@Component
public class OrderBiz {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Integer creatOrder(Integer roomId,Integer empId) {
        Integer id=orderRepository.getMaxId();
        if (null==id){
            id=1;
        }else {
            id++;
        }
        RoomOrder newOrder = new RoomOrder();
        newOrder.setId(id);
        newOrder.setRoomId(roomId);
        newOrder.setOperator(empId);
        newOrder.setOpertime(new Date());
        orderRepository.saveAndFlush(newOrder);
        return id;
    }

    public Object getOrderDetailById(Integer orderId) {
        List<OrderDetail> orderDetails=orderDetailRepository.getOrderDetailById(orderId);
        return orderDetails;
    }

    @Transactional(rollbackFor = Exception.class)
    public ReturnObject creatOrderDetail(OrderDetail orderDetail) {
        ReturnObject returnObject=new ReturnObject();
        orderDetail.setOpertime(new Date());
        orderDetailRepository.saveAndFlush(orderDetail);
        return returnObject;
    }

    public void delOrderDetail(Integer id) {
        orderDetailRepository.deleteById(id );
    }
}
