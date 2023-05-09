package com.zxl.config;
import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000121688191";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCARfJEUJVBYX+tyujie9urIyas6n9ohiBo8B2eYylWPdzIy+yfWnLgprL/Tmx2gCzyuNUm+KwWVyZAgoBE8TafMXcXIOS34sE5RcjTVMDcceidFCUnH0UqoDI1Z9RgXhejerXMV5rw/jZkdFxB8+FoHH1MBKe2+rJZQYycojsigFWovykGp/Vh2peMXhcMbhBg0J27uu5JBSywo7X+SF+vtHctTF5xEJuHDU0X2jXXTEbnrgJH8bLZQpzY9P3wgiCVLJ/myCH/VFtwt7YXpjwuWtbngPZJbu6JhEbJccxgazQu9hHyDNr5U/CKL9icuh8biddsojNWyKxxO6/B9bLxAgMBAAECggEAaiP2vOqFJo2bzd4J6GaetTSn6ws7E+1wYgTWLVpWOSOFTq3XBWEdj6DAmpt1CnUzPEEPN2krVG0WnOifZOzHyuBub7frKfG6+z4wWBZYY9DprxidSYsJe6UFBsX8qSUSoFaImiafceyYa3URZg18pd51G3L6qGE3NL4VsQJYtkmYfEIMv7u0s7DO5iZEu4p4VrFaiYw2dwKUxEv/Df1dgPV4iwZ6TTz/XISfklgnm92b3jsFrTfSePg1nnttd69hg1MOAFdAc195ei+qfiu+0jp8vPFB/AfBKEMZKAqtjeYbvHVtTiNAPQ9JPd/u2hvKaPXWG4wYe7wkXzFVFTkbBQKBgQDCI2fbG6YzOyrsSbMF6GqtXncdW31RKQ/7P0bvgFzwVUX6B7BVp5dwihi9pVlNfVL1ak8SomMtcoeOKf44AvKbFW3r0VuokGJSAOPwslszJhavxoCs6Fj4IBUfqxgAvkUioTyUehXRW6tymEIFaUOQ5dN7etEBEhGnzkTu/skzmwKBgQCpJa2E1Jhv4s32uxVm2dq97fPss+qpQ/ZnFvT9F4BrKhij4f/OI1q8PgVmEzUniJNp0jKwcc5KQaCYTao6FeP1yGJ8wnq9yVaTJFGQzr+IhSzQUn92lWDiXOUOObyH/zSFOjzjReT3AVt6CRe/DYPRezR1cHzBtVWO7bQoDcsaYwKBgQCtlgjb0nomHsZ/ZlqLcshH4kpxVofT1Pp0NZ0Qs17miei66rsRq3tuZhw/HiSec+uEgpzXVZmGXny0cfncTU5tupiBnb3uF8PB/QfTBTckoe7xFnWhpVM/8TfSDCK3L2oTz8WiIRN3EhdXrKqDuh5u5gDVzPgqk+Rzfa0HYYu39wKBgBMoiFnWNpndp5R9pjPrEwKWNB2oVzjq0Lrmd8M+6TW6I+ZUD8RKbtmJcNUZ8dhTeNbwjvs7OLFic40sps5DcnmBQ957rKlYZ6zs3Sw4rqsI4oWKApPs4XdiLDOLSJZiypEYgpL/dKqhhbnx07W5Eygj+1Id9pN+NX2l4NT0kv+fAoGAYj8APaw0gZVqdAV4sgnv9mGw09yfGBO7nTUl5ETZQVeEhUIJDrR1X/zW/pF6HKs/GetIXX/2Zy9K1i1CDuOAnYGpcWru+ivMEAv09JeOLadZNA9bmiJx5fUJ9dlyGDNSiJJdfLPzEn+ccWiwtHfwYlwiAcqpKgPsTVkzLgpTnSw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhdIZpsLKAiEoSINFTwRjMkygSHNcGA6x0wqioRN2hN5N23lan9pHaR9Knj2NCw1o/QRXjdza8FMIKhb2ZRgBqqtHeZQ/CC/8km/PviVYBTNPv7vM2w+3eteNsza5zbqKGbXJKkekTgfNqBMNDFTAsZPpV55uDlUkws/tYvX5ypVXzWkI35VxwJ/FXvDKPP+PrQRJahYF4CYkaXXiLXfWkDO2xm6Lzxq3wXLfBDxQ1du01Zz7xELyg9XxQmnO1Kno+hIWF8P1qNTbJyjapR21rAtHTXrwD31ukeHpT1HxBnBoDmRgQp12z29zVSVExaihYYDONxJRnudl4FVvEGDdWwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/success";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
