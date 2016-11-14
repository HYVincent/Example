package com.example.vincent.base;

import android.app.Application;

import com.common.libary.log.MyLog;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.formatter.border.DefaultBorderFormatter;
import com.elvishew.xlog.formatter.message.json.DefaultJsonFormatter;
import com.elvishew.xlog.formatter.message.throwable.DefaultThrowableFormatter;
import com.elvishew.xlog.formatter.message.xml.DefaultXmlFormatter;
import com.elvishew.xlog.formatter.stacktrace.DefaultStackTraceFormatter;
import com.elvishew.xlog.formatter.thread.DefaultThreadFormatter;
import com.elvishew.xlog.printer.AndroidPrinter;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.SystemPrinter;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.backup.FileSizeBackupStrategy;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;
import com.elvishew.xlog.printer.flattener.DefaultLogFlattener;
import com.lzy.okgo.OkGo;


/**
 * XLog：https://github.com/elvishew/XLog/blob/master/README_ZH.md
 * Created by Vincent on 2016/10/25.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.init(this);//网络框架OKGo初始化
//        MyLog.init("sample");//初始化 must
//        XLog.init(LogLevel.ALL);//不带边框
//        MyLog.setSwitch(true);//日志开关，默认为关，debug模式需要手动打开

        LogConfiguration config = new LogConfiguration.Builder()
                .tag("MY_TAG")                                         // 指定 TAG，默认为 "X-LOG"
                .t()                                                   // 允许打印线程信息，默认禁止
                .st(2)                                                 // 允许打印深度为2的调用栈信息，默认禁止
                .b()                                                   // 允许打印日志边框，默认禁止
                .jsonFormatter(new DefaultJsonFormatter())                  // 指定 JSON 格式化器，默认为 DefaultJsonFormatter
                .xmlFormatter(new DefaultXmlFormatter())                    // 指定 XML 格式化器，默认为 DefaultXmlFormatter
                .throwableFormatter(new DefaultThrowableFormatter())        // 指定可抛出异常格式化器，默认为 DefaultThrowableFormatter
                .threadFormatter(new DefaultThreadFormatter())              // 指定线程信息格式化器，默认为 DefaultThreadFormatter
                .stackTraceFormatter(new DefaultStackTraceFormatter())      // 指定调用栈信息格式化器，默认为 DefaultStackTraceFormatter
                .borderFormatter(new DefaultBorderFormatter())               // 指定边框格式化器，默认为 DefaultBorderFormatter
                .build();

        Printer androidPrinter = new AndroidPrinter();             // 通过 android.util.Log 打印日志的打印器
        Printer systemPrinter = new SystemPrinter();               // 通过 System.out.println 打印日志的打印器
        Printer filePrinter = new FilePrinter                      // 打印日志到文件的打印器
                .Builder("/sdcard/xlog/")                              // 指定保存日志文件的路径
                .fileNameGenerator(new DateFileNameGenerator())        // 指定日志文件名生成器，默认为 ChangelessFileNameGenerator("log")
                .backupStrategy(new FileSizeBackupStrategy(1024*1024))                // 指定日志文件备份策略，默认为 FileSizeBackupStrategy(1024 * 1024)
                .logFormatter(new DefaultLogFlattener())// 指定日志平铺器，默认为 DefaultLogFlattener
                .build();

        XLog.init(LogLevel.ALL,                                    // 指定日志级别，低于该级别的日志将不会被打印
                config,                                                // 指定日志配置，如果不指定，会默认使用 new LogConfiguration.Builder().build()
                androidPrinter,                                        // 添加任意多的打印器。如果没有添加任何打印器，会默认使用 AndroidPrinter
                systemPrinter,
                filePrinter);

    }
}
