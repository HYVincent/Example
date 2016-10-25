### Example

###这是一个library，收集了平时项目中使用的一些公共的方法，自定义View，日志工具Logger，网络工具等
</br>使用方法：
</br>1、在根目录的build.gradle的allprojects{{repositories{//在这里添加}}}
```java
  allprojects{
    repositories{
      ...
      maven{ url "https://jitpack.io"}
      }
  }
```
</br>2、在app的build.gradle中添加依赖：
```java
  deppendencies{
  ............
    comile 'com.github.HYVincent:Example:-SNAPSHOT'
  }
```

####log
</br>class:MyLog 
</br>要使用这个日志工具，必须在集成Application的类的onCreate()方法中初始化，Example:
```java
/**
 * @name Example
 * @class name：com.example.vincent
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2016/10/25 16:17
 * @change
 * @chang time
 * @class describe
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init("Example");//tag 随意写
        MyLog.setSwitch(true);//默认是关闭的，要使用必须要打开开关
    }
}

```
####netutil
</br>class:VolleyUtil 封装的网络请求，详情具体查看该类
</br>class:NetUtil:网络工具类，关于网络的相关判断，使用具体查看该类
####util
</br>class:AppUtil 和系统相关的方法、判断
</br>startOtherAppActivity(Context context,String packageName,String activityName) 启动另外一个app里面的某Activity
</br>isServiceRunning(Context mContext, String className) 判断Service是否正在运行 true运行 false 没有运行
</br> getAllApp(Context context)  返回包名的集合列表
</br>isAppInstalled(Context context, String packeName) 检查app是否安装 true 安装  false 没有安装
</br>isBackground(Context context) 判断app当前处于前台运行还是后台 true 后台 false 前台
</br>isFirstActivity(Context context, String name) 检测当前运行的应用第一个启动的activity是否指定的activity
</br>isTopActivity(Context context, String name) 检测当前运行的应用正在运行的activity是否指定的activity
</br>restartApp(Context context,String appPackname) 重启APP
</br>getVersionName(Context context) //版本名
</br> getVersionCode(Context context) 	//版本号
</br> getPackageInfo(Context context) 获取包名
####DateUtil 日期类工具
</br>dateFormat(String sdate) 格式化日期显示格式yyyy-MM-dd
</br>dateFormat(String sdate, String format) 输入日期 和 格式
</br>getIntervalDays(String sd, String ed) 求两个日期相差天数
</br>getInterval(String beginMonth, String endMonth) 起始年月yyyy-MM与终止月yyyy-MM之间跨度的月数
</br> getFormatCurrentTime("yyyy") 取得当前日期的年份，以yyyy格式返回.
</br>getBeforeYear() 取得当前日期的年份，以yyyy格式返回.
</br> getCurrentMonth() 取得当前日期的月份，以MM格式返回.
</br> getCurrentDay() 取得当前日期的天数，以格式"dd"返回.
</br> getCurrentDate() 返回当前时间字符串。
</br>getFormatDate(Date date) 返回给定时间字符串。
</br> getFormatDate(String format) 根据制定的格式，返回日期字符串。例如2007-05-05
</br>getCurrentTime() 返回当前时间字符串。
</br>getFormatTime(Date date) 返回给定时间字符串。
</br>getFormatCurrentTime(String format) 根据给定的格式，返回时间字符串。
</br>getFormatDateTime(Date date, String format) 根据给定的格式与时间(Date类型的)，返回时间字符串
</br>getDateObj(int year, int month, int day) 取得指定年月日的日期对象.
</br>getDateObj(String args, String split) 取得指定分隔符分割的年月日的日期对象.
</br>getDateFromString(String dateStr, String pattern) 取得给定字符串描述的日期对象，描述模式采用pattern指定的格式.
</br> getDateObj() 取得当前Date对象.
</br>getDaysOfCurMonth()  当前月份有多少天；
</br>getDaysOfCurMonth(final String time) 根据指定的年月 返回指定月份（yyyy-MM）有多少天。
</br>getDayofWeekInMonth(String year, String month,String weekOfMonth, String dayOfWeek) 返回指定为年度为year月度为month的月份内，第weekOfMonth个星期的第dayOfWeek天
</br>getDate(int year, int month, int date, int hourOfDay,int minute, int second) 根据指定的年月日小时分秒，返回一个java.Util.Date对象。
</br>getDayOfWeek(String year, String month, String day) 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
</br>getDayOfWeek(String date) 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
</br>getChinaDayOfWeek(String date) 返回当前日期是星期几。例如：星期日、星期一、星期六等等。
</br>getDayOfWeek(Date date) 根据指定的年、月、日返回当前是星期几。1表示星期天、2表示星期一、7表示星期六。
</br> getWeekOfYear(String year, String month, String day) 返回制定日期所在的周是一年中的第几个周
</br>getDateAdd(Date date, int amount)  取得给定日期加上一定天数后的日期对象.
</br>getFormatDateAdd(Date date, int amount, String format) 取得给定日期加上一定天数后的日期对象.
</br>getFormatCurrentAdd(int amount, String format)  获得当前日期固定间隔天数的日期，如前60天dateAdd(-60)
</br>getFormatYestoday(String format)取得给定格式的昨天的日期输出
</br>getYestoday(String sourceDate, String format) 返回指定日期的前一天
</br> getFormatTomorrow(String format) 返回明天的日期
</br>getFormatDateTommorrow(String sourceDate, String format) 返回指定日期的后一天
</br>getCurrentDateString(String dateFormat) 根据主机的默认 TimeZone，来获得指定形式的时间字符串。
</br>getCurDate() 返回当前时间串 格式:yyMMddhhmmss,在上传附件时使用
</br>getCurTimeByFormat(String format) 根据给定的格式，返回时间字符串。 和getFormatDate(String format)相似。
</br>getDiff(String startTime, String endTime)获取两个时间串时间的差值，单位为秒
</br> getHour(long second)  含小时、分钟、秒的时间字符串，例如3小时23分钟13秒。
</br> getDateTime(long microsecond) 返回指定时间字符串。
</br>getDateByAddFltHour(float flt) 返回当前时间加实数小时后的日期时间。
</br> getDateByAddHour(String datetime, int minute) 返回指定时间加指定小时数后的日期时间。
</br> getDiffHour(String startTime, String endTime)  获取两个时间串时间的差值，单位为小时
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>




