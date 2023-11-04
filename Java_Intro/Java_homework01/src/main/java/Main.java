//  1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//  2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//  3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//  4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = new Random().nextInt(2000);
        int n = getMSbPosition(i);
        int[] m1 = getMultiples(n, i, Short.MAX_VALUE);
        int[] m2 = getNonMultiples(n, Short.MIN_VALUE, i);

        System.out.println("i = " + i);
        System.out.println("n = " + n);
//        System.out.println("m1 = " + Arrays.toString(m1));
//        System.out.println("m2 = " + Arrays.toString(m2));


    }
    private static int getMSbPosition(int number){
        int position = 0;

        while (number > 1){
            number = number >> 1;
            position++;
        }
        return position;
    }

    private  static int[] getMultiples(int number, int start, int end){
        int count = 0;

        for (int j = start; j <= end; j++){
            if (j % number == 0){
                count++;
            }
        }

        int[] array = new int[count];
        int index = 0;
        for (int j = start; j <= end; j++){
            if (j % number == 0){
                array[index++] = j;
            }
        }
        return array;
    }

    private  static int[] getNonMultiples(int number, int start, int end){
        int count = 0;

        for (int j = start; j <= end; j++){
            if (j % number != 0){
                count++;
            }
        }

        int[] array = new int[count];
        int index = 0;
        for (int j = start; j <= end; j++){
            if (j % number != 0){
                array[index++] = j;
            }
        }
        return array;
    }
}
