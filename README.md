# StepView

## introduce

StepView is extracted from the software developed by my company and do the reinforcement, divided into horizontal and vertical version, color size freely adjustable, flexible to use!
(中文版在这里)[https://github.com/zhangxuyang321/StepView/blob/master/StepView.md]
## UI

[Download Demo](https://github.com/zhangxuyang321/StepView/blob/master/apk/step.apk)

![1](https://github.com/zhangxuyang321/StepView/blob/master/ui/hflow.png)
![2](https://github.com/zhangxuyang321/StepView/blob/master/ui/vflow.png)

## How to use

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

### Horizontal View

#### Attribute is introduced

Attribute | Describe | Type | Default value | Whether must
    --- | --- | --- | --- | ---
    h_bg_radius | Background circle radius | dimension | 5 | No
    h_pro_radius | Has completed the radius of the circles | dimension | 2 | No 
    h_bg_width | Background line width | dimension | 3 | No
    h_bg_color | Background Color | color | #cdcbcc | No
    h_pro_width | The width of the line has been completed | dimension | 2 | No
    h_pro_color | The completed color | color | #029dd5 | No
    h_text_padding | Text and distance of the circle | dimension | 10 | No
    h_time_padding | Time and distance of the circle | dimension | 15 | No
    h_max_step | Total steps | int | 5 | No
    h_pro_step | Step has been completed | int | 1 | No
    h_textsize | textsize | dimension | 10 | No

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

#### Code

```java
    /**
     * Progress Settings
     * @param progress  Have completed a few steps
     * @param maxStep  Total steps
     * @param titles   	    Step name
     * @param times      Every step of the completion time
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times);
    
    /**
     * Color Settings
     * @param map <text,color>
     */
    public void setKeyColor(Map<String, String> map);
```

### Vertical View

#### Attribute is introduced

Attribute | Describe | Type | Default value | Whether must
    --- | --- | --- | --- | ---
    v_bg_radius | Background circle radius | dimension | 5 | No
    v_pro_radius | Has completed the radius of the circle | dimension | 2 | No
    v_bg_width | Background line width | dimension | 3 | No
    v_bg_color | Background Color | color | #cdcbcc | No
    v_pro_width | The width of the line has been completed | dimension | 2 | No
    v_pro_color |  The completed color | color | #029dd5 | No
    v_interval | interval | dimension | 80 | No
    v_bgPositionX | In a horizontal position | dimension | 100 | No
    v_textPaddingLeft | The distance of text and lines | dimension | 10 | No
    v_timePaddingRight | The distance of time and lines | dimension | 15 | No
    v_max_step | Total steps | int | 5 | No
    v_pro_step | Step has been completed | int | 1 | No
    v_textsize | Text size | dimension | 10 | No
    v_textMoveTop | The text on the vertical distance | dimension | 5 | No
    v_timeMoveTop | The time on the vertical distance | dimension | 4 | No

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

#### Code

``` java
    /**
     * Progress Settings
     * @param progress Have completed a few steps
     * @param maxStep  Total steps
     * @param titles    Step description
     * @param times    Time description
     */
    public void setProgress(int progress, int maxStep, String[] titles, String[] times);
    
    
    /**
     *  Color Settings
     * @param map <text,color>
     */
    public void setKeyColor(Map<String, String> map);
    
```

## Use attention

###All directions

* When title[] and time[] uploading the null does not show the indicator、words and time.
  
* Min steps sum(max_step)>=2 and >= finished steps(pro_step)
* The unit of the font’s size is dp
* The color setting of the concrete steps is according to the key from the map whether title[] contain or not to make a decision whether change or not
* Only finished steps can set color individually, unfinished steps all use the color from bg_color

### Transverse 
* Lateral indicator counts intervals between steps automatically
* Lateral indicator is placed in the middle automatically, when you set paddingLeft ,you do not need to set paddingRight
* Lateral indicator can not slide transversely

###Vertical
* Vertical indicator need to set the intervals between steps(v_interval)
* Vertical indicator can combine with ScrollView to get slide
* Vertical indicator doesn’t use item reusing, you’d better use listview if the date size is bigger
* Vertical indicator’s word drawing is different, which leads to words and *
* steps nodes(O) not in the same horizontal, you can adapt v_textMove Top with v_timeMove Top 


## LICENSE 开源协议

    Apache License Version 2.0
