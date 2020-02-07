import java.io.*;
public class Main{
	public static void main(String[] args) {
		FileReader file;
		BufferedReader reader;
		PassTwo assembler = new PassTwo();
		
		try {
			reader = new BufferedReader(new FileReader("SYMTAB.txt"));
			assembler.setSymbolTable(reader);
			reader = new BufferedReader(new FileReader("LITTAB.txt"));
			assembler.setLiteralTable(reader);
			reader = new BufferedReader(new FileReader("IC.txt"));
			String machineCode = assembler.generateMachineCode(reader);
			System.out.println(machineCode);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}