/**
 * @项目名称：AutomaticPackaging
 * @文件名：MainApp.java
 * @版本信息：
 * @日期：2015-1-8
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.xyxg.automaticpackaging;

import java.io.File;

import com.xyxg.automaticpackaging.control.DataControler;
import com.xyxg.automaticpackaging.frame.FirstFrame;
import com.xyxg.automaticpackaging.frame.FourthFrame;
import com.xyxg.automaticpackaging.frame.SecondFrame;
import com.xyxg.automaticpackaging.frame.ThirdFrame;
import com.xyxg.automaticpackaging.modle.Parameters;

/**
 * @项目名称：AutomaticPackaging
 * @类名称：MainApp
 * @类描述：应用总控制类
 * @创建人：ningque
 * @创建时间：2015-1-8 下午2:49:04
 * @修改人：ningque
 * @修改时间：2015-1-8 下午2:49:04
 * @修改备注：
 * @version
 */
public class MainApp {
    /**
     * 全局应用实例
     */
    public static MainApp mainFrame;
    
    /**
     * 配置参数对象，暂时未用
     */
    public Parameters parameters;
    
    /**
     * 数据控制层
     */
    public DataControler controler;
    
    public FirstFrame firstFrame;
    
    public SecondFrame secondFrame;
    
    public ThirdFrame thirdFrame;
    
    public FourthFrame fourthFrame;
    
    /**
     * 打包标志
     */
    public static final int NA517_APK = 0;
    
    public static final int TRAVEL_APK = 1;
    
    public static int packageFlag = NA517_APK;
    
    public static File file;
    
    public static void main(String[] args) {
        // 初始化实例
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
