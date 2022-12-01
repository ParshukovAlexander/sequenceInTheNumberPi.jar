import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s="";

        while (true){
            System.out.println("Введите последовательность чисел или напишите " +
                    "'exit' для выхода из программы");

            s= scan.nextLine();

            if (s.matches("^[0-9]*$")) {
                System.out.println("Начинаю сканирование");
                new WorkThread(new Subsequence(s));
                test();
            }
            else if ("exit".equals(s)) {
                System.out.println("Хорошего дня!");
                break;
            }
            else{
                System.out.println("Данные были ввидены неккоректно. " +
                        "Пожалуйста, попробуйте еще раз");
            }

        }
    }

    private static void test() {
        while (true){
            if (Integer.parseInt(WorkThread.getSubsequence().getSequencePosition())!=0 &&
                    Integer.parseInt(WorkThread.getSubsequence().getSequencePosition())!=-1){
                System.out.println("Позиция найденна: "+WorkThread.getSubsequence().getSequencePosition());
                break;
            }else if (System.currentTimeMillis()-WorkThread.getTimeWork() > 300000){
                System.out.println("время ожидания истекло");
                break;
            }
        }
    }
}
