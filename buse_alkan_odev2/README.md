# UiDesignApp
<p align="center">Mobile Ui Design</p>

# Outputs
<img height="400" width="210" src="https://github.com/busealkan/buse_alkan_odev2/blob/master/screens/uiDesign.mp4" alt="SS1"/>


# Eager ve Lazy Filters
## Eager Filters
<p>Eager filter ihtiyaç anından önce oluşturulurak gerektiğinde gerçekleşir.</p>

<li>Anlamak ve hata ayıklamak daha kolaydır. Ayrıca tek bir kullanım durumu için yüksek oranda optimize edilebilirler (örn filter. )</li>


```
val instruments = listOf("viola", "cello", "violin")
val eager = instruments.filter { it [0] == 'v' }
println("eager: " + eager)
```

⇒ eager: [viola, violin]


## Lazy Filters
<p>Lazy filter, ihtiyaç duyulan ana kadar gerçekleşmez sadece çalışma zamanında gerekirse gerçekleşir</p>

<li>Daha az hesaplama ile sonuçlanır ve hesaplamada birden fazla adım varsa (örneğin filter, map, reduce), daha az geçici veri oluşturulur.</li>

```
val instruments = listOf("viola", "cello", "violin")
val filtered = instruments.asSequence().filter { it[0] == 'v'}
println("filtered: " + filtered.toList())
```
⇒ filtered: [viola, violin]


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

