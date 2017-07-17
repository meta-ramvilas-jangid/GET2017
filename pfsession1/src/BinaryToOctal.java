//package pfsession1;

public class BinaryToOctal {
	
		public int convertBinaryToOctal(long n){
		    String str=n+""; //convert long to string
			StringBuffer sb=new StringBuffer(str);
			if(sb.indexOf(".")!=-1){   // check weather input is decimal
				return -1;
			}
				
			int l=str.length();  //length of string
	        /**
	         * convert size of string into multiple of three 
	         * by adding 0 in left side
	         */
			if(l%3==1){ 
				sb.insert(0,"00");
			}else if(l%3==2){
				sb.insert(0,"0");
			}
			
			l=sb.length();
			String ss="";
			for(int i=0;i<l;i=i+3)
			{
	     		String s=sb.substring(i, i+3);
	            switch(s){
		           case "000" :  ss=ss+"0";
		                         break;		  
		           case "001" :  ss=ss+"1";
		            			 break; 
		           case "010" :  ss=ss+"2";
		           				 break;
		           case "011" :  ss=ss+"3";
		            			 break;
				   case "100" :  ss=ss+"4";
								 break;
				   case "101" :  ss=ss+"5";
								 break;
				   case "110" :  ss=ss+"6";
								 break;
				   case "111" :  ss=ss+"7";
								 break;				
				}
	        }
			/**
			 * convert string to int
			 */
			int p=Integer.parseInt(ss);
			return p;
		}
	}




