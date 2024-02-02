package org.example;

import java.awt.Desktop;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ITuesMusicPlayer {
    void playSound(String searchRequest) throws IOException {
            playSoundInternal(searchRequest, 1);
    }
    void playSound(String searchRequest, int limit) throws IOException {
            playSoundInternal(searchRequest, limit);
    }
    private void playSoundInternal(String searchRequest, int limit ) throws IOException {
        String url = buildUrl(searchRequest, limit);
        String page = downloadWebPage(url);

        String artistName = getTag(page, "artistName");
        String trackName = getTag(page, "trackName");
        String previewUrl = getTag(page, "previewUrl");
        System.out.println(artistName + " - " + trackName);
        try (InputStream in = new URL(previewUrl).openStream()){
            int count = 0;
            count++;
            Files.copy(in, Paths.get(count + " " + trackName + ".m4a"));
        }
        System.out.println("Готово!");

        if (!Desktop.isDesktopSupported()) {
            System.out.println("Файл не доступен для воспроизведения");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File(trackName + ".m4a");
        desktop.open(file);
    }

    private String getTag(String page, String tagName) {
        int start = page.indexOf(tagName) + tagName.length() + 3;
        int end = page.indexOf("\"", start);
        String value = page.substring(start, end);
    return value;
    }

    private static String buildUrl(String term, int limit) {
        String termWithoutSpaces = term.replaceAll(" ", "+");
        String itunesApi = "https://itunes.apple.com/search?term=";
        String limitParam = "&limit=" + limit;
        String mediaParam = "&media=music";
        StringBuilder builder = new StringBuilder();
        builder.append(itunesApi);
        builder.append(termWithoutSpaces);
        builder.append(limitParam);
        builder.append(mediaParam);
        // String url = itunesApi + termWithoutSpaces + limitParam;
        return builder.toString();
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
}
