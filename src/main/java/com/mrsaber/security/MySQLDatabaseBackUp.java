package com.mrsaber.security;

import java.io.*;

/**
 * MySQL数据库备份
 *
 */
public class MySQLDatabaseBackUp {

    /**
     * Java代码实现MySQL数据库导出
     *
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     */
    public static boolean exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }

        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                printWriter.println(line);
            }
            printWriter.flush();
            if(process.waitFor() == 0){//0 表示线程正常终止。
                return true;
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *
     * @param fPath Sql文件路径
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName root
     * @param passWord 123456
     * @param databaseName 数据库名称
     * @return
     */
    public static boolean importDatabaseTool(String fPath, String hostIP, String userName,
                             String passWord, String databaseName) {
        try {
            System.out.println("还原开始·······");
            // String fPath = "c:/test.sql";
            Runtime rt = Runtime.getRuntime();
            // 调用mysql的cmd命令
            Process child = rt.exec("mysql -u" + userName + " -p" + passWord
                    + "  " + databaseName);
            OutputStream out = child.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fPath), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);

            writer.flush();

            out.close();
            br.close();
            writer.close();
            System.out.println("还原成功······");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("还原失败······");
            return false;
        }
        return true;
    }
}

