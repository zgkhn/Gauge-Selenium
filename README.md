# 🚀 Gauge + Selenium Test Otomasyon Projesi

Bu proje, **Gauge** test otomasyon çerçevesi ile **Selenium** kullanarak web tarayıcısında otomatik testler çalıştırmak için bir şablon sunar.

---

## 📌 Kurulum

### 🔹 Şablonu Yükleme

```bash
gauge --install java_maven_selenium
```

---

## 🛠 Özellikler

- **🌍 Web Otomasyonu:** Selenium ile web uygulamalarında otomatik testler çalıştırılır.
- **📝 Spesifikasyon Tabanlı Testler:** Test senaryoları **Gauge**'ın doğal dili destekleyen yapısı ile yazılır.
- **🔄 Modüler Yapı:** Test kodları **Page Object Model (POM)** ile düzenlenmiştir.
- **📊 Test Raporları:** Gauge, test çalıştırmalarının detaylı raporlarını oluşturur.

---

## 🏗 Proje Yapısı

```
├── specs               # Test senaryoları (Specification dosyaları)
├── src/test/java       # Test implementasyonları
│   ├── Pages           # Sayfa nesneleri (POM yapısı)
│   ├── Steps           # Gauge test adımları
│   ├── DriverFactory   # WebDriver yönetimi
│
├── env/default        # Ortam ayarları
└── pom.xml            # Maven bağımlılıkları
```

---

## 🖊 Spesifikasyon Tanımlama

**Örnek Test Senaryosu:**

```gauge
Mizu Test
==========================

Scenario: Hatalı Login Testi
------------------------------
* "singin" elementi üzerinde dur
* "singinlink" elementine tıkla
* "mail" elementine "mail@gmail.com" degerini gir
* "password" elementine "123456789" degerini gir
* "giris" elementine tıkla
* "hata" elementini kontrol et
* "ok" elementine tıkla
```

---

## Testleri Çalıştırma

```bash
gauge run specs
```

### 🎯 Belirli Senaryoyu Çalıştırma

```bash
gauge run specs/login.spec
```

---

---

## 🤝 Katkıda Bulunma

Projeye katkıda bulunmak isterseniz, fork edip pull request gönderebilirsiniz. 🙌

---

## 📄 Lisans

Bu proje **MIT Lisansı** ile lisanslanmıştır.

---

🔗 **GitHub Repo:** [Gauge-Selenium](https://github.com/zgkhn/Gauge-Selenium.git)

