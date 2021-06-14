package com.spring.thfog.controller;

import com.spring.thfog.entity.Room;
import com.spring.thfog.handler.RoomBiz;
import com.spring.thfog.handler.common.DescribableEnum;
import com.spring.thfog.handler.common.JsonResult;
import com.spring.thfog.handler.common.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title
 * @ClassName RoomController
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/6/9 23:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/thefog/room")
public class RoomController {

    @Autowired
    private RoomBiz roomBiz;


    @GetMapping("/findAllRoom")
    public Object findAllRoom(){
        return new JsonResult(DescribableEnum.SUCCESS, roomBiz.findAllRoom());
    }

    @GetMapping("/findRoom")
    public Object findAllRoom(Integer id){
        return new JsonResult(DescribableEnum.SUCCESS, roomBiz.findRoom(id));
    }

    @GetMapping("/creatRoom")
    public Object creatRoom(Integer id,String name,String remark){
        ReturnObject returnObject= roomBiz.creatRoom(id,name,remark);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }

    @GetMapping("/creatOrder")
    public Object creatOrder(Integer roomId,Integer empId){
        ReturnObject returnObject= roomBiz.creatOrder(roomId,empId);
        if (returnObject.getIserr()){
            return new JsonResult(DescribableEnum.FAIL, returnObject.getErrmsg());
        }else {
            return new JsonResult(DescribableEnum.SUCCESS, returnObject.getResult());
        }
    }
}
