# Задача 22: Даны два неупорядоченных набора целых чисел (может быть, с повторениями). Выдать без повторений в порядке возрастания все те числа, которые встречаются в обоих наборах.
# Пользователь вводит в строку первый список затем на следующией строке второй список.
from random import randint

def get_nums():
    len = int(input("Введите размер набора: "))
    nums = [randint(-10, 10) for i in range(len)]
    print(nums)
    return nums

nums_1 = get_nums()
nums_2 = get_nums()

set_1 = set(nums_1)
set_2 = set(nums_2)
nums_set = set_1.union(set_2)
nums_list = sorted(list(nums_set))
print(nums_list)