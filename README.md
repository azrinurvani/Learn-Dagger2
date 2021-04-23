# Learn-Dagger2
Learn Dagger2 using MVVM and Navigation Component

# Step
1. Tambahkan Depedency 
2. Buat BaseApplication extends dari DaggerApplication
3. Tambahkan atribut .name di manifest dengan nilai BaseApplication
4. Buat Interface AppComponent untuk Builder dari Component untuk mendaftarkan seluruh module yang ada
5. Buat method builder() dengan annotaion @Component.Builder untuk builder dari AppComponent yang ada di BaseApplication, kemudian Rebuild
6. Buat class abstract ActivityBuildersModule untuk sebagai module dari Activity yang ada di app.
7. Buat class baru dengan nama AppModule dan berikan annotation @Module untuk membuat daftar depedency yang akan digunakan pada scope app.
8. Hapus dummy depedency yang ada di AppModule, begitupun @Inject pada AuthActivity
9. Copy paste design layout activity_auth.xml
10. Buat method dengan annotaion @Provides yang bernama provideRequestOptions() dengan nilai return RequestOptions di AppModule
11. Buat method dengan annotaion @Provides yang bernama provideGlideInstance dengan nilai return RequestManager yang memiliki parameter application dan requestOptions di AppModule
12. Buat method (depedency) dengan annotation @Provides yang bernama provideAppDrawable dengan return Drawable (untuk set Image pada Glide berupa logo)
13. Buat package ui dan viewmodels
14. Pindahkan AuthActivity pada UI
15. Tambahkan annotaion @Singleton pada AppComponent dan pada setiap depedency (method yang ada di @Module -> AppModule)
16. Buat class baru dengan nama ViewModelProviderFactory di package viemodels
17. Copy and paste Code dari ViewModelProviderFactory dari GIT
18. Pada package di buat class baru dengan nama ViewModelFactoryModule untuk binds ViewModelProviderFactory
19. Pada package UI buat class baru dengan nama AuthViewModel dan @Inject constructor dari AuthViewModel tersebut (proses inject bisa dilakukan apabila sudah disediakan depedency dari object tersebut)
20. Buat key atau annotation class dengan nama ViewModelKey untuk Binding Map ViewModel
21. Pada package di buat package baru dengan nama auth, dan buat class baru dengan nama AuthViewModelsModule untuk binding ViewModel dari AuthViewModel menggunakan Map (ViewModelKey)
22. Daftarkan module dari AuthViewModelsModule pada contributeAuthActivity yang ada di class AcitivtyBuildersModule (disini sudah menyinggung konsep Sub Component) 
23. Inject ViewModelProviderFactory pada AuthActivity
24. Buat variable untuk AuthViewModel dan inisialisasi dengan menggunakan ViewModelProviderFactory
25. Buat log debug untuk testing apakah AuthViewModel berjalan di constructor AuthViewModel
26. Run app
27. Buat new package dengan nama Util, dan Buat class baru dengan nama Constants yang berisi constants BASE_URL
28. Pada AppModule buat depedency untuk instance retrofit dengan nama provideRetrofitInstance
29. Pada package di buat package baru dengan nama network dan buat class interface dengan nama AuthApi untuk end point dari Auth
30. Pada package di/auth buat class baru (module baru) dengan nama AuthModule dan buat depedency untuk create Api Service dari Auth dengan nama provideAuthApi dengan return AuthApi --> retrofit.create(AuthApi.class)
31. Tambahkan module AuthModule pada contributeAuthActivity di ActivityBuildersModule class
32. Inject AuthApi pada contructor AuthViewModel dan buat log debug untuk testing apakah AuthApi berhasil di inject
33. Run app
34. Buat DTO atau model class dengan nama User, sesuaikan dengan response
35. Tambahkan callAdapter pada method provideInstanceRetrofit di AppModule dengan parameter RxJavaCallAdapterFactory.create()
36. Buat method getUser pada AuthApi dengan return Flowable
37. Remove log debug pada constructor AuthViewModel dan ganti dengan memanggil method getUser pada AuthApi
38. Pada onNext() method berarti data berhasil diterima, buat log debug untuk testing
39. Tambahkan Internet permission pada AndroidManifest.xml
40. Run App
