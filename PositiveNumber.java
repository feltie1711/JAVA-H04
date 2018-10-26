
public class PositiveNumber {
	private int value;
	
	public PositiveNumber() {
		
	}
	
	public static void main(String[] args) {
		PositiveNumber p = new PositiveNumber();
		p.setDecimal("144");
		System.out.println("Binaer: " + p.getBinary());
		p.setHexadecimal("affe");
		System.out.println("Dezimal: " + p.getDecimal());
		p.setBinary("1000101011");
		System.out.println("Hexadezimal: " + p.getHexadecimal());
	}
	
	public void setDecimal(String s) {								//Nichts zu erklaeren, obvious
		try {
			this.value = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	public void setHexadecimal(String s) {
		String hex = "0123456789ABCDEF";							//Alle möglichen Hexadezimal-Werte
		String up = s.toUpperCase();	
		int exp = 0;
		int ergebnis = 0;											//Startwert
		for(int i = s.length()-1; i >= 0; i--) {					//Geht den String durch, Richtung egal, deshalb Standard
			char c = up.charAt(i);									//Nimmt sich den Character des Hex-Strings
			int d = hex.indexOf(c);									//Gleicht die Position mit obigem String ab (Position = Wert)
			ergebnis = (int)(Math.pow(16,exp)*d + ergebnis);		//...Also indexOf('F') == 15; und addet das auf val
			exp++;
		}
		this.value = ergebnis;
	}
	
	public void setBinary(String s) {								//Geht von hinten nach vorne den Eingabe-binaerstring durch
		int i = s.length()-1;										//und zaehlt die Exponenten pro stelle hoch
		int exp = 0;												//Kern des Codes:
		int tmp = 0;												//Wenn '1', dann ergebnis + 2^exp
		while(i >= 0) {
			if(s.charAt(i) == '1') {
				tmp += (int)Math.pow(2, exp);
			}			
			exp++;
			i--;
		}
		
		this.value = tmp;
	}
	
	public String getDecimal() {									//Witzig
		return String.valueOf(this.value);
	}
	
	public String getHexadecimal() {								//Selbes Prinzip wie oben mit dem Hexstring
		String hex = "0123456789ABCDEF";
		int val = this.value;
		int rest;
		String ergebnis = "";
		while(val > 0) {											//Solange die Zahl groesser 0 ist
			rest = val % 16;										//Nehme den Rest
			ergebnis = hex.charAt(rest) + ergebnis;					//Und haenge den hex-wert vom Rest vorne dran
			val /= 16;												//Geteilt rechnen und weiter
		}
		return ergebnis;
	}
	
	public String getBinary() {										//Siehe getHexadecimal() nur keine Benoetigung des hexstrings
		String ergebnis = "";
		int temp = this.value;
		do {
			ergebnis = (temp % 2) + ergebnis;
			temp = temp / 2;
		} while (temp != 0);
		return ergebnis;
	}
}
