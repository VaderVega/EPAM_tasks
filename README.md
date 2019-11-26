# EPAM tasks

## OOP

### Task 1. [Принципы ООП, простейшие классы и объекты](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task1)

Разработайте спецификацию и создайте класс Ручка (Pen). Определите в этом классе методы equals(), hashCode() и toString().

### Task 2. [Классы и объекты](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task2)

Напишите приложение, позволяющее вести учет канцелярских товаров на рабочем месте сотрудника. Определите полную стоимость канцтоваров у определенного сотрудника.

### Task 3. [Наследование](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task3)

Разработайте иерархию канцелярских товаров. Создайте “набор новичка”, используя созданную иерархию.

### Task 4. [Интерфейсы](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task4)

Используйте “набор новичка”, созданный в задании 3, (или любую другую коллекцию объектов); отсортируйте вещи в этом наборе по стоимости, по наименованию, по стоимости и наименованию.

### Task 5. [Параметризация, перечисления](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task5)

Разработайте приложение, позволяющее формировать группы студентов по разным дисциплинам. Состав групп может быть разным. Каждая дисциплина в отдельности определяет, целыми или вещественными будут оценки по нет. Необходимо найти группы, в которые входит студент X, и сравнить его оценки. Для огранизации перечня дисциплин можно использовать перечисление.

### Task 6. [Классы внутри классов](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task6)

Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки. Создайте объект АтомнаяЛодка и “запустите его в плавание”.

### Task 7. [Аннотации](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/OOP/Task7)

Разработайте для класса АтомнаяЛодка из задания 6 (или любого другого класса) аннотацию, которая могла бы обрабатываться утилитой Javadoc. Аннотируйте класс.

## Information handling

### Task 1. [Стркоковые классы](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/InformationHandling/Task1)

Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как накопитель объект типа StringBuilder. Логгер должен содержать методы поиска определенной информации в таком логе [с возможностью вывода ее в поток ввода вывода]. Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.

### Task 2. [Locale и ResourceBundle](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/InformationHandling/Task2)

Разработать приложение, позволяющее по выбору пользователя использовать русский или английский язык, для отображения информации.  Приложение должно представлять собой перечень вопросов под номерами (на английском или русском соответственно). Выбрав номер вопроса пользователь может узнать ответ на него.

### Task 3. [Регулярные выражения](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/InformationHandling/Task3)

Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки последовательно или нет, а также выделить все предложения, в которых встречаются ссылки на рисунки. Для разбора текста использовать регулярные выражения.

## I/O Streams

### Task 1. [Работа с байтовыми потоками ввода-вывода](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/IOStreams/Task1)

Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.

### Task 2. [Работа с символьными потоками ввода-вывода](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/IOStreams/Task2)

Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит. Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.

### Task 3. [Работа с байтовыми и символьными потоками ввода-вывода](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/IOStreams/Task3)

Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8. Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.

### Task 4. [Сериализация](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/IOStreams/Task4)

Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься и в нескольких фильмах). Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов, позволять ее модифицировать, а по завершении работы приложения – сохранять (в файл). Для восстановления/сохранения коллекции использовать  сериализацию/десериализацию.

## Exceptions and Errors

### Task 1. [Обработка исключительных ситуаций](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/ExceptionsAndErrors/Task1)

Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы, а также создавать и удалять текстовые файлы. Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл. Требуется определить исключения для каждого слоя приложения и корректно их обработать.

### Task 2. [Обработка исключительных ситуаций](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/ExceptionsAndErrors/Task2)

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла. Физическое чтение файла должно происходить только один раз. Обработайте следующие исключительные ситуации: нет файла *.properties, нет ключа в properties-файле.

## Generics and Collections

### Task 1. [Классы коллекций](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/GenericsAndCollections/Task1)

Изучите классы реализации коллекций и заполните следующую таблицу

| Class | Ordering | Random Access | Key-Value Pairs | Allows Duplicates | Allows Null Values | Thread Safe | Blocking Operations |
| --- | --- | --- | --- | --- | --- | --- | --- |
|   |   |   |   |   |   |   |   |

### Task 2. [Использование Map](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/GenericsAndCollections/Task2)

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла. Физическое чтение файла должно происходить только один раз. Результаты чтения храните в коллекции типа Map. Ответьте на вопрос: как ведет себя map-коллекция если в нее добавить элемент с ключом, который уже присутствует?

### Task 3. [Ссылки на коллекций](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/GenericsAndCollections/Task3)
Определена иерархия классов
```Java
class MedicalStaff{}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}
```
Укажите корректные и некорректные операторы. Дайте ответу пояснение.

### Task 4. [Применение коллекций](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/GenericsAndCollections/Task4)

Заполните таблицу.

|   | Основная функциональность | Примеры типичного использования |
| --- | --- | --- |
| Set |  |  |
| List |  |  |
| Queue |  |  |
| Map |  |    |


## Multithreading

### Task 1. [Синхронизация 1](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/Multithreading/Task1)

В текстовом (или xml) файле содержится информация о переводах средств со счета на счет. Создайте приложение, позволяющее в параллельном режиме обработать эту информацию (счета с приложении представляются собой объекты). Синхронизируйте код приложения используя ключевое слово synchronized (1 вариант) и библиотеку java.util.concurrent (2 вариант).


### Task 2. [Синхронизация 2](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/Multithreading/Task2)

Создать “универсальный” класс, позволяющий получить значение из любого properties-файла. Физическое чтение файла должно происходить только один раз. Учтите ситуацию, когда несколько потоков одновременно обращаются к одному и тому же файлу.

### Task 3. [Управление многопоточным приложением](https://github.com/VaderVega/EPAM_tasks/tree/master/src/main/java/Multithreading/Task3)

Перепишите код приложения для темы wait, notify так, чтобы ситуация, когда все потоки хотят прочитать из очереди, не могла возникнуть.

```java
package _java._se._07._waitnotify;
import java.util.ArrayList;
import java.util.List;
public class SharedResource {
	private List<Integer> list;

	public SharedResource() {
		list = new ArrayList<Integer>();
	}

	public void setElement(Integer element) {
		list.add(element);
	}

	public Integer getELement() {
		if (list.size() > 0) {
			return list.remove(0);
		} 
		return null;
	}

}
```

```java
package _java._se._07._waitnotify;
import java.util.Random;

public class UserResourceThread {
	public static void main(String[] args) throws InterruptedException {
		SharedResource res = new SharedResource();
		IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
		IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
		IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);
		IntegerSetterGetter t5 = new IntegerSetterGetter("5", res);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		Thread.sleep(100);

		t1.stopThread();
		t2.stopThread();
		t3.stopThread();
		t4.stopThread();
		t5.stopThread();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();

		System.out.println("main");
	}
}
```

```java
class IntegerSetterGetter extends Thread {
	private SharedResource resource;
	private boolean run;

	private Random rand = new Random();

	public IntegerSetterGetter(String name, SharedResource resource) {
		super(name);
		this.resource = resource;
		run = true;
	}

	public void stopThread() {
		run = false;
	}

	public void run() {
		int action;

		try {
			while (run) {
				action = rand.nextInt(1000);
				if (action % 2 == 0) {
					getIntegersFromResource();
				} else {
					setIntegersIntoResource();
				}
			}
			System.out.println("Поток " + getName() + " завершил работу.");
		} catch (InterruptedException e) {
		    e.printStackTrace();
            		}
            	}
            
            	private void getIntegersFromResource() throws InterruptedException {
            		Integer number;
            
            		synchronized (resource) {
            			System.out.println("Поток " + getName()
            					+ " хочет извлечь число.");
            			number = resource.getELement();
            			while (number == null) {
            				System.out.println("Поток " + getName()
            						+ " ждет пока очередь заполнится.");
            				resource.wait();
            				System.out
            						.println("Поток " + getName() + " возобновил работу.");
            				number = resource.getELement();
            			}
            			System.out
            					.println("Поток " + getName() + " извлек число " + number);
            		}
            	}
            
            	private void setIntegersIntoResource() throws InterruptedException {
            		Integer number = rand.nextInt(500);
            		synchronized (resource) {
            			resource.setElement(number);
            			System.out.println("Поток " + getName() + " записал число "
            					+ number);
            			resource.notify();
            		}
            	}
            }
		
```