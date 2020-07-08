package com.apixel.manager.utils;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    private static final String slat = "&%5123***&&%%$$#@";
    /**
     * 清除html标签
     *
     * @param line
     * @return
     */
    public static String removeHtmlTag(String line) {
        if (line == null) {
            return null;
        }
        String htmlStr = line;
        String textStr = "";
        try {
            // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            // 定义HTML标签的正则表达式
            String regEx_html = "<[^>]+>";
            // 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
            String regEx_special = "\\&[a-zA-Z]{1,10};";
            // 过滤script标签
            Pattern p_script = Pattern.compile(regEx_script, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            // 过滤style标签
            htmlStr = m_script.replaceAll("");
            Pattern p_style = Pattern.compile(regEx_style, 2);
            Matcher m_style = p_style.matcher(htmlStr);
            // 过滤html标签
            htmlStr = m_style.replaceAll("");
            Pattern p_html = Pattern.compile(regEx_html, 2);
            Matcher m_html = p_html.matcher(htmlStr);
            // 过滤特殊标签
            htmlStr = m_html.replaceAll("");
            Pattern p_special = Pattern.compile(regEx_special, 2);
            Matcher m_special = p_special.matcher(htmlStr);
            htmlStr = m_special.replaceAll("");
            textStr = htmlStr.replace("\\n", "").replace("\\t", " ").replace("\t", " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;
    }

    public static String md5Encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
