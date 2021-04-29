package day8;

import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author 程方园
 * @className HttpTest
 * @date 2021/4/13
 */
public class HttpTest {

//    String encryptedData =
//            AesUtils.aesEncrypt(json 格式数据, AES 秘钥);

    //aesEncrypt:如下
    public static String aesEncrypt(String data, String secretKey) {
        try {
            // 加密算法/
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //工作模式 / 填充方式
            byte[] dataBytes = data.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, new
                    SecretKeySpec(Base64Utils.decodeFromString(secretKey), "AES"));
            byte[] result = cipher.doFinal(dataBytes);
            return Base64Utils.encodeToString(result);
        } catch (Exception e) {
//            log.error("执行 CodecUtil.aesEncrypt 失败： data={}， 异常： {}", data, e);
        }
        return null;
    }


    //    a
//    esDecrypt 解密 如下:
    public static String aesDecrypt(String encryptedDataBase64, String securityKey) {
        try {

            List<String> stringList = new ArrayList<>();

            for (String str : stringList) {
                System.out.println(str);
            }

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
// / 加密算法/工作模式/填充方式
            byte[] dataBytes = Base64Utils.decodeFromString(encryptedDataBase64);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64Utils.decodeFromString(securityKey), "AES"));
            byte[] result = cipher.doFinal(dataBytes);

            return new String(result);
        } catch (Exception e) {
//            log.error("执行 aesDecrypt 失败： data={}， 异常： {}", encryptedDataBase64, e);
            throw new RuntimeException("");
        }
    }
////    示例:数据加密
//ObjectUtil.writeValueAsString():
//    //将对象转为 json
//    //字符串 目录 1.2.3中有代码示例
//    String encryptedData = AesUtils.aesEncrypt(ObjectUtil.writeValueAsString(param),"秘钥");

}
