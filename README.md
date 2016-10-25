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

