
#### Существует два основных способа внедрения зависимостей в Android:

- **Внедрение конструктора**. Это способ, описанный выше. Вы передаете зависимости класса его конструктору.
    
- **Внедрение поля (или установщика)**. Некоторые классы фреймворка Android, такие как activities и fragments, создаются системой, поэтому внедрение конструктора невозможно. При внедрении полей экземпляры зависимостей создаются после создания класса. Код будет выглядеть следующим образом:

```kotlin
class Car {    
	lateinit var engine: Engine    
	fun start() {        
		engine.start()    
	}  
}
```


В примере была только одна зависимость, но большее количество зависимостей и классов может сделать ручное внедрение зависимостей более утомительным. Ручное внедрение зависимостей также создает несколько проблем:`Car`

- Для больших приложений для извлечения всех зависимостей и их правильного подключения может потребоваться большое количество шаблонного кода. В многоуровневой архитектуре, чтобы создать объект для верхнего уровня, вы должны предоставить все зависимости нижележащих слоев. В качестве конкретного примера, для создания реального автомобиля вам могут понадобиться двигатель, трансмиссия, шасси и другие детали; а двигателю, в свою очередь, нужны цилиндры и свечи зажигания.
    
- Когда вы не можете создавать зависимости перед их передачей — например, при использовании отложенных инициализаций или при привязке объектов к потокам вашего приложения — вам необходимо написать и поддерживать пользовательский контейнер (или график зависимостей), который управляет временем жизни ваших зависимостей в памяти.

#### IoC Inversion of Control

Принцип инверсии управления (Inversion of Control, IoC) - это принцип разработки программного обеспечения, который основывается на переносе ответственности за управление зависимостями между компонентами от самого компонента к внешнему фреймворку или контейнеру. Вместо того чтобы компонент сам создавал или получал свои зависимости, он делегирует эту ответственность контейнеру или фреймворку.

Ключевая идея принципа инверсии управления заключается в следующем: компоненты должны зависеть от абстракций, а не от конкретных реализаций. Таким образом, компоненты могут быть легко заменяемыми и переиспользуемыми.

Примером популярного подхода, реализующего принцип инверсии управления, является использование контейнеров внедрения зависимостей (Dependency Injection, DI), где контейнер берет на себя создание и предоставление зависимостей компонентам.

Применение принципа инверсии управления позволяет создавать более гибкие и расширяемые системы, улучшает тестируемость кода и помогает разделить ответственность между компонентами в приложении.
#### Варианта решения проблемы 

1. _Сервисы_ 

	 * Альтернативой внедрению зависимостей является использование [локатора служб](https://en.wikipedia.org/wiki/Service_locator_pattern). Шаблон проектирования локатора служб также улучшает разделение классов и конкретных зависимостей. Вы создаете класс, известный как _service locator_, который создает и хранит зависимости, а затем предоставляет эти зависимости по запросу.
 
2. _Автоматическое внедрение зависимостей_

	* Существуют библиотеки, которые решают эту проблему путем автоматизации процесса создания и предоставления зависимостей. Они подразделяются на две категории:

	1. Решения, основанные на отражении, которые подключают зависимости во время выполнения.

	2. Статические решения, которые генерируют код для подключения зависимостей во время компиляции.
    
	[Dagger](https://dagger.dev/) - популярная библиотека внедрения зависимостей для Java, Kotlin и Android, поддерживаемая Google. Dagger упрощает использование DI в вашем приложении, создавая для вас график зависимостей и управляя им. Он обеспечивает полностью статические зависимости и зависимости во время компиляции, решая многие проблемы разработки и производительности решений, основанных на отражении, таких как [Guice](https://en.wikipedia.org/wiki/Google_Guice).

#### Альтернативы внедрению зависимостей

Альтернативой внедрению зависимостей является использование [локатора служб](https://en.wikipedia.org/wiki/Service_locator_pattern). Шаблон проектирования локатора служб также улучшает разделение классов и конкретных зависимостей. Вы создаете класс, известный как _service locator_, который создает и хранит зависимости, а затем предоставляет эти зависимости по запросу.

```kotlin
object ServiceLocator {    
	fun getEngine(): Engine = Engine()  
}  
  
class Car {    
	private val engine = ServiceLocator.getEngine()    
	fun start() {        
		engine.start()   
	}  
}
```

Шаблон поиска служб отличается от внедрения зависимостей способом используются элементы. С шаблоном поиска служб классы имеют контроль и запрашивают объекты для внедрения; с внедрением зависимостей приложение имеет контроль и активно внедряет требуемые объекты.

По сравнению с внедрением зависимостей:

- Набор зависимостей, требуемый локатором служб, усложняет тестирование кода, поскольку все тесты должны взаимодействовать с одним и тем же глобальным локатором служб.
    
- Зависимости кодируются в реализации класса, а не в поверхности API. В результате сложнее понять, что нужно классу извне. В результате изменения `Car` или зависимостей, доступных в локаторе служб, могут привести к сбоям во время выполнения или тестирования, вызывая сбой ссылок.
    
- Управлять временем жизни объектов сложнее, если вы хотите ограничить что-либо, кроме времени жизни всего приложения.

