package exe2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class P2Test {
	
	private static ReadWrite vClass;
	
	@BeforeClass
	public static void setUp(){
		vClass = new ReadWrite();
	}
	
	@Test
	public void invalidFileNameTest() {
		String filename = "abaster@virus.com";
		assertEquals("Entrada invalida",vClass.Read(filename));
	}
	
	@Test
	public void readNotExistingFileTest() {
		String filename = "abaster1.txt";
		assertEquals("Arquivo inexistente",vClass.Read(filename));
	}
	
	@Test
	public void writeToFileTest() {
		String filename = "abaster.txt";
		assertEquals("Escrita realizada",vClass.Write(filename, new String[]{"uau"}));
	}
	
	@Test
	public void writeToThanReadFileTest() {
		String filename = "abaster.txt";
		assertEquals("Escrita realizada",vClass.Write(filename, new String[]{"uau"}));
		assertEquals("uau\n",vClass.Read(filename));
	}
}
