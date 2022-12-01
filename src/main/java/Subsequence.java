public class Subsequence {
    /**
     * Последовательность числа, с которой проводится проверка*
     *
     *  @author - Parshukov_Alexander */


    //Последовательность
    private String sequence;

    //положениее последовательности
    private String sequencePosition = "0";

    public Subsequence(String sequence) {
        this.sequence = sequence;
    }

    public String getSequencePosition() {
        return sequencePosition;
    }

    public String getSequence() {
        return sequence;
    }


    public void setSequencePosition(String sequencePosition) {
        this.sequencePosition = sequencePosition;
    }
}
