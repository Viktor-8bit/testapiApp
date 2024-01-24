
# Создать проект

Выбираем всегда Empty Views Activity
# Переменные в языке Kotlin

**val - что-то вроде константы, объекты дизайна, не можем пере присвоить;
var - пере присваиваем  

**val label = findViewById<*TextView*>(R.id.Mainlabel);

- `val` - ключевое слово в Kotlin для объявления неизменяемой (immutable) переменной. Это означает, что ссылка на `TextView` будет иметь фиксированное значение после присваивания.
- `label` - название переменной, которую ты выбрал. Ты можешь выбрать любое другое имя, которое более подходит для твоего контекста.
- `findViewById<TextView>` - метод, который вызывается для поиска `TextView` элемента в макете активности. В данном случае, он ищет элемент с идентификатором `Mainlabel`.
- `(R.id.Mainlabel)` - это ссылка на идентификатор ресурса `Mainlabel`, который представляет собой уникальное целочисленное значение, присвоенное `TextView` элементу в макете активности. `R` - это класс, автоматически создаваемый системой, чтобы представлять ресурсы, определенные в проекте.

**Можем так делать**

val user_data: Char
val user_data: Int
val user_data: EditText = findViewById(R.id.user_data)

```kotlin
open class Родитель {
    open fun некоторыйМетод() {
        println("Родительский метод")
    }
}

class Дочерний : Родитель() {
    override fun некоторыйМетод() {
        super.некоторыйМетод() // Вызов родительского метода
        println("Дочерний метод")
    }
}

fun main() {
    val объект = Дочерний()
    объект.некоторыйМетод()
}
```

# Код в начале программы

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
}
```

1. `override` - ключевое слово в Kotlin, которое указывает на переопределение метода из родительского класса. В данном случае, мы переопределяем метод `onCreate()` из класса `Activity`.
    
2. `fun` - ключевое слово, которое указывает на объявление функции.
    
3. `onCreate(savedInstanceState: Bundle?)` - название функции `onCreate`, которая принимает один параметр `savedInstanceState` типа `Bundle?`. Параметр `savedInstanceState` содержит информацию, которая была сохранена в предыдущем состоянии активити (например, при перезапуске приложения).
	Когда активити уничтожается и пересоздается, например, при повороте экрана, метод `onSaveInstanceState()` вызывается, и ты можешь сохранить нужные данные в объекте `Bundle`, который будет передан в метод `onCreate()` или `onRestoreInstanceState()` при восстановлении активити.
	В методе `onCreate()` или `onRestoreInstanceState()`, ты можешь проверить, есть ли данные в `savedInstanceState`, и если они есть, восстановить их.

	Вот пример, как можно использовать `savedInstanceState` для сохранения и восстановления данных формы:
	
	```java
	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    // Сохранение данных формы в Bundle
	    String name = editTextName.getText().toString();
	    outState.putString("name", name);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    super.onRestoreInstanceState(savedInstanceState);
	    // Восстановление данных формы из Bundle
	    String name = savedInstanceState.getString("name");
	    editTextName.setText(name);
	}
	```
	Таким образом, ты можешь сохранить данные формы в `savedInstanceState` и восстановить их при возвращении на активити.

1. `super.onCreate(savedInstanceState)` - вызов метода `onCreate()` из родительского класса (в данном случае, класса `Activity`). Этот вызов гарантирует выполнение базовой реализации метода в родительском классе.
    
5. `setContentView(R.layout.activity_main)` - метод, который устанавливает макет (layout) для активити. Здесь используется макет `activity_main`, который определен в ресурсах проекта.
    

Обычно метод `onCreate()` используется для инициализации активити и установки начального состояния. В данном примере, метод `onCreate()` вызывает базовую реализацию из родительского класса, а затем устанавливает макет `activity_main`.

# Бинд кнопки
```kotlin
	button.setOnClickListener {  
		var text = userData.text.toString().trim()  
			if(text == "toast")  
				Toast.makeText(this, "User enter toast", Toast.LENGTH_SHORT).show();  
			else  {  
				label.text = text;  
			}  
	}
	trim() - убирает пробелы после и до текста
	```
	

# Список элементов
```kotlin
	val taskList: ListView = findViewById(R.id.listView);  
	val todos: MutableList<String> = mutableListOf();
	MutableList<String> - создает лист из строк
	// контекст (this типа тута), затем дизайн и массив на основе чего будет создан ListView  
	val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, todos);
	adapter.insert(text, 0) - добавит элемент в начало списка
```
**Удаление из списка**
```kotlin
	taskList.setOnItemClickListener { adapterView, view, i, l ->  
		val text = taskList.getItemAtPosition(i).toString()  
		adapter.remove(text)  
		Toast.makeText(this, "Мы удалили $text", Toast.LENGTH_LONG).show()  
	}
```
**КЛАССЫ В Kotlin**
	Если хотим бахнуть класс в котором только 1 конструктор и он забивает поля класса, то ->
```kotlin
	class User(val login: String, val email: String, val pass: String) {
	}
```
 *(кста можем хранить пользователей в файлах или в бдшке SQLite)* 
 
# Встроенная бдшка SQLite

Cоздаем класс DbHelper
```kotlin
import android.content.ContentValues  
import android.content.Context;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
  
public class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?)  
: SQLiteOpenHelper(context, "app", factory, 1) { // контекст, название бд, версия  
  
// метод создания бдшки  
	override fun onCreate(db: SQLiteDatabase?) {  
		val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)" 
		db!!.execSQL(query);  
	}  
  
// метод пересоздания бдшки  
	override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {  
		db!!.execSQL("DROP TABLE IF EXISTS users")  
		this.onCreate(db)  
	}  
  
	fun addUser(user: User) {  
	
	// объект в мы подставляем значения полученные от пользователя  
		val values = ContentValues()  
		values.put("login", user.login)  
		values.put("email", user.email)  
		values.put("pass", user.pass)  
		val db = this.writableDatabase  
	// имя таблицы потом сдвиг, потом значения, которые добавятся в опр. поля  
		db.insert("users", null, values)  
		db.close()  
	}  
}
```
!! - нужно чтобы работать с var? переменными 

И пропишем разрешение на запись/чтение бдшки 
```xml

<?xml version="1.0" encoding="utf-8"?>  
<manifest xmlns:android="http://schemas.android.com/apk/res/android"  
xmlns:tools="http://schemas.android.com/tools">  
  
<!-- добавляем разрешение пользоваться файлами-->  
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"  
android:maxSdkVersion="32" />
```

Работа с бдшкой SQLite 
```kotlin
buttonReg.setOnClickListener {  
	val login = userLogin.text.toString().trim()  
	val email = userEmail.text.toString().trim()  
	val pass = userPass.text.toString().trim()  
	  
	if(login == "" || email == "" || pass == "")  
		Toast.makeText(this, "Не все заполнил полудурок 🤡", Toast.LENGTH_LONG).show()  
	else {  
		val user = User(login, email, pass)  
		  
		// this - контекст, null - можно передать бдшку  
		val db = DbHelper(this, null)  
		db.addUser(user)  
		Toast.makeText(this, "Пользователь $login добавлен 👍", Toast.LENGTH_LONG).show()  
		  
		userLogin.text.clear()  
		userEmail.text.clear()  
		userPass.text.clear()  
	}  
}
```

# Добавить страницу

`res/layout -> "new" -> "Activity" -> "Empty Activity"`

Бахнем переход на другую страницу 

```kotlin
val linkToReg: TextView = findViewById(R.id.link_to_reg)  
  
linkToReg.setOnClickListener {  
	val intent = Intent(this, MainActivity::class.java)  
	startActivity(intent)  
}
```
_MainActivity_ - класс Kotlin требуемой страницы 

В бдшке есть 

*this.**readableDatabase*** - отсюда читаем
*this.**writableDatabase*** - сюда пишем

```kotlin

fun getUser(login: String, pass: String): Boolean {  
	val db = this.readableDatabase  
	  
	val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)  
	return result.moveToFirst()  
}
```

*: Boolean* - тип данных возвращаемого значения функции 

# Список элементов (тип 2)

Создаем класс для листа 

```kotlin
class Host(val id: Int, val name: String, val status: Boolean) {  
} 

```

Накидываем RecyclerView

В MainActivity.kt или в коде фрема/активити создаем след прикол (фрагмент)

```kotlin
val myview = inflater.inflate(R.layout.fragment_list, container, false)  
  
val ListHosts : RecyclerView = myview.findViewById(R.id.ListHosts)  
  
val items = arrayListOf<Host>()  
  
items.add(Host(1, "AmogusPC", true))  
items.add(Host(2, "DESKTOP-050E4JN", true))  
items.add(Host(3, "WIN-8PJNE1C8M8J", true))
```

Затем создаем для объекта xml представление 
`res -> laout -> new -> Layout Resources File -> name = list_of_hosts`

Заполняем xml представление полями 

Создаем класс адаптер 
```kotlin
// класс аптер, принимает массив элементов и контекст элементов с которыми работаем  
class ItemsAdapter(var items: List<Item>, var context: Context) :  
	RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){  
	  
	// за счет этого класса находим элементы с которыми будем работать внутри нашего дизайна  
	// здесь создаются переменные которые указывают с какими объектами из дизайна мы будем работать  
	class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {  
		val image: ImageView = view.findViewById(R.id.item_list_image)  
		val title: TextView = view.findViewById(R.id.item_list_title)  
		val desc: TextView = view.findViewById(R.id.item_list_desc)  
		val price: TextView = view.findViewById(R.id.item_list_price)  
	}  
	  
	// Создаем параметр view, какой конкретно дизайн обрабатываем  
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {  
		// находим нужный дизайн  
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)  
		// собственный класс в котором мы находим нужные объекты  
		return MyViewHolder(view)  
	}  
		  
	// должен возвращать потсчет количества элементов  
	override fun getItemCount(): Int {  
		return items.count()  
	}  
	  
	// укажем какие данные подставим в поля которые шашли  
	// перебераем все элементы массива по позиции  
	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {  
		holder.title.text = items[position].title  
		holder.desc.text = items[position].desc  
		holder.price.text = items[position].price.toString() + "$"  
		  
		// по названию узнаем id картинки  
		val imageId = context.resources.getIdentifier(  
		items[position].image,  
		"drawable",  
		context.packageName  
		)  
		holder.image.setImageResource(imageId)  
	}  
}
```



# Изображения 

Засовываем их в папку 
`res -> drawable`

imageView - добавить изображение

scaleType: centerCrop - чтобы расположить по центру изображение и обрезать 
layout_height: 200dp

android:layout_height="wrap_content" - wrap_content столько места сколько нужно

# Передача данных между формами

Передача данных
```kotlin
	var intent = Intent(context, ItemActivity::class.java)
	// передача доп данных  
	intent.putExtra("itemTitle", items[position].title)  
	intent.putExtra("itemText", items[position].text)  
	intent.putExtra("imageId", imageId)  
	context.startActivity(intent)
```

Получение данных
```kotlin
	val title: TextView = findViewById(R.id.item_list_title_card)  
	val description: TextView = findViewById(R.id.item_list_text)  
	val buyButton: Button = findViewById(R.id.button_buy)  
	  
	title.text = intent.getStringExtra("itemTitle")  
	description.text = intent.getStringExtra("itemText")
```

# Подключить библиотеку

Переходим в 
`Gradle Scripts -> build.gradle (Module :app)` 

добавляем в __dependencies__

разрешаем работу с интернетом
`<user-permission android:name="android.permission.INTERNET"/>` 


# Таймер 
```kotlin
object : CountDownTimer(20000, 1000) {  
	override fun onFinish() {  
	}  
  
	override fun onTick(millisUntilFinished: Long) {  
		textView.text = (millisUntilFinished / 1000).toString()  
	}  
}.start()
```
# Модификаторы доступа в Kotlin

`lateinit` - это модификатор доступа в Kotlin, который применяется к свойствам класса. 
Он указывает компилятору, что свойство будет инициализировано позднее, после создания экземпляра класса, но до первого использования этого свойства.

Когда вы объявляете свойство с модификатором `lateinit`, вы обязаны сами позаботиться о его инициализации, прежде чем к нему обращаться, иначе возникнет исключение `UninitializedPropertyAccessException`.

список модификаторов доступа в Kotlin:

1. `public` (по умолчанию): Этот модификатор делает члены видимыми для всех. Если не указан модификатор доступа, то `public` используется автоматически.
    
2. `private`: Этот модификатор делает члены видимыми только в пределах того же класса или файла.
    
3. `protected`: Этот модификатор делает члены видимыми в пределах того же класса, подкласса и того же пакета.
    
4. `internal`: Этот модификатор делает члены видимыми в пределах того же модуля. Модуль - это набор файлов Kotlin, скомпилированных вместе.
    
5. `public`, `internal` для модуля: Этот модификатор делает члены видимыми для всех внутри модуля, но невидимыми для клиентов модуля.
    
6. `private`, `protected` в файле: Этот модификатор делает члены видимыми только в пределах файла, в котором они объявлены.
    

Кроме модификаторов доступа, Kotlin также предлагает другие модификаторы, такие как `abstract`, `final`, `open`, `const`, `sealed` и т. д., которые используются для определения поведения классов и членов.