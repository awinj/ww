//package test;
//
//import java.io.IOException;
//
//
//import com.alibaba.rocketmq.client.producer.SendCallback;
//import com.alibaba.rocketmq.client.producer.SendResult;
//import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
//import com.deppon.dpboot.module.mq.client.producer.impl.GenericsConcurrentlyProducer;
//
//import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
//
//public class SocialCallBackRequestProducer {
//	 protected GenericsConcurrentlyProducer<String> producer = new GenericsConcurrentlyProducer<String>();
//	    private String namesrvAddr="10.230.20.224:8765";
//	    private String producerGroup="FSSC_CALLBACK_SOCIALSECURITY_PGROUP";
//	    private String topic="BALANCE_FSSC_CALLBACK_SOCIALSECURITY";
//	    private String tag;
//
//	    public SocialCallBackRequestProducer() {
//	    }
//
//	    public void startup() {
//	        producer.setProducerGroup(producerGroup);
//	        producer.setNamesrvAddr(namesrvAddr);
//
//
//	         producer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
//	        try {
//	             producer.startup();
//	        } catch (Throwable e) {
//	        }
//	    }
//
//	    public void shutdown() {
//	        producer.shutdown();
//	    }
//
//	    public void send() {
//	    	String req = "{\"socialDispatchType\":\"PT\",\"socialProcessResultList\":[{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000344\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952641001F11000000011NNVU\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000346\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952671001F11000000011NNVW\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000347\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951151001F11000000011NNVR\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000348\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951131001F11000000011NNVQ\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000349\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028951041001F11000000011NNVP\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000350\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952401001F11000000011NNVS\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000351\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952681001F11000000011NNVX\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000352\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952621001F11000000011NNVT\",\"workFlowType\":\"个人所得税（派遣）-付款\"},{\"result\":\"1\",\"reason\":\"报账成功\",\"workFlowNo\":\"FSSC106180802000353\",\"socialDispatchDetail\":[],\"businessId\":\"DPPT15332028952651001F11000000011NNVV\",\"workFlowType\":\"个人所得税（派遣）-付款\"}]}";
//
//			Boolean result =  producer.send(topic, tag, "FSSC106180802000346", req, null);
////			log.info("SocialCallBackRequestProducer send result:"+result);
//	    }
//
//	    public static void main(String[] args)
//		{
//			SocialCallBackRequestProducer p=new SocialCallBackRequestProducer();
//			p.startup();
//			p.send();
//			p.shutdown();
//		}
//
//
//	    public String getNamesrvAddr() {
//	        return namesrvAddr;
//	    }
//
//	    public void setNamesrvAddr(String namesrvAddr) {
//	        this.namesrvAddr = namesrvAddr;
//	    }
//
//	    public String getProducerGroup() {
//	        return producerGroup;
//	    }
//
//	    public void setProducerGroup(String producerGroup) {
//	        this.producerGroup = producerGroup;
//	    }
//
//	    public String getTopic() {
//	        return topic;
//	    }
//
//	    public void setTopic(String topic) {
//	        this.topic = topic;
//	    }
//
//	    public String getTag() {
//	        return tag;
//	    }
//
//	    public void setTag(String tag) {
//	        this.tag = tag;
//	    }
//}
