package nc.bs.depponfs.background;

import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
import com.deppon.dpboot.module.mq.client.consumer.GenericsMessageConsumer;
import com.deppon.dpboot.module.mq.client.consumer.impl.GenericsConcurrentlyConsumer;

/**
 * Created by 刘静 on 2018/5/14.
 */
public class Consume implements GenericsMessageConsumer<String> {
    protected GenericsConcurrentlyConsumer<String> consumer = new GenericsConcurrentlyConsumer<String>();



    private String namesrvAddr = "10.230.20.224:8765";
    private String consumerGroup = "MQ-LeaData-GROUP";
    private String topic = "Topic-MQ-LeaData";
    private String tag = "*";
    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Consume() {
    }
    public void startup() {
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumerGroup(consumerGroup);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setTopic(topic);
        consumer.setTag(tag);
        consumer.setMessageConsumer(this);
        consumer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
        try {
            consumer.startup();
        } catch (Throwable e) {
        }
    }

    public void shutdown() {
        consumer.shutdown();
    }


    public void onConsume(String s) {

        System.out.println(s);
    }


    public static void main(String[] args)
    {
        new Consume().startup();
    }

}