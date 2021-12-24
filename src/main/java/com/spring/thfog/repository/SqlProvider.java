package com.spring.thfog.repository;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @Title
 * @ClassName SqlProvider
 * @Description TODO
 * @Author 金金金金
 * @Date Created in 2021/12/8 23:50
 * @Version 1.0
 **/
public class SqlProvider {

    public String findAllGoodsSql(Map<String,Object> para){
        return new SQL(){{
            SELECT("id,goods_name goodsName,goods_price goodsPrice,goods_type goodsType");
            FROM("goods");
            if (null!=para.get("goodsType1")&&-1!=(Integer)para.get("goodsType1")){
                WHERE("goods_type="+(Integer)para.get("goodsType1"));
            }
        }}.toString();
    }


    public String getGoodsData(Map<String,Object> para){
        return "select a.goods_id goodsId,b.goods_type goodsType,a.goods_name goodsName,sum(a.goods_num) goodsNum,sum(a.real_amount) goodsAmount " +
                "from order_detail a,goods b where a.goods_id=b.id and a.order_id in (select k.id from room_order k where k.state = 1 " +
                "and date(k.pay_time) between '"+para.get("date1")+"' and '"+para.get("date2")+"') group by a.goods_id ,b.goods_type ,a.goods_name";
    }

    public String getOrderData(Map<String,Object> para){
        return "select a.id orderId,a.room_id orderRoomId,b.name orderRoomName," +
                "a.amount amount,a.real_pay realPay,a.pay_time paytime,a.pay_operator,c.username payname " +
                "from room_order a,room b,user c where a.room_id=b.id and a.pay_operator = c.id " +
                " and a.state =1 and date(a.pay_time) between '"+para.get("date1")+"' and '"+para.get("date2")+"'";
    }


    public String findPayDetail(String orderId){
        return "select a.flag type,a.amount amount,a.member_id memberId, " +
                "               b.name memberName,a.opertime opertime,a.remark,c.username opername " +
                "               from pay a left join member b on a.member_id = b.id left join user c on a.operator=c.id " +
                "                where a.type =1 and a.order_id ="+orderId+" order by a.id ";
    }

    public String findOrderDetail(String orderId){
        return "select a.id,g.goods_type goodsType,a.goods_id goodsId," +
                "            a.goods_price goodsPrice," +
                "            a.goods_name goodsName,a.goods_num goodsNum,a.real_amount realAmount " +
                "            ,a.operator,a.opertime,a.remark,b.username opername " +
                "     from order_detail a left join user b on a.operator=b.id " +
                "left join goods g on a.goods_id = g.id where a.order_id="+orderId+" order by a.id ";
    }
}
