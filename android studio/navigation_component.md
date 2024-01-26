3 ключевые части 

1. Navigation graph это xml ресурс, содержащий всю связанную с навигацией информацию в одном централизованном месте
2. NavHost пустой контейнер для объектов навигации
3. NavContrroller управляет заменой содержимого на NavHost

#### Способ 1. Используем XML

`Resource Manager -> + -> Navigation Resource File`

Бахаем фрагменты

Стрелочки содержат ID

Прописав этот ID можно переключаться между фрагментами

```kotlin
val view = inflater.inflate(R.layout.fragment_first, container, false)  
  
view.findViewById<TextView>(R.id.textView1).setOnClickListener {  
Navigation.findNavController(view).navigate(R.id.to_second_fragment)  
}  
  
return view
```

Фрагмент обычно выглядит так:

```kotlin
override fun onCreateView(  
	inflater: LayoutInflater, container: ViewGroup?,  
	savedInstanceState: Bundle?  
): View? {  
	val myview = inflater.inflate(R.layout.fragment_list, container, false)
	return myview;
}
```

Для переключения между фрагментами используем NavController, который управляет навигацией приложения в NavHost

Инициируем в MainActivity navController
```kotlin
lateinit var navController: NavController  
override fun onCreate(savedInstanceState: Bundle?) {  
	super.onCreate(savedInstanceState)  
	setContentView(R.layout.activity_main)  
	navController = Navigation.findNavController(this, R.id.nav_host)  
}
```

Код для переходя между фрагментами 

```kotlin
(activity as MainActivity).navController.navigate(R.id.list_to_hostPage)
```

Передача параметров между фреймами

```kotlin
holder.button.setOnClickListener {  
	val bundle: Bundle = Bundle()  
	  
	bundle.putInt("id", items!![position].id)  
	bundle.putString("name", items!![position].name)  
	bundle.putBoolean("status", items!![position].status)  
	  
	activity.navController.navigate(R.id.list_to_hostPage, bundle)  
}
```

Чтение параметров переданных между фреймами

```kotlin
	var id: Int? = arguments?.getInt("id")  
	var name: String? = arguments?.getString("name")  
	var status: Boolean? = arguments?.getBoolean("status")
```

