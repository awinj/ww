/**
 * @Description
 * @author   
 * @date 2018-7-27下午7:51:02  
 * 
 */
package test;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
import com.deppon.dpboot.module.mq.client.consumer.GenericsMessageConsumer;
import com.deppon.dpboot.module.mq.client.consumer.impl.GenericsConcurrentlyConsumer;

/**
 * @author Administrator
 * 
 */
public class ResponseInfoPortAction implements
		GenericsMessageConsumer<String> {
	protected GenericsConcurrentlyConsumer<String> consumer = new GenericsConcurrentlyConsumer<String>();


	// private String namesrvAddr =
	// "10.249.131.116:9876;10.249.131.117:9876;10.249.131.118:9876";
	private String namesrvAddr = "10.230.20.224:8765";// /需要和资金系统确定
//	private String namesrvAddr = "10.249.130.124:9876;10.249.130.125:9876;10.249.130.126:9876;10.249.130.134:9876;10.249.130.135:9876;10.249.130.136:9876";
//	private String consumerGroup = "NHR_SOCIALSECURITY_CGROUP"; // /需要和资金系统确定
	private String consumerGroup = "FSSC_CALLBACK_SOCIALSECURITY_PGROUP111";
	private String topic = "BALANCE_FSSC_CALLBACK_SOCIALSECURITY";// /需要和资金系统确定

	private String tag = "*";



	 @PostConstruct
	public void startup() {
//		 namesrvAddr="10.249.131.116:9876;10.249.131.117:9876;10.249.131.118:9876";
		consumer.setNamesrvAddr(namesrvAddr);
		consumer.setConsumerGroup(consumerGroup);
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		consumer.setTopic(topic);
		consumer.setTag(tag);
		consumer.setMessageConsumer(this);
		consumer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
		try {
			consumer.startup();
			System.out.print("启动");
		} catch (Throwable e) {
		}
	}

	/**
	 * @Description
	 * @author
	 * @time 2018-7-27下午8:36:04
	 * 
	 */
	public void onConsume(String s) {
		System.out.print("收到："+s);
		try {

			if (s != null) {
				SocialProcessEntity socialProcessEntity = JSON.parseObject(s,
						SocialProcessEntity.class);
				String socialDispatchType = socialProcessEntity
						.getSocialDispatchType();
				HashMap<String, String> distypeHm = new HashMap<String, String>();
				distypeHm.put("SM", "dpfs_dispatchaccount");
				distypeHm.put("PT", "dpfs_dispatchertaxaccount");
				distypeHm.put("BS", "dpfs_insuranceaccount");
				List<SocialProcessResult> socialProcessResultList = socialProcessEntity
						.getSocialProcessResultList();
				if (socialProcessResultList != null
						&& socialProcessResultList.size() > 0) {
					for (SocialProcessResult res : socialProcessResultList) {

						/* 业务唯一标识 */
						String businessId = res.getBusinessId() == null ? ""
								: res.getBusinessId();
						if (businessId == null || businessId.equals("")) {
							throw new Exception("业务数据唯一标识为空");
						}
						/* 工作流号 */
						String workFlowNo = res.getWorkFlowNo() == null ? ""
								: res.getWorkFlowNo();
						/*
						 * 工作流类型 String workFlowType =
						 * parameters.getWorkFlowType(); 返回结果 String result =
						 * parameters.getResult(); 失败原因 String reason =
						 * parameters.getReason();
						 */
						String headResult = res.getResult();
						String headReason = res.getReason() == null ? "" : res
								.getReason();
						List<SocialDispatchDetail> socialDispatchDetail = res
								.getSocialDispatchDetail();

						System.out.println("唯一标识：" + businessId + " 工作流号:"
								+ workFlowNo);
						System.out.println("处理结果:" + headReason);
						if (headResult != null && headResult.equals("1")) {
							System.out.println("###########报账dnal##########");
							// 如果成功，则直接更新全部明细为成功
							StringBuffer sql = new StringBuffer();
							sql.append("update "
									+ distypeHm.get(socialDispatchType)
									+ " set dataresult='" + headReason
									+ "',payflownum='" + workFlowNo + "' ");
							sql.append("where fsscbusinessid='" + businessId
									+ "' and nvl(dr,0)=0");
							System.out.println("###########报账成功Sql: " + sql);
//							iResponseInfoPort.updateProcessCallBack(sql
//									.toString());
							// NCLocator.getInstance().lookup(IAuthorAddBySocunit.class).modifySocialDispatchDetail(sql.toString());
						} else {
							// 如果失败，则更新具体原因
							System.out.println("###########报账失败##########");
							if (socialDispatchDetail == null
									|| socialDispatchDetail.size() == 0) {
								// throw new
								// BusinessException("##############处理明细List为空################");
								StringBuffer sql = new StringBuffer();
								sql.append("update "
										+ distypeHm.get(socialDispatchType)
										+ " set dataresult='" + headReason
										+ "',vstatus='0' ");
								sql.append("where fsscbusinessid='"
										+ businessId + "' and nvl(dr,0)=0");
								System.out
										.println("###########报账失败Sql: " + sql);
//								iResponseInfoPort.updateProcessCallBack(sql
//										.toString());
							} else {
								for (SocialDispatchDetail detail : socialDispatchDetail) {
									String vpsncode = detail.getEmployeeCode() == null ? ""
											: detail.getEmployeeCode();
									if (vpsncode == null || vpsncode.equals("")) {
										throw new Exception("明细工号为空");
									}
									String reason = detail.getReason() == null ? ""
											: detail.getReason();
									String datailReason = (detail.getResult() != null && detail
											.getResult().equals("0")) ? headReason
											+ "," + reason
											: headReason;
									System.out.println("工号：" + vpsncode
											+ "失败原因:" + reason);
									StringBuffer sql = new StringBuffer();
									sql.append("update "
											+ distypeHm.get(socialDispatchType)
											+ " set dataresult='"
											+ datailReason + "' ");
									sql.append(",vstatus='0' ");
									sql.append("where fsscbusinessid='"
											+ businessId
											+ "' and nvl(dr,0)=0 and vpsncode='"
											+ vpsncode + "'");
									System.out.println("###########报账失败Sql: "
											+ sql);
//									iResponseInfoPort.updateProcessCallBack(sql
//											.toString());
								}
							}

						}
					}
				}

			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
	
	@PreDestroy
    public void shutdown() {
        consumer.shutdown();
    }


    public static void main(String args[])
	{
		ResponseInfoPortAction a=new ResponseInfoPortAction();
		a.startup();
	}
}
