package com.spring.vnbig.first.init_start.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类 返回ip地址，请求参数
 */
@Controller
public class TestController {


    @RequestMapping("/version")
    public String testversion(HttpServletRequest request) {
        return "3";
    }

    @RequestMapping(value = "/paramlist")
    @ResponseBody
    public String requestList(@RequestParam("listParam[]") List<String> param) {
        String reStr = param.toString();
        System.out.println("paramlist @@:" + reStr);
        return "Request successful. Post param : List<String> - " + param.toString();
    }

    @RequestMapping(value = "/parammap")
    @ResponseBody
    public String requestList(@RequestParam Map<String, Object> param) {
        String reStr = param.toString();
        System.out.println("parammap @@:" + reStr);
        return "Request successful. Post param : Map - " + param;
    }


    @RequestMapping("/modelip")
    public ModelAndView getIpAddrForWeb(HttpServletRequest request, HttpServletResponse response) {
        String ip = TestController.getRealIp(request);
        System.out.println("the client Ip is " + ip);
        ModelAndView model = new ModelAndView();
        model.setViewName("welcome");
        model.addObject("ip", ip);
        return model;
    }

    @RequestMapping("/stringip")
    public void getIpAddrForIphone(HttpServletRequest request, HttpServletResponse response) {
        String ip = TestController.getRealIp(request);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(ip);
        out.flush();
    }


    @RequestMapping("/jsonip")
    public void getJsonData(HttpServletRequest request, HttpServletResponse response) {
        String ip = TestController.getRealIp(request);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ip", ip);
        map.put("id", 12121);
        map.put("name", "dyn");
        map.put("time", System.currentTimeMillis());
        String mapJson = JSON.toJSONString(map);

        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(mapJson);
        out.flush();

    }

    private static String getRealIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
