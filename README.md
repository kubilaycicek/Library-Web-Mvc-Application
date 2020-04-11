# Spring Mvc & Thymleaf Kütüphane Uygulaması
Spring Framework ile geliştirilmiş Kütüphane uygulaması.
Kitap Yazar ve Yayınevi ile ilgili Temel CRUD işlemleri gerçekleştiriliyor.

## Kullanıcı Bilgileri
 * Admin  User   : kubilaycicek Password : 1234
 * Normal User   : normaluser   Password : 1234
  
## Kullanılan Teknolojiler
* Spring Boot 
* Spring Mvc
* Spring Security
* Thymleaf
* H2 Database 
* JPA, Hibernate
* Lombok 
* Model Mapper 
* JUnit
* Swagger

## Paketler
* Bootstrap : Uygulama çalışırken ilk ayarlar burada gerçekleştirildi.
* Configuration : Security, Swagger , ModelMapper ayarları ve bean'lar burada tanımlandı.
* Constant   : Uygulama ile ilgili URL tanımlarını Mappings sınıfında static final olarak tanımlandı.
* Controller : Spring Mvc Controller Sınıfları
* Converter  : Data Transfer objelerini Pojo'ya Pojo objelerinin Data Transfer Objelerine dönüştürüldüğü paket.
* Dto        : Data Transler objeleri
* Entity     : Database entity objeleri
* Repository : JpaRepository'nin implementasyonlarının gerçekleştiği paket.
* Service    : Servis Katmanı İşlemlerin gerçekleştirildiği paket.
* Api        : Rest API paketi.
