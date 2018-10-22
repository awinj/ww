//package test;
//
//import com.alibaba.rocketmq.client.producer.SendCallback;
//import com.alibaba.rocketmq.client.producer.SendResult;
//import com.alibaba.rocketmq.common.message.Message;
//import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
//import com.deppon.dpboot.module.mq.client.producer.impl.GenericsConcurrentlyProducer;
//import nc.bs.depponfs.background.MQConfig;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by aWin on 2018-08-07.
// */
//public class Produce {
//
//    private static String namesrvAddr = "10.230.20.224:8765";// /需要和资金系统确定
////    private static String namesrvAddr = "10.249.130.124:9876;10.249.130.125:9876;10.249.130.126:9876;10.249.130.134:9876;10.249.130.135:9876;10.249.130.136:9876";
//    private static String consumerGroup = "NHR_SOCIALSECURITY_CGROUP"; // /需要和资金系统确定
//    private static String topic = "BALANCE_FSSC_CALLBACK_SOCIALSECURITY";// /需要和资金系统确定
//    private static String tag = "*";
//
//    public static void main(String args[]) throws Throwable {
//        GenericsConcurrentlyProducer<String> producer=new GenericsConcurrentlyProducer<String>();
////        producer.setNamesrvAddr(namesrvAddr);
//        producer.setNamesrvAddr(namesrvAddr);
//        producer.setProducerGroup(consumerGroup);
//        producer.setInstanceName("test");
////        producer.setTopic(topic);
////        producer.sett.setTag(tag);
////        producer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
//
//        String s="{\"socialDispatchType\":\"PT\",\"socialProcessResultList\":[{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000344\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952641001F11000000011NNVU\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000346\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952671001F11000000011NNVW\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000347\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951151001F11000000011NNVR\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000348\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951131001F11000000011NNVQ\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000349\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951041001F11000000011NNVP\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000350\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952401001F11000000011NNVS\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000351\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952681001F11000000011NNVX\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000352\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952621001F11000000011NNVT\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000353\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952651001F11000000011NNVV\",\"workFlowType\":\"个人所得税（派遣）-付款\"}]}";
//
//        Message msg = new Message(MQConfig.Topic,MQConfig.Tag,("asd").getBytes(MQConfig.CharsetName) );
//        producer.startup();
//        producer.send(topic,tag,"",s,new SendCallback(){
//
//            public void onSuccess(SendResult sendResult) {
//                System.out.print("发送成功");
//            }
//
//            public void onException(Throwable throwable) {
//                System.out.print("发送失败");
//            }
//        });
//    }
//
//
//}
