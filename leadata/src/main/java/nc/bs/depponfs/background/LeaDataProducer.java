//package nc.bs.depponfs.background;/*
// * Licensed to the Apache Software Foundation (ASF) under one or more
// * contributor license agreements.  See the NOTICE file distributed with
// * this work for additional information regarding copyright ownership.
// * The ASF licenses this file to You under the Apache License, Version 2.0
// * (the "License"); you may not use this file except in compliance with
// * the License.  You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//import awin.dao.BaseDAO;
//import awin.dao.exception.DAOException;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.rocketmq.client.exception.MQClientException;
//import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
//import com.alibaba.rocketmq.client.producer.SendResult;
//import com.alibaba.rocketmq.client.producer.SendStatus;
//import com.alibaba.rocketmq.common.message.Message;
//import com.deppon.dpboot.module.common.serializer.factory.impl.GenericsHessianFactory;
//import com.deppon.dpboot.module.mq.client.producer.impl.GenericsConcurrentlyProducer;
//
//import java.util.List;
//
///**
// * 离职薪资数据生产者，将离职薪资数据发送到mq中间件
// */
//public class LeaDataProducer {
//
//    private boolean isStart=false;
//    private static LeaDataProducer leaProducer;
//
//    /**
//     * 私有的构造函数，保证实例只能从getInstance 得到
//     */
//    private LeaDataProducer(){
//
//    }
//
//    /**
//     *
//     * @return 单例
//     */
//    public static LeaDataProducer getInstance(){
//        synchronized (leaProducer)
//        {
//            if(leaProducer==null)
//            {
//                leaProducer=new LeaDataProducer();
//            }
//        }
//        return leaProducer;
//    }
//
//
//    /**
//     *
//     * @return 获得离职薪资数据，包括正式人员和实习生的离职薪资数据
//     */
//    private List<LeaDataVO> getLeaDatas(){
//        List<LeaDataVO> leadata=getZSRYLeadata();//正式人员离职薪资数据
//        List<LeaDataVO> sxsLeadata=getSXSLeadata();//实习生离职薪资数据
//        if(leadata==null)
//            return  sxsLeadata;
//        if(sxsLeadata==null)
//            return leadata;
//        leadata.addAll(sxsLeadata);
//        return leadata;
////        return list;
//    }
//
//
//    /**
//     *
//     * @return 获得实习生离职薪资数据
//     */
//    private  List<LeaDataVO> getSXSLeadata()
//    {
//        StringBuilder sql=new StringBuilder("");
//        sql.append(" select wa.personalloan repayded,  'Y' istrainee,   wa.pk_t_intern_wadate pk,	                                             ");
//        sql.append(" wa.taxed taxded,                                                                   ");
//        sql.append(" wa.otherpay otherded,                                                              ");
//        sql.append(" wa.balancead balancead,                                                            ");
//        sql.append(" dept.deptcode,                                                                     ");
//        sql.append(" dept.deptname,                                                                     ");
//        sql.append(" job.jobcode,                                                                       ");
//        sql.append(" job.jobname,                                                                       ");
//        sql.append(" def.docname jobtype,                                                               ");
//        sql.append(" psn.psncode,                                                                       ");
//        sql.append(" psn.psnname,                                                                       ");
//        sql.append(" peroid.cyear||peroid.cmonth yearmonth                                              ");
//        sql.append("  from dbwlhr.t_intern_wadata wa                                                    ");
//        sql.append(" inner join dbwlhr.bd_psndoc psn on wa.pk_psndoc=psn.pk_psndoc                      ");
//        sql.append(" inner join dbwlhr.bd_deptdoc dept on wa.deptname=dept.pk_deptdoc                   ");
//        sql.append(" inner join dbwlhr.om_job job on wa.jobname =job.pk_om_job                          ");
//        sql.append(" inner join dbwlhr.bd_defdoc def on job.groupdef4=def.pk_defdoc                     ");
//        sql.append(" inner join t_lea_planperiod peroid on wa.pk_lea_planperiod=peroid.pk_planperiod    ");
//        sql.append(" where     nvl(kingdee7,' ')!='已推送'    and wa.def9='汇款成功'    and rownum<5 order by wa.ts desc                 ");
//        //sql.append(" and wa.ts<='").append(MQConfig.getLastSysnTime()).append("'	and  rownum=1    					                          ");
//        BaseDAO dao=new BaseDAO();
//        try {
//            return dao.query(LeaDataVO.class,sql.toString());
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     *
//     * @return 获得正式人员离职薪资数据
//     */
//    private  List<LeaDataVO> getZSRYLeadata()
//    {
//        StringBuilder sql=new StringBuilder();
//        sql.append(" select primonthdeduct,			  'N' istrainee,		wa.pk_lea_wadata pk,													");
//        sql.append(" wa.groupdef23 personnelfee,                                                                ");
//        sql.append(" familyded,                                                                                 ");
//        sql.append(" feeded,                                                                                    ");
//        sql.append(" socialded,                                                                                 ");
//        sql.append(" housingded,                                                                                ");
//        sql.append(" repayded,                                                                                  ");
//        sql.append(" stayded,                                                                                   ");
//        sql.append(" partydues,                                                                                 ");
//        sql.append(" acccardmny,                                                                                ");
//        sql.append(" otherded,                                                                                  ");
//        sql.append(" wa.groupdef12 surpluswages,                                                                ");
//        sql.append(" emphandbookmny,                                                                            ");
//        sql.append(" carded,                                                                                    ");
//        sql.append(" totalreward,                                                                               ");
//        sql.append(" psn.pk_psndoc,                                                                             ");
//        sql.append(" psn.psncode,                                                                               ");
//        sql.append(" psn.psnname,                                                                               ");
//        sql.append(" industrialinjury,                                                                          ");
//        sql.append(" wa.psncode,                                                                                ");
//        sql.append(" workclothesmny,                                                                            ");
//        sql.append(" workcardmny,                                                                               ");
//        sql.append(" salaryzk,                                                                                  ");
//        sql.append(" balancead,                                                                                 ");
//        sql.append(" totalded,                                                                                  ");
//        sql.append(" wa.pk_lea_planperiod,                                                                      ");
//        sql.append(" peroid.cyear||peroid.cmonth yearmonth,                                                     ");
//        sql.append(" taxded,                                                                                    ");
//        sql.append(" socialunit,                                                                                ");
//        sql.append(" debded,                                                                                    ");
//        sql.append(" compensaded,                                                                               ");
//        sql.append(" discided,                                                                                  ");
//        sql.append(" socialsecuritycardmny,                                                                     ");
//        sql.append(" deptjob.docname jobtype,                                                                   ");
//        sql.append(" deptjob.def9 deptstncode                                                                   ");
//        sql.append("  from t_lea_wadata wa                                                                      ");
//        sql.append("  inner join bd_psndoc psn on wa.pk_psndoc=psn.pk_psndoc                                    ");
//        sql.append("  left join (                                                                               ");
//        sql.append(" select jobname,jobcode,deptname,deptcode,docname,dept.def9   from                          ");
//        sql.append(" dbwlhr.om_job job                                                                          ");
//        sql.append(" inner join dbwlhr.bd_deptdoc dept on job.pk_deptdoc =dept.pk_deptdoc                       ");
//        sql.append(" left join dbwlhr.bd_defdoc def on job.groupdef4=def.pk_defdoc                              ");
//        sql.append(" where nvl(job.dr,0)=0 and nvl(job.isabort,'N')='N'                                         ");
//        sql.append(" and nvl(dept.dr,0)=0                                                                       ");
//        sql.append(" and nvl(def.dr,0)=0 and nvl(dept.hrcanceled,'N')='N'                                       ");
//        sql.append(" )  deptjob on wa.pk_om_job=deptjob.jobname and wa.pk_deptdoc=deptjob.deptname              ");
//        sql.append("  inner join t_lea_planperiod peroid on wa.pk_lea_planperiod=peroid.pk_planperiod           ");
//        sql.append(" where   nvl(kingdee7,' ')!='已推送'  and  wa.groupdef19='汇款成功' and rownum<5 order by wa.ts desc  ");
//        //sql.append(" and wa.ts<='").append(MQConfig.getLastSysnTime()).append("'		and  rownum=1    				                     ");
//
//        BaseDAO dao=new BaseDAO();
//        try {
//            return  dao.query(LeaDataVO.class,sql.toString());
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    /**
//     *发送离职薪资数据
//     * @throws Exception 异常
//     */
//    public void sendLeaData() throws Exception {
//
////        List<LeaDataVO> leaDataVOs = getLeaDatas();
////        if(leaDataVOs==null|| leaDataVOs.size()<=0)
////            return ;
//        //TODO 若果数据量过大，要分批发送，每500条发送一次
//
//
//        GenericsConcurrentlyProducer<String> producer = new GenericsConcurrentlyProducer<String>();
////        DefaultMQProducer producer = new DefaultMQProducer(MQConfig.ProducerGroup);
//
//        producer.setSerializer(new GenericsHessianFactory<String>().getSerializer());
//        producer.setNamesrvAddr(MQConfig.getNameSrvAddr());
//        try {
//            if(!isStart)
//            {
//                producer.startup();
//                isStart=true;
//            }
//        } catch (Throwable e) {
//            throw new Exception("生产者start失败，请检查服务是否正常");
//        }
//        String parse=JSON.toJSONString("test");
//
//        try {
//
//            Message msg = new Message(MQConfig.Topic,MQConfig.Tag,(parse).getBytes(MQConfig.CharsetName) );
//
//
//
//            Boolean result =  producer.send(MQConfig.Topic, MQConfig.Tag, "", parse, null);
////            SendResult sendResult = producer.send(msg);
//            if(result)
//            {
//                System.out.println("消息发送成功："+parse);
//                //回写状态数据状态
//                //更新t_intern_wadate ,t_lea_wadata 的字段kingdee7 为 已推送   TODO
//                //更新最新同步时间   TODO
//            }
//            else
//            {
//                throw new Exception("发送消息失败");
//            }
//        }  catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception("发送消息失败"+e.getMessage());
//        }
//        finally {
//            if(isStart)
//            {
//                producer.shutdown();
//                isStart=false;
//            }
//
//        }
//    }
//
//    /**
//     * 测试方法
//     * @param args 参数
//     * @throws Exception 异常
//     */
//    public static void main(String[] args) throws Exception {
//
//         new LeaDataProducer().sendLeaData();
//    }
//
//}
