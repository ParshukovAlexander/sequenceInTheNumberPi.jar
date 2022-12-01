
public abstract class PiCalculation{

    private static volatile StringBuffer piValue=new StringBuffer();

    /**
     * Класс задает длину числа Pi и проводит его считывания*
     *
     *  @author - Parshukov_Alexander */
    public static synchronized void getPiLength(final int n) {
        piValue =new StringBuffer();
        long timeWork = System.currentTimeMillis();

        // найденные цифры сразу же будем записывать в StringBuffer
        int boxes = n * 10 / 3;	// размер массива
        int reminders[] = new int[boxes];
        // инициализируем масив двойками
        for (int i = 0; i < boxes; i++) {
            reminders[i] = 2;
        }

        int heldDigits = 0;    // счётчик временно недействительных цифр
        for (int i = 0; i < n; i++) {
            int carriedOver = 0;    // перенос на следующий шаг
            int sum = 0;
            for (int j = boxes - 1; j >= 0; j--) {
                reminders[j] *= 10;
                sum = reminders[j] + carriedOver;
                int quotient = sum / (j * 2 + 1);   // результат деления суммы на знаменатель
                reminders[j] = sum % (j * 2 + 1);   // остаток от деления суммы на знаменатель
                carriedOver = quotient * j;   // j - числитель
            }
            reminders[0] = sum % 10;
            int q = sum / 10;	// новая цифра числа Пи
            // регулировка недействительных цифр
            if (q == 9) {
                heldDigits++;
            } else if (q == 10) {
                q = 0;
                for (int k = 1; k <= heldDigits; k++) {
                    int replaced = Integer.parseInt(piValue.substring(i - k, i - k + 1));
                    if (replaced == 9) {
                        replaced = 0;
                    } else {
                        replaced++;
                    }
                    piValue.deleteCharAt(i - k);
                    piValue.insert(i - k, replaced);
                }
                heldDigits = 1;
            } else {
                heldDigits = 1;
            }

            piValue.append(q);// сохраняем найденную цифру
            if (System.currentTimeMillis() - timeWork > 300000 ||
                    Integer.parseInt(WorkThread.getSubsequence().getSequencePosition())>0){
                piValue =new StringBuffer();
                return;
            }
        }
        if (piValue.length() >= 2) {
            piValue.insert(1, '.');	// добавляем в строчку точку после 3
        }
    }

    public static StringBuffer getPiValue() {
        return piValue;
    }

}
