
public class HardDrive {
	public byte[] read(long lba, int size) {
		byte[] data = {new Byte((byte) 0x0001), new Byte((byte) 0x1001)};
		System.out.println("HardDrive: reading");
		return data;
	}
}
