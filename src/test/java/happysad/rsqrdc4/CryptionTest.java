package happysad.rsqrdc4;

import org.junit.Assert;
import org.junit.Test;

import happysad.rsqrdc4.impl.RC4;

public class CryptionTest {
	
	@Test
	public void testEncryption()
	{
		RC4 rc4 = new RC4();
		byte[] key = "This is my key!".getBytes();
		byte[] data = "This is my data!".getBytes();
		
		rc4.init(key);
		byte[] encrypted_data = rc4.encrypt(data);
		
		for(int i = 0; i < encrypted_data.length; i++) {
			Assert.assertNotEquals(data[i], encrypted_data[i]);
		}
	}
	
	@Test
	public void testDecrytpion()
	{
		RC4 rc4 = new RC4();
		byte[] key = "This is my key!".getBytes();
		byte[] data = "This is my data!".getBytes();
		
		rc4.init(key);
		byte[] encrypted_data = rc4.encrypt(data);
		
		rc4.init(key);
		byte[] decrypted_data = rc4.decrypt(encrypted_data);
		
		Assert.assertArrayEquals(data, decrypted_data);
	}
}
