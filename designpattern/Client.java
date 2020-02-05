package デザインパターン02;
 
public class Client {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Koujyou koujyou1 = new TvKoujyou();
		Koujyou koujyou2 = new RadioKoujyou();
		Seihin[] array = new Seihin[3];
		array[0] = koujyou1.create();
		array[1] = koujyou2.create();
		array[2] = koujyou1.create();
		for (int i = 0; i < array.length; ++i) { array[i].print();
		}
		}
	}
//テレビとラジオ用の親クラス
abstract class Koujyou {
	public final Seihin create() {
		Seihin seihin = factoryMethod(); touroku(seihin);
		return seihin;
		}
	public abstract Seihin factoryMethod();
	public abstract void touroku(Seihin s);
}
//テレビ専用のインスタンスを作っている
class TvKoujyou extends Koujyou {
	public Seihin factoryMethod() {
		return new Television();
		}
	public void touroku(Seihin s) {
		Television t = (Television) s;
		t.numberring();
		t.setDate(Date.today());
		}
			}
//ラジオ専用の製造番号などのインスタンスを作っている
	class RadioKoujyou extends Koujyou {
		public Seihin factoryMethod() {
			return new Radio();
			}
		public void touroku(Seihin s) {
		Radio r = (Radio) s; r.numberring();
		}
	}
	//入力された情報を出力する処理（テレビ版）
	class Television extends Seihin {
		private int tvSerialNumber;
		private String date;
		public void numberring() {
			tvSerialNumber = Counter.getTvNumber();
			}
		public void setDate(String date) {
			this.date = date;
			}
		public void print() {
			System.out.println("このテレビに関する情報:");
			System.out.println(" 製造番号:" + tvSerialNumber);
			System.out.println(" 製造年月日:" + date);
	}
	}
	abstract class Seihin {
		public abstract void print();
		}

//入力された情報を出力する処理（ラジオ版）
	class Radio extends Seihin {
		private int radioSerialNumber;
		public void numberring() {
			//カウンタークラスからラジオ用の数値をとりだす
			radioSerialNumber = Counter.getRadioNumber();
			} public void print() {
				System.out.println("このラジオに関する情報:");
				System.out.println(" 製造番号:" + radioSerialNumber);
	}
	}
	//必要な値を入力する処理
	class Date {
		public static String today() {
			return "2004/01/20";
			}
		}
	class Counter {
		private static int tvNum = 100;
		private static int radioNum = 76;
		public static int getTvNumber() {
			return tvNum++;
			}
		public static int getRadioNumber() {
			return radioNum++;
	}
	}















