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
