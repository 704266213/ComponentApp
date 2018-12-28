# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile



# 混淆时不使用大小写混合，混淆后的类名为小写
# windows下的同学还是加入这个选项吧(windows大小写不敏感)
-dontusemixedcaseclassnames
# 如果应用程序引入的有jar包,并且想混淆jar包里面的class
-dontskipnonpubliclibraryclasses
# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

# 有了verbose这句话，混淆后就会生成映射文件
# 包含有类名->混淆后类名的映射关系
# 然后使用printmapping指定映射文件的名称
-verbose
-ignorewarnings

# Optimization is turned off by default. Dex does not like code run
# through the ProGuard optimize and preverify steps (and performs some
# of these optimizations on its own).
# 不做预检验，preverify是proguard的四个步骤之一
# Android不需要preverify，去掉这一步可以加快混淆速度
-dontpreverify

# If you want to enable optimization, you should include the following:
# 混淆采用的算法
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
# 设置混淆的压缩比率 0 ~ 7
-optimizationpasses 5
-allowaccessmodification

# 保护代码中的Annotation不被混淆
# 这在JSON实体映射时非常重要，比如fastJson
-keepattributes *Annotation*

# 避免混淆泛型
# 这在JSON实体映射时非常重要，比如fastJson
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable


# Add any project specific keep options here:
# 保留了继承自Activity、Application这些类的子类
# 因为这些子类有可能被外部调用
# 比如第一行就保证了所有Activity的子类不要被混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.view.View
-keep public class * extends android.app.backup.BackupAgent
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Fragment
-keep public class com.android.vending.licensing.ILicensingService


# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
# 所有native的方法不能去混淆.
-keepclasseswithmembernames class * {
        native <methods>;
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
#  枚举类不能去混淆
-keepclassmembers enum * {
        public static **[] values();
        public static ** valueOf(java.lang.String);
    }

# 某些构造方法不能去混淆
-keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet, int);
}

# aidl文件不能去混淆.
# 保留Parcelable序列化的类不能被混淆
-keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
}


# 保留Serializable 序列化的类不被混淆
-keep class * implements java.io.Serializable {
        public *;
}

-keepclassmembers class * implements java.io.Serializable {
       static final long serialVersionUID;
       private static final java.io.ObjectStreamField[] serialPersistentFields;
       !static !transient <fields>;
       private void writeObject(java.io.ObjectOutputStream);
       private void readObject(java.io.ObjectInputStream);
       java.lang.Object writeReplace();
       java.lang.Object readResolve();
}

# 保留Activity中的方法参数是view的方法，
# 从而我们在layout里面编写onClick就不会影响
-keepclassmembers class * extends android.app.Activity {
       public void *(android.view.View);
}

# 保留自定义控件(继承自View)不能被混淆
-keep public class * extends android.view.View {
        public <init>(android.content.Context);
        public <init>(android.content.Context, android.util.AttributeSet);
        public <init>(android.content.Context, android.util.AttributeSet, int);
        public void set*(...);
        public void get*(...);
}

# 对R文件下的所有类及其方法，都不能被混淆
-keepclassmembers class **.R$* {
        *;
}

# 对于带有回调函数onXXEvent的，不能混淆
-keepclassmembers class * {
        void *(**On*Event);
}


###排除所有注解类
-keepattributes *Annotation*
-keepattributes *JavascriptInterface*

#kotlin必须混淆
-dontwarn kotlin.**

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}



#不混淆所有的com.happy.food.model包下的类和这些类的所有成员变量
-keep class com.kycc.app.converter.**{*;}

#不混淆所有的com..kycc.app.model包下的类和这些类的所有成员变量，以下需要自己处理
#常见的需要混淆的有：Model层的数据，使用注解的类，反射的类
-keep class com.kycc.app.model.**{*;}
-keep class com.kycc.app.api.**{*;}




