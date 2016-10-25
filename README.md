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
</br>getYearSelect(String selectName, String value,int startYear, int endYear) 返回年份的下拉框。
</br>getYearSelect(String selectName, String value,int startYear, int endYear, boolean hasBlank) 返回年份的下拉框
</br>getYearSelect(String selectName, String value,int startYear, int endYear, boolean hasBlank,String js) 返回年份的下拉框。
</br> String getYearSelect(String selectName, String value,int startYear, int endYear, String js) 返回年份的下拉框
</br>getMonthSelect(String selectName, String value,boolean hasBlank) 获取月份的下拉框
</br>getMonthSelect(String selectName, String value,boolean hasBlank, String js)获取月份的下拉框
</br>getDaySelect(String selectName, String value,boolean hasBlank)获取天的下拉框，默认的为1-31。
</br>getDaySelect(String selectName, String value,boolean hasBlank, String js)获取天的下拉框，默认的为1-31
</br>countWeekend(String startDate, String endDate) 计算两天之间有多少个周末（这个周末，指星期六和星期天，一个周末返回结果为2，两个为4，以此类推。）（此方法目前用于统计司机用车记录。）
</br> getDiffDays(String startDate, String endDate) 返回两个日期之间相差多少天。
</br>getArrayDiffDays(String startDate,String endDate) 返回两个日期之间的详细日期数组(包括开始日期和结束日期)。
</br>timeStamp2Date(String seconds,String format) 时间戳转换成日期格式字符串
</br>date2TimeStamp(String date_str,String format) 日期格式字符串转换成时间戳
</br> timeStamp()取得当前时间戳（精确到秒）
#### ExitUtil 连点两次退出
</br>isQuit(Context context,String exitMsg) 连续点击两次退出，此方法在onBackPressed()中调用，应该去掉父类回调方法
#### FileUtil 文件工具类
</br>WriteProperties(Context context, String fileName, String pKey, String pValue) 写入数据 键值对存
</br>getValueByKey(Context context, String fileName, String key) 读取数据 键值对取
</br>getAllProperties(Context context, String fileName) 返回全部信息
</br>delFile(String path) 删除改目录下的文件
</br>clearAllProperties(Context context,String fileName) 根据文件名清空所有数据
</br>write(Context context, String fileName, String content) 写文本文件 在Android系统中，文件保存在 /data/data/PACKAGE_NAME/files 目录下
</br> writeId(Context context, String fileName, String id) 写入数据 在app私有目录下
</br>read(Context context, String fileName) 读取文本文件
</br>readInStream(InputStream inStream) 读取输入流
</br>readInStream(InputStream inStream) 创建文件
</br>writeFile(byte[] buffer, String folder,、String fileName)向手机写图片
</br>getFileName(String filePath) 根据文件绝对路径获取文件名
</br>getFileNameNoFormat(String filePath) 根据文件的绝对路径获取文件名但不包含扩展名
</br>getFileFormat(String fileName) 获取文件扩展名
</br>getFileSize(String filePath) 获取文件大小
</br>getFileSize(long size) 获取文件大小
</br>formatFileSize(long fileS) 转换文件大小
</br>getDirSize(File dir) 获取目录文件大小
</br>getFileList(File dir) 获取目录文件个数
</br> toBytes(InputStream in) //获取字节数组根据输入流
</br>checkFileExists(String name) 检查文件是否存在
</br> checkFilePathExists(String path) 检查路径是否存在
</br>getFreeDiskSpace() 计算SD卡的剩余空间
</br> createDirectory(String directoryName) 新建目录
</br>checkSaveLocationExists() 检查是否安装SD卡
</br>checkExternalSDExists() 检查是否安装外置的SD卡
</br>deleteDirectory(String fileName) 删除目录(包括：目录里的所有文件)
</br> deleteFile(String fileName)  删除文件
</br>deleteBlankPath(String path)  删除空目录
</br>reNamePath(String oldName, String newName)  重命名
</br>deleteFileWithPath(String filePath) 删除文件
</br> clearFileWithPath(String filePath)清空一个文件夹
</br>getSDRoot() 获取SD卡的根目录
</br>getExternalSDRoot() 获取手机外置SD卡的根目录
</br>listPath(String root)列出root目录下所有子目录
</br>listPathFiles(String root) 获取一个文件夹下的所有文件
</br> createPath(String newPath) 创建目录
</br>getPathName(String absolutePath)  截取路径名
</br> getAppCache(Context context, String dir) 获取应用程序缓存文件夹下的指定目录
</br>readSDFile(String fileName) 读取SD卡中文本文件
</br>readAssetsTxt(Context context,String fileName) 读取assets下的txt文件，返回utf-8 String
</br>saveFile(Context c, String fileName, Bitmap bitmap) 将Bitmap 图片保存到本地路径，并返回路径
</br>saveFile(Context c, String filePath, String fileName, Bitmap bitmap) 保存位图文件
</br>bitmapToBytes(Bitmap bm) 将位图转换为字节数组
</br> saveFile(Context c, String filePath, String fileName, byte[] bytes) 保存字节数组文件
#### NotificationUtils 通知栏工具类
</br>sendNotification(Context context, String activity, int imgId, String title, String msg) 在顶部下拉通知栏产生一个通知
#### ScreenOpenCloseListener 屏幕监听 用户锁屏、打开屏幕、解锁
</br>begin(ScreenStateListener listener) 开始监听
</br>unregisterListener() 解除监听
####SharedPreferencesUtil SharePreferences工具类
</br>putString(String name, String value) 写入值 键值对
</br> putLong(String name, Long value)
</br> putInt(String name, int value) 
</br>putBoolean(String name, Boolean value) 
</br> remove(String name) 移除
</br> clear() 清理数据
</br> getLong(String key)获取值 long类型
</br>getBoolean(String key)
</br>getInt(String key)
</br>getString(String key)
</br>getLong(String key, long defValue)
</br>getInt(String key, int defValue)
</br> getBoolean(String key, boolean defValue)
</br>getString(String key, String defValue)
</br>Editor getEditor() 返回一个可编辑对象
#### StringUtil 字符串工具类
</br>toDate(String sdate) 将字符串转位日期类型
</br>friendly_time(String sdate) 以友好的方式显示时间
</br>isToday(String sdate) 判断给定字符串时间是否为今日
</br>getToday() 返回long类型的今天的日期
</br>isEmpty(String str) 判断一个字符串是否为null或空值.
</br>isEmptyEx(String input) 判断给定字符串是否空白串，（isEmpty的扩展方法）。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
</br>isEmail(String email) 判断是不是一个合法的电子邮件地址
</br>isMobileNO(String mobiles) 判断是不是一个合法的手机号码
</br>isPhoneNumber(String isPhoneNumber) 判断输入的号码是否为合法的电话号码（包括固话，区号，手机）
</br>isNumber(String str) 是否只是数字.
</br>isContainChinese(String str)是否包含中文.
</br>toInt(String str, int defValue) 字符串转整数
</br>toInt(Object obj) 对象转整数
</br>toLong(String obj) 对象转整数
</br>toBool(String b) 字符串转布尔值
</br>toConvertString(InputStream is) 将一个InputStream流转换成字符串
</br>toByteArray(String s) 把字符串转为字节数组
</br>toHexString(byte[] bytes) 字节数组转为字符串
####SystemUtil
</br> getPhoneMdel()获取手机型号，
</br>getPhoneManufacturer() 获取手机厂商
</br> getVersionOs()系统版本，
</br> getAndroidSDKVersionStr() ＳＤＫ版本
</br> getAndroidSDKVersionInt() 系统版本号
</br>getCpuName()　获取Ｃｐｕ信息
</br>getIMEINumber(Context context) 获取ＩＭＥＩ号码
</br>getPhoneNumber(Context context) 获取手机号码
</br>getBaseband_Ver() 获取基带版本
</br>getLinuxCore_Ver() 内核版本
</br>getInner_Ver() 内部版本
</br>getPhoneRAM(Context context)获取手机的可用内存大小
</br>getPhoneRAM(Context context) 获取手机总的运行内存
</br>isRoot()判断手机是否Root
</br>isBackground(Context context) 判断应用是在前台还是后台，
</br>getMemFree(Context context)得到系统可用内存，
</br> getSDSize(Context context) 内置SD卡总容量，
</br> getSDTotalSize(Context context) 获得内置SD卡总大小，
</br>isServiceWork(Context mContext, String serviceName) 判断某个服务是否正在运行的Method
</br>goSetting(Context context)  开启悬浮窗权限oppo手机，
</br>isAppInstalled(Context context, String packageName) 判断某个APP是否安装，
</br> goHuaWeiSetting(Context context,String errMsg)跳转到华为手机管家悬浮窗权限管理页面，
</br>goHWWindowPermission(Context context,String errMsg)跳转到华为手机管家权限管理主页，
</br>goHWSelfMotionStartManager(Context context,String errMsg)华为手机管家自启动管理
</br>goRelevanceStartManager(Context context,String errMsg)跳转到华为手机管家关联启动页面，
</br>goProtectAppManager(Context context,String errMsg)跳转到受保护的app管理页面锁屏可以继续运行，
</br>goNotificationManager(Context context,String errMsg)跳转到华为手机管家通知管理页面，跳转到华为手机管家清理加速页面
</br>goNotificationManager(Context context,String errMsg)跳转到华为手机管家骚扰拦截页面，
</br>goInterceptionAct(Context context,String errMsg)通过反射获取类对象，
</br> getInputKeyboard(EditText editText) 自动弹出键盘
</br>closeInputKeyBoard(EditText editText) 关闭软键盘
</br>getScreenParameterWidth(Context context)获取屏幕宽度
</br>getScreenParameterWidth(Context context)获取屏幕高度
</br>
####ToastUtil
</br>showSingleTextToast(Context context,String msg) 如果当前Toast没有消失，继续点击事件不叠加
</br>showDefaultToast(Context context,String msg) 默认的Toast long
</br>showSingleToastCenter(Context context,String msg) 屏幕中间弹出来 long
</br>showCenterToastShort(Context context,String msg) 屏幕中间弹出来 short
</br> showSingleTextToastLong(Context context,String msg) 不叠加 长时间显示






