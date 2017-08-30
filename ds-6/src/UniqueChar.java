import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
public class UniqueChar {
	Map<String, Integer> cache;
	
	public UniqueChar(){
		cache =new HashMap<String, Integer>();
	}
	/**
	 * @param str - input String
	 * @return  - return no of unique char
	 */
	int getUniqueChar(String str){
		/*
		 * check if present in memory then return with unique char
		 */
		if(cache.containsKey(str)){
			System.out.print(" in Memory : ");
			return cache.get(str);
		}else{
			/*
			 * create map for each char present in String
			 */
			Map<Character, Integer> m=new HashMap<Character, Integer>();
			for(int i=0;i<str.length();i++){
				if(m.containsKey(str.charAt(i))){
					int j=m.get(str.charAt(i));
					m.put(str.charAt(i), j+1);
				}else{
					m.put(str.charAt(i), 1);
				}
			}
			/*
			 * if value of char is more then one then remove from map
			 */
			int i=-1;
			char ch[]=new char[str.length()];
			for(Character c : m.keySet()){
				if(m.get(c)>1){
					ch[++i]=c;
				}
			}
			for(int j=0;j<=i;j++){
				m.remove(ch[j]);
			}
			cache.put(str,m.size());
			
		}
		return cache.get(str);
	}
	public static void main(String[] args) {
		UniqueChar uniqueChar=new UniqueChar();
		
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("raaam jp"));
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("raaam jp"));	
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("aaabcd"));
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("ramvilas"));
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("ramvilas"));
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("aaabcd"));
		System.out.println(" Unique chars : " +uniqueChar.getUniqueChar("pqrstuvwxx"));
	}

}
