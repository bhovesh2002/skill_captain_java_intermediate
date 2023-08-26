package Day5;

import java.util.*;

//TimerTask because I wanted the song to change automatically
public class MyMusicPlayer extends TimerTask implements MusicPlayer{
    private List<String> playList;
    private boolean isPlaying;
    private boolean onShuffle;
    private String currentSong;
    private static int currentSongId = 0;

    public MyMusicPlayer() {
        this.playList = new ArrayList<>();
        this.isPlaying = false;
        this.onShuffle = false;
    }

    @Override
    public void play() {
        if(!playList.isEmpty()){
            System.out.println("Playing song: " + playList.get(currentSongId));
            currentSong = playList.get(currentSongId);
            currentSongId += 1;
            isPlaying = true;
        }else{
            System.out.println("Playlist is empty~!");
            isPlaying = false;
        }
    }

    public void run(){
        if (isPlaying){
            if(!onShuffle){
                if (currentSongId < playList.size()){
                    System.out.println("Now playing: " + playList.get(currentSongId));
                    currentSong  = playList.get(currentSongId);
                    currentSongId += 1;
                }else{
                    currentSongId = 0;
                    System.out.println("Playing the playlist again!");
                    System.out.println("Playing song: " + playList.get(currentSongId));
                    currentSong = playList.get(currentSongId);
                    currentSongId += 1;
                }
            }else {
                //For some reason the first song of the playlist doesn't get played,
                //when I tried to decrease the min value for random generation by 1, it gave an outofbound exception
                //and should I create variable to store 0? I didn't keep in a variable because 0 is supposed to be the very first index
                //or the very first song in the list. Since the first song will always be at 0th index, I didn't think this can be
                //considered as a magicNumber. OOverall I did try to reduce magicNumbers as much as possible.
                int randomNumber = generateRandom(playList.size(), 0);
                int minSize = 1;
                if(currentSongId == randomNumber && playList.size() != minSize) {
                    randomNumber = generateRandom(playList.size(), 0);
                }
                System.out.println("Now playing song: " + playList.get(randomNumber));
                currentSongId = randomNumber;
                currentSong = playList.get(randomNumber);
            }
        }
    }


    @Override
    public void pause() {
        if (isPlaying){
            System.out.println("Paused song: " + currentSong);
            isPlaying = false;
        }else {
            System.out.println("No song is being played!");
        }
    }

    public void shufflePlay(){
        if(!playList.isEmpty()){
            int randomNumber = generateRandom(playList.size(), 0);
            System.out.println("Playing on Shuffle!");
            System.out.println("Playing Song: " + playList.get(randomNumber));
            currentSongId = randomNumber;
            isPlaying = true;
            onShuffle = true;
        }else{
            System.out.println("Empty Playlist!");
        }
    }

    @Override
    public void stop() {
        if (isPlaying){
            System.out.println("Stopped Song: " + currentSong);
            isPlaying = false;
        }else{
            System.out.println("No song is currently playing!");
        }
    }

    @Override
    public void addSong(String song) {
        playList.add(song);
        System.out.println(song + " has been added");
    }

    @Override
    public void removeSong(String song) {
        if (playList.contains(song)){
            playList.remove(song);
            System.out.println(song + " Removed");
        }else {
            System.out.println("No" + song + "song found!");
        }
    }

    //I tried to implement small functionalities in  methods, so that it can be used more easily
    public int generateRandom(int max, int min){
        return (int) (Math.random()*(max-min-1)+1);
    }

    
    public static final int PLAY  = 1;
    public static final int PAUSE  = 2;
    public static final int SHUFFLE  = 3;
    public static final int ADD  = 4;
    public static final int REMOVE  = 5;
    public static final int EXIT  = 6;

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        //When I was checking the submitted solutions, I found that you've had written "MusicPlayer player", which made sense,
        //because we are implementing that interface("MusicPlayer") through MyMusicPlayer class, but then I could not use
        // methods(shuffle-play) which we were not present in MusicPlayer interface.
        //IDE suggested that I use MyMusicPLayer rather than MusicPlayer. Will this cause any problem? I didn't experience any errors,
        //regarding this.
        MyMusicPlayer player = new MyMusicPlayer();

        player.addSong("Song 1");
        player.addSong("Song 2");
        player.addSong("Song 3");
        player.addSong("Song 4");
        player.addSong("Song 5");

        //This part was added so that there could be automatic change in songs
        Timer timer = new Timer();
        TimerTask timerPlayer = (TimerTask) player;

        System.out.println("Press 1 to play song ");
        System.out.println("Press 2 to pause a song");
        System.out.println("Press 3 to shuffle playlist");
        System.out.println("Press 4 to add a song");
        System.out.println("Press 5 to delete a song");
        System.out.println("Press 6 to exit");
        int i = 0;

        while (i !=EXIT){
            System.out.println("Please make a choice: ");
             i = Sc.nextInt();
             Sc.nextLine();

            switch (i){
                case PLAY -> {
                    player.play();
                    timer.schedule(timerPlayer, 3000, 3000);
                }

                case PAUSE -> {player.pause();}

                case SHUFFLE -> {
                    player.shufflePlay();
                    timer.schedule(timerPlayer, 3000, 3000);
                }

                case ADD -> {
                    System.out.println("Enter song name: ");
                    String addSong = Sc.nextLine();
                    player.addSong(addSong);
                }

                case REMOVE -> {
                    System.out.println("Enter song name to delete: ");
                    String deleteSong = Sc.nextLine();
                    player.removeSong(deleteSong);
                }

                case EXIT -> {
                    System.out.println("EXITING~~");
                }
                default -> {
                    System.out.println("Wrong choice entered! please try again!");

                }
            }
        }
    //I'll get to error/exception handling soon, but I want to keep on doing these day-wise assignments and maintain a streak because its fun
        //So either when I get stuck on a problem with some huge program or when I am done with the current JAVA level or when the 
        //assignment is easy 
    }

}
