#include <jni.h>
#include <GLES3/gl3.h>
#include "imgui.h"
#include "imgui_impl_opengl3.h"
#include "imgui_impl_android.h"
#include "android/native_window_jni.h"

extern "C" JNIEXPORT void JNICALL
Java_com_HESOYAM_externalsaray_FloatingMenu_ImGuiInit(JNIEnv* env, jobject) {

    ImGui::CreateContext();
    ImGui_ImplOpenGL3_Init();
    ImGui::StyleColorsClassic();
}

extern "C" JNIEXPORT void JNICALL
Java_com_HESOYAM_externalsaray_FloatingMenu_ImGuiRender(JNIEnv* env, jobject) {
    ImGui_ImplOpenGL3_NewFrame();
    ImGui::NewFrame();
    ImGui::ShowDemoWindow();
    ImGui::EndFrame();
    ImGui::Render();
    ImGui_ImplOpenGL3_RenderDrawData(ImGui::GetDrawData());
}

extern "C" JNIEXPORT void JNICALL
Java_com_HESOYAM_externalsaray_FloatingMenu_ImGuiResize(JNIEnv* env, jobject, jint width, jint height) {
    ImGui::GetIO().DisplaySize = {(float) width, (float) height};
}

extern "C" JNIEXPORT void JNICALL
Java_com_HESOYAM_externalsaray_FloatingMenu_ImGuiInput(JNIEnv* env, jobject, jobject input) {

}