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
		
		StringBuffer sb;
		
		for(int rounds = 1; rounds <= 10; rounds++)
		{
			sb = new StringBuffer();
			
			rc4.init(key);
			byte[] encrypted_data = rc4.encrypt(data, rounds);
			
			for(int i = 0; i < encrypted_data.length; i++) {
				sb.append(String.format("%02X ", encrypted_data[i]));
				Assert.assertNotEquals(data[i], encrypted_data[i]);
			}
			
			System.out.println("Encrypted[" + rounds + " rounds]: \t\t" + sb.toString() + " \tLength: " + encrypted_data.length);
			sb = null;
		}
	}
	
	@Test
	public void testDecrytpion()
	{
		RC4 rc4 = new RC4();
		byte[] key = "This is my key!".getBytes();
		byte[] data = "This is my data!".getBytes();
		
		rc4.init(key);
		byte[] encrypted_data = rc4.encrypt(data, 2);
		
		rc4.init(key);
		byte[] decrypted_data = rc4.decrypt(encrypted_data, 2);
		
		Assert.assertArrayEquals(data, decrypted_data);
	}
}
