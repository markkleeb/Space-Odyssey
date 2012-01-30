import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Space_Odyssey extends PApplet {

String space[]  = {
"HAL: Too bad about Frank, isn't it?",
"BOWMAN: Yes, it is.",
"HAL: I suppose you're pretty broken up about it?",
"BOWMAN: Yes. I am.",
"HAL: He was an excellent crew member.",
"HAL: It's a bad break, but it won't substantially affect the mission.",
"BOWMAN: Hal, give me manual hibernation control.",
"HAL: Have you decided to revive the rest of the crew, Dave?"
};
Phrase[] phrases = new Phrase[space.length];
int inc = 0;
PFont fontA;

public void setup() {
 

  fontA = loadFont("AndaleMono-48.vlw");

  for (int i = 0; i < space.length; i++) {
    phrases[i] = new Phrase(space[i]);
}
  size(600, 600, P3D);
  background(0);

}

public void draw() {
  background(0);
  translate(width/2, height/2);
  rotateX(PI/4);

for(int i = 0; i < phrases.length; i++){
  if (phrases[i].enabled){
   phrases[i].drawPhrase(); 
  }
}
}

   

public void mousePressed() {

  phrases[inc].start();
  inc++;
  
  for(int i = 0; i < phrases.length; i++){
    for(int j=0; j < phrases[i].letter.length; j++){
      println(phrases[i].letter[j].charStr);
    }
  }
  if (inc >= phrases.length) {
    inc = 0;
  }
}


class CharObj {
  char charStr;
  float x, y, z, xD, yD, zD;
  int fontSize;
  PFont font;
  boolean enabled = false;

  CharObj(char _charStr, float _xD, float _yD, float _zD) {
    charStr = _charStr;
    xD= _xD;
   yD = _yD;
   zD = _zD;
   font = loadFont("AndaleMono-48.vlw");
   fontSize = 18;
    
  }

public void start(){
 x = 0;
y = 0;
z = 0;

 enabled = true;
  
}

public void charDraw(){
  textFont(fontA);
  fill(255);
  textSize(fontSize);
  text(charStr, x, y, z);
  x += xD;
  y += yD;
  z += zD;

}


}
class Phrase {

  float xspeed;
  float yspeed;
  float zspeed;
  String phrase;
  CharObj letter[];
  boolean enabled = false;
  int  frameNumber = 8;
  int incrementer = 0;

  Phrase(String _phrase) {

    zspeed = -1;
    phrase = _phrase;
    letter = new CharObj[phrase.length()];

    for (int i = 0; i < phrase.length(); i++) {

      letter[i] = new CharObj(phrase.charAt(i), xspeed, yspeed, zspeed);
    }
  }

  public void start() {
    xspeed = random(-5, 5);
    yspeed = random(1, 5);
    for (int i = 0; i < phrase.length(); i++) {

      letter[i] = new CharObj(phrase.charAt(i), xspeed, yspeed, zspeed);
    }
    enabled = true;
    incrementer = 0;
  }
  public void drawPhrase() {
    if ((incrementer % frameNumber == 0) && (incrementer / frameNumber < letter.length)) {
      int charNum = incrementer / frameNumber;
      letter[charNum].start();
      println("Character " + letter[charNum].charStr + " enabled");
    }

    for (int i = 0; i < letter.length; i++) {
      if (letter[i].enabled) {
        letter[i].charDraw();
      }
    }

    incrementer++;
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "Space_Odyssey" });
  }
}
