LOCAL_PATH :=$(call my-dir)
include $(CLEAR_VARS) 
local_arm_mode:=arm #����ΪARMָ��
LOCAL_MODULE    :=native-lib  #ģ������
LOCAL_SRC_FILES :=native-lib.cpp #Դ�ļ�.c����.cpp
LOCAL_LDLIBS +=-llog   #������
include $(BUILD_SHARED_LIBRARY) #ָ�������ļ�����  �����Ƕ�̬���ӿ� .so�ļ�
