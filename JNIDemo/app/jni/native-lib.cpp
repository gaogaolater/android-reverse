#include <jni.h>
#include <android/log.h>

#define LOG_TAG "gaogao"
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN  , LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR  , LOG_TAG, __VA_ARGS__)

extern "C" JNIEXPORT jstring JNICALL
Java_com_aqiang_jnidemo_jnidemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    return env->NewStringUTF("Hello from C++");
}

jdouble add(JNIEnv* env,jobject obj,jfloat a,jfloat b){
    return a+b;
}

jdouble minus(JNIEnv* env,jobject obj,jfloat a,jfloat b){
    return a-b;
}

jdouble mutiply(JNIEnv* env,jobject obj,jfloat a,jfloat b){
    return a*b;
}

jdouble divide(JNIEnv* env,jobject obj,jfloat a,jfloat b){
    return a/b;
}

 //注册Java端的方法  以及本地相对应的方法
JNINativeMethod nativeMethods[]={
  {"add","(FF)D",(void*)add},
  {"minus","(FF)D",(void*)minus},
  {"mutiply","(FF)D",(void*)mutiply},
  {"divide","(FF)D",(void*)divide},
};

//实现jni_onload 动态注册方法
jint JNI_OnLoad(JavaVM* vm, void* reserved) {
	JNIEnv* env = NULL;
	if (vm->GetEnv((void**) &env, JNI_VERSION_1_4) != JNI_OK) {
		return JNI_ERR;
	}
	jclass cl=env->FindClass("com/aqiang/jnidemo/jnidemo/MainActivity");
    if((env->RegisterNatives(cl,nativeMethods,sizeof(nativeMethods)/sizeof(nativeMethods[0])))!=JNI_OK){
        return JNI_ERR;
    }
    return JNI_VERSION_1_4;//必须返回这个值
}
