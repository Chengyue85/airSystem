package com.plus.utils;

import com.plus.po.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**字符串处理函数
 */
public class StringUtils {
	
	private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };

	public static boolean isNull(String name){
		if(name == null || "".equals(name)){
			return true;
		}else{
			return false;
		}
	}
	
	   /**
	    * des加密
	    * @param data
	    * @return
	    */
	    @SuppressWarnings("restriction")
//	    public static String encryptBasedDes(String data) {
//	      String encryptedData = null;
//	      try {
//	        // DES算法要求有一个可信任的随机数源
//	        SecureRandom sr = new SecureRandom();
//	        DESKeySpec deskey = new DESKeySpec(DES_KEY);
//	        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
//	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//	        SecretKey key = keyFactory.generateSecret(deskey);
//	        // 加密对象
//	        Cipher cipher = Cipher.getInstance("DES");
//	        cipher.init(Cipher.ENCRYPT_MODE, key, sr);
//	        // 加密，并把字节数组编码成字符串
//	        encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
//	      } catch (Exception e) {
//	        // log.error("加密错误，错误信息：", e);
//	        throw new RuntimeException("加密错误，错误信息：", e);
//	      }
//	      return encryptedData;
//	    }
//	    /**
//	     * 解密
//	     * @param cryptData
//	     * @return
//	     */
//	    @SuppressWarnings("restriction")
//	    public static String decryptBasedDes(String cryptData) {
//	      String decryptedData = null;
//	      try {
//	        // DES算法要求有一个可信任的随机数源
//	        SecureRandom sr = new SecureRandom();
//	        DESKeySpec deskey = new DESKeySpec(DES_KEY);
//	        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
//	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//	        SecretKey key = keyFactory.generateSecret(deskey);
//	        // 解密对象
//	        Cipher cipher = Cipher.getInstance("DES");
//	        cipher.init(Cipher.DECRYPT_MODE, key, sr);
//	        // 把字符串进行解码，解码为为字节数组，并解密
//	        decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
//	      } catch (Exception e) {
//	        throw new RuntimeException("解密错误，错误信息：", e);
//	      }
//	      return decryptedData;
//	    }
	    
	    
	    public String checkUser(User user){
	    	
	    	String reg = "/(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)/";
			String reg2 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
			
			Pattern pattern  = Pattern.compile(reg);
			Matcher m = pattern.matcher(user.getIdNumber());
			
			
			if("".equals(user.getUsername()) || user.getUsername() ==null){
				return "用户名为空";
			}
			
			if("".equals(user.getPassword()) || user.getPassword() == null){
				return "密码为空";
			}
			
			if(!m.matches()){
				return "身份证号不合规范";
			}else{
				pattern = Pattern.compile(reg2);
				m = pattern.matcher(user.getPhone());
//				System.out.println(user.getPhone());
//				System.out.println(pattern);
//				System.out.println(m.matches());
				if(!m.matches()){
					return "手机号不合规范";
				}else{
					return "数据合法";
				}
				
			}
			
	    	
	    }
	    
	    /*
	    @Test
	    public void text(){
	    	String s = "123456";
	    	StringUtils utils = new StringUtils();
	    	System.out.println(utils.encryptBasedDes(s));
	    	System.out.println(utils.decryptBasedDes(utils.encryptBasedDes(s)));
	    	
	    }*/
}
