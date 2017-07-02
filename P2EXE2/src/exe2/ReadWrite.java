package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWrite {
	
	private boolean isInvalidInput(String s){
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher(s);
		
		return matcher.find()||s.isEmpty();
	}
	
	public String readOrWrite(String FILENAME,char operation,String[] writeLine){
		String result = "";
		
		if (isInvalidInput(FILENAME)){
			return "Entrada invalida";
		}
		
	    if (operation == 'R' || operation == 'r'){

			try (BufferedReader br = new BufferedReader(new FileReader(FILENAME));){
				
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					result+=sCurrentLine+"\n";
				}
			} catch (IOException e) {
				result = "Arquivo inexistente";
			} 
		}
		
		else if (operation == 'W' || operation == 'w'){
			
			if (writeLine==null){
				writeLine = new String[]{};
			}
			
			try(BufferedWriter buffWrite = new BufferedWriter(new FileWriter(FILENAME));)
			{
				for (int i=0;i<writeLine.length;i++){
					buffWrite.append(writeLine[i] + "\n");
				}
				result = "Escrita realizada";
			} catch (IOException e) {
				result = "Arquivo invalido";
			} 
		}
		else{
			result = "Operacao invalida";
		}
	    return result;
	}
}
