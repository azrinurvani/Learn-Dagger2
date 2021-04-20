# Learn-Dagger2
Learn Dagger2 using MVVM and Navigation Component

# Step
1. Tambahkan Depedency 
2. Buat BaseApplication extends dari DaggerApplication
3. Tambahkan atribut .name di manifest dengan nilai BaseApplication
4. Buat Interface AppComponent untuk Builder dari Component untuk mendaftarkan seluruh module yang ada
5. Buat method builder() dengan annotaion @Component.Builder untuk builder dari AppComponent yang ada di BaseApplication, kemudian Rebuild
6. Buat class abstract ActivityBuildersModule untuk sebagai module dari Activity yang ada di app
