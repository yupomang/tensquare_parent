package com.tensquare.test;

import com.tensquare.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg1(){
        rabbitTemplate.convertAndSend("itcast","直接测试模式");
    }

    /*
    * 分裂模式
    * */
    @Test
    public void sendMsg2(){
        rabbitTemplate.convertAndSend("chuanzhi","","分裂模式测试");
    }

    /*
     * 主题模式
     * */
    @Test
    public void sendMsg3(){
        rabbitTemplate.convertAndSend("topicparent","good.log","主题模式测试");
    }
}
