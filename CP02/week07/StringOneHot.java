package lab07;

import java.util.*;

public class StringOneHot {
	private String str;
	private Map<Integer, String> strMap;
	private Set<String> strSet;
	private ArrayList<ArrayList<Integer>> oneHotVec;
	private Map<String, ArrayList<Integer>> strOneHotVec;

	public StringOneHot(String s) {
		// TODO: 생성자 구현
		this.str=s;
		String str = "Hello";

		this.strSet = new LinkedHashSet<>();
		for(int i=0;i<str.length();i++){
			strSet.add(String.valueOf(str.charAt(i)));
		}

		List<String> sorted = new ArrayList<>(strSet);
		Collections.sort(sorted);

		this.strMap = new HashMap<>();
		for(int i=0;i<sorted.size();i++){
			strMap.put(i,sorted.get(i));
		}

		this.oneHotVec = new ArrayList<>();
		for(int i=0;i<sorted.size();i++){
			ArrayList<Integer> oneHot = new ArrayList<>();
			for(int j=0;j<sorted.size();j++){
				oneHot.add(0);
			}
			oneHot.set(i,1);
			oneHotVec.add(oneHot);
		}

		this.strOneHotVec = new HashMap<>();
		for(int i=0;i<sorted.size();i++){
			strOneHotVec.put(sorted.get(i), oneHotVec.get(i));
		}
	}

	public Set<String> getStrSet(){
		// TODO: 수정
		return strSet;
	}

	public Map<Integer, String> getStrMap(){
		// TODO: 수정
		return strMap;
	}

	public Map<String, ArrayList<Integer>> getStrOneHotVec(){
		// TODO: 수정
		return strOneHotVec;
	}

	public String getString() {
		// TODO: 수정
		return str;
	}
}


