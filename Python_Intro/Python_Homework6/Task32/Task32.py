# Задача 32: Определить индексы элементов массива (списка),
#  значения которых принадлежат заданному диапазону
# (т.е. не меньше заданного минимума и не больше заданного максимума)
# Input:
# 1, 3, 7, 10, 5, 8
# 4
# 8
# Output:
# 2(7), 4(5), 5(8)

def prompt_list(text):
    return list(map(int, input(text).split()))


def find_indexes(array, min_val, max_val):
    result = []
    for i in range(len(array)):
        if min_val <= array[i] <= max_val:
            result.append(i)
    return (result)


nums = prompt_list('Введите элементы массива через пробел: ')
a = int(input('Введите нижнюю границу диапазона: '))
b = int(input('Введите верхнюю границу диапазона: '))
print(find_indexes(nums, a, b))
