
public class PositiveNumber {

	private int value;

	public PositiveNumber() {
	}

	public void setDecimal(String s) {
		try{
			value = Integer.parseInt(s);
		}
		catch(Exception e){e.printStackTrace();}
	}
/*
 * rechnet den uebergebenen hex-Wert in eine Dezimalzahl um
 *  @param s
 */
	public void setHexadecimal(String s) {
		try{
			int tmpVal=0; //tmp Variable um value nicht zu überschreiben
			char[] values = s.toCharArray(); //Hex-Zahl auftrennen
		
		for(int i=0;i<values.length;i++) {
			int pow = Math.round(Math.round(Math.pow(16, values.length-1-i))); //Stelle des Zeichens in der Hex Zahl um mit 16^Stelle zu multiplizieren
			if(values[i]=='0'); //Die einzelnen moeglichen Hex-Werte werden abgefragt
			else if(values[i]=='1')tmpVal += 1*pow; // und dann wie zuvor genannt mit pow multipliziert multipliziert
			else if(values[i]=='2')tmpVal += 2*pow;
			else if(values[i]=='3')tmpVal += 3*pow;
			else if(values[i]=='4')tmpVal += 4*pow;
			else if(values[i]=='5')tmpVal += 5*pow;
			else if(values[i]=='6')tmpVal += 6*pow;
			else if(values[i]=='7')tmpVal += 7*pow;
			else if(values[i]=='8')tmpVal += 8*pow;
			else if(values[i]=='9')tmpVal += 9*pow;
			else if(values[i]=='A' || values[i]=='a')tmpVal += 10*pow;
			else if(values[i]=='B' || values[i]=='b')tmpVal += 11*pow;
			else if(values[i]=='C' || values[i]=='c')tmpVal += 12*pow;
			else if(values[i]=='D' || values[i]=='d')tmpVal += 13*pow;
			else if(values[i]=='E' || values[i]=='e')tmpVal += 14*pow;
			else if(values[i]=='F' || values[i]=='f')tmpVal += 15*pow;
			else throw new NumberFormatException(); //falls eine Stelle keinem der bekannten Zeichen entspricht, Exception werfen
			
		}
		if(tmpVal>Integer.MAX_VALUE || tmpVal<0)throw new ArithmeticException();
		value = tmpVal;
		}catch(NumberFormatException e) {System.out.println("Fehlerhafte Eingabe");}
		catch(ArithmeticException e) {System.out.println("nicht erlaubte Zahlengroesse");}
	}

	/**
	 * Wandelt den Input s ins Dezimalsystem um, und setzt den internen Wert value zum Dezimalwert der uebergebenen Binaerzahl s
	 * @param s
	 */
	public void setBinary(String s) {
		int i = s.length()-1;
		int exp = 0;
		int tmp = 0;
		
		while(i >= 0) {
			if(s.charAt(i) == '1') {
				tmp += (int)Math.pow(2, exp);
			}			
			exp++;
			i--;
		}
		
		this.value = tmp;
	}

	/*
	 * gibt den aktuellen wert von value aus
	 * @return ""+value
	 */
	
	public String getDecimal() {
		return ""+value;
	}

	/*
	 * rechnet value in eine Hex-Zahl um
	 * @return res
	 */
	public String getHexadecimal() {

		String res = ""; //erzeugt leeren String
		StringBuilder tmp = new StringBuilder();
		tmp.append(getBinary()); //erzeugt einen bit-String aus value
		switch (tmp.length() % 4) { // haengt Nullen vornr an, um 4-Bit-Bloecke zu vervollstaendigen
		case 0:
			break;
		case 1:
			tmp.insert(0, "000");
			break;
		case 2:
			tmp.insert(0, "00");
			break;
		case 3:
			tmp.insert(0, "0");
			break;
		}
		for (int i = 0; i < tmp.length() / 4; i++) {
			switch (tmp.substring(i * 4, (i + 1) * 4)) { //vier Bit-Bloecke werden der Reihe Nach aus tmp ausgelesen und abgeglichen. res wird um den entsprechenden Hex-Wert ergaenzt
			case "0000":
				res += 0;
				break;
			case "0001":
				res += 1;
				break;
			case "0010":
				res += 2;
				break;
			case "0011":
				res += 3;
				break;
			case "0100":
				res += 4;
				break;
			case "0101":
				res += 5;
				break;
			case "0110":
				res += 6;
				break;
			case "0111":
				res += 7;
				break;
			case "1000":
				res += 8;
				break;
			case "1001":
				res += 9;
				break;
			case "1010":
				res += "A";
				break;
			case "1011":
				res += "B";
				break;
			case "1100":
				res += "C";
				break;
			case "1101":
				res += "D";
				break;
			case "1110":
				res += "E";
				break;
			case "1111":
				res += "F";
				break;
			}

		}
		return res; //String mit allen Hex-Werten wird zurueckgegeben
	}

	/**
	 * Gibt den aktuellen Wert als Binaerdarstellung zurueck
	 * @return ergebnis
	 */
	public String getBinary() {
		String ergebnis = "";
		int temp = this.value;
		do {
			ergebnis = (temp % 2) + ergebnis;
			temp = temp / 2;
		} while (temp != 0);
		return ergebnis; 
	}

	/*
	 * private rekursive Methode zur Umrechnung von Integer in einen Binary-String. uebernommen aus Praesenzaufgabe 04
	 * nutzt den euklidischen Algorithmus.
	 * und fuegt rueckwaerts die Werte an den String an, um direkt die richtige Reihenfolge zu erlangen. 
	 */
//	private String intToBin(int pZahl) {
//		String l = ""; 
//		int bin = pZahl % 2; 
//		int zahl = pZahl / 2;
//		if (zahl != 0)
//			l += (intToBin(zahl));
//		l += bin;
//		return l;
//	}

}
