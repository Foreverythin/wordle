package comp1721.cwk1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordList {
  ArrayList<String> list = new ArrayList<String>();
  // TODO: Implement constructor with a String parameter
  public WordList(String fileName) throws IOException {
    FileReader file = new FileReader(fileName);
    BufferedReader br = new BufferedReader(file);
    String s = new String();
    while ((s = br.readLine()) != null)
      list.add(s);
    br.close();
  }
  // TODO: Implement size() method, returning an int
  public int size() {
    return list.size();
  }
  // TODO: Implement getWord() with an int parameter, returning a String
  public String getWord(int i){
    return list.get(i);
  }
}