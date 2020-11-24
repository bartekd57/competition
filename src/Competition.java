import java.util.Arrays;

class Competition {
    private String name;
    private Participant[] participants;
    int ageLimit;
    private int size;

    Competition(){

    }
    public Competition(String name, int maxParticipants, int ageLimit) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.participants = new Participant[maxParticipants];
    }

    void addParticipant(Participant participant) {

        participants[size] = participant;
        String newId [] = new String[participants.length];
        newId[size] = participants[size].getDocumentId();

        for (int i = 0; i < newId.length; i++) {
            if(newId[i].equals(participants[size].getDocumentId())){
                throw new DuplicateException("masz takie samo id");
            }
        }


        if(ageLimit>participants[size].getAge()){
            throw new AgeViolationException("jestes na to za mlody, limit wieku to " + ageLimit + " lat");
        }
        size++;
        if(size> participants.length){
            throw new MamCompetitionException("przekroczono limit zapisów, max to " + participants.length);
        }


    }

    boolean hasFreeSpots() {
        return size < participants.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zawody ")
                .append(name)
                .append("\n")
                .append("Liczba uczestników: ").append(size);
        for (int i = 0; i < size; i++) {
            builder.append("\n");
            builder.append(" > ");
            builder.append(participants[i].toString());
        }
        return builder.toString();
    }
}