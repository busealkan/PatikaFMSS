# Parcelable ve Serializable
<p>Android’de Acivityler arası veri taşınırken genellikle Intent/Bundle yapısı kullanılır. Bu yapı daha çok String, Integer gibi verileri göndermek için kullanılır. Object göndermek için ise 2 yöntem bulunuyor. Bu yöntemlerden biri Serializable diğeri Parcelable'dır.</p><br/>
<p>Bu yöntemler ile referans tiplerini parçalayıp bir hizaya getiriyoruz daha sonra Intent yapısının içerisine koyup diğer Activity'e taşıyoruz.

<b>Serializable: </b>Classdan oluşturulmuş nesnenin Stringe çevrilmesine Serializable denir. Tam tersi duruma ise deSerializable denir. Yani String bir ifadenin tekrar nesneye dönüştürülmesi işlemidir.<br/>

<b>Parcelable: </b>Parcelable Android için Google mühendisleri tarafından sayfalar arası daha hızlı veri transferi yapabilmek için geliştirilmiştir. Parcelable Interface performansıyla Serializable'a göre üstünlük sağlıyor. Google mühendislerine göre Parcelable hız konusunda oldukça iyi seviyede. Yani veri transferini hızlı bir şekilde gerçekleştirebiliyor.

<br/>
<b>Parcelable ve Serializable Arasındaki Bazı Farklar</b>
<li>Parcelable, Serializable’a göre 10 kat daha hızlıdır.</li>
<li>Serializable arabiriminin uygulanması, Parcelable arabiriminin uygulanmasına göre daha kolaydır.</li>
<li>Serializable arayüzü birçok geçici nesne yaratır ve bir miktar çöp toplanmasına neden olur.</li>
<li>Serializable standart bir Java Interface’idir. Parcelable Android SDK'nın bir parçasıdır.</li>
<li>Serializable mobil, masaüstü gibi bir çok ortamda kullanılabilir. üParcelable sadece Android için geliştirilmiştir.</li>
</p>


<br/>
<b>Parcelable ve Serializable Performans Testi</b><br>  
<img src="https://raw.githubusercontent.com/FMSSBilisimAndroid/buse_alkan_odev3/main/parcelableSerializablePerformansTesti.png" alt="SS1"/>
