#include <jni.h>
#include <stdio.h>
#include <fenv.h>
#include "RoundingJNI.h"


JNIEXPORT void JNICALL Java_RoundingJNI_round_1down(JNIEnv *env, jobject thisObj) {
	fesetround(FE_DOWNWARD);
}

JNIEXPORT void JNICALL Java_RoundingJNI_round_1up(JNIEnv *env, jobject thisObj) {
	fesetround(FE_UPWARD);
}