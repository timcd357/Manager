package com.apixel.manager.utils;

public class Message<T> {
    private int code;
    private String msg;
    private T data;
    /**
     * 成功时候的调用
     */
    public static <T> Message<T> success() {
        return new Message<T>(200, "成功");
    }
    /**
     * 成功时候的调用
     */
    public static <T> Message<T> success(T data) {
        return new Message<T>(200, "成功", data);
    }
    /**
     * 失败时候的调用
     */
    public static <T> Message<T> error(CodeMsg codeMsg) {
        return new Message<T>(codeMsg);
    }
    private Message(T data) {
        this.data = data;
    }
    private Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private Message(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    private Message(CodeMsg codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
