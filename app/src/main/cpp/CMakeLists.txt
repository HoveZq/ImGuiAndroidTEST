cmake_minimum_required(VERSION 3.22.1)
project("externalsaray")

include_directories(ImGui)
include_directories(ImGui/backends)

add_library(${CMAKE_PROJECT_NAME} SHARED
        ImGui/imgui.cpp
        ImGui/imgui_demo.cpp
        ImGui/imgui_draw.cpp
        ImGui/imgui_tables.cpp
        ImGui/imgui_widgets.cpp
        ImGui/backends/imgui_impl_android.cpp
        ImGui/backends/imgui_impl_opengl3.cpp
        native-lib.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME}
        android
        GLESv3
        egl
        log)