//package com.demo.dao.jpa.conroller;
//
///**
// * Created by dell on 2020/7/10.
// */
//public class BBB {
//
//    ///杨志众 18:01:01
//    @RequestMapping(value = "/compatibleTest", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> installApp(@RequestBody Map<String, String> appmap) throws JSchException {
//        String devNum = appmap.get("devNum");
//        String pos = appmap.get("pos");
//        String barCode = appmap.get("barcode");
//        String appPath = appmap.get("appPath");
//        String appName = appmap.get("appName");
//        String status = appmap.get("status");
//        String ip_user_pwd_port = devTerminalAddrMap.get(pos);
//        String[] iupp = ip_user_pwd_port.split("_");
//        String ip = iupp[0];
//        String username = iupp[1];
//        String password = iupp[2];
//        String port = iupp[3];
//        Map<String, Object> resultMap = new HashMap<>();
//        if (devNum.equals("") || pos.equals("") || barCode.equals("") || appName.equals("") || devNum == null || pos == null || barCode == null || appName == null) {
//            resultMap.put("code", "1");
//            resultMap.put("msg", "输入参数有误，不能为空");
//        } else if (ip_user_pwd_port.equals("") || ip_user_pwd_port == null) {
//            resultMap.put("code", "1");
//            resultMap.put("msg", "设置装置的表位与终端对应关系为空");
//        } else {
//            resultMap.put("code", "0");
//            String msg = "", sshResult = "", containerName = "";
//            SshConfig sshc = null;
//            Date currentTime = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                appName= updateAppName(appName).get(0);
//                containerName=updateAppName(appName).get(1);
//              /*  if (appName.equals("advPuAmr")) {
//                    containerName = "advPuAmrContainer";
//                } else if (appName.equals("advPdAmr")) {
//                    containerName = "advPdAmrContainer";
//                } else if (appName.equals("dbCenter") || appName.equals("ccoRouter")) {
//                    containerName = "baseContainer";
//                } else if (appName.equals("taskManager")) {
//                    containerName = "edcContainer";
//                }*/
//
//                //杨志众 18:01:10
//                sshc = new SshConfig(username, ip, password, port);
//                if ("7".equals(status)) {
//                    File file = new File(appPath);
//                    if (!file.exists()) {
//                        resultMap.put("msg", "上传APP安装包文件:" + appName + "不存在！");
//                        resultMap.put("time", sdf.format(currentTime));
//                        logger.info(sdf.format(currentTime) + "上传APP安装包文件:" + appName + "不存在！");
//                        return resultMap;
//                    }
//                    sshc.upload("/usr/local/default/apps", appPath);
//                    resultMap.put("msg", "上传APP安装包文件:" + appName + "成功！");
//                    resultMap.put("time", sdf.format(currentTime));
//                    logger.info(sdf.format(currentTime) + "上传APP安装包文件:" + appName + "成功！");
//                } else if ("1".equals(status)) {
//                    if (!(containerName.equals(""))) {
//                        //   sshResult = sshc.sendssh(" sudo appm -i -c advPuAmrContainer -n advPuAmr -f /usr/local/default/apps/" + appName + ".tar");
//                        sshResult = sshc.sendssh(" sudo appm -i -c "+ containerName+" -n "+appName+" -f /usr/local/default/apps/" + appName + ".tar");
//                    } else {
//                        sshResult = sshc.sendssh(" tar -xvf /usr/local/default/apps/" + appName + ".tar -C /usr/local/extapps/");
//                    }
//                    resultMap.put("msg", "安装:" + appName + "成功！");
//                    resultMap.put("time", sdf.format(currentTime));
//                    logger.info(sdf.format(currentTime) + "安装:" + appName + "成功！");
//                } else if ("2".equals(status) || "3".equals(status)) {
//                    if (!(containerName.equals(""))) {
//                        sshResult = sshc.sendssh(" sudo appm -s -c "+ containerName+" -n " + appName);
//                    } else {
//                        //   sshResult = sshc.sendssh(" /usr/local/extapps/" + appName + "/bin/" + appName);
//                        sshResult = sshc.sendssh("sudo pkill -9 " + appName);
//                    }
//                    resultMap.put("msg", (status.equals("3") ? "运行:" : "启动:") + appName + "成功！");
//                    resultMap.put("time", sdf.format(currentTime));
//                    logger.info(sdf.format(currentTime) + (status.equals("3") ? "运行:" : "启动:") + appName + "成功！");
//                } else if ("4".equals(status)) {
//                    if (!(containerName.equals(""))) {
//                        sshResult = sshc.sendssh(" sudo appm -S -c "+ containerName+" -n " + appName);
//                    } else {
//                        sshResult = sshc.sendssh("sudo pkill -9 " + appName);
//                    }
//                    resultMap.put("msg", "停止:" + appName + "成功！");
//                    resultMap.put("time", sdf.format(currentTime));
//                    logger.info(sdf.format(currentTime) + "停止:" + appName + "成功！");
//                } else if ("5".equals(status)) {
//                    if (!(containerName.equals(""))) {
//                        sshResult = sshc.sendssh(" sudo appm -u -c "+ containerName+" -n " + appName);
//                        resultMap.put("msg", "卸载:" + appName + "成功！");
//                        logger.info(sdf.format(currentTime) + "卸载:" + appName + "成功！");
//                    } else {
//                        resultMap.put("msg", "非容器应用无需卸载！");
//                        logger.info(sdf.format(currentTime) + "非容器应用无需卸载");
//                    }
//                    resultMap.put("time", sdf.format(currentTime));
//                }else if("8".equals(status)){
//                    sshResult = sshc.sendssh("sudo pkill -9 " + appName);
//                    resultMap.put("msg", "重启:" + appName + "成功！");
//                    resultMap.put("time", sdf.format(currentTime));
//                    logger.info(sdf.format(currentTime) + "重启:" + appName + "成功！");
//                }
//
//                //杨志众 18:01:15
//            } catch (Exception e) {
//                resultMap.put("code", "1");
//                resultMap.put("time", sdf.format(currentTime));
//                resultMap.put("msg", "处理失败！" + e.getMessage());
//                return resultMap;
//            } finally {
//                if (sshc != null || sshc.session.isConnected()) {
//                    sshc.session.disconnect();
//                    sshc.session = null;
//                    sshc = null;
//                }
//            }
//
//
//        }
