package br.com.mateussm340.cashewmusic.models;

import br.com.mateussm340.cashewmusic.interfaces.IMyFavorites;

import java.util.Scanner;

public class Audio implements IMyFavorites {
    private final Scanner reading = new Scanner(System.in);
    private final Preferences preferences = new Preferences();
    private String title;
    private int totalPlays;
    private int totalLikes;
    private int rating;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTotalLikesPlay(int totalPlays, int totalLikes) {
        this.totalPlays = totalPlays;
        this.totalLikes = totalLikes;
    }

    public int getTotalPlays() {
        return this.totalPlays;
    }

    public int getTotalLikes() {
        return this.totalLikes;
    }

    public int getRating() {
        return this.rating;
    }

    @Override
    public void addFavorite(Audio audio) {
        System.out.print("\n-> Você deseja adicionar: " + audio.getTitle() + " aos favoritos? (sim ou não): ");
        String chosenOption = reading.next();
        String initialMessageTitle = "-> " + audio.getTitle();

        if (chosenOption.equals("sim")) {
            System.out.println(initialMessageTitle + " foi adicionada com sucesso aos favoritos");
            preferences.includePreference(audio);
        } else {
            System.out.println(initialMessageTitle + " não adicionada aos favoritos");
        }
    }

    public int getClassificationBySelectedQuantity(int quantity) {
        int currentIndex = -1;
        int totalAudioComparator = 1500;

        for (int i = 0; i <= totalAudioComparator; i+= (totalAudioComparator / 10)) {
            if (quantity >= i) {
                currentIndex += 1;
            }
        }

        return currentIndex;
    }

    public void showAddedTotalLikesPlay() {
        System.out.print("Quantidade de curtidas: ");
        int likeCount = reading.nextInt();

        System.out.print("Quantidade de reproduções: ");
        int playbackCount = reading.nextInt();

        setTotalLikesPlay(playbackCount, likeCount);
    }

    public void showTotalLikesPlay() {
        System.out.println("Total de reproduções: " + getTotalPlays());
        System.out.println("Total de curtidas: " + getTotalLikes());
        System.out.println("Classificação: " + getRating());
    }
}
