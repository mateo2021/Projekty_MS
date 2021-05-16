/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad_2_max_flow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mateusz Stadnicki
 */
public class Zad_2_max_flow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
            
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Jaką chcesz ścieżkę wybrać (PRZEPŁYW MAXYMALNY) jeśli 8-max podaj 8 jeśli przepływ 5-ięć podaj 5");
        int litera = scan.nextInt();
        
        switch(litera){
            case 5:{
                Max_flow_5 flow = new Max_flow_5();
                Scanner sc = new Scanner(new BufferedReader(new FileReader("wejscie_5.txt")));
                   int rows = 5;
                    int columns = 5;
                     int[][] graph = new int[rows][columns];
                while (sc.hasNextLine()) {
                    for (int i = 0; i < graph.length; i++) {
                         String[] line = sc.nextLine().trim().split(", ");
                            for (int j = 0; j < line.length; j++) {
                            graph[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        System.out.println("Postac tekstowa : " +Arrays.deepToString(graph));
        
        
         flow.fordFulkerson(graph, 0, 4);
            
                break;
            }
            case 8:{
                      Max_flow_8 flow = new Max_flow_8();
                Scanner sc = new Scanner(new BufferedReader(new FileReader("wejscie_8.txt")));
                   int rows = 5;
                    int columns = 5;
                     int[][] graph = new int[rows][columns];
                while (sc.hasNextLine()) {
                    for (int i = 0; i < graph.length; i++) {
                         String[] line = sc.nextLine().trim().split(", ");
                            for (int j = 0; j < line.length; j++) {
                            graph[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        System.out.println("Postac tekstowa : " +Arrays.deepToString(graph));
        
        
         flow.fordFulkerson(graph, 0, 4);
                break;
            }
           default: {
                System.out.println("Podaj poprawny przepływ, spróbuj ponownie");
    }
            
        }
    }        
         
    }
    

