package cn.zgys.wifi.util;

import java.util.Random;

public class Code {
	
		String cardNumber=returnCard();//调用下边的方法
		
		//随机不重复数（用于生成不重复帐号）
	   public String returnCard(){
//	       String cardNnumer=getCard();//调用生成随机数的方法：这里以6位为例
//	       SuECard eCard = eCardService.selectByCardNum(cardNnumer);//生成的随机数进入数据库中查询一下，看时候有相同的。
//	       if(eCard != null){//如果有相同的数据
//	          return returnCard();//再次调用方法，生成一个随机数
//	       }else{//否则
//	           return cardNnumer;//这个数据我就要
//	       }
	       return null;
	   }
	   //生成随机数（用于生成验证码）
	   public static String getCard(){
	       Random rand=new Random();//生成随机数
	        String cardNnumer="";
	        for(int a=0;a<6;a++){
	        cardNnumer+=rand.nextInt(10);//生成6位数字
	        }
	       return cardNnumer;
	   }
	   
	   //生成密码（2位字母+6位数字）
	   public static String getStringRandom() {  

	        String val = "";  
	        Random random = new Random();        
	        //length为几位密码 
	        for(int i = 0; i < 2; i++) {          
	            String charOrNum = "char";  
	            //输出字母还是数字  
	            if( "char".equalsIgnoreCase(charOrNum) ) {  
//	                //输出是大写字母还是小写字母  
//	                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
	                val += (char)(random.nextInt(26) + 97);  
	            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
	                val += String.valueOf(random.nextInt(10));  
	            }  
	        }	        
	        return val + getCard();  
	    }
	   
}
