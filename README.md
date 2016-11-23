# Getting started with Kotlin And third-party libraries Glide, Dagger 2, Retrofit 2, Realm, MVP and RxJava on Android
[![License](http://img.shields.io/badge/license-MIT-green.svg?style=flat)]()

It’s not a secret to Android developers all around the globe, that IT community has been trying to find a distinct replacement to Java. Until 2011 before Kotlin creation was announced the most suitable candidate was Scala. Kotlin source code was open in 2012 and in 2016 the 1.0 version was released.

Kotlin has appeared as a response to massive Java code and Scala low-speed compilation. Today many famous IT companies use it in their projects. The attention to this language is continuing to grow, as it wins over the developers with its syntax and that fact that Kotlin supports in IDE by the means of plugin. Even Jake Wharton, recognized Android gospeller, uses Kotlin in the projects of his own thus acquiring Android community towards practical usage of this language.

Let’s not leave ourselves behind and try Kotlin on practice to weigh its extensively discussed pros and cons. And also we will learn how to start development of Android applications on Kotlin. 

## What does Kotlin hide?
### Mostly Kotlin is commended for its briefness and code safety and also for compatibility with Java and flexile usage. It’s hard to list all its announced advantages, so let’s view the most interesting ones.
## Strong sides of Kotlin:
* Fully [compatible with Java] (https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/model/NewsResponse.java#L12). It can use all available Java frameworks, libraries and also with separate modules in current projects.
* Has [open source code](https://kotlinlang.org/), so it’s easy to track and determine an issue and if you come up with it, you can always submit it to Kotlin developers.
* Kotlins repository consumes less space than Scala, and adding Kotkin to a project is equal to Google library.
* Starting from Java 6, it can use the major part of Java 7 and some portable elements of Java 8. That’s why it is easily available even if you are facing troubles updating to new JVM version.
* Immutability by default.
* Higher-Order Functions, i.e. the functions that take functions as parameters.
* Null safety. Variables in Kotlin can’t possess the null value by default unless you denote them.

### If the Kotlin advantages are clear, it has disadvantages as well, even though they are not so obvious.

## Weak sides of Kotlin:
* Kotlin is oriented on Java 6 bytecode and doesn’t use a number of improvements available in Java 8 like invoke-dynamic.
* Issues with annotation processing.
* There are no analogues to plugin-macros or compilers which limits the usage of convenient Scala macros or plugins like Checker Framework from Java. 
* If you practice joint usage of Java and Kotlin you need to follow certain rules of compatibility.
* You will have to rewrite some proven to be effective solutions for Android, including the architectural ones because of the fact that Kotlin enables the usage of alternative approach.
* The language is pretty young and hasn’t found any specific niche, however, it is suitable not only for Android but also for Backend development.
* The language is pretty green and there are no worked out best practices for solving particular tasks.

## Let’s stop on compatibility and examine the example of a simple application development with usage of such popular libraries like:
* [Glide](https://github.com/bumptech/glide)
* [Dagger 2](https://github.com/google/dagger)
* [Retrofit 2](https://github.com/square/retrofit)
* [Realm database.](https://realm.io/)
* [RxJava + RxAndroid](https://github.com/ReactiveX/RxAndroid)

## The app serves as a good instance of  libraries data usage and implementation of MVP architecture:
![Screenshot](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/assets/screen4.jpg)
## Let’s proceed to development
## It’s pretty easy to start the development process with Kotlin. First of all, you need to install the plugin:
![Screenshot](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/assets/screen1.png)
## After that configure your project. The easiest way to do this is to press Ctrl+Shift+A and find Configure Kotlin in Project item that will appear in autocomplete:
![Screenshot](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/assets/screen2.png)
## To convert existing Java classes to Kotlin you need to find the command named Convert Java to Kotlin:
![Screenshot](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/assets/screen3.png)
## Now let's start the integration of the needed libraries
## A few words before start. Some libraries like Dagger 2 require Annotation Processing. Java Annotation Processing is not suitable for Kotlin. That’s why it includes its own Annotation Processing Tool for Kotlin (kapt), here is a great opinion on it.

## To activate it you need to add this in the [build.gradle](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/build.gradle#L26) file:
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

## Then we create [inheriting class](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/shared/AppDelegate.kt#L10) from Application and configure Realm and dependencies graph for Dagger 2 developed by Google:
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
## To work with HTTP we use Retrofit. We need to create an [interface](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/shared/NewsApiInterface.kt#L8) with one method that will receive news feed:

```kotlin
interface NewsApiInterface {
   @GET("/feeds/newsdefaultfeeds.cms?feedtype=sjson")
   fun getNews(): Observable<NewsResponse>
}
```

## We create [NewsModule class](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/shared/NewsModule.kt#L18) wherein the injected objectives will be created:

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

## In [NewPresenter](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/presenter/NewsPresenter.kt#L16) class we will use RxAndroid and Realm for [news feed processing and caching](https://github.com/steelkiwi/Getting-started-with-Kotlin/blob/master/app/src/main/java/com/ktoi/toi/presenter/NewsPresenter.kt#L32) :

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

Projects source code is available on this Repository =)

## Let’s sum up
 All in all, Kotlin is a modern and secure programming language that simplifies Android apps development. It looks like a distinct alternative to Java as it has good documentation and is simple enough for understanding. We hope that this article helped you to figure out how to create a project on Kotlin and integrate the needed libraries.
 
 
## License

	The MIT License (MIT)
	
	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.
