import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManagerStudent;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("THE WORLD IS ENDING"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS NOT FUN\""));
		assertFalse(CryptoManager.isStringInBounds("omg"));
		assertFalse(CryptoManager.isStringInBounds("Linh Trần"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("apple", 5));
		assertEquals("B?FFIZQILF>", CryptoManager.caesarEncryption("HELLO WORLD", 250));
		assertEquals("UV'TVYL'KYLHT", CryptoManager.caesarEncryption("NO MORE DREAM", 7));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("OLSSV'^VYSK", 7));
		assertEquals("NO MORE DREAM", CryptoManager.caesarDecryption("GHYFHK>Y=K>:F", 825));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("JQMOZ0 ]],M", CryptoManager.bellasoEncryption("HELLO WORLD", "BLACKPINK IN YOUR AREA"));
		assertEquals("KTYY$VNOM#QTZ,X[%WQ(", CryptoManager.bellasoEncryption("COMMUNICATION IS KEY", "HELLO"));
		assertEquals("D &L9>@H['#%", CryptoManager.bellasoEncryption("ASSIGNMENT 3", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption("JQMOZ0 ]],M", "BLACKPINK IN YOUR AREA"));
		assertEquals("COMMUNICATION IS KEY", CryptoManager.bellasoDecryption("KTYY$VNOM#QTZ,X[%WQ(", "HELLO"));

	}

}
