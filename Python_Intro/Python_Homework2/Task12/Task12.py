# Задача 12: Петя и Катя – брат и сестра. Петя – студент, а Катя –
# школьница. Петя помогает Кате по математике. Он задумывает два
# натуральных числа X и Y (X,Y≤1000), а Катя должна их отгадать. Для
# этого Петя делает две подсказки. Он называет сумму этих чисел S и их
# произведение P. Помогите Кате отгадать задуманные Петей числа.
# Пример
# 4 4 -> 2 2
# 5 6 -> 2 3

sum = int(input('Введите сумму чисел: '))
mult = int(input('Введите произведение чисел: '))

res1 = (sum + ((sum**2 - 4 * mult)**0.5))/2
res2 = (sum - ((sum**2 - 4 * mult)**0.5))/2
print(int(res1))
print(int(res2))
