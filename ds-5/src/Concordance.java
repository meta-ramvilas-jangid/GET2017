import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Concordance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Character,List<Integer>> m=new HashMap<Character, List<Integer>>();
		String contain="";
		for(String str : args){
			contain+=str;
		}
		char ch[]=contain.toCharArray();
		
		for(int i=0;i<contain.length();i++){
			List<Integer> list=new ArrayList<Integer>();
			char c=contain.charAt(i);
			if(m.containsKey(c)){
				list=m.get(c);
				list.add(i);
				m.put(c, list);
			}else{
				list.add(i);
				m.put(c, list);
			}
		}
        String output=contain+" {";
		for(char c:m.keySet()){
			output+=c+" = "+m.get(c)+", ";
		}
		
		output=output.replaceAll(", $","}");
		System.out.print(output);
		
		
		
	}

}
