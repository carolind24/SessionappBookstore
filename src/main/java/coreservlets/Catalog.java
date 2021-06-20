package coreservlets;

public class Catalog {
	private static CatalogItem[] items =
		{ new CatalogItem
			("tech001",
			 "<i>Bilgisayar Mühendisligine Giris - Rifat Colkesen </i>" ,
			 "Bu kitap, Bilgisayar Muhendisligi, Bilgisayar Bilimleri, Endustri Muhendisligi, Elektrik Elektronik Muhendisligi Bolumleri icin bilgisayar muhendisligi konulari hakkinda referans niteligindedir. " +
			 "Ayni zamanda, Bilgisayar Muhendisligi kavramlarina ve konularina hakim olmak, temel bilgilerini belirli referansa oturtmak isteyen meslek yüksek okullarinin ilgili bölümleri icin de bir basvuru kaynagidir. \n" ,
			 39.95),
		  new CatalogItem
		  	("tech002",
		     "<i>Eclipse ile Java</i>",
			 "Eclipse ve Java teknolojilerine genel bakis ile baslayan bu kitap ve Java programlama dili temelleri ve Object-Oriented programlama kavramlari ile devam etmektedir. " +
			 "Kullanici, dilin genel yapisini kavradiktan sonra Java sinif kitapligi (collections, streams), hata ayiklama (debugger, exceptions), JUnit ile birim testlerin yapilmasi, Java ile veritabanina ulasilmasi (JDBC) konulari uzerinde durulmaktadir. ",
		  	 49.99),
		  new CatalogItem
		    ("dede001",
		     "<i>Dede Korkut</i>",
		     "Dede Korkut hikayeleri bir ön söz ve 12 hikayeden olusur. " +
		     "Eser icerisinde olaganustu olaylar gercege uygun bir sekilde aktarilmistir. \n" +
		     "Eser icerisinde Turklerin eski yasam sekilleri anlatilmistir. Ayrica Islam dini ile ilgili ozellikler de bulunmaktadir. ",
		     19.95),
		   new CatalogItem
		     ("hacicavcav001",
		      "<i>Karagoz ile Hacivat</i>",
			  "Karagoz oyunu halkin ortak malidir. Oyunlarda gosterilen konularin kim tarafindan duzenlendigi bilinmez. " +
		      "Zaman icerisinde her Karagoz sanatcisi oyuna bir seyler eklemis, zamanin ihtiyaci ve sartlarina gore konulari islemistir. \n",
		      19.95),
		    new CatalogItem
		      ("yurekdede001",
		      "<i>Dede Korkut</i>",
		 	  "Kitapta dunyaya gelis amacimiz, kulluk, iyi niyetli olmak, saf ve temiz kalpli olmak, kendinden baskasini dusunmek ve deger " +
		 	  "vermek, sahip olunan nimetler, alinan bir nefes icin bile sukretmek, kederde sabretmek, sevincte dertsizlikten dolayi \n" +
		 	  "ozelestiri yaparak Allaha siginmak gibi olgulardan bahsetmektedir. " ,
		 	   59.95),
		};
	
	
	public static CatalogItem getItem(String itemID) {
		
		CatalogItem item;
		if (itemID == null)
			return null;
		
		for(int i=0; i<items.length; i++) {
		
			item = items[i];
			if (itemID.equals(item.getItemID()))
				return item;
		
		} 
		
		return null;
		
	}
	
} 