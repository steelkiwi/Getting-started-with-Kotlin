 ## ДОПОЛНЯЕТСЯ

# Getting started with Kotlin, Glide, Dagger 2, Retrofit 2, Realm, MVP and RxJava on Android

### Разработчики, хорошо знают, что в мировом IT-сообществе уже долгое время пытаются найти достойную замену языку Java. До 2011 года самым подходящим кандидатом можно было считать Scala, пока не было анонсировано создание Kotlin. Исходный код Kotlin открыли в 2012 году, а в 2016 состоялся официальный релиз версии 1.0.
### Kotlin появился в качестве ответа громоздкому коду Java и медленной скорости компиляции Scala. Сегодня многие известные IT-компании используют его в своих проектах. Внимание к языку продолжает расти, подкупает его синтаксис и поддержка в IDE. Даже Jake Wharton, признанный евангелист Android, применяет Kotlin в своих проектах и тем самым привлекает Android-сообщество к использованию этого языка.
### Не будем оставаться в стороне и попробуем Kotlin на практике, чтобы оценить его широко обсуждаемые плюсы и минусы, а также узнаем как начать разрабатывать на Kotlin приложения под Android. 
# Что скрывает Kotlin?
### В основном Kotlin хвалят за краткость и безопасность кода, а также за совместимость с java и разностороннее применение. Все его заявленные достоинства перечислить сложно, однако остановимся на самых интересных.
## Сильные стороны Kotlin
* Полностью совместим с Java. Может использовать все известные Java фреймворки и библиотеки, а также отдельные модули в текущих проектах.
* Имеет открытый исходный код, поэтому можно легко найти, обозначить проблему в случае её возникновения и сообщить об этом разработчикам языка.
* Его репозиторий весит мало в отличии от того же Scala, и добавление Kotlin в проект равносильно добавлению саппорт библиотеки от Google.
* Начинается с Java 6, может использовать большую часть Java 7 и некоторые портированные элементы Java 8, поэтому легко доступен, даже если вам проблематично обновиться до новой версии JVM.
* Иммутабельность по умолчанию.
* Higher-Order Functions, т.е. функции которые принимают функции, как параметры.
* Null safety. По умолчанию в Kotlin переменные не могут принимать null, если вы явно их так не обозначите.

### Если с плюсами Kotlin всё довольно прозрачно, то минусы не сразу так очевидны, но они есть.

## Слабые стороны Kotlin
* Kotlin ориентирован на байткод Java 6 и не использует ряд улучшений, доступных в Java 8, например, invoke-dynamic.
* Проблемы с annotation processing.
* Отсутствуют аналоги плагинов-макросов или компиляторов, что ограничивает использование удобных макросов из Scala или плагинов наподобие Checker Framework из Java.
* При использовании Java и Kotlin совместно нужно соблюдать определённые правила совместимости.
* Некоторые состоявшиеся, проверенные решения в Android, в том числе и архитектурные, потребуется переписать из-за того, что в Kotlin можно использовать альтернативный подход.
* Язык довольно молодой и не нашёл себя в какой-то конкретной нише, хотя хорошо подходит как для Android разработки, так и для серверной.
* Из-за молодости языка нет каких-то выведенных best practices для решения конкретных задач.

## Остановимся на совместимости и рассмотрим пример разработки простого приложения, которое использует такие популярные библиотеки как: 
* [Glide](https://github.com/bumptech/glide)
* [Dagger 2](https://github.com/google/dagger)
* [Retrofit 2](https://github.com/square/retrofit)
* [Realm database.](https://realm.io/)
* [RxJava + RxAndroid](https://github.com/ReactiveX/RxAndroid)

## Приложение построено по архитектуре MVP и  является хорошим примером использования данных библиотек и архитектуры.

## Приступим к разработке
## Начать разрабатывать на Кotlin довольно легко. Для начала нужно установить плагин.

## Далее сконфигурируйте проект. Самым простым способом будет:  нажать Ctrl+Shift+K и найти пункт Configure Kotlin in Project, который появится в автокомплите. 

## Чтобы конвертировать существующие java-классы в Kotlin ищем команду Convert Java to Kotlin

## Теперь начнем интегрировать нужные нам библиотеки:

## Для интеграции библиотек  добавим следующие строки в build.gradle
```groovy
kapt {
    generateStubs = true
}
buildscript {
   ext.supportVersion = '25.0.0'
   ext.daggerVersion = '2.7'
   ext.retrofitVersion = '2.1.0'
   ext.rxVersion = '1.2.1'
   repositories {
       mavenCentral()
       jcenter()
   }
   dependencies {
       classpath "io.realm:realm-gradle-plugin:2.1.1"
   }
}


dependencies {
   compile fileTree(dir: 'libs', include: ['*.jar'])
   androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
       exclude group: 'com.android.support', module: 'support-annotations'
   })
   compile 'com.android.support:appcompat-v7:25.0.0'
   testCompile 'junit:junit:4.12'
   compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
   compile "com.android.support:cardview-v7:${supportVersion}"
   compile "com.android.support:design:${supportVersion}"


   // Dagger 2
   compile "com.google.dagger:dagger:${daggerVersion}"
   kapt "com.google.dagger:dagger-compiler:${daggerVersion}"
   provided "org.glassfish:javax.annotation:3.1.1"


   //Retrofit 2
   compile "com.squareup.retrofit2:retrofit:${retrofitVersion}"
   compile "com.squareup.retrofit2:adapter-rxjava:${retrofitVersion}"
   compile "com.squareup.retrofit2:converter-gson:${retrofitVersion}"


   compile 'com.google.code.gson:gson:2.8.0'


   compile "io.reactivex:rxjava:${rxVersion}"
   compile "io.reactivex:rxandroid:${rxVersion}"


   compile 'com.github.bumptech.glide:glide:3.7.0'


 }
```

## Создадим класс наследуемый от Application и сконфигурируем в нем Realm и граф для Dagger
```kotlin
class AppDelegate : Application() {


   var injector: AppInjector? = null


   @Singleton
   @Component(modules = arrayOf(NewsModule::class))
   interface AppInjector {
      
       fun inject(activity: MainActivity)
      
   }


   override fun onCreate() {
       super.onCreate()
       injector = DaggerAppDelegate_AppInjector.builder().build()


       Realm.init(this)
       val config = RealmConfiguration.Builder().build()
       Realm.setDefaultConfiguration(config)
   }
}
```
## Для работы с HTTP используем Retrofit. Создадим для этого интерфейс с одним методом, который будет получать список новостей 

```kotlin
interface NewsApiInterface {
   @GET("/feeds/newsdefaultfeeds.cms?feedtype=sjson")
   fun getNews(): Observable<NewsResponse>
}
```

## Создадим класс NewsModule, в котором будут создаваться инъекцируемые (inject) объекты

```kotlin
@Module
class NewsModule {


   @Provides
   @Singleton
   fun provideNewsPresenter(): NewsPresenter {
       return NewsPresenter()
   }


   @Provides
   @Singleton
   internal fun provideNewApiInterface(): NewsApiInterface {
       val retrofit = Retrofit.Builder()
               .baseUrl(Constants.NEWS_ENDPOINT)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
               .build()
       return retrofit.create(NewsApiInterface::class.java)
   }
}
```

## В классе NewPresenter мы будем использовать RxAndroid и Realm для получения списка новостей его фильтрации и кеширования.

```kotlin
subscription = mNewsApiInterface!!
       .getNews()
       .map { it.newsItem }
       .flatMap({ items ->
           Realm.getDefaultInstance().executeTransaction({ realm ->
               realm.delete(NewsItem::class.java)
               realm.insert(items)
           })
           Observable.just(items)
       })
       .onErrorResumeNext { throwable ->
           val realm = Realm.getDefaultInstance()
           val items = realm.where(NewsItem::class.java).findAll()
           Observable.just(realm.copyFromRealm(items))
       }
       .observeOn(AndroidSchedulers.mainThread())
       .doOnTerminate { mNewsView?.hideLoading() }
       .subscribe({ mNewsView?.onNewsItemLoaded(it) }, { mNewsView?.onError(it) })
```

##  Исходный код проекта доступен внутри этого репозитория =)

# Вывод
## Kotlin современный, safety язык программирования, который упрощает создание андроид-приложения. Он выглядит доступной альтернативой Java с хорошей документацией и достаточно простым для понимания содержанием. Надеемся, что данная статья помогла Вам разобраться с созданием проекта на Kotlin и интеграцией в него данных библиотек. 
