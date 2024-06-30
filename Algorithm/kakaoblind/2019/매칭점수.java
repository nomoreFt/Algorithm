package Programmers.kakaoblind_2019;

public class ¸ÅÄªÁ¡¼ö {
	public static void main(String[] args) {
		String s = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta property=\"og:url\" content=\"https://a.com\"/>\r\n" + 
				"</head>  \r\n" + 
				"<body>\r\n" + 
				"Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \r\n" + 
				"<a href=\"https://b.com\"> Link to b </a>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		int mid = 0, posl = 0, posr = 0;
		while(mid <= posl) {
			posl = s.indexOf("<meta", posl +1);
			posr = s.indexOf(">", posl);
			String tes2 = s.substring(posl,posr);
			mid = s.lastIndexOf("https://",posr);
			if(mid > 0) { 
				s.substring(mid);
			}
		}
	}
}
