
### Готовим MVVM с индусом на ютубе

* Шаг 1. Создайте папку ViewModel
* Шаг 2. Импортируйте библиотеки 

```kotlin
	implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")  
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
```

* Шаг 3. Получить ViewModel от ViewModelProvider 

```kotlin
mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
```

* Шаг 4. Для общения между ViewModel и View используем liveData, например 

```kotlin
class MainViewModel :ViewModel() {  
  
	val liveData = MutableLiveData<String>()  
	  
	init {  
		startTimer()  
	}  
	  
	fun startTimer() {  
		object :CountDownTimer(20000, 1000) {  
			override fun onFinish() {  
			}  
			  
			override fun onTick(millisUntilFinished: Long) {  
				liveData.value = (millisUntilFinished/1000).toString()  
			}  
		}.start()  
	}  
}
```

или если нужен context, то так бахаем 

```kotlin
class MainViewModel(application: Application) :AndroidViewModel(application) {  
  
	val liveData = MutableLiveData<String>()  
	  
	init {  
		startTimer()  
	}  
	
	fun startTimer() {  
		object :CountDownTimer(20000, 1000) {  
			override fun onFinish() {  
				Toast.makeText(getApplication(), "hello", Toast.LENGTH_LONG).show()  
			}  
			  
			override fun onTick(millisUntilFinished: Long) {  
				liveData.value = (millisUntilFinished/1000).toString()  
			}  
		}.start()  
	}  
}
```

* Шаг 5. Создаем в Activity наблюдателя для реактивного отображения значений из ViewModel

```kotlin
override fun onStart() {  
	super.onStart()  
	mViewModel.liveData.observe(this, Observer {  
		textView.text = it  
	})
```

Важно помнить, что MainActivity не знает что происходит в ViewModel
Мы запрашиваем у ViewModelProvider нашу ViewModel мы ее не создаем

* Шаг 5. Бахнем фабрику потому что панки. 
Фабрика нужна чтобы передавать параметры в ViewModel

Бахнем класс MainFactory

```kotlin
class MainFactory(val application: Application, val text: String)  
: ViewModelProvider.AndroidViewModelFactory(application) {  

	override fun <T : ViewModel> create(modelClass: Class<T>): T {  
		return MainViewModel(application, text) as T  
	}  

}
```

Тогда в MainActivity используем нашу фабрику 

```kotlin
mViewModel = ViewModelProvider(this, MainFactory(application, "amogus")).get(MainViewModel::class.java)
```
