

public class WorkThread {

    /**
     * Распределение на потоки: CountPi - производит расчет, Search - поиск позиции*
     *
     * @author - Parshukov_Alexander
     */

    private static Subsequence subsequence;

    private static long timeWork;

    public WorkThread(Subsequence subsequenceInput) {
        subsequence = subsequenceInput;
        timeWork = System.currentTimeMillis();
        Thread count = new CountPi();
        Thread search = new Search();
        count.start();
        search.start();
    }


    public static class CountPi extends Thread {

        @Override
        public void run() {
            PiCalculation.getPiLength(1000000);
        }
    }

    public static class Search extends Thread {

        @Override
        public void run() {
            while (true) {

                if (PiCalculation.getPiValue().indexOf(subsequence.getSequence()) != -1) {
                    String sequencePosition = String.valueOf(PiCalculation.getPiValue().indexOf(subsequence.getSequence()));
                    WorkThread.getSubsequence().setSequencePosition(sequencePosition);
                    break;
                } else if (System.currentTimeMillis() - timeWork > 300000) {
                    WorkThread.getSubsequence().setSequencePosition(String.valueOf(-1));
                    break;
                }
            }
        }
    }

    public static Subsequence getSubsequence() {
        return subsequence;
    }

    public static long getTimeWork() {
        return timeWork;
    }
}
