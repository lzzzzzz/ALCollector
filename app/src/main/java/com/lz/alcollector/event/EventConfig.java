package com.lz.alcollector.event;

/**
 * Created by LZ on 2016/12/10.
 */

public class EventConfig {
    /**页面开始事件*/
    public static final int EVENT_FLAG_PAGE_START=0x01;
    /**页面结束事件*/
    public static final int EVENT_FLAG_PAGE_STOP=0x02;
    /**页面BUTTON事件*/
    public static final int EVENT_FLAG_PAGE_BUTTON_CLICK=0x03;
    /**页面ACTION事件*/
    public static final int EVENT_FLAG_PAGE_ACTION_CLICK=0x04;
    /**页面自定义事件*/
    public static final int EVENT_FLAG_PAGE_OTHER_CLICK=0x05;

}
