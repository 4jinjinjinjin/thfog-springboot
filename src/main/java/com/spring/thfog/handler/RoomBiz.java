package com.spring.thfog.handler;

import com.spring.thfog.entity.OrderDetail;
import com.spring.thfog.entity.Room;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.OrderRepository;
import com.spring.thfog.repository.RoomRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Title
 * @ClassName RoomBiz
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/9 23:34
 * @Version 1.0
 **/
@Component
public class RoomBiz {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private OrderBiz orderBiz;

    public Object findAllRoom() {
        return roomRepository.findAll();
    }

    public Object findRoom(Integer id) {
        return roomRepository.findById(id);
    }

    public ReturnObject creatRoom(Integer id,String name, String remark) {
        ReturnObject returnObject=new ReturnObject();
        Room roomNew= new Room();
        if (null!=id){
            roomNew= roomRepository.findById(id).orElse(new Room());
        }
        roomNew.setName(name);
        roomNew.setRemark(StringUtils.isNotBlank(remark)?remark:" ");
        roomRepository.saveAndFlush(roomNew);
        return returnObject;
    }

    @Transactional(rollbackFor = Exception.class)
    public ReturnObject creatOrder(Integer roomId, Integer empId) {
        ReturnObject returnObject=new ReturnObject();
        Room roomCheck=roomRepository.findById(roomId).orElse(null);
        if (null==roomCheck){
            returnObject.setState(-1);
            returnObject.setErrmsg("未查询到【"+roomId+"】对应的房间信息。");
            return returnObject;
        }
        if (1==roomCheck.getIsUse()||null!=roomCheck.getOrderId()){
            returnObject.setState(-1);
            returnObject.setErrmsg("当前房间【"+roomId+"】已被使用，请刷新确认。");
            return returnObject;
        }
        //1. 插入订单表
        Integer orderId=orderBiz.creatOrder(roomId,empId);
        roomCheck.setIsUse(1);
        roomCheck.setStartTime(new Date());
        roomCheck.setOrderId(orderId);
        roomRepository.saveAndFlush(roomCheck);
        return returnObject;
    }
}
