package happysad.rsqrdc4;

public interface IEncrypt {
	
	public void init(byte[] key);
	
	public byte[] encrypt(byte[] data, int rounds);
}
