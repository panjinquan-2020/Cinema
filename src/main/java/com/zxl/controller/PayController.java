package com.zxl.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.zxl.config.AlipayConfig;
import com.zxl.entity.TMovieorder;
import com.zxl.service.TMovieorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PayController {
    @Autowired
    private TMovieorderService tMovieorderService;

    private static String out_trade_no;

    @RequestMapping("/success")
    public String success(RedirectAttributes ra){
        //修改订单状态
        TMovieorder t=new TMovieorder();
        t.setOrderid(Integer.parseInt(out_trade_no));
        t.setStatus(1);
        tMovieorderService.update(t);
        ra.addFlashAttribute("message","支付成功");
        return "redirect:/userorder/findorder?page=1&pagesize=2";
    }

    @RequestMapping("/pay")
    public String payController(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//
//        //设置请求参数
//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        alipayRequest.setReturnUrl(AlipayConfig.return_url);
//        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
//
//
//        //商户订单号，商户网站订单系统中唯一订单号，必填
        out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//        //付款金额，必填
//        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"), "UTF-8");
//        //订单名称，必填
//        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"), "UTF-8");
//        //商品描述，可空
//        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"), "UTF-8");
//
//
//
//        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
//                + "\"total_amount\":\"" + total_amount + "\","
//                + "\"subject\":\"" + subject + "\","
//                + "\"body\":\"" + body + "\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//
//        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
//        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//        //		+ "\"total_amount\":\""+ total_amount +"\","
//        //		+ "\"subject\":\""+ subject +"\","
//        //		+ "\"body\":\""+ body +"\","
//        //		+ "\"timeout_express\":\"10m\","
//        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//
//        //请求
//        String form = "";
//        try {
//            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        response.setContentType("text/html;charset=" + AlipayConfig.charset);
//        response.getWriter().write(form);//直接将完整的表单html输出到页面
//        response.getWriter().flush();
//        response.getWriter().close();
        return "redirect:/success";

    }
}
