# Задача №49. Создать телефонный справочник с возможностью импорта
#  и экспорта данных в формате .txt. Фамилия, имя, отчество, номер
# телефона - данные, которые должны находиться в файле.
# 1. Программа должна выводить данные
# 2. Программа должна сохранять данные в текстовом файле
# 3. Пользователь может ввести одну из характеристик для поиска
#  определенной записи(Например имя или фамилию человека)
# 4. Использование функций. Ваша программа не должна быть линейной

# Задача 38: Доработать метод search с семинара так, чтобы выводились все найденные совпадения.
#  Если нашлось несколько совпадений - запросить уточнение поиска и найти вариант среди полученного списка.

# Дополнительно: Дополнить телефонный справочник возможностью изменения и удаления данных.
#  Пользователь также может ввести имя или фамилию, и Вы должны реализовать функционал для изменения и удаления данных

import functions as func

while True:
    print('1.Показать контакты, 2. Добавить контакт, 3. Поиск, 4. Изменить')
    mode = int(input())
    if mode == 1:
        func.show_data()
    elif mode == 2:
        func.add_data()
    elif mode == 3:
        func.find_data()
    elif mode == 4:
        func.change_data()
    else:
        break