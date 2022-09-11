# FragmentLifecycleApp
<img  height="400" width="250" src="https://raw.githubusercontent.com/busealkan/PatikaFMSS/main/buse_alkan_odev3/buse_alkan_odev3_lifecycle/screens/lifecycle.gif"/>

# Log Outputs
<img  height="400" width="250" src="https://raw.githubusercontent.com/busealkan/PatikaFMSS/main/buse_alkan_odev3/buse_alkan_odev3_lifecycle/screens/lifecycleLog.png"/>

# Fragment
<p>Fragment, Activity üzerinde çalışan bir yapıdır. Bir sayfa üzerinde birden fazla ekran görüntülenecek ise Fragmentlar tercih edilmektedir.
<br/>
<h3>Fragment Lifecycle</h3>
<img  height="400" width="250" src="https://raw.githubusercontent.com/busealkan/PatikaFMSS/main/buse_alkan_odev3/buse_alkan_odev3_lifecycle/screens/fragment-view-lifecycle.png"/>
<li><b>onAttach():</b>İlk olarak onCreate () metotundan önce çağırılarak Fragment’in bir Activity’e eklendiğini bildirir.</li>
  
<li><b>onCreate():</b>Sistem Fragment yaratıldığında bu metotu çağırır. Tüm özellikleri ekleyerek Fragment'i başlatır.</li>
  
<li><b>onCreateView():</b>Fragment’ın kullanıcı arayüzünü ilk kez çizmek için bu metot çalışır.</li>
  
<li><b>onViewCreated():</b>Bu metot, onCreateView () öğesinden sonra çağrılır. Fragment sonrası 
oluşan view burada kullanılır.
</li>
  
<li><b>onViewStateRestored():</b>Fragment, görünüm hiyerarşisinin tüm kaydedilmiş durumunun geri yüklendiğini söyler.</li>
  
<li><b>onStart():</b>Fragment görünür olduğunda çağrılır.</li>
  
<li><b>onResume():</b>Fragment'in kullanıcıyla etkileşime geçtiği metottur.</li>
  
<li><b>onPause():</b>Fragment'in kullanıcıyla etkileşimi sonlandığında çağrılan metottur.</li>
  
<li><b>onStop():</b>Fragment tamamen kapatıldığında çağırılır.</li>
  
<li><b>onSaveInstanceState():</b>Fragment UI durumunu sürdürmek için bundle ile veri iletimini kullanır.</li>
   
<li><b>onDestroyView():</b>Fragment'in ara yüzüne eşlik eden kaynakların temizlenmesine izin verir.</li>

<li><b>onDestroy():</b>Fragment durumunun son temizliğini yapmak için çağırılır.</li>
  
<li><b>onDetach():</b>Fragment bulunduğu Activity'den ayrıldığında çağrılır.</li>
<br/><br/>
<p><b>Telefonun yönünün değiştirilmesi durumunda değerler tasarım aşamasında verilen değere geri dönüyor. Nedeni Android‘in kullanıcıdan alınan değerleri tutup performansa olumsuz etkisi olmaması için statik değer olduğu farzedilen değerleri hafızaya almamasıdır. Bu sorunu çözmenin bazı yolları;</b></p>

<li>AndroidManifest.xml dosyasında kullanılan Activity'e android:configChanges="orientation|screenSize|keyboardHidden" kod bloğunu eklemektir. Fakat önerilen bir çözüm yolu değildir.</li>

<li>Telefonun yönü değiştiğinde sırası ile onSaveInstanceState ve onRestoreInstanceState olayları tetikleniyor.</li>

<br/><br/>
<li><b>onSaveInstanceState</b> metodu uygulamanın ekran rotasyonu değiştirildiğinde veya home butonuna basıldığında saklanmasını istediğimiz verileri key/value şeklinde outState içerisinde saklamamızı sağlar.</li>

```
override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.v("BuseAlkan", "onSaveInstanceState called.")

        val nameText = fragmentHomeBinding.txtName.text.toString()
        outState.putString("name", nameText)
    }
```
 
<li><b>onRestoreInstanceState</b> metodu içinde de onSaveInstanceState metodunda kaydedilen değerler alınarak ilgili kontrollere atanır.</li>
 
```
 override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        Log.v("BuseAlkan", "onViewStateRestored called.")

        savedInstanceState?.let{
            val getName = savedInstanceState.getString("name")
            fragmentHomeBinding.txtName.setText(getName)
        }
    }
```

# Libraries and Tools 
<li><a href="https://developer.android.com/guide/fragments">Fragments</a></li> 
<li><a href="https://developer.android.com/guide/fragments/lifecycle">Fragment Lifecycle</a></li>
<li><a href="https://developer.android.com/guide/fragments/saving-state">Saving state with fragments </a></li>

  
# License
Copyright 2022 Buse ALKAN..

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
