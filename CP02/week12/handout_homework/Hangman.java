package lab12_handout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
	private List<String> wordList = new ArrayList<>();
	private int limit;  // 제한횟수
	private int index;  // 랜덤 문제번호
	private String question;  // 리스트에서 꺼낸 문제
	private String correct;
	private String underscore;   // 화면에 나타나는 언더바
	private String answer;   // 사용자의 정답
	private String toUpperA, toUpperQ;   // 정답비교를 위해 사용하는 대문자 문자열
	private Scanner sc = new Scanner(System.in);

	public Hangman() {
		try {
			readText();
			this.index = (int)(this.wordList.size() * Math.random());
			this.question = wordList.get(index); // 문제선택
			this.limit = question.length() * 2; // 반복횟수는 문자열 길이의 두배
			toUpperQ = question.toUpperCase(); // 비교를 위해 대문자로 만듬
			underscoreMaker(); // 문제의 길이에 따라 언더바 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readText() throws IOException {
		// TODO: 주어진 파일 (hangman.txt)를 읽어서 wordList를 업데이트
		try(BufferedReader br = new BufferedReader(new FileReader("hangman.txt"))){
			String a;
			while((a = br.readLine()) != null){
				if(!a.trim().isEmpty()) {
					wordList.add(a.trim());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void underscoreMaker() {  // 화면에 나타나는 underscore와 비교한 정답 생성
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();
		for(int i = 0; i < question.length(); i++) {
			str1.append("_ ");
			str2.append(question.charAt(i));
		}
		this.underscore = new String(str1);
		this.correct = new String(str2);
	}

	public void play() {
		System.out.println("행맨 게임!");
		System.out.println("(제한 횟수는 " + limit + "번입니다.)");
		while(true) {
			System.out.println("현재 상태: " + underscore);
			System.out.print("문자를 입력해주세요(한글자): ");
			answer = sc.next();
			if(answer.length() != 1) {
				System.out.println("한글자만 입력가능합니다.");
				continue;
			}
			toUpperA = answer.toUpperCase();
			compare();
			if(underscore.equals(correct)) {
				System.out.println("현재 상태: " + underscore);
				System.out.println("정답을 맞췄습니다.");
				break;
			}
			limit--;
			if(limit == 0) {
				System.out.println("정답을 맞추지 못했습니다.");
				System.out.println("정답: " + this.question);
				break;
			}
		}
		sc.close();
	}

	public void compare() {
		// TODO: compare 함수 내부 구현
		boolean q = false;
		char[] underArray = underscore.toCharArray();

		for(int i=0;i<question.length();i++){
			if(toUpperA.charAt(0) == toUpperQ.charAt(i)){
				underArray[i*2] = question.charAt(i);
				q = true;
			}
		}
		if(q){
			underscore = new String(underArray);
		}
	}
	public static void main(String[] args) {
		Hangman h = new Hangman();
		h.play();
	}
}
