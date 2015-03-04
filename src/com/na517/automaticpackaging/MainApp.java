/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�ļ�����MainApp.java
 * @�汾��Ϣ��
 * @���ڣ�2015-1-8
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.na517.automaticpackaging;

import java.io.File;

import com.na517.automaticpackaging.control.DataControler;
import com.na517.automaticpackaging.frame.FirstFrame;
import com.na517.automaticpackaging.frame.FourthFrame;
import com.na517.automaticpackaging.frame.SecondFrame;
import com.na517.automaticpackaging.frame.ThirdFrame;
import com.na517.automaticpackaging.modle.Parameters;

/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�����ƣ�MainApp
 * @��������Ӧ���ܿ�����
 * @�����ˣ�ningque
 * @����ʱ�䣺2015-1-8 ����2:49:04
 * @�޸��ˣ�ningque
 * @�޸�ʱ�䣺2015-1-8 ����2:49:04
 * @�޸ı�ע��
 * @version
 */
public class MainApp {
    /**
     * ȫ��Ӧ��ʵ��
     */
    public static MainApp mainFrame;
    
    /**
     * ���ò���������ʱδ��
     */
    public Parameters parameters;
    
    /**
     * ���ݿ��Ʋ�
     */
    public DataControler controler;
    
    public FirstFrame firstFrame;
    
    public SecondFrame secondFrame;
    
    public ThirdFrame thirdFrame;
    
    public FourthFrame fourthFrame;
    
    /**
     * �����־
     */
    public static final int NA517_APK = 0;
    
    public static final int TRAVEL_APK = 1;
    
    public static int packageFlag = NA517_APK;
    
    public static File file;
    
    public static void main(String[] args) {
        // ��ʼ��ʵ��
        mainFrame = new MainApp();
        mainFrame.firstFrame = new FirstFrame();
        mainFrame.firstFrame.setVisible(true);
        mainFrame.secondFrame = new SecondFrame();
        mainFrame.secondFrame.setVisible(false);
        mainFrame.thirdFrame = new ThirdFrame();
        mainFrame.thirdFrame.setVisible(false);
        mainFrame.fourthFrame = new FourthFrame();
        mainFrame.fourthFrame.setVisible(false);
    }
}
