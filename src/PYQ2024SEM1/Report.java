/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PYQ2024SEM1;
import java.util.*;
import java.io.*;
/**
 *
 * @author justb
 */
public class Report {
    public static void main(String[] args) {
        String inputFile = "oaiset.csv";
        OAIRecord[] data = new OAIRecord[50];
        System.out.println("Loading Dataset...");
        loadRecord(inputFile, data);
        System.out.println("The curated record is as follow: ");
        printRecord(cleanRecord(data));
        System.out.println("\nThe summary report is as follow:");
        reportData(cleanRecord(data));
    }
    
    public static void reportData(OAIRecord[] data) {
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        
        for (int j = 0; j < data.length; j++) {
            String[] author_list = data[j].getAllAuthors();
            for (int i = 0; i < author_list.length; i++) {
                if(!authors.contains(author_list[i])) {
                    authors.add(author_list[i]);
                    count.add(1);
                }
                else{
                    int index = authors.indexOf(author_list[i]);
                    count.set(index, count.get(index) + 1);
                }
            }
        }
        System.out.println("Report:");
        Collections.sort(authors);
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(authors.get(i) + " : " + count.get(i));
        }
    }
    
    public static OAIRecord[] loadRecord(String inputFile, OAIRecord[] data) {
        try{
            Scanner sc =  new Scanner(new FileInputStream(inputFile));
            sc.nextLine(); //get first title line
            int i = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.split(",");
                String doi = info[0];
                String title = info[1];
                String subject = info[2];
                String author1 = info[3];
                String author2 = info[4];
                String author3 = info[5];
                String author4 = info[6];
                String author5 = info[7];
                String author6 = info[8];
                String author7 = info[9];
                String author8 = info[10];
                String keyword = info[11];
                String status = info[12];
                data[i] = new OAIRecord(doi, title, subject, author1, author2, author3, author4, author5, author6, author7, author8, keyword ,status);
                i++;
            }
            sc.close();
        } catch(FileNotFoundException e) {
            System.out.println("");
        }
        
        return data;
    }
    
    public static OAIRecord[] cleanRecord(OAIRecord[] data) {
        int to_be_deleted = 0;
        for (OAIRecord a : data) {
            if(a == null) {
                to_be_deleted++;
                continue;
            }
            if(a.getStatus().equalsIgnoreCase("deleted")) {
                to_be_deleted++;
            }
        }

        OAIRecord[] new_data = new OAIRecord[data.length - to_be_deleted];
        int i = 0;
        for (OAIRecord a : data) {
            if(a == null) {
                continue;
            }
            if(!a.getStatus().equalsIgnoreCase("deleted")) {
                new_data[i] = a;
                i++;
            }
        }
        
        return new_data;
    }
    
    public static void printRecord(OAIRecord[] data) {
        int i = 1;
        for (OAIRecord a : data) {
            System.out.print("Record " + i + " ");
            a.printOAI();
            i++;
        }
    }
}

class OAIRecord {
    private String author1, author2, author3, author4, author5, author6, author7, author8;
    private String keyword, status, doi, title, subject;

    public OAIRecord(String doi, String title, String subject, String author1, String author2, String author3, String author4, String author5, String author6, String author7, String author8, String keyword, String status) {
        this.doi = doi;
        this.title = title;
        this.subject = subject;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.author4 = author4;
        this.author5 = author5;
        this.author6 = author6;
        this.author7 = author7;
        this.author8 = author8;
        this.keyword = keyword;
        this.status = status;
    }
    
    public String[] getAllAuthors() {
        String[] authors = {author1, author2, author3, author4, author5, author6, author7, author8};
        return authors;
    }
    
    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public String getAuthor4() {
        return author4;
    }

    public String getAuthor5() {
        return author5;
    }

    public String getAuthor6() {
        return author6;
    }

    public String getAuthor7() {
        return author7;
    }

    public String getAuthor8() {
        return author8;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getStatus() {
        return status;
    }

    public String getDoi() {
        return doi;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }
    
    public void printOAI() {
        System.out.printf("%s \"%s\" %s {%s,%s,%s,%s,%s,%s,%s,%s} %s %s\n", doi, title, subject, author1, author2, author3, author4, author5, author6, author7, author8, keyword, status);
    }
}

