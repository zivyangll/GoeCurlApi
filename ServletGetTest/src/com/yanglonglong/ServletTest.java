package com.yanglonglong;


import com.google.gson.Gson;
import com.google.gson.JsonElement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTest extends javax.servlet.http.HttpServlet {
    //��ʼ��
    public void init() throws ServletException {
        System.out.println("����init()�������������г�ʼ������");
    }

    //����GET����
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=GB2312");

        String jsonStr = "{'password':'123456','username':'����'}";
        Gson gson = new Gson();
        JsonElement a = gson.toJsonTree(jsonStr);
        PrintWriter out = null;
        out = response.getWriter();// ��������out
        out.println(a.toString());
        out.flush(); // ��ˢ������
        out.close(); // �ر����
    }

    //����POST����
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    //����ʵ��
    public void destroy() {
        super.destroy();
        System.out.println("����destroy()������������������ʵ���Ĺ���");
    }
}