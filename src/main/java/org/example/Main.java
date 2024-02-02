package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {

        ITuesMusicPlayer player = new ITuesMusicPlayer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Что хотите послушать?");
        String name = sc.nextLine();
        player.playSound(name);

     }
}
/*  String term = getUserInput();
    String url = buildUrl(term);
    String page = downloadWebPage(url);
    printResult(page);
    pageWriter(page);
}
private static void printResult(String page) {
        StringBuilder result = buildMovieInformation(page);
        System.out.println(result.toString());
        }

static StringBuilder buildMovieInformation(String page) {
        int end, start;
        StringBuilder result = new StringBuilder();

        int moviesCount = 0;
        int currentMovieIndex = 0;
        while (moviesCount < 115) {
        currentMovieIndex = page.indexOf("feature-movie", currentMovieIndex + 20);

        start = page.indexOf("trackName", currentMovieIndex) + "trackName".length() + 3;
        end = page.indexOf("\",", start);
        String movieName = page.substring(start, end);

        start = page.indexOf("primaryGenreName", currentMovieIndex) + "primaryGenreName".length() + 3;
        end = page.indexOf("\",", start);
        String primaryGenreName = page.substring(start, end).replaceAll("<br />", "\n");

        start = page.indexOf("longDescription", currentMovieIndex) + "longDescription".length() + 3;
        end = page.indexOf("\",", start);
        String movieDescription = page.substring(start, end).replaceAll("<br />", "\n");

        if (primaryGenreName.equals("Comedy")) {
        result.append("Мы нашли комедию.\n");
        result.append(movieName);
        result.append(" \n Description: \n ");
        result.append(movieDescription);
        break;
        } else {
        result.append("This is a movie.\n");
        result.append(movieName);
        result.append(" \n Description: \n ");
        result.append(movieDescription + "\n");
        moviesCount++;
        }
        }
        return result;
        }
static StringBuilder buildSongInformation(String page) {
        int end, start;
        StringBuilder result = new StringBuilder();

        start = page.indexOf("artistName") + "artistName".length() + 3;
        end = page.indexOf("\",", start);
        String artistName = page.substring(start, end);

        start = page.indexOf("primaryGenreName") + "primaryGenreName".length() + 3;
        end = page.indexOf("\",", start);
        String primaryGenreName = page.substring(start, end);

        start = page.indexOf("trackCensoredName") + "trackCensoredName".length() + 3;
        end = page.indexOf("\",", start);
        String trackCensoredName = page.substring(start, end);

        start = page.indexOf("country") + "country".length() + 3;
        end = page.indexOf("\",", start);
        String country = page.substring(start, end);

        result.append("This is a song.\n");
        result.append(artistName);
        result.append("\nОтслеживаемое имя: " + trackCensoredName);
        result.append("\nПервое имя: " + primaryGenreName);
        result.append("\nCountry: " + country);
        return result;
        }

private static String getKind(String page) {
        int start;
        int end;
        start = page.indexOf("kind") + "kind".length() + 3;
        end = page.indexOf("\",", start);
        String kind = page.substring(start, end);
        return kind;
        }

private static StringBuilder buildBookResult(String page) {
        StringBuilder builder = new StringBuilder();
        int start;
        int end;
        start = page.indexOf("artistName") + 13;
        end = page.indexOf("\",", start);
        String author = page.substring(start, end);

        start = page.indexOf("collectionName") + "collectionName".length() + 3;
        end = page.indexOf("\",", start);
        String bookName = page.substring(start, end);

        start = page.indexOf("description") + "description".length() + 3;
        end = page.indexOf("\"", start);
        String bookDescription = page.substring(start, end);

        builder.append("This is a book. Author is ");
        builder.append(author);
        builder.append(".\nThe name is: ");
        builder.append(bookName);
        builder.append("\nDescription: \n");
        builder.append(bookDescription);
        return builder;
        }


private static String buildUrl(String term) {
        String termWithoutSpaces = term.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=300";
        StringBuilder url = new StringBuilder();
        url.append(itunesApi);
        url.append(termWithoutSpaces);
        url.append(limitParam);
        // String url = itunesApi + termWithoutSpaces + limitParam;
        return url.toString();
        }

static String getUserInput() {
        System.out.println("What you looking for in itunes");
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        return info;
        }

private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
        while ((line = br.readLine()) != null) {
        result.append(line);
        }
        }
        return result.toString();

        }
private static void pageWriter(String page) throws IOException {
        File output = new File("C:\\Users\\Marat\\Desktop\\PassGitHab.txt");
        FileWriter writer = new FileWriter(output);
        writer.write(page);
        writer.flush();
        writer.close();
        }
  */