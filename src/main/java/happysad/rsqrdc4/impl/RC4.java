package happysad.rsqrdc4.impl;

import happysad.rsqrdc4.IDecrypt;
import happysad.rsqrdc4.IEncrypt;

public class RC4 implements IEncrypt, IDecrypt {
	
	private final byte[] S = new byte[256];
	private final byte[] T = new byte[256];
	
	public void init(byte[] key) {
		if(key.length < 1) {
			throw new IllegalArgumentException("A key must be specified of length which is greater than 0!");
		} else {
			for(int i = 0; i < 256; i++) {
				S[i] = (byte) (i);
				T[i] = key[i % key.length];
			}
			
			int j = 0;
			for(int i = 0; i < 256; i++) {
				j = (j + S[i] + T[i]) & 0xFF;
				
				byte tmp = S[j];
				S[j] = S[i];
				S[i] = tmp;
			}
		}
	}
	
	public byte[] encrypt(byte[] data) {
		final byte[] cipherdata = new byte[data.length];
		
		int i = 0, j = 0;
		int k, t;
		
		for(int c = 0; c < data.length; c++) {
			i = (i + 1) & 0xFF;
			j = (j + S[i]) & 0xFF;
			
			byte tmp = S[j];
			S[j] = S[i];
			S[i] = tmp;
			
			t = (S[i] + S[j]) & 0xFF;
			k = S[t];
			
			cipherdata[c] = (byte) (data[c] ^ k);
		}
		
		return cipherdata;
	}
	
	public byte[] decrypt(byte[] data) {
		
		return encrypt(data);
	}
}
