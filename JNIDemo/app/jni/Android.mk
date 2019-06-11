LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS) 
local_arm_mode:=arm #设置为ARM指令
LOCAL_MODULE    :=native-lib  #模块名称
LOCAL_SRC_FILES :=native-lib.cpp #源文件.c或者.cpp
LOCAL_LDLIBS +=-llog   #依赖库
include $(BUILD_SHARED_LIBRARY) #指定编译文件类型  这里是动态链接库 .so文件
