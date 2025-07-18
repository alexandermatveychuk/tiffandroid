/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include <android/log.h>
#include <android/bitmap.h>
#include <stdlib.h>
#include <stdio.h>
#include "tiffio.h"
#include <unistd.h>
#include "NativeExceptions.h"
#include "NativeDecoder.h"
/* Header for class NativeTiffBitmapFactory */

#ifdef NDEBUG
    #define LOGI(x)
    #define LOGII(x, y)
    #define LOGIS(x, y)
    #define LOGE(x)
    #define LOGES(x, y)
#else
    #define LOGI(x) __android_log_print(ANDROID_LOG_DEBUG, "NativeTiffBitmapFactory", "%s", x)
    #define LOGII(x, y) __android_log_print(ANDROID_LOG_DEBUG, "NativeTiffBitmapFactory", "%s %d", x, y)
    #define LOGIS(x, y) __android_log_print(ANDROID_LOG_DEBUG, "NativeTiffBitmapFactory", "%s %s", x, y)
    #define LOGE(x) __android_log_print(ANDROID_LOG_ERROR, "NativeTiffBitmapFactory", "%s", x)
    #define LOGES(x, y) __android_log_print(ANDROID_LOG_ERROR, "NativeTiffBitmapFactory", "%s %s", x, y)
#endif

#ifndef _Included_org_beyka_tiffbitmapfactory_TiffBitmapFactory
#define _Included_org_beyka_tiffbitmapfactory_TiffBitmapFactory
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_beyka_tiffexample_TiffBitmapFactory
 * Method:    nativeDecodePath
 * Signature: (Ljava/lang/String;I)Landroid/graphics/Bitmap;
 */
JNIEXPORT jobject JNICALL Java_org_beyka_tiffbitmapfactory_TiffBitmapFactory_nativeDecodePath
  (JNIEnv *, jclass, jstring, jobject, jobject);

/*
 * Class:     com_example_beyka_tiffexample_TiffBitmapFactory
 * Method:    nativeDecodePath
 * Signature: (Ljava/lang/String;I)Landroid/graphics/Bitmap;
 */
JNIEXPORT jobject JNICALL Java_org_beyka_tiffbitmapfactory_TiffBitmapFactory_nativeDecodeFD
  (JNIEnv *, jclass, jint, jobject, jobject);

/*
 * Class:     com_example_beyka_tiffexample_TiffBitmapFactory
 * Method:    nativeCloseFd
 * Signature: (Ljava/lang/String;I)Landroid/graphics/Bitmap;
 */
JNIEXPORT jobject JNICALL Java_org_beyka_tiffbitmapfactory_TiffBitmapFactory_nativeCloseFd
        (JNIEnv *, jclass, jint);


#ifdef __cplusplus
}
#endif
#endif
