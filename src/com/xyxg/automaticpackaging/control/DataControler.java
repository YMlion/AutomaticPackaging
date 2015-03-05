/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�ļ�����DataControler.java
 * @�汾��Ϣ��
 * @���ڣ�2015-1-9
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.xyxg.automaticpackaging.control;

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

import com.xyxg.automaticpackaging.MainApp;

/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�����ƣ�DataControler
 * @�������� ���ݿ�����
 * @�����ˣ�ningque
 * @����ʱ�䣺2015-1-9 ����4:50:02
 * @�޸��ˣ�ningque
 * @�޸�ʱ�䣺2015-1-9 ����4:50:02
 * @�޸ı�ע��
 * @version
 */
public class DataControler {
    /** stringsĿ¼ **/
    public static String XML_PATH_APP_NAME;
    
    /** 517na�������� **/
    public static final String PROJECT_517NA = "517NaMobile";
    
    /** ���ù������� **/
    public static final String PROJECT_TRAVEL = "517NaCropTravel";
    
    /** Manifest **/
    SAXReader readerMain = new SAXReader();
    
    /** strings **/
    SAXReader readerString = new SAXReader();
    
    /** Manifest���ĵ� **/
    Document documentMain;
    
    /** strings���ĵ� **/
    Document documentString;
    
    Document configDoc;
    
    /** ���ڵ� **/
    Element root;
    
    /** ��Ų�����HashMap **/
    public HashMap<String, String> map;
    
    /** ��Ŀ¼ **/
    public static String ROOT_PATH;
    
    /** AndroidManifest.xmlĿ¼ **/
    public static String XML_PATH;
    
    /** ����Ŀ¼ **/
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
     * ��ʼ���ֶ�
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
     * �������нڵ�
     * 
     * @description
     * @date 2015-1-12
     * @param element
     */
    @SuppressWarnings("unchecked")
    public void listElement() {
        listAttrs(root, true);
        Element element = root.element("application");
        // System.out.println("��ǰ�ڵ����ƣ�" + element.getName());
        
        List<Element> list = element.elements("meta-data");
        for (Element e : list) {
            listAttrs(e, false);
        }
    }
    
    /**
     * ������������
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
     * ����map�е�����
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
     * ����map�е�����
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
     * ����map�е�����
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
     * д���ļ�
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
        OutputFormat format = OutputFormat.createPrettyPrint();// �����ļ������ʱ���Զ������ĸ�ʽ
        format.setEncoding("UTF-8");// ���ñ���
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
     * �޸�.properties�ļ�
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
     * ���ļ���ָ�����ݵĵ�һ���滻Ϊ��������.
     * 
     * @param oldStr
     *            ��������
     * @param replaceStr
     *            �滻����
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
     * ����app����
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
        // ��ǰ�ڵ������ӽڵ������
        @SuppressWarnings("unchecked")
        Iterator<Element> it = e.elementIterator();
        // ����
        while (it.hasNext()) {
            // ��ȡĳ���ӽڵ����
            Element string = it.next();
            if (string.attribute("name").getValue().equals("app_name")) {
                string.setText(appName);
                // System.out.println(string.getText());
                break;
            }
        }
        OutputFormat format = OutputFormat.createPrettyPrint();// �����ļ������ʱ���Զ������ĸ�ʽ
        format.setEncoding("UTF-8");// ���ñ���
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
     * ����.batִ�д��
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
     * ��ȡ�ļ��е�ĳһ���ַ���
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
    
    public void writeConfig() {
        try {
            configDoc = readerMain.read(new File(ROOT_PATH + "\\config.xml"));
            Element root = configDoc.getRootElement();
            List<Element> properties = root.elements("property");
            for (int i = 0; i < properties.size(); i++) {
                String name = properties.get(i).attributeValue("name");
                if ("target.dir".equals(name)) {
                    properties.get(i).addAttribute("value", "./src/" + map.get("package").replace('.', '/'));
                }
                else if ("new_name_c".equals(name)) {
                    properties.get(i).addAttribute("value", map.get("package"));
                }
                else if ("new_name".equals(name)) {
                    properties.get(i).addAttribute("value", map.get("package"));
                }
            }
            OutputFormat format = OutputFormat.createPrettyPrint();// �����ļ������ʱ���Զ������ĸ�ʽ
            format.setEncoding("UTF-8");// ���ñ���
            try {
                XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(ROOT_PATH + "\\config.xml")), "UTF-8"),
                                                 format);
                writer.write(configDoc);
                writer.flush();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
