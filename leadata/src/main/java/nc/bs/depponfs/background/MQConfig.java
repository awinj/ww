//package nc.bs.depponfs.background;
//
//import awin.dao.BaseDAO;
//import awin.dao.exception.DAOException;
//
//import java.util.List;
//
///**
// * Created by aWin on 2018-07-20.
// */
//public class MQConfig {
//    public final static String ProducerGroup = "MQ-LeaData-GROUP";
//    public final static String Topic = "Topic-MQ-LeaData";
//    public final static String Tag = "TagA";
//    public final static String CharsetName = "UTF-8";
//    private static String nameSrvAddr;
//    private static String lastSysnTime;
//
//
//    public static String getNameSrvAddr() {
//        if (nameSrvAddr == null) {
//            try {
//                List<ConfigVO> configs = new BaseDAO().query(ConfigVO.class, "select * from mid_config where systemcode='FSSC' and parakey='NameSrvAddr'");
//                if (configs != null && configs.size() > 0) {
//                    for (ConfigVO config : configs) {
//                        if ("NameSrvAddr".equals(config.getParakey())) {
//                            nameSrvAddr = config.getParavalue();
//                        }
//                    }
//                }
//            } catch (DAOException e) {
//                e.printStackTrace();
//            }
//        }
//        if (nameSrvAddr == null) {
//            nameSrvAddr = "10.230.20.224:8765";
//        }
//        return nameSrvAddr;
//    }
//
//    public static String getLastSysnTime() {
//        try {
//            List<ConfigVO> configs = new BaseDAO().query(ConfigVO.class, "select * from mid_config where systemcode='FSSC' and parakey='LastSysnTime'");
//            if (configs != null && configs.size() > 0) {
//                for (ConfigVO config : configs) {
//                    if ("LastSysnTime".equals(config.getParakey())) {
//                        lastSysnTime = config.getParavalue();
//                    }
//                }
//            }
//        } catch (DAOException e) {
//            e.printStackTrace();
//        }
//        if (lastSysnTime == null)
//            lastSysnTime = "2018-01-01 00:00:00";
//        return lastSysnTime;
//    }
//
//}
