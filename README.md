# StepView

## 介绍

StepView是由自己公司开发的软件中抽取出来又做了强化,分为横向版和竖向版,颜色大小随意可调,灵活好用!

## UI

[Download Demo](https://github.com/zhangxuyang321/StepView/blob/master/apk/step.apk)

![1](https://github.com/zhangxuyang321/StepView/blob/master/ui/hflow.png)
![2](https://github.com/zhangxuyang321/StepView/blob/master/ui/vflow.png)


## 使用

### Gradle

```Groovy
compile 'com.xyz.step:step:1.0.4'
```

### Maven

```xml
<dependency>
  <groupId>com.xyz.step</groupId>
  <artifactId>step</artifactId>
  <version>1.0.4</version>
  <type>pom</type>
</dependency>
```

### 横向

#### 属性介绍

属性 | 介绍 | 类型 | 默认 | 是否必须
    --- | --- | --- | --- | ---
    h_bg_radius | 背景 ○ 的半径 | dimension | 5 | 否
    h_pro_radius | 已完成 ○ 的半径 | dimension | 2 | 否 
    h_bg_width | 背景线的宽度 | dimension | 3 | 否
    h_bg_color | 背景的颜色 | color | #cdcbcc | 否
    h_pro_width | 已完成线的宽度 | dimension | 2 | 否
    h_pro_color | 已完成的颜色 | color | #029dd5 | 否
    h_text_padding | 步骤描述文字(title)与○的距离 | dimension | 10 | 否
    h_time_padding | 时间与○的距离 | dimension | 15 | 否
    h_max_step | 总步骤(○)的个数 | int | 5 | 否
    h_pro_step | 已完成步骤 | int | 1 | 否
    h_textsize | 字体大小 | dimension | 10 | 否
    
    
#### layout

```xml
<com.xyz.step.FlowViewHorizontal
        android:id="@+id/hflowview4"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:paddingLeft="30dp"
        app:h_bg_radius="6dp"
        app:h_bg_width='4dp'
        app:h_pro_radius='4dp'
        app:h_pro_width="2dp"
        app:h_text_padding='10dp'
        app:h_textsize='10dp'
        app:h_time_padding='17dp' />
```

#### 代码

```java
    /**
     * 进度设置
     * @param progress 已完成到哪部
     * @param maxStep  总步骤
     * @param titles   步骤名称
     * @param times    完成时间
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times);
    
    /**
     * 颜色设置 键值是步骤标题所包含的字符
     * @param map 标题-颜色
     */
    public void setKeyColor(Map<String, String> map);
```

### 竖向

#### 属性介绍

属性 | 介绍 | 类型 | 默认 | 是否必须
    --- | --- | --- | --- | ---
    v_bg_radius | 背景 ○ 的半径 | dimension | 5 | 否
    v_pro_radius | 已完成 ○ 的半径 | dimension | 2 | 否 
    v_bg_width | 背景线的宽度 | dimension | 3 | 否
    v_bg_color | 背景的颜色 | color | #cdcbcc | 否
    v_pro_width | 已完成线的宽度 | dimension | 2 | 否
    v_pro_color | 已完成的颜色 | color | #029dd5 | 否
    v_interval | ○ 与 ○之间的间距 | dimension | 80 | 否
    v_bgPositionX | 指示线距view左边缘的距离 | dimension | 100 | 否
    v_textPaddingLeft | 步骤描述文字与指示线的距离 | dimension | 10 | 否
    v_timePaddingRight | 时间与指示线的距离 | dimension | 15 | 否
    v_max_step | 总步骤(○)的个数 | int | 5 | 否
    v_pro_step | 已完成步骤 | int | 1 | 否
    v_textsize | 字体大小 | dimension | 10 | 否
    v_textMoveTop | 指示器右侧文字位置上下移动的距离 | 5 | 否
    v_timeMoveTop | 指示器左侧文字位置上下移动的距离 | 4 | 否
    
#### layout

```xml
<com.xyz.step.FlowViewVertical
        android:id="@+id/vflow"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingBottom="10dp"
        android:paddingRight="10dp"
        android:paddingTop="10dp"
        app:v_bgPositionX="40dp"
        app:v_bg_color="#029dd5"
        app:v_bg_radius="8dp"
        app:v_bg_width="4dp"
        app:v_interval="80dp"
        app:v_max_step="10"
        app:v_pro_color="#cdcbcc"
        app:v_pro_radius="8dp"
        app:v_pro_step="9"
        app:v_pro_width="4dp"
        app:v_textMoveTop="7dp"
        app:v_textsize="14dp" />
```

#### 代码

``` java
    /**
     * 进度设置
     * @param progress 当前进行到哪一步
     * @param maxStep  总的步骤
     * @param titles   文字描述(指示线右侧)
     * @param times    时间描述(指示线左侧)
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times);
    
    
    /**
     * 颜色设置 键值是步骤标题所包含的字符
     * @param map 标题-颜色
     */
    public void setKeyColor(Map<String, String> map);
    
```

## 使用注意

* title[] 和 time[] 传null 的时候则不显示指示器不显示文字与时间

## LICENSE 开源协议

    Apache License Version 2.0
