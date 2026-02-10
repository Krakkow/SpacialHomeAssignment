package com.spacial.utils;

public class LogicFuncs {

    private LogicFuncs() {
    }

    public static boolean isTitleValid(String title) {
        return title != null && !title.trim().isEmpty();
    }

    public static boolean isUrlValid(String url, int year) {
        return url != null && url.startsWith("https") && url.contains(String.valueOf(year));
    }

}
