package デザインパターン最後;
 
public class Adapter {
	 public static void main(String[] args) {
	  Dengen d; d = new AcAdapter();
	  d.print();
	  }
	 }

	interface Dengen { // Target
	 public int kyuuden();
	 public abstract void print();
	 }

	class JapaneseConsent { // Adaptee
	 public int power() {
	  return 100;
	  }
	 }

	class AcAdapter extends JapaneseConsent implements Dengen { // Adapter
	 public int kyuuden() {
	  return (int)(power() * 0.16);
	  }
	 public void print() {
		 System.out.println( kyuuden() + "V で給電されています" );
	 }
	 }