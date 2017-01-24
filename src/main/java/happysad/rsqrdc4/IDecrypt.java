package happysad.rsqrdc4;

public interface IDecrypt {
	
	public void init(byte[] key);
	
	public byte[] decrypt(byte[] data);
}
