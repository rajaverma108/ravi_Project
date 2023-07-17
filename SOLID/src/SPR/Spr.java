package SPR;

class Spr {
    public static void main(String[] args) throws Exception {

        //A class should have one and only one responsibility and reason to change.

        Note note = new Note();
        note.addComment("First note");
        note.addComment("Second note");

        Persistence persistence = new Persistence();
        String filename = "notes.txt";
        persistence.saveToFile(note, filename);

        System.out.println(note);
      //  Runtime.getRuntime().exec("gedit " + filename);
    }
}