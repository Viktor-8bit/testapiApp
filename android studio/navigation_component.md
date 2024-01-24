3 ключевые части 

1. Navigation graph
2. NavHost по умолчанию NavHostFragment. Пункты назначения. 
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


