/**
 * @项目名称：AutomaticPackaging
 * @文件名：DataControler.java
 * @版本信息：
 * @日期：2015-1-9
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.na517.automaticpackaging.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.na517.automaticpackaging.MainApp;

/**
 * @项目名称：AutomaticPackaging
 * @类名称：DataControler
 * @类描述： 数据控制类
 * @创建人：ningque
 * @创建时间：2015-1-9 下午4:50:02
 * @修改人：ningque
 * @修改时间：2015-1-9 下午4:50:02
 * @修改备注：
 * @version
 */
public class DataControler {
    /** strings目录 **/
    public static String XML_PATH_APP_NAME;
    
    /** 517na工程名称 **/
    public static final String PROJECT_517NA = "517NaMobile";
    
    /** 差旅工程名称 **/
    public static final String PROJECT_TRAVEL = "517NaCropTravel";
    
    /** Manifest **/
    SAXReader readerMain = new SAXReader();
    
    /** strings **/
    SAXReader readerString = new SAXReader();
    
    /** Manifest的文档 **/
    Document documentMain;
    
    /** strings的文档 **/
    Document documentString;
    
    /** 根节点 **/
    Element root;
    
    /** 存放参数的HashMap **/
    public HashMap<String, String> map;
    
    /** 根目录 **/
    public static String ROOT_PATH;
    
    /** AndroidManifest.xml目录 **/
    public static String XML_PATH;
    
    /** 工程目录 **/
    public static String PROJECT_PATH;
    
    public DataControler() {
        if (MainApp.packageFlag == MainApp.TRAVEL_APK) {
            XML_PATH = ROOT_PATH + "\\" + PROJECT_TRAVEL + "\\AndroidManifest.xml";
            PROJECT_PATH = ROOT_PATH + "\\" + PROJECT_TRAVEL;
            XML_PATH_APP_NAME = PROJECT_PATH + "\\res\\values\\strings.xml";
        }
        else {
            XML_PATH = ROOT_PATH + "\\" + PROJECT_517NA + "\\AndroidManifest.xml";
            PROJECT_PATH = ROOT_PATH + "\\" + PROJECT_517NA;
        }
    }
    
    /**
     * 初始化字段
     * 
     * @description
     * @date 2015-1-12
     */
    public boolean initData() {
        try {
            documentMain = readerMain.read(new File(XML_PATH));
            root = documentMain.getRootElement();
            map = new HashMap<String, String>();
        }
        catch (DocumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 遍历所有节点
     * 
     * @description
     * @date 2015-1-12
     * @param element
     */
    @SuppressWarnings("unchecked")
    public void listElement() {
        listAttrs(root, true);
        Element element = root.element("application");
        // System.out.println("当前节点名称：" + element.getName());
        
        List<Element> list = element.elements("meta-data");
        for (Element e : list) {
            listAttrs(e, false);
        }
    }
    
    /**
     * 遍历所有属性
     * 
     * @description
     * @date 2015-1-12
     * @param e
     * @param isName
     */
    @SuppressWarnings("unchecked")
    public void listAttrs(Element e, boolean isName) {
        List<Attribute> attrs = e.attributes();
        
        for (int i = 0; i < attrs.size(); i++) {
            if (!isName) {
                map.put(attrs.get(i).getValue(), attrs.get(i + 1).getValue());
                // System.out.println(attrs.get(i).getValue() + "--------" +
                // map.get(attrs.get(i).getValue()));
                i++;
            }
            else {
                map.put(attrs.get(i).getName(), attrs.get(i).getValue());
                // System.out.println(attrs.get(i).getName() + "--------" +
                // map.get(attrs.get(i).getName()));
            }
        }
    }
    
    /**
     * 更新map中的数据
     * 
     * @description
     * @date 2015-1-12
     * @param element
     */
    @SuppressWarnings("unchecked")
    public void updateFirst(Element element) {
        element.addAttribute("package", map.get("package"));
        element.addAttribute("versionCode", map.get("versionCode"));
        element.addAttribute("versionName", map.get("versionName"));
        Element e = element.element("application");
        List<Element> list = e.elements("meta-data");
        for (Element attr : list) {
            List<Attribute> attrs = attr.attributes();
            if (attrs.get(0).getValue().equals("UMENG_APPKEY")) {
                attr.addAttribute("value", map.get("UMENG_APPKEY"));
            }
            if (attrs.get(0).getValue().equals("UMENG_CHANNEL")) {
                attr.addAttribute("value", map.get("UMENG_CHANNEL"));
            }
            if (attrs.get(0).getValue().equals("com.baidu.lbsapi.API_KEY")) {
                attr.addAttribute("value", map.get("com.baidu.lbsapi.API_KEY"));
            }
        }
    }
    
    /**
     * 更新map中的数据
     * 
     * @description
     * @date 2015-1-12
     * @param element
     */
    @SuppressWarnings("unchecked")
    public void updateSecond(Element e) {
        List<Element> list = e.elements("meta-data");
        for (Element attr : list) {
            List<Attribute> attrs = attr.attributes();
            if (attrs.get(0).getValue().equals("PUSH_APPID")) {
                attr.addAttribute("value", map.get("PUSH_APPID"));
            }
            if (attrs.get(0).getValue().equals("PUSH_APPKEY")) {
                attr.addAttribute("value", map.get("PUSH_APPKEY"));
            }
            if (attrs.get(0).getValue().equals("PUSH_APPSECRET")) {
                attr.addAttribute("value", map.get("PUSH_APPSECRET"));
            }
        }
        List<Element> listReceiver = e.elements("receiver");
        for (Element attr : listReceiver) {
            List<Attribute> attrs = attr.attributes();
            if (attrs.get(0).getValue().equals("com.na517.util.receiver.PushMsgReceiver") || attrs.get(0)
                                                                                                  .getValue()
                                                                                                  .equals("com.na517.croptravel.util.receiver.PushMsgReceiver")) {
                Element child = attr.element("intent-filter");
                child = child.element("action");
                child.addAttribute("name", "com.igexin.sdk.action." + map.get("PUSH_APPID"));
            }
            else if (attrs.get(0).getValue().equals("com.igexin.getuiext.service.PayloadReceiver")) {
                Element child = attr.element("intent-filter");
                child = (Element) child.elements().get(1);
                child.addAttribute("name", "com.igexin.sdk.action." + map.get("PUSH_APPID"));
            }
        }
    }
    
    /**
     * 更新map中的数据
     * 
     * @description
     * @date 2015-1-12
     * @param element
     */
    @SuppressWarnings("unchecked")
    public void updateThird(Element e) {
        List<Element> list = e.elements("meta-data");
        for (Element attr : list) {
            List<Attribute> attrs = attr.attributes();
            if (attrs.get(0).getValue().equals("AGENT_NAME")) {
                attr.addAttribute("value", map.get("AGENT_NAME"));
            }
            if (attrs.get(0).getValue().equals("AGENT_PID")) {
                attr.addAttribute("value", map.get("AGENT_PID"));
            }
            if (attrs.get(0).getValue().equals("SERVICE_TEL")) {
                attr.addAttribute("value", map.get("SERVICE_TEL"));
            }
        }
    }
    
    /**
     * 写入文件
     * 
     * @description
     * @date 2015-1-12
     * @param writeFlag
     */
    public void write(int writeFlag) {
        switch (writeFlag) {
            case 1:
                updateFirst(root);
                break;
            case 2:
                updateSecond(root.element("application"));
                break;
            case 3:
                updateThird(root.element("application"));
                break;
            default:
                break;
        }
        OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式
        format.setEncoding("UTF-8");// 设置编码
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(XML_PATH)), "UTF-8"), format);
            writer.write(documentMain);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 修改.properties文件
     * 
     * @description
     * @date 2015-1-13
     * @param filename
     * @param psw
     */
    public void writePropertiesFile(String filename, String psw) {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(ROOT_PATH + "\\ant.properties");
            properties.load(inputStream);
            inputStream.close();
            OutputStream outputStream = new FileOutputStream(ROOT_PATH + "\\ant.properties");
            properties.setProperty("key.store", filename);
            properties.setProperty("key.store.password", psw);
            properties.setProperty("key.alias.password", psw);
            properties.store(outputStream, "ningque");
            outputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 将文件中指定内容的第一行替换为其它内容.
     * 
     * @param oldStr
     *            查找内容
     * @param replaceStr
     *            替换内容
     */
    public void replaceTxtByStr(String filePath, String oldStr, String replaceStr) {
        String temp = "";
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            
            temp = br.readLine();
            while (temp != null) {
                if (temp.trim().equals(oldStr)) {
                    buf = buf.append("\t" + replaceStr);
                }
                else {
                    buf = buf.append(temp);
                }
                buf = buf.append(System.getProperty("line.separator"));
                temp = br.readLine();
            }
            
            br.close();
            
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter output = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter writer = new BufferedWriter(output);
            // System.out.println(buf.toString());
            writer.write(buf.toString());
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 更新app名称
     * 
     * @description
     * @date 2015-1-13
     * @param appName
     */
    public void updateAppName(String appName) {
        try {
            documentString = readerString.read(new File(XML_PATH_APP_NAME));
        }
        catch (DocumentException e) {
            e.printStackTrace();
        }
        Element e = documentString.getRootElement();
        // 当前节点下面子节点迭代器
        @SuppressWarnings("unchecked")
        Iterator<Element> it = e.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element string = it.next();
            if (string.attribute("name").getValue().equals("app_name")) {
                string.setText(appName);
                // System.out.println(string.getText());
                break;
            }
        }
        OutputFormat format = OutputFormat.createPrettyPrint();// 创建文件输出的时候，自动缩进的格式
        format.setEncoding("UTF-8");// 设置编码
        try {
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(XML_PATH_APP_NAME)), "UTF-8"), format);
            writer.write(documentString);
            writer.flush();
            writer.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     * 调用.bat执行打包
     * 
     * @description
     * @date 2015-1-13
     */
    public static void packaging() {
        try {
            Runtime.getRuntime().exec("cmd /k start " + DataControler.ROOT_PATH + "\\package.bat");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取文件中的某一行字符串
     * 
     * @description
     * @date 2015-1-20
     * @return
     */
    public String getFileString(String filePath, String prefix) {
        File file = new File(filePath);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr;
            isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String temp = "";
            temp = br.readLine();
            while (temp != null) {
                if (temp.trim().startsWith(prefix)) {
                    br.close();
                    return temp.trim();
                }
                temp = br.readLine();
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
