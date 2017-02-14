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
     * 颜色设置 键值是步骤标题所*包含*的字符
     * @param map 标题-颜色
     */
    public void setKeyColor(Map<String, String> map);
```


