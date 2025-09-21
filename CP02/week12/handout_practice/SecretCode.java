package lab11_week12.handout_practice;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SecretCode {

	public static void main(String[] args) throws IOException{
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in  = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\untitled\\src\\lab11_week12\\handout_practice\\from.txt"));
			out = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\untitled\\src\\lab11_week12\\handout_practice\\encrypted.txt"));
			int c;
			int uni = -('a' - 'D') ;
			while((c = in.read()) != -1) {
				// TODO: secretCode로 변환하여 저장
				if (c < 65){
					out.write(c);
				} else{
					c = Character.toLowerCase(c);
					if(c>119){
						c = c-26;
					}
					c= c+uni;
					out.write(c);
				}

			}
		}finally {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
	}
}
