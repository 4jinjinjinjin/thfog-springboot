package com.spring.thfog.handler;

import com.spring.thfog.entity.Room;
import com.spring.thfog.handler.common.ReturnObject;
import com.spring.thfog.repository.RoomRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Object findAllRoom() {
        return roomRepository.findAll();
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
}
