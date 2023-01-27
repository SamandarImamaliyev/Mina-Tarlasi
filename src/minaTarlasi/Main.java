package minaTarlasi;

public class Main {

	public static void main(String[] args) {
		System.out.println("Mina Sahesi oyununa xos gelmisiniz!");
		System.out.println(
				"-1 minalarin yerini, -2 hemin xananin etrafinda minanin olmadigini, musbet reqemler ise hemin xananin etrafinda ne qeder minanin oldugunu bildirir. \nCalisin minaya toxunmayin.. \nUgurlar!");

		MinaTarlasi mayinTarlasi = new MinaTarlasi(3, 3);
		mayinTarlasi.run();
	}

}
