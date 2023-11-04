# Задача 30:  Заполните массив элементами арифметической прогрессии.
# Её первый элемент, разность и количество элементов нужно ввести с клавиатуры.
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d.
# Каждое число вводится с новой строки.
# Input:
# 1
# 2
# 5
# Output:
# 1, 3, 5, 7, 9


# def arithmetic_progression(start, step, lenght):
#     return [item for item in range(start, start+step*(lenght-1)+1, step)]


def arithmetic_progression(start, step, lenght):
    result = []
    for i in range(lenght):
        result.append(start)
        start += step
    return result


start = int(input('Начальное значение: '))
step = int(input('Шаг: '))
length = int(input('Количество элементов: '))
print(arithmetic_progression(start, step, length))
