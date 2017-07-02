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
		assertEquals("Entrada invalida",vClass.readOrWrite(filename, 'r', null));
	}
	
	@Test
	public void invalidOperationTest() {
		String filename = "abaster.txt";
		assertEquals("Operacao invalida",vClass.readOrWrite(filename, 't', null));
	}
	
	@Test
	public void readNotExistingFileTest() {
		String filename = "abaster1.txt";
		assertEquals("Arquivo inexistente",vClass.readOrWrite(filename, 'r', null));
	}
	
	@Test
	public void writeToFileTest() {
		String filename = "abaster.txt";
		assertEquals("Escrita realizada",vClass.readOrWrite(filename, 'w', new String[]{"uau"}));
	}
	
	@Test
	public void writeToThanReadFileTest() {
		String filename = "abaster.txt";
		assertEquals("Escrita realizada",vClass.readOrWrite(filename, 'w', new String[]{"uau"}));
		assertEquals("uau\n",vClass.readOrWrite(filename, 'r', null));
	}
}
